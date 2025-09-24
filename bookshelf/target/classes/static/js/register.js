// Call the dataTables jQuery plugin
$(document).ready(function() {
// on ready
});


async function registrarBook() {

console.log("akjhsh");

let datos = {};
  datos.title =document.getElementById('txtTitle').value;
  datos.author =document.getElementById('txtAuthor').value;
  datos.description =document.getElementById('txtDescription').value;
  datos.read =document.getElementById('txtRead').value;
  datos.inBookshelf =document.getElementById('txtInBookshelf').value;
  datos.userName = localStorage.name;

  console.log(datos);

      const request = await fetch('api/books', {
        method: 'POST',
        headers: {
                 'Accept': 'application/json',
                 'Content-Type': 'application/json',
                 'Authorization': localStorage.token
                 },
        body: JSON.stringify(datos)
      });

alert ("El libro ha sido registrado exitosamente");
clearFields();
window.location.href = 'books.html';

}

function clearFields() {
    document.getElementById('txtTitle').value = "";
    document.getElementById('txtAuthor').value = "";
    document.getElementById('txtDescription').value = "";
    document.getElementById('txtRead').value = "";
    document.getElementById('txtInBookshelf').value = "";
}

function getHeaders(){
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': localStorage.token
    };
}