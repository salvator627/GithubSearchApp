package com.example.github.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.github.API.Retrofit
import com.example.github.User
import com.example.github.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ViewModel : ViewModel() {

    val listUser = MutableLiveData<ArrayList<User>>()

    fun setSearch(query: String){
        Retrofit.instance
            .getSearch(query)
            .enqueue(object : Callback<UserResponse>{
                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {
                    if (response.isSuccessful){
                        listUser.postValue(response.body()?.items)
                    }
                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    Log.d("Failure", t.message.toString())
                }
            })
    }

    fun getSearchUsers(): LiveData<ArrayList<User>>{
        return listUser
    }
}