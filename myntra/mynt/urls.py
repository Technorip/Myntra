from django.conf.urls import url
from mynt import views

urlpatterns = [
    url(r'^api/$', views.api, name='api'),
    url(r'^results/(?P<pk>\d+)/$', views.results, name='result'),
    url(r'^home/$', views.results, name='result'),
]

