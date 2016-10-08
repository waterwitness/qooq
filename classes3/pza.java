import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader;
import com.tencent.qphone.base.util.QLog;

public class pza
  implements Runnable
{
  public pza(IndividualRedPacketManager paramIndividualRedPacketManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a().a(false, true);
    IndividualRedPacketManager.a();
    if (QLog.isColorLevel()) {
      QLog.d(IndividualRedPacketManager.b(), 2, "AIO_BG_WIDTH:" + this.a.d);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */