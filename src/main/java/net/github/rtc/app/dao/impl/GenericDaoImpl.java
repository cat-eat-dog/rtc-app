package net.github.rtc.app.dao.impl;

import net.github.rtc.app.dao.GenericDao;
import net.github.rtc.app.utils.datatable.SearchCriteria;
import net.github.rtc.app.utils.datatable.SearchResults;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Ivan Yatcuba on 8/12/14.
 */
@Component
public abstract class GenericDaoImpl<T> implements GenericDao<T> {

    @Autowired
    SessionFactory sessionFactory;

    private Class<T> type;

    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    protected Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public T create(T t){
        getCurrentSession().save(t);
        return t;
    }

    @Override
    public void delete(long id){
        getCurrentSession().delete(find(id));
    }

    @Override
    public void deleteByCode(String code){
        getCurrentSession().delete(findByCode(code));
    }

    @Override
    public T find(long id){
        return (T)getCurrentSession().get(type, id);
    }

    @Override
    public T findByCode(String code){
        return (T)getCurrentSession().createCriteria(type).add(Restrictions.eq("code", code)).uniqueResult();
    }

    @Override
    public T update(T t){
        getCurrentSession().merge(t);
        return t;
    }

    @Override
    public List<T> findAll(){
        return getCurrentSession().createCriteria(type).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }


    @Override
    public SearchResults<T> search(SearchCriteria searchCriteria) {
        SearchResults<T> searchResults = new SearchResults<>();
        Criteria criteria = searchCriteria.getCriteria().getExecutableCriteria(getCurrentSession());
        searchResults.setTotalResults(((Long) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue());
        criteria.setProjection(null).setResultTransformer(Criteria.ROOT_ENTITY);
        if(searchCriteria.getSortOrder() == SearchCriteria.SortOrder.ASC){
            criteria.addOrder(Order.asc(searchCriteria.getSortField()));
        }else {
            criteria.addOrder(Order.desc(searchCriteria.getSortField()));
        }
        if(searchCriteria.getPageSize() > 0){
            criteria.setFirstResult((searchCriteria.getCurrentPage()-1) * searchCriteria.getPageSize());
            criteria.setMaxResults((searchCriteria.getCurrentPage()-1) * searchCriteria.getPageSize() + searchCriteria.getPageSize());
            searchResults.setResults(criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list());
        }else {
            searchResults.setResults(criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list());
        }
        return searchResults;
    }
}
