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
    age = models.IntegerField(default=None)
    casual = 'CA'
    formal = 'FO'
    fav_choice = (
        (casual,'casual'),
        (formal,('formal'))
    )
    favourite =models.CharField(max_length=25,choices=fav_choice,default=casual)
    sandel = 'SA'
    shoes = 'SHO'
    fav_foot = (
        (sandel, 'sandels'),
        (shoes, ('shoes'))
    )
    foot_ware= models.CharField(max_length=25,choices=fav_foot,default=sandel)


    def __str__(self):
        return self.name


