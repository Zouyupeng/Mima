package com.oceanknight.mima.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Oceanknight
 * @date 2023/10/19 22:20
 * @describe 交易记录表
 */
@Entity(
    tableName = "transaction",
)
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "transaction_id")
    var transactionId: Int? = null,

    // 收款方 可空
    @ColumnInfo(name = "recipient", defaultValue = "")
    var recipient: String?,

    // 备注如果标记balance，则记录为平账操作（仍在思考）
    @ColumnInfo(name = "description", defaultValue = "")
    var description: String
)

