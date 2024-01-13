package com.oceanknight.mima.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * @author Oceanknight
 * @date 2023/10/15 22:30
 * @describe    户头表
 *              此处户头指的是一个账本下，Assets，Income这种户头，
 *              不是邮箱，电话号那个意义的账户
 */
@Entity(
    tableName = "account",
    foreignKeys = [
        ForeignKey(
            entity = Ledger::class,
            parentColumns = ["ledger_id"],
            childColumns = ["parent_ledger_id"],
            onUpdate = ForeignKey.CASCADE,
        ),
        ForeignKey(
            entity = Account::class,
            parentColumns = ["account_id"],
            childColumns = ["parent_account_id"],
            onUpdate = ForeignKey.CASCADE,
        ),
    ]
)
data class Account(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "account_id")
    var accountId: Int? = null,

    @ColumnInfo(name = "account_name")
    var accountName: String,

    @ColumnInfo(name = "parent_ledger_id")
    var parentLedgerId: Int,

    @ColumnInfo(name = "parent_account_id", defaultValue = "-1")
    var parentAccountId: Int,

    // TODO: 去了解一下Room的TypeConvert，看看是在这里转时间戳方便还是在外面处理好了存方便
    @ColumnInfo(name = "create_date")
    var createDate: String,

    // TODO: 同上TODO
    @ColumnInfo(name = "edit_date")
    var editDate: String,

    @ColumnInfo(name = "describe")
    var describe: String,
)
