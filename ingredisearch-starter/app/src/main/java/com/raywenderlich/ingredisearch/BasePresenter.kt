package com.raywenderlich.ingredisearch

/**
 * Created by ykc on 2018-02-02.
 */
abstract class BasePresenter<V> {
    protected  var view: V? = null

    fun attachView(view: V) {
        this.view = view
    }

    fun detachView() {
        this.view = null
    }
}