# -*- coding: utf-8 -*-
# Generated by Django 1.9.5 on 2016-04-16 23:02
from __future__ import unicode_literals

import datetime
from django.db import migrations, models
from django.utils.timezone import utc


class Migration(migrations.Migration):

    dependencies = [
        ('mynt', '0002_auto_20160416_2211'),
    ]

    operations = [
        migrations.AddField(
            model_name='user',
            name='time_stamp',
            field=models.TimeField(default=datetime.datetime(2016, 4, 16, 23, 2, 22, 598367, tzinfo=utc)),
        ),
    ]