package com.jesil.pratice.aad.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.jesil.pratice.aad.R
import com.jesil.pratice.aad.data.LearningLeadersData
import com.jesil.pratice.aad.model.JsonPlaceHolderApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A simple [Fragment] subclass.
 * Use the [LearningLeadersFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LearningLeadersFragment : Fragment() {

    companion object{
        private const val BASE_URL = "https://gadsapi.herokuapp.com/"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_learning_leaders, container, false)
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val jsonPlaceHolderApi: JsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)

        val call: Call<List<LearningLeadersData>> = jsonPlaceHolderApi.post
        call.enqueue(object : Callback<List<LearningLeadersData>> {
            override fun onResponse(
                call: Call<List<LearningLeadersData>>,
                response: Response<List<LearningLeadersData>>
            ) {

            }

            override fun onFailure(call: Call<List<LearningLeadersData>>, t: Throwable) {
                Toast.makeText(activity, t.message, Toast.LENGTH_LONG).show()
            }


        })

        return view
    }

}