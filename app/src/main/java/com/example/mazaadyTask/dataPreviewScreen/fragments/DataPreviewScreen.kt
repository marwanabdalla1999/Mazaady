package com.example.mazaadyTask.dataPreviewScreen.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mazaadyTask.R
import com.example.mazaadyTask.dataPreviewScreen.adapter.DataAdapter
import com.example.mazaadyTask.databinding.DataPreviewFragmentBinding


@Suppress("DEPRECATION")
class DataPreviewScreen : Fragment() {

    private lateinit var binding: DataPreviewFragmentBinding
    private  var  dataHashMap:HashMap< * , *>? =null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataPreviewFragmentBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        setupData()


    }

    private fun setupData() {
        val adapter= dataHashMap?.let { DataAdapter(it) }
        binding.data.adapter=adapter
        val divider=DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
        ContextCompat.getDrawable(requireContext(),R.drawable.divider)
            ?.let { divider.setDrawable(it) }
        binding.data.addItemDecoration(divider)
    }

    private fun init() {

         backHandler()
        dataHashMap = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getSerializable("dataHashMap",HashMap::class.java)
        } else {
            arguments?.getSerializable("dataHashMap") as HashMap<*, *>

        }

    }

    private fun backHandler() {
        binding.back.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }


}