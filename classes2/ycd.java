import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.huangye.C2BUtils;
import cooperation.huangye.HYIvrBusinessManager.OnGetIvrBusinessListener;

public final class ycd
  implements HYIvrBusinessManager.OnGetIvrBusinessListener
{
  public ycd(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if (paramString2 != null) {}
    for (boolean bool = true;; bool = false)
    {
      C2BUtils.a(paramString1, localContext, localSessionInfo, bool);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ycd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */