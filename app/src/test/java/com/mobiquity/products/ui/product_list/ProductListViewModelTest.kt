package com.mobiquity.products.ui.product_list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mobiquity.products.MockData
import com.mobiquity.products.data.ProductRepository
import com.mobiquity.products.data.Result
import com.mobiquity.products.getOrAwaitValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import java.io.IOException

@ExperimentalCoroutinesApi
class ProductListViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var productRepository: ProductRepository
    lateinit var viewModel: ProductListViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(TestCoroutineDispatcher())
        viewModel = ProductListViewModel(productRepository)
    }

    @Test
    fun `categoryLiveData return success-status when request is successful`() = runBlockingTest {
        `when`(productRepository.getProducts()).thenReturn(Result.Success(MockData.getCategoryList()))
        viewModel.getProducts()
        val status = viewModel.getCategoryLiveData().getOrAwaitValue()
        assertTrue(status is Result.Success)
    }

    @Test
    fun `categoryLiveData return error-status when request is failed`() = runBlockingTest {
        `when`(productRepository.getProducts()).thenReturn(Result.Error(IOException()))
        viewModel.getProducts()
        val status = viewModel.getCategoryLiveData().getOrAwaitValue()
        assertTrue(status is Result.Error)
    }
}