package com.green.catalogservice.messagequeue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.green.catalogservice.catalog.jpa.CatalogEntity;
import com.green.catalogservice.catalog.jpa.CatalogRepository;
import com.green.catalogservice.error.CatalogException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {

    private final CatalogRepository catalogRepository;

    @KafkaListener(topics = "ex01")
    public void consume(String message) {
        log.info("Kafka Message: ->" + message);

        Map<Object, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(message, new TypeReference<Map<Object, Object>>() {});
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }

        CatalogEntity entity = catalogRepository.findByProductId((String)map.get("productId"))
                .orElseThrow(() -> new CatalogException("해당 제품이 없습니다."));
        if (entity != null) {
            entity.setStock(entity.getStock() - (Integer)map.get("qty"));
            catalogRepository.save(entity);
        }
    }
}