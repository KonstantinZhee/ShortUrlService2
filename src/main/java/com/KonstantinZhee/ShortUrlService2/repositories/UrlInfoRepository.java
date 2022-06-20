package com.KonstantinZhee.ShortUrlService2.repositories;

import com.KonstantinZhee.ShortUrlService2.models.UrlInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlInfoRepository extends CrudRepository<UrlInfo, Integer> {
    UrlInfo findByHash(String hash);
}
