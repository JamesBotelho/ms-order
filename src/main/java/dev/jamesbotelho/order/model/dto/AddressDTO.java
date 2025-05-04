package dev.jamesbotelho.order.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record AddressDTO(
  @NotBlank(message = "street is required")
  String street,
  @NotBlank(message = "address number is required")
  String number,
  @NotBlank(message = "postal code is required")
  String postalCode,
  @NotBlank(message = "city is required")
  String city,
  @NotBlank(message = "state is required")
  String state
) {
}
