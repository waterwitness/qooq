import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.OldHttpEngine.OldHttpCommunicatorListner;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class vbg
  extends TimerTask
{
  public vbg(OldHttpEngine.OldHttpCommunicatorListner paramOldHttpCommunicatorListner)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.a(9004, -1, "nonetwork");
    this.a.b(this.a.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg, this.a.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vbg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */