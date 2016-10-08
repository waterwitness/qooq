import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qng
  implements Runnable
{
  public qng(DataLineMsgProxy paramDataLineMsgProxy, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    DataLineMsgProxy.b(this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy, this.jdField_a_of_type_Long);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */