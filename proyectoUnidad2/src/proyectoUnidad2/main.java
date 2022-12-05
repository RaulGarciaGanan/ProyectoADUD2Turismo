package proyectoUnidad2;

import java.io.InputStream;
import java.util.*;

import conexionBBDD.*;

public class main {
	static conexionSQL conexion;
	static conexionSQLite conexionSQLite;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in) ;
		int menu;
		do { 
			menu=0;
			System.out.println("A que base de datos desea conectarse: \n"
					+ "1.MySQl\n"
					+ "2.SQLite\n"
					+ "3.DB\n"
					+ "4.salir");
			menu = in.nextInt();
			switch(menu) {
			case 1:
				try {
					conexion = new conexionSQL();
					conexion.BBDD();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					conexionSQLite = new conexionSQLite();
					conexionSQLite.BBDD();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				break;
			case 4:
				System.out.println("Gracias por usar nuestro programa");
				break;
			}
		}while(menu !=4);
		
		

	}

	
}
