package com.users_posts.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.users_posts.databinding.FragmentUsersPostBinding
import com.users_posts.ui.adapters.PostUserAdapter
import com.users_posts.ui.viewmodels.UserPostViewModel

class UsersPostFragment : Fragment() {

    private val binding: FragmentUsersPostBinding by lazy {
        FragmentUsersPostBinding.inflate(layoutInflater)
    }

    private val postUserAdapter: PostUserAdapter by lazy {
        PostUserAdapter()
    }

    private val viewModel: UserPostViewModel by activityViewModels()

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
        setupObservers()
        viewModel.getPostByUser()
    }

    private fun setupObservers() {
        viewModel.postByUserList.observe(viewLifecycleOwner) {
            postUserAdapter.setData(it)
        }
    }

    private fun setupUI() {

        binding.userPostRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
            adapter = postUserAdapter
        }
        binding.layoutUserSelected.user = viewModel.userSelected
    }
}