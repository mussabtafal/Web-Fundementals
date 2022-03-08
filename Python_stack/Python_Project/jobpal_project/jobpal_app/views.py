from django.shortcuts import render,redirect

def landing(request):
    return render (request, 'landing.html')

def about_us(request):
    return render (request, 'about_us.html')

def jobs(request):
    return render (request, 'job_list.html')

def job_detail(request):
    return render (request, 'job_detail.html')

def companies(request):
    return render (request, 'company_list.html')

def company_profile(request):
    return render (request, 'company_profile.html')

def user_register(request):
    return render (request, 'users_register.html')

def company_register(request):
    return render (request, 'company_register.html')

def add_job(request):
    return render (request, 'add_job.html')

