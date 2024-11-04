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

@WebServlet("/Vuelos")
public class Vuelos extends HttpServlet {

    private static final String URL = "jdbc:mysql://localhost:3306/sistema_reservas";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response); // Redirige la solicitud GET al método doPost para reutilizar el código
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        out.println("<h1>Vuelos Disponibles</h1>");
        
        // Inicio de la tabla
        out.println("<table>");
        out.println("<tr><th>ID</th><th>Origen</th><th>Destino</th><th>Fecha Ida</th><th>Fecha Vuelta</th><th>Pasajeros</th></tr>");
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement misentencia = conn.prepareStatement("SELECT * FROM reservas");
             ResultSet rs = misentencia.executeQuery()) {

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("origen") + "</td>");
                out.println("<td>" + rs.getString("destino") + "</td>");
                out.println("<td>" + rs.getString("fecha_ida") + "</td>");
                out.println("<td>" + rs.getString("fecha_vuelta") + "</td>");
                out.println("<td>" + rs.getInt("pasajeros") + "</td>");
                out.println("</tr>");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<p>Error al conectar con la base de datos.</p>");
        }

        // Cierre de la tabla
        out.println("</table>");
        out.println("<a href='Iberia.jsp' class='back-button'>Volver</a>");
        out.println("</div>");

        out.println("</body></html>");
        
        out.close(); // Cerrar el PrintWriter
    }
}
