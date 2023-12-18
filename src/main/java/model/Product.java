package model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    // 4가지의 관계를 나타내는 어노테이션
    //@ManyToMany
    //@OneToMany
    //@OneToOne
    @ManyToOne  // 상품과 카테고리가 N:1 관계라는 가정
    @JoinColumn(name="Category_id")   // 규칙 : @JoinColumn(name="테이블이름_기본키컬럼이름")
    private Category category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }
}
