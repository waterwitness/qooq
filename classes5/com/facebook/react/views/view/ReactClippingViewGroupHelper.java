package com.facebook.react.views.view;

import android.graphics.Rect;
import android.view.View;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class ReactClippingViewGroupHelper
{
  public static final String PROP_REMOVE_CLIPPED_SUBVIEWS = "removeClippedSubviews";
  private static final Rect sHelperRect = new Rect();
  
  public static void calculateClippingRect(View paramView, Rect paramRect)
  {
    Object localObject = paramView.getParent();
    if (localObject == null) {
      paramRect.setEmpty();
    }
    do
    {
      return;
      if (!(localObject instanceof ReactClippingViewGroup)) {
        break;
      }
      localObject = (ReactClippingViewGroup)localObject;
      if (!((ReactClippingViewGroup)localObject).getRemoveClippedSubviews()) {
        break;
      }
      ((ReactClippingViewGroup)localObject).getClippingRect(sHelperRect);
      sHelperRect.offset(-paramView.getLeft(), -paramView.getTop());
      paramView.getDrawingRect(paramRect);
    } while (paramRect.intersect(sHelperRect));
    paramRect.setEmpty();
    return;
    paramView.getDrawingRect(paramRect);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\view\ReactClippingViewGroupHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */