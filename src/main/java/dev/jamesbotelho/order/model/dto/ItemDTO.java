package dev.jamesbotelho.order.model.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ItemDTO(
  String productId,
  Integer count,
  BigDecimal price
) {}
