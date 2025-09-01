// Call the dataTables jQuery plugin
$(document).ready(function() {
// on ready
});

async function registerBook(){

let datos = {};
  datos.title =document.getElementById('txtTitle').value;
  datos.author =document.getElementById('txtAuthor').value;
  datos.description =document.getElementById('txtDescription').value;
  datos.read =document.getElementById('txtRead').value;
  datos.inBookshelf =document.getElementById('txtInBookshelf').value;


      const request = await fetch('api/books', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        //body: JSON.stringify({a: 1, b: 'Textual content'})
      });
      const books = await request.json();


}