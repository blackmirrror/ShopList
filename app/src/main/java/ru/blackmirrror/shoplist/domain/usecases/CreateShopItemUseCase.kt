package ru.blackmirrror.shoplist.domain.usecases

import ru.blackmirrror.shoplist.domain.ShopItem
import ru.blackmirrror.shoplist.domain.repositories.ShopListRepository

class CreateShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun execute(shopItem: ShopItem): Boolean {
        return shopListRepository.createShopItem(shopItem)
    }
}