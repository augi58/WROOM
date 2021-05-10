package lt.augi58.wroom.repository;

import lt.augi58.wroom.enums.Role;
import lt.augi58.wroom.model.UserJPA;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAO extends AbstractHibernateJpaDAO<Long, UserJPA> {

    public List<UserJPA> getAllClients(Long accountId) {
        TypedQuery<UserJPA> query
                = getEntityManager().createQuery(
                "select a "
                        + " from " + entityClass.getName() + " a "
                        + " where a.role like :role"
                        + " and a.account.id like :accountId",
                UserJPA.class);
        query.setParameter("role", Role.CLIENT);
        query.setParameter("accountId", accountId);
        return query.getResultList();
    }

    public List<UserJPA> getAllTechnicians(Long accountId) {
        TypedQuery<UserJPA> query
                = getEntityManager().createQuery(
                "select a "
                        + " from " + entityClass.getName() + " a "
                        + " where a.role like :role"
                + " and a.account.id like :accountId",
                UserJPA.class);
        query.setParameter("role", Role.TECHNICIAN);
        query.setParameter("accountId", accountId);
        return query.getResultList();
    }
}
