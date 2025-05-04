package dev.jamesbotelho.order.controller;

import dev.jamesbotelho.order.model.dto.OrderDTO;
import dev.jamesbotelho.order.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
public class OrderController {

  private final OrderService service;

  @GetMapping("{id}")
  public Mono<OrderDTO> findOrderById(@PathVariable String id) {
    return service.findOrderById(id);
  }

  @PostMapping
  public Mono<OrderDTO> createOrder(@Valid @RequestBody OrderDTO dto) {
    return service.insert(dto);
  }
}
