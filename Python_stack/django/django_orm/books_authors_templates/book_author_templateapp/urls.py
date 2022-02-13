from django.urls import path
from . import views

urlpatterns = [
    path('', views.book_page),
    path('authors', views.author_page),
    path('add_books', views.add_books),
    path('add_authors', views.add_authors),
    path('books/<int:id>/', views.show_books),
    path('authors/<int:id>/', views.show_authors),
    path('books/<int:id>/author_book', views.author_book),  
    path('authors/<int:id>/book_author', views.book_author),
]