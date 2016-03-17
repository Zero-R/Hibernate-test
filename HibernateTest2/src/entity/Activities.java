package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dell on 2015/11/11 0011.
 */
@Entity
@Table(name = "activities")
public class Activities implements Serializable {

    @Id
    @Column(name = "activity_id")
    @GenericGenerator(name = "generator_hilo", strategy = "hilo")
    @GeneratedValue(generator = "generator_hilo")
    private Integer id;
    private String name;
    private int batch;
    private int standard;
    private int period;
    private double property;
    private double cost;

    @Temporal(TemporalType.DATE)
    private Date beginDate;

    @OneToMany(targetEntity = Doing.class)
    @JoinColumn(name = "activity_id", referencedColumnName = "activity_id")
    private Set<Doing> doingUsers = new HashSet<>();

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

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public double getProperty() {
        return property;
    }

    public void setProperty(double property) {
        this.property = property;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    @Override
    public String toString() {
        return "Activities{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", batch=" + batch +
                ", standard=" + standard +
                ", period=" + period +
                ", property=" + property +
                ", cost=" + cost +
                ", beginDate=" + beginDate +
                '}';
    }
}
