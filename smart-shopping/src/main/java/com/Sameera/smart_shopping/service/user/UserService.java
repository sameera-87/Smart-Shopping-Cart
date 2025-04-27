package com.Sameera.smart_shopping.service.user;

import com.Sameera.smart_shopping.dto.*;
import com.Sameera.smart_shopping.exceptions.AlreadyExistsException;
import com.Sameera.smart_shopping.exceptions.ResourceNotFoundException;
import com.Sameera.smart_shopping.model.User;
import com.Sameera.smart_shopping.repository.UserRepository;
import com.Sameera.smart_shopping.request.CreateUserRequest;
import com.Sameera.smart_shopping.request.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found!"));
    }

    @Override
    public User createUser(CreateUserRequest request) {
        return Optional.of(request)
                .filter(user -> !userRepository.existsByEmail(request.getEmail()))
                .map(req -> {
                    User user = new User();
                    user.setEmail(request.getEmail());
                    user.setPassword(request.getPassword());
                    user.setFirstName(request.getFirstName());
                    user.setLastName(request.getLastName());
                    return userRepository.save(user);
                }).orElseThrow(() -> new AlreadyExistsException("Oops! " + request.getEmail() + "already exists!"));
    }

    @Override
    public User updateUser(UserUpdateRequest request, Long userId) {
        return userRepository.findById(userId).map(existingUser -> {
            existingUser.setFirstName(request.getFirstName());
            existingUser.setLastName((request.getLastName()));
            return userRepository.save(existingUser);
        }).orElseThrow(() -> new ResourceNotFoundException("User not found!"));
    }

    @Override
    public void deleteUSer(Long userId) {
        userRepository.findById(userId).ifPresentOrElse(userRepository :: delete, () -> {
            throw new ResourceNotFoundException("User not found!");
        });
    }

    @Override
    public UserDto convertUserToDto(User user){

        UserDto dto = new UserDto();
        dto.setId(user.getUserId());
        dto.setFirstName(user.getFirstName());
        dto.setLastname(user.getLastName());
        dto.setEmail(user.getEmail());

        // Map Cart
        if (user.getCart() != null) {
            CartDto cartDto = new CartDto();
            cartDto.setCartId(user.getCart().getId());
            cartDto.setTotalAmount(user.getCart().getTotalAmount());

            // Map Cart Items
            if (user.getCart().getCartItems() != null && !user.getCart().getCartItems().isEmpty()) {
                Set<CartItemDto> cartItemDtos = user.getCart().getCartItems().stream().map(cartItem -> {
                    CartItemDto itemDto = new CartItemDto();
                    itemDto.setItemId(cartItem.getId());
                    itemDto.setQuantity(cartItem.getQuantity());
                    itemDto.setUnitPrice(cartItem.getUnitPrice());

                    // Map the Product inside CartItem
                    if (cartItem.getProduct() != null) {
                        ProductDto productDto = new ProductDto();
                        productDto.setId(cartItem.getProduct().getId());
                        productDto.setName(cartItem.getProduct().getName());
                        productDto.setBrand(cartItem.getProduct().getBrand());
                        productDto.setPrice(cartItem.getProduct().getPrice());
                        productDto.setDescription(cartItem.getProduct().getDescription());
                        // (You can add more fields if needed.)

                        itemDto.setProduct(productDto);
                    }

                    return itemDto;
                }).collect(java.util.stream.Collectors.toSet());

                cartDto.setItems(cartItemDtos);
            }

            dto.setCart(cartDto);
        }

        // Map Orders
        if (user.getOrder() != null && !user.getOrder().isEmpty()) {
            List<OrderDto> orderDtos = user.getOrder().stream().map(order -> {
                OrderDto orderDto = new OrderDto();
                orderDto.setId(order.getOrderId());
                orderDto.setOrderDate(order.getOrderDate().atStartOfDay());
                orderDto.setTotalAmount(order.getTotalAmount());
                orderDto.setStatus(order.getOrderStatus().name());
                // Optionally map OrderItems inside OrderDto
                return orderDto;
            }).toList();
            dto.setOrders(orderDtos);
        }

        return dto;
    }
}
