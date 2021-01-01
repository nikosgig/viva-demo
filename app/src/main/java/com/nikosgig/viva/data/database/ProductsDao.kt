package com.nikosgig.viva.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nikosgig.viva.data.model.ProductModel

@Dao
interface ProductsDao {

    @Query("SELECT * FROM products ORDER BY id DESC")
    suspend fun getProducts(): List<ProductModel>

    @Query("SELECT * FROM products WHERE id = :id LIMIT 1")
    suspend fun getProductById(id: Int): ProductModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(application: ProductModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductList(application: List<ProductModel>)

    @Query("DELETE FROM products WHERE id = :id")
    suspend fun deleteProductById(id: Int)

    @Query("DELETE FROM products")
    suspend fun deleteProducts()
}