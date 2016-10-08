import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.BaseActionBarDataLineFile;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.QLog;

public class sbs
  implements INetEventHandler
{
  public sbs(BaseActionBarDataLineFile paramBaseActionBarDataLineFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    BaseActionBarDataLineFile.a(this.a, false);
    QLog.d(BaseActionBarDataLineFile.a() + "[MPFile]", 1, "processNetChange,mConnPCSuc: " + BaseActionBarDataLineFile.a(this.a));
    if (AppNetConnInfo.isMobileConn()) {
      QLog.d(BaseActionBarDataLineFile.a() + "[MPFile]", 1, "网络切换到3G/4G网络");
    }
    while (!AppNetConnInfo.isWifiConn()) {
      return;
    }
    QLog.d(BaseActionBarDataLineFile.a() + "[MPFile]", 1, "网络切换到Wifi网络");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sbs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */