// Call the dataTables jQuery plugin
$(document).ready(function() {
// on ready
});

async function login(){

let datos = {};
  datos.email =document.getElementById('txtEmail').value;
  datos.password =document.getElementById('txtPassword').value;


      const request = await fetch('api/login', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
      });

     const response = await request.json();
         if (response != ''){
             localStorage.token = response[1];
             localStorage.name = response[0];
             window.location.href = 'books.html';
         } else {
             alert ("Las credenciales son incorrectas. Por favor intente nuevamente");
         }

}
