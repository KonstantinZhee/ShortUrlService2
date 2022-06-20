package com.KonstantinZhee.ShortUrlService2.controllers;


import com.KonstantinZhee.ShortUrlService2.services.UrlInfoService;
import com.KonstantinZhee.ShortUrlService2.util.CodeGenerator;
import com.KonstantinZhee.ShortUrlService2.models.UrlInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping("/")
public class UrlInfoController {
    private final Logger logger = LogManager.getLogger(UrlInfoController.class.getSimpleName());
    private final UrlInfoService urlInfoService;
    private final CodeGenerator codeGenerator;
    @Value("${shorter.length}")
    private Integer shorterLength;

    @Autowired
    public UrlInfoController(final UrlInfoService urlInfoService) {
        this.urlInfoService = urlInfoService;
        this.codeGenerator = new CodeGenerator();
    }

    @PostMapping
    public String createShortUrl(@RequestBody String originalUrl) {
        String hash = codeGenerator.generate(shorterLength);
        logger.info(hash);
        if (originalUrl != null) {
            UrlInfo urlInfo = new UrlInfo(null, hash, originalUrl,new Timestamp(new Date().getTime()));
            urlInfoService.save(urlInfo);
            return hash;
        } else {
            return null;
        }
    }

    @GetMapping(path = "/{hash}")
    public ResponseEntity redirectByShortUrl(@PathVariable("hash") String hash) {
        UrlInfo urlInfo = urlInfoService.findByHash(hash);
        if (urlInfo != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", urlInfo.getOriginalUrl());
            return new ResponseEntity<String>(headers, HttpStatus.FOUND);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
