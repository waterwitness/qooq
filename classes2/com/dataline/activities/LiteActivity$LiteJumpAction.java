package com.dataline.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import bl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class LiteActivity$LiteJumpAction
{
  LiteActivity a;
  
  public LiteActivity$LiteJumpAction(LiteActivity paramLiteActivity1, LiteActivity paramLiteActivity2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramLiteActivity2;
  }
  
  /* Error */
  String a(Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: invokevirtual 32	android/net/Uri:getScheme	()Ljava/lang/String;
    //   6: astore_3
    //   7: ldc 34
    //   9: aload_3
    //   10: invokevirtual 40	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifeq +20 -> 33
    //   16: new 42	java/io/File
    //   19: dup
    //   20: aload_1
    //   21: invokevirtual 45	android/net/Uri:getPath	()Ljava/lang/String;
    //   24: invokespecial 48	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: invokevirtual 51	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   30: astore_2
    //   31: aload_2
    //   32: areturn
    //   33: ldc 53
    //   35: aload_3
    //   36: invokevirtual 40	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   39: ifeq +107 -> 146
    //   42: aload_0
    //   43: getfield 22	com/dataline/activities/LiteActivity$LiteJumpAction:a	Lcom/dataline/activities/LiteActivity;
    //   46: invokevirtual 59	com/dataline/activities/LiteActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   49: aload_1
    //   50: iconst_1
    //   51: anewarray 36	java/lang/String
    //   54: dup
    //   55: iconst_0
    //   56: ldc 61
    //   58: aastore
    //   59: aconst_null
    //   60: aconst_null
    //   61: aconst_null
    //   62: invokevirtual 67	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   65: astore_1
    //   66: aload_1
    //   67: astore_2
    //   68: aload_1
    //   69: ldc 61
    //   71: invokeinterface 73 2 0
    //   76: istore 4
    //   78: aload_1
    //   79: astore_2
    //   80: aload_1
    //   81: invokeinterface 77 1 0
    //   86: pop
    //   87: aload_1
    //   88: astore_2
    //   89: aload_1
    //   90: iload 4
    //   92: invokeinterface 81 2 0
    //   97: astore_3
    //   98: aload_3
    //   99: astore_2
    //   100: aload_1
    //   101: ifnull -70 -> 31
    //   104: aload_1
    //   105: invokeinterface 84 1 0
    //   110: aload_3
    //   111: areturn
    //   112: astore_3
    //   113: aconst_null
    //   114: astore_1
    //   115: aload_1
    //   116: astore_2
    //   117: aload_3
    //   118: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   121: aload_1
    //   122: ifnull +34 -> 156
    //   125: aload_1
    //   126: invokeinterface 84 1 0
    //   131: aconst_null
    //   132: areturn
    //   133: astore_1
    //   134: aload_2
    //   135: ifnull +9 -> 144
    //   138: aload_2
    //   139: invokeinterface 84 1 0
    //   144: aload_1
    //   145: athrow
    //   146: aconst_null
    //   147: areturn
    //   148: astore_1
    //   149: goto -15 -> 134
    //   152: astore_3
    //   153: goto -38 -> 115
    //   156: aconst_null
    //   157: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	LiteJumpAction
    //   0	158	1	paramUri	Uri
    //   1	138	2	localObject	Object
    //   6	105	3	str	String
    //   112	6	3	localException1	Exception
    //   152	1	3	localException2	Exception
    //   76	15	4	i	int
    // Exception table:
    //   from	to	target	type
    //   42	66	112	java/lang/Exception
    //   42	66	133	finally
    //   68	78	148	finally
    //   80	87	148	finally
    //   89	98	148	finally
    //   117	121	148	finally
    //   68	78	152	java/lang/Exception
    //   80	87	152	java/lang/Exception
    //   89	98	152	java/lang/Exception
  }
  
  public void a(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    if (paramIntent.getBooleanExtra("dataline_share_finish", false)) {}
    Object localObject;
    do
    {
      return;
      paramIntent.putExtra("dataline_share_finish", true);
      localObject = paramIntent.getType();
    } while (TextUtils.isEmpty((CharSequence)localObject));
    if (localBundle == null)
    {
      QLog.e(LiteActivity.a, 1, "LiteJumpAction:doShare type is [" + (String)localObject + "], action is [" + paramIntent.getAction() + "]");
      return;
    }
    if ((((String)localObject).startsWith("text")) && (!localBundle.containsKey("android.intent.extra.STREAM")))
    {
      paramIntent = localBundle.getString("android.intent.extra.TEXT");
      this.a.a(paramIntent);
      return;
    }
    if (((String)localObject).startsWith("message"))
    {
      paramIntent = (SpannableString)localBundle.get("android.intent.extra.TEXT");
      this.a.a(paramIntent.toString());
      return;
    }
    if (((String)localObject).startsWith("image"))
    {
      if (paramIntent.getAction().equals("android.intent.action.SEND"))
      {
        paramIntent = (Uri)localBundle.get("android.intent.extra.STREAM");
        if (paramIntent == null)
        {
          LiteActivity.a(this.b);
          return;
        }
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramIntent);
        a((ArrayList)localObject, true);
        return;
      }
      a((ArrayList)localBundle.get("android.intent.extra.STREAM"), true);
      return;
    }
    if (paramIntent.getAction().equals("android.intent.action.SEND"))
    {
      paramIntent = (Uri)localBundle.get("android.intent.extra.STREAM");
      if (paramIntent == null)
      {
        LiteActivity.a(this.b);
        return;
      }
      if (((paramIntent instanceof Uri)) && ("text/x-vcard".equals(localObject)) && ("content".equals(paramIntent.getScheme())))
      {
        new bl(this.b).execute(new Object[] { this.b.getApplicationContext(), paramIntent });
        return;
      }
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramIntent);
      a((ArrayList)localObject, false);
      return;
    }
    a((ArrayList)localBundle.get("android.intent.extra.STREAM"), false);
  }
  
  void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList == null)
    {
      LiteActivity.a(this.b);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = a((Uri)paramArrayList.next());
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(str);
      }
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.b.a(localArrayList, i);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\dataline\activities\LiteActivity$LiteJumpAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */