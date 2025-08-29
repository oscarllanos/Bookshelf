// Call the dataTables jQuery plugin
$(document).ready(function() {

    loadBooks();

  $('#bookTable').DataTable();
});

async function loadBooks(){


      const request = await fetch('book/6789', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        //body: JSON.stringify({a: 1, b: 'Textual content'})
      });
      const books = await request.json();

      console.log(books);


}