// Call the dataTables jQuery plugin
$(document).ready(function() {

    loadBooks();

  $('#bookTable').DataTable();

  updateUserName();
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
    listBooks(books);
}

function getHeaders(){
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': localStorage.token
    };
}

function listBooks(books) {
    let listHtml = '';
    let id = 1;
        for (let book of books){
            let BtnUpdate = '<a href="#" class="btn btn-info btn-circle btn-sm"><i class="fas fa-info-circle"></i></a>';
            let BtnDelete= '<a href="#" onclick="deleteBook('+book.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>'

            let bookHtml = '<tr><td>'+id+'</td><td>'+book.title+'</td><td>'+book.author
                          +'</td><td>'+book.read+'</td><td>'+book.inBookshelf
                          +'</td><td>'+BtnDelete+''+BtnUpdate+'</td></tr>';
            listHtml += bookHtml;
            id++;
        }
        document.querySelector('#bookTable tbody').outerHTML=listHtml;
}

async function deleteBook(id){
    if (!confirm('¿Desea eliminar este libro?')){
        return;
    }
    const request = await fetch('api/books/'+id, {
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