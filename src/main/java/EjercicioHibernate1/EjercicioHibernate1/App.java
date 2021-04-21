package EjercicioHibernate1.EjercicioHibernate1;

import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;


public class App 
{
	
	private static Logger logger = LogManager.getLogger(App.class);
	
	static Scanner teclado = new Scanner(System.in);
	
	static SessionFactory sessionFactory;
	
    public static void main( String[] args )
    {
        int opcion;
        
        do {
        	
        	opcion = mostrarMenuInicio();
        	
        }while(opcion!=3);
    }
    
    public static int mostrarMenuInicio() {
    	
    	System.out.println("");
    	System.out.println("1 - Departamento");
    	System.out.println("2 - Empleado");
    	System.out.println("3 - Salir");
    	return teclado.nextInt();
    	
    }
}
