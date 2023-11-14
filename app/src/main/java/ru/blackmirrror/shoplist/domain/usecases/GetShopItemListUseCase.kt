package ru.blackmirrror.shoplist.domain.usecases

import androidx.lifecycle.LiveData
import ru.blackmirrror.shoplist.domain.ShopItem
import ru.blackmirrror.shoplist.domain.repositories.ShopListRepository

class GetShopItemListUseCase(private val shopListRepository: ShopListRepository) {
    fun execute(): LiveData<List<ShopItem>> {
        return shopListRepository.getShopList()
    }
}