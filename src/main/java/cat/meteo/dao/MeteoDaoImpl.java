package cat.meteo.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cat.meteo.domain.DadesMeteo;

@SuppressWarnings("deprecation")
@Repository
public class MeteoDaoImpl extends AbstractDao implements MeteoDao {
	
	@SuppressWarnings({ "unchecked" })
	public List<DadesMeteo> cercaPerRang(Date dataInici, Date dataFi) {
		
		Criteria criteria = getSession().createCriteria(DadesMeteo.class);
		if(dataInici!=null){
			criteria.add(Expression.ge("data",dataInici));
		}
		if(dataFi!=null){
			criteria.add(Expression.le("data",dataFi));
		}		
	
		criteria.addOrder(Order.asc("data"));
	 
		return criteria.list();
	}
	
	@SuppressWarnings({ "unchecked" })
	public float cercaMaximaPerRang(Date dataInici, Date dataFi) {
		
		float temp = 0;
		Criteria criteria = getSession().createCriteria(DadesMeteo.class);
		if(dataInici!=null){
			criteria.add(Expression.ge("data",dataInici));
		}
		if(dataFi!=null){
			criteria.add(Expression.le("data",dataFi));
		}
		criteria.setProjection(Projections.max("temperatura"));
	
		criteria.addOrder(Order.asc("data"));
		List lst = criteria.list();
		if (lst.size()!=0) {
			temp = (float)lst.get(0);
		}
	 
		return temp;
	}
	
	@SuppressWarnings({ "unchecked" })
	public float cercaMinimaPerRang(Date dataInici, Date dataFi) {
		
		float temp = 0;
		DadesMeteo dadesMeteo = new DadesMeteo();
		Criteria criteria = getSession().createCriteria(DadesMeteo.class);
		if(dataInici!=null){
			criteria.add(Expression.ge("data",dataInici));
		}
		if(dataFi!=null){
			criteria.add(Expression.le("data",dataFi));
		}
		criteria.setProjection(Projections.min("temperatura"));
	
		criteria.addOrder(Order.asc("data"));
		List lst = criteria.list();
		if (lst.size()!=0) {
			temp = (float)lst.get(0);
		}
	 
		return temp;
	}
	
	@SuppressWarnings("unchecked")
	public List<DadesMeteo> cerca(Date dataInici, Date dataFi, String lloc) {
		
		Criteria criteria = getSession().createCriteria(DadesMeteo.class);
		if(dataInici!=null){
			criteria.add(Expression.ge("data",dataInici));
		}
		if(dataFi!=null){
			criteria.add(Expression.le("data",dataFi));
		}
		
		if(lloc!= null){
			criteria.add(Restrictions.eq("zona",lloc));
		}
	
		criteria.addOrder(Order.asc("data"));
	 
		return criteria.list();
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<DadesMeteo> cercaPerLloc(String lloc) {
		 Criteria criteria = getSession().createCriteria(DadesMeteo.class);
	     criteria.add(Restrictions.eq("zona",lloc));
	     return (List<DadesMeteo>)criteria.list();
	}	
	
	
	public void gravaRegistre(DadesMeteo dadesMeteo) {
		
		persist(dadesMeteo);
		
	}
	
	public void eliminaRegistre(DadesMeteo dadesMeteo) {
		
		delete(dadesMeteo);
		
	}
	
	

}
