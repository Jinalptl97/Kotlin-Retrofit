package com.example.myapplication.demoretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.myapplication.demoretrofit.databinding.ActivityMainBinding
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofitservices=RetrofitInstance.getREtrofitInstance().create(AlbumServices::class.java)
        val responseLiveData: LiveData<Response<Albums>> =
        liveData {
            val response=retrofitservices.getalbums()
            emit(response)
        }

        responseLiveData.observe(this,Observer{
            val albumList=it.body()?.listIterator()
            if(albumList!=null){
                while (albumList.hasNext()){
                    val albumItem=albumList.next()
                    val albumtitle="Album Title:${albumItem.title} \n"
                    binding.titletextview.append(albumtitle)
                }
            }
        })
    }
}