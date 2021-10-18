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

import io.swagger.client.models.AppointmentState
import io.swagger.client.models.LocationLite

/**
 * 
 * @param id 
 * @param type 
 * @param startTime 
 * @param endTime 
 * @param text 
 * @param state 
 * @param location 
 */
data class AppointmentSimple (

    val id: kotlin.String? = null,
    val type: kotlin.String? = null,
    val startTime: java.time.LocalDateTime? = null,
    val endTime: java.time.LocalDateTime? = null,
    val text: kotlin.String? = null,
    val state: AppointmentState? = null,
    val location: LocationLite? = null
) {
}