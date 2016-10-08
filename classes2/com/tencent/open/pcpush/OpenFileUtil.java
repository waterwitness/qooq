package com.tencent.open.pcpush;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.webkit.MimeTypeMap;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public final class OpenFileUtil
{
  public OpenFileUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Intent a(Context paramContext, File paramFile)
  {
    if ((paramContext == null) || (paramFile == null) || (!paramFile.isFile())) {
      return null;
    }
    String str = paramFile.getName().toLowerCase().trim();
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    if (a(str, paramContext.getResources().getStringArray(2131230788)))
    {
      localIntent.setDataAndType(Uri.fromFile(paramFile), "image/*");
      return localIntent;
    }
    if (a(str, paramContext.getResources().getStringArray(2131230792)))
    {
      localIntent.setDataAndType(Uri.parse(paramFile.toString()).buildUpon().encodedAuthority("com.android.htmlfileprovider").scheme("content").encodedPath(paramFile.toString()).build(), "text/html");
      return localIntent;
    }
    if (a(str, paramContext.getResources().getStringArray(2131230789)))
    {
      localIntent.addFlags(67108864);
      localIntent.putExtra("oneshot", 0);
      localIntent.putExtra("configchange", 0);
      localIntent.setDataAndType(Uri.fromFile(paramFile), "audio/*");
      return localIntent;
    }
    if (a(str, paramContext.getResources().getStringArray(2131230790)))
    {
      localIntent.addFlags(67108864);
      localIntent.putExtra("oneshot", 0);
      localIntent.putExtra("configchange", 0);
      localIntent.setDataAndType(Uri.fromFile(paramFile), "video/*");
      return localIntent;
    }
    if (a(str, paramContext.getResources().getStringArray(2131230793)))
    {
      localIntent.setDataAndType(Uri.fromFile(paramFile), "text/plain");
      return localIntent;
    }
    if (a(str, paramContext.getResources().getStringArray(2131230797)))
    {
      localIntent.setDataAndType(Uri.fromFile(paramFile), "application/pdf");
      return localIntent;
    }
    if (a(str, paramContext.getResources().getStringArray(2131230794)))
    {
      localIntent.setDataAndType(Uri.fromFile(paramFile), "application/msword");
      return localIntent;
    }
    if (a(str, paramContext.getResources().getStringArray(2131230795)))
    {
      localIntent.setDataAndType(Uri.fromFile(paramFile), "application/vnd.ms-excel");
      return localIntent;
    }
    if (a(str, paramContext.getResources().getStringArray(2131230796)))
    {
      localIntent.setDataAndType(Uri.fromFile(paramFile), "application/vnd.ms-powerpoint");
      return localIntent;
    }
    if (a(str, paramContext.getResources().getStringArray(2131230798)))
    {
      localIntent.setDataAndType(Uri.fromFile(paramFile), "application/x-chm");
      return localIntent;
    }
    paramContext = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str.substring(str.lastIndexOf(".") + 1).toLowerCase().trim());
    localIntent.setDataAndType(Uri.fromFile(paramFile), paramContext);
    return localIntent;
  }
  
  public static boolean a(String paramString, String[] paramArrayOfString)
  {
    boolean bool2 = false;
    int j = paramArrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramString.endsWith(paramArrayOfString[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\pcpush\OpenFileUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */