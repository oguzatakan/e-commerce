package com.atakanoguzdev.ecommerce.repository;

import com.atakanoguzdev.ecommerce.model.Advertisement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface AdvertisementElasticSearchRepository extends ElasticsearchRepository<Advertisement, String> {

    Page<Advertisement> findByTitleAndDescriptionLike(String title, Pageable pageable);

    @Query("{\"match\": {\"title\": {\"query\": \"?0\", \"fuzziness\": \"1\", \"operator\": \"or\"}}}")
    Page<Advertisement> findByTitleFuzzy(String title, Pageable pageable);
}
