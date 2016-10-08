package com.tencent.mobileqq.troop.widget;

import android.view.View;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class TroopFeedViewFactory$ViewProvider
{
  public TroopFeedViewFactory$ViewProvider(TroopFeedViewFactory paramTroopFeedViewFactory)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected abstract View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean);
  
  public View a(TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    return a(null, paramTroopFeedItem, paramInt, paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\widget\TroopFeedViewFactory$ViewProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */