package com.example.lunatiket.ui

import MainAdapter
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lunatiket.data.remote.ApiService
import com.example.lunatiket.data.remote.response.AirportResponseItem
import com.example.lunatiket.databinding.ActivityFlightBinding
import com.example.lunatiket.utils.Constant.BASE_URL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FlightActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFlightBinding
    private lateinit var viewAdapter: MainAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFlightBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewManager = LinearLayoutManager(this)
        getUsersData()

    }

    private fun getUsersData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        retrofit.getAirport().enqueue(object : Callback<List<AirportResponseItem>> {
            override fun onResponse(call: Call<List<AirportResponseItem>>, response: Response<List<AirportResponseItem>>) {
                Log.d("onResponse", "test")
                if (response.isSuccessful) {
                    val data = response.body()
                    Log.e("On Response", response.message())
                    if (data != null) {
                        // Handle the data
                        viewAdapter = MainAdapter(baseContext, data)
                        binding.listRv.apply {
                            layoutManager = viewManager
                            adapter = viewAdapter
                        }

                    }
                } else {
                    val errorBody = response.errorBody()?.string()
                    Log.e("On Response", "Error: $errorBody")
                }
            }

            override fun onFailure(call: Call<List<AirportResponseItem>>, t: Throwable) {
                t.printStackTrace()
                Log.d("OtherActivity", "OnFailure" + t.message)
            }
        })


    }
}