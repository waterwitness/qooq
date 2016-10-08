package cooperation.qqreader;

import android.os.Bundle;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import cooperation.qwallet.plugin.QWalletHelper;
import mqq.app.AppRuntime;
import yjd;

public class QRRemoteAsynCommond
  extends RemoteCommand
{
  public static final int a = 10001;
  public static final String a = "QRRemoteAsynCommond";
  public static final int b = 10002;
  public static final String b = "qqreader_plugin_asyn_cmd";
  
  public QRRemoteAsynCommond()
  {
    super("qqreader_plugin_asyn_cmd");
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    switch (paramBundle.getInt("CommondType"))
    {
    }
    for (;;)
    {
      return null;
      if (a() != null)
      {
        paramBundle = paramBundle.getString("publicaccount_uin");
        PublicAccountUtil.a(a(), a().a(), paramBundle, new yjd(this, paramOnInvokeFinishLinstener));
        continue;
        QWalletHelper.a();
      }
    }
  }
  
  public boolean isSynchronized()
  {
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqreader\QRRemoteAsynCommond.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */