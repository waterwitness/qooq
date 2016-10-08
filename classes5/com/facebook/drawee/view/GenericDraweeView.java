package com.facebook.drawee.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.facebook.drawee.R.styleable;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import javax.annotation.Nullable;

public class GenericDraweeView
  extends DraweeView<GenericDraweeHierarchy>
{
  private float mAspectRatio = 0.0F;
  private final AspectRatioMeasure.Spec mMeasureSpec = new AspectRatioMeasure.Spec();
  
  public GenericDraweeView(Context paramContext)
  {
    super(paramContext);
    inflateHierarchy(paramContext, null);
  }
  
  public GenericDraweeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    inflateHierarchy(paramContext, paramAttributeSet);
  }
  
  public GenericDraweeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    inflateHierarchy(paramContext, paramAttributeSet);
  }
  
  public GenericDraweeView(Context paramContext, GenericDraweeHierarchy paramGenericDraweeHierarchy)
  {
    super(paramContext);
    setHierarchy(paramGenericDraweeHierarchy);
  }
  
  private static ScalingUtils.ScaleType getScaleTypeFromXml(TypedArray paramTypedArray, int paramInt, ScalingUtils.ScaleType paramScaleType)
  {
    paramInt = paramTypedArray.getInt(paramInt, -1);
    if (paramInt < 0) {
      return paramScaleType;
    }
    return ScalingUtils.ScaleType.values()[paramInt];
  }
  
  private void inflateHierarchy(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    Resources localResources = paramContext.getResources();
    int i1 = 300;
    int i4 = 0;
    ScalingUtils.ScaleType localScaleType8 = GenericDraweeHierarchyBuilder.DEFAULT_SCALE_TYPE;
    int i8 = 0;
    ScalingUtils.ScaleType localScaleType7 = GenericDraweeHierarchyBuilder.DEFAULT_SCALE_TYPE;
    int i2 = 0;
    ScalingUtils.ScaleType localScaleType6 = GenericDraweeHierarchyBuilder.DEFAULT_SCALE_TYPE;
    int i7 = 0;
    ScalingUtils.ScaleType localScaleType5 = GenericDraweeHierarchyBuilder.DEFAULT_SCALE_TYPE;
    Object localObject2 = GenericDraweeHierarchyBuilder.DEFAULT_ACTUAL_IMAGE_SCALE_TYPE;
    int n = 0;
    int i3 = 0;
    int i5 = 0;
    boolean bool1 = false;
    int i = 0;
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool3 = true;
    boolean bool2 = true;
    int j = 0;
    int m = 0;
    int k = 0;
    int i6 = 0;
    Object localObject1 = localObject2;
    ScalingUtils.ScaleType localScaleType4 = localScaleType6;
    ScalingUtils.ScaleType localScaleType3 = localScaleType8;
    ScalingUtils.ScaleType localScaleType1 = localScaleType5;
    ScalingUtils.ScaleType localScaleType2 = localScaleType7;
    if (paramAttributeSet != null) {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.GenericDraweeView);
    }
    for (;;)
    {
      try
      {
        i1 = paramContext.getInt(R.styleable.GenericDraweeView_fadeDuration, 300);
        this.mAspectRatio = paramContext.getFloat(R.styleable.GenericDraweeView_viewAspectRatio, this.mAspectRatio);
        i4 = paramContext.getResourceId(R.styleable.GenericDraweeView_placeholderImage, 0);
        localScaleType3 = getScaleTypeFromXml(paramContext, R.styleable.GenericDraweeView_placeholderImageScaleType, localScaleType8);
        i8 = paramContext.getResourceId(R.styleable.GenericDraweeView_retryImage, 0);
        localScaleType2 = getScaleTypeFromXml(paramContext, R.styleable.GenericDraweeView_retryImageScaleType, localScaleType7);
        i2 = paramContext.getResourceId(R.styleable.GenericDraweeView_failureImage, 0);
        localScaleType4 = getScaleTypeFromXml(paramContext, R.styleable.GenericDraweeView_failureImageScaleType, localScaleType6);
        i7 = paramContext.getResourceId(R.styleable.GenericDraweeView_progressBarImage, 0);
        localScaleType1 = getScaleTypeFromXml(paramContext, R.styleable.GenericDraweeView_progressBarImageScaleType, localScaleType5);
        i6 = paramContext.getInteger(R.styleable.GenericDraweeView_progressBarAutoRotateInterval, 0);
        localObject1 = getScaleTypeFromXml(paramContext, R.styleable.GenericDraweeView_actualImageScaleType, (ScalingUtils.ScaleType)localObject2);
        n = paramContext.getResourceId(R.styleable.GenericDraweeView_backgroundImage, 0);
        i3 = paramContext.getResourceId(R.styleable.GenericDraweeView_overlayImage, 0);
        i5 = paramContext.getResourceId(R.styleable.GenericDraweeView_pressedStateOverlayImage, 0);
        bool1 = paramContext.getBoolean(R.styleable.GenericDraweeView_roundAsCircle, false);
        i = paramContext.getDimensionPixelSize(R.styleable.GenericDraweeView_roundedCornerRadius, 0);
        bool4 = paramContext.getBoolean(R.styleable.GenericDraweeView_roundTopLeft, true);
        bool5 = paramContext.getBoolean(R.styleable.GenericDraweeView_roundTopRight, true);
        bool3 = paramContext.getBoolean(R.styleable.GenericDraweeView_roundBottomRight, true);
        bool2 = paramContext.getBoolean(R.styleable.GenericDraweeView_roundBottomLeft, true);
        j = paramContext.getColor(R.styleable.GenericDraweeView_roundWithOverlayColor, 0);
        m = paramContext.getDimensionPixelSize(R.styleable.GenericDraweeView_roundingBorderWidth, 0);
        k = paramContext.getColor(R.styleable.GenericDraweeView_roundingBorderColor, 0);
        paramContext.recycle();
        localObject2 = new GenericDraweeHierarchyBuilder(localResources);
        ((GenericDraweeHierarchyBuilder)localObject2).setFadeDuration(i1);
        if (i4 > 0) {
          ((GenericDraweeHierarchyBuilder)localObject2).setPlaceholderImage(localResources.getDrawable(i4), localScaleType3);
        }
        if (i8 > 0) {
          ((GenericDraweeHierarchyBuilder)localObject2).setRetryImage(localResources.getDrawable(i8), localScaleType2);
        }
        if (i2 > 0) {
          ((GenericDraweeHierarchyBuilder)localObject2).setFailureImage(localResources.getDrawable(i2), localScaleType4);
        }
        if (i7 > 0)
        {
          paramAttributeSet = localResources.getDrawable(i7);
          paramContext = paramAttributeSet;
          if (i6 > 0) {
            paramContext = new AutoRotateDrawable(paramAttributeSet, i6);
          }
          ((GenericDraweeHierarchyBuilder)localObject2).setProgressBarImage(paramContext, localScaleType1);
        }
        if (n > 0) {
          ((GenericDraweeHierarchyBuilder)localObject2).setBackground(localResources.getDrawable(n));
        }
        if (i3 > 0) {
          ((GenericDraweeHierarchyBuilder)localObject2).setOverlay(localResources.getDrawable(i3));
        }
        if (i5 > 0) {
          ((GenericDraweeHierarchyBuilder)localObject2).setPressedStateOverlay(getResources().getDrawable(i5));
        }
        ((GenericDraweeHierarchyBuilder)localObject2).setActualImageScaleType((ScalingUtils.ScaleType)localObject1);
        if ((bool1) || (i > 0))
        {
          paramContext = new RoundingParams();
          paramContext.setRoundAsCircle(bool1);
          if (i > 0)
          {
            if (bool4)
            {
              n = i;
              float f1 = n;
              if (!bool5) {
                break label710;
              }
              n = i;
              float f2 = n;
              if (!bool3) {
                break label716;
              }
              n = i;
              float f3 = n;
              if (!bool2) {
                break label722;
              }
              paramContext.setCornersRadii(f1, f2, f3, i);
            }
          }
          else
          {
            if (j != 0) {
              paramContext.setOverlayColor(j);
            }
            if ((k != 0) && (m > 0)) {
              paramContext.setBorder(k, m);
            }
            ((GenericDraweeHierarchyBuilder)localObject2).setRoundingParams(paramContext);
          }
        }
        else
        {
          setHierarchy(((GenericDraweeHierarchyBuilder)localObject2).build());
          return;
        }
      }
      finally
      {
        paramContext.recycle();
      }
      n = 0;
      continue;
      label710:
      n = 0;
      continue;
      label716:
      n = 0;
      continue;
      label722:
      i = 0;
    }
  }
  
  public float getAspectRatio()
  {
    return this.mAspectRatio;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.mMeasureSpec.width = paramInt1;
    this.mMeasureSpec.height = paramInt2;
    AspectRatioMeasure.updateMeasureSpec(this.mMeasureSpec, this.mAspectRatio, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
    super.onMeasure(this.mMeasureSpec.width, this.mMeasureSpec.height);
  }
  
  public void setAspectRatio(float paramFloat)
  {
    if (paramFloat == this.mAspectRatio) {
      return;
    }
    this.mAspectRatio = paramFloat;
    requestLayout();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\drawee\view\GenericDraweeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */