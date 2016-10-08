import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pwk
  implements Runnable
{
  public pwk(DataLineHandler paramDataLineHandler, long paramLong1, long paramLong2, long paramLong3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    DataLineHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler, this.jdField_a_of_type_Long, this.b, this.c);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pwk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */