package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;

public class SubAccountBindObserver
  implements BusinessObserver
{
  public SubAccountBindObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      b(paramBoolean, (SubAccountBackProtocData)paramObject);
      return;
    case 1: 
      c(paramBoolean, (SubAccountBackProtocData)paramObject);
      return;
    }
    a(paramBoolean, (SubAccountBackProtocData)paramObject);
  }
  
  protected void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData) {}
  
  protected void b(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData) {}
  
  protected void c(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\SubAccountBindObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */