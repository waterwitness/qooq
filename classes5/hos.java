import com.tencent.biz.pubaccount.MultiVideoPlayActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

public class hos
  implements INetInfoHandler
{
  public hos(MultiVideoPlayActivity paramMultiVideoPlayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.MultiVideoPlayActivity", 2, "INetInfoHandler onNetMobile2None()");
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.MultiVideoPlayActivity", 2, "INetInfoHandler onNetMobile2Wifi() ssid=" + paramString);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.MultiVideoPlayActivity", 2, "INetInfoHandler onNetNone2Mobile() apn=" + paramString);
    }
    MultiVideoPlayActivity.a(this.a);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.MultiVideoPlayActivity", 2, "INetInfoHandler onNetNone2Wifi() ssid=" + paramString);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.MultiVideoPlayActivity", 2, "INetInfoHandler onNetWifi2Mobile() apn=" + paramString);
    }
    MultiVideoPlayActivity.a(this.a);
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.MultiVideoPlayActivity", 2, "INetInfoHandler onNetWifi2None()");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */