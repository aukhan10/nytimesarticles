package com.droid.nytimes.screens.articledetail.activity

import androidx.lifecycle.Observer
import com.droid.nytimes.screens.articledetail.constant.AdvertisementDetailConstant
import com.droid.nytimes.R
import com.droid.nytimes.common.base.activity.AppBaseActivity
import com.droid.nytimes.common.models.dto.AdvertisementModel
import com.droid.nytimes.common.util.ImageUtil
import com.droid.nytimes.screens.articledetail.viewModel.AdvertisementDetailViewModel
import kotlinx.android.synthetic.main.activity_advertisement_detail.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import org.koin.android.viewmodel.ext.android.getViewModel

class AdvertisementDetailActivity : AppBaseActivity() {
    private lateinit var viewModel: AdvertisementDetailViewModel
    override fun init() {
        toolbar.setup(this, getString(R.string.activity_advertisement_detail_title), true)
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
            if (it) {
                showLoadingDialog()
            } else {
                hideLoadingDialog()
            }
        })
        viewModel.advertisementModel.observe(this, Observer {
            it?.let {
                populateAdvertisementModel(it)
            }
        })
        viewModel.readDataFromBundle.observe(this, Observer {
            if (it) {
                readDataFromBundle()
            }
        })
    }

    override fun getLayoutResId() = R.layout.activity_advertisement_detail

    private fun populateAdvertisementModel(model: AdvertisementModel) {
        model.apply {
            tvName.text = title ?: ""
            tvDate.text = published_date ?: ""
            tvWriter.text = writer ?: ""
            tvDescription.text = detail ?: ""
            media?.let {
                val list = it
                if (list.size > 0) {
                    val image = list[0]
                    ImageUtil.loadImage(ivBanner.context, ivBanner, image.imageUrls[2].url)
                }
            }
        }
    }

    private fun readDataFromBundle() {
        val ob = intent.getSerializableExtra(AdvertisementDetailConstant.Bundle_Advertisement_Model)
        if (ob is AdvertisementModel) {
            viewModel.setAdvertisementDetailModel(ob)
        }
    }
}