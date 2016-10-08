package com.tencent.mobileqq.vipav;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class VipFullScreenVideoView
  extends VideoView
{
  public VipFullScreenVideoView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public VipFullScreenVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VipFullScreenVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vipav\VipFullScreenVideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */