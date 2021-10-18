/**
 * Ascom Prisoner API
 * This is the Ascom REST Interface for Locations, Users, Persons and Appointments. You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/). 
 *
 * OpenAPI spec version: 1.0.0
 * Contact: alessandro.marra@ascom.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
package io.swagger.client.models

import io.swagger.client.models.Location
import io.swagger.client.models.LocationLite
import io.swagger.client.models.PersonState

/**
 * 
 * @param id 
 * @param name 
 * @param kind 0 Floor, 1 Room, 2 Bed, 3 Shower
 * @param parentId 
 * @param rfId 
 * @param persons 
 * @param children 
 */
data class Location (

    val id: kotlin.Int? = null,
    val name: kotlin.String? = null,
    /* 0 Floor, 1 Room, 2 Bed, 3 Shower */
    val kind: kotlin.Int? = null,
    val parentId: kotlin.Int? = null,
    val rfId: kotlin.String? = null,
    val persons: kotlin.Array<PersonState>? = null,
    val children: kotlin.Array<Location>? = null
) {
}