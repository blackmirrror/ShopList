package ru.blackmirrror.shoplist.domain.usecases

import ru.blackmirrror.shoplist.domain.ShopItem
import ru.blackmirrror.shoplist.domain.repositories.ShopListRepository

class UpdateShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun execute(shopItem: ShopItem): ShopItem {
        return shopListRepository.updateShopItem(shopItem)
    }
}