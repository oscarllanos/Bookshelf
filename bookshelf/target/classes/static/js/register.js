// Call the dataTables jQuery plugin
$(document).ready(function() {

    if(localStorage.id != 0){
        loadBook();
    }

});

async function loadBook(){
    const request = await fetch('api/books/update/'+localStorage.id, {
            method: 'GET',
            headers: getHeaders()
    });
    const books = await request.json();

    for (let book of books){
            document.getElementById('txtTitle').value = book.title;
            document.getElementById('txtAuthor').value = book.author;
            document.getElementById('txtDescription').value = book.description;
            document.getElementById('readDropdown').text = book.read;
            document.getElementById('bookshelfDropdown').text = book.inBookshelf;
    }
}


async function registrarBook() {

let datos = {};
if(localStorage.id != 0){
        datos.id = localStorage.id;
    }
  datos.title =document.getElementById('txtTitle').value;
  datos.author =document.getElementById('txtAuthor').value;
  datos.description =document.getElementById('txtDescription').value;
  datos.read =document.getElementById('readDropdown').text;
  datos.inBookshelf =document.getElementById('bookshelfDropdown').text;
  datos.userName = localStorage.name;

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
    document.getElementById('readDropdown').text = "";
    document.getElementById('bookshelfDropdown').text = "";
}

function getHeaders(){
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': localStorage.token
    };
}