package com.rumeysaozer.roomdaggerhilt.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rumeysaozer.roomdaggerhilt.adapter.ImageAdapter
import com.rumeysaozer.roomdaggerhilt.databinding.ActivityMainBinding
import com.rumeysaozer.roomdaggerhilt.util.Resource
import com.rumeysaozer.roomdaggerhilt.viewmodel.ImageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewmodel : ImageViewModel

    private val adapter = ImageAdapter(arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.recyclerView.adapter = adapter
        viewmodel = ViewModelProvider(this).get(ImageViewModel::class.java)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        viewmodel.names.observe(this@MainActivity){result->
            result?.let{
                adapter.updateImageList(result.data!!)
            }
            binding.progressBar.isVisible = result is Resource.Loading && result.data!!.isNullOrEmpty()
            binding.error.isVisible = result is Resource.Error && result.data!!.isNullOrEmpty()
            binding.error.text = result.error?.localizedMessage
        }
    }
}