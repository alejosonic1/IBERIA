function esContrasenaValida() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const errorMessage = document.getElementById("error-message");

    if (username !== "alejo" || password !== "patata") {
		window.location.href = "ErrorPagina.jsp";
        return false;
    }

    errorMessage.textContent = "";
    window.location.href = "Iberia.jsp";
    return false; 
}
