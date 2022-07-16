package com.example.orderdemo.entity;

import com.example.orderdemo.entity.base.BaseEntity;
import com.example.orderdemo.entity.enums.ProductSimpleStatus;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
//@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @Id
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String productId;
    private String name;
//    private String slug;
//    private String description;
    private String detail; // text
    private String thumbnails; // nhiều ảnh cách nhau bởi dấu ,
    private BigDecimal price;
    @Enumerated(EnumType.ORDINAL)
    private ProductSimpleStatus status;

    public Product(){
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
    }

    public Product(String productId, String name, String detail, String thumbnails, BigDecimal price, ProductSimpleStatus status) {
        this.productId = productId;
        this.name = name;
        this.detail = detail;
        this.thumbnails = thumbnails;
        this.price = price;
        this.status = status;
    }


//    @Basic
//    private int status;
//    @Transient
//    private ProductStatus productStatus;
//
//    @PostLoad // khi load
//    void fillTransient() {
//        this.productStatus = ProductStatus.of(status); // chuyển dữ liệu dạng số ở trong database về kiểu enum
//    }
//
//    @PrePersist // trước khi lưu
//    void fillPersistent() {
//        // đưa giá trị của product status vào trường status.
//        this.status = this.productStatus.getValue();
//    }
}
