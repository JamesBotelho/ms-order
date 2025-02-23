package dev.jamesbotelho.order.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import dev.jamesbotelho.order.model.dto.OrderDTO;
import dev.jamesbotelho.order.model.entity.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "status", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "lastUpdated", ignore = true)
  Order toEntity(OrderDTO dto);
  
  @Mapping(target = "payment", ignore = true)
  OrderDTO toDTO(Order order);
}
