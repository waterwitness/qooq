import com.dataline.activities.DLRouterActivity;
import com.dataline.activities.LiteActivity;
import com.dataline.util.RouterSessionAdapter;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;

public class qfr
  implements Runnable
{
  public qfr(RouterHandler paramRouterHandler, Session paramSession)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.e.put(Long.valueOf(this.jdField_a_of_type_ComTencentLitetransfersdkSession.uSessionID), this.jdField_a_of_type_ComTencentLitetransfersdkSession);
    this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a(3, this.jdField_a_of_type_ComTencentLitetransfersdkSession, 0.0D, 0);
    if (this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a.c();
      this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a.notifyDataSetChanged();
      LiteActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a.a.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a.a.jdField_a_of_type_ComTencentWidgetXListView);
      LiteActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a.a.jdField_a_of_type_ComTencentWidgetXListView);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qfr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */