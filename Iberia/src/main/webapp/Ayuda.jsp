<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IBERIA</title>
<style>
    body {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100vh;
        margin: 0;
        background: #f5f5f5;
        font-family: Arial, sans-serif;
    } 
    
    header{
    background-color: #DC143C;
    }

    h1 {
        margin: 0;
        padding: 1rem;
    }

    .tit1 {
        color: red;
        margin: 0;
        padding: 1rem;
    }

    .contenedor, .contenedor2 {
        background: #ffffff;
        padding: 2rem;
        width: 600px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        text-align: center;
        margin-top: 1rem;
    }
    
    p {
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        padding: 1rem;
    }
</style>
</head>
<body>

<h1>Ayuda</h1>

<header >
<img src="imagenes/logoiberia.svg">
</header>
<div class="contenedor">
    <h1 class="tit1">Preguntas Frecuentes</h1>
    <p>¿Cómo registrarse?</p>
    <p>¿Cancelar viaje?</p>
    <p>¿Dónde está mi maleta?</p>
</div>

<div class="contenedor2">
    <h1 class="tit1">Contacto</h1>
    <p>Nuestro número de contacto es 900 911 922</p>
    <p>En cualquier caso, también puede enviarnos un email aquí: iberiaemail@gmail.com</p>
</div>

</body>
</html>
