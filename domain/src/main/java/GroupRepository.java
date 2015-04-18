import org.springframework.data.repository.CrudRepository;

/**
 * Created by MAX on 07.04.2015.
 */
public interface GroupRepository extends CrudRepository<Group, Long> {
    <S extends Group> S save(S entity);
}
