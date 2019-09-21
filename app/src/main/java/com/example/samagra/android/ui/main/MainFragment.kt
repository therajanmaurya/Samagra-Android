package com.example.samagra.android.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.samagra.android.R
import com.example.samagra.android.di.Injectable
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject

class MainFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: MainViewModel

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        btnComments.setOnClickListener { viewModel.fetchComments(false) }
        btnPhotos.setOnClickListener { viewModel.fetchPhotos(false) }
        btnPosts.setOnClickListener { viewModel.fetchPosts(false) }
        btnTodos.setOnClickListener { viewModel.fetchTodos(false) }
        btnCurrentTimestamp.setOnClickListener { fetchAll(false) }

        viewModel.commentsProcessTime.observe(viewLifecycleOwner, Observer {
            tvCommentsStart.text =
                getString(R.string.process_time, getString(R.string.start), it.startFetchTime)
            tvCommentsEnd.text =
                getString(R.string.process_time, getString(R.string.end), it.endFetchTime)
            tvCommentsStartSave.text =
                getString(R.string.process_time, getString(R.string.start_save), it.startSaveTime)
            tvCommentsEndSave.text =
                getString(R.string.process_time, getString(R.string.end_save), it.endSaveTime)
        })

        viewModel.photosProcessTime.observe(viewLifecycleOwner, Observer {
            tvPhotosStart.text =
                getString(R.string.process_time, getString(R.string.start), it.startFetchTime)
            tvPhotosEnd.text =
                getString(R.string.process_time, getString(R.string.end), it.endFetchTime)
            tvPhotosStartSave.text =
                getString(R.string.process_time, getString(R.string.start_save), it.startSaveTime)
            tvPhotosEndSave.text =
                getString(R.string.process_time, getString(R.string.end_save), it.endSaveTime)
        })

        viewModel.postsProcessTime.observe(viewLifecycleOwner, Observer {
            tvPostsStart.text =
                getString(R.string.process_time, getString(R.string.start), it.startFetchTime)
            tvPostsEnd.text =
                getString(R.string.process_time, getString(R.string.end), it.endFetchTime)
            tvPostsStartSave.text =
                getString(R.string.process_time, getString(R.string.start_save), it.startSaveTime)
            tvPostsEndSave.text =
                getString(R.string.process_time, getString(R.string.end_save), it.endSaveTime)
        })

        viewModel.todosProcessTime.observe(viewLifecycleOwner, Observer {
            tvTodosStart.text =
                getString(R.string.process_time, getString(R.string.start), it.startFetchTime)
            tvTodosEnd.text =
                getString(R.string.process_time, getString(R.string.end), it.endFetchTime)
            tvTodosStartSave.text =
                getString(R.string.process_time, getString(R.string.start_save), it.startSaveTime)
            tvTodosEndSave.text =
                getString(R.string.process_time, getString(R.string.end_save), it.endSaveTime)
        })

        fetchAll(true)
    }

    private fun fetchAll(isDelay: Boolean) {
        viewModel.fetchComments(isDelay)
        viewModel.fetchPhotos(isDelay)
        viewModel.fetchPosts(isDelay)
        viewModel.fetchTodos(isDelay)
    }
}
