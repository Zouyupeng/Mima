package com.oceanknight.mima.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.oceanknight.mima.database.dao.AccountDao
import com.oceanknight.mima.database.dao.CurrencyDao
import com.oceanknight.mima.database.dao.LedgerDao
import com.oceanknight.mima.database.dao.TagDao
import com.oceanknight.mima.database.dao.TransactionDao
import com.oceanknight.mima.database.dao.TransactionItemDao
import com.oceanknight.mima.database.model.AccountEntity
import com.oceanknight.mima.database.model.CurrencyEntity
import com.oceanknight.mima.database.model.LedgerEntity
import com.oceanknight.mima.database.model.TagEntity
import com.oceanknight.mima.database.model.TransactionEntity
import com.oceanknight.mima.database.model.TransactionItemEntity

/**
 * @author Oceanknight
 * @date 2024/1/17 22:22
 * @describe
 */
@Database(
    version = 1,
    entities = [
        AccountEntity::class,
        CurrencyEntity::class,
        LedgerEntity::class,
        TagEntity::class,
        TransactionEntity::class,
        TransactionItemEntity::class
    ]
)
abstract class MimaDatabase: RoomDatabase() {
    abstract fun accountDao(): AccountDao

    abstract fun currencyDao(): CurrencyDao

    abstract fun ledgerDao(): LedgerDao

    abstract fun tagDao(): TagDao

    abstract fun transactionDao(): TransactionDao

    abstract fun transactionItemDao(): TransactionItemDao
}