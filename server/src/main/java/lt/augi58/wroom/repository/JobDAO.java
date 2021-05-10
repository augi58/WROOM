package lt.augi58.wroom.repository;

import lt.augi58.wroom.model.JobJPA;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.Optional;

@Repository
public class JobDAO extends AbstractHibernateJpaDAO<Long, JobJPA> {

    public Optional<JobJPA> getByName(String jobName) {
        TypedQuery<JobJPA> query
                = getEntityManager().createQuery(
                "select a "
                        + " from " + entityClass.getName() + " a "
                        + " where a.name like :jobName",
                JobJPA.class);
        query.setParameter("jobName", jobName);
        return query.getResultList().stream().findFirst();
    }

}
