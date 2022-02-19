from django.db import models
from time import localtime, strftime

class ShowManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        if len(postData['show_title']) < 2:
            errors["show_title"] = "Show title should be at least 2 characters"
        if len(postData['show_network']) < 3:
            errors["show_network"] = "Show network should be at least 2 characters"
        if len(postData['show_desc']) < 10:
            errors["show_desc"] = "Show description should be at least 10 characters"
        # if len(postData['release_date']) < strftime("%Y-%m-%d %H:%M:%S.%f+00:00", localtime()):
        #     errors["release_date"] = "Show release date should be in the past"
        return errors

class Show(models.Model):
    title = models.CharField(max_length=255)
    network = models.CharField(max_length=45)
    release_date = models.DateTimeField()
    desc = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = ShowManager()
