package com.facebook.stetho.common.android;

import java.util.List;
import javax.annotation.Nullable;

public abstract interface FragmentManagerAccessor<FRAGMENT_MANAGER, FRAGMENT>
{
  @Nullable
  public abstract List<FRAGMENT> getAddedFragments(FRAGMENT_MANAGER paramFRAGMENT_MANAGER);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\common\android\FragmentManagerAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */