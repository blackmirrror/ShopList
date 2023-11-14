package ru.blackmirrror.shoplist.domain.repositories

import androidx.lifecycle.LiveData
import ru.blackmirrror.shoplist.domain.ShopItem

interface ShopListRepository {
    fun getShopList(): LiveData<List<ShopItem>>
    fun getShopItemById(shopItemId: Int): ShopItem
    fun createShopItem(shopItem: ShopItem): Boolean
    fun removeShopItem(shopItemId: Int): Boolean
    fun updateShopItem(shopItem: ShopItem): ShopItem
}