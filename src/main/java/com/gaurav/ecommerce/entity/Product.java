package com.gaurav.ecommerce.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

/*
    Entities in JPA are nothing but POJOs(Plain Old Java Object) representing data that
    can be persisted in the database. An entity represents a
    table stored in a database. Every instance of an
    entity represents a row in the table.

    Note: entity classes must not be declared final.
*/
@Entity
// we can specify the table name using the @Table annotation: here
// product is the table name in db
// we can also mention SCHEMA Schema name helps to distinguish one set of tables from another.
//  If we don’t use the @Table annotation, the name of the table will be the name of the entity.
@Table(name = "product")
@Data //automatically generate the getters and setters behind the scenes thats why we use lombok library
public class Product {

/*
    Each JPA entity must have a primary key that uniquely identifies it.
    The @Id annotation defines the primary key. We can generate the
    identifiers in different ways, which are specified
    by the @GeneratedValue annotation.

    We can choose from four id generation strategies with
    the strategy element. The value can be AUTO, TABLE, SEQUENCE, or IDENTITY:
*/

/*
    @Transient annotaiton is very useful in cases when
    Sometimes, we may want to make a field non-persistent. We can use the
    @Transient annotation to do so. It specifies that the field won’t be persisted.
*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;

    @Column(name = "sku")
    private String sku;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "active")
    private boolean active;

    @Column(name = "units_in_stock")
    private int unitsInStock;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;


}
