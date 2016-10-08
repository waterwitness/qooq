import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.random.RandomController;
import com.tencent.av.random.ui.RandomMultiActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class gmi
  implements Runnable
{
  public gmi(RandomMultiActivity paramRandomMultiActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController == null) || (SessionMgr.a().a(this.a.jdField_a_of_type_ComTencentAvRandomRandomController.d) == null)) {
      return;
    }
    SessionMgr.a().a(this.a.jdField_a_of_type_ComTencentAvRandomRandomController.d).a.f = true;
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.j() == 1) {
      ReportController.b(null, "CliOper", "", "", "0X80053C8", "0X80053C8", 0, 0, "", "", "", "");
    }
    RandomMultiActivity.a(this.a, true);
    this.a.c();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gmi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */