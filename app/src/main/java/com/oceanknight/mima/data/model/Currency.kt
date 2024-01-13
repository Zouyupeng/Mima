package com.oceanknight.mima.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Oceanknight
 * @date 2023/10/15 19:53
 * @describe 货币表
 */
@Entity(tableName = "currency")
data class Currency(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "currency_id")
    var currencyId: Int? = null,

    @ColumnInfo(name = "currency_name")
    var currencyName: String,

    @ColumnInfo(name = "currency_icon")
    var currencyIcon: String
)