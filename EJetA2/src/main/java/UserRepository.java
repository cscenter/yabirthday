
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;


interface UserRepository extends Repository<User, Long> {
    Page<User> findAll(Pageable pageable);
    User findByName(String name);
}