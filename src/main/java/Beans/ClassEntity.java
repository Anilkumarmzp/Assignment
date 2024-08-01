package Beans;

import javax.persistence.*;

@Entity
@Table(name = "your_table")
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "column1")
    private String column1;

    @Column(name = "column2")
    private int column2;

    @Column(name = "column3")
    private String column3;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public int getColumn2() {
        return column2;
    }

    public void setColumn2(int column2) {
        this.column2 = column2;
    }

    public String getColumn3() {
        return column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }
}
