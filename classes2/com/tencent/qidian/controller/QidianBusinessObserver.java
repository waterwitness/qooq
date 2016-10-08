package com.tencent.qidian.controller;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;

public class QidianBusinessObserver
  implements BusinessObserver
{
  private static final String a = QidianBusinessObserver.class.getName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1001: 
      a(paramBoolean, (HashMap)paramObject);
      return;
    case 1002: 
      b(paramBoolean, (HashMap)paramObject);
      return;
    case 1003: 
      c(paramBoolean, (HashMap)paramObject);
      return;
    }
    d(paramBoolean, (HashMap)paramObject);
  }
  
  public void a(boolean paramBoolean, HashMap paramHashMap) {}
  
  protected void b(boolean paramBoolean, HashMap paramHashMap) {}
  
  protected void c(boolean paramBoolean, HashMap paramHashMap) {}
  
  protected void d(boolean paramBoolean, HashMap paramHashMap) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qidian\controller\QidianBusinessObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */