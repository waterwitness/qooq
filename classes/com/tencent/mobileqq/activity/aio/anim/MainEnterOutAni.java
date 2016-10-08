package com.tencent.mobileqq.activity.aio.anim;

import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MainEnterOutAni
  extends TranslateAnimation
{
  public int a = 0;
  public boolean a;
  
  public MainEnterOutAni()
  {
    this(1, 0.0F, 1, -1.0F, 1, 0.0F, 1, 0.0F);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MainEnterOutAni(int paramInt1, float paramFloat1, int paramInt2, float paramFloat2, int paramInt3, float paramFloat3, int paramInt4, float paramFloat4)
  {
    super(paramInt1, paramFloat1, paramInt2, paramFloat2, paramInt3, paramFloat3, paramInt4, paramFloat4);
  }
  
  public boolean getTransformation(long paramLong, Transformation paramTransformation)
  {
    if (!AIOEnterInAni.a) {
      setStartTime(paramLong);
    }
    return super.getTransformation(paramLong, paramTransformation);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\anim\MainEnterOutAni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */