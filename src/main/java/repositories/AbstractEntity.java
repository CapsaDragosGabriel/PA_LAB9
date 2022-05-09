package repositories;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(
        {
                @NamedQuery(name = "City.findById",
                        query = "select e from City e where e.id=?1"),
                ,
        }
)
public abstract class AbstractEntity {
}
