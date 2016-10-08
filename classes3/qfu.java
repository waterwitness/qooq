import com.dataline.util.RouterSessionAdapter;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;

public class qfu
  implements Runnable
{
  public qfu(RouterHandler paramRouterHandler, long paramLong, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Session localSession = (Session)this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.e.get(Long.valueOf(this.jdField_a_of_type_Long));
    if ((this.jdField_a_of_type_Int == 2) && (localSession != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.e.remove(Long.valueOf(this.jdField_a_of_type_Long));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a(2, localSession, 0.0D, this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a.notifyDataSetChanged();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qfu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */