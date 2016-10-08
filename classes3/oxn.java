import android.content.Context;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.QCallProxy.QueryRecentCallsListener;
import java.util.List;
import mqq.os.MqqHandler;

public class oxn
  implements QCallProxy.QueryRecentCallsListener
{
  public oxn(RecentCallHelper paramRecentCallHelper, QQAppInterface paramQQAppInterface, Context paramContext, MqqHandler paramMqqHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_MqqOsMqqHandler, paramList);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oxn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */