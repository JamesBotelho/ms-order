package dev.jamesbotelho.order.service;

import dev.jamesbotelho.order.model.dto.OrderDTO;
import dev.jamesbotelho.order.model.entity.Order;
import dev.jamesbotelho.order.model.mapper.OrderMapper;
import dev.jamesbotelho.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

import static reactor.core.publisher.Mono.just;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final OrderMapper mapper;
  private final OrderRepository repository;

  @Override
  public Mono<OrderDTO> insert(OrderDTO dto) {
    return just(dto)
      .map(mapper::toEntity)
      .map(Order::setOrderSubmitted)
      .flatMap(repository::save)
      .map(mapper::toDTO);
  }

  @Override
  public Mono<OrderDTO> findOrderById(String id) {
    return repository.findById(id)
      .map(mapper::toDTO);
  }
}
