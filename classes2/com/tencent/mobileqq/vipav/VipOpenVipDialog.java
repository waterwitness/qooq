package com.tencent.mobileqq.vipav;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import wgi;
import wgj;
import wgk;
import wgl;

public class VipOpenVipDialog
{
  public VipOpenVipDialog()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, wgl paramwgl1, wgl paramwgl2)
  {
    if (paramBaseActivity == null) {
      return;
    }
    label17:
    label25:
    String str;
    if (TextUtils.isEmpty(paramString5))
    {
      paramString5 = "mvip.gongneng.mobileqq.tongyong.open.android";
      if (paramInt2 > 0) {
        break label105;
      }
      paramInt2 = 1;
      str = paramString3;
      if (TextUtils.isEmpty(paramString3)) {
        str = "取消";
      }
      if (!TextUtils.isEmpty(paramString4)) {
        break label108;
      }
    }
    label105:
    label108:
    for (paramString3 = "立即开通";; paramString3 = paramString4)
    {
      paramString1 = DialogUtil.a(paramBaseActivity, 0, paramString1, paramString2, str, paramString3, new wgj(paramString5, paramInt1, paramBaseActivity, paramInt2, paramwgl2), new wgk(paramwgl1));
      if ((paramString1 == null) || (paramBaseActivity.isFinishing())) {
        break;
      }
      paramString1.show();
      return;
      break label17;
      break label25;
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (paramBaseActivity == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString3))
    {
      paramString3 = "取消";
      label15:
      if (!TextUtils.isEmpty(paramString4)) {
        break label73;
      }
      paramString4 = "确定";
    }
    label73:
    for (;;)
    {
      paramString5 = new wgi(paramString5, paramBaseActivity);
      paramString1 = DialogUtil.a(paramBaseActivity, 0, paramString1, paramString2, paramString3, paramString4, paramString5, paramString5);
      if ((paramString1 == null) || (paramBaseActivity.isFinishing())) {
        break;
      }
      paramString1.show();
      return;
      break label15;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vipav\VipOpenVipDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */