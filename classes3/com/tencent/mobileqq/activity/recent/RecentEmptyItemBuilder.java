package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AbsListView.LayoutParams;

public class RecentEmptyItemBuilder
  extends RecentItemBaseBuilder
{
  private static final String jdField_b_of_type_JavaLangString = "R.layout.conversation_no_chat";
  private int a;
  private int jdField_b_of_type_Int;
  private int q;
  
  public RecentEmptyItemBuilder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    if (paramView != null)
    {
      paramRecentFaceDecoder = paramView;
      if ("R.layout.conversation_no_chat".equals(paramView.getTag(2130903228))) {}
    }
    else
    {
      paramRecentFaceDecoder = View.inflate(paramContext, 2130903228, null);
      this.b = paramContext.getResources().getDimensionPixelSize(2131493027);
      this.a = paramContext.getResources().getDimensionPixelSize(2131493023);
      this.q = paramContext.getResources().getDimensionPixelSize(2131493029);
    }
    int i = paramViewGroup.getHeight() - this.a * 2 - this.b;
    if (i > this.q)
    {
      paramView = new AbsListView.LayoutParams(-1, -1);
      paramView.width = -1;
      paramView.height = i;
      paramRecentFaceDecoder.setLayoutParams(paramView);
      paramRecentFaceDecoder.setTag(Boolean.valueOf(true));
      paramView = (TextView)paramRecentFaceDecoder.findViewById(2131297817);
      paramViewGroup = (Button)paramRecentFaceDecoder.findViewById(2131297818);
      if (!(paramObject instanceof Integer)) {
        break label527;
      }
      i = ((Integer)paramObject).intValue();
      if (i != 1) {
        break label263;
      }
      paramView.setCompoundDrawablesWithIntrinsicBounds(0, 2130838707, 0, 0);
      paramView.setVisibility(0);
      paramView.setText(2131370329);
      paramView.setTextColor(paramContext.getResources().getColorStateList(2131428306));
      paramViewGroup.setVisibility(8);
      paramViewGroup.setOnClickListener(null);
    }
    for (;;)
    {
      paramRecentFaceDecoder.setTag(-1, Integer.valueOf(paramInt));
      paramRecentFaceDecoder.setTag(2130903228, "R.layout.conversation_no_chat");
      return paramRecentFaceDecoder;
      i = this.q;
      break;
      label263:
      if (i == 0)
      {
        if ((paramContext instanceof MsgBoxListActivity))
        {
          if (((MsgBoxListActivity)paramContext).d)
          {
            paramView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            paramView.setVisibility(0);
            paramView.setText("");
          }
        }
        else
        {
          paramView.setCompoundDrawablesWithIntrinsicBounds(0, 2130838707, 0, 0);
          paramView.setVisibility(0);
          paramView.setText(2131368874);
          paramView.setTextColor(paramContext.getResources().getColorStateList(2131428306));
          paramViewGroup.setVisibility(8);
          paramViewGroup.setOnClickListener(null);
        }
      }
      else if (i == 7)
      {
        paramView.setCompoundDrawablesWithIntrinsicBounds(0, 2130840624, 0, 0);
        paramView.setVisibility(0);
        paramView.setText(2131370329);
        paramView.setTextColor(paramContext.getResources().getColorStateList(2131428306));
        paramViewGroup.setVisibility(8);
        paramViewGroup.setOnClickListener(null);
      }
      else if (i == 6)
      {
        paramView.setCompoundDrawablesWithIntrinsicBounds(0, 2130840624, 0, 0);
        paramView.setVisibility(0);
        paramView.setText(2131368876);
        paramView.setTextColor(paramContext.getResources().getColorStateList(2131428262));
        paramViewGroup.setVisibility(0);
        paramViewGroup.setTag(-1, Integer.valueOf(paramInt));
        paramViewGroup.setOnClickListener(paramOnClickListener);
        if (AppSetting.j) {
          paramViewGroup.setContentDescription("点击进行选人，可以直接发起QQ电话");
        }
      }
      else
      {
        paramView.setVisibility(4);
        paramView.setText("");
        continue;
        label527:
        paramView.setVisibility(8);
        paramView.setText("");
        paramViewGroup.setVisibility(8);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\RecentEmptyItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */