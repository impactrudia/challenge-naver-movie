package com.happymoonday.challengesforheymoon.presentation.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.navigation.navGraphViewModels
import com.happymoonday.challengesforheymoon.R
import com.happymoonday.challengesforheymoon.adapters.ChooseNationAdapter
import com.happymoonday.challengesforheymoon.adapters.SearchMovieAdapter
import com.happymoonday.challengesforheymoon.databinding.FragmentSearchResultsBinding
import com.happymoonday.challengesforheymoon.domain.enums.CountryType
import com.happymoonday.challengesforheymoon.domain.model.Movie
import com.happymoonday.challengesforheymoon.presentation.base.BaseFragment

class SearchResultFragment : BaseFragment() {

    override lateinit var binding: FragmentSearchResultsBinding
    override val viewModel: SearchViewModel by navGraphViewModels(R.id.nav_graph_search_xml)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchResultsBinding.inflate(inflater, container, false)

        binding.apply {
            textEmptyMessage.setOnClickListener { //TODO FIX
                showFavoriteAlert()
            }

            val adapter = SearchMovieAdapter()
            recyclerView.adapter = adapter

            subscribeUi(adapter)
        }

        return binding.root
    }

    private fun subscribeUi(adapter: SearchMovieAdapter) {
        val item = Movie(
            "홈런",
            "https://movie.naver.com/movie/bi/mi/basic.nhn?code=187310",
            "https://ssl.pstatic.net/imgmovie/mdi/mit110/1873/187310_P20_100054.jpg",
        "Minari",
        "2020",
        "정이삭|",
        "윌 패튼|스티븐 연|한예리|윤여정|앨런 김|노엘 조|",
        "7.58")
        var items = listOf<Movie>(item, item, item, item)
        adapter.submitList(items)

        //TODO FIX
        binding.recyclerView.isVisible = !items.isNullOrEmpty()
        binding.textEmptyMessage.isVisible = items.isNullOrEmpty()
    }

    private fun showFavoriteAlert(){
        val alertDialog: AlertDialog? = this.let {
            val builder = AlertDialog.Builder(requireContext())
            builder.apply {
                setTitle(R.string.are_you_sure_you_want_to_add_this_movie_to_your_favorites)
                setPositiveButton(R.string.no
                ) { dialog, id ->
                }
                setNegativeButton(R.string.yes
                ) { dialog, id ->
                    requireActivity().finish()
                    //TODO 탭 첫 번째로 이동
                }
            }
            builder.create()
        }
        alertDialog?.show()
    }

}