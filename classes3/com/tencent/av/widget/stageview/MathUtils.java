package com.tencent.av.widget.stageview;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MathUtils
{
  public static final double a = 6.283185307179586D;
  static final double b = 0.017453292519943295D;
  
  public MathUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static double a(double paramDouble)
  {
    return (paramDouble % 6.283185307179586D + 6.283185307179586D) % 6.283185307179586D;
  }
  
  public static double a(double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    paramDouble1 = a(paramDouble1);
    paramDouble2 = a(paramDouble2);
    if (paramBoolean)
    {
      if (paramDouble1 > paramDouble2) {
        return paramDouble1 - paramDouble2;
      }
      return paramDouble1 + (6.283185307179586D - paramDouble2);
    }
    if (paramDouble1 > paramDouble2) {
      return 6.283185307179586D - paramDouble1 + paramDouble2;
    }
    return paramDouble2 - paramDouble1;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return (paramInt1 % paramInt2 + paramInt2) % paramInt2;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    paramInt1 = a(paramInt1, paramInt3);
    paramInt2 = a(paramInt2, paramInt3);
    if (paramBoolean)
    {
      if (paramInt1 > paramInt2) {
        return paramInt1 - paramInt2;
      }
      return paramInt1 + (paramInt3 - paramInt2);
    }
    if (paramInt1 > paramInt2) {
      return paramInt3 - paramInt1 + paramInt2;
    }
    return paramInt2 - paramInt1;
  }
  
  public static boolean a(double paramDouble1, double paramDouble2, boolean paramBoolean, double paramDouble3)
  {
    paramDouble1 = a(paramDouble1);
    paramDouble2 = a(paramDouble2);
    boolean bool;
    if (paramDouble2 > 3.141592653589793D) {
      if ((paramDouble1 > 3.141592653589793D) && (paramDouble1 <= paramDouble2)) {
        bool = true;
      }
    }
    while (paramBoolean) {
      if (!bool)
      {
        return true;
        bool = false;
        continue;
        if (paramDouble2 < 3.141592653589793D)
        {
          if ((paramDouble1 > 3.141592653589793D) || (paramDouble1 <= paramDouble2)) {
            bool = true;
          } else {
            bool = false;
          }
        }
        else {
          bool = true;
        }
      }
      else
      {
        return false;
      }
    }
    return bool;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\widget\stageview\MathUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */