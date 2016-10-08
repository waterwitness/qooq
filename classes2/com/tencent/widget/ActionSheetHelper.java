package com.tencent.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ActionSheetHelper
{
  public ActionSheetHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Dialog a(Context paramContext, View paramView)
  {
    paramContext = ActionSheet.a(paramContext);
    paramContext.b(paramView, new LinearLayout.LayoutParams(-1, -1));
    return paramContext;
  }
  
  public static Dialog b(Context paramContext, View paramView)
  {
    paramContext = ActionSheet.b(paramContext);
    paramContext.b(paramView, new LinearLayout.LayoutParams(-1, -1));
    return paramContext;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\ActionSheetHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */