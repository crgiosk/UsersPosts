package com.pruebadeingreso.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pruebadeingreso.databinding.FragmentUsersBinding
import com.pruebadeingreso.ui.adapters.UserAdapter

class UsersFragment : Fragment() {

    private val binding: FragmentUsersBinding by lazy {
        FragmentUsersBinding.inflate(layoutInflater)
    }

    private val usersAdapter: UserAdapter by lazy {
        UserAdapter(
            onClickItem =  {
                //TODO!!
                //navigate to posts screen
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
    }

    private fun setupListeners() {
        binding.findUserEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(search: Editable?) {
                search?.let { safeSearch ->
                    //todo!!
                    //add validacion in viewModel and notify to adapter
                    //And create a observer to by
                }
            }

        })
    }

    private fun setupUI() {

        binding.usersRecyclerView?.apply {
            layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
            adapter = usersAdapter
        }
    }

}