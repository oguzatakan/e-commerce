package com.atakanoguzdev.ecommerce.dto;

import com.atakanoguzdev.ecommerce.model.Advertisement;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class AdvertisementDtoConverterImpl implements AdvertisementDtoConverter{

    @Override
    public AdvertisementDto convertDto(Advertisement advertisement){
        if (advertisement == null){
            return null;
        }

        Set<String> hashtags = null;
        String id = null;
        String title = null;
        String description = null;
        double price = 0.0d;
        LocalDateTime creationDate = null;
        LocalDateTime lastModifiedDate = null;
        long userId = 0L;

        Set<String> set = advertisement.getHashtags();
        if (set != null) {
            hashtags = new HashSet<String>(set);
        }

        id = advertisement.getId();
        title = advertisement.getTitle();
        description = advertisement.getDescription();
        if (advertisement.getPrice() !=null) {
            userId = advertisement.getUserId();
        }

        assert hashtags != null;
        assert false;
        AdvertisementDto advertisementDto = new AdvertisementDto(id, title, description, price ,creationDate, lastModifiedDate, userId, hashtags);

        return advertisementDto;
    }
}
