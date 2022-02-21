# Generated by Django 2.2.4 on 2022-02-19 10:05

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
        ('log_reg_app', '0004_auto_20220219_1205'),
    ]

    operations = [
        migrations.CreateModel(
            name='Book',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('book_title', models.CharField(max_length=255)),
                ('book_description', models.TextField()),
                ('created_at', models.DateTimeField(auto_now_add=True)),
                ('updated_at', models.DateTimeField(auto_now=True)),
                ('user_book_like', models.ManyToManyField(related_name='liked_books', to='log_reg_app.User')),
                ('user_uploaded_book', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='uploaded_books', to='log_reg_app.User')),
            ],
        ),
    ]