package dev.jamesbotelho.order.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Address {
  private String street;
  private String number;
  private String postalCode;
  private String city;
  private String state;
}
