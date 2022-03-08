from django.urls import path     
from . import views
urlpatterns = [
    path('', views.landing),
    path('about_us', views.about_us),
    path('jobs', views.jobs),
    path('jobs/1', views.job_detail),
    path('companies', views.companies),
    path('companies/1', views.company_profile),
    path('user_register', views.user_register),
    path('company_register', views.company_register),
    path('add_job', views.add_job),
]