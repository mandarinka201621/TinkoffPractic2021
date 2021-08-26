package com.example.koshelok.ui.listwallet

import android.os.Handler
import android.os.Looper
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.appbar.AppBarLayout

class AppBarRefreshListener(private val mSwipeRefreshLayout: SwipeRefreshLayout) :
    AppBarLayout.OnOffsetChangedListener {

    private var mVerticalOffset = 0
    private val mHandler: Handler = Handler(Looper.getMainLooper())

    override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
        handleOffsetChanged(verticalOffset)
    }

    private fun handleOffsetChanged(verticalOffset: Int) {
        if (verticalOffset == 0) {
            mHandler.removeCallbacksAndMessages(null)
            mHandler.postDelayed(
                { mSwipeRefreshLayout.isEnabled = mVerticalOffset == 0 },
                BLOCK_DELAY
            )
        } else {
            mSwipeRefreshLayout.isEnabled = false
        }
        mVerticalOffset = verticalOffset
    }

    companion object {
        private const val BLOCK_DELAY = 300L
    }
}
