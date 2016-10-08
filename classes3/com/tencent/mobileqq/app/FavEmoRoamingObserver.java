package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class FavEmoRoamingObserver
  implements BusinessObserver
{
  public static final String a = "FavEmoRoamingObserver";
  
  public FavEmoRoamingObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (paramObject == null);
      a(((Boolean)paramObject).booleanValue());
      return;
      if (paramObject == null) {
        break;
      }
      try
      {
        a((ArrayList)paramObject);
        return;
      }
      catch (Exception paramObject) {}
    } while (!QLog.isColorLevel());
    QLog.d("FavEmoRoamingObserver", 2, ((Exception)paramObject).toString());
    return;
    a(new ArrayList());
  }
  
  protected void a(List paramList) {}
  
  protected void a(boolean paramBoolean) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\FavEmoRoamingObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */