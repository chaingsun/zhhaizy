package zhhaizy.zhhaizy.domain;


import javax.persistence.*;


@Entity
@Table(name = "drugCategory" )
public class DrugCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//药品类型id

    private String name;//修改后的药品类型

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
}
