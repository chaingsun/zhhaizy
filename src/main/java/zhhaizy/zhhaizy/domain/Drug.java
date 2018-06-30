package zhhaizy.zhhaizy.domain;

import javax.persistence.*;

/**
 * springboot
 * spring-data-jpa
 */
@Entity
@Table(name = "drugs")
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.
IDENTITY)
    private Integer id;//药品ID
    private String name;//药品名

    private String pic;//图片

    private String elements;//成分

    private String attendEfficacy;//主治功效

    private String usageDosage;//用法

    private String specification;//药品规格

    @ManyToOne
    private DrugSeries drugSeries;//药品系列

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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getElements() {
        return elements;
    }

    public void setElements(String elements) {
        this.elements = elements;
    }

    public String getAttendEfficacy() {
        return attendEfficacy;
    }

    public void setAttendEfficacy(String attendEfficacy) {
        this.attendEfficacy = attendEfficacy;
    }

    public String getUsageDosage() {
        return usageDosage;
    }

    public void setUsageDosage(String usageDosage) {
        this.usageDosage = usageDosage;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public DrugSeries getDrugSeries() {
        return drugSeries;
    }

    public void setDrugSeries(DrugSeries drugSeries) {
        this.drugSeries = drugSeries;
    }
}
