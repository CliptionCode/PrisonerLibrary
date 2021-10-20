package com.ascom.prisonerlibrary

import android.os.Handler
import android.os.HandlerThread
import dao.InfoApi
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun apiCall() {
        val versionInstance = InfoApi(sessionId = "abc")

        val ht = HandlerThread("infoapi")
        ht.start()

        Handler(ht.looper).post {
            try {
                val result = versionInstance.infoGet().version
                System.err.println("Result: $result")

                // not authentificated request test
                try {
                    val result2 = versionInstance.infoAdvancedGet().version
                    System.err.println("Result 2: $result2")
                } catch (ex2: Exception) {
                    System.err.println("AdvancedGet Exception: ${ex2.message} >> ${ex2.cause} >> $ex2")
                }
            } catch (ex: Exception) {
                System.err.println("InfoGet Exception: ${ex.message} >> ${ex.cause} >> $ex")
            }
        }
        assertTrue(true)
    }
}