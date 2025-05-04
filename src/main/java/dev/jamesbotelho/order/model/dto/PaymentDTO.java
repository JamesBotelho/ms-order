package dev.jamesbotelho.order.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record PaymentDTO(
  @NotBlank(message = "card id is required")
  String cardId,
  @NotBlank(message = "bin is required")
  String bin,
  @NotBlank(message = "token is required")
  String token,
  @NotBlank(message = "card holder name is required")
  String cardHolderName,
  @NotBlank(message = "security code is required")
  String securityCode,
  @NotBlank(message = "brand is required")
  String brand,
  @NotBlank(message = "expiration month is required")
  String expirationMonth,
  @NotBlank(message = "expiration year is required")
  String expirationYear
) {
}
