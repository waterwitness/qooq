package com.tencent.tmdownloader.internal.notification;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.tmassistantbase.a.m;
import java.io.File;

public class f
{
  public static boolean a(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if (new File(paramString).exists())
      {
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setFlags(268435456);
        localIntent.setDataAndType(Uri.fromFile(new File(paramString)), "application/vnd.android.package-archive");
        com.tencent.tmassistantbase.a.f.a().b().startActivity(localIntent);
        return true;
      }
    }
    catch (Exception paramString)
    {
      m.c("voken", "installApp>>>", paramString);
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\internal\notification\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */