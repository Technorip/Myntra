from django.shortcuts import render

# Create your views here.

def api(request):
    return render(request,'mynt/api.html',{})


def results(request):
    return render(request,'mynt/result.html',{})