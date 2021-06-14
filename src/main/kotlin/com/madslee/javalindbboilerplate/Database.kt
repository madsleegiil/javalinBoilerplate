package com.madslee.javalindbboilerplate

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.flywaydb.core.Flyway
import org.slf4j.LoggerFactory

class Database() {

    private val hikariDatasource: HikariDataSource
    private val logger = LoggerFactory.getLogger(this::class.java)

    init {
        hikariDatasource = HikariDataSource(hikariConfig())
        startFlyway()
    }

    fun getDatasource() = hikariDatasource

    private fun hikariConfig(): HikariConfig = HikariConfig().apply {
        jdbcUrl = environmentProperty("jdbcUrl")
        username = environmentProperty("databaseUsername")
        password = environmentProperty("databasePassword")
    }

    private fun startFlyway() {
        logger.info("Starting Flyway")
        val config = Flyway.configure()
        config.dataSource(getDatasource())
        val flyway = Flyway(config)
        flyway.migrate()
    }
}
