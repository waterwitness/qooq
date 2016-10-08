package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.PstnCardInfo;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.huangye.HYEntranceManager;

public class RecentCallLightalkVipItemBuilder
  extends RecentItemBaseBuilder
{
  private static final String b = "RecentCallLightalkVipItemBuilder";
  
  public RecentCallLightalkVipItemBuilder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    paramObject = paramView;
    if (paramView == null) {
      paramObject = LayoutInflater.from(paramContext).inflate(2130904125, null);
    }
    paramView = (ViewGroup)((View)paramObject).findViewById(2131301482);
    paramView.setContentDescription("电话黄页 按钮");
    paramView.setOnClickListener(paramOnClickListener);
    paramView.setOnLongClickListener(paramOnLongClickListener);
    paramView.setTag(-1, Integer.valueOf(paramInt));
    boolean bool = BaseApplicationImpl.getContext().getSharedPreferences("qqhuangye", 0).getBoolean("show_reddot", true);
    paramRecentFaceDecoder = ((View)paramObject).findViewById(2131297405);
    if (bool)
    {
      paramRecentFaceDecoder.setVisibility(0);
      paramRecentFaceDecoder = (QQAppInterface)BaseApplicationImpl.a().a();
      if (!HYEntranceManager.a().a(paramRecentFaceDecoder))
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentCallLightalkVipItemBuilder", 2, "HY config isShowEntrance is false.");
        }
        paramView.setVisibility(8);
      }
      paramView = (ViewGroup)((View)paramObject).findViewById(2131301486);
      paramView.setContentDescription("专线电话 按钮");
      paramView.setOnClickListener(paramOnClickListener);
      paramView.setOnLongClickListener(paramOnLongClickListener);
      paramView.setTag(-1, Integer.valueOf(paramInt));
      paramContext = ((View)paramObject).findViewById(2131301488);
      paramView = (ViewGroup)((View)paramObject).findViewById(2131301490);
      paramView.setContentDescription("通讯录 按钮");
      paramView.setOnClickListener(paramOnClickListener);
      paramView.setOnLongClickListener(paramOnLongClickListener);
      paramView.setTag(-1, Integer.valueOf(paramInt));
      paramViewGroup = (ViewGroup)((View)paramObject).findViewById(2131301491);
      paramViewGroup.setContentDescription("拨号盘 按钮");
      paramViewGroup.setOnClickListener(paramOnClickListener);
      paramViewGroup.setOnLongClickListener(paramOnLongClickListener);
      paramViewGroup.setTag(-1, Integer.valueOf(paramInt));
      paramOnClickListener = (ViewGroup)((View)paramObject).findViewById(2131301489);
      paramOnLongClickListener = (PstnManager)paramRecentFaceDecoder.getManager(142);
      if (QLog.isColorLevel()) {
        QLog.d("RecentCallLightalkVipItemBuilder", 2, "pstn gray flag = " + paramOnLongClickListener.a());
      }
      if (paramOnLongClickListener.c()) {
        break label420;
      }
      paramContext.setVisibility(8);
    }
    for (;;)
    {
      paramRecentFaceDecoder = paramOnLongClickListener.a(paramRecentFaceDecoder.a());
      int i = 0;
      paramInt = i;
      if (paramRecentFaceDecoder != null) {
        if (paramRecentFaceDecoder.pstn_ever_c2c_vip != 1)
        {
          paramInt = i;
          if (paramRecentFaceDecoder.pstn_ever_multi_vip != 1) {}
        }
        else
        {
          paramInt = 1;
        }
      }
      if (paramInt == 0) {
        break label429;
      }
      paramViewGroup.setVisibility(0);
      paramView.setVisibility(0);
      paramOnClickListener.setVisibility(0);
      return (View)paramObject;
      paramRecentFaceDecoder.setVisibility(8);
      break;
      label420:
      paramContext.setVisibility(0);
    }
    label429:
    paramViewGroup.setVisibility(8);
    paramView.setVisibility(8);
    paramOnClickListener.setVisibility(8);
    return (View)paramObject;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\RecentCallLightalkVipItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */