package dev.jamesbotelho.order.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Customer {
  private String id;
  private String firstName;
  private String lastName;
  private String email;
  private Address deliveryAddress;
}
