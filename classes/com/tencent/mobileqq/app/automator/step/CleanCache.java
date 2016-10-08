package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.IOException;
import qiw;

public class CleanCache
  extends AsyncStep
{
  private static final int j = 3000;
  private static final int k = 2500;
  
  public CleanCache()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    this.a.b.a().getSharedPreferences("HEAD", 0).edit().clear().commit();
    c();
    ThreadManager.a(new qiw(this), 2, null, false);
    return 7;
  }
  
  public String a()
  {
    if ((this.a.b.getAccount() != null) && (this.a.b.isLogin())) {
      return this.a.b.getAccount();
    }
    return "0";
  }
  
  void c()
  {
    CardHandler.c();
    File localFile = new File(AppConstants.bj + ".nomedia");
    if (!localFile.exists()) {}
    try
    {
      localFile.createNewFile();
      FileManagerUtil.a();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\CleanCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */