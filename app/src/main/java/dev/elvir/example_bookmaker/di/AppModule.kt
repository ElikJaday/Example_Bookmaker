package dev.elvir.example_bookmaker.di

import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideAppString(): String = "hello Application"
}