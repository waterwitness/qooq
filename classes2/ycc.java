import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.huangye.C2BUtils;
import cooperation.huangye.HYIvrSessionIdManager.OnGetIvrSessionIdListener;

public final class ycc
  implements HYIvrSessionIdManager.OnGetIvrSessionIdListener
{
  public ycc(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    C2BUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString2, paramString3, paramString4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ycc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */