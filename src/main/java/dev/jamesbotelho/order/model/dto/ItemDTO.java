package dev.jamesbotelho.order.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ItemDTO(
  @NotBlank(message = "product id is required")
  String productId,
  @NotNull(message = "count products is required")
  @Min(value = 1, message = "The min value of product is 1")
  Integer count,
  @NotNull(message = "price is required")
  BigDecimal price
) {}
