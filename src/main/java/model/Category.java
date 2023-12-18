package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;

    // 리스트는 우리가 만들어줘야된다.
    @OneToMany(mappedBy = "category")
    // 양방향 연결 시 주인을 정해줘야되는데 그 주인을 적을떄 category_id가 아닌 category_id의 변수 이름 즉 외래키의 변수 이름인 category를 적어줘야된다.
    private List<Product> productList = new ArrayList<>();

    public List<Product> getProductList() {
        return productList;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }
}
