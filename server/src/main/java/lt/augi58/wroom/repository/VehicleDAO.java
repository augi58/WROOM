package lt.augi58.wroom.repository;

import lt.augi58.wroom.model.VehicleJPA;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VehicleDAO extends AbstractHibernateJpaDAO<Long, VehicleJPA> {

    public List<VehicleJPA> getAllByUserId(Long ownerId) {
        TypedQuery<VehicleJPA> query
                = getEntityManager().createQuery(
                "select a "
                        + " from " + entityClass.getName() + " a "
                        + " where a.owner.id = :ownerId",
                VehicleJPA.class);
        query.setParameter("ownerId", ownerId);
        return query.getResultList();
    }

}
