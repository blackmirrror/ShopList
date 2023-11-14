package ru.blackmirrror.shoplist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.blackmirrror.shoplist.data.repositories.ShopListRepositoryImpl
import ru.blackmirrror.shoplist.domain.ShopItem
import ru.blackmirrror.shoplist.domain.usecases.CreateShopItemUseCase
import ru.blackmirrror.shoplist.domain.usecases.GetShopItemListUseCase
import ru.blackmirrror.shoplist.domain.usecases.RemoveShopItemUseCase
import ru.blackmirrror.shoplist.domain.usecases.UpdateShopItemUseCase

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopItemListUseCase = GetShopItemListUseCase(repository)
    private val removeShopItemUseCase = RemoveShopItemUseCase(repository)
    private val createShopItemUseCase = CreateShopItemUseCase(repository)
    private val updateShopItemUseCase = UpdateShopItemUseCase(repository)

    val shopList: LiveData<List<ShopItem>> = getShopItemListUseCase.execute()

    init {
        for (i in 0 until 15) {
            val item = ShopItem("Name $i", i % 5 + 1, false)
            createShopItemUseCase.execute(item)
        }
    }

    fun removeShopItem(shopItemId: Int): Boolean {
        return removeShopItemUseCase.execute(shopItemId)
    }

    fun changeEnableState(shopItem: ShopItem): ShopItem {
        return updateShopItemUseCase.execute(
            shopItem.copy(enabled = !shopItem.enabled)
        )
    }
}