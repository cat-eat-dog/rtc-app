package net.github.rtc.app.dao.news;

import net.github.rtc.app.dao.generic.AbstractGenericDaoImpl;
import net.github.rtc.app.model.entity.news.News;
import net.github.rtc.app.model.entity.news.NewsStatus;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewsDaoImpl extends AbstractGenericDaoImpl<News> implements NewsDao {

    @Override
    public List<News> findPublished() {
        return getCurrentSession().createCriteria(News.class).add(Restrictions.eq("status", NewsStatus.PUBLISHED)).addOrder(Order.asc("publishDate")).list();
    }
}