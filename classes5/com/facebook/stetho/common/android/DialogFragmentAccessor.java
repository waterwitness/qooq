package com.facebook.stetho.common.android;

import android.app.Dialog;

public abstract interface DialogFragmentAccessor<DIALOG_FRAGMENT, FRAGMENT, FRAGMENT_MANAGER>
  extends FragmentAccessor<FRAGMENT, FRAGMENT_MANAGER>
{
  public abstract Dialog getDialog(DIALOG_FRAGMENT paramDIALOG_FRAGMENT);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\common\android\DialogFragmentAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */