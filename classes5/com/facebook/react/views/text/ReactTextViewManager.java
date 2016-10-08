package com.facebook.react.views.text;

import android.text.TextUtils.TruncateAt;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactProp;
import com.facebook.react.uimanager.ThemedReactContext;
import javax.annotation.Nullable;

public class ReactTextViewManager
  extends BaseViewManager<ReactTextView, ReactTextShadowNode>
{
  @VisibleForTesting
  public static final String REACT_CLASS = "RCTText";
  
  public static String getStaticName()
  {
    return "RCTText";
  }
  
  public static Class<ReactTextShadowNode> getStaticShadowNodeClass()
  {
    return ReactTextShadowNode.class;
  }
  
  public ReactTextShadowNode createShadowNodeInstance()
  {
    return new ReactTextShadowNode(false);
  }
  
  public ReactTextView createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactTextView(paramThemedReactContext);
  }
  
  public String getName()
  {
    return getStaticName();
  }
  
  public Class<ReactTextShadowNode> getShadowNodeClass()
  {
    return getStaticShadowNodeClass();
  }
  
  @ReactProp(defaultFloat=NaN.0F, name="lineHeight")
  public void setLineHeight(ReactTextView paramReactTextView, float paramFloat)
  {
    if (Float.isNaN(paramFloat))
    {
      paramReactTextView.setLineSpacing(0.0F, 1.0F);
      return;
    }
    paramReactTextView.setLineSpacing(PixelUtil.toPixelFromSP(paramFloat), 0.0F);
  }
  
  @ReactProp(defaultInt=Integer.MAX_VALUE, name="numberOfLines")
  public void setNumberOfLines(ReactTextView paramReactTextView, int paramInt)
  {
    paramReactTextView.setMaxLines(paramInt);
    paramReactTextView.setEllipsize(TextUtils.TruncateAt.END);
  }
  
  @ReactProp(name="textAlign")
  public void setTextAlign(ReactTextView paramReactTextView, @Nullable String paramString)
  {
    if ((paramString == null) || ("auto".equals(paramString)))
    {
      paramReactTextView.setGravity(0);
      return;
    }
    if ("left".equals(paramString))
    {
      paramReactTextView.setGravity(3);
      return;
    }
    if ("right".equals(paramString))
    {
      paramReactTextView.setGravity(5);
      return;
    }
    if ("center".equals(paramString))
    {
      paramReactTextView.setGravity(1);
      return;
    }
    throw new JSApplicationIllegalArgumentException("Invalid textAlign: " + paramString);
  }
  
  public void updateExtraData(ReactTextView paramReactTextView, Object paramObject)
  {
    paramObject = (ReactTextUpdate)paramObject;
    if (((ReactTextUpdate)paramObject).containsImages()) {
      TextInlineImageSpan.possiblyUpdateInlineImageSpans(((ReactTextUpdate)paramObject).getText(), paramReactTextView);
    }
    paramReactTextView.setText((ReactTextUpdate)paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\text\ReactTextViewManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */