package com.facebook.csslayout;

import java.util.Arrays;
import javax.annotation.Nullable;

public class Spacing
{
  public static final int ALL = 8;
  public static final int BOTTOM = 3;
  public static final int END = 7;
  public static final int HORIZONTAL = 5;
  public static final int LEFT = 0;
  public static final int RIGHT = 2;
  public static final int START = 6;
  public static final int TOP = 1;
  public static final int VERTICAL = 4;
  private static final int[] sFlagsMap = { 1, 2, 4, 8, 16, 32, 64, 128, 256 };
  @Nullable
  private float[] mDefaultSpacing = null;
  private boolean mHasAliasesSet;
  private final float[] mSpacing = newFullSpacingArray();
  private int mValueFlags = 0;
  
  private static float[] newFullSpacingArray()
  {
    return new float[] { NaN.0F, NaN.0F, NaN.0F, NaN.0F, NaN.0F, NaN.0F, NaN.0F, NaN.0F, NaN.0F };
  }
  
  private static float[] newSpacingResultArray()
  {
    return newSpacingResultArray(0.0F);
  }
  
  private static float[] newSpacingResultArray(float paramFloat)
  {
    return new float[] { paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, NaN.0F, NaN.0F, paramFloat };
  }
  
  public float get(int paramInt)
  {
    float f;
    if (this.mDefaultSpacing != null)
    {
      f = this.mDefaultSpacing[paramInt];
      if (this.mValueFlags != 0) {
        break label46;
      }
    }
    label46:
    do
    {
      do
      {
        return f;
        if ((paramInt == 6) || (paramInt == 7))
        {
          f = NaN.0F;
          break;
        }
        f = 0.0F;
        break;
        if ((this.mValueFlags & sFlagsMap[paramInt]) != 0) {
          return this.mSpacing[paramInt];
        }
      } while (!this.mHasAliasesSet);
      if ((paramInt == 1) || (paramInt == 3)) {}
      for (paramInt = 4; (this.mValueFlags & sFlagsMap[paramInt]) != 0; paramInt = 5) {
        return this.mSpacing[paramInt];
      }
    } while ((this.mValueFlags & sFlagsMap[8]) == 0);
    return this.mSpacing[8];
  }
  
  public float getRaw(int paramInt)
  {
    return this.mSpacing[paramInt];
  }
  
  float getWithFallback(int paramInt1, int paramInt2)
  {
    if ((this.mValueFlags & sFlagsMap[paramInt1]) != 0) {
      return this.mSpacing[paramInt1];
    }
    return get(paramInt2);
  }
  
  void reset()
  {
    Arrays.fill(this.mSpacing, NaN.0F);
    this.mDefaultSpacing = null;
    this.mHasAliasesSet = false;
    this.mValueFlags = 0;
  }
  
  public boolean set(int paramInt, float paramFloat)
  {
    boolean bool = false;
    if (!FloatUtil.floatsEqual(this.mSpacing[paramInt], paramFloat))
    {
      this.mSpacing[paramInt] = paramFloat;
      if (CSSConstants.isUndefined(paramFloat)) {}
      for (this.mValueFlags &= (sFlagsMap[paramInt] ^ 0xFFFFFFFF);; this.mValueFlags |= sFlagsMap[paramInt])
      {
        if (((this.mValueFlags & sFlagsMap[8]) != 0) || ((this.mValueFlags & sFlagsMap[4]) != 0) || ((this.mValueFlags & sFlagsMap[5]) != 0)) {
          bool = true;
        }
        this.mHasAliasesSet = bool;
        return true;
      }
    }
    return false;
  }
  
  public boolean setDefault(int paramInt, float paramFloat)
  {
    if (this.mDefaultSpacing == null) {
      this.mDefaultSpacing = newSpacingResultArray();
    }
    if (!FloatUtil.floatsEqual(this.mDefaultSpacing[paramInt], paramFloat))
    {
      this.mDefaultSpacing[paramInt] = paramFloat;
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\csslayout\Spacing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */