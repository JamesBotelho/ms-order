package dev.jamesbotelho.order.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

import dev.jamesbotelho.order.model.enums.OrderStatus;

@Builder
public record OrderDTO(
  String id,
  @Valid
  @NotEmpty(message = "items is required")
  List<ItemDTO> items,
  @NotNull(message = "customer is required")
  CustomerDTO customer,
  @Valid
  @NotNull(message = "payment is required")
  PaymentDTO payment,
  OrderStatus status,
  LocalDateTime createdAt,
  LocalDateTime lastUpdated
) {
}
