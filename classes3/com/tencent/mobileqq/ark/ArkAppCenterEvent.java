package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ArkAppCenterEvent
{
  public static final int a = 0;
  private static ArkAppCenterEvent.DictObservers a = new ArkAppCenterEvent.DictObservers();
  public static final int b = 1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(int paramInt, String paramString)
  {
    Object localObject = (ArkAppCenterEvent.Observers)a.get(paramString);
    if (localObject != null)
    {
      localObject = ((ArkAppCenterEvent.Observers)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (localEntry.getValue() != null) {
          ((ArkAppCenterEvent.Callback)localEntry.getValue()).a(paramInt, paramString);
        }
      }
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      paramString1 = a.entrySet().iterator();
      while (paramString1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramString1.next();
        if (localEntry.getValue() != null) {
          ((ArkAppCenterEvent.Observers)localEntry.getValue()).remove(paramString2);
        }
      }
    }
    paramString1 = (ArkAppCenterEvent.Observers)a.get(paramString1);
    if (paramString1 != null) {
      paramString1.remove(paramString2);
    }
  }
  
  public static void a(String paramString1, String paramString2, ArkAppCenterEvent.Callback paramCallback)
  {
    if (paramString1 == null) {
      return;
    }
    ArkAppCenterEvent.Observers localObservers2 = (ArkAppCenterEvent.Observers)a.get(paramString1);
    ArkAppCenterEvent.Observers localObservers1 = localObservers2;
    if (localObservers2 == null)
    {
      localObservers1 = new ArkAppCenterEvent.Observers();
      a.put(paramString1, localObservers1);
    }
    localObservers1.put(paramString2, paramCallback);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\ark\ArkAppCenterEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */