import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.utils.TipsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class grx
  implements Runnable
{
  public grx(DoubleVideoCtrlUI paramDoubleVideoCtrlUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoCtrlUI", 2, "5s has past, remote has not open camera!");
    }
    if ((!this.a.f) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().f == 2))
    {
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(14, true);
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().i) || (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().j))
      {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().f = 1;
        this.a.f(1);
      }
      this.a.ag();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\grx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */