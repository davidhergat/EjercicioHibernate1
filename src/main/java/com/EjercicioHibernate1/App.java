package com.EjercicioHibernate1;


import java.util.List;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.EjercicioHibernate1.dao.DepartamentoDAO;
import com.EjercicioHibernate1.dao.EmpleadoDAO;
import com.EjercicioHibernate1.entities.xmlmapping.Departamento;
import com.EjercicioHibernate1.entities.xmlmapping.Empleado;
import com.EjercicioHibernate1.utils.HibernateUtil;


public class App 
{
	
	private static Logger logger = LogManager.getLogger(App.class);
	static Scanner teclado = new Scanner(System.in);
	static SessionFactory sessionFactory;
	
    public static void main( String[] args )
    {
        int opcionMenuInicio, opcionMenuCRUD, codigo;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Departamento dep;
		Empleado emp;

        do {
        	
        	opcionMenuInicio = mostrarMenuInicio();
        	
    		switch(opcionMenuInicio) {
    		
    			//Operaciones con Departamento
				case 1:
										
					opcionMenuCRUD = mostrarMenuCRUD();
					
					switch(opcionMenuCRUD) {
					
						case 1:
							dep = crearDepartamento();
							DepartamentoDAO.insertarDepartamento(session, dep);
							break;
							
						case 2:
							System.out.println("Introduce codigo del departamento:");
							codigo = teclado.nextInt();
							dep = DepartamentoDAO.getDepartamento(session, codigo);
							break;
							
						case 3:
							List<Departamento> listaDepartamento = DepartamentoDAO.getDepartamentos(session);
							for(int i=0; i<listaDepartamento.size(); i++) {
								System.out.println(listaDepartamento.get(i).toString());
								System.out.println("----------------");
							}
							break;
							
						case 4:
							dep = crearDepartamento();
							DepartamentoDAO.actualizarDepartamento(session, dep);
							break;							
							
						case 5:
							System.out.println("Introduce codigo del departamento:");
							codigo = teclado.nextInt();
							DepartamentoDAO.borrarDepartamento(session, codigo);
							break;
					}
				break;
				
				//Operaciones con Empleados
				case 2:
					
					opcionMenuCRUD = mostrarMenuCRUD();
					
					switch(opcionMenuCRUD) {
					
					case 1:
						emp = crearEmpleado();
						EmpleadoDAO.insertarEmpleado(session, emp);
						break;
						
					case 2:
						System.out.println("Introduce codigo del empleado:");
						codigo = teclado.nextInt();
						emp = EmpleadoDAO.getEmpleado(session, codigo);
						break;
						
					case 3:
						List<Empleado> listaEmpleados = EmpleadoDAO.getEmpleados(session);
						for(int i=0; i<listaEmpleados.size(); i++) {
							System.out.println(listaEmpleados.get(i).toString());
							System.out.println("----------------");
						}
						break;
						
					case 4:
						emp = crearEmpleado();
						EmpleadoDAO.actualizarEmpleado(session, emp);
						break;
						
					case 5:
						System.out.println("Introduce codigo del empleado:");
						codigo = teclado.nextInt();
						EmpleadoDAO.borrarEmpleado(session, codigo);
						break;
					}
				break;
					
    		}
        	
        }while(opcionMenuInicio!=3);
    }
    
    public static int mostrarMenuInicio() {
    	
    	System.out.println("");
    	System.out.println("1 - Departamento");
    	System.out.println("2 - Empleado");
    	System.out.println("3 - Salir");
    	return teclado.nextInt();
    	
    }
    
    public static int mostrarMenuCRUD() {
    	
    	System.out.println("");
    	System.out.println("1 - Insertar");
    	System.out.println("2 - Mostrar");
    	System.out.println("3 - Mostrar lista");
    	System.out.println("4 - Actualizar");
    	System.out.println("5 - Borrar");
    	System.out.println("6 - Volver");
    	return teclado.nextInt();
    	
    }
    
    public static Departamento crearDepartamento() {
    	
    	Departamento dep = new Departamento();
    	
    	System.out.println("Introduce codigo del departamento:");
    	dep.setCodigo(teclado.nextInt());
    	System.out.println("Introduce nombre del departamento:");
    	dep.setNombre(teclado.next());
    	System.out.println("Introduce codigo de responsable:");
    	dep.setCodigoResponsable(teclado.nextInt());
    	
    	return dep;
    	
    }
    
    public static Empleado crearEmpleado() {
    	
    	Empleado emp = new Empleado();
    	
    	System.out.println("Introduce codigo del empleado:");
    	emp.setCodigo(teclado.nextInt());
    	System.out.println("Introduce nombre del empleado:");
    	emp.setNombre(teclado.next());
    	System.out.println("Introduce primer apellido del empleado:");
    	emp.setApellido1(teclado.next());
    	System.out.println("Introduce segundo apellido del empleado:");
    	emp.setApellido2(teclado.next());
    	System.out.println("Introduce lugar de nacimiento del empleado:");
    	emp.setLugarNacimiento(teclado.next());
    	System.out.println("Introduce fecha de nacimiento del empleado:");
    	emp.setFechaNacimiento(teclado.next());
    	System.out.println("Introduce direccion del empleado:");
    	emp.setDireccion(teclado.next());
    	System.out.println("Introduce telefono del empleado:");
    	emp.setTelefono(teclado.next());
    	System.out.println("Introduce puesto del empleado:");
    	emp.setPuesto(teclado.next());
    	System.out.println("Introduce codigo del departamento:");
    	emp.setCodigoDepartamento(teclado.nextInt());
    	
    	return emp;
    	
    }
    
}
