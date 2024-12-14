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
import java.util.Optional;

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
        /*
            {"id":9,"productId":"p-004","qty":10,"unitPrice":1000,
            "totalPrice":10000,
            "userId":"1058fdf7-0570-46e6-8f35-7e564255a4f0","orderId":"540cd218-b5d4-4757-9d0f-f54969ab2d4e","createdAt":1733111274816}
         */
        Optional<CatalogEntity> catalogEntity = catalogRepository.findByProductId((String) map.get("productId"));
        if(catalogEntity.isPresent()){
            // 찾았는 제품에서 재고량 마이너스
            catalogEntity.get().setStock( catalogEntity.get().getStock() - (Integer) map.get("qty"));
            catalogRepository.save(catalogEntity.get());
            // catalogEntity 저장
        }else {
            // 데이터베이스에 없는 제품이면 처음부터 마이너스 숫자로 저장..
            catalogRepository.save(CatalogEntity.builder()
                    .productId((String) map.get("productId"))
                    .productName("제품명")
                    .stock((Integer) map.get("qty"))
                    .build());
        }
    }
}
