import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pwl
  implements Runnable
{
  public pwl(DataLineHandler paramDataLineHandler, long paramLong, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.OnSessionComplete(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pwl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */