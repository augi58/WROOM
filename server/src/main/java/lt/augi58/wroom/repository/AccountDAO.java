package lt.augi58.wroom.repository;

import lt.augi58.wroom.model.AccountJPA;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO extends AbstractHibernateJpaDAO<Long, AccountJPA> {

}
