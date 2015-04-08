/**
 * Created by Rafa on 02.04.2015.
 */
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends  CrudRepository<User, Long> {
    List<User> findByName(String name);
}
