package com.oceanknight.mima.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

/**
 * @author Oceanknight
 * @date 2024/1/13 19:01
 * @describe 账户-货币 中间表
 */
@Entity(
    tableName = "account-currency",
    primaryKeys = ["account_id", "currency_id"],
    foreignKeys = [
        ForeignKey(
            entity = Account::class,
            parentColumns = ["account_id"],
            childColumns = ["account_id"],
        ),
        ForeignKey(
            entity = Currency::class,
            parentColumns = ["currency_id"],
            childColumns = ["currency_id"],
        ),
    ]
)
data class AccountCurrency (
    @ColumnInfo(name = "account_id")
    var accountId: Int?,

    @ColumnInfo(name = "currency_id")
    var currencyId: Int?,

    var balance: Double
)