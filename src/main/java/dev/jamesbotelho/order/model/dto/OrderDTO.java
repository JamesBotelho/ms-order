package dev.jamesbotelho.order.model.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record OrderDTO(
  String id,
  List<ItemDTO> items,
  CustomerDTO customer,
  PaymentDTO payment
) {
}
