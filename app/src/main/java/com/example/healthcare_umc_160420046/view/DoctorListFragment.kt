package com.example.healthcare_umc_160420046.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.healthcare_umc_160420046.R
import com.example.healthcare_umc_160420046.viewmodel.DoctorListViewModel

class DoctorListFragment : Fragment() {
    private lateinit var viewModel: DoctorListViewModel
    private val doctorListAdapter = DoctorListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doctor_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[DoctorListViewModel::class.java]
        viewModel.refresh()

        val recView = view.findViewById<RecyclerView>(R.id.recView)
        val refreshLayout = view.findViewById<SwipeRefreshLayout>(R.id.refreshLayout)
        val txtError = view.findViewById<TextView>(R.id.txtError)
        val progressLoad = view.findViewById<ProgressBar>(R.id.progressLoad)

        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = doctorListAdapter

        refreshLayout.setOnRefreshListener {
            recView.visibility = View.GONE
            txtError.visibility = View.GONE
            progressLoad.visibility  = View.VISIBLE
            viewModel.refresh()
            refreshLayout.isRefreshing = false
        }

        observeViewModel()
    }

    private fun observeViewModel(){
        viewModel.doctorLD.observe(viewLifecycleOwner, Observer {
            doctorListAdapter.updateDoctorList(it)
        })

        viewModel.loadingErrorLD.observe(viewLifecycleOwner, Observer {
            val txtError = view?.findViewById<TextView>(R.id.txtError)
            if (txtError != null) {
                txtError.visibility = if(it) View.VISIBLE else View.GONE
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            val progressLoad = view?.findViewById<ProgressBar>(R.id.progressLoad)
            val recView = view?.findViewById<RecyclerView>(R.id.recView)

            if(it){
                if (progressLoad != null) {
                    progressLoad.visibility = View.VISIBLE
                }
                if (recView != null) {
                    recView.visibility = View.GONE
                }
            } else{
                if (progressLoad != null) {
                    progressLoad.visibility = View.GONE
                }
                if (recView != null) {
                    recView.visibility = View.VISIBLE
                }
            }
        })
    }

}