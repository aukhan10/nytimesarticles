package com.droid.nytimes.common.base.activity

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.droid.nytimes.R

abstract class AppBaseActivity() : AppCompatActivity() {
    private var loadingDialog: Dialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        init()
        setEvents()
        setObservers()
    }

    fun startAnotherActivity(intent: Intent) {
        startActivity(intent)
    }

    fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    fun bindVerticalAdapterWithRecyclerview(
        recyclerView: RecyclerView,
        adapter: RecyclerView.Adapter<*>?
    ) {
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.adapter = adapter
    }

    open fun showLoadingDialog() {
        if (loadingDialog == null) {
            loadingDialog = Dialog(this)
            loadingDialog?.let {
                it.requestWindowFeature(Window.FEATURE_NO_TITLE)
                it.setContentView(R.layout.dialog_loading)
                it.setCancelable(false)
                it.window?.setBackgroundDrawableResource(R.color.black)
                if (!it.isShowing) {
                    it.show()
                }
            }

        }
    }

    open fun hideLoadingDialog() {
        loadingDialog?.let {
            if (it.isShowing) {
                it.dismiss()
            }
        }
    }

    protected abstract fun init()
    protected abstract fun setEvents()
    protected abstract fun setObservers()
    protected abstract fun getLayoutResId(): Int
}