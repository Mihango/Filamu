package com.techmashinani.filamu.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import com.techmashinani.filamu.R
import com.techmashinani.filamu.di.Injectable
import com.techmashinani.filamu.viewmodels.ActorViewModel
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class ActorDetailFragment : Fragment(), Injectable {

    @Inject lateinit var mFactory: ViewModelProvider.Factory
    lateinit var viewModel: ActorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_actor_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, mFactory).get(ActorViewModel::class.java)

        val bundle = ActorDetailFragmentArgs.fromBundle(arguments!!)
        viewModel.init(bundle.actor)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showData()
    }

    private fun showData() {
        viewModel.actorLiveData.observe(viewLifecycleOwner, Observer {
            // show actor details
        })

        viewModel.personLiveData.observe(viewLifecycleOwner, Observer {
            // show person details
        })
    }
}
