package dev.elvir.example_bookmaker

import android.app.Application
import dev.elvir.core.feature_component.ComponentManager

class MainApp : Application(), ComponentManager {

    lateinit var componentManager: dev.elvir.example_bookmaker.ComponentManager

    override fun onCreate() {
        super.onCreate()
        if (!this::componentManager.isInitialized) {
            createMainComponentManager()
        }
    }

    override fun <T> getDependency(key: Class<T>): T = componentManager.componentBuilder(key, this)

    private fun createMainComponentManager(): dev.elvir.example_bookmaker.ComponentManager =
        ComponentManager()
            .apply { plusAppComponent() }
            .also { componentManager = it }

}
