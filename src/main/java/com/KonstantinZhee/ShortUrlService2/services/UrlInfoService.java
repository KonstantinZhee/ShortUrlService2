package com.KonstantinZhee.ShortUrlService2.services;

import com.KonstantinZhee.ShortUrlService2.models.UrlInfo;
import com.KonstantinZhee.ShortUrlService2.repositories.UrlInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UrlInfoService {
    private final UrlInfoRepository urlInfoRepository;

    @Autowired
    public UrlInfoService(UrlInfoRepository urlInfoRepository) {
        this.urlInfoRepository = urlInfoRepository;
    }
    public void save(UrlInfo urlInfo) {
        urlInfoRepository.save(urlInfo);
    }
    public UrlInfo findByHash (String hash) {
        return urlInfoRepository.findByHash(hash);
    }

}
