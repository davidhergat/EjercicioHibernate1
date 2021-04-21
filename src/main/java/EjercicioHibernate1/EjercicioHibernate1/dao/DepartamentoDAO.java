package EjercicioHibernate1.EjercicioHibernate1.dao;

import java.util.List;

import org.hibernate.Session;

import EjercicioHibernate1.EjercicioHibernate1.utils.*;

import EjercicioHibernate1.EjercicioHibernate1.entities.xmlmapping.Departamento;

public class DepartamentoDAO {

	public static void insertarDepartamento(Session s, Departamento dep) {
		s.save(dep);
	}
	
	public static List<Departamento> getDepartamentos(){
		return getDepartamentos(HibernateUtil.retrieveSession());
	}
	
	public static List<Departamento> getDepartamentos(Session s){
		String hQuery = "from departamento";
		List<Departamento> listaDepartamento = s.createQuery(hQuery, Departamento.class).list();
		return listaDepartamento;
	}
	
	public static Departamento getDepartamento(Session s, int codigo) {
		  String hQuery = " from departamento d " + " where d.codigo = :codigoDepartamento";
		  Departamento departamento = s.createQuery(hQuery, Departamento.class).setParameter("codigo", codigo).setMaxResults(1).uniqueResult();
		  return departamento;
	}
	
	public static void borrarDepartamento(Session s, int codigoDepartamento) {
		Departamento dep = getDepartamento(s, codigoDepartamento);
		s.delete(dep);
	}
	
	public static void actualizarDepartamento(Session s, Departamento dep) {
		s.update(dep);
	}
	
	
}
