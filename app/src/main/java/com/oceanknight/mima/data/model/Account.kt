package com.oceanknight.mima.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * @author Oceanknight
 * @date 2023/10/15 22:30
 * @describe    账户
 *              此处账户指的是一个账本下，Assets，Income这种户头，
 *              不是邮箱，电话号那个意义的账户
 */
@Entity(
    tableName = "account",
    foreignKeys = [
        ForeignKey(
            entity = Ledger::class,
            parentColumns = ["id"],
            childColumns = [""]
        ),
        ForeignKey(
            entity = Account::class,
            parentColumns = ["id"],
            childColumns = ["parent_account_id"]
        ),
        ForeignKey(
            entity = Currency::class,
            parentColumns = ["id"],
            childColumns = ["ledger_id"]
        )
    ]
)
data class Account(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "account_name")
    var accountName: String,

    @ColumnInfo(name = "parent_ledger_id")
    var parentLedgerId: Int,

    @ColumnInfo(name = "parent_account_id", defaultValue = "-1")
    var parentAccountId: Int,

    @ColumnInfo(name = "ledger_id")
    var ledgerId: Int,

    // TODO: 去了解一下Room的TypeConvert，看看是在这里转时间戳方便还是在外面处理好了存方便
    @ColumnInfo(name = "create_date")
    var createDate: String,

    @ColumnInfo(name = "value")
    var value: Long,

    // TODO: 同上TODO
    @ColumnInfo(name = "edit_date")
    var editDate: String,

    @ColumnInfo(name = "describe")
    var describe: String,
)
