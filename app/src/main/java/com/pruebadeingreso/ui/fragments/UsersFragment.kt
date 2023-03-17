package com.pruebadeingreso.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pruebadeingreso.R
import com.pruebadeingreso.databinding.FragmentUsersBinding
import com.pruebadeingreso.ui.adapters.UserAdapter
import com.pruebadeingreso.ui.viewmodels.UserPostViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersFragment : Fragment() {

    private val binding: FragmentUsersBinding by lazy {
        FragmentUsersBinding.inflate(layoutInflater, null, false)
    }

    private val viewModel: UserPostViewModel by activityViewModels()

    private val usersAdapter: UserAdapter by lazy {
        UserAdapter(
            onClickItem = {
                viewModel.userSelected = it
                findNavController().navigate(R.id.action_usersFragment_to_usersPostFragment)
            }
        )
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
        setupListeners()
        setupObservers()
        viewModel.getUsers()
    }

    private fun setupListeners() {
        binding.findUserEditText.addTextChangedListener(object : TextWatcher {

            //TODO!! create a ExtensionFucntion
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(search: Editable?) {
                search.toString()?.let { safeSearch ->


                    //todo!!
                    //call dao filtering data from db
                }
            }

        })
    }

    private fun setupUI() {

        binding.usersRecyclerView.run {
            adapter = usersAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        }
    }

    private fun setupObservers() {
        viewModel.usersList.observe(viewLifecycleOwner) {
            usersAdapter.updateData(it)
        }
    }

}