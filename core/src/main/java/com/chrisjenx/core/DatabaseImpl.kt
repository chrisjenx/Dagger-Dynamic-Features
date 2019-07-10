package com.chrisjenx.core

import java.util.UUID
import javax.inject.Inject

class DatabaseImpl
@Inject constructor() : Database {
    override fun getData(): String {
        return UUID.randomUUID().toString()
    }
}