package com.atakanoguzdev.ecommerce.dto

import org.mapstruct.Mapper
import java.time.LocalDateTime


data class AdvertisementDto (
    val id:String?,
    val title:String,
    val description: String,
    val price: Double, //TODO change it by BigDecimal
    val creationDate: LocalDateTime,
    val lastModifiedDate: LocalDateTime,
    val userId: Long,
    val hashtags: Set<String>)

