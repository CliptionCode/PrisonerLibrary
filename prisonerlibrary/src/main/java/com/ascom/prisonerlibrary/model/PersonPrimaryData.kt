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
package com.ascom.prisonerlibrary.model


/**
 *
 * @param nationalities
 * @param languages
 * @param foods
 * @param locker
 */
data class PersonPrimaryData(

    val nationalities: kotlin.Array<kotlin.String>? = null,
    val languages: kotlin.Array<kotlin.String>? = null,
    val foods: kotlin.Array<kotlin.String>? = null,
    val locker: kotlin.Int? = null
) {
}