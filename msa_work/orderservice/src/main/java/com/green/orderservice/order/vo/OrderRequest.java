package com.green.orderservice.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {

    private String userId;

    @NotNull
    @Min(0)
    private Long totalPrice;

    @NotNull
    @Min(1)
    private Integer quantity;
    
}
