package com.mobiquity.products.data

import com.mobiquity.products.MockData
import com.mobiquity.products.data.remote.ProductRemoteDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.`when`
import java.io.IOException

@ExperimentalCoroutinesApi
class ProductRepositoryTest {

    @Mock
    lateinit var dataSource: ProductRemoteDataSource
    lateinit var productRepository: ProductRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        productRepository = ProductRepository(dataSource)
    }

    @Test
    fun `fetchCategories return category list when response is successful`() = runBlockingTest {
        `when`(dataSource.fetchCategories()).thenReturn(Result.Success(MockData.getCategoryList()))
        assertTrue(productRepository.getProducts() is Result.Success)
    }

    @Test
    fun `fetchCategories return error when response is fail`() = runBlockingTest {
        `when`(dataSource.fetchCategories()).thenReturn(Result.Error(IOException()))
        assertTrue(productRepository.getProducts() is Result.Error)
    }
}