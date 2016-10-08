package com.facebook.react.uimanager;

import android.view.View;
import android.view.ViewGroup;

public abstract class ViewGroupManager<T extends ViewGroup>
  extends BaseViewManager<T, LayoutShadowNode>
{
  public static Class<LayoutShadowNode> getStaticShadowNodeClass()
  {
    return LayoutShadowNode.class;
  }
  
  public void addView(T paramT, View paramView, int paramInt)
  {
    paramT.addView(paramView, paramInt);
  }
  
  public LayoutShadowNode createShadowNodeInstance()
  {
    return new LayoutShadowNode();
  }
  
  public View getChildAt(T paramT, int paramInt)
  {
    return paramT.getChildAt(paramInt);
  }
  
  public int getChildCount(T paramT)
  {
    return paramT.getChildCount();
  }
  
  public Class<LayoutShadowNode> getShadowNodeClass()
  {
    return getStaticShadowNodeClass();
  }
  
  public boolean needsCustomLayoutForChildren()
  {
    return false;
  }
  
  public void removeAllViews(T paramT)
  {
    int i = getChildCount(paramT) - 1;
    while (i >= 0)
    {
      removeViewAt(paramT, i);
      i -= 1;
    }
  }
  
  public void removeViewAt(T paramT, int paramInt)
  {
    paramT.removeViewAt(paramInt);
  }
  
  public void updateExtraData(T paramT, Object paramObject) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\ViewGroupManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */