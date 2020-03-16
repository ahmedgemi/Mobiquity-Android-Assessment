package com.mobiquity.products.di

import com.mobiquity.products.ui.product_list.ProductListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeProductListFragment(): ProductListFragment

}