package securityinmemory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import securityinmemory.model.Canton;

/**
 * Created by Alexis on 05/04/2017.
 */
public interface CantonRepository  extends JpaRepository<Canton,Integer> {

        Canton findByCntId(int id);
}
