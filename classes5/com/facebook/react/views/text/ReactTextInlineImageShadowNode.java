package com.facebook.react.views.text;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactProp;
import java.util.Locale;
import javax.annotation.Nullable;

public class ReactTextInlineImageShadowNode
  extends LayoutShadowNode
{
  @Nullable
  private final Object mCallerContext;
  private final AbstractDraweeControllerBuilder mDraweeControllerBuilder;
  @Nullable
  private Uri mUri;
  
  public ReactTextInlineImageShadowNode(AbstractDraweeControllerBuilder paramAbstractDraweeControllerBuilder, @Nullable Object paramObject)
  {
    this.mDraweeControllerBuilder = paramAbstractDraweeControllerBuilder;
    this.mCallerContext = paramObject;
  }
  
  @Nullable
  private static Uri getResourceDrawableUri(Context paramContext, @Nullable String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      return null;
    }
    paramString = paramString.toLowerCase(Locale.getDefault()).replace("-", "_");
    int i = paramContext.getResources().getIdentifier(paramString, "drawable", paramContext.getPackageName());
    return new Uri.Builder().scheme("res").path(String.valueOf(i)).build();
  }
  
  @Nullable
  public Object getCallerContext()
  {
    return this.mCallerContext;
  }
  
  public AbstractDraweeControllerBuilder getDraweeControllerBuilder()
  {
    return this.mDraweeControllerBuilder;
  }
  
  @Nullable
  public Uri getUri()
  {
    return this.mUri;
  }
  
  public boolean isVirtual()
  {
    return true;
  }
  
  @ReactProp(name="src")
  public void setSource(@Nullable String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramString != null) {}
    try
    {
      localObject2 = Uri.parse(paramString);
      localObject1 = localObject2;
      String str = ((Uri)localObject2).getScheme();
      localObject1 = localObject2;
      if (str == null) {
        localObject1 = null;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = getResourceDrawableUri(getThemedContext(), paramString);
    }
    if (localObject2 != this.mUri) {
      markUpdated();
    }
    this.mUri = ((Uri)localObject2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\text\ReactTextInlineImageShadowNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */