package com.example.orderdemo.controller;

import com.example.orderdemo.entity.Order;
import com.example.orderdemo.entity.search.*;
import com.example.orderdemo.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/admin")
@CrossOrigin(origins = "http://localhost:8081")
public class OrderApi {

    final OrderService orderService;

    public OrderApi(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/orders")
    public ResponseEntity<?> findAll(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "limit", defaultValue = "10") int limit,
            @RequestParam(name = "orderId", required = false) String orderId,
            @RequestParam(name = "nameUser", required = false) String nameUser,
            @RequestParam(name = "phone", required = false) String phone,
            @RequestParam(name = "nameProduct", required = false) String nameProduct,
            @RequestParam(name = "sort", required = false) String sort,
            @RequestParam(name = "start", required = false) String start,
            @RequestParam(name = "end", required = false) String end
    ) {
        SearchBody searchBody = SearchBody.SearchBodyBuilder.aSearchBody()
                .withPage(page)
                .withLimit(limit)
                .withOrderId(orderId)
                .withPhone(phone)
                .withNameUser(nameUser)
                .withNameProduct(nameProduct)
                .withSort(sort)
                .withStart(start)
                .withEnd(end)
                .build();

        return ResponseEntity.ok(orderService.findAll(searchBody));
    }

//    @RequestMapping(method = RequestMethod.GET, path = "orders")
//    public ResponseEntity<?> findAll(
//            @RequestParam(name = "page", defaultValue = "1") int page,
//            @RequestParam(name = "limit", defaultValue = "10") int limit,
//            @RequestParam(defaultValue = "") String keyword,
//            @RequestParam(defaultValue = "") String userId,
//            @RequestParam(defaultValue = "2") int status) {
//
//        Specification<Order> specification = Specification.where(null);
//
//        if (status != 0) {
//            SearchCriteria searchCriteria
//                    = new SearchCriteria("status", SearchCriteriaOperator.EQUALS, status);
//            OrderSpecification filter = new OrderSpecification(searchCriteria);
//            specification = specification.and(filter);
//        }
//        if (userId != null) {
//            SearchCriteria searchCriteria
//                    = new SearchCriteria("fullName", SearchCriteriaOperator.JOIN_USERNAME, userId);
//            OrderSpecification filter = new OrderSpecification(searchCriteria);
//            specification = specification.and(filter);
//        }
//        Page<Order> result = this.orderService.findAll(page, limit, specification);
//        return ResponseEntity.ok().body(result);
//    }
//
//    @RequestMapping(method = RequestMethod.POST, path = "orders")
//    public ResponseEntity<?> findAllByOneObject(
//            @RequestBody FilterParameter param) {
//        Page<Order> result = this.orderService.findAll(param);
//        return ResponseEntity.ok().body(result);
//    }
}