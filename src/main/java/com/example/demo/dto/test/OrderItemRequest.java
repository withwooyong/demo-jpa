package com.example.demo.dto.test;

import com.example.demo.entity.test.PackagesV2;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
@ToString
@Builder
@NoArgsConstructor
public class OrderItemRequest {
    private int cartSeq;
    private String cartType;
    private String packageTypeCode;
    private Integer packageSeq;
    private String packageName;
    private String freeYn;
    private Integer originalPrice;
    private Integer salePrice;
    private Integer cnt;
    private String requiredYn;
    private Integer productSeq;
    private Integer sortOrder;
    @Setter
    private List<OrderItemRequest> productItems;

    @Builder
    public OrderItemRequest(int cartSeq, String cartType, String packageTypeCode, Integer packageSeq, String packageName, String freeYn, Integer originalPrice, Integer salePrice, Integer cnt, String requiredYn, Integer productSeq, Integer sortOrder, List<OrderItemRequest> productItems) {
        this.cartSeq = cartSeq;
        this.cartType = cartType;
        this.packageTypeCode = packageTypeCode;
        this.packageSeq = packageSeq;
        this.packageName = packageName;
        this.freeYn = freeYn;
        this.originalPrice = originalPrice;
        this.salePrice = salePrice;
        this.cnt = cnt;
        this.requiredYn = requiredYn;
        this.productSeq = productSeq;
        this.sortOrder = sortOrder;
        this.productItems = productItems;
    }

    public OrderItemRequest(List<CartItem> cartItemList, boolean isEntrancedUser, PackagesV2 packageInfo) {
        List<OrderItemRequest> orderItemRequests = new ArrayList<>();
        OrderItemRequest orderItemRequest = new OrderItemRequest();
        for (CartItem cartItem : cartItemList) {
            OrderItemRequest innerOrderItemRequest = OrderItemRequest.builder()
                    .cartSeq(cartItem.getCartSeq())
                    .packageSeq(packageInfo.getPackageSeq())
                    .packageTypeCode(cartItem.getPackageTypeCode())
                    .packageName(cartItem.getPackageName())
                    .freeYn(cartItem.getFreeYn())
                    .originalPrice(cartItem.getOriginalPrice())
                    .salePrice(0)
                    .cnt(cartItem.getCnt())
                    .requiredYn(cartItem.getRequiredYn())
                    .productSeq(cartItem.getProductSeq())
                    .sortOrder(cartItem.getSortOrder())
                    .build();
            if (cartItem.getProductSeq() == null)
                orderItemRequest = innerOrderItemRequest;
            else orderItemRequests.add(innerOrderItemRequest);
        }
        this.productItems = orderItemRequests;
    }
}
