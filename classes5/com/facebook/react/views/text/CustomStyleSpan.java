package com.facebook.react.views.text;

import android.content.res.AssetManager;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import javax.annotation.Nullable;

public class CustomStyleSpan
  extends MetricAffectingSpan
{
  private final AssetManager mAssetManager;
  @Nullable
  private final String mFontFamily;
  private final int mStyle;
  private final int mWeight;
  
  public CustomStyleSpan(int paramInt1, int paramInt2, @Nullable String paramString, AssetManager paramAssetManager)
  {
    this.mStyle = paramInt1;
    this.mWeight = paramInt2;
    this.mFontFamily = paramString;
    this.mAssetManager = paramAssetManager;
  }
  
  private static void apply(Paint paramPaint, int paramInt1, int paramInt2, @Nullable String paramString, AssetManager paramAssetManager)
  {
    Typeface localTypeface = paramPaint.getTypeface();
    int j;
    if (localTypeface == null)
    {
      j = 0;
      int k = 0;
      int i;
      if (paramInt2 != 1)
      {
        i = k;
        if ((j & 0x1) != 0)
        {
          i = k;
          if (paramInt2 != -1) {}
        }
      }
      else
      {
        i = 0x0 | 0x1;
      }
      if (paramInt1 != 2)
      {
        paramInt2 = i;
        if ((j & 0x2) != 0)
        {
          paramInt2 = i;
          if (paramInt1 != -1) {}
        }
      }
      else
      {
        paramInt2 = i | 0x2;
      }
      if (paramString == null) {
        break label111;
      }
      paramString = ReactFontManager.getInstance().getTypeface(paramString, paramInt2, paramAssetManager);
    }
    for (;;)
    {
      if (paramString == null) {
        break label129;
      }
      paramPaint.setTypeface(paramString);
      return;
      j = localTypeface.getStyle();
      break;
      label111:
      paramString = localTypeface;
      if (localTypeface != null) {
        paramString = Typeface.create(localTypeface, paramInt2);
      }
    }
    label129:
    paramPaint.setTypeface(Typeface.defaultFromStyle(paramInt2));
  }
  
  @Nullable
  public String getFontFamily()
  {
    return this.mFontFamily;
  }
  
  public int getStyle()
  {
    if (this.mStyle == -1) {
      return 0;
    }
    return this.mStyle;
  }
  
  public int getWeight()
  {
    if (this.mWeight == -1) {
      return 0;
    }
    return this.mWeight;
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    apply(paramTextPaint, this.mStyle, this.mWeight, this.mFontFamily, this.mAssetManager);
  }
  
  public void updateMeasureState(TextPaint paramTextPaint)
  {
    apply(paramTextPaint, this.mStyle, this.mWeight, this.mFontFamily, this.mAssetManager);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\text\CustomStyleSpan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */