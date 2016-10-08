package com.tencent.mobileqq.hotchat.anim;

import android.view.animation.Interpolator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class BezierInterpolator
  implements Interpolator
{
  public float a;
  public float b;
  public float c;
  public float d;
  
  private BezierInterpolator()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public BezierInterpolator(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.c = paramFloat3;
    this.b = paramFloat2;
    this.d = paramFloat4;
  }
  
  public float getInterpolation(float paramFloat)
  {
    return (float)(Math.pow(1.0F - paramFloat, 2.0D) * 3.0D * paramFloat * this.b + 3.0F * (1.0F - paramFloat) * Math.pow(paramFloat, 2.0D) * this.d + Math.pow(paramFloat, 3.0D));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\hotchat\anim\BezierInterpolator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */