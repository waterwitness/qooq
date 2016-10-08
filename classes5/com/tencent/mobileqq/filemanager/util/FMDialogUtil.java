package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import sii;
import sij;
import sik;
import sil;
import sim;
import sin;

public class FMDialogUtil
{
  public FMDialogUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseActivity.sTopActivity;
    }
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FMDialogUtil<FileAssistant>", 2, "show dialog fail, context is null!");
      }
      return;
    }
    a((Context)localObject, ((Context)localObject).getString(paramInt1), paramInt2, paramFMDialogInterface);
  }
  
  public static void a(Context paramContext, int paramInt, String paramString, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    sil localsil = new sil(paramFMDialogInterface);
    paramFMDialogInterface = new sim(paramFMDialogInterface);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new sin(paramContext, paramInt, paramString, localsil, paramFMDialogInterface));
      return;
    }
    DialogUtil.a(paramContext, 230, paramContext.getString(paramInt), paramString, 2131362754, 2131362755, localsil, paramFMDialogInterface).show();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    sii localsii = new sii(paramFMDialogInterface);
    paramFMDialogInterface = new sij(paramFMDialogInterface);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new sik(paramContext, paramString, paramInt, localsii, paramFMDialogInterface));
      return;
    }
    DialogUtil.a(paramContext, 230, paramString, paramContext.getString(paramInt), 2131362754, 2131362755, localsii, paramFMDialogInterface).show();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\util\FMDialogUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */