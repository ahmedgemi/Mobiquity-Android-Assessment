package com.mobiquity.products.di.component

import androidx.lifecycle.ViewModel
import com.mobiquity.products.di.ViewModelKey
import com.mobiquity.products.ui.product_list.ProductListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProductListViewModel::class)
    abstract fun bindProductListViewModel(viewModel: ProductListViewModel): ViewModel
}