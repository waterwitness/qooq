package com.tencent.mobileqq.theme.diy;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ThemeDIYActivity$7
  implements DialogInterface.OnClickListener
{
  ThemeDIYActivity$7(ThemeDIYActivity paramThemeDIYActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.this$0.app, "CliOper", "", this.this$0.app.a(), "theme_mall", "diy_out_tips", 0, 1, "0", "", "", "");
    this.this$0.isNotifyBack = false;
    if ((this.this$0.exitDialog != null) && (this.this$0.exitDialog.isShowing()))
    {
      this.this$0.exitDialog.dismiss();
      this.this$0.exitDialog = null;
    }
    this.this$0.onBackEvent();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\diy\ThemeDIYActivity$7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */