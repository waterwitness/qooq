package com.facebook.drawee.generic;

import com.facebook.common.internal.Preconditions;
import java.util.Arrays;

public class RoundingParams
{
  private int mBorderColor = 0;
  private float mBorderWidth = 0.0F;
  private float[] mCornersRadii = null;
  private int mOverlayColor = 0;
  private boolean mRoundAsCircle = false;
  private RoundingMethod mRoundingMethod = RoundingMethod.BITMAP_ONLY;
  
  public static RoundingParams asCircle()
  {
    return new RoundingParams().setRoundAsCircle(true);
  }
  
  public static RoundingParams fromCornersRadii(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return new RoundingParams().setCornersRadii(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public static RoundingParams fromCornersRadii(float[] paramArrayOfFloat)
  {
    return new RoundingParams().setCornersRadii(paramArrayOfFloat);
  }
  
  public static RoundingParams fromCornersRadius(float paramFloat)
  {
    return new RoundingParams().setCornersRadius(paramFloat);
  }
  
  private float[] getOrCreateRoundedCornersRadii()
  {
    if (this.mCornersRadii == null) {
      this.mCornersRadii = new float[8];
    }
    return this.mCornersRadii;
  }
  
  public int getBorderColor()
  {
    return this.mBorderColor;
  }
  
  public float getBorderWidth()
  {
    return this.mBorderWidth;
  }
  
  public float[] getCornersRadii()
  {
    return this.mCornersRadii;
  }
  
  public int getOverlayColor()
  {
    return this.mOverlayColor;
  }
  
  public boolean getRoundAsCircle()
  {
    return this.mRoundAsCircle;
  }
  
  public RoundingMethod getRoundingMethod()
  {
    return this.mRoundingMethod;
  }
  
  public RoundingParams setBorder(int paramInt, float paramFloat)
  {
    if (paramFloat >= 0.0F) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "the border width cannot be < 0");
      this.mBorderWidth = paramFloat;
      this.mBorderColor = paramInt;
      return this;
    }
  }
  
  public RoundingParams setCornersRadii(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float[] arrayOfFloat = getOrCreateRoundedCornersRadii();
    arrayOfFloat[1] = paramFloat1;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[3] = paramFloat2;
    arrayOfFloat[2] = paramFloat2;
    arrayOfFloat[5] = paramFloat3;
    arrayOfFloat[4] = paramFloat3;
    arrayOfFloat[7] = paramFloat4;
    arrayOfFloat[6] = paramFloat4;
    return this;
  }
  
  public RoundingParams setCornersRadii(float[] paramArrayOfFloat)
  {
    Preconditions.checkNotNull(paramArrayOfFloat);
    if (paramArrayOfFloat.length == 8) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "radii should have exactly 8 values");
      System.arraycopy(paramArrayOfFloat, 0, getOrCreateRoundedCornersRadii(), 0, 8);
      return this;
    }
  }
  
  public RoundingParams setCornersRadius(float paramFloat)
  {
    Arrays.fill(getOrCreateRoundedCornersRadii(), paramFloat);
    return this;
  }
  
  public RoundingParams setOverlayColor(int paramInt)
  {
    this.mOverlayColor = paramInt;
    this.mRoundingMethod = RoundingMethod.OVERLAY_COLOR;
    return this;
  }
  
  public RoundingParams setRoundAsCircle(boolean paramBoolean)
  {
    this.mRoundAsCircle = paramBoolean;
    return this;
  }
  
  public RoundingParams setRoundingMethod(RoundingMethod paramRoundingMethod)
  {
    this.mRoundingMethod = paramRoundingMethod;
    return this;
  }
  
  public static enum RoundingMethod
  {
    OVERLAY_COLOR,  BITMAP_ONLY;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\drawee\generic\RoundingParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */