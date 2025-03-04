package dev.jamesbotelho.order.model.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

import dev.jamesbotelho.order.model.enums.OrderStatus;

@Builder
public record OrderDTO(
  String id,
  List<ItemDTO> items,
  CustomerDTO customer,
  PaymentDTO payment,
  OrderStatus status,
  LocalDateTime createdAt,
  LocalDateTime lastUpdated
) {
}
