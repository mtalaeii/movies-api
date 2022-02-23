package com.mtalaeii.search.adapter

import com.mtalaeii.search.model.Data

interface OnItemClick {
    fun onClick(data: Data)
    fun onFavoriteIconCLick(data:Data)
}