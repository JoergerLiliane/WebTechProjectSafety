import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BenutzerNameRepo {

    public interface BenutzerNameRepository extends CrudRepository<BenutzerName, Long> {

    }

}
