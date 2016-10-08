package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public class StrangerObserver
  implements BusinessObserver
{
  public StrangerObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 4) {
      a(paramBoolean, (PBRepeatMessageField)paramObject);
    }
  }
  
  public void a(boolean paramBoolean, PBRepeatMessageField paramPBRepeatMessageField) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\StrangerObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */