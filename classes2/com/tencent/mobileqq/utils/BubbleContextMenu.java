package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuLayout;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;
import wae;

public class BubbleContextMenu
{
  public static boolean a;
  
  public BubbleContextMenu()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static View a(BubblePopupWindow paramBubblePopupWindow, Context paramContext, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener)
  {
    QQCustomMenuLayout localQQCustomMenuLayout = new QQCustomMenuLayout(paramContext);
    localQQCustomMenuLayout.setGravity(17);
    int k = paramQQCustomMenu.a();
    int i = 0;
    while (i < k)
    {
      Object localObject = paramQQCustomMenu.a(i);
      wae localwae = new wae(paramContext, paramBubblePopupWindow);
      localwae.setText(((QQCustomMenuItem)localObject).a());
      localwae.setTextSize(13.0F);
      Resources localResources = paramContext.getResources();
      TextPaint localTextPaint = new TextPaint(1);
      localTextPaint.density = localResources.getDisplayMetrics().density;
      int m = (int)Layout.getDesiredWidth(((QQCustomMenuItem)localObject).a(), localTextPaint);
      int j = 5;
      if (localTextPaint.density >= 2.0F) {
        j = 10;
      }
      j = (int)(j * localTextPaint.density);
      localwae.setMinimumWidth(j * 2 + m);
      localwae.setPadding(j, 0, j, 0);
      localwae.setContentDescription(((QQCustomMenuItem)localObject).a());
      localwae.setId(((QQCustomMenuItem)localObject).a());
      localwae.setTextColor(-1);
      localwae.setBackgroundDrawable(null);
      localwae.setIncludeFontPadding(true);
      localwae.setOnClickListener(paramOnClickListener);
      localwae.setGravity(17);
      localQQCustomMenuLayout.addView(localwae, new LinearLayout.LayoutParams(-2, -2, 1.0F));
      if (i != k - 1)
      {
        localObject = new ImageView(paramContext);
        ((ImageView)localObject).setBackgroundResource(2130838100);
        localQQCustomMenuLayout.addView((View)localObject, -2, -2);
      }
      i += 1;
    }
    localQQCustomMenuLayout.a();
    return localQQCustomMenuLayout;
  }
  
  public static BubblePopupWindow a(View paramView, int paramInt1, int paramInt2, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.a(a(localBubblePopupWindow, paramView.getContext(), paramQQCustomMenu, paramOnClickListener));
    localBubblePopupWindow.a(new ColorDrawable(0));
    localBubblePopupWindow.c(true);
    localBubblePopupWindow.a(true);
    localBubblePopupWindow.c(1);
    localBubblePopupWindow.b(2);
    localBubblePopupWindow.b(paramView, paramInt1, paramInt2);
    return localBubblePopupWindow;
  }
  
  public static BubblePopupWindow a(View paramView, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.a(a(localBubblePopupWindow, paramView.getContext(), paramQQCustomMenu, paramOnClickListener));
    localBubblePopupWindow.a(new ColorDrawable(0));
    localBubblePopupWindow.c(true);
    localBubblePopupWindow.a(true);
    localBubblePopupWindow.b(paramView);
    return localBubblePopupWindow;
  }
  
  public static BubblePopupWindow a(View paramView, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener, BubblePopupWindow.OnDismissListener paramOnDismissListener)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.a(a(localBubblePopupWindow, paramView.getContext(), paramQQCustomMenu, paramOnClickListener));
    localBubblePopupWindow.a(paramOnDismissListener);
    localBubblePopupWindow.a(new ColorDrawable(0));
    localBubblePopupWindow.c(true);
    localBubblePopupWindow.a(true);
    localBubblePopupWindow.b(paramView);
    return localBubblePopupWindow;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\BubbleContextMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */