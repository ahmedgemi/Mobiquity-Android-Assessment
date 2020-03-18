package com.mobiquity.products.ui.product_details

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mobiquity.products.AndroidMockData
import com.mobiquity.products.Constants
import com.mobiquity.products.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ProductDetailsFragmentTest {

    @Before
    fun setUp() {
    }

    @Test
    fun testProductDetailFragment() {
        val productModel = AndroidMockData.getProductObj()
        val fragmentArgs = Bundle().apply {
            putParcelable(Constants.PRODUCT_DATA, productModel)
        }

        launchFragmentInContainer<ProductDetailsFragment>(fragmentArgs = fragmentArgs)

        Espresso.onView(ViewMatchers.withId(R.id.tv_name))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tv_name))
            .check(ViewAssertions.matches(ViewMatchers.withText(productModel.name)))

        Espresso.onView(ViewMatchers.withId(R.id.tv_price))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tv_price))
            .check(ViewAssertions.matches(ViewMatchers.withText(productModel.salePrice.amount)))
    }
}