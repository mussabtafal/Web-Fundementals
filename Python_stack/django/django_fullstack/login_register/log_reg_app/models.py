from django.db import models
from datetime import date
import datetime
import re

class RegManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
        if len(postData['first_name']) < 2:
            errors["first_name"] = "Show title should be at least 2 characters"

        if len(postData['last_name']) < 2:
            errors["last_name"] = "Show network should be at least 2 characters"

        if not EMAIL_REGEX.match(postData['email']):                
            errors['email'] = "Invalid email address!"

        email_validate = User.objects.filter(useremail=postData['email'])
        if len(email_validate) > 0 :
            errors['val_email'] = "email already exists"

        if len(postData['password']) < 8:
            errors["password"] = "Password should be at least 8 characters"

        if postData['password'] != postData['confirm_password']:
                errors["confirm_password"] = "Passwords Does not match"
        
        if postData['dob'] == 0000-00-00:
            errors["dob_exist"] = "Date is mandatory"
        
        if datetime.datetime.strptime(postData['dob'] , '%Y-%m-%d') > datetime.datetime.now():
            errors["dob"] = "Birth date should be in the past"

        today = datetime.date.today()
        birth = datetime.datetime.strptime(postData['dob'] , '%Y-%m-%d')
        if today.year - birth.year < 13:
            errors["age"] = "age should be atleast 13"

        return errors

    def basic_validator_second(self, postData):
        errors = {}
        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
        if not EMAIL_REGEX.match(postData['email']):                
            errors['email'] = "Invalid email address!"
        if len(postData['password']) < 8:
            errors["password"] = "Password should be at least 8 characters"
        return errors

class User(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=45)
    user_dob = models.DateTimeField()
    useremail = models.CharField(max_length=255, unique=True)
    userpassword = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = RegManager()

