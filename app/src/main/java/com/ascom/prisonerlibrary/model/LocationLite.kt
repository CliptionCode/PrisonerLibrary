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


/**
 * 
 * @param id 
 * @param name 
 * @param kind 0 Floor, 1 Room, 2 Bed, 3 Shower
 */
data class LocationLite (

    val id: kotlin.Int? = null,
    val name: kotlin.String? = null,
    /* 0 Floor, 1 Room, 2 Bed, 3 Shower */
    val kind: kotlin.Int? = null
) {
}