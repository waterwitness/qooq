package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ImageViewTouche
  extends ImageViewTouchBase
{
  private boolean mEnableTrackballScroll;
  private Bitmap region;
  private boolean showRegion;
  
  public ImageViewTouche(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ImageViewTouche(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void postTranslateCenter(float paramFloat1, float paramFloat2)
  {
    super.postTranslate(paramFloat1, paramFloat2);
    center(true, true);
  }
  
  public void setEnableTrackballScroll(boolean paramBoolean)
  {
    this.mEnableTrackballScroll = paramBoolean;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\ImageViewTouche.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */