package com.atakanoguzdev.ecommerce;

import com.atakanoguzdev.ecommerce.model.Advertisement;
import com.atakanoguzdev.ecommerce.repository.AdvertisementElasticSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private AdvertisementElasticSearchRepository adRepository;

    @Override
    public void run(String... args) throws Exception{

        Page<Advertisement> findAdvertisement = adRepository.findByTitleFuzzy("Advertisemnt 1", Pageable.unpaged());
        System.out.println("Total Results: " + findAdvertisement.getTotalElements());
        List<Advertisement> adList = findAdvertisement.get().collect(Collectors.toList());
        System.out.println("Elements: \n" + adList);

        adRepository.findAll().forEach(ad -> System.out.println(ad));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
