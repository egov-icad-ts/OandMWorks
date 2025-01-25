package in.OAndM.repositories;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.OAndM.core.BaseRepository;

import in.OAndM.Entities.RTIApplication;
import in.OAndM.Entities.RtiProformaG;


@Repository
public interface RtiApplicationRepository extends BaseRepository<RTIApplication, Integer> {
	
//	@Query("SELECT r FROM RTIApplication r WHERE r.deleteFlag = false")
//    List<RTIApplication> findAllActive();
//
//    @Query("SELECT r FROM RTIApplication r WHERE r.id = :id AND r.deleteFlag = false")
//    Optional<RTIApplication> findActiveById(@Param("id") Integer id);
	
	// No additional methods needed as findAllByDeleteFlagFalse and findByIdAndDeleteFlagFalse are inherited.

	 @Query("SELECT r FROM RTIApplication r WHERE r.deleteFlag = false")
	    List<RTIApplication> findAllByDeleteFlagFalse();

	    @Query("SELECT r FROM RTIApplication r WHERE r.id = :id AND r.deleteFlag = false")
	    Optional<RTIApplication> findByIdAndDeleteFlagFalse(@Param("id") Integer id);
	    
	    
	    
}
