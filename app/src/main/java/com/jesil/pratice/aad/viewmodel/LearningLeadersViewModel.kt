package com.jesil.pratice.aad.viewmodel

import android.net.DnsResolver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jesil.pratice.aad.data.Learners
import com.jesil.pratice.aad.data.LearningLeadersData
import com.jesil.pratice.aad.model.Webservices
import com.jesil.pratice.aad.utils.DataResult
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class LearningLeadersViewModel : ViewModel() {

 private val _dataResult = MutableLiveData<DataResult<Learners>>()
    val dataResult : LiveData<DataResult<Learners>>
            get() = _dataResult

    init {
        getLearningLeadersFromViewModel()
    }

    private fun getLearningLeadersFromViewModel() {
        _dataResult.postValue(DataResult.Loading())
        Webservices.retrofitWebservice.getTopLearners().enqueue(object : retrofit2.Callback<Learners>{
            override fun onResponse(
                call: Call<Learners>,
                response: Response<Learners>
            ) {
                _dataResult.postValue(DataResult.Success(response.body()))
            }

            override fun onFailure(call: Call<Learners>, t: Throwable) {

                _dataResult.postValue(DataResult.Error(t))
            }

        })
    }

}