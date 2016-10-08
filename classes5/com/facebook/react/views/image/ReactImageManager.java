package com.facebook.react.views.image;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ReactProp;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import java.util.Map;
import javax.annotation.Nullable;

public class ReactImageManager
  extends SimpleViewManager<ReactImageView>
{
  public static final String REACT_CLASS = "RCTImageView";
  @Nullable
  private final Object mCallerContext;
  @Nullable
  private AbstractDraweeControllerBuilder mDraweeControllerBuilder;
  
  public ReactImageManager()
  {
    this.mDraweeControllerBuilder = null;
    this.mCallerContext = null;
  }
  
  public ReactImageManager(AbstractDraweeControllerBuilder paramAbstractDraweeControllerBuilder, Object paramObject)
  {
    this.mDraweeControllerBuilder = paramAbstractDraweeControllerBuilder;
    this.mCallerContext = paramObject;
  }
  
  @Nullable
  public static Map getDirectEventTypeConstants()
  {
    return MapBuilder.of(ImageLoadEvent.eventNameForType(4), MapBuilder.of("registrationName", "onLoadStart"), ImageLoadEvent.eventNameForType(2), MapBuilder.of("registrationName", "onLoad"), ImageLoadEvent.eventNameForType(3), MapBuilder.of("registrationName", "onLoadEnd"));
  }
  
  @Nullable
  public static Map getStaticExportedCustomDirectEventTypeConstants()
  {
    return getDirectEventTypeConstants();
  }
  
  public static String getStaticName()
  {
    return "RCTImageView";
  }
  
  public ReactImageView createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactImageView(paramThemedReactContext, getDraweeControllerBuilder(), getCallerContext());
  }
  
  public Object getCallerContext()
  {
    return this.mCallerContext;
  }
  
  public AbstractDraweeControllerBuilder getDraweeControllerBuilder()
  {
    if (this.mDraweeControllerBuilder == null) {
      this.mDraweeControllerBuilder = Fresco.newDraweeControllerBuilder();
    }
    return this.mDraweeControllerBuilder;
  }
  
  @Nullable
  public Map getExportedCustomDirectEventTypeConstants()
  {
    return getStaticExportedCustomDirectEventTypeConstants();
  }
  
  public String getName()
  {
    return getStaticName();
  }
  
  protected void onAfterUpdateTransaction(ReactImageView paramReactImageView)
  {
    super.onAfterUpdateTransaction(paramReactImageView);
    paramReactImageView.maybeUpdateView();
  }
  
  @ReactProp(customType="Color", name="borderColor")
  public void setBorderColor(ReactImageView paramReactImageView, @Nullable Integer paramInteger)
  {
    if (paramInteger == null)
    {
      paramReactImageView.setBorderColor(0);
      return;
    }
    paramReactImageView.setBorderColor(paramInteger.intValue());
  }
  
  @ReactProp(name="borderRadius")
  public void setBorderRadius(ReactImageView paramReactImageView, float paramFloat)
  {
    paramReactImageView.setBorderRadius(paramFloat);
  }
  
  @ReactProp(name="borderWidth")
  public void setBorderWidth(ReactImageView paramReactImageView, float paramFloat)
  {
    paramReactImageView.setBorderWidth(paramFloat);
  }
  
  @ReactProp(name="fadeDuration")
  public void setFadeDuration(ReactImageView paramReactImageView, int paramInt)
  {
    paramReactImageView.setFadeDuration(paramInt);
  }
  
  @ReactProp(name="shouldNotifyLoadEvents")
  public void setLoadHandlersRegistered(ReactImageView paramReactImageView, boolean paramBoolean)
  {
    paramReactImageView.setShouldNotifyLoadEvents(paramBoolean);
  }
  
  @ReactProp(name="loadingIndicatorSrc")
  public void setLoadingIndicatorSource(ReactImageView paramReactImageView, @Nullable String paramString)
  {
    paramReactImageView.setLoadingIndicatorSource(paramString);
  }
  
  @ReactProp(name="progressiveRenderingEnabled")
  public void setProgressiveRenderingEnabled(ReactImageView paramReactImageView, boolean paramBoolean)
  {
    paramReactImageView.setProgressiveRenderingEnabled(paramBoolean);
  }
  
  @ReactProp(name="resizeMode")
  public void setResizeMode(ReactImageView paramReactImageView, @Nullable String paramString)
  {
    paramReactImageView.setScaleType(ImageResizeMode.toScaleType(paramString));
  }
  
  @ReactProp(name="src")
  public void setSource(ReactImageView paramReactImageView, @Nullable String paramString)
  {
    paramReactImageView.setSource(paramString);
  }
  
  @ReactProp(customType="Color", name="tintColor")
  public void setTintColor(ReactImageView paramReactImageView, @Nullable Integer paramInteger)
  {
    if (paramInteger == null)
    {
      paramReactImageView.clearColorFilter();
      return;
    }
    paramReactImageView.setColorFilter(paramInteger.intValue());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\image\ReactImageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */