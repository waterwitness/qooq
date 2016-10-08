package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class RichMediaStrategy$OldEngineDPCProfile$TimeoutParam
{
  public static final int a = 2000;
  int b;
  int c;
  int d;
  int e;
  int f;
  int g;
  private int h;
  
  public RichMediaStrategy$OldEngineDPCProfile$TimeoutParam()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = 40000;
    this.c = 30000;
    this.d = 20000;
    this.e = 20000;
    this.f = 15000;
    this.g = 10000;
  }
  
  private RichMediaStrategy$OldEngineDPCProfile$TimeoutParam(TimeoutParam paramTimeoutParam)
  {
    this.b = 40000;
    this.c = 30000;
    this.d = 20000;
    this.e = 20000;
    this.f = 15000;
    this.g = 10000;
    this.b = paramTimeoutParam.b;
    this.c = paramTimeoutParam.c;
    this.d = paramTimeoutParam.d;
    this.e = paramTimeoutParam.e;
    this.f = paramTimeoutParam.f;
    this.g = paramTimeoutParam.g;
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return this.b;
    case 1: 
    case 4: 
    case 5: 
      return this.d;
    }
    return this.c;
  }
  
  public TimeoutParam a()
  {
    return new TimeoutParam(this);
  }
  
  public void a(int paramInt)
  {
    this.h = (paramInt * 2000);
  }
  
  public int b(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return this.e + this.h;
    case 1: 
    case 4: 
    case 5: 
      return this.g + this.h;
    }
    return this.f + this.h;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\transfile\RichMediaStrategy$OldEngineDPCProfile$TimeoutParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */