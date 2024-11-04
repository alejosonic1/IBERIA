package ConectaBDD;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BusquedaForm")
public class BusquedaForm extends HttpServlet {

    private static final String URL = "jdbc:mysql://localhost:3306/sistema_reservas";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String origen = request.getParameter("origen");
        String destino = request.getParameter("destino");
        String fechaIda = request.getParameter("fecha_ida");
        String fechaVuelta = request.getParameter("fecha_vuelta");
        String pasajeros = request.getParameter("pasajeros");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head>");
        out.println("<title>Resultados de Búsqueda</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f5f5f5; margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh; }");
        out.println(".container { max-width: 800px; width: 100%; background-color: #fff; padding: 20px; border-radius: 8px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); text-align: center; }");
        out.println("h1 { color: #333; font-size: 24px; margin-bottom: 10px; }");
        out.println("p { color: #666; font-size: 16px; margin-bottom: 20px; }");
        out.println("table { width: 100%; border-collapse: collapse; margin-top: 10px; }");
        out.println("th, td { padding: 12px; text-align: center; }");
        out.println("th { background-color: #dc143c; color: #fff; font-weight: bold; }");
        out.println("tr:nth-child(even) { background-color: #f2f2f2; }");
        out.println(".back-button { display: inline-block; margin-top: 20px; padding: 10px 20px; background-color: #28a745; color: #fff; text-decoration: none; border-radius: 4px; font-weight: bold; }");
        out.println(".back-button:hover { background-color: #218838; }");
        out.println("</style></head><body>");

        out.println("<div class='container'>");
        out.println("<h1>Vuelos Disponibles</h1>");
        out.println("<p>Ha seleccionado el siguiente origen: " + origen + "</p>");
        
        try {
            // VERIFICA SI ESTA EL DRIVER
            Class.forName("com.mysql.cj.jdbc.Driver");
            // ESTO HACE QUE LA CONEXION SIGA CON ESOS PARAMETROS DE URL USER Y PASSWORD
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            // ESTO HACE GUARDA EN UNA VARIABLE LA SELECT CON LO QUE QUERAMOS QUE HAGA
            String sql = "SELECT * FROM reservas WHERE origen = ? AND destino = ? AND fecha_ida = ? AND fecha_vuelta = ? AND pasajeros = ?";
            // ESTO NOS EJECUTA LA SELECT
            PreparedStatement stmt = conn.prepareStatement(sql);
            // LE ESTOY INDICANDO LA POSICION QUE VAN EN LA SENTENCIA SQL
            stmt.setString(1, origen);
            stmt.setString(2, destino);
            stmt.setString(3, fechaIda);
            stmt.setString(4, fechaVuelta);
            stmt.setString(5, pasajeros);
            // EJECUTA Y RECORRE LA CONSULTA
            ResultSet rs = stmt.executeQuery();

            out.println("<table>");
            out.println("<tr><th>ID</th><th>Origen</th><th>Destino</th><th>Fecha Ida</th><th>Fecha Vuelta</th><th>Pasajeros</th></tr>");
            // BUCLE PARA RECORRER LOS DATOS
            boolean hasResults = false;
            while (rs.next()) {
                hasResults = true;
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("origen") + "</td>");
                out.println("<td>" + rs.getString("destino") + "</td>");
                out.println("<td>" + rs.getString("fecha_ida") + "</td>");
                out.println("<td>" + rs.getString("fecha_vuelta") + "</td>");
                out.println("<td>" + rs.getInt("pasajeros") + "</td>");
                
                out.println("</tr>");
            }
            
            if (!hasResults) {
                out.println("<tr><td colspan='7'>No se encontraron vuelos con los criterios seleccionados.</td></tr>");
            }

            out.println("</table>");
            out.println("<a href='Iberia.jsp' class='back-button'>Volver a la página principal</a>");
            out.println("</div>");

            conn.close();
        } catch (ClassNotFoundException e) {
            out.println("<p>Error: No se encontró el driver JDBC de MySQL.</p>");
            e.printStackTrace(out);
        } catch (SQLException e) {
            out.println("<p>Error al conectar con la base de datos.</p>");
            e.printStackTrace(out);
        }

        out.println("</body></html>");
        out.close();
    }
}
