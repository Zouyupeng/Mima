package com.oceanknight.mima.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * @author Oceanknight
 * @date 2023/10/15 21:26
 * @describe 账本表
 */
@Entity(
    tableName = "ledger",
    foreignKeys = [ForeignKey(
        entity = CurrencyEntity::class,
        parentColumns = ["currency_id"],
        childColumns = ["default_currency_id"],
        onUpdate = ForeignKey.CASCADE,
        onDelete = ForeignKey.SET_NULL,
    )]
)
data class LedgerEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ledger_id")
    var ledgerId: Int? = null,

    @ColumnInfo(name = "ledger_name")
    var ledgerName: String,

    // TODO: 整好图片存储以后设置一个图片路径
    @ColumnInfo(name = "default_currency_id")
    var defaultCurrencyId: String?

)
