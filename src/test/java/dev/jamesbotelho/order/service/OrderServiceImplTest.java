package dev.jamesbotelho.order.service;

import dev.jamesbotelho.order.model.dto.AddressDTO;
import dev.jamesbotelho.order.model.dto.CustomerDTO;
import dev.jamesbotelho.order.model.dto.ItemDTO;
import dev.jamesbotelho.order.model.dto.OrderDTO;
import dev.jamesbotelho.order.model.dto.PaymentDTO;
import dev.jamesbotelho.order.model.entity.Address;
import dev.jamesbotelho.order.model.entity.Customer;
import dev.jamesbotelho.order.model.entity.Item;
import dev.jamesbotelho.order.model.entity.Order;
import dev.jamesbotelho.order.model.enums.OrderStatus;
import dev.jamesbotelho.order.model.mapper.OrderMapper;
import dev.jamesbotelho.order.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

  @Mock
  private OrderRepository repository;

  @Spy
  private OrderMapper mapper = Mappers.getMapper(OrderMapper.class);

  @InjectMocks
  private OrderServiceImpl service;

  @Test
  void should_find_order_by_id() {
    Item item = Item.builder().productId("productId").count(1).price(new BigDecimal("100")).build();
    Address address = Address.builder().street("street").number("123A").postalCode("58000000").city("city").state("state").build();
    Customer customer = Customer.builder().id("id").firstName("firstName").lastName("lastName").email("email@email.com").deliveryAddress(address).build();
    Order order = Order.builder().id("orderId").items(List.of(item)).customer(customer).status(OrderStatus.SUBMITTED).createdAt(LocalDateTime.now()).lastUpdated(LocalDateTime.now()).build();

    ItemDTO itemDTO = ItemDTO.builder().productId("productId").count(1).price(new BigDecimal("100")).build();
    AddressDTO addressDTO = AddressDTO.builder().street("street").number("123A").postalCode("58000000").city("city").state("state").build();
    CustomerDTO customerDTO = CustomerDTO.builder().id("id").firstName("firstName").lastName("lastName").email("email@email.com").deliveryAddress(addressDTO).build();
    OrderDTO expectedDto = OrderDTO.builder().id("orderId").items(List.of(itemDTO)).customer(customerDTO).status(OrderStatus.SUBMITTED).createdAt(LocalDateTime.now()).lastUpdated(LocalDateTime.now()).build();

    when(repository.findById("orderId")).thenReturn(Mono.just(order));

    StepVerifier.create(service.findOrderById("orderId"))
      .expectNext(expectedDto)
      .verifyComplete();

    verify(repository, times(1)).findById("orderId");
    verify(mapper, times(1)).toDTO(order);
  }

  @Test
  void should_insert_order() {
    ArgumentCaptor<Order> orderArgumentCaptor = ArgumentCaptor.forClass(Order.class);

    Item item = Item.builder().productId("productId").count(1).price(new BigDecimal("100")).build();
    Address address = Address.builder().street("street").number("123A").postalCode("58000000").city("city").state("state").build();
    Customer customer = Customer.builder().id("id").firstName("firstName").lastName("lastName").email("email@email.com").deliveryAddress(address).build();
    Order order = Order.builder().id("orderId").items(List.of(item)).customer(customer).status(OrderStatus.SUBMITTED).createdAt(LocalDateTime.now()).lastUpdated(LocalDateTime.now()).build();

    ItemDTO itemDTO = ItemDTO.builder().productId("productId").count(1).price(new BigDecimal("100")).build();
    AddressDTO addressDTO = AddressDTO.builder().street("street").number("123A").postalCode("58000000").city("city").state("state").build();
    CustomerDTO customerDTO = CustomerDTO.builder().id("id").firstName("firstName").lastName("lastName").email("email@email.com").deliveryAddress(addressDTO).build();
    PaymentDTO paymentDTO = PaymentDTO.builder().cardId("cardId").bin("bin").token("token").cardHolderName("cardHolderName").securityCode("111").brand("brand").expirationYear("01").expirationYear("25").build();
    OrderDTO orderDto = OrderDTO.builder().items(List.of(itemDTO)).customer(customerDTO).status(OrderStatus.SUBMITTED).payment(paymentDTO).build();

    when(repository.save(any(Order.class))).thenReturn(Mono.just(order));

    StepVerifier.create(service.insert(orderDto))
      .assertNext(dto -> {
        assertEquals(List.of(itemDTO), dto.items());
        assertEquals(customerDTO, dto.customer());
        assertEquals(OrderStatus.SUBMITTED, dto.status());
        assertNotNull(dto.createdAt());
        assertNotNull(dto.lastUpdated());
      })
      .verifyComplete();


    verify(mapper, times(1)).toEntity(orderDto);
    verify(repository, times(1)).save(orderArgumentCaptor.capture());
    verify(mapper, times(1)).toDTO(order);

    Order orderCaptured = orderArgumentCaptor.getValue();

    assertNotNull(orderCaptured.getCreatedAt());
    assertNotNull(orderCaptured.getLastUpdated());
    assertEquals(List.of(item), orderCaptured.getItems());
    assertEquals(customer, orderCaptured.getCustomer());
    assertEquals(OrderStatus.SUBMITTED, orderCaptured.getStatus());
  }

}