package com.green.catalogservice.catalog.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.green.catalogservice.catalog.jpa.CatalogEntity;
import com.green.catalogservice.catalog.jpa.CatalogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {

    private final CatalogRepository catalogRepository;

    @KafkaListener(topics = "${spring.kafka.topic-name}")
    public void consumeMessage(String message) {
        log.info("Received message: {}", message);

        Map<Object,Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        try{
            map = mapper.readValue(message, Map.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        // 해당되는 ProductId 찾음.. 없으면 빈 CatalogEntity 생성
        CatalogEntity catalogEntity = catalogRepository.findByProductId((String) map.get("productId"))
                                        .orElse(new CatalogEntity());
        // 찾았는 제품에서 재고량 마이너스
        catalogEntity.setStock( catalogEntity.getStock() - (Integer) map.get("qty"));
        // catalogEntity 저장
        catalogRepository.save(catalogEntity);
        // log 남기기
        log.info("catalogRepository.save(catalogEntity): {} 재고수량을 변경 했습니다.", catalogEntity.getProductId());
    }
}
