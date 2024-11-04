<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Simulación de Página Iberia</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
            background-image: url('imagenes/Playa.jpeg'); /* Imagen de fondo */
            background-size: cover;
            background-position: center;
            color: white;
        }

        /* Barra superior estilo Iberia */
        header {
            background-color: #DC143C;
            color: white;
            padding: 15px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .logo {
            height: 40px;
        }

        .menu {
            display: flex;
            gap: 20px;
            font-size: 14px;
        }

        .menu a {
            color: white;
            text-decoration: none;
        }

        /* Sección de búsqueda */
        .search-container {
            background-color: rgba(255, 255, 255, 0.9);
            padding: 20px;
            margin: 20px auto;
            max-width: 1000px;
            border-radius: 8px;
            display: flex;
            gap: 10px;
            align-items: center;
            flex-wrap: wrap;
            color: black;
        }

        .search-container label {
            font-weight: bold;
            width: 100%;
            text-align: center;
        }

        .search-container input,
        .search-container select {
            padding: 10px;
            flex: 1;
            min-width: 150px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        .search-container .search-button {
            background-color: #DC143C;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 4px;
            font-weight: bold;
            flex: 0 1 150px;
        }

        /* Banner de fondo */
        .banner {
            text-align: center;
            padding: 60px 20px;
        }

        .banner h1 {
            font-size: 36px;
            font-weight: bold;
        }

        .banner p {
            font-size: 18px;
            margin-top: 10px;
        }

        /* Botones inferiores */
        .bottom-buttons {
            display: flex;
            justify-content: center;
            gap: 10px;
            margin-top: 20px;
            
            
        }

        .bottom-buttons .button {
            background-color: white;
            color: #DC143C;
            padding: 15px;
            border-radius: 8px;
            text-align: center;
            font-weight: bold;
            width: 180px;
            text-decoration: none;
            
        }
        .button-1 {
            background-image: url('imagenes/PERU.jpg');
            background-size: cover; /* Esto hace que la imagen ocupe todo el espacio del botón */
            
            
        }
        .button-2 {
            background-image: url('imagenes/MEXICO.jpg');
            background-size: cover; /* Esto hace que la imagen ocupe todo el espacio del botón */
            
        }
        .button-3 {
            background-image: url('imagenes/ITALIA.jpg');
            background-size: cover; /* Esto hace que la imagen ocupe todo el espacio del botón */
            
        }
    </style>
</head>
<body>
    <header>
        <img src="imagenes/logoiberia.svg" alt="Iberia Logo" class="logo">
        <div class="menu">
            <a href="Vuelos">Vuelos</a>
            <a href="Hoteles.jsp">Hoteles</a>
            <a href="Ofertas.jsp">Ofertas</a>
            <a href="Ayuda.jsp">Ayuda</a>
        </div>
    </header>

    <div class="banner">
        <h1>Descubre las Islas Canarias con un 30% de descuento</h1>
       
    </div>

    <form action="BusquedaForm" method="POST">
        <div class="search-container">
            <input type="text" id="origen" name="origen" placeholder="Origen">
            <input type="text" id="destino" name="destino" placeholder="Destino">
            <input type="date" id="fecha-ida" name="fecha_ida" placeholder="Fecha de Ida">
            <input type="date" id="fecha-vuelta" name="fecha_vuelta" placeholder="Fecha de Vuelta">
            <select id="pasajeros" name="pasajeros">
                <option value="1">1 Pasajero</option>
                <option value="2">2 Pasajeros</option>
                <option value="3">3 Pasajeros</option>
                <option value="4">4 Pasajeros</option>
            </select>
            <button type="submit" class="search-button">Buscar</button>
        </div>

        <div class="bottom-buttons">
            <a href="https://es.wikipedia.org/wiki/Per%C3%BA" class="button button-1">INFORMACION DE PERU</a>
            <a href="https://es.wikipedia.org/wiki/M%C3%A9xico" class="button button-2">INFORMACION DE MEXICO</a>
            <a href="https://es.wikipedia.org/wiki/Italia" class="button button-3">INFORMACION DE ITALIA</a>
        </div>
    </form>
</body>
</html>
