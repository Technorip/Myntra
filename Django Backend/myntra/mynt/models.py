from __future__ import unicode_literals

from django.db import models
from django.utils import timezone

# Create your models here.

class user(models.Model):
    name = models.CharField(max_length=50,blank=False)
    mail_id = models.EmailField(max_length=50,blank=True)
    time_stamp = models.TimeField(default=timezone.now())
    male='M'
    female='F'
    gender_choice = (
        (male,'male'),
        (female,'female')
    )
    gender =models.CharField(max_length=10,choices=gender_choice,default=male)

    def __str__(self):
        return self.name

