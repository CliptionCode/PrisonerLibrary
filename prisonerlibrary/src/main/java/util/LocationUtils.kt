package util

import com.ascom.prisonerlibrary.model.Location

object LocationUtils {
    fun getAllCells(inLocation: Location): List<Location> {
        if (inLocation.children.isEmpty()) {
            return mutableListOf(inLocation)
        }
        return rGetLastLevel(inLocation.children).toList()
    }

    private fun rGetLastLevel(inChildren: Array<Location>): Array<Location> {
        if (inChildren.isNotEmpty()) {
            val childrensChildren = arrayListOf<Location>()
            inChildren.forEach {
                if (it.children.isNotEmpty()) {
                    childrensChildren.addAll(it.children)
                }
            }
            if (childrensChildren.isEmpty()) {
                return inChildren
            }
            return rGetLastLevel(childrensChildren.toTypedArray())
        }
        return inChildren
    }

    private fun rGetAllTilLastLevel(inLocation: Location): List<Location>{
        val allLocations = mutableListOf(inLocation)
        if(inLocation.children.isNotEmpty()){
            allLocations.addAll(inLocation.children)
            inLocation.children.forEach {
                if(it.children.isNotEmpty()){
                    allLocations.addAll(rGetAllTilLastLevel(it))
                }
            }
        }
        return allLocations.distinctBy { it.id }
    }

    fun changeSelectedOfMeAndAllChildren(inRootLocation: Location?, inChildren: Array<Location>, inSelected: Boolean) {
        if(inRootLocation != null){
            inRootLocation.selected = inSelected
        }
        if (inChildren.isNotEmpty()) {
            inChildren.forEach {
                it.selected = inSelected
                changeSelectedOfMeAndAllChildren(null, it.children, inSelected)
            }
        }
    }

    fun areAllLocationsSelected(inRootLocation: Location) : Boolean{
        val allLocations = rGetAllTilLastLevel(inRootLocation)
        return allLocations.filter { it.selected }.size == allLocations.size
    }

    fun areAnyLocationsSelected(inLocation: Location): Boolean {
        return rGetAllTilLastLevel(inLocation).any { it.selected }
    }
}