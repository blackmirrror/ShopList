package ru.blackmirrror.shoplist.domain.usecases

import ru.blackmirrror.shoplist.domain.repositories.ShopListRepository

class RemoveShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun execute(shopItemId: Int): Boolean {
        return shopListRepository.removeShopItem(shopItemId)
    }
}