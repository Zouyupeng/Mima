package com.oceanknight.mima.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

/**
 * @author Oceanknight
 * @date 2023/10/19 23:07
 * @describe 交易记录和tag的中间表
 */
 @Entity(
     primaryKeys = ["transaction_id", "tag_id"],
     foreignKeys = [
         ForeignKey(
             entity = TransactionEntity::class,
             parentColumns = ["transaction_id"],
             childColumns = ["transaction_id"],
         ),
         ForeignKey(
             entity = TagEntity::class,
             parentColumns = ["tag_id"],
             childColumns = ["tag_id"],
         ),
     ]
 )
data class TransactionTag(
    @ColumnInfo(name = "transaction_id")
    var transactionId: Int,

    @ColumnInfo(name = "tag_id")
    var tagId: Int
)