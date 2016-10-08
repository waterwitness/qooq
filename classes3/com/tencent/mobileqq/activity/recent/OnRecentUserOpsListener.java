package com.tencent.mobileqq.activity.recent;

import android.view.View;

public abstract interface OnRecentUserOpsListener
{
  public abstract void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean);
  
  public abstract void a(View paramView, Object paramObject);
  
  public abstract void a(RecentBaseData paramRecentBaseData, String paramString);
  
  public abstract void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\OnRecentUserOpsListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */