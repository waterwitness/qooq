package com.facebook.react.modules.dialog;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import javax.annotation.Nullable;

class AlertFragment
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  static final String ARG_BUTTON_NEGATIVE = "button_negative";
  static final String ARG_BUTTON_NEUTRAL = "button_neutral";
  static final String ARG_BUTTON_POSITIVE = "button_positive";
  static final String ARG_MESSAGE = "message";
  static final String ARG_TITLE = "title";
  @Nullable
  private final DialogModule.AlertFragmentListener mListener;
  
  public AlertFragment(@Nullable DialogModule.AlertFragmentListener paramAlertFragmentListener, Bundle paramBundle)
  {
    this.mListener = paramAlertFragmentListener;
    setArguments(paramBundle);
  }
  
  public static Dialog createDialog(Context paramContext, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramContext = new AlertDialog.Builder(paramContext).setTitle(paramBundle.getString("title")).setMessage(paramBundle.getString("message"));
    if (paramBundle.containsKey("button_positive")) {
      paramContext.setPositiveButton(paramBundle.getString("button_positive"), paramOnClickListener);
    }
    if (paramBundle.containsKey("button_negative")) {
      paramContext.setNegativeButton(paramBundle.getString("button_negative"), paramOnClickListener);
    }
    if (paramBundle.containsKey("button_neutral")) {
      paramContext.setNeutralButton(paramBundle.getString("button_neutral"), paramOnClickListener);
    }
    return paramContext.create();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.mListener != null) {
      this.mListener.onClick(paramDialogInterface, paramInt);
    }
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    return createDialog(getActivity(), getArguments(), this);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    if (this.mListener != null) {
      this.mListener.onDismiss(paramDialogInterface);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\modules\dialog\AlertFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */