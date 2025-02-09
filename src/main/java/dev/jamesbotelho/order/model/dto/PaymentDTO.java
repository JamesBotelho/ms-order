package dev.jamesbotelho.order.model.dto;

import lombok.Builder;

@Builder
public record PaymentDTO(
  String cardId,
  String bin,
  String token,
  String cardHolderName,
  String securityCode,
  String brand,
  String expirationMonth,
  String expirationYear
) {
}
