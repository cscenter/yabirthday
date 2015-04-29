import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserService {
    Page<User> findUsers(UserSearchCriteria criteria, Pageable pageable);
    User getUser(String name);
}