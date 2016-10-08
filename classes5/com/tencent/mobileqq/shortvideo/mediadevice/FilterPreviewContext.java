package com.tencent.mobileqq.shortvideo.mediadevice;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FilterPreviewContext
{
  public int a;
  private int b;
  
  public FilterPreviewContext()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a()
  {
    int i = this.b;
    this.b = (i + 1);
    return i;
  }
  
  public void a()
  {
    this.b = 0;
    this.a = 0;
  }
  
  public int b()
  {
    return this.b;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\mediadevice\FilterPreviewContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */