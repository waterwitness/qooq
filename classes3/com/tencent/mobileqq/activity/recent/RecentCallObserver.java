package com.tencent.mobileqq.activity.recent;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class RecentCallObserver
  implements com.tencent.mobileqq.app.BusinessObserver, mqq.observer.BusinessObserver
{
  public RecentCallObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, (Integer)paramObject[0], (String)paramObject[1], (List)paramObject[2], ((Boolean)paramObject[3]).booleanValue());
  }
  
  protected void a(boolean paramBoolean1, Integer paramInteger, String paramString, List paramList, boolean paramBoolean2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\RecentCallObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */