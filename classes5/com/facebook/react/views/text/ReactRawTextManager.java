package com.facebook.react.views.text;

import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.uimanager.ThemedReactContext;

public class ReactRawTextManager
  extends ReactTextViewManager
{
  @VisibleForTesting
  public static final String REACT_CLASS = "RCTRawText";
  
  public static String getStaticName()
  {
    return "RCTRawText";
  }
  
  public static Class<ReactTextShadowNode> getStaticShadowNodeClass()
  {
    return ReactTextShadowNode.class;
  }
  
  public ReactTextShadowNode createShadowNodeInstance()
  {
    return new ReactTextShadowNode(true);
  }
  
  public ReactTextView createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    throw new IllegalStateException("RKRawText doesn't map into a native view");
  }
  
  public String getName()
  {
    return getStaticName();
  }
  
  public Class<ReactTextShadowNode> getShadowNodeClass()
  {
    return getStaticShadowNodeClass();
  }
  
  public void updateExtraData(ReactTextView paramReactTextView, Object paramObject) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\text\ReactRawTextManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */