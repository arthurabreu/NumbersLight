package com.arthur.android.numberslight.listnumbers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.arthur.android.numberslight.R
import com.arthur.android.numberslight.databinding.NumbersListFragmentBinding
import com.arthur.android.numberslight.di.observeLifecycleIn
import com.arthur.android.numberslight.listnumbers.adapter.ItemsAdapter
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class NumbersListFragment : Fragment() {

    @Inject
    lateinit var numbersViewModel: NumbersListViewModel

    private lateinit var binding: NumbersListFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<NumbersListFragmentBinding>(
                    inflater,
                    R.layout.numbers_list_fragment,
                    container,
                    false
            ).also {
                binding = it
            }.root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.observeLifecycleIn(numbersViewModel)
        binding.run {
            this.viewModel = numbersViewModel
            initRecycler(binding)
            lifecycleOwner = this@NumbersListFragment
        }
        numbersViewModel.networkState.observeForever {
            it?.let {
                if (it){
                    binding.btnInternet.visibility = View.GONE
                    binding.recyclerMovies.visibility = View.VISIBLE
                }else{
                    binding.btnInternet.visibility = View.VISIBLE
                    binding.recyclerMovies.visibility = View.GONE
                }
            }
        }
    }

    private fun initRecycler(
            activityMainBinding: NumbersListFragmentBinding
    ) {
        val layoutManager = LinearLayoutManager(context)

        val recyclerMovies = activityMainBinding.recyclerMovies
        recyclerMovies.layoutManager = layoutManager
        recyclerMovies.hasFixedSize()
        recyclerMovies.adapter = ItemsAdapter()
        recyclerMovies.addItemDecoration(
                androidx.recyclerview.widget.DividerItemDecoration(
                        context,
                        layoutManager.orientation
                )
        )
    }
}
