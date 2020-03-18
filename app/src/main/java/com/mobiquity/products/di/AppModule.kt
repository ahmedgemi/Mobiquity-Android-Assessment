package com.mobiquity.products.di

import com.mobiquity.products.data.ProductRepository
import com.mobiquity.products.data.remote.ProductRemoteDataSource
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun providesProductRepository(remoteDataSource: ProductRemoteDataSource): ProductRepository {
        return ProductRepository(remoteDataSource)
    }
}