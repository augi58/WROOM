package lt.augi58.wroom.repository;

import lt.augi58.wroom.model.JobJPA;
import org.springframework.stereotype.Repository;

@Repository
public class JobDAO extends AbstractHibernateJpaDAO<Long, JobJPA> {

}
