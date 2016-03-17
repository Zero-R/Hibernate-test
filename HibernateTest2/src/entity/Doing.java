package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by dell on 2015/11/12 0012.
 */
@Entity
@Table(name = "doing")
public class Doing implements Serializable{

    @Id
    @GenericGenerator(name = "generator_hilo", strategy = "hilo")
    @GeneratedValue(generator = "generator_hilo")
    private int id;
    private int todayData;
    private int totalData;
    private boolean isTodayFinished;
    private boolean isValid;

    public int getTodayData() {
        return todayData;
    }

    public void setTodayData(int todayData) {
        this.todayData = todayData;
    }

    public int getTotalData() {
        return totalData;
    }

    public void setTotalData(int totalData) {
        this.totalData = totalData;
    }

    public boolean isTodayFinished() {
        return isTodayFinished;
    }

    public void setIsTodayFinished(boolean isTodayFinished) {
        this.isTodayFinished = isTodayFinished;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    @Override
    public String toString() {
        return "Doing{" +
                ", todayData=" + todayData +
                ", totalData=" + totalData +
                ", isTodayFinished=" + isTodayFinished +
                ", isValid=" + isValid +
                '}';
    }
}
