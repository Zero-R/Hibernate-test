package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dell on 2015/11/11 0011.
 */
@Entity
@Table(name = "users")
public class Users implements Serializable{
    @Id
    @Column(name = "user_id")
    @GenericGenerator(name = "generator_hilo", strategy = "hilo")
    @GeneratedValue(generator = "generator_hilo")
    private Integer id;

    @Column(unique = true)
    private long tel;
    private String name;
    private String password;
    private int points;
    private double wealth;

    @Column(unique = true)
    private long IMEI;

    @OneToMany(targetEntity = Doing.class)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Set<Doing> doingActivities = new HashSet<> ();

    @OneToMany(targetEntity = Users.class)
    @JoinTable(name = "friends",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "user_id")
    )
    private Set<Users> friends = new HashSet<>();

    @OneToMany(targetEntity = Users.class)
    @JoinTable(name = "pre_friends",
            joinColumns = @JoinColumn(name = "requested_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "request_id", referencedColumnName = "user_id")
    )
    private Set<Users> preFriends = new HashSet<>();

    public Integer getId() {
        return id;

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public double getWealth() {
        return wealth;
    }

    public void setWealth(double wealth) {
        this.wealth = wealth;
    }

    public long getIMEI() {
        return IMEI;
    }

    public void setIMEI(long IMEI) {
        this.IMEI = IMEI;
    }

    public Set<Doing> getDoingActivities() {
        return doingActivities;
    }

    public void setDoingActivities(Set<Doing> doingActivities) {
        this.doingActivities = doingActivities;
    }

    public Set<Users> getFriends() {
        return friends;
    }

    public void setFriends(Set<Users> friends) {
        this.friends = friends;
    }

    public Set<Users> getPreFriends() {
        return preFriends;
    }

    public void setPreFriends(Set<Users> preFriends) {
        this.preFriends = preFriends;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id='" + id + '\'' +
                ", tel=" + tel +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", points=" + points +
                ", wealth=" + wealth +
                ", IMEI=" + IMEI +
                '}';
    }
}
