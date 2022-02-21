from django.urls import path
from . import views

urlpatterns = [
    path('books', views.index),
    path('book_add', views.add_book),
    path('logout', views.logout),
    path('books/<int:book_id>/', views.book_page),
    path('books/<int:book_id>/edit', views.edit_book),
    path('books/<int:book_id>/favorites', views.add_fav),
    path('books/<int:book_id>/un_favorites', views.remove_fav),
]