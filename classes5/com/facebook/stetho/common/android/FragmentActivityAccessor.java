package com.facebook.stetho.common.android;

import android.app.Activity;
import javax.annotation.Nullable;

public abstract interface FragmentActivityAccessor<FRAGMENT_ACTIVITY extends Activity, FRAGMENT_MANAGER>
{
  @Nullable
  public abstract FRAGMENT_MANAGER getFragmentManager(FRAGMENT_ACTIVITY paramFRAGMENT_ACTIVITY);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\common\android\FragmentActivityAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */