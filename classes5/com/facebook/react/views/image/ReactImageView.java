package com.facebook.react.views.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.SystemClock;
import com.facebook.common.logging.FLog;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.controller.ForwardingControllerListener;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.tencent.bitapp.pre.PreConst;
import javax.annotation.Nullable;

public class ReactImageView
  extends GenericDraweeView
{
  private static final int REMOTE_IMAGE_FADE_DURATION_MS = 300;
  private static final Matrix sInverse = new Matrix();
  private static final Matrix sMatrix = new Matrix();
  private int mBorderColor;
  private float mBorderRadius;
  private float mBorderWidth;
  @Nullable
  private final Object mCallerContext;
  @Nullable
  private ControllerListener mControllerForTesting;
  @Nullable
  private ControllerListener mControllerListener;
  private final AbstractDraweeControllerBuilder mDraweeControllerBuilder;
  private int mFadeDurationMs = -1;
  private boolean mIsDirty;
  private boolean mIsLocalImage;
  @Nullable
  private Drawable mLoadingImageDrawable;
  private boolean mProgressiveRenderingEnabled;
  private final RoundedCornerPostprocessor mRoundedCornerPostprocessor;
  private ScalingUtils.ScaleType mScaleType = ImageResizeMode.defaultValue();
  @Nullable
  private Uri mUri;
  
  public ReactImageView(Context paramContext, AbstractDraweeControllerBuilder paramAbstractDraweeControllerBuilder, @Nullable Object paramObject)
  {
    super(paramContext, buildHierarchy(paramContext));
    this.mDraweeControllerBuilder = paramAbstractDraweeControllerBuilder;
    this.mRoundedCornerPostprocessor = new RoundedCornerPostprocessor(null);
    this.mCallerContext = paramObject;
  }
  
  private static GenericDraweeHierarchy buildHierarchy(Context paramContext)
  {
    return new GenericDraweeHierarchyBuilder(paramContext.getResources()).setRoundingParams(RoundingParams.fromCornersRadius(0.0F)).build();
  }
  
  @Nullable
  private static Drawable getResourceDrawable(Context paramContext, @Nullable String paramString)
  {
    int i = getResourceDrawableId(paramContext, paramString);
    if (i > 0) {
      return paramContext.getResources().getDrawable(i);
    }
    return null;
  }
  
  private static int getResourceDrawableId(Context paramContext, @Nullable String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      return 0;
    }
    return paramContext.getResources().getIdentifier(paramString.toLowerCase().replace("-", "_"), "drawable", paramContext.getPackageName());
  }
  
  @Nullable
  private static Uri getResourceDrawableUri(Context paramContext, @Nullable String paramString)
  {
    int i = getResourceDrawableId(paramContext, paramString);
    if (i > 0) {
      return new Uri.Builder().scheme("res").path(String.valueOf(i)).build();
    }
    return null;
  }
  
  private static boolean shouldResize(@Nullable Uri paramUri)
  {
    return (paramUri != null) && ((UriUtil.isLocalContentUri(paramUri)) || (UriUtil.isLocalFileUri(paramUri)));
  }
  
  public boolean hasOverlappingRendering()
  {
    return false;
  }
  
  public void maybeUpdateView()
  {
    ResizeOptions localResizeOptions = null;
    if (!this.mIsDirty) {}
    boolean bool;
    do
    {
      return;
      bool = shouldResize(this.mUri);
    } while ((bool) && ((getWidth() <= 0) || (getHeight() <= 0)));
    Object localObject = (GenericDraweeHierarchy)getHierarchy();
    ((GenericDraweeHierarchy)localObject).setActualImageScaleType(this.mScaleType);
    if (this.mLoadingImageDrawable != null) {
      ((GenericDraweeHierarchy)localObject).setPlaceholderImage(this.mLoadingImageDrawable, ScalingUtils.ScaleType.CENTER);
    }
    int j;
    float f;
    label102:
    int i;
    if ((this.mScaleType != ScalingUtils.ScaleType.CENTER_CROP) && (this.mScaleType != ScalingUtils.ScaleType.FOCUS_CROP))
    {
      j = 1;
      if (j == 0) {
        break label359;
      }
      f = 0.0F;
      RoundingParams localRoundingParams = ((GenericDraweeHierarchy)localObject).getRoundingParams();
      localRoundingParams.setCornersRadius(f);
      localRoundingParams.setBorder(this.mBorderColor, this.mBorderWidth);
      ((GenericDraweeHierarchy)localObject).setRoundingParams(localRoundingParams);
      if (this.mFadeDurationMs < 0) {
        break label367;
      }
      i = this.mFadeDurationMs;
      label148:
      ((GenericDraweeHierarchy)localObject).setFadeDuration(i);
      if (j == 0) {
        break label388;
      }
      localObject = this.mRoundedCornerPostprocessor;
      label164:
      if (bool) {
        localResizeOptions = new ResizeOptions(getWidth(), getHeight());
      }
      if ((PreConst.isTestPerformance) && (FLog.isLoggable(6))) {
        FLog.e("bitapp_performance", "Create ImageRequest and begin request: " + this.mUri);
      }
      localObject = ImageRequestBuilder.newBuilderWithSource(this.mUri).setPostprocessor((Postprocessor)localObject).setResizeOptions(localResizeOptions).setProgressiveRenderingEnabled(this.mProgressiveRenderingEnabled).build();
      this.mDraweeControllerBuilder.reset();
      this.mDraweeControllerBuilder.setAutoPlayAnimations(true).setCallerContext(this.mCallerContext).setOldController(getController()).setImageRequest(localObject);
      if ((this.mControllerListener == null) || (this.mControllerForTesting == null)) {
        break label393;
      }
      localObject = new ForwardingControllerListener();
      ((ForwardingControllerListener)localObject).addListener(this.mControllerListener);
      ((ForwardingControllerListener)localObject).addListener(this.mControllerForTesting);
      this.mDraweeControllerBuilder.setControllerListener((ControllerListener)localObject);
    }
    for (;;)
    {
      setController(this.mDraweeControllerBuilder.build());
      this.mIsDirty = false;
      return;
      j = 0;
      break;
      label359:
      f = this.mBorderRadius;
      break label102;
      label367:
      if (this.mIsLocalImage)
      {
        i = 0;
        break label148;
      }
      i = 300;
      break label148;
      label388:
      localObject = null;
      break label164;
      label393:
      if (this.mControllerForTesting != null) {
        this.mDraweeControllerBuilder.setControllerListener(this.mControllerForTesting);
      } else if (this.mControllerListener != null) {
        this.mDraweeControllerBuilder.setControllerListener(this.mControllerListener);
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 > 0) && (paramInt2 > 0)) {
      maybeUpdateView();
    }
  }
  
  public void setBorderColor(int paramInt)
  {
    this.mBorderColor = paramInt;
    this.mIsDirty = true;
  }
  
  public void setBorderRadius(float paramFloat)
  {
    this.mBorderRadius = PixelUtil.toPixelFromDIP(paramFloat);
    this.mIsDirty = true;
  }
  
  public void setBorderWidth(float paramFloat)
  {
    this.mBorderWidth = PixelUtil.toPixelFromDIP(paramFloat);
    this.mIsDirty = true;
  }
  
  public void setControllerListener(ControllerListener paramControllerListener)
  {
    this.mControllerForTesting = paramControllerListener;
    this.mIsDirty = true;
    maybeUpdateView();
  }
  
  public void setFadeDuration(int paramInt)
  {
    this.mFadeDurationMs = paramInt;
  }
  
  public void setLoadingIndicatorSource(@Nullable String paramString)
  {
    paramString = getResourceDrawable(getContext(), paramString);
    if (paramString != null) {}
    for (paramString = new AutoRotateDrawable(paramString, 1000);; paramString = null)
    {
      this.mLoadingImageDrawable = paramString;
      this.mIsDirty = true;
      return;
    }
  }
  
  public void setProgressiveRenderingEnabled(boolean paramBoolean)
  {
    this.mProgressiveRenderingEnabled = paramBoolean;
  }
  
  public void setScaleType(ScalingUtils.ScaleType paramScaleType)
  {
    this.mScaleType = paramScaleType;
    this.mIsDirty = true;
  }
  
  public void setShouldNotifyLoadEvents(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (this.mControllerListener = null;; this.mControllerListener = new BaseControllerListener()
        {
          public void onFailure(String paramAnonymousString, Throwable paramAnonymousThrowable)
          {
            if ((PreConst.isTestPerformance) && (FLog.isLoggable(6))) {
              FLog.e("bitapp_performance", "Image event load fail viewTag: " + ReactImageView.this.getId() + " | mUri: " + ReactImageView.this.mUri);
            }
            this.val$mEventDispatcher.dispatchEvent(new ImageLoadEvent(ReactImageView.this.getId(), SystemClock.uptimeMillis(), 3));
          }
          
          public void onFinalImageSet(String paramAnonymousString, @Nullable ImageInfo paramAnonymousImageInfo, @Nullable Animatable paramAnonymousAnimatable)
          {
            if (paramAnonymousImageInfo != null)
            {
              if ((PreConst.isTestPerformance) && (FLog.isLoggable(6))) {
                FLog.e("bitapp_performance", "Image event load success viewTag: " + ReactImageView.this.getId() + " | mUri: " + ReactImageView.this.mUri);
              }
              this.val$mEventDispatcher.dispatchEvent(new ImageLoadEvent(ReactImageView.this.getId(), SystemClock.uptimeMillis(), 3));
              this.val$mEventDispatcher.dispatchEvent(new ImageLoadEvent(ReactImageView.this.getId(), SystemClock.uptimeMillis(), 2));
            }
            while (!FLog.isLoggable(6)) {
              return;
            }
            FLog.e("bitapp_performance", "Image event load success but imageInfo is null viewTag: " + ReactImageView.this.getId() + " | mUri: " + ReactImageView.this.mUri);
          }
          
          public void onSubmit(String paramAnonymousString, Object paramAnonymousObject)
          {
            if ((PreConst.isTestPerformance) && (FLog.isLoggable(6))) {
              FLog.e("bitapp_performance", "Image event load start viewTag: " + ReactImageView.this.getId() + " | mUri: " + ReactImageView.this.mUri);
            }
            this.val$mEventDispatcher.dispatchEvent(new ImageLoadEvent(ReactImageView.this.getId(), SystemClock.uptimeMillis(), 4));
          }
        })
    {
      this.mIsDirty = true;
      return;
    }
  }
  
  public void setSource(@Nullable String paramString)
  {
    this.mUri = null;
    if (paramString != null) {}
    try
    {
      this.mUri = Uri.parse(paramString);
      if (this.mUri.getScheme() == null) {
        this.mUri = null;
      }
      if (this.mUri == null) {
        this.mUri = getResourceDrawableUri(getContext(), paramString);
      }
      for (this.mIsLocalImage = true;; this.mIsLocalImage = false)
      {
        this.mIsDirty = true;
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  private class RoundedCornerPostprocessor
    extends BasePostprocessor
  {
    private RoundedCornerPostprocessor() {}
    
    float getRadius(Bitmap paramBitmap)
    {
      ScalingUtils.getTransform(ReactImageView.sMatrix, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), paramBitmap.getWidth(), paramBitmap.getHeight(), 0.0F, 0.0F, ReactImageView.this.mScaleType);
      ReactImageView.sMatrix.invert(ReactImageView.sInverse);
      return ReactImageView.sInverse.mapRadius(ReactImageView.this.mBorderRadius);
    }
    
    public void process(Bitmap paramBitmap1, Bitmap paramBitmap2)
    {
      paramBitmap1.setHasAlpha(true);
      if (ReactImageView.this.mBorderRadius < 0.01F)
      {
        super.process(paramBitmap1, paramBitmap2);
        return;
      }
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setShader(new BitmapShader(paramBitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
      paramBitmap1 = new Canvas(paramBitmap1);
      float f = getRadius(paramBitmap2);
      paramBitmap1.drawRoundRect(new RectF(0.0F, 0.0F, paramBitmap2.getWidth(), paramBitmap2.getHeight()), f, f, localPaint);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\image\ReactImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */