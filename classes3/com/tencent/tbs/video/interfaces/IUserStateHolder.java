package com.tencent.tbs.video.interfaces;

import android.app.Activity;
import android.content.Intent;

public abstract interface IUserStateHolder
{
  public abstract boolean isSuperVipUser();
  
  public abstract void onVipActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void requestOpenSuperVip(Activity paramActivity);
  
  public abstract void setUserStateChangedListener(IUserStateChangedListener paramIUserStateChangedListener);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tbs\video\interfaces\IUserStateHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */