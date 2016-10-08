package com.facebook.react.views.text;

import android.view.View;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManager;
import javax.annotation.Nullable;

public class ReactTextInlineImageViewManager
  extends ViewManager<View, ReactTextInlineImageShadowNode>
{
  static final String REACT_CLASS = "RCTTextInlineImage";
  @Nullable
  private final Object mCallerContext;
  @Nullable
  private final AbstractDraweeControllerBuilder mDraweeControllerBuilder;
  
  public ReactTextInlineImageViewManager()
  {
    this(null, null);
  }
  
  public ReactTextInlineImageViewManager(@Nullable AbstractDraweeControllerBuilder paramAbstractDraweeControllerBuilder, @Nullable Object paramObject)
  {
    this.mDraweeControllerBuilder = paramAbstractDraweeControllerBuilder;
    this.mCallerContext = paramObject;
  }
  
  public static String getStaticName()
  {
    return "RCTTextInlineImage";
  }
  
  public static Class<ReactTextInlineImageShadowNode> getStaticShadowNodeClass()
  {
    return ReactTextInlineImageShadowNode.class;
  }
  
  public ReactTextInlineImageShadowNode createShadowNodeInstance()
  {
    if (this.mDraweeControllerBuilder != null) {}
    for (Object localObject = this.mDraweeControllerBuilder;; localObject = Fresco.newDraweeControllerBuilder()) {
      return new ReactTextInlineImageShadowNode((AbstractDraweeControllerBuilder)localObject, this.mCallerContext);
    }
  }
  
  public View createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    throw new IllegalStateException("RCTTextInlineImage doesn't map into a native view");
  }
  
  public String getName()
  {
    return getStaticName();
  }
  
  public Class<ReactTextInlineImageShadowNode> getShadowNodeClass()
  {
    return getStaticShadowNodeClass();
  }
  
  public void updateExtraData(View paramView, Object paramObject) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\text\ReactTextInlineImageViewManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */