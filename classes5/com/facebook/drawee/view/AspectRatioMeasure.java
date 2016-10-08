package com.facebook.drawee.view;

import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import javax.annotation.Nullable;

public class AspectRatioMeasure
{
  private static boolean shouldAdjust(int paramInt)
  {
    return (paramInt == 0) || (paramInt == -2);
  }
  
  public static void updateMeasureSpec(Spec paramSpec, float paramFloat, @Nullable ViewGroup.LayoutParams paramLayoutParams, int paramInt1, int paramInt2)
  {
    if ((paramFloat <= 0.0F) || (paramLayoutParams == null)) {}
    do
    {
      return;
      if (shouldAdjust(paramLayoutParams.height))
      {
        paramSpec.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int)((View.MeasureSpec.getSize(paramSpec.width) - paramInt1) / paramFloat + paramInt2), paramSpec.height), 1073741824);
        return;
      }
    } while (!shouldAdjust(paramLayoutParams.width));
    paramSpec.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int)((View.MeasureSpec.getSize(paramSpec.height) - paramInt2) * paramFloat + paramInt1), paramSpec.width), 1073741824);
  }
  
  public static class Spec
  {
    public int height;
    public int width;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\drawee\view\AspectRatioMeasure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */