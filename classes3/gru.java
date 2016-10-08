import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.widget.ChildLockCircle.AnimationListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class gru
  implements ChildLockCircle.AnimationListener
{
  public gru(DoubleVideoCtrlUI paramDoubleVideoCtrlUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a() {}
  
  public void b()
  {
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new grv(this));
  }
  
  public void c()
  {
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new grw(this));
  }
  
  public void d()
  {
    if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().w)
    {
      ReportController.b(null, "CliOper", "", "", "0X80061F8", "0X80061F8", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X80061FA", "0X80061FA", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gru.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */