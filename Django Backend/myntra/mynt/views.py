from django.shortcuts import render,redirect,get_object_or_404
from .forms import PostForms
from .models import user
from django.utils import timezone

# Create your views here.

def api(request):
    return render(request,'mynt/api.html',{})


def results(request,pk):
    x = get_object_or_404(user,pk=pk)
    return render(request,'mynt/result.html',{'value':x})


def home(request):
    if request.method == "POST":
        form=PostForms(request.POST)
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