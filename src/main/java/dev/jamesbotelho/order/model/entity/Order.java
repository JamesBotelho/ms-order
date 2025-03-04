package dev.jamesbotelho.order.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import dev.jamesbotelho.order.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
@Document("orders")
public class Order {
  @Id
  private String id;
  private List<Item> items;
  private Customer customer;
  private OrderStatus status;
  private LocalDateTime createdAt;
  private LocalDateTime lastUpdated;

  public Order setOrderSubmitted() {
    return this.toBuilder()
      .status(OrderStatus.SUBMITTED)
      .createdAt(LocalDateTime.now())
      .lastUpdated(LocalDateTime.now())
      .build();
  }
}
