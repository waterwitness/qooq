package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ServerAddr
{
  public String a;
  public int b;
  
  public ServerAddr()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = 80;
  }
  
  public void a() {}
  
  public void b() {}
  
  public String toString()
  {
    return this.a + ":" + this.b;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\ServerAddr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */