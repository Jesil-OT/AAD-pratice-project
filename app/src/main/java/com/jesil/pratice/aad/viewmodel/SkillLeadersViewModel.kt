package com.jesil.pratice.aad.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jesil.pratice.aad.data.SkillIq
import com.jesil.pratice.aad.model.Webservices
import com.jesil.pratice.aad.utils.DataResult
import com.jesil.pratice.aad.utils.DataResult.*
import retrofit2.Call
import retrofit2.Response

class SkillLeadersViewModel : ViewModel() {

    private val _dataResult = MutableLiveData<DataResult<SkillIq>>()

    val dataResult : LiveData<DataResult<SkillIq>>
        get() = _dataResult

    init {
        getSkillIqLeadersFromViewModel()
    }

    private fun getSkillIqLeadersFromViewModel() {
        Webservices.retrofitWebservice.getSkillIq().enqueue(object : retrofit2.Callback<SkillIq>{
            override fun onResponse(
                call: Call<SkillIq>,
                response: Response<SkillIq>
            ) {
                _dataResult.postValue(Success(response.body()))
            }

            override fun onFailure(call: Call<SkillIq>, t: Throwable) {
                _dataResult.postValue(Error(t))
            }

        })
    }
}