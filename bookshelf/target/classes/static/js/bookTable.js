// Call the dataTables jQuery plugin
$(document).ready(function() {

    loadBooks();

  $('#bookTable').DataTable();
});

async function loadBooks(){


      const request = await fetch('api/books', {
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
      let BtnUpdate = '<a href="#" class="btn btn-info btn-circle btn-sm"><i class="fas fa-info-circle"></i></a>';
      let BtnDelete= '<a href="#" onclick="deleteBook('+book.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>'

      let bookHtml = '<tr><td>'+book.id+'</td><td>'+book.title+'</td><td>'+book.author
                      +'</td><td>'+book.read+'</td><td>'+book.inBookshelf
                      +'</td><td>'+BtnDelete+''+BtnUpdate+'</td></tr>';
      listHtml += bookHtml;

      }
      document.querySelector('#bookTable tbody').outerHTML=listHtml;

}

    async function deleteBook(id){

    if (!confirm('¿Desea eliminar este libro?')){
    return;
    }

    const request = await fetch('api/books/'+id, {
            method: 'DELETE',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
            //body: JSON.stringify({a: 1, b: 'Textual content'})
          });
    location.reload();
    }