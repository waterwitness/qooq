package com.tencent.mobileqq.maproam.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQMapView;

public class RoamingMapView
  extends QQMapView
{
  public static final int a = 0;
  public static final int b = 1;
  private int f;
  
  public RoamingMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.f = 0;
    setMapMode(this.f);
  }
  
  public int a()
  {
    return this.f;
  }
  
  public void setMapMode(int paramInt)
  {
    this.f = paramInt;
    if (1 == this.f)
    {
      setEnabled(true);
      return;
    }
    setEnabled(false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\maproam\widget\RoamingMapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */