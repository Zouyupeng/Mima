package com.oceanknight.mima.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * @author Oceanknight
 * @date 2023/10/19 23:15
 * @describe 交易分录表
 *          交易分录可以理解为交易记录的组成因子
 *          一条交易记录可以有多个交易分录
 *          一条交易记录的所有交易分录必须配平
 */
@Entity(
    tableName = "transactionItem",
    foreignKeys = [
        ForeignKey(
            entity = Currency::class,
            parentColumns = ["currency_id"],
            childColumns = ["origin_currency_id", "conversion_currency_id"],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.SET_DEFAULT
        ),
        ForeignKey(
            entity = Account::class,
            parentColumns = ["account_id"],
            childColumns = ["account_id"],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.SET_NULL
        ),
        ForeignKey(
            entity = Transaction::class,
            parentColumns = ["id"],
            childColumns = ["transaction_id"],
            onDelete = ForeignKey.SET_NULL
        ),
    ]
)
data class TransactionItem(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name = "transaction_id")
    var transactionId: Int,

    @ColumnInfo(name = "account_id")
    var accountId: Int,

    @ColumnInfo(name = "origin_currency_id")
    var originCurrencyId: Int,

    @ColumnInfo(name = "origin_currency_value")
    var originCurrencyValue: Int,

    // 货币换算 以应对beancount语法中的 @ 或者 @@
    @ColumnInfo(name = "conversion_currency_id", defaultValue = "NULL")
    var conversionCurrencyId: Int?,

    @ColumnInfo(name = "conversion_currency_value", defaultValue = "NULL")
    var conversionCurrencyValue: Int?,


)