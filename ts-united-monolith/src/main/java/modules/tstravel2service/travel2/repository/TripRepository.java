package modules.tstravel2service.travel2.repository;
import java.util.ArrayList;
import modules.tscommon.edu.fudan.common.entity.TripId;
import modules.tstravel2service.travel2.entity.TripFromtstravel2service;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author fdse
 */
@Repository("tripRepositoryFromtstravel2service")
public interface TripRepository extends CrudRepository<TripFromtstravel2service, TripId> {
    TripFromtstravel2service findByTripId(TripId tripId);

    void deleteByTripId(TripId tripId);

    @Override
    ArrayList<TripFromtstravel2service> findAll();

    ArrayList<TripFromtstravel2service> findByRouteId(String routeId);
}