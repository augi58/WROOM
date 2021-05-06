package lt.augi58.wroom.repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

public abstract class AbstractHibernateJpaDAO<K, E> {

    @PersistenceContext
    protected EntityManager entityManager;

    protected Class<E> entityClass;

    @SuppressWarnings("unchecked")
    public AbstractHibernateJpaDAO() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
    }

    public void persist(E entity) {
        getEntityManager().persist(entity);
    }

    public void remove(E entity) {
        getEntityManager().remove(entity);
    }

    public void refresh(E entity) {
        getEntityManager().refresh(entity);
    }

    public E merge(E entity) {
        return getEntityManager().merge(entity);
    }

    public E flush(E entity) {
        getEntityManager().flush();
        return entity;
    }

    public void flush() {
        getEntityManager().flush();
    }

    public List<E> findAll() {
        String queryStr = "SELECT h FROM " + entityClass.getName() + " h order by 1 desc";
        Query query = getEntityManager().createQuery(queryStr);
        List<E> resultList = query.getResultList();
        return resultList;
    }

    public Integer removeAll() {
        String queryStr = "DELETE FROM " + entityClass.getName() + " h";
        Query query = getEntityManager().createQuery(queryStr);
        return query.executeUpdate();
    }

    public Integer deleteById(Long id) {
        String queryStr = "DELETE FROM " + entityClass.getName() + " h WHERE h.id = " + id;
        Query query = getEntityManager().createQuery(queryStr);
        return query.executeUpdate();
    }

    public E create(E entity) {
        entityManager.persist(entity);
        return entity;
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }


    public E getById(K id) {
        return getEntityManager().find(entityClass, id);
    }

    public Optional<E> findById(K id) {
        String queryStr = "SELECT h FROM " + entityClass.getName() + " h where h.id = " +id;
        Query query = getEntityManager().createQuery(queryStr);
        return query.getResultList().stream().findFirst();
    }
}
