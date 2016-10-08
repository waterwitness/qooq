import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qidian.controller.QidianHandler;
import org.json.JSONObject;

public class obs
  implements Runnable
{
  public obs(PublicAccountChatPie paramPublicAccountChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QidianHandler localQidianHandler = (QidianHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85);
    int j;
    if (!this.a.ag)
    {
      j = 0;
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("app", "QD");
      if (this.a.aD != null) {
        ((JSONObject)localObject).put("assignType", Long.parseLong(this.a.aD));
      }
      if (this.a.aE != null) {
        ((JSONObject)localObject).put("assignKey", Long.parseLong(this.a.aE));
      }
      i = j;
      if (this.a.aF != null)
      {
        ((JSONObject)localObject).put("ext", this.a.aF);
        i = j;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        String str2;
        String str3;
        int i = 1;
        continue;
        localObject = ((JSONObject)localObject).toString();
      }
    }
    str1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
    str2 = this.a.aC;
    str3 = this.a.aB;
    if (i != 0)
    {
      localObject = null;
      localQidianHandler.b(str1, str2, str3, (String)localObject);
      this.a.a().runOnUiThread(new obt(this));
      localQidianHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.aC);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\obs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */