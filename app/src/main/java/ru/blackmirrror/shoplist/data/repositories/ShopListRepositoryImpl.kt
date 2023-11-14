package ru.blackmirrror.shoplist.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.blackmirrror.shoplist.domain.ShopItem
import ru.blackmirrror.shoplist.domain.ShopItem.Companion.UNDEFINED_ID
import ru.blackmirrror.shoplist.domain.repositories.ShopListRepository
import java.lang.RuntimeException

object ShopListRepositoryImpl: ShopListRepository {

    private val shopListLiveData = MutableLiveData<List<ShopItem>>()
    private var shopList = sortedSetOf(Comparator<ShopItem> { o1, o2 ->
        o1.id.compareTo(o2.id)
    })

    private var autoIncrementId = 0

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLiveData
    }

    override fun getShopItemById(shopItemId: Int): ShopItem {
        return shopList.find { it.id == shopItemId }?:
        throw RuntimeException("Element shopItem $shopItemId not found")
    }

    override fun createShopItem(shopItem: ShopItem): Boolean {
        if (shopItem.id == UNDEFINED_ID)
            shopItem.id = autoIncrementId++
        shopList.add(shopItem)
        updateList()
        return true
    }

    override fun removeShopItem(shopItemId: Int): Boolean {
        shopList.removeIf { it.id == shopItemId }
        updateList()
        return true
    }

    override fun updateShopItem(shopItem: ShopItem): ShopItem {
        removeShopItem(shopItem.id)
        createShopItem(shopItem)
        return shopItem
    }

    private fun updateList() {
        shopListLiveData.value = shopList.toList()
    }
}