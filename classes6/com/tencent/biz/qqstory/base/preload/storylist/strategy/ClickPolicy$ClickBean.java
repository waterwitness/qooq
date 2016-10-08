package com.tencent.biz.qqstory.base.preload.storylist.strategy;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ClickPolicy$ClickBean
{
  public final String a;
  public final String b;
  
  public ClickPolicy$ClickBean(String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public boolean a(Object paramObject)
  {
    if ((paramObject instanceof ClickBean)) {
      return (this.a == ((ClickBean)paramObject).a) && (this.b == ((ClickBean)paramObject).b);
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\storylist\strategy\ClickPolicy$ClickBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */