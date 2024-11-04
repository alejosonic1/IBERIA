package ConectaBDD;
import java.sql.*;
public class ConectaConexion {

	public static void main(String[] args) {
		try {
			
			//Crear conexion
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:,3306/sistema_reservas","root","");
			
			//Crear Objeto Statement
			Statement miStatement =miConexion.createStatement();
			
			//EjecutarSQL
			String instruccionsql="INSERT INTO RESERVAS(DESTINO, ORIGEN)VALUES('MIAMI','PERU')";
			
			miStatement.executeUpdate(instruccionsql);
			
			System.out.println("DATOS INTRODUCIDOS CORRECTAMENTE");
		}
		catch(Exception e) {
			System.out.println("NO CONECTAAAA");
			e.printStackTrace();
		}
	}

}
