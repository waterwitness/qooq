package cooperation.qqhotspot.hotspotnode;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import yhh;

public class PublicAccountHandler
{
  public static String a = "PublicAccountHandler";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AccountDetail paramAccountDetail)
  {
    ThreadManager.a(new yhh(paramQQAppInterface, paramAccountDetail), 5, null, true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqhotspot\hotspotnode\PublicAccountHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */