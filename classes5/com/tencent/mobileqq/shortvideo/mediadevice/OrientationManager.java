package com.tencent.mobileqq.shortvideo.mediadevice;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class OrientationManager
  extends OrientationEventListener
{
  private int a;
  
  public OrientationManager(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (paramInt == -1) {}
    do
    {
      return;
      if ((paramInt > 315) || (paramInt < 45))
      {
        this.a = 90;
        return;
      }
      if ((paramInt > 45) && (paramInt < 135))
      {
        this.a = 180;
        return;
      }
      if ((paramInt > 135) && (paramInt < 225))
      {
        this.a = 270;
        return;
      }
    } while ((paramInt <= 225) || (paramInt >= 315));
    this.a = 0;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\mediadevice\OrientationManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */