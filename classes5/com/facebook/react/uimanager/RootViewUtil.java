package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.infer.annotation.Assertions;

public class RootViewUtil
{
  public static RootView getRootView(View paramView)
  {
    for (;;)
    {
      if ((paramView instanceof RootView)) {
        return (RootView)paramView;
      }
      paramView = paramView.getParent();
      if (paramView == null) {
        return null;
      }
      Assertions.assertNotNull(paramView);
      Assertions.assertCondition(paramView instanceof View);
      paramView = (View)paramView;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\RootViewUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */