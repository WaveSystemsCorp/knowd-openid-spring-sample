package com.wave.openid.springsample;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

/**
 * HibernateDaoBase - simple DAO base class providing generic CRUD
 * functionality for specified serializable entity T
 */
@Configuration
public abstract class HibernateDaoBase <T extends Serializable>
{

    private Class< T > clazz;

    protected EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Transactional
    public void setClazz( final Class< T > clazzToSet )
    {
        this.clazz = clazzToSet;
    }

    @Transactional
    public T getById( final Long id )
    {
        return this.entityManager.find( this.clazz, id );
    }

    @Transactional
    public List< T > getListByField(String field, Object value)
    {
        Query q =  this.entityManager.createQuery(
                "from " + this.clazz.getName() + " where " + field + " = ?1 "
        );
        q.setParameter(new Integer(1), value);
        return q.getResultList();
    }

    @Transactional
    public List< T > getAll()
    {
        return this.entityManager.createQuery(
                "from " + this.clazz.getName()
        ).getResultList();
    }

    @Transactional
    public void create( final T entity )
    {
        this.entityManager.persist(entity);
    }

    @Transactional
    public void update( final T entity )
    {
        this.entityManager.merge( entity );
    }

    @Transactional
    public void delete( final T entity )
    {
        this.entityManager.remove( entity );
    }

    @Transactional
    public void deleteById( final Long entityId )
    {
        final T entity = this.getById( entityId );
        this.delete( entity );
    }
}

