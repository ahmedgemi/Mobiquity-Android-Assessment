package com.mobiquity.products.di

import android.app.Application
import com.mobiquity.products.ProductsApp
import com.mobiquity.products.di.component.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class,FragmentModule::class,ViewModelModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application):Builder
        fun build():AppComponent
    }

    fun inject(app: ProductsApp)
}
