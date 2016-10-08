package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;

public class ArkAppCenterCheckEvent
{
  public static final int a = 0;
  private static HashMap a = new HashMap();
  public static final int b = 1;
  public static final int c = 2;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Object a(int paramInt, String paramString, Object paramObject1, Object paramObject2)
  {
    paramString = (ArkAppCenterCheckEvent.Callback)a.get(paramString);
    if (paramString != null) {
      paramObject2 = paramString.a(paramInt, paramObject1);
    }
    return paramObject2;
  }
  
  public static void a(String paramString)
  {
    if (paramString != null) {
      a.remove(paramString);
    }
  }
  
  public static void a(String paramString, ArkAppCenterCheckEvent.Callback paramCallback)
  {
    if (paramString != null) {
      a.put(paramString, paramCallback);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\ark\ArkAppCenterCheckEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */