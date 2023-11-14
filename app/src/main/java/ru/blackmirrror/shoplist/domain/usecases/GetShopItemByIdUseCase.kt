package ru.blackmirrror.shoplist.domain.usecases

import ru.blackmirrror.shoplist.domain.ShopItem
import ru.blackmirrror.shoplist.domain.repositories.ShopListRepository

class GetShopItemByIdUseCase(private val shopListRepository: ShopListRepository) {
    fun execute(shopItemId: Int): ShopItem {
        return shopListRepository.getShopItemById(shopItemId)
    }
}