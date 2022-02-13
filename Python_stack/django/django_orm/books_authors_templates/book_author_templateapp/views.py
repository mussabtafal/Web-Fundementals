from itertools import count
from django.shortcuts import render, redirect
from .models import *

# Create your views here.
def book_page(request):
    bookdata = Book.objects.all()
    book_table = {
        "books": bookdata,     
    }
    return render(request, "Books.html", book_table)

def author_page(request):
    authordata = Author.objects.all()
    author_table = {
        "authors": authordata,
    }
    return render(request, "Authors.html", author_table)

def add_authors(request):
    Author.objects.create(
        first_name = request.POST['firstname'], 
        last_name = request.POST['lastname'],
        notes = request.POST['notes'],)
    return redirect("/authors")

def add_books(request):
    Book.objects.create(
        title = request.POST['title'], 
        desc = request.POST['descrip'],)
    print(Book.objects.all())
    return redirect("/")

def show_books(request, id):
    this_book = Book.objects.get(id = id)
    all_authors = Author.objects.all()
    book_authors = this_book.authors.all()
    non_assoc_authors = Author.objects.exclude(books = this_book)
    this_book_table = {
        "books": this_book, 
        "authors": all_authors,
        "book_authors": book_authors,
        "non_assoc_authors": non_assoc_authors
    }
    return render(request, "show_books.html", this_book_table)

def author_book(request, id):
    new_book = Book.objects.get(id = id)
    new_author = Author.objects.get(id = request.POST['author_select'])
    new_author.books.add(new_book)
    return redirect(f"/books/{new_book.id}")


def show_authors(request, id):
    this_author = Author.objects.get(id = id)
    all_books = Book.objects.all()
    author_books = this_author.books.all()
    non_assoc_books = Book.objects.exclude(authors = this_author)
    this_book_table = {
        "authors": this_author, 
        "books": all_books,
        "author_books": author_books,
        "non_assoc_books": non_assoc_books 
    }
    return render(request, "show_authors.html", this_book_table)

def book_author(request, id):
    new_author = Author.objects.get(id = id)
    new_book = Book.objects.get(id = request.POST['book_select'])
    new_book.authors.add(new_author)
    return redirect(f"/authors/{new_author.id}")






