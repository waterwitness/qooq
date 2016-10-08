import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pwj
  implements Runnable
{
  public pwj(DataLineHandler paramDataLineHandler, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Session localSession = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a(this.jdField_a_of_type_Long);
    DataLineHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler, localSession, null, null, true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pwj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */