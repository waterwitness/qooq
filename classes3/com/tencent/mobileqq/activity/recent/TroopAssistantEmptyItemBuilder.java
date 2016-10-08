package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AbsListView.LayoutParams;

public class TroopAssistantEmptyItemBuilder
  extends RecentItemBaseBuilder
{
  private static final String jdField_b_of_type_JavaLangString = "TroopAssistantEmptyItemBuilder";
  private int a;
  private int jdField_b_of_type_Int;
  private int q;
  private int r;
  
  public TroopAssistantEmptyItemBuilder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    int i;
    if (paramView == null)
    {
      paramRecentFaceDecoder = null;
      if (!"TroopAssistantEmptyItemBuilder".equals(paramRecentFaceDecoder))
      {
        paramView = View.inflate(paramContext, 2130905049, null);
        paramView.setTag("TroopAssistantEmptyItemBuilder");
        paramRecentFaceDecoder = paramContext.getResources();
        this.b = paramRecentFaceDecoder.getDimensionPixelSize(2131493027);
        this.a = paramRecentFaceDecoder.getDimensionPixelSize(2131493028);
        this.q = paramRecentFaceDecoder.getDimensionPixelSize(2131493029);
        i = paramRecentFaceDecoder.getDimensionPixelSize(2131493164);
        this.r = (paramRecentFaceDecoder.getDimensionPixelSize(2131493165) + i);
      }
      i = paramViewGroup.getMeasuredHeight() - this.a - this.b - 10 - this.r;
      if (i <= this.q) {
        break label210;
      }
      label124:
      paramRecentFaceDecoder = new AbsListView.LayoutParams(-1, -1);
      paramRecentFaceDecoder.width = -1;
      paramRecentFaceDecoder.height = i;
      paramView.setLayoutParams(paramRecentFaceDecoder);
      if ((paramObject instanceof Integer))
      {
        paramObject = (Integer)paramObject;
        paramRecentFaceDecoder = (TextView)paramView.findViewById(2131305128);
        if (((Integer)paramObject).intValue() != 4) {
          break label219;
        }
        paramRecentFaceDecoder.setText(2131369930);
      }
    }
    for (;;)
    {
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
      paramRecentFaceDecoder = paramView.getTag();
      break;
      label210:
      i = this.q;
      break label124;
      label219:
      paramRecentFaceDecoder.setText(2131370329);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\TroopAssistantEmptyItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */