package com.tencent.mobileqq.redtouch;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public abstract class NumRedGetMsgCallback
{
  private static int b;
  public int a;
  
  public NumRedGetMsgCallback()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    int i = b;
    b = i + 1;
    this.a = i;
  }
  
  public abstract void a(String paramString, List paramList);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\redtouch\NumRedGetMsgCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */