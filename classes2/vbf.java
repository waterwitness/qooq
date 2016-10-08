import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.OldHttpEngine;
import com.tencent.mobileqq.transfile.OldHttpEngine.OldHttpCommunicatorListner;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class vbf
  extends TimerTask
{
  public vbf(OldHttpEngine.OldHttpCommunicatorListner paramOldHttpCommunicatorListner)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTransfileOldHttpEngine.c(this.a.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vbf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */