package com.tencent.mobileqq.freshnews.topic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.theme.ThemeUtil;

public class FreshNewsEmptyItem
  extends LinearLayout
{
  public FreshNewsEmptyItem(AppInterface paramAppInterface, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    paramContext = LayoutInflater.from(paramContext).inflate(2130904169, this, false);
    if (ThemeUtil.isInNightMode(paramAppInterface)) {
      paramContext.setBackgroundResource(2131427641);
    }
    for (;;)
    {
      paramContext.getLayoutParams().height = paramViewGroup.getHeight();
      addView(paramContext);
      return;
      paramContext.setBackgroundResource(2131427640);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\topic\FreshNewsEmptyItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */