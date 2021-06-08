package com.madslee.javalindbboilerplate

private val defaultProperties = hashMapOf(
    "jdbcUrl" to "jdbc:h2:mem:AZ",
    "databaseUsername" to "sa",
    "databasePassword" to "",
    "javalinPort" to "7000"
)

fun environmentProperty(key: String) = System.getenv(key) ?: defaultProperties[key]
