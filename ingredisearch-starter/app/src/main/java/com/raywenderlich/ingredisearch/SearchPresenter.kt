package com.raywenderlich.ingredisearch

/**
 * Created by ykc on 2018-02-01.
 */
class SearchPresenter {
    private var view: View? = null

    fun attachView(view: View) {
        this.view = view
    }

    fun detachView() {
        this.view = null
    }

    fun search(query: String) {
        if (query.trim().isBlank()) {
            view?.showQueryRequireMessage()
        } else {
            view?.showSearchResults(query)
        }
    }


    interface View {
        fun showQueryRequireMessage()
        fun showSearchResults(query: String)
    }




}