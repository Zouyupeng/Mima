package com.oceanknight.mima.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * @author Oceanknight
 * @date 2023/10/19 23:07
 * @describe 交易记录和tag的中间表
 */
 @Entity(
     tableName = "transactionTagLink",
     foreignKeys = [
         ForeignKey(
             entity = Transaction::class,
             parentColumns = ["id"],
             childColumns = ["transaction_id"],
             onDelete = ForeignKey.SET_NULL
         ),
         ForeignKey(
             entity = Tag::class,
             parentColumns = ["id"],
             childColumns = ["tag_id"],
             onDelete = ForeignKey.SET_NULL
         ),
     ]
 )
data class TransactionTagLink(
    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "transaction_id")
    var transactionId: Int,

    @ColumnInfo(name = "tag_id")
    var tagId: Int
)