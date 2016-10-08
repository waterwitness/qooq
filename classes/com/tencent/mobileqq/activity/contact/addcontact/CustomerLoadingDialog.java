package com.tencent.mobileqq.activity.contact.addcontact;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class CustomerLoadingDialog
  extends Dialog
{
  public CustomerLoadingDialog(Context paramContext)
  {
    super(paramContext, 2131558990);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject = LayoutInflater.from(getContext()).inflate(2130904391, null);
    paramBundle = getWindow();
    paramBundle.setContentView((View)localObject);
    localObject = paramBundle.getAttributes();
    ((WindowManager.LayoutParams)localObject).width = -2;
    ((WindowManager.LayoutParams)localObject).height = -2;
    ((WindowManager.LayoutParams)localObject).gravity = 48;
    ((WindowManager.LayoutParams)localObject).y += getContext().getResources().getDimensionPixelOffset(2131493442);
    paramBundle.setAttributes((WindowManager.LayoutParams)localObject);
    setCanceledOnTouchOutside(false);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\contact\addcontact\CustomerLoadingDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */