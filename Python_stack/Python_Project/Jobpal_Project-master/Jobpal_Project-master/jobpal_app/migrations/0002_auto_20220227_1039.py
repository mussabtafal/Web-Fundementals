# Generated by Django 2.2.4 on 2022-02-27 08:39

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('jobpal_app', '0001_initial'),
    ]

    operations = [
        migrations.AlterField(
            model_name='job',
            name='location',
            field=models.CharField(max_length=100),
        ),
    ]