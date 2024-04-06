package com.example.lab2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab2.adapter.HistoricalAdapter
import com.example.lab2.api.ApiClient
import com.example.lab2.databinding.ActivityMainBinding
import com.example.lab2.model.Historical
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = HistoricalAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        with(binding){
            historicalFigures.adapter = adapter
            historicalFigures.layoutManager =LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            etSearch.setOnEditorActionListener{ it, actionId, _ ->
                if (actionId == android.view.inputmethod.EditorInfo.IME_ACTION_SEARCH){
                    performSearch(it.text.toString())
                    true
                } else{
                    false
                }

            }
        }
        setContentView(binding.root)


//            setContentView(binding.root)
//        supportFragmentManager
//            .beginTransaction()
//            .add(R.id.fragment_container_view, HistoricalFragment.newInstance())
//            .commit()
    }

    private fun performSearch(query: String) {
        ApiClient.api.fetchHistoricalLIst(query).enqueue(object :
            Callback<List<Historical>> {
            override fun onResponse(call: Call<List<Historical>>, response: Response<List<Historical>>) {
                if (response.isSuccessful) {
                    adapter.submitList(response.body())
                }
            }
            override fun onFailure(call: Call<List<Historical>>, t: Throwable) {
            }
        })
    }
}