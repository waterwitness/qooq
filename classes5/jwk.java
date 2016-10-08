import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.qfind.QFindBLEScanMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jwk
  implements Runnable
{
  public jwk(SmartDeviceProxyMgr paramSmartDeviceProxyMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SmartDeviceProxyMgr.a(this.a, new QFindBLEScanMgr());
    this.a.a(null, false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jwk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */