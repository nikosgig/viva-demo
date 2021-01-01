package com.nikosgig.viva.features.productList

import com.nikosgig.viva.data.database.ProductsDao
import com.nikosgig.viva.data.model.ProductModel

class ProductListRepository(private val productsDao: ProductsDao) {

    suspend fun insertProductToDatabase(product: ProductModel) = productsDao.insertProduct(product)

    suspend fun insertProductListToDatabase(products: List<ProductModel>) =
        productsDao.insertProductList(products)

    suspend fun deleteProductFromDatabase(id: Int) = productsDao.deleteProductById(id)

    suspend fun getProducts() = productsDao.getProducts()

    suspend fun getProductById(id: Int) = productsDao.getProductById(id)

}