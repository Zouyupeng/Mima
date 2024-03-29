package com.oceanknight.mima.database.model

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
    tableName = "transaction-item",
    foreignKeys = [
        ForeignKey(
            entity = CurrencyEntity::class,
            parentColumns = ["currency_id"],
            childColumns = ["origin_currency_id", "conversion_currency_id"],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.SET_NULL
        ),
        ForeignKey(
            entity = AccountEntity::class,
            parentColumns = ["account_id"],
            childColumns = ["account_id"],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.SET_NULL
        ),
        ForeignKey(
            entity = TransactionEntity::class,
            parentColumns = ["transaction_id"],
            childColumns = ["transaction_id"],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE,
        ),
    ]
)
data class TransactionItemEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "transaction_item_id")
    var transactionItemId: Int? = null,

    @ColumnInfo(name = "transaction_id")
    var transactionId: Int,

    @ColumnInfo(name = "account_id")
    var accountId: Int,

    @ColumnInfo(name = "origin_currency_id")
    var originCurrencyId: Int,

    @ColumnInfo(name = "origin_currency_value")
    var originCurrencyValue: Int,

    // 货币换算 以应对beancount语法中的 @ 或者 @@
    @ColumnInfo(name = "conversion_currency_id", defaultValue = "")
    var conversionCurrencyId: Int?,

    @ColumnInfo(name = "conversion_currency_value", defaultValue = "")
    var conversionCurrencyValue: Int?
)