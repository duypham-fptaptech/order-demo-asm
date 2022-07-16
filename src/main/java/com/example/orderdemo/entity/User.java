package com.example.orderdemo.entity;

import com.example.orderdemo.entity.base.BaseEntity;
import com.example.orderdemo.entity.enums.ProductSimpleStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User{
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Id
    private String id;
    private String fullName;
    private String phone;
    private String email;
    private ProductSimpleStatus status;
}