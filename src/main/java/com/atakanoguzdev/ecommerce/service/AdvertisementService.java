package com.atakanoguzdev.ecommerce.service;

import com.atakanoguzdev.ecommerce.dto.AdvertisementDto;
import com.atakanoguzdev.ecommerce.dto.CreateAdvertisementRequest;
import com.atakanoguzdev.ecommerce.repository.AdvertisementRepository;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementService {

    private final AdvertisementRepository advertisementRepository;

    public AdvertisementService(AdvertisementRepository advertisementRepository) {
        this.advertisementRepository = advertisementRepository;
    }

    public AdvertisementDto createAdvertisement(CreateAdvertisementRequest request){

        return null;

    }
}
