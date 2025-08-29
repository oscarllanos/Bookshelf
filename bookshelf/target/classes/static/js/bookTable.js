// Call the dataTables jQuery plugin
$(document).ready(function() {

    loadBooks();

  $('#bookTable').DataTable();
});

async function loadBooks(){


      const request = await fetch('books', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        //body: JSON.stringify({a: 1, b: 'Textual content'})
      });
      const books = await request.json();

      let listHtml = '';
      for (let book of books){
      let bookHtml = '<tr><td>'+book.id+'</td><td>'+book.title+'</td><td>'+book.author
                      +'</td><td>'+book.read+'</td><td>'+book.inBookshelf
                      +'</td><td><a href="#" class="btn btn-info btn-circle btn-sm"><i class="fas fa-info-circle"></i></a><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>';
      listHtml += bookHtml;

      }
      document.querySelector('#bookTable tbody').outerHTML=listHtml;
}