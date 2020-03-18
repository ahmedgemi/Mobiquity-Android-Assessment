package com.mobiquity.products.ui.product_list

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mobiquity.products.R
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ProductListFragmentTest {

    fun testProgressBar_Display_WhenDataLoading(){
        launchFragmentInContainer<ProductListFragment>()
        Espresso.onView(ViewMatchers.withId(R.id.layout_progress))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}