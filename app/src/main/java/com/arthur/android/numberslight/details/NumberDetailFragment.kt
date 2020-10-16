package com.arthur.android.numberslight.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.arthur.android.numberslight.R
import com.arthur.android.numberslight.databinding.NumbersDetailsFragmentBinding
import com.arthur.android.numberslight.di.observeLifecycleIn
import com.arthur.android.numberslight.listnumbers.NUMBERS
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class NumberDetailFragment : Fragment() {

    @Inject
    lateinit var numberDetailsViewModel: NumberDetailsViewModel

    private lateinit var binding: NumbersDetailsFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<NumbersDetailsFragmentBinding>(
                    inflater,
                    R.layout.numbers_details_fragment,
                    container,
                    false
            ).also {
                binding = it
            }.root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.observeLifecycleIn(numberDetailsViewModel)
        binding.run {
            this.viewModel = numberDetailsViewModel
            lifecycleOwner = this@NumberDetailFragment
            viewModel = numberDetailsViewModel.apply {
                numberId.value = arguments?.getInt(NUMBERS)
            }
        }
    }
}