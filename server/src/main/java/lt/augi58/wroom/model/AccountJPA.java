package lt.augi58.wroom.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "accounts")
public class AccountJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<UserJPA> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserJPA> getUsers() {
        return users;
    }

    public void setUsers(Set<UserJPA> users) {
        this.users = users;
    }
}
