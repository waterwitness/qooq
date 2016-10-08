package com.tencent.mobileqq.maproam;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import tcb;
import tcc;

public class Utils
{
  public static Dialog a;
  
  public Utils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Dialog a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    paramContext = new Dialog(paramContext, 2131558973);
    paramContext.setContentView(2130904559);
    TextView localTextView = (TextView)paramContext.findViewById(2131297840);
    if (localTextView != null) {
      localTextView.setText(paramString1);
    }
    paramString1 = (TextView)paramContext.findViewById(2131296852);
    if (paramString1 != null) {
      paramString1.setText(paramString2);
    }
    paramString1 = (TextView)paramContext.findViewById(2131297843);
    if (paramString1 != null) {
      paramString1.setText(17039360);
    }
    paramString1 = (TextView)paramContext.findViewById(2131297844);
    if (paramString1 != null) {
      paramString1.setText(17039370);
    }
    paramContext.setOnDismissListener(paramOnDismissListener);
    return paramContext;
  }
  
  public static ProgressDialog a(Context paramContext, String paramString)
  {
    Drawable localDrawable = paramContext.getResources().getDrawable(2130842887);
    paramContext = new ProgressDialog(paramContext, 2131558973);
    paramContext.show();
    paramContext.getWindow().setContentView(2130903052);
    paramContext.setContentView(2130903052);
    ((TextView)paramContext.findViewById(2131296852)).setText(paramString);
    ((ProgressBar)paramContext.findViewById(2131296851)).setIndeterminateDrawable(localDrawable);
    return paramContext;
  }
  
  public static void a()
  {
    if ((a == null) || (a.isShowing())) {}
    try
    {
      a.dismiss();
      a = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public static void a(Context paramContext, int paramInt, String paramString, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    paramContext = a(paramContext, paramContext.getResources().getString(paramInt), paramString, new tcb());
    paramString = (TextView)paramContext.findViewById(2131297844);
    if (paramString != null)
    {
      a();
      paramString.setOnClickListener(paramOnClickListener1);
    }
    paramString = (TextView)paramContext.findViewById(2131297843);
    if (paramString != null)
    {
      if (paramOnClickListener2 != null) {
        break label84;
      }
      paramString.setOnClickListener(new tcc());
    }
    for (;;)
    {
      a = paramContext;
      a.show();
      return;
      label84:
      paramString.setOnClickListener(paramOnClickListener2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\maproam\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */