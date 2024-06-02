package model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private AccountModel account;

    // Constructors
    public UserModel() {
    }

    public UserModel(Integer id, String name, AccountModel account) {
        this.id = id;
        this.name = name;
        this.account = account;
    }

    // Getters and Setters
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

    public AccountModel getAccount() {
        return account;
    }

    public void setAccount(AccountModel account) {
        this.account = account;
    }
}
