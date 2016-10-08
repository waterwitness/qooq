import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gwk
  implements Runnable
{
  gwk(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.k())
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a(0L, false, 0L);
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoCtrlLayerUIBase", 2, "RefreshNoiseStateRunnable refreshUserNoiseState return true");
      }
    }
    Handler localHandler;
    Runnable localRunnable;
    if (this.a.f != null)
    {
      localHandler = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      localRunnable = this.a.f;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.d >= 2000L) {
        break label98;
      }
    }
    label98:
    for (long l = 2000L;; l = this.a.jdField_a_of_type_ComTencentAvVideoController.d)
    {
      localHandler.postDelayed(localRunnable, l);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gwk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */