package com.etrump.mixlayout;

import android.graphics.Typeface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ETFont
{
  public static final int ET_COLOR_BLACK = -16777216;
  public static final int ET_FONT_STYLE_BOLD = 1;
  public static final int ET_FONT_STYLE_CROCHET = 8;
  public static final int ET_FONT_STYLE_SHADOW = 128;
  private int mCrochetColor;
  private int mCrochetWidth;
  private boolean mDisableBackground;
  private boolean mDisableCrochet;
  private boolean mDisableShadow;
  public int mFontColor;
  public int mFontId;
  public String mFontPath;
  private int mFontSize;
  private final int mFontSizeMin;
  private int mFontStyle;
  public int mFontType;
  private int mShadowBlurRadius;
  private int mShadowColor;
  private int mShadowOffsetX;
  private int mShadowOffsetY;
  public Typeface mTypeface;
  
  public ETFont(int paramInt, String paramString, float paramFloat)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mFontSizeMin = 8;
    this.mDisableShadow = true;
    this.mDisableCrochet = true;
    this.mFontId = paramInt;
    this.mFontPath = paramString;
    setSize(paramFloat);
    this.mFontColor = -16777216;
    this.mFontStyle = 0;
  }
  
  public ETFont(int paramInt1, String paramString, float paramFloat, int paramInt2, Typeface paramTypeface)
  {
    this.mFontSizeMin = 8;
    this.mDisableShadow = true;
    this.mDisableCrochet = true;
    this.mFontId = paramInt1;
    this.mFontPath = paramString;
    setSize(paramFloat);
    this.mFontColor = -16777216;
    this.mFontStyle = 0;
    this.mFontType = paramInt2;
    this.mTypeface = paramTypeface;
  }
  
  public void copy(ETFont paramETFont)
  {
    if (paramETFont != null)
    {
      this.mFontId = paramETFont.mFontId;
      this.mFontPath = paramETFont.mFontPath;
      this.mFontSize = paramETFont.mFontSize;
      this.mFontColor = paramETFont.mFontColor;
      this.mFontStyle = paramETFont.mFontStyle;
      this.mShadowColor = paramETFont.mShadowColor;
      this.mShadowOffsetX = paramETFont.mShadowOffsetX;
      this.mShadowOffsetY = paramETFont.mShadowOffsetY;
      this.mShadowBlurRadius = paramETFont.mShadowBlurRadius;
      this.mCrochetColor = paramETFont.mCrochetColor;
      this.mCrochetWidth = paramETFont.mCrochetWidth;
      this.mDisableBackground = paramETFont.mDisableBackground;
      this.mDisableShadow = paramETFont.mDisableShadow;
      this.mDisableCrochet = paramETFont.mDisableCrochet;
    }
  }
  
  public void disableEffects(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.mDisableBackground = paramBoolean1;
    this.mDisableShadow = paramBoolean2;
    this.mDisableCrochet = paramBoolean3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (ETFont)paramObject;
    } while ((this.mFontId != ((ETFont)paramObject).mFontId) || (this.mFontColor != ((ETFont)paramObject).mFontColor) || (this.mFontSize != ((ETFont)paramObject).mFontSize) || (this.mFontStyle != ((ETFont)paramObject).mFontStyle));
    return true;
  }
  
  public int getColor()
  {
    return this.mFontColor;
  }
  
  public int getId()
  {
    return this.mFontId;
  }
  
  public String getPath()
  {
    return this.mFontPath;
  }
  
  public int getSize()
  {
    return this.mFontSize;
  }
  
  public boolean isBold()
  {
    return (this.mFontStyle & 0x1) != 0;
  }
  
  public void setBold(boolean paramBoolean)
  {
    if (true == paramBoolean)
    {
      this.mFontStyle |= 0x1;
      return;
    }
    this.mFontStyle &= 0xFFFFFFFE;
  }
  
  public void setColor(int paramInt)
  {
    this.mFontColor = paramInt;
  }
  
  public void setCrochet(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      this.mCrochetColor = paramInt1;
      this.mCrochetWidth = paramInt2;
      this.mFontStyle |= 0x8;
      return;
    }
    this.mFontStyle &= 0xFFFFFFF7;
  }
  
  public void setId(int paramInt)
  {
    this.mFontId = paramInt;
  }
  
  public void setPath(String paramString)
  {
    this.mFontPath = paramString;
  }
  
  public void setShadow(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean == true)
    {
      this.mShadowColor = paramInt1;
      this.mShadowOffsetX = paramInt2;
      this.mShadowOffsetY = paramInt3;
      this.mShadowBlurRadius = paramInt4;
      this.mFontStyle |= 0x80;
      return;
    }
    this.mFontStyle &= 0xFF7F;
  }
  
  public void setSize(float paramFloat)
  {
    int i = 8;
    int j = (int)paramFloat;
    if (j < 8) {}
    for (;;)
    {
      this.mFontSize = i;
      return;
      i = j;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\etrump\mixlayout\ETFont.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */