package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.content.Context;

public abstract interface FrameParent
{
  public abstract Context getContext();
  
  public abstract void invalidate();
  
  public abstract void postInvalidate();
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\trimvideo\video\widget\FrameParent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */