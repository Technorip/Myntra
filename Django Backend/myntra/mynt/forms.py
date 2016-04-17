from django import forms
from .models import user

class PostForms(forms.ModelForm):

    class Meta:
        model =user
        fields = ('name','gender','age','favourite','foot_ware')
