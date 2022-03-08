from django.db import models
from log_reg_app.models import User

# Create your models here.
class WishManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        if len(postData['item']) < 3:
            errors["title"] = "Wish should at least be 3 characters"
        if len(postData['description']) < 3:
            errors["description"] = "description should be at least be 3 characters"
        return errors

class Wish(models.Model):
    item = models.CharField(max_length=255)
    description = models.TextField()
    user = models.ForeignKey(User, related_name="wishes", on_delete = models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = WishManager()

class Granted_wish(models.Model):
    item = models.CharField(max_length=255)
    date_added = models.DateTimeField(auto_now=True)
    granted_at = models.DateTimeField(auto_now_add=True)
    likes = models.ManyToManyField(User, related_name='likes')
    user = models.ForeignKey(User, related_name="granted_wishes", on_delete = models.CASCADE)



