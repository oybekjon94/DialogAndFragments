package com.example.fragmentlifecycle

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.fragmentlifecycle.databinding.FragmentFirstBinding
import kotlin.math.log

class FirstFragment : Fragment() {
    val TAG = "Fragment first"
    lateinit var textView:TextView

    private var _binding:FragmentFirstBinding? = null //nullable
    private val binding get() = _binding!!   //nullable emas
    private var sharedString :String? = null  //1

    private lateinit var intirface: FirstFragmentInterface

    override fun onAttach(context: Context) {
        super.onAttach(context)
        intirface = activity as MainActivity  //cast
        Log.d(TAG, "onAttach: ")
    }

    //fragment create bolganda call
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedString = arguments?.let { //2 ovoldik
            it.getString("key")
        }
        Log.d(TAG, "onCreate: ")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    //viewni create qilish
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentFirstBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        return _binding?.root
    }

    //viewlar bilan ishlash
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ")
        binding.button.setOnClickListener {
            val text = binding.textEt.text.toString()
            intirface.onClickBtn(text)
        }
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach: ")
    }
}