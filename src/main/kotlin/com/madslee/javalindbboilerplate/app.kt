package com.madslee.javalindbboilerplate

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.get
import org.slf4j.LoggerFactory

private val logger = LoggerFactory.getLogger("Main")

fun startApp(startH2Database: Boolean) {
    val database = Database(startH2Database)
    database.getDatasource()

    val javalin = Javalin.create().start(environmentProperty("javalinPort")!!.toInt())

    javalin.routes {
        get("example") {
            it.status(200)
        }
    }
}

fun main() {
    startApp(false)
}
