import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.random.RandomController;
import com.tencent.av.random.ui.RandomDoubleActivity;
import com.tencent.av.utils.SparkDot;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gli
  implements Runnable
{
  public gli(RandomDoubleActivity paramRandomDoubleActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (SessionMgr.a().a(this.a.jdField_a_of_type_ComTencentAvRandomRandomController.d) == null) {}
    while (SessionMgr.a().a(this.a.jdField_a_of_type_ComTencentAvRandomRandomController.d).a.b != 5) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvUtilsSparkDot.b();
    this.a.jdField_a_of_type_ComTencentAvUtilsSparkDot.setVisibility(8);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gli.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */