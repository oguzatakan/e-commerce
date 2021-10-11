package com.atakanoguzdev.ecommerce.service;

import com.atakanoguzdev.ecommerce.dto.AdvertisementDto;
import com.atakanoguzdev.ecommerce.dto.AdvertisementDtoConverter;
import com.atakanoguzdev.ecommerce.dto.CreateAdvertisementRequest;
import com.atakanoguzdev.ecommerce.model.Advertisement;
import com.atakanoguzdev.ecommerce.repository.AdvertisementRepository;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementService {

    private final AdvertisementRepository advertisementRepository;


    public AdvertisementService(AdvertisementRepository advertisementRepository) {
        this.advertisementRepository = advertisementRepository;
    }

    public AdvertisementDto createAdvertisement(CreateAdvertisementRequest request){
        Advertisement advertisement =   new Advertisement(request.getTitle(),
                request.getDescription(),
                request.getPrice(),
                request.getUserId(),
                request.getHashtag());

        advertisementRepository.save(advertisement);
        return AdvertisementDtoConverter.INSTANCE.convertDto(advertisement);

    }
}
