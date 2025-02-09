package dev.jamesbotelho.order.model.dto;

import lombok.Builder;

@Builder
public record CustomerDTO(
  String id,
  String firstName,
  String lastName,
  String email,
  AddressDTO deliveryAddress
) {
}
