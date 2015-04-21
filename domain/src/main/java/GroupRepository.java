import org.springframework.data.repository.CrudRepository;

/**
 * Created by MAX on 07.04.2015.
 */
public interface GroupRepository extends CrudRepository<Group, String> {
    <S extends Group> S save(S entity);
    Group findOne(String s);
    <S extends Group> Iterable<S> save(Iterable<S> iterable);
}
