package com.facebook.react.views.progressbar;

import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ReactProp;
import com.facebook.react.uimanager.ThemedReactContext;
import javax.annotation.Nullable;

public class ReactProgressBarViewManager
  extends BaseViewManager<ProgressBarContainerView, ProgressBarShadowNode>
{
  static final String DEFAULT_STYLE = "Large";
  static final String PROP_INDETERMINATE = "indeterminate";
  static final String PROP_PROGRESS = "progress";
  static final String PROP_STYLE = "styleAttr";
  static final String REACT_CLASS = "AndroidProgressBar";
  
  public static String getStaticName()
  {
    return "AndroidProgressBar";
  }
  
  public static Class<ProgressBarShadowNode> getStaticShadowNodeClass()
  {
    return ProgressBarShadowNode.class;
  }
  
  static int getStyleFromString(@Nullable String paramString)
  {
    if (paramString == null) {
      throw new JSApplicationIllegalArgumentException("ProgressBar needs to have a style, null received");
    }
    if (paramString.equals("Horizontal")) {
      return 16842872;
    }
    if (paramString.equals("Small")) {
      return 16842873;
    }
    if (paramString.equals("Large")) {
      return 16842874;
    }
    if (paramString.equals("Inverse")) {
      return 16843399;
    }
    if (paramString.equals("SmallInverse")) {
      return 16843400;
    }
    if (paramString.equals("LargeInverse")) {
      return 16843401;
    }
    throw new JSApplicationIllegalArgumentException("Unknown ProgressBar style: " + paramString);
  }
  
  public ProgressBarShadowNode createShadowNodeInstance()
  {
    return new ProgressBarShadowNode();
  }
  
  protected ProgressBarContainerView createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ProgressBarContainerView(paramThemedReactContext);
  }
  
  public String getName()
  {
    return getStaticName();
  }
  
  public Class<ProgressBarShadowNode> getShadowNodeClass()
  {
    return getStaticShadowNodeClass();
  }
  
  protected void onAfterUpdateTransaction(ProgressBarContainerView paramProgressBarContainerView)
  {
    paramProgressBarContainerView.apply();
  }
  
  @ReactProp(customType="Color", name="color")
  public void setColor(ProgressBarContainerView paramProgressBarContainerView, @Nullable Integer paramInteger)
  {
    paramProgressBarContainerView.setColor(paramInteger);
  }
  
  @ReactProp(name="indeterminate")
  public void setIndeterminate(ProgressBarContainerView paramProgressBarContainerView, boolean paramBoolean)
  {
    paramProgressBarContainerView.setIndeterminate(paramBoolean);
  }
  
  @ReactProp(name="progress")
  public void setProgress(ProgressBarContainerView paramProgressBarContainerView, double paramDouble)
  {
    paramProgressBarContainerView.setProgress(paramDouble);
  }
  
  @ReactProp(name="styleAttr")
  public void setStyle(ProgressBarContainerView paramProgressBarContainerView, @Nullable String paramString)
  {
    paramProgressBarContainerView.setStyle(paramString);
  }
  
  public void updateExtraData(ProgressBarContainerView paramProgressBarContainerView, Object paramObject) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\progressbar\ReactProgressBarViewManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */