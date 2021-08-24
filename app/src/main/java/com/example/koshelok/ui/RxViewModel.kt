package com.example.koshelok.ui

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

open class RxViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    protected fun Disposable.disposeOnFinish() {
        addDisposable(this)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
