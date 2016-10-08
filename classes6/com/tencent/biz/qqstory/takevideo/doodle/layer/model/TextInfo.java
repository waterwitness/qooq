package com.tencent.biz.qqstory.takevideo.doodle.layer.model;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TextInfo
{
  public static final int a = 1;
  public static final int b = 2;
  public String a;
  public int c;
  public int d;
  public int e;
  
  public TextInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(TextInfo paramTextInfo)
  {
    this.a = paramTextInfo.a;
    this.c = paramTextInfo.c;
    this.d = paramTextInfo.d;
    this.e = paramTextInfo.e;
  }
  
  public String toString()
  {
    return "TextInfo{text='" + this.a + '\'' + ", textColor=" + this.c + ", size=" + this.d + ", state=" + this.e + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\layer\model\TextInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */