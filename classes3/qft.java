import com.dataline.util.RouterSessionAdapter;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;

public class qft
  implements Runnable
{
  public qft(RouterHandler paramRouterHandler, long paramLong1, long paramLong2, long paramLong3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Session localSession = (Session)this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.e.get(Long.valueOf(this.jdField_a_of_type_Long));
    this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a(1, localSession, (float)((float)this.b * 1.0D / (float)this.c), 0);
    if (this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a.notifyDataSetChanged();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */