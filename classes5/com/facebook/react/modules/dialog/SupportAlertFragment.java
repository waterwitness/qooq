package com.facebook.react.modules.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import fb.support.v4.app.DialogFragment;
import javax.annotation.Nullable;

class SupportAlertFragment
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  @Nullable
  private final DialogModule.AlertFragmentListener mListener;
  
  public SupportAlertFragment(@Nullable DialogModule.AlertFragmentListener paramAlertFragmentListener, Bundle paramBundle)
  {
    this.mListener = paramAlertFragmentListener;
    setArguments(paramBundle);
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.mListener != null) {
      this.mListener.onClick(paramDialogInterface, paramInt);
    }
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    return AlertFragment.createDialog(getActivity(), getArguments(), this);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    if (this.mListener != null) {
      this.mListener.onDismiss(paramDialogInterface);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\modules\dialog\SupportAlertFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */