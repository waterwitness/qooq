package com.tencent.av.utils;

import android.app.Activity;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import mqq.manager.TicketManager;

public class AvImpeachUtil
{
  private static final int a = 16;
  public static final String a = "AvImpeachUtil";
  public static final String b = "http://aq.qq.com/cn2/uniform_impeach/impeach_entry";
  
  public AvImpeachUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuilder.append(0);
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("?eviluin=");
    ((StringBuffer)localObject).append(a(a(paramString, "8ecf8427ex%wE@1s")));
    ((StringBuffer)localObject).append("&srv_para=newpara&scene=101&appname=kqq&subapp=anonym_voice&system=android");
    paramString = "http://aq.qq.com/cn2/uniform_impeach/impeach_entry" + ((StringBuffer)localObject).toString();
    if (QLog.isColorLevel()) {
      QLog.d("AvImpeachUtil", 2, "impeach url: " + paramString);
    }
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("ishiderefresh", true);
    localIntent.putExtra("ishidebackforward", true);
    localIntent.putExtra("avSafeReport", true);
    CookieSyncManager.createInstance(paramVideoAppInterface.a().getApplicationContext());
    localObject = CookieManager.getInstance();
    ((CookieManager)localObject).setAcceptCookie(true);
    String str = ((TicketManager)paramVideoAppInterface.getManager(2)).getSkey(paramVideoAppInterface.getAccount());
    str = "skey=" + str + ";";
    paramVideoAppInterface = "uin=o" + paramVideoAppInterface.getAccount() + ";";
    ((CookieManager)localObject).setCookie("http://aq.qq.com/cn2/uniform_impeach/impeach_entry", str);
    ((CookieManager)localObject).setCookie("http://aq.qq.com/cn2/uniform_impeach/impeach_entry", paramVideoAppInterface);
    CookieSyncManager.getInstance().sync();
    paramActivity.startActivity(localIntent.putExtra("url", paramString));
  }
  
  public static byte[] a(String paramString1, String paramString2)
  {
    int j = 0;
    for (;;)
    {
      int i;
      byte[] arrayOfByte;
      try
      {
        localObject = paramString1.getBytes("utf-8");
        int k = localObject.length;
        i = k;
        if (k % 16 != 0) {
          i = k + (16 - k % 16);
        }
        paramString1 = new byte[i];
        System.arraycopy(localObject, 0, paramString1, 0, localObject.length);
        localObject = Cipher.getInstance("AES/CBC/NoPadding");
        paramString2 = new SecretKeySpec(paramString2.getBytes(), "AES");
        arrayOfByte = new byte[16];
        i = j;
      }
      catch (Exception paramString1)
      {
        Object localObject;
        paramString1.printStackTrace();
        return null;
      }
      ((Cipher)localObject).init(1, paramString2, new IvParameterSpec(arrayOfByte));
      ((Cipher)localObject).getIV();
      paramString1 = ((Cipher)localObject).doFinal(paramString1);
      return paramString1;
      while (i < 16)
      {
        arrayOfByte[i] = 0;
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\utils\AvImpeachUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */