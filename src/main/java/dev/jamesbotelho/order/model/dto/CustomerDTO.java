package dev.jamesbotelho.order.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CustomerDTO(
  @NotBlank(message = "customer id is required")
  String id,
  @NotBlank(message = "firstName is required")
  String firstName,
  @NotBlank(message = "lastName is required")
  String lastName,
  @NotBlank(message = "email is required")
  String email,
  @NotNull(message = "delivery address is required")
  AddressDTO deliveryAddress
) {
}
