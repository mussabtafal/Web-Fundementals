# Generated by Django 2.2.4 on 2022-02-27 08:43

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('jobpal_app', '0003_auto_20220227_1041'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='job',
            name='status',
        ),
    ]