package com.facebook.react.uimanager;

import android.view.View;

public abstract class SimpleViewManager<T extends View>
  extends BaseViewManager<T, LayoutShadowNode>
{
  public static Class<LayoutShadowNode> getStaticShadowNodeClass()
  {
    return LayoutShadowNode.class;
  }
  
  public LayoutShadowNode createShadowNodeInstance()
  {
    return new LayoutShadowNode();
  }
  
  public Class<LayoutShadowNode> getShadowNodeClass()
  {
    return getStaticShadowNodeClass();
  }
  
  public void updateExtraData(T paramT, Object paramObject) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\SimpleViewManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */