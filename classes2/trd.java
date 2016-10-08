import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.qphone.base.util.QLog;

public class trd
  implements Runnable
{
  public trd(OlympicManager paramOlympicManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OlympicManager", 2, "refreshUI tryDownloadActResource mTorchbearerFlag is 1 ");
    }
    OlympicManager.a(this.a, this.a.a, true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\trd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */