package com.example.application;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import static androidx.core.content.ContextCompat.startActivity;

public class CallFunction
{
    Context context;
    public CallFunction(Context context)
    {
        this.context=context;
    }
    public void callMethod(String number)
    {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:"+number));
        context.startActivity(callIntent);
    }
}
