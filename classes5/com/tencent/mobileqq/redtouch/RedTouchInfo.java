package com.tencent.mobileqq.redtouch;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class RedTouchInfo
{
  public static final int a = -1;
  public static final String a = "redTouch";
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public String b;
  public int g;
  public int h;
  public int i;
  public int j;
  
  public RedTouchInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static RedTouchInfo a()
  {
    return new RedTouchInfo();
  }
  
  public int a()
  {
    if (this.i > 0) {
      return 2;
    }
    if (!TextUtils.isEmpty(this.b)) {
      return 4;
    }
    if (this.h > 0) {
      return 1;
    }
    if (this.j > 0) {
      return 3;
    }
    if (this.g > 0) {
      return 0;
    }
    return -1;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\redtouch\RedTouchInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */