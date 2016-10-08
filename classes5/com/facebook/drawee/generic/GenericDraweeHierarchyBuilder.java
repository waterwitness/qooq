package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public class GenericDraweeHierarchyBuilder
{
  public static final ScalingUtils.ScaleType DEFAULT_ACTUAL_IMAGE_SCALE_TYPE = ScalingUtils.ScaleType.CENTER_CROP;
  public static final int DEFAULT_FADE_DURATION = 300;
  public static final ScalingUtils.ScaleType DEFAULT_SCALE_TYPE = ScalingUtils.ScaleType.CENTER_INSIDE;
  private ColorFilter mActualImageColorFilter;
  private PointF mActualImageFocusPoint;
  private Matrix mActualImageMatrix;
  private ScalingUtils.ScaleType mActualImageScaleType;
  private List<Drawable> mBackgrounds;
  private int mFadeDuration;
  private Drawable mFailureImage;
  private ScalingUtils.ScaleType mFailureImageScaleType;
  private List<Drawable> mOverlays;
  private Drawable mPlaceholderImage;
  @Nullable
  private ScalingUtils.ScaleType mPlaceholderImageScaleType;
  private Drawable mPressedStateOverlay;
  private Drawable mProgressBarImage;
  private ScalingUtils.ScaleType mProgressBarImageScaleType;
  private Resources mResources;
  private Drawable mRetryImage;
  private ScalingUtils.ScaleType mRetryImageScaleType;
  private RoundingParams mRoundingParams;
  
  public GenericDraweeHierarchyBuilder(Resources paramResources)
  {
    this.mResources = paramResources;
    init();
  }
  
  private void init()
  {
    this.mFadeDuration = 300;
    this.mPlaceholderImage = null;
    this.mPlaceholderImageScaleType = null;
    this.mRetryImage = null;
    this.mRetryImageScaleType = null;
    this.mFailureImage = null;
    this.mFailureImageScaleType = null;
    this.mProgressBarImage = null;
    this.mProgressBarImageScaleType = null;
    this.mActualImageScaleType = DEFAULT_ACTUAL_IMAGE_SCALE_TYPE;
    this.mActualImageMatrix = null;
    this.mActualImageFocusPoint = null;
    this.mBackgrounds = null;
    this.mOverlays = null;
    this.mPressedStateOverlay = null;
    this.mRoundingParams = null;
    this.mActualImageColorFilter = null;
  }
  
  public static GenericDraweeHierarchyBuilder newInstance(Resources paramResources)
  {
    return new GenericDraweeHierarchyBuilder(paramResources);
  }
  
  private void validate()
  {
    Iterator localIterator;
    if (this.mOverlays != null)
    {
      localIterator = this.mOverlays.iterator();
      if (localIterator.hasNext()) {}
    }
    else if (this.mBackgrounds != null)
    {
      localIterator = this.mBackgrounds.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        return;
        Preconditions.checkNotNull((Drawable)localIterator.next());
        break;
      }
      Preconditions.checkNotNull((Drawable)localIterator.next());
    }
  }
  
  public GenericDraweeHierarchy build()
  {
    validate();
    return new GenericDraweeHierarchy(this);
  }
  
  public ColorFilter getActualImageColorFilter()
  {
    return this.mActualImageColorFilter;
  }
  
  public PointF getActualImageFocusPoint()
  {
    return this.mActualImageFocusPoint;
  }
  
  public Matrix getActualImageMatrix()
  {
    return this.mActualImageMatrix;
  }
  
  public ScalingUtils.ScaleType getActualImageScaleType()
  {
    return this.mActualImageScaleType;
  }
  
  public List<Drawable> getBackgrounds()
  {
    return this.mBackgrounds;
  }
  
  public int getFadeDuration()
  {
    return this.mFadeDuration;
  }
  
  public Drawable getFailureImage()
  {
    return this.mFailureImage;
  }
  
  public ScalingUtils.ScaleType getFailureImageScaleType()
  {
    return this.mFailureImageScaleType;
  }
  
  public List<Drawable> getOverlays()
  {
    return this.mOverlays;
  }
  
  public Drawable getPlaceholderImage()
  {
    return this.mPlaceholderImage;
  }
  
  @Nullable
  public ScalingUtils.ScaleType getPlaceholderImageScaleType()
  {
    return this.mPlaceholderImageScaleType;
  }
  
  public Drawable getPressedStateOverlay()
  {
    return this.mPressedStateOverlay;
  }
  
  public Drawable getProgressBarImage()
  {
    return this.mProgressBarImage;
  }
  
  public ScalingUtils.ScaleType getProgressBarImageScaleType()
  {
    return this.mProgressBarImageScaleType;
  }
  
  public Resources getResources()
  {
    return this.mResources;
  }
  
  public Drawable getRetryImage()
  {
    return this.mRetryImage;
  }
  
  public ScalingUtils.ScaleType getRetryImageScaleType()
  {
    return this.mRetryImageScaleType;
  }
  
  public RoundingParams getRoundingParams()
  {
    return this.mRoundingParams;
  }
  
  public GenericDraweeHierarchyBuilder reset()
  {
    init();
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setActualImageColorFilter(ColorFilter paramColorFilter)
  {
    this.mActualImageColorFilter = paramColorFilter;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setActualImageFocusPoint(PointF paramPointF)
  {
    this.mActualImageFocusPoint = paramPointF;
    return this;
  }
  
  @Deprecated
  public GenericDraweeHierarchyBuilder setActualImageMatrix(Matrix paramMatrix)
  {
    this.mActualImageMatrix = paramMatrix;
    this.mActualImageScaleType = null;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setActualImageScaleType(ScalingUtils.ScaleType paramScaleType)
  {
    this.mActualImageScaleType = paramScaleType;
    this.mActualImageMatrix = null;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setBackground(Drawable paramDrawable)
  {
    this.mBackgrounds = Arrays.asList(new Drawable[] { paramDrawable });
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setBackgrounds(List<Drawable> paramList)
  {
    this.mBackgrounds = paramList;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setFadeDuration(int paramInt)
  {
    this.mFadeDuration = paramInt;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setFailureImage(Drawable paramDrawable)
  {
    return setFailureImage(paramDrawable, DEFAULT_SCALE_TYPE);
  }
  
  public GenericDraweeHierarchyBuilder setFailureImage(Drawable paramDrawable, ScalingUtils.ScaleType paramScaleType)
  {
    this.mFailureImage = paramDrawable;
    this.mFailureImageScaleType = paramScaleType;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setOverlay(Drawable paramDrawable)
  {
    this.mOverlays = Arrays.asList(new Drawable[] { paramDrawable });
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setOverlays(List<Drawable> paramList)
  {
    this.mOverlays = paramList;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setPlaceholderImage(Drawable paramDrawable)
  {
    return setPlaceholderImage(paramDrawable, DEFAULT_SCALE_TYPE);
  }
  
  public GenericDraweeHierarchyBuilder setPlaceholderImage(Drawable paramDrawable, @Nullable ScalingUtils.ScaleType paramScaleType)
  {
    this.mPlaceholderImage = paramDrawable;
    this.mPlaceholderImageScaleType = paramScaleType;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setPressedStateOverlay(Drawable paramDrawable)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, paramDrawable);
    this.mPressedStateOverlay = localStateListDrawable;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setProgressBarImage(Drawable paramDrawable)
  {
    return setProgressBarImage(paramDrawable, DEFAULT_SCALE_TYPE);
  }
  
  public GenericDraweeHierarchyBuilder setProgressBarImage(Drawable paramDrawable, ScalingUtils.ScaleType paramScaleType)
  {
    this.mProgressBarImage = paramDrawable;
    this.mProgressBarImageScaleType = paramScaleType;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setRetryImage(Drawable paramDrawable)
  {
    return setRetryImage(paramDrawable, DEFAULT_SCALE_TYPE);
  }
  
  public GenericDraweeHierarchyBuilder setRetryImage(Drawable paramDrawable, ScalingUtils.ScaleType paramScaleType)
  {
    this.mRetryImage = paramDrawable;
    this.mRetryImageScaleType = paramScaleType;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setRoundingParams(RoundingParams paramRoundingParams)
  {
    this.mRoundingParams = paramRoundingParams;
    return this;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\drawee\generic\GenericDraweeHierarchyBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */