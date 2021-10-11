package com.atakanoguzdev.ecommerce.dto;

import com.atakanoguzdev.ecommerce.model.Advertisement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdvertisementDtoConverter {

    AdvertisementDtoConverter INSTANCE = Mappers.getMapper(AdvertisementDtoConverter.class);

    AdvertisementDto convertDto(Advertisement advertisement);
}
