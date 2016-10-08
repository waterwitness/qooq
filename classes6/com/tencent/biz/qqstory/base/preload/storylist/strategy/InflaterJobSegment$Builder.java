package com.tencent.biz.qqstory.base.preload.storylist.strategy;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class InflaterJobSegment$Builder
{
  private InflaterRepeatPolicy a;
  
  public InflaterJobSegment$Builder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Builder a(InflaterRepeatPolicy paramInflaterRepeatPolicy)
  {
    this.a = paramInflaterRepeatPolicy;
    return this;
  }
  
  public InflaterJobSegment a()
  {
    InflaterJobSegment localInflaterJobSegment = new InflaterJobSegment();
    InflaterJobSegment.a(localInflaterJobSegment, this.a);
    return localInflaterJobSegment;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\storylist\strategy\InflaterJobSegment$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */