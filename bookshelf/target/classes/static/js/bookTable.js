// Call the dataTables jQuery plugin
$(document).ready(function() {

    loadBooks();

  updateUserName();

  localStorage.id = "0";
});

function updateUserName(){
    document.getElementById('txt-name-user').outerHTML = localStorage.name;
}

async function loadBooks(){

    const request = await fetch('api/books/'+localStorage.name, {
        method: 'GET',
        headers: getHeaders()
    });
    const books = await request.json();
    //listBooks(books);
    $('#dataTable').DataTable({
                        data: books,
                        columns: [
                                { data: 'title' },
                                { data: 'author' },
                                { data: 'read' },
                                { data: 'inBookshelf' },
                                { data: 'id',
                                  render: function (data, type) {
                                              if (type === 'display') {
                                                 let BtnUpdate = "<a href='#' onclick='updateBook("+data
                                                                 +")' class='btn btn-info btn-circle btn-sm'><i class='fas fa-info-circle'></i></a>";
                                                 let BtnDelete= "<a href='#' onclick='deleteBook("+data
                                                                 +")' class='btn btn-danger btn-circle btn-sm'><i class='fas fa-trash'></i></a>"

                                                 return '<td>'+BtnDelete+'  '+BtnUpdate+'</td>'
                                              }
                                           return data;
                                           }
                                }
                            ]
                    });
}

function getHeaders(){
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': localStorage.token
    };
}

async function updateBook(id){
    if (!confirm('¿Desea actualizar este libro?')){
        return;
    }
    localStorage.id = id;
    window.location.href = 'register.html'
}

async function deleteBook(id){
    if (!confirm('¿Desea eliminar este libro?')){
        return;
    }
    const request = await fetch('api/books/delete/'+id, {
            method: 'DELETE',
            headers: getHeaders()
          });
    location.reload();
}

async function searchBook() {
    let txtSearch =document.getElementById('searchTxt').value;

    const request = await fetch('api/books/'+localStorage.name+'/'+txtSearch, {
            method: 'GET',
            headers: getHeaders()
        });
        const books = await request.json();
        listBooks(books);
}

async function logout() {
    localStorage.clear();
    window.location.href = 'login.html';
}