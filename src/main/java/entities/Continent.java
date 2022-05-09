package entities;


import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "continents", schema = "public", catalog = "cities")
@NoArgsConstructor
@NamedQueries(
        {
                @NamedQuery(name = "Continent.findAll", query = "select e from Continent e order by  e.name"),
                @NamedQuery(name = "Continent.findById",
                        query = "select e from Continent e where e.id=?1"),
                @NamedQuery(name = "Continent.findByName",
                        query = "select e from Continent e where e.name=?1"),


        }
)
public class Continent implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany
    @JoinColumn(updatable = true, insertable = false, name = "continent", referencedColumnName = "name")
    private Set<Country> countrySet;

    public Continent(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Continent that = (Continent) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
