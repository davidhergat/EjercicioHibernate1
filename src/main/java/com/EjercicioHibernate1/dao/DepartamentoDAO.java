package com.EjercicioHibernate1.dao;



import java.util.List;

import org.hibernate.Session;

import com.EjercicioHibernate1.entities.xmlmapping.Departamento;
import com.EjercicioHibernate1.utils.HibernateUtil;



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
		  String hQuery = " from departamento d " + " where d.codigo = :codigo";
		  Departamento departamento = s.createQuery(hQuery, Departamento.class).setParameter("codigo", codigo).setMaxResults(1).uniqueResult();
		  return departamento;
	}
	
	public static void borrarDepartamento(Session s, int codigo) {
		Departamento dep = getDepartamento(s, codigo);
		s.delete(dep);
	}
	
	public static void actualizarDepartamento(Session s, Departamento dep) {
		s.update(dep);
	}
	
	
}
