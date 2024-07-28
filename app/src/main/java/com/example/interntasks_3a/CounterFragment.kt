package com.example.interntasks_3a

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.interntasks_3a.databinding.FragmentCounterBinding


class CounterFragment : Fragment() {
    private var _binding: FragmentCounterBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CounterViewModel by viewModels()

    private var counter = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCounterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.switch1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.counterText.text=viewModel.viewModelCounter.toString()

                binding.counterButton.setOnClickListener {
                    viewModel.counterNumber()
                    binding.counterText.text=viewModel.viewModelCounter.toString()
                }
            } else {
                binding.counterText.text=counter.toString()

                binding.counterButton.setOnClickListener {
                    counter++
                    binding.counterText.text=counter.toString()
                }
            }
        }

        if (binding.switch1.isChecked){
            binding.counterButton.setOnClickListener {
                viewModel.counterNumber()
                binding.counterText.text=viewModel.viewModelCounter.toString()
            }
        }else{
            binding.counterButton.setOnClickListener {
                counter++
                binding.counterText.text=counter.toString()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}