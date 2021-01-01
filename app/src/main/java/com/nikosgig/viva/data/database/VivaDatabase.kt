package com.nikosgig.viva.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nikosgig.viva.data.model.ProductModel

@Database(entities = [ProductModel::class], version = 1)
abstract class VivaDatabase : RoomDatabase() {

    abstract fun productsDao(): ProductsDao

    companion object {
        @Volatile
        private var instance: VivaDatabase? = null

        fun getDatabase(context: Context): VivaDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, VivaDatabase::class.java, "viva.db")
                .build()
    }
}