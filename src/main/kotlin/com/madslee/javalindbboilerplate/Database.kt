package com.madslee.javalindbboilerplate

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.flywaydb.core.Flyway
import org.h2.tools.Server
import org.slf4j.LoggerFactory

class Database(startH2: Boolean) {

    private val hikariDatasource: HikariDataSource
    private val logger = LoggerFactory.getLogger(this::class.java)

    init {
        hikariDatasource = HikariDataSource(hikariConfig())
        if (startH2) startH2()
        startFlyway()
    }

    fun getDatasource() = hikariDatasource

    private fun hikariConfig(): HikariConfig = HikariConfig().apply {
        jdbcUrl = environmentProperty("jdbcUrl")
        username = environmentProperty("databaseUsername")
        password = environmentProperty("databasePassword")
    }

    private fun startH2() {
        logger.info("Starting H2")
        Server.createTcpServer().start()
    }

    private fun startFlyway() {
        logger.info("Starting Flyway")
        val config = Flyway.configure()
        config.dataSource(getDatasource())
        val flyway = Flyway(config)
        flyway.migrate()
    }
}
