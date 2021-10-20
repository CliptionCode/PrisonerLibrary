package util

import android.graphics.Color
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController

class ToolbarUtils {
    companion object {
        private val defaultMenuListener: Toolbar.OnMenuItemClickListener =
            Toolbar.OnMenuItemClickListener {
                when (it.itemId) {
                    else -> {
                        System.err.println("Item not handled within ${ToolbarUtils::javaClass::name}")
                        return@OnMenuItemClickListener false
                    }
                }
                return@OnMenuItemClickListener true
            }

        fun initToolbar(
            activity: FragmentActivity?,
            view: View,
            toolbarId: Int,
            mainActivityHostFragmentId: Int,
            menuId: Int? = null,
            listener: Toolbar.OnMenuItemClickListener? = null,
            toolbarTitleText: String? = null,
            vararg appBarConfigIds:Int
        ) {
            val navHostFragment =
                activity?.supportFragmentManager?.findFragmentById(mainActivityHostFragmentId) as NavHostFragment
            val navController = navHostFragment.navController

            val appBarConfiguration = AppBarConfiguration.Builder(
                appBarConfigIds.toSet()
            ).build()
            val toolbar = view.findViewById<Toolbar>(toolbarId)
            toolbar.setTitleTextColor(Color.WHITE)
            toolbar.setBackgroundColor(Color.parseColor("#183443"))
            toolbar.setSubtitleTextColor(Color.WHITE)
            if (menuId != null) {
                toolbar.inflateMenu(menuId)
                if (listener != null) {
                    toolbar.setOnMenuItemClickListener(listener)
                } else {
                    toolbar.setOnMenuItemClickListener(defaultMenuListener)
                }
            }
            toolbar.setupWithNavController(navController, appBarConfiguration)

            if (toolbarTitleText != null && toolbarTitleText.isNotBlank()) {
                toolbar.setTitle(toolbarTitleText)
                //toolbar.setSubtitle(toolbarTitleText)
            }
        }
    }
}