import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;

public class mfd
  implements Runnable
{
  public mfd(QQSettingMe paramQQSettingMe)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!QQSettingMe.b(this.a)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "updateVipInfo");
    }
    String str1 = this.a.a.a();
    String str2 = ((TicketManager)this.a.a.getManager(2)).getSkey(str1);
    ((VipInfoHandler)this.a.a.a(27)).a(str2, str1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mfd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */