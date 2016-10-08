package com.facebook.drawee.generic;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.MatrixDrawable;
import com.facebook.drawee.drawable.Rounded;
import com.facebook.drawee.drawable.RoundedBitmapDrawable;
import com.facebook.drawee.drawable.RoundedColorDrawable;
import com.facebook.drawee.drawable.RoundedCornersDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.drawable.SettableDrawable;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.drawable.VisibilityCallback;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public class GenericDraweeHierarchy
  implements SettableDraweeHierarchy
{
  private final int mActualImageIndex;
  private final SettableDrawable mActualImageSettableDrawable;
  private final int mControllerOverlayIndex;
  private final Drawable mEmptyActualImageDrawable = new ColorDrawable(0);
  private final Drawable mEmptyControllerOverlayDrawable = new ColorDrawable(0);
  private Drawable mEmptyPlaceholderDrawable;
  private final FadeDrawable mFadeDrawable;
  private final int mFailureImageIndex;
  private final int mPlaceholderImageIndex;
  private final int mProgressBarImageIndex;
  private final Resources mResources;
  private final int mRetryImageIndex;
  private RoundingParams mRoundingParams;
  private final RootDrawable mTopLevelDrawable;
  
  GenericDraweeHierarchy(GenericDraweeHierarchyBuilder paramGenericDraweeHierarchyBuilder)
  {
    this.mResources = paramGenericDraweeHierarchyBuilder.getResources();
    this.mRoundingParams = paramGenericDraweeHierarchyBuilder.getRoundingParams();
    int i;
    int k;
    Object localObject1;
    int j;
    Object localObject4;
    int m;
    label301:
    label311:
    Iterator localIterator;
    if (paramGenericDraweeHierarchyBuilder.getBackgrounds() != null)
    {
      i = paramGenericDraweeHierarchyBuilder.getBackgrounds().size();
      k = 0 + i;
      Object localObject2 = paramGenericDraweeHierarchyBuilder.getPlaceholderImage();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = getEmptyPlaceholderDrawable();
      }
      Drawable localDrawable1 = maybeWrapWithScaleType(maybeApplyRoundingBitmapOnly(this.mRoundingParams, this.mResources, (Drawable)localObject1), paramGenericDraweeHierarchyBuilder.getPlaceholderImageScaleType());
      j = k + 1;
      this.mPlaceholderImageIndex = k;
      this.mActualImageSettableDrawable = new SettableDrawable(this.mEmptyActualImageDrawable);
      Drawable localDrawable2 = maybeWrapWithMatrix(maybeWrapWithScaleType(this.mActualImageSettableDrawable, paramGenericDraweeHierarchyBuilder.getActualImageScaleType(), paramGenericDraweeHierarchyBuilder.getActualImageFocusPoint()), paramGenericDraweeHierarchyBuilder.getActualImageMatrix());
      localDrawable2.setColorFilter(paramGenericDraweeHierarchyBuilder.getActualImageColorFilter());
      k = j + 1;
      this.mActualImageIndex = j;
      localObject2 = paramGenericDraweeHierarchyBuilder.getProgressBarImage();
      j = k + 1;
      this.mProgressBarImageIndex = k;
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = maybeWrapWithScaleType((Drawable)localObject2, paramGenericDraweeHierarchyBuilder.getProgressBarImageScaleType());
      }
      Object localObject3 = paramGenericDraweeHierarchyBuilder.getRetryImage();
      k = j + 1;
      this.mRetryImageIndex = j;
      localObject2 = localObject3;
      if (localObject3 != null) {
        localObject2 = maybeWrapWithScaleType((Drawable)localObject3, paramGenericDraweeHierarchyBuilder.getRetryImageScaleType());
      }
      localObject4 = paramGenericDraweeHierarchyBuilder.getFailureImage();
      m = k + 1;
      this.mFailureImageIndex = k;
      localObject3 = localObject4;
      if (localObject4 != null) {
        localObject3 = maybeWrapWithScaleType((Drawable)localObject4, paramGenericDraweeHierarchyBuilder.getFailureImageScaleType());
      }
      if (paramGenericDraweeHierarchyBuilder.getOverlays() == null) {
        break label555;
      }
      j = paramGenericDraweeHierarchyBuilder.getOverlays().size();
      if (paramGenericDraweeHierarchyBuilder.getPressedStateOverlay() == null) {
        break label561;
      }
      k = 1;
      j += k;
      k = m + j;
      this.mControllerOverlayIndex = k;
      localObject4 = new Drawable[k + 1];
      if (i > 0)
      {
        i = 0;
        localIterator = paramGenericDraweeHierarchyBuilder.getBackgrounds().iterator();
        label359:
        if (localIterator.hasNext()) {
          break label567;
        }
      }
      localObject4[this.mPlaceholderImageIndex] = localDrawable1;
      localObject4[this.mActualImageIndex] = localDrawable2;
      localObject4[this.mProgressBarImageIndex] = localObject1;
      localObject4[this.mRetryImageIndex] = localObject2;
      localObject4[this.mFailureImageIndex] = localObject3;
      if (j > 0)
      {
        i = 0;
        j = 0;
        if (paramGenericDraweeHierarchyBuilder.getOverlays() != null)
        {
          localObject1 = paramGenericDraweeHierarchyBuilder.getOverlays().iterator();
          i = j;
        }
      }
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext())
      {
        if (paramGenericDraweeHierarchyBuilder.getPressedStateOverlay() != null) {
          localObject4[(m + i)] = paramGenericDraweeHierarchyBuilder.getPressedStateOverlay();
        }
        if (this.mControllerOverlayIndex >= 0) {
          localObject4[this.mControllerOverlayIndex] = this.mEmptyControllerOverlayDrawable;
        }
        this.mFadeDrawable = new FadeDrawable((Drawable[])localObject4);
        this.mFadeDrawable.setTransitionDuration(paramGenericDraweeHierarchyBuilder.getFadeDuration());
        this.mTopLevelDrawable = new RootDrawable(maybeWrapWithRoundedOverlayColor(this.mRoundingParams, this.mFadeDrawable));
        this.mTopLevelDrawable.mutate();
        resetFade();
        return;
        i = 0;
        break;
        label555:
        j = 0;
        break label301;
        label561:
        k = 0;
        break label311;
        label567:
        Drawable localDrawable3 = (Drawable)localIterator.next();
        localObject4[(i + 0)] = maybeApplyRoundingBitmapOnly(this.mRoundingParams, this.mResources, localDrawable3);
        i += 1;
        break label359;
      }
      localObject4[(m + i)] = ((Drawable)((Iterator)localObject1).next());
      i += 1;
    }
  }
  
  private static Drawable applyRounding(@Nullable RoundingParams paramRoundingParams, Resources paramResources, Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramResources = RoundedBitmapDrawable.fromBitmapDrawable(paramResources, (BitmapDrawable)paramDrawable);
      applyRoundingParams(paramResources, paramRoundingParams);
      return paramResources;
    }
    if (((paramDrawable instanceof ColorDrawable)) && (Build.VERSION.SDK_INT >= 11))
    {
      paramResources = RoundedColorDrawable.fromColorDrawable((ColorDrawable)paramDrawable);
      applyRoundingParams(paramResources, paramRoundingParams);
      return paramResources;
    }
    return paramDrawable;
  }
  
  private static void applyRoundingParams(Rounded paramRounded, RoundingParams paramRoundingParams)
  {
    paramRounded.setCircle(paramRoundingParams.getRoundAsCircle());
    paramRounded.setRadii(paramRoundingParams.getCornersRadii());
    paramRounded.setBorder(paramRoundingParams.getBorderColor(), paramRoundingParams.getBorderWidth());
  }
  
  private void fadeInLayer(int paramInt)
  {
    if (paramInt >= 0) {
      this.mFadeDrawable.fadeInLayer(paramInt);
    }
  }
  
  private void fadeOutBranches()
  {
    fadeOutLayer(this.mPlaceholderImageIndex);
    fadeOutLayer(this.mActualImageIndex);
    fadeOutLayer(this.mProgressBarImageIndex);
    fadeOutLayer(this.mRetryImageIndex);
    fadeOutLayer(this.mFailureImageIndex);
  }
  
  private void fadeOutLayer(int paramInt)
  {
    if (paramInt >= 0) {
      this.mFadeDrawable.fadeOutLayer(paramInt);
    }
  }
  
  @Nullable
  private ScaleTypeDrawable findLayerScaleTypeDrawable(int paramInt)
  {
    Drawable localDrawable2 = this.mFadeDrawable.getDrawable(paramInt);
    Drawable localDrawable1 = localDrawable2;
    if ((localDrawable2 instanceof MatrixDrawable)) {
      localDrawable1 = localDrawable2.getCurrent();
    }
    if ((localDrawable1 instanceof ScaleTypeDrawable)) {
      return (ScaleTypeDrawable)localDrawable1;
    }
    return null;
  }
  
  private Drawable getEmptyPlaceholderDrawable()
  {
    if (this.mEmptyPlaceholderDrawable == null) {
      this.mEmptyPlaceholderDrawable = new ColorDrawable(0);
    }
    return this.mEmptyPlaceholderDrawable;
  }
  
  private Drawable getLayerChildDrawable(int paramInt)
  {
    return getLayerDrawable(paramInt, false);
  }
  
  private Drawable getLayerDrawable(int paramInt, boolean paramBoolean)
  {
    Object localObject2 = this.mFadeDrawable;
    Object localObject3 = this.mFadeDrawable.getDrawable(paramInt);
    Object localObject1 = localObject3;
    if ((localObject3 instanceof MatrixDrawable))
    {
      localObject2 = localObject3;
      localObject1 = ((Drawable)localObject2).getCurrent();
    }
    localObject3 = localObject1;
    if ((localObject1 instanceof ScaleTypeDrawable))
    {
      localObject3 = ((Drawable)localObject1).getCurrent();
      localObject2 = localObject1;
    }
    if (paramBoolean) {
      return (Drawable)localObject2;
    }
    return (Drawable)localObject3;
  }
  
  private static Drawable maybeApplyRoundingBitmapOnly(@Nullable RoundingParams paramRoundingParams, Resources paramResources, Drawable paramDrawable)
  {
    if ((paramRoundingParams == null) || (paramRoundingParams.getRoundingMethod() != RoundingParams.RoundingMethod.BITMAP_ONLY)) {}
    for (;;)
    {
      return paramDrawable;
      if (((paramDrawable instanceof BitmapDrawable)) || ((paramDrawable instanceof ColorDrawable))) {
        return applyRounding(paramRoundingParams, paramResources, paramDrawable);
      }
      Object localObject = paramDrawable;
      for (Drawable localDrawable = ((Drawable)localObject).getCurrent(); (localDrawable != null) && (localObject != localDrawable); localDrawable = ((Drawable)localObject).getCurrent())
      {
        if (((localObject instanceof ForwardingDrawable)) && (((localDrawable instanceof BitmapDrawable)) || ((localDrawable instanceof ColorDrawable)))) {
          ((ForwardingDrawable)localObject).setCurrent(applyRounding(paramRoundingParams, paramResources, localDrawable));
        }
        localObject = localDrawable;
      }
    }
  }
  
  private static Drawable maybeWrapWithMatrix(Drawable paramDrawable, @Nullable Matrix paramMatrix)
  {
    Preconditions.checkNotNull(paramDrawable);
    if (paramMatrix == null) {
      return paramDrawable;
    }
    return new MatrixDrawable(paramDrawable, paramMatrix);
  }
  
  private static Drawable maybeWrapWithRoundedOverlayColor(@Nullable RoundingParams paramRoundingParams, Drawable paramDrawable)
  {
    if ((paramRoundingParams != null) && (paramRoundingParams.getRoundingMethod() == RoundingParams.RoundingMethod.OVERLAY_COLOR))
    {
      paramDrawable = new RoundedCornersDrawable(paramDrawable);
      applyRoundingParams(paramDrawable, paramRoundingParams);
      paramDrawable.setOverlayColor(paramRoundingParams.getOverlayColor());
      return paramDrawable;
    }
    return paramDrawable;
  }
  
  private static Drawable maybeWrapWithScaleType(Drawable paramDrawable, @Nullable ScalingUtils.ScaleType paramScaleType)
  {
    return maybeWrapWithScaleType(paramDrawable, paramScaleType, null);
  }
  
  private static Drawable maybeWrapWithScaleType(Drawable paramDrawable, @Nullable ScalingUtils.ScaleType paramScaleType, @Nullable PointF paramPointF)
  {
    Preconditions.checkNotNull(paramDrawable);
    if (paramScaleType == null) {
      return paramDrawable;
    }
    paramDrawable = new ScaleTypeDrawable(paramDrawable, paramScaleType);
    if (paramPointF != null) {
      paramDrawable.setFocusPoint(paramPointF);
    }
    return paramDrawable;
  }
  
  private void resetActualImages()
  {
    if (this.mActualImageSettableDrawable != null) {
      this.mActualImageSettableDrawable.setDrawable(this.mEmptyActualImageDrawable);
    }
  }
  
  private void resetFade()
  {
    if (this.mFadeDrawable != null)
    {
      this.mFadeDrawable.beginBatchMode();
      this.mFadeDrawable.fadeInAllLayers();
      fadeOutBranches();
      fadeInLayer(this.mPlaceholderImageIndex);
      this.mFadeDrawable.finishTransitionImmediately();
      this.mFadeDrawable.endBatchMode();
    }
  }
  
  private static void resetRoundedDrawable(Rounded paramRounded)
  {
    paramRounded.setCircle(false);
    paramRounded.setRadius(0.0F);
    paramRounded.setBorder(0, 0.0F);
  }
  
  private void setDrawableAndScaleType(@Nullable Drawable paramDrawable, @Nullable ScalingUtils.ScaleType paramScaleType, int paramInt)
  {
    if (paramDrawable == null)
    {
      this.mFadeDrawable.setDrawable(paramInt, null);
      return;
    }
    Drawable localDrawable = maybeApplyRoundingBitmapOnly(this.mRoundingParams, this.mResources, paramDrawable);
    paramDrawable = localDrawable;
    if (paramScaleType != null)
    {
      paramDrawable = findLayerScaleTypeDrawable(paramInt);
      if (paramDrawable == null) {
        break label60;
      }
      paramDrawable.setScaleType(paramScaleType);
    }
    label60:
    for (paramDrawable = localDrawable;; paramDrawable = maybeWrapWithScaleType(localDrawable, paramScaleType))
    {
      setLayerChildDrawable(paramInt, paramDrawable);
      return;
    }
  }
  
  private void setLayerChildDrawable(int paramInt, Drawable paramDrawable)
  {
    Drawable localDrawable = getLayerDrawable(paramInt, true);
    if (localDrawable == this.mFadeDrawable)
    {
      this.mFadeDrawable.setDrawable(paramInt, paramDrawable);
      return;
    }
    ((ForwardingDrawable)localDrawable).setCurrent(paramDrawable);
  }
  
  private void setProgress(float paramFloat)
  {
    Drawable localDrawable = getLayerChildDrawable(this.mProgressBarImageIndex);
    if (localDrawable == null) {
      return;
    }
    if (paramFloat >= 0.999F)
    {
      if ((localDrawable instanceof Animatable)) {
        ((Animatable)localDrawable).stop();
      }
      fadeOutLayer(this.mProgressBarImageIndex);
    }
    for (;;)
    {
      localDrawable.setLevel(Math.round(10000.0F * paramFloat));
      return;
      if ((localDrawable instanceof Animatable)) {
        ((Animatable)localDrawable).start();
      }
      fadeInLayer(this.mProgressBarImageIndex);
    }
  }
  
  private void updateBitmapOnlyRounding()
  {
    int i;
    if ((this.mRoundingParams != null) && (this.mRoundingParams.getRoundingMethod() == RoundingParams.RoundingMethod.BITMAP_ONLY))
    {
      i = 0;
      if (i < this.mFadeDrawable.getNumberOfLayers()) {}
    }
    for (;;)
    {
      return;
      Drawable localDrawable = getLayerChildDrawable(i);
      if ((localDrawable instanceof Rounded)) {
        applyRoundingParams((Rounded)localDrawable, this.mRoundingParams);
      }
      for (;;)
      {
        i += 1;
        break;
        if (localDrawable != null)
        {
          setLayerChildDrawable(i, this.mEmptyActualImageDrawable);
          setLayerChildDrawable(i, maybeApplyRoundingBitmapOnly(this.mRoundingParams, this.mResources, localDrawable));
        }
      }
      i = 0;
      while (i < this.mFadeDrawable.getNumberOfLayers())
      {
        localDrawable = getLayerChildDrawable(i);
        if ((localDrawable instanceof Rounded)) {
          resetRoundedDrawable((Rounded)localDrawable);
        }
        i += 1;
      }
    }
  }
  
  private void updateOverlayColorRounding()
  {
    Object localObject = this.mTopLevelDrawable.getCurrent();
    if ((this.mRoundingParams != null) && (this.mRoundingParams.getRoundingMethod() == RoundingParams.RoundingMethod.OVERLAY_COLOR)) {
      if ((localObject instanceof RoundedCornersDrawable))
      {
        localObject = (RoundedCornersDrawable)localObject;
        applyRoundingParams((Rounded)localObject, this.mRoundingParams);
        ((RoundedCornersDrawable)localObject).setOverlayColor(this.mRoundingParams.getOverlayColor());
      }
    }
    while (!(localObject instanceof RoundedCornersDrawable))
    {
      return;
      localObject = this.mTopLevelDrawable.setCurrent(this.mEmptyActualImageDrawable);
      localObject = maybeWrapWithRoundedOverlayColor(this.mRoundingParams, (Drawable)localObject);
      this.mTopLevelDrawable.setCurrent((Drawable)localObject);
      return;
    }
    localObject = ((RoundedCornersDrawable)localObject).setCurrent(this.mEmptyActualImageDrawable);
    this.mTopLevelDrawable.setCurrent((Drawable)localObject);
  }
  
  public void getActualImageBounds(RectF paramRectF)
  {
    this.mActualImageSettableDrawable.getTransformedBounds(paramRectF);
  }
  
  public RoundingParams getRoundingParams()
  {
    return this.mRoundingParams;
  }
  
  public Drawable getTopLevelDrawable()
  {
    return this.mTopLevelDrawable;
  }
  
  public void reset()
  {
    resetActualImages();
    resetFade();
  }
  
  public void setActualImageColorFilter(ColorFilter paramColorFilter)
  {
    this.mFadeDrawable.getDrawable(this.mActualImageIndex).setColorFilter(paramColorFilter);
  }
  
  public void setActualImageFocusPoint(PointF paramPointF)
  {
    Preconditions.checkNotNull(paramPointF);
    ScaleTypeDrawable localScaleTypeDrawable = findLayerScaleTypeDrawable(this.mActualImageIndex);
    if (localScaleTypeDrawable == null) {
      throw new UnsupportedOperationException("ScaleTypeDrawable not found!");
    }
    localScaleTypeDrawable.setFocusPoint(paramPointF);
  }
  
  public void setActualImageScaleType(ScalingUtils.ScaleType paramScaleType)
  {
    Preconditions.checkNotNull(paramScaleType);
    ScaleTypeDrawable localScaleTypeDrawable = findLayerScaleTypeDrawable(this.mActualImageIndex);
    if (localScaleTypeDrawable == null) {
      throw new UnsupportedOperationException("ScaleTypeDrawable not found!");
    }
    localScaleTypeDrawable.setScaleType(paramScaleType);
  }
  
  public void setControllerOverlay(@Nullable Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (paramDrawable == null) {
      localDrawable = this.mEmptyControllerOverlayDrawable;
    }
    this.mFadeDrawable.setDrawable(this.mControllerOverlayIndex, localDrawable);
  }
  
  public void setFadeDuration(int paramInt)
  {
    this.mFadeDrawable.setTransitionDuration(paramInt);
  }
  
  public void setFailure(Throwable paramThrowable)
  {
    this.mFadeDrawable.beginBatchMode();
    fadeOutBranches();
    if (this.mFadeDrawable.getDrawable(this.mFailureImageIndex) != null) {
      fadeInLayer(this.mFailureImageIndex);
    }
    for (;;)
    {
      this.mFadeDrawable.endBatchMode();
      return;
      fadeInLayer(this.mPlaceholderImageIndex);
    }
  }
  
  public void setFailureImage(Drawable paramDrawable)
  {
    setFailureImage(paramDrawable, null);
  }
  
  public void setFailureImage(@Nullable Drawable paramDrawable, @Nullable ScalingUtils.ScaleType paramScaleType)
  {
    setDrawableAndScaleType(paramDrawable, paramScaleType, this.mFailureImageIndex);
  }
  
  public void setImage(Drawable paramDrawable, float paramFloat, boolean paramBoolean)
  {
    paramDrawable = maybeApplyRoundingBitmapOnly(this.mRoundingParams, this.mResources, paramDrawable);
    paramDrawable.mutate();
    this.mActualImageSettableDrawable.setDrawable(paramDrawable);
    this.mFadeDrawable.beginBatchMode();
    fadeOutBranches();
    fadeInLayer(this.mActualImageIndex);
    setProgress(paramFloat);
    if (paramBoolean) {
      this.mFadeDrawable.finishTransitionImmediately();
    }
    this.mFadeDrawable.endBatchMode();
  }
  
  public void setPlaceholderImage(int paramInt)
  {
    setPlaceholderImage(this.mResources.getDrawable(paramInt));
  }
  
  public void setPlaceholderImage(Drawable paramDrawable)
  {
    setPlaceholderImage(paramDrawable, null);
  }
  
  public void setPlaceholderImage(@Nullable Drawable paramDrawable, @Nullable ScalingUtils.ScaleType paramScaleType)
  {
    Drawable localDrawable = paramDrawable;
    if (paramDrawable == null) {
      localDrawable = getEmptyPlaceholderDrawable();
    }
    setDrawableAndScaleType(localDrawable, paramScaleType, this.mPlaceholderImageIndex);
  }
  
  public void setPlaceholderImageFocusPoint(PointF paramPointF)
  {
    Preconditions.checkNotNull(paramPointF);
    ScaleTypeDrawable localScaleTypeDrawable = findLayerScaleTypeDrawable(this.mPlaceholderImageIndex);
    if (localScaleTypeDrawable == null) {
      throw new UnsupportedOperationException("ScaleTypeDrawable not found!");
    }
    localScaleTypeDrawable.setFocusPoint(paramPointF);
  }
  
  public void setProgress(float paramFloat, boolean paramBoolean)
  {
    this.mFadeDrawable.beginBatchMode();
    setProgress(paramFloat);
    if (paramBoolean) {
      this.mFadeDrawable.finishTransitionImmediately();
    }
    this.mFadeDrawable.endBatchMode();
  }
  
  public void setProgressBarImage(Drawable paramDrawable)
  {
    setProgressBarImage(paramDrawable, null);
  }
  
  public void setProgressBarImage(@Nullable Drawable paramDrawable, @Nullable ScalingUtils.ScaleType paramScaleType)
  {
    setDrawableAndScaleType(paramDrawable, paramScaleType, this.mProgressBarImageIndex);
  }
  
  public void setRetry(Throwable paramThrowable)
  {
    this.mFadeDrawable.beginBatchMode();
    fadeOutBranches();
    if (this.mFadeDrawable.getDrawable(this.mRetryImageIndex) != null) {
      fadeInLayer(this.mRetryImageIndex);
    }
    for (;;)
    {
      this.mFadeDrawable.endBatchMode();
      return;
      fadeInLayer(this.mPlaceholderImageIndex);
    }
  }
  
  public void setRetryImage(Drawable paramDrawable)
  {
    setRetryImage(paramDrawable, null);
  }
  
  public void setRetryImage(@Nullable Drawable paramDrawable, @Nullable ScalingUtils.ScaleType paramScaleType)
  {
    setDrawableAndScaleType(paramDrawable, paramScaleType, this.mRetryImageIndex);
  }
  
  public void setRoundingParams(RoundingParams paramRoundingParams)
  {
    this.mRoundingParams = paramRoundingParams;
    updateOverlayColorRounding();
    updateBitmapOnlyRounding();
  }
  
  public static class RootDrawable
    extends ForwardingDrawable
    implements VisibilityAwareDrawable
  {
    @Nullable
    private VisibilityCallback mVisibilityCallback;
    
    public RootDrawable(Drawable paramDrawable)
    {
      super();
    }
    
    @SuppressLint({"WrongCall"})
    public void draw(Canvas paramCanvas)
    {
      if (!isVisible()) {
        return;
      }
      if (this.mVisibilityCallback != null) {
        this.mVisibilityCallback.onDraw();
      }
      super.draw(paramCanvas);
    }
    
    public int getIntrinsicHeight()
    {
      return -1;
    }
    
    public int getIntrinsicWidth()
    {
      return -1;
    }
    
    public void setVisibilityCallback(@Nullable VisibilityCallback paramVisibilityCallback)
    {
      this.mVisibilityCallback = paramVisibilityCallback;
    }
    
    public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (this.mVisibilityCallback != null) {
        this.mVisibilityCallback.onVisibilityChange(paramBoolean1);
      }
      return super.setVisible(paramBoolean1, paramBoolean2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\drawee\generic\GenericDraweeHierarchy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */