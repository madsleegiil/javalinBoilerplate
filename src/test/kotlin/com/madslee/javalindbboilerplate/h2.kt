package com.madslee.javalindbboilerplate

import org.h2.tools.Server

fun startH2() {
    Server.createTcpServer().start()
}
