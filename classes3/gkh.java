import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.random.RandomController;
import com.tencent.av.random.RandomWebProtocol;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gkh
  implements Runnable
{
  public gkh(RandomController paramRandomController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomController", 2, "mMatchTimeoutRunnable trigger, show timeOutDialog!");
    }
    this.a.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a();
    this.a.j();
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gkh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */