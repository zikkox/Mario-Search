package com.example.mariosearch.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.mariosearch.data.CharacterService
import com.example.mariosearch.data.createRF
import com.example.mariosearch.databinding.ActivityCharacterBinding
import kotlinx.coroutines.launch

class CharacterActivity : AppCompatActivity() {

    private val binding by lazy { ActivityCharacterBinding.inflate(layoutInflater) }
    private val characterAdapter = CharacterAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViews()
        getData()
    }

    private fun initViews(){
        binding.characterRecyclerview.adapter = characterAdapter
    }

    private fun getData() {
        val createApi = createRF().create(CharacterService::class.java)

        lifecycleScope.launch {
            val response = createApi.getCharactersList()
            if (response.isSuccessful) {
                val list = response.body()?.amiibo
                characterAdapter.updateList(list ?: emptyList())
            }
        }
    }
}