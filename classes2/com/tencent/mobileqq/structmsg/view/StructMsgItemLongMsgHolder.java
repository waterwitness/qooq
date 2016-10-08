package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class StructMsgItemLongMsgHolder
{
  public static final int a = 0;
  public static final String a = "longMsgHolderType";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  
  public StructMsgItemLongMsgHolder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static View a(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, Bundle paramBundle)
  {
    paramOnLongClickAndTouchListener = paramContext.getResources();
    int i;
    label37:
    Object localObject;
    if (paramBundle.getInt("longMsgHolderType", -1) == 1)
    {
      i = 1;
      if ((paramView == null) || (!(paramView instanceof RelativeLayout))) {
        break label237;
      }
      ((RelativeLayout)paramView).removeAllViews();
      paramView = (RelativeLayout)paramView;
      paramView.setLayoutParams(new RelativeLayout.LayoutParams(-1, AIOUtils.a(75.0F, paramOnLongClickAndTouchListener)));
      paramBundle = new RelativeLayout(paramContext);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      paramView.addView(paramBundle, (ViewGroup.LayoutParams)localObject);
      localObject = new ImageView(paramContext);
      paramContext = new TextView(paramContext);
      if (i == 0) {
        break label249;
      }
      ((ImageView)localObject).setImageResource(2130838842);
      paramContext.setText(paramOnLongClickAndTouchListener.getString(2131364559));
    }
    for (;;)
    {
      ((ImageView)localObject).setId(2131296505);
      ((ImageView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(AIOUtils.a(23.5F, paramOnLongClickAndTouchListener), AIOUtils.a(22.5F, paramOnLongClickAndTouchListener)));
      paramBundle.addView((View)localObject);
      paramContext.setTextSize(2, 14.0F);
      paramContext.setTextColor(Color.parseColor("#777777"));
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131296505);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(7.5F, paramOnLongClickAndTouchListener);
      paramBundle.addView(paramContext, (ViewGroup.LayoutParams)localObject);
      return paramView;
      i = 0;
      break;
      label237:
      paramView = new RelativeLayout(paramContext);
      break label37;
      label249:
      ((ImageView)localObject).setImageResource(2130838841);
      paramContext.setText(paramOnLongClickAndTouchListener.getString(2131364560));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\view\StructMsgItemLongMsgHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */