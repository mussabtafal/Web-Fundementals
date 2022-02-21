from django.db import models
from log_reg_app.models import User

# Create your models here.
class BookManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}

        if len(postData['title']) < 1:
            errors["title"] = "Book title is Required"
        if len(postData['description']) < 5:
            errors["description"] = "Book description should be at least 5 characters"
        return errors

class Book(models.Model):
    book_title = models.CharField(max_length=255)
    book_description = models.TextField()
    user_uploaded_book = models.ForeignKey(User, related_name="uploaded_books", on_delete = models.CASCADE)
    user_book_like = models.ManyToManyField(User, related_name="liked_books")
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = BookManager()



