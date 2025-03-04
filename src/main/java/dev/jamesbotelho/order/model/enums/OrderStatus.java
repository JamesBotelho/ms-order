package dev.jamesbotelho.order.model.enums;

public enum OrderStatus {
  SUBMITTED,
  WITHOUT_STOCK,
  ADDRESS_NOT_VALID,
  PAYMENT_APPROVED,
  PAYMENT_FAILED,
  PROCESSING,
  SHIPPED,
  DELIVERED
}
