package com.tencent.mobileqq.emosm;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class DataFactory
{
  public static final int a = 1000;
  public static final String a = "callbackid";
  public static final int b = 1001;
  public static final String b = "request";
  public static final int c = 1002;
  public static final String c = "response";
  public static final int d = 1003;
  public static final String d = "cmd";
  public static final String e = "respkey";
  public static final String f = "failcode";
  
  public DataFactory()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Bundle a(String paramString1, String paramString2, int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("cmd", paramString1);
    localBundle.putString("callbackid", paramString2);
    localBundle.putInt("respkey", paramInt);
    localBundle.putBundle("request", paramBundle);
    return localBundle;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emosm\DataFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */