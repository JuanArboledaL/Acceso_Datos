package dam.acdat.hibernate.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idUsuario")
    private long id;

    @Column(name = "Nombre", length = 48)
    private String name;

    @Temporal(TemporalType.DATE) //Para que solo salga la fecha
    @Column (name = "FechaCumpleanyos")
    private Date birthdate;

    public User() {}

    public User(String name, Date birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
