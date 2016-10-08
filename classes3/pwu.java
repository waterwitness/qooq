import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pwu
  implements Runnable
{
  public pwu(DataLineHandler paramDataLineHandler, long paramLong, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    DataLineHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pwu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */