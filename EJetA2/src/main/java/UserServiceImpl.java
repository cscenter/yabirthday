import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;


@Component("UserService")
@Transactional
@Repository
class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Page<User> findUsers(UserSearchCriteria criteria, Pageable pageable) {
        Assert.notNull(criteria, "Criteria must not be null");
        String name = criteria.getName();

        if (!StringUtils.hasLength(name)) {
            return this.userRepository.findAll(null);
        }
        int splitPos = name.lastIndexOf(",");
        if (splitPos >= 0) {
            name = name.substring(0, splitPos);
        }
        return this.userRepository.findAll(null);
    }

    @Override
    public User getUser(String name) {
        Assert.notNull(name, "Name must not be null");

       return this.userRepository.findByName(name);
    }


}