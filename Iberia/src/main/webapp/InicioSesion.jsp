<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IBERIA</title>
	<link rel="stylesheet" href="InicioSesion.css" type="text/css"> 
</head>
<body>
    <div class="login-container">
        <h2>Iniciar Sesión</h2>
        <form onsubmit="return esContrasenaValida()">
            <input type="text" id="username" placeholder="Usuario" required>
            <input type="password" id="password" placeholder="Contraseña" required>
            <button type="submit">Ingresar</button>
            <p class="error" id="error-message"></p>
        </form>
    </div>
      <script src="Validacion.js"></script>
    
</html>