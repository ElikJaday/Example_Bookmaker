package dev.elvir.example_bookmaker.di

import dagger.Component
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AppScope

@Component(
    modules = [
        AppModule::class
    ]
)
@AppScope
interface AppComponent {

}