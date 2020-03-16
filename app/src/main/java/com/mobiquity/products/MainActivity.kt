package com.mobiquity.products

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mobiquity.products.base.BaseActivity
import com.mobiquity.products.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.textview2.text = "OK !!!"
        binding.button.setOnClickListener {
            Toast.makeText(this,"Test",Toast.LENGTH_SHORT).show()
        }

    }

}
