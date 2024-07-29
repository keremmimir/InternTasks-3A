package com.example.interntasks_3a

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.interntasks_3a.databinding.FragmentNumberGuessBinding

class NumberGuessFragment : Fragment() {
    private var _binding: FragmentNumberGuessBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NumberGuessViewModel by viewModels()

    var buttons = listOf<Button>()
    var guessNumber = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNumberGuessBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonStart.setOnClickListener {
            viewModel.startNewGame()
            binding.buttonStart.visibility = View.GONE
        }

        observeData()

        with(binding){
            buttons = listOf(button0, button1, button2, button3, button4, button5,
            button6, button7, button8, button9)
        }

        buttons.forEach{ button ->
            button.setOnClickListener {
                guessNumber = button.text.toString().toInt()
                binding.guessText.text = guessNumber.toString()
            }
        }

        binding.buttonClear.setOnClickListener {
            viewModel.startNewGame()
            binding.guessText.text = "TEKRAR DENE"
        }

        binding.buttonGuess.setOnClickListener {
            viewModel.guessNumber(guessNumber)
            binding.guessText.text = viewModel.result.value
        }
    }
    fun observeData(){
        viewModel.startButton.observe(viewLifecycleOwner, Observer { boolen ->
            if (boolen){
                binding.buttonStart.visibility = View.GONE
            }
        })

        viewModel.char.observe(viewLifecycleOwner, Observer { char->
            binding.charText.text = char.toString()
        })

        viewModel.result.observe(viewLifecycleOwner, Observer { result ->
            binding.guessText.text = result
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}