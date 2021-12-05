package com.example.helloworld.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
abstract class AccountDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAccount(accountEntity: AccountEntity)

    @Query("SELECT * FROM account_table ORDER BY id ASC")
    abstract fun readAccount(): List<AccountEntity>

}