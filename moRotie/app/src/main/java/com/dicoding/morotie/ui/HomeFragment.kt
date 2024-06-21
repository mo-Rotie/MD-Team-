package com.dicoding.morotie.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.morotie.BuildConfig
import com.dicoding.morotie.R
import com.dicoding.morotie.adapter.MoldAdapter
import com.dicoding.morotie.api.MoldResponse
import com.dicoding.morotie.api.MoldService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class HomeFragment : Fragment() {
    private lateinit var moldAdapter: MoldAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var aboutUsBtn: ImageView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.rv_trivia)
        aboutUsBtn = view.findViewById(R.id.aboutUs_btn)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        loadDataFromApi()


        aboutUsBtn.setOnClickListener{
            val intent = Intent(requireContext(), AboutUsActivity::class.java)
            startActivity(intent)
        }



        return view
    }

    private fun loadDataFromApi() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(MoldService::class.java)
        service.getMoldItems().enqueue(object : Callback<MoldResponse> {
            override fun onResponse(call: Call<MoldResponse>, response: Response<MoldResponse>) {
                if (response.isSuccessful) {
                    val moldResponse = response.body()
                    moldResponse?.let {
                        val moldItems = it.data.mold_table
                        moldAdapter = MoldAdapter(moldItems) { moldItem ->
                            val fragment1 = DetailTriviaFragment()
                            val fragment2 = DetailArticleFragment()

                            if (moldItem.jenis=="jamur") {
                                val bundle = Bundle()
                                bundle.putString("nama", moldItem.Nama)
                                bundle.putString("deskripsi", moldItem.Deskripsi)
                                bundle.putString("gambar", moldItem.Gambar)
                                bundle.putString("spesies", moldItem.Spesies)
                                bundle.putString("gejala", moldItem.Gejala_keracunan)
                                bundle.putString("pengobatan", moldItem.Pengobatan)
                                fragment2.arguments = bundle


                                requireActivity().supportFragmentManager.beginTransaction()
                                    .replace(R.id.mainFrame, fragment2)
                                    .addToBackStack(null)
                                    .commit()

                            } else{
                                val bundle = Bundle()
                                bundle.putString("nama", moldItem.Nama)
                                bundle.putString("deskripsi", moldItem.Deskripsi)
                                bundle.putString("gambar", moldItem.Gambar)
                                fragment1.arguments = bundle


                                requireActivity().supportFragmentManager.beginTransaction()
                                    .replace(R.id.mainFrame, fragment1)
                                    .addToBackStack(null)
                                    .commit()

                            }


                        }
                        recyclerView.adapter = moldAdapter
                    }
                } else {
                }
            }

            override fun onFailure(call: Call<MoldResponse>, t: Throwable) {
                // Handle failure
            }
        })
    }


}