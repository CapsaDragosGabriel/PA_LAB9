package entities;


import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "countries", schema = "public", catalog = "cities")
@NoArgsConstructor
@NamedQueries(
        {
                @NamedQuery(name = "Country.findAll", query = "select e from Country e order by  e.name"),
                @NamedQuery(name = "Country.findByContinent",
                        query = "select e from Country e where e.continent = ?1"),
                @NamedQuery(name = "Country.findById",
                        query = "select e from Country e where e.id=?1"),
                @NamedQuery(name = "Country.findByName",
                        query = "select e from Country e where e.name=?1"),
        }

)
public class Country implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "code")
    private Integer code;
    @Basic
    @Column(name = "continent")
    private String continent;
    @OneToMany
    @JoinColumn(updatable = false, insertable = false, name = "country", referencedColumnName = "name")
    private Set<City> citySet;
    @ManyToOne
    @JoinColumn(updatable = false, insertable = false, name = "continent", referencedColumnName = "name")
    private Continent continentOBJ;

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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country that = (Country) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(code, that.code) && Objects.equals(continent, that.continent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, continent);
    }
}
