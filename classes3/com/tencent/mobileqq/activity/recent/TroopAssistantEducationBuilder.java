package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

@Deprecated
public class TroopAssistantEducationBuilder
  extends RecentItemBaseBuilder
{
  public TroopAssistantEducationBuilder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    paramObject = paramView;
    if (paramView == null) {
      paramObject = View.inflate(paramContext, 2130905051, null);
    }
    paramRecentFaceDecoder = ((View)paramObject).findViewById(2131305124);
    paramRecentFaceDecoder.setTag(-1, Integer.valueOf(paramInt));
    paramRecentFaceDecoder.setOnClickListener(paramOnClickListener);
    paramRecentFaceDecoder = ((View)paramObject).findViewById(2131305134);
    paramRecentFaceDecoder.setTag(-1, Integer.valueOf(paramInt));
    paramRecentFaceDecoder.setOnClickListener(paramOnClickListener);
    ((View)paramObject).setTag(-1, Integer.valueOf(paramInt));
    return (View)paramObject;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\TroopAssistantEducationBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */