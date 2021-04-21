package EjercicioHibernate1.EjercicioHibernate1.dao;

import java.util.List;

import org.hibernate.Session;

import EjercicioHibernate1.EjercicioHibernate1.entities.xmlmapping.Empleado;
import EjercicioHibernate1.EjercicioHibernate1.utils.HibernateUtil;

public class EmpleadoDAO {
	
	public static void insertarDepartamento(Session s, Empleado emp) {
		s.save(emp);
	}
	
	public static List<Empleado> getEmpleados(){
		return getEmpleados(HibernateUtil.retrieveSession());
	}
	
	public static List<Empleado> getEmpleados(Session s){
		String hQuery = "from empleado";
		List<Empleado> listaEmpleado = s.createQuery(hQuery, Empleado.class).list();
		return listaEmpleado;
	}
	
	public static Empleado getEmpleado(Session s, int codigo) {
		  String hQuery = " from empleado e " + " where e.codigo = :codigo";
		  Empleado empleado = s.createQuery(hQuery, Empleado.class).setParameter("codigo", codigo).setMaxResults(1).uniqueResult();
		  return empleado;
	}
	
	public static void borrarDepartamento(Session s, int codigo) {
		Empleado emp = getEmpleado(s, codigo);
		s.delete(emp);
	}
	
	public static void actualizarDepartamento(Session s, Empleado emp) {
		s.update(emp);
	}
}
