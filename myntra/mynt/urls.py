from django.conf.urls import url
from mynt import views

urlpatterns = [
    url(r'^api/$', views.api, name='api'),
    url(r'^results/$', views.results, name='result'),


]