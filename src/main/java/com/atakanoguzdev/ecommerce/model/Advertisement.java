package com.atakanoguzdev.ecommerce.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

@Entity(name = "advertisement")
@Document(indexName = "advertisement") // TODO move this document entity to the another one
public class Advertisement {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Field(type = FieldType.Keyword)
    private String title;

    @Field(type = FieldType.Keyword)
    private String description;

    private Double price;

    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private Date creationDate;

    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private Date lastModifiedDate;

    private Long userId;

    public Advertisement() {

    }

    public Advertisement(String title, String description, Double price, Long userId) {
        this(title, description, price, Date.from(Instant.now()), Date.from(Instant.now()), userId);
    }

    public Advertisement(String title, String description, Double price, Date creationDate, Date lastModifiedDate, Long userId) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.creationDate = creationDate;
        this.lastModifiedDate = lastModifiedDate;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", creationDate=" + creationDate +
                ", lastModifiedDate=" + lastModifiedDate +
                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advertisement that = (Advertisement) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(price, that.price) && Objects.equals(creationDate, that.creationDate) && Objects.equals(lastModifiedDate, that.lastModifiedDate) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, price, creationDate, lastModifiedDate, userId);
    }
}
