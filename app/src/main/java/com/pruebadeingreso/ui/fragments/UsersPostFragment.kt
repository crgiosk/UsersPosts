package com.pruebadeingreso.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pruebadeingreso.databinding.FragmentUsersPostBinding
import com.pruebadeingreso.ui.adapters.PostUserAdapter

class UsersPostFragment : Fragment() {

    private val binding: FragmentUsersPostBinding by lazy {
        FragmentUsersPostBinding.inflate(layoutInflater)
    }

    private val postUserAdapter: PostUserAdapter by lazy {
        PostUserAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }


    private fun setupUI() {

        binding.userPostRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
            adapter = postUserAdapter
        }
    }
}