package com.atakanoguzdev.ecommerce.dto

data class CreateAdvertisementRequest(
        val title: String,
        val description: String,
        val price: Double, // TODO: change it by BigDecimal
        val userId: Long,
        val hashtag: Set<String> // TODO: check the forbidden hashtag
)