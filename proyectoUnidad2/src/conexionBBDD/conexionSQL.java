package conexionBBDD;

import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.*;

import modelo.visitaclienteSQL;
import objetos.*;

public class conexionSQL {
	Connection miConexion = new conexionBBDD().conectorBBDD();

	public void BBDD() throws SQLException {
		Scanner in = new Scanner(System.in);
		int menu;
		do {
			menu = 0;
			System.out.println("Elije una opcion:\n" + "1.Listado de empleados\n" + "2.Listado de clientes\n"
					+ "3.Listado de visitas\n" + "4.CRUD empleado\n" + "5.CRUD clientes\n" + "6.CRUD visitas\n"
					+ "7.Listado de visitas ya programadas\n" + "8.Programar nueva visita\n" + "9.Salir");
			menu = in.nextInt();

			switch (menu) {
			case 1:
				verEmpleados();

				break;
			case 2:
				verClientes();
				break;
			case 3:
				verVisitas();
				break;
			case 4:
				crudEmpleado();
				break;
			case 5:
				crudCliente();
				break;
			case 6:
				crudVisita();
				break;
			case 7:
				verVisitaClientes();
				break;
			case 8:
				apuntarseVisitas();
				break;
			case 9:
				System.out.println("Saliendo del servidor MySQL");
				break;
			}
		} while (menu != 8);
	}

	public void crudEmpleado() throws SQLException {
		Scanner in = new Scanner(System.in);
		int menu;
		do {
			menu = 0;
			System.out.println("Elije una opcion:\n" + "1.Crear Empleado\n" + "2.Modificar Empleado\n"
					+ "3.Eliminar Empleado\n" + "4.Volver Al menu Anterior");
			menu = in.nextInt();
			switch (menu) {
			case 1:
				crearEmpleados();
				break;
			case 2:
				editarEmpleados();
				break;
			case 3:
				borrarEmpleados();
				break;
			case 4:
				break;

			}
		} while (menu != 4);

	}

	public void crudCliente() throws SQLException {
		Scanner in = new Scanner(System.in);
		int menu;
		do {
			menu = 0;
			System.out.println("Elije una opcion:\n" + "1.Crear Cliente\n" + "2.Modificar Cliente\n"
					+ "3.Eliminar Cliente\n" + "4.Volver Al menu Anterior");
			menu = in.nextInt();
			switch (menu) {
			case 1:
				crearClientes();
				break;
			case 2:
				editarClientes();
				;
				break;
			case 3:
				borrarClientes();
				;
				break;
			case 4:
				break;

			}
		} while (menu != 4);
	}

	public void crudVisita() throws SQLException {
		Scanner in = new Scanner(System.in);
		int menu;
		do {
			menu = 0;
			System.out.println("Elije una opcion:\n" + "1.Crear Visita\n" + "2.Modificar Visita\n"
					+ "3.Eliminar Visita\n" + "4.Volver Al menu Anterior");
			menu = in.nextInt();
			switch (menu) {
			case 1:
				crearVisitas();
				break;
			case 2:
				editarVisitas();
				break;
			case 3:
				borrarVisitas();
				break;
			case 4:
				break;

			}
		} while (menu != 4);

	}

	public void verEmpleados() throws SQLException {
		Statement miSentencia = miConexion.createStatement();

		ResultSet miResultSet = miSentencia.executeQuery("SELECT * FROM empleadoproyect");
		while (miResultSet.next()) {
			System.out.println(miResultSet.getInt(1) + " " + miResultSet.getString(2) + " " + miResultSet.getString(3)
					+ " " + miResultSet.getString(4) + " " + miResultSet.getString(5) + " " + miResultSet.getString(6)
					+ " " + miResultSet.getString(7) + " " + miResultSet.getString(8) + "\n");
		}
	}

	public void verVisitas() throws SQLException {
		Statement miSentencia = miConexion.createStatement();

		ResultSet miResultSet = miSentencia.executeQuery("SELECT * FROM visitaguiada");
		while (miResultSet.next()) {
			System.out.println(miResultSet.getInt(1) + " " + miResultSet.getString(2) + " " + miResultSet.getString(3)
					+ " " + miResultSet.getString(4) + " " + miResultSet.getString(5) + " " + miResultSet.getString(6)
					+ " " + miResultSet.getString(7) + " " + miResultSet.getString(8) + "\n");
		}
	}

	public void verClientes() throws SQLException {
		Statement miSentencia = miConexion.createStatement();

		ResultSet miResultSet = miSentencia.executeQuery("SELECT * FROM cliente");
		while (miResultSet.next()) {
			System.out.println(miResultSet.getInt(1) + " " + miResultSet.getString(2) + " " + miResultSet.getString(3)
					+ " " + miResultSet.getString(4) + " " + miResultSet.getString(5) + " " + miResultSet.getString(6)
					+ "\n");
		}
	}

	public void verVisitaClientes() throws SQLException {
		Statement miSentencia = miConexion.createStatement();

		ResultSet miResultSet = miSentencia.executeQuery("SELECT * FROM visitacliente");
		while (miResultSet.next()) {
			System.out.println(miResultSet.getInt(1) + " " + miResultSet.getString(2) + " " + miResultSet.getString(3)
					+ " " + miResultSet.getString(4) + "\n");
		}
	}

	public void crearEmpleados() throws SQLException {
		Scanner in = new Scanner(System.in);
		int opcion = 1;
		String dni, nombre, apellido, fechaNaci, fechaContra, nacionalidad, cargo;
		System.out.println("Introduce el DNI del empleado");
		dni = in.nextLine();
		System.out.println("Introduce el nombre del empleado");
		nombre = in.nextLine();
		System.out.println("Introduce el apellido del empleado");
		apellido = in.nextLine();
		System.out.println("Introduce la fecha de nacimiento del empleado (con este formato: yyyy-mm-dd)");
		fechaNaci = in.nextLine();
		System.out.println("Introduce la fecha de contratacion del empleado  (con este formato: yyyy-mm-dd)");
		fechaContra = in.nextLine();
		System.out.println("Introduce la nacionalidad del empleado");
		nacionalidad = in.nextLine();
		System.out.println("Introduce el cargo del empleado");
		cargo = in.nextLine();

		empleado emp = new empleado(ultimoIDEmple() + 1, dni, nombre, apellido, comprobarFecha(fechaNaci, opcion),
				comprobarFecha(fechaContra, opcion), nacionalidad, cargo);

		Statement miSentencia = miConexion.createStatement();

		String sql = String.format(
				"INSERT INTO empleadoproyect (idEmpleado, dni, nombre, apellido, fechaNacimiento, fechaContratacion, nacionalidad, cargo) VALUES("
						+ emp.getId() + ",'" + emp.getDni() + "','" + emp.getNombre() + "','" + emp.getApellido()
						+ "','" + emp.getFechaNaci() + "','" + emp.getFechaContrato() + "','" + emp.getNacionalidad()
						+ "','" + emp.getCargo() + "')");

		miSentencia.execute(sql);

		verEmpleados();
	}

	public void crearClientes() throws SQLException {
		Scanner in = new Scanner(System.in);
		int edad;
		String dni, nombre, apellido, profesion;
		System.out.println("Introduce el DNI del cliente");
		dni = in.nextLine();
		System.out.println("Introduce el nombre del cliente");
		nombre = in.nextLine();
		System.out.println("Introduce el apellido del cliente");
		apellido = in.nextLine();
		System.out.println("Introduce la edad del cliente");
		edad = in.nextInt();
		System.out.println("Introduce la profesion del cliente");
		profesion = in.nextLine();

		cliente cli = new cliente(ultimoIDCliente() + 1, dni, nombre, apellido, edad, profesion);

		Statement miSentencia = miConexion.createStatement();
		String sql = String.format("INSERT INTO cliente (idcliente,dni,nombre,apellidos,edad,profesion) values("
				+ cli.getId() + ",'" + cli.getDni() + "', '" + cli.getNombre() + "','" + cli.getApellidos() + "',"
				+ cli.getEdad() + ",'" + cli.getProfesion() + "')");

		miSentencia.execute(sql);

		verClientes();
	}

	public void crearVisitas() throws SQLException {
		Scanner in = new Scanner(System.in);
		boolean opcion = true;
		int maxVisitantes, idEmpleado;
		double coste;
		String nombre, puntoPartida, cursoAcademico, tematica;
		System.out.println("Introduce el nombre de la visita");
		nombre = in.nextLine();
		System.out.println("Introduce el punto de partida de la visita");
		puntoPartida = in.nextLine();
		System.out.println("Introduce el curso academico");
		cursoAcademico = in.nextLine();
		System.out.println("Introduce la tematica de la visita");
		tematica = in.nextLine();
		System.out.println("Introduce el coste de la visita");
		coste = in.nextDouble();
		System.out.println("Introduce el numero de clientes maximos");
		maxVisitantes = in.nextInt();
		verEmpleados();
		System.out.println("Elije el empleado que va a ser empleado que va a ser encargado de la visita");
		idEmpleado = in.nextInt();

		visitaGuiada visit = new visitaGuiada(ultimoIDVisita() + 1, nombre, maxVisitantes, puntoPartida, cursoAcademico,
				tematica, coste, idEmpleado);

		Statement miSentencia = miConexion.createStatement();

		String sql = String.format(
				"INSERT INTO visitaguiada (nVisita,nombre,maxVisitantes,puntoPartida,cursoAcademico,tematica,coste,idEmpleado) VALUES("
						+ visit.getnVisita() + ",'" + visit.getNombre() + "'," + visit.getMaxVisitantes() + ",'"
						+ visit.getPuntoPartida() + "','" + visit.getCursoAcademico() + "','" + visit.getTematica()
						+ "'," + visit.getCoste() + "," + visit.getIdEmple() + ")");

		miSentencia.execute(sql);

		verVisitas();
	}

	public void editarEmpleados() throws SQLException {
		Scanner in = new Scanner(System.in);
		int opcion = 2;
		int menu = 0;
		String dni, nombre, apellido, fechaNaci, fechaContra, nacionalidad, cargo;
		verEmpleados();
		System.out.println("Elije el empleado que desea modificar");
		menu = in.nextInt();

		System.out.println("Modifica el DNI del empleado");
		dni = in.nextLine();
		in.nextLine();
		System.out.println("Modifica el nombre del empleado");
		nombre = in.nextLine();
		System.out.println("Modifica el apellido del empleado");
		apellido = in.nextLine();
		System.out.println("Modifica la fecha de nacimiento del empleado (con este formato: yyyy-mm-dd)");
		fechaNaci = in.nextLine();
		System.out.println("Modifica la fecha de contratacion del empleado  (con este formato: yyyy-mm-dd)");
		fechaContra = in.nextLine();
		System.out.println("Modifica la nacionalidad del empleado");
		nacionalidad = in.nextLine();
		System.out.println("Modifica el cargo del empleado");
		cargo = in.nextLine();

		empleado emp = new empleado(menu, dni, nombre, apellido, comprobarFecha(fechaNaci, opcion),
				comprobarFecha(fechaContra, opcion), nacionalidad, cargo);

		Statement miSentencia = miConexion.createStatement();

		String sql = String.format("UPDATE empleadoproyect SET idEmpleado = " + emp.getId() + ", dni = '" + emp.getDni()
				+ "', nombre = '" + emp.getNombre() + "', apellido = '" + emp.getApellido() + "', "
				+ "fechaNacimiento = '" + emp.getFechaNaci() + "',fechaContratacion = '" + emp.getFechaContrato()
				+ "', nacionalidad = '" + emp.getNacionalidad() + "', cargo = '" + emp.getCargo()
				+ "' WHERE idEmpleado = " + emp.getId());

		miSentencia.executeUpdate(sql);

		verEmpleados();

	}

	public void editarClientes() throws SQLException {
		Scanner in = new Scanner(System.in);
		boolean opcion = false;
		int edad, menu = 0;
		String dni, nombre, apellido, profesion;
		verClientes();
		System.out.println("Elije el cliente que desea modificar");
		menu = in.nextInt();

		System.out.println("Modifica el DNI del cliente");
		dni = in.nextLine();
		in.nextLine();
		System.out.println("Modifica el nombre del cliente");
		nombre = in.nextLine();
		System.out.println("Modifica el apellido del cliente");
		apellido = in.nextLine();
		System.out.println("Modifica la edad del cliente");
		edad = in.nextInt();
		System.out.println("Modifica la profesion del cliente");
		profesion = in.nextLine();

		cliente client = new cliente(menu, dni, nombre, apellido, edad, profesion);

		Statement miSentencia = miConexion.createStatement();

		String sql = String.format("UPDATE cliente SET idcliente = " + client.getId() + ", dni = '" + client.getDni()
				+ "', nombre = '" + client.getNombre() + "', apellidos = '" + client.getApellidos() + "', " + "edad = '"
				+ client.getEdad() + "',profesion = '" + client.getProfesion() + "' WHERE idEmpleado = "
				+ client.getId());

		miSentencia.executeUpdate(sql);

		verClientes();
	}

	public void editarVisitas() throws SQLException {
		Scanner in = new Scanner(System.in);
		boolean opcion = true;
		int maxVisitantes, idEmpleado, menu = 0;
		double coste;
		String nombre, puntoPartida, cursoAcademico, tematica;
		verVisitas();
		System.out.println("Elije la visita que desea modificar");
		menu = in.nextInt();

		in.nextLine();
		System.out.println("Modifica el nombre de la visita");
		nombre = in.nextLine();

		System.out.println("Modifica el punto de partida de la visita");
		puntoPartida = in.nextLine();
		System.out.println("Modifica el curso academico");
		cursoAcademico = in.nextLine();
		System.out.println("Modifica la tematica de la visita");
		tematica = in.nextLine();
		System.out.println("Modifica el coste de la visita");
		coste = in.nextDouble();
		System.out.println("Modifica el numero de clientes maximos");
		maxVisitantes = in.nextInt();
		verEmpleados();
		System.out.println("Modifica el empleado que va a ser empleado que va a ser encargado de la visita");
		idEmpleado = in.nextInt();

		visitaGuiada visit = new visitaGuiada(menu, nombre, maxVisitantes, puntoPartida, cursoAcademico, tematica,
				coste, idEmpleado);

		Statement miSentencia = miConexion.createStatement();

		String sql = String.format("UPDATE visitaguiada SET nVisita = " + visit.getnVisita() + ", nombre = '"
				+ visit.getNombre() + "', maxVisitantes = " + visit.getMaxVisitantes() + ", puntoPartida = '"
				+ visit.getPuntoPartida() + "', cursoAcademico = '" + visit.getCursoAcademico() + "', tematica = '"
				+ visit.getTematica() + "'");

		miSentencia.execute(sql);

		verVisitas();
	}

	public void borrarEmpleados() throws SQLException {
		Scanner in = new Scanner(System.in);
		int menu = 0;
		verEmpleados();
		System.out.println("Elieje el empleado que deseas borrar");
		menu = in.nextInt();

		Statement miSentencia = miConexion.createStatement();

		String sql = String.format("DELETE FROM empleadoproyect WHERE idEmpleado=" + menu);

		miSentencia.executeUpdate(sql);

		verEmpleados();
	}

	public void borrarClientes() throws SQLException {
		Scanner in = new Scanner(System.in);
		int menu = 0;
		verClientes();
		System.out.println("Elieje el cliente que deseas borrar");
		menu = in.nextInt();

		Statement miSentencia = miConexion.createStatement();

		String sql = String.format("DELETE FROM cliente WHERE idcliente=" + menu);

		miSentencia.executeUpdate(sql);

		verClientes();
	}

	public void borrarVisitas() throws SQLException {
		Scanner in = new Scanner(System.in);
		int menu = 0;
		verVisitas();
		System.out.println("Elieje el visita que deseas borrar");
		menu = in.nextInt();

		Statement miSentencia = miConexion.createStatement();

		String sql = String.format("DELETE FROM visitaguiada WHERE nVisita=" + menu);

		miSentencia.executeUpdate(sql);

		verVisitas();
	}

	public void apuntarseVisitas() throws SQLException {
		Scanner in = new Scanner(System.in);
		int menuClient = 0, menuVisita = 0, clientApuntados, opcion = 3;
		String fecha;

		verClientes();
		System.out.println("Elije el cliente que va a ser el encargado de la reserva");
		menuClient = in.nextInt();

		verVisitas();
		System.out.println("Elije la visita a la que os vais a apuntar");
		menuVisita = in.nextInt();

		in.nextLine();
		System.out.println("Numero de clientes que van a ir");
		clientApuntados = in.nextInt();
		in.nextLine();
		System.out.println("Fecha de la visita (con este formato: yyyy-mm-dd)");
		fecha = in.nextLine();

		visitacliente vc = new visitacliente(menuClient, menuVisita, clientApuntados, comprobarFecha(fecha, opcion));

		Statement miSentencia = miConexion.createStatement();

		String sql = String.format(
				"INSERT INTO visitacliente (idCliente,idVisita,nClienteApuntados,fecha) VALUES (" + vc.getIdCliente()
						+ "," + vc.getIdVisita() + "," + vc.getnClientesApuntados() + ",'" + vc.getFecha() + "')");
		miSentencia.execute(sql);

		verVisitaClientes();

	}

	public int ultimoIDEmple() throws SQLException {
		Statement miSentencia = miConexion.createStatement();
		int id = 1;
		ResultSet miResultSet = miSentencia.executeQuery("SELECT max(idEmpleado) as maxid FROM empleadoproyect");
		while (miResultSet.next()) {
			id = miResultSet.getInt("maxid");
			System.out.println("Traza maxid: " + id);
		}
		return id;
	}

	public int ultimoIDCliente() throws SQLException {
		Statement miSentencia = miConexion.createStatement();
		int id = 1;
		ResultSet miResultSet = miSentencia.executeQuery("SELECT max(idcliente) as maxid FROM cliente");
		if (!miResultSet.next()) {
			return id;
		} else {
			while (miResultSet.next()) {
				id = miResultSet.getInt("maxid");
				System.out.println("Traza maxid: " + id);
			}
			return id;
		}
	}

	public int ultimoIDVisita() throws SQLException {
		Statement miSentencia = miConexion.createStatement();
		int id = 1;
		ResultSet miResultSet;
		try {
			miResultSet = miSentencia.executeQuery("SELECT max(nVisita) as maxid FROM visitaguiada");
		} catch (Exception e) {
			return id;
		}

		while (miResultSet.next()) {
			id = miResultSet.getInt("maxid");
			System.out.println("Traza maxid: " + id);
		}
		return id;

	}

	public Date comprobarFecha(String fecha, int menu) throws SQLException {
		// String startDate="01-02-2013";
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date date = null;
		try {
			date = sdf1.parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Fecha mal introducida");
			switch (menu) {
			case 1:
				crearEmpleados();
				break;
			case 2:
				editarEmpleados();
				break;
			case 3:
				apuntarseVisitas();
				break;

			}
		}
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
		return sqlStartDate;

		/*
		 * Pattern pat=null; Matcher mat=null;
		 * 
		 * pat = Pattern.compile("[0-9]{}");
		 */
	}
}
