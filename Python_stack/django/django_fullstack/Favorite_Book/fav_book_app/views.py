from django.shortcuts import render, redirect
from .models import *
from django.contrib import messages

# Create your views here.
def index(request):
    if 'userid' not in request.session:
        return redirect("/")
    else:
        this_user = User.objects.get(id = request.session['userid'])
        all_books = Book.objects.all()
        liked_books = this_user.liked_books.all()
        all_book_data = {
            "books": all_books,
            "liked_books": liked_books
        }
        return render(request, "userpage.html", all_book_data)

def add_book(request):
    errors = Book.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/books')
    else:
        this_user = User.objects.get(id = request.session['userid'])
        this_book = Book.objects.create(
            book_title = request.POST['title'],
            book_description = request.POST['description'],
            user_uploaded_book = this_user,
        )
        this_book.user_book_like.add(this_user)
        return redirect (f'/books/{this_book.id}')

def book_page(request, book_id):
    all_books = Book.objects.all()
    this_book = Book.objects.get(id = book_id)
    this_user = this_book.user_uploaded_book.id
    user_likes = this_book.user_book_like.all()

    if this_user == request.session['userid']:
        book_data = {
            "user_books": this_book,
            "books": all_books,
            "likes": user_likes,
        }
        return render (request,'book_edit_page.html', book_data)
    else:
        book_data = {
            "books": this_book,
            "likes": user_likes,
        }
        return render (request,'book_page.html', book_data)

def edit_book(request, book_id):
    errors = Book.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect(f'/books/{book_id}')
    else:
        this_user = User.objects.get(id = request.session['userid'])
        this_book = Book.objects.get(id = book_id)
        if request.POST['submit_button'] == 'update':
            this_book.book_title = request.POST['title']
            this_book.book_description = request.POST['description']
            this_book.save()
            return redirect (f'/books/{this_book.id}/')
        elif request.POST['submit_button'] == 'delete':
            this_book = Book.objects.get(id = book_id)
            this_book.delete()
            return redirect ("/books")

def add_fav(request, book_id):
    this_user = User.objects.get(id = request.session['userid'])
    this_book = Book.objects.get(id = book_id)
    this_book.user_book_like.add(this_user)
    return redirect (f"/books/{book_id}")

def remove_fav(request, book_id):
    this_user = User.objects.get(id = request.session['userid'])
    this_book = Book.objects.get(id = book_id)
    this_book.user_book_like.remove(this_user)
    return redirect (f"/books/{book_id}")

def logout(reqeust):
    reqeust.session.clear()
    return redirect ("/")