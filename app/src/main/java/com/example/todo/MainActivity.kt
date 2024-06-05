package com.example.todo

import android.app.Activity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo.databinding.ActivityMainBinding
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var todoAdapter: TodoAdapter
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        getAPI()
    }

    private fun getAPI() {
        val retrolfitAPI = RetrolfitAPI.getRetrolfit().create(TodosIntance::class.java)

        val retrolfitAPILiveData : LiveData<Response<Todos>> = liveData {
            val response = retrolfitAPI.getTodosIntance()
            emit(response)
        }


        retrolfitAPILiveData.observe(this, Observer {
            val todosList = it.body()
            if(todosList != null){
                todoAdapter = TodoAdapter(todosList)
                binding.recyclerView.adapter = todoAdapter
            }
        })
    }
}