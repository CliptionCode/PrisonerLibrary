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
package dao

import com.ascom.prisonerlibrary.model.Info
import infastructure.*

class InfoApi(basePath: kotlin.String = "https://labama.aw1.ch/Prison/api/v1", sessionId: String) :
    ApiClient(basePath, sessionId) {

    /**
     * Get WebApi advanced Information
     *
     * @return Info
     */
    @Suppress("UNCHECKED_CAST")
    fun infoAdvancedGet(): Info {

        val localVariableConfig = RequestConfig(
            RequestMethod.GET,
            "/info/advanced"
        )
        val response = request<Info>(
            localVariableConfig
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as Info
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException(
                (response as ClientError<*>).body as? String ?: "Client error"
            )
            ResponseType.ServerError -> throw ServerException(
                (response as ServerError<*>).message ?: "Server error"
            )
        }
    }

    /**
     * Get WebApi Version
     *
     * @return Info
     */
    @Suppress("UNCHECKED_CAST")
    fun infoGet(): Info {

        val localVariableConfig = RequestConfig(
            RequestMethod.GET,
            "/info"
        )
        val response = request<Info>(
            localVariableConfig
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as Info
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException(
                (response as ClientError<*>).body as? String ?: "Client error"
            )
            ResponseType.ServerError -> throw ServerException(
                (response as ServerError<*>).message ?: "Server error"
            )
        }
    }
}