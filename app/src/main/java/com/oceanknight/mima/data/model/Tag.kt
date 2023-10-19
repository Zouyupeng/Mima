package com.oceanknight.mima.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * @author Oceanknight
 * @date 2023/10/19 22:59
 * @describe
 */
@Entity(
    tableName = "tag",
    indices = [
        Index(
            value = ["tag"],
            unique = true
        )
    ]
)
data class Tag(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "tag_name", defaultValue = "")
    var tag: String,
)