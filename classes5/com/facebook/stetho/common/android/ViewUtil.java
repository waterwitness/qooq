package com.facebook.stetho.common.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.stetho.common.Predicate;
import com.facebook.stetho.common.Util;
import javax.annotation.Nullable;

public final class ViewUtil
{
  @Nullable
  public static View hitTest(View paramView, float paramFloat1, float paramFloat2)
  {
    return hitTest(paramView, paramFloat1, paramFloat2, null);
  }
  
  @Nullable
  public static View hitTest(View paramView, float paramFloat1, float paramFloat2, @Nullable Predicate<View> paramPredicate)
  {
    View localView2 = hitTestImpl(paramView, paramFloat1, paramFloat2, paramPredicate, false);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = hitTestImpl(paramView, paramFloat1, paramFloat2, paramPredicate, true);
    }
    return localView1;
  }
  
  private static View hitTestImpl(View paramView, float paramFloat1, float paramFloat2, @Nullable Predicate<View> paramPredicate, boolean paramBoolean)
  {
    if (!isHittable(paramView)) {}
    while ((!pointInView(paramView, paramFloat1, paramFloat2)) || ((paramPredicate != null) && (!paramPredicate.apply(paramView)))) {
      return null;
    }
    if (!(paramView instanceof ViewGroup)) {
      return paramView;
    }
    paramView = (ViewGroup)paramView;
    PointF localPointF;
    int i;
    if (paramView.getChildCount() > 0)
    {
      localPointF = new PointF();
      i = paramView.getChildCount() - 1;
      if (i >= 0) {}
    }
    else
    {
      if (!paramBoolean) {
        break label140;
      }
    }
    for (;;)
    {
      return paramView;
      View localView = paramView.getChildAt(i);
      if (isTransformedPointInView(paramView, localView, paramFloat1, paramFloat2, localPointF))
      {
        localView = hitTestImpl(localView, localPointF.x, localPointF.y, paramPredicate, paramBoolean);
        if (localView != null) {
          return localView;
        }
      }
      i -= 1;
      break;
      label140:
      paramView = null;
    }
  }
  
  private static boolean isHittable(View paramView)
  {
    if (paramView.getVisibility() != 0) {}
    while (ViewCompat.getInstance().getAlpha(paramView) < 0.001F) {
      return false;
    }
    return true;
  }
  
  public static boolean isTransformedPointInView(ViewGroup paramViewGroup, View paramView, float paramFloat1, float paramFloat2, @Nullable PointF paramPointF)
  {
    Util.throwIfNull(paramViewGroup);
    Util.throwIfNull(paramView);
    paramFloat1 = paramViewGroup.getScrollX() + paramFloat1 - paramView.getLeft();
    paramFloat2 = paramViewGroup.getScrollY() + paramFloat2 - paramView.getTop();
    boolean bool = pointInView(paramView, paramFloat1, paramFloat2);
    if ((bool) && (paramPointF != null)) {
      paramPointF.set(paramFloat1, paramFloat2);
    }
    return bool;
  }
  
  public static boolean pointInView(View paramView, float paramFloat1, float paramFloat2)
  {
    return (paramFloat1 >= 0.0F) && (paramFloat1 < paramView.getRight() - paramView.getLeft()) && (paramFloat2 >= 0.0F) && (paramFloat2 < paramView.getBottom() - paramView.getTop());
  }
  
  @Nullable
  private static Activity tryGetActivity(Context paramContext)
  {
    for (;;)
    {
      if (paramContext == null) {
        return null;
      }
      if ((paramContext instanceof Activity)) {
        return (Activity)paramContext;
      }
      if (!(paramContext instanceof ContextWrapper)) {
        break;
      }
      paramContext = ((ContextWrapper)paramContext).getBaseContext();
    }
    return null;
  }
  
  @Nullable
  public static Activity tryGetActivity(View paramView)
  {
    Object localObject;
    if (paramView == null) {
      localObject = null;
    }
    Activity localActivity;
    do
    {
      return (Activity)localObject;
      localActivity = tryGetActivity(paramView.getContext());
      localObject = localActivity;
    } while (localActivity != null);
    paramView = paramView.getParent();
    if ((paramView instanceof View)) {
      return tryGetActivity((View)paramView);
    }
    return null;
  }
  
  private static class ViewCompat
  {
    private static final ViewCompat sInstance = new ViewCompat();
    
    static
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        sInstance = new ViewCompatHoneycomb(null);
        return;
      }
    }
    
    public static ViewCompat getInstance()
    {
      return sInstance;
    }
    
    public float getAlpha(View paramView)
    {
      return 1.0F;
    }
    
    @TargetApi(11)
    private static class ViewCompatHoneycomb
      extends ViewUtil.ViewCompat
    {
      public float getAlpha(View paramView)
      {
        return paramView.getAlpha();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\common\android\ViewUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */