package entities;


import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "cities", schema = "public", catalog = "cities")
@NoArgsConstructor
@NamedQueries(
        {
                @NamedQuery(name = "City.findAll", query = "select e from City e order by  e.name"),
                @NamedQuery(name = "City.findByCountry",
                        query = "select e from City e where e.country = ?1"),
                @NamedQuery(name = "City.findById",
                        query = "select e from City e where e.id=?1"),
                @NamedQuery(name = "City.findByName",
                        query = "select e from City e where e.name=?1"),
        }
)
public class City implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "country")
    private String country;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "capital")
    private Boolean capital;
    @Basic
    @Column(name = "latitude")
    private Double latitude;
    @Basic
    @Column(name = "longitude")
    private Double longitude;
    @ManyToOne
    @JoinColumn(updatable = true, insertable = false, name = "country", referencedColumnName = "name")
    private Country countryOBJ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCapital() {
        return capital;
    }

    public void setCapital(Boolean capital) {
        this.capital = capital;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id && Objects.equals(country, city.country) && Objects.equals(name, city.name) && Objects.equals(capital, city.capital) && Objects.equals(latitude, city.latitude) && Objects.equals(longitude, city.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, name, capital, latitude, longitude);
    }
}
