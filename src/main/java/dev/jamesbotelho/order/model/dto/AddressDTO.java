package dev.jamesbotelho.order.model.dto;

import lombok.Builder;

@Builder
public record AddressDTO(
  String street,
  String number,
  String postalCode,
  String city,
  String state
) {
}
