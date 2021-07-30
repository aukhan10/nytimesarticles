package com.droid.nytimes.screens.dashboard.activity

import android.content.Intent
import androidx.lifecycle.Observer
import com.droid.nytimes.screens.articledetail.constant.AdvertisementDetailConstant
import com.droid.nytimes.common.base.activity.AppBaseActivity
import com.droid.nytimes.R
import com.droid.nytimes.common.models.dto.AdvertisementModel
import com.droid.nytimes.screens.articledetail.activity.AdvertisementDetailActivity
import com.droid.nytimes.screens.dashboard.adapter.ListAdvertisementAdapter
import com.droid.nytimes.screens.dashboard.listener.OnAdvertisementSelected
import com.droid.nytimes.screens.dashboard.viewmodel.DashboardViewModel
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import org.koin.android.viewmodel.ext.android.getViewModel

class DashboardActivity : AppBaseActivity(){
    private lateinit var viewModel: DashboardViewModel
    override fun init() {
        toolbar.setup(this, getString(R.string.activity_dashboard_title), false)
        viewModel = getViewModel()
    }

    override fun setEvents() {

    }

    override fun setObservers() {
        viewModel.showMessage.observe(this, Observer {
            it?.let {
                showMessage(it)
            }
        })
        viewModel.isLoading.observe(this, Observer {
            it?.let {
                if (it) {
                    showLoadingDialog()
                } else {
                    hideLoadingDialog()
                }
            }
        })
        viewModel.listAdvertisements.observe(this, Observer {
            it?.let {
                populateList(it)
            }
        })
    }

    override fun getLayoutResId() = R.layout.activity_dashboard

    private fun populateList(list: ArrayList<AdvertisementModel>) {
        val adapter = ListAdvertisementAdapter(this, list, onAdvertisementModel)
        bindVerticalAdapterWithRecyclerview(recyclerView, adapter)
    }

    private val onAdvertisementModel = object : OnAdvertisementSelected {
        override fun onClicked(model: AdvertisementModel) {

            val intent = Intent(this@DashboardActivity, AdvertisementDetailActivity::class.java)
            intent.putExtra(AdvertisementDetailConstant.Bundle_Advertisement_Model, model)
            startAnotherActivity(intent)

        }

    }

}