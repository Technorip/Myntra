from django.shortcuts import render,redirect,get_object_or_404
from .forms import PostForms
from .models import user
from django.utils import timezone
from django.http import request,response

# Create your views here.

def api(request):
    return render(request,'mynt/api.html',{})


def results(request,pk):
    x = get_object_or_404(user,pk=pk)
    """
    ink = "http://developer.myntra.com/search/data/"
    link += x.gender
    data = request.GET(link)
    context_pass = {
        "data": data,"value":x
    }
    """

    context_pass = {
        "value":x
    }
    return render(request,'mynt/result.html',context_pass)


def home(request):
    if request.method == "GET":
        form=PostForms(request.GET)
        if form.is_valid():
            user = form.save(commit=False)
            user.time_stamp = timezone.now()
            user.save()
            """
            return redirect(results,pk=user.pk)
            """
            return redirect(results,pk=user.pk)
    else:
        form=PostForms()
    return render(request,'mynt/welcome.html',{'form':form})