package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class RecentCallMoreItemBuilder
  extends RecentItemBaseBuilder
{
  public RecentCallMoreItemBuilder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    paramObject = paramView;
    if (paramView == null) {
      paramObject = LayoutInflater.from(paramContext).inflate(2130904126, null);
    }
    ((View)paramObject).setContentDescription("展示更多QQ电话好友 按钮");
    ((View)paramObject).setOnClickListener(paramOnClickListener);
    ((View)paramObject).setOnLongClickListener(paramOnLongClickListener);
    ((View)paramObject).setTag(-1, Integer.valueOf(paramInt));
    return (View)paramObject;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\RecentCallMoreItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */