import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;

class lby
  implements Runnable
{
  lby(lbt paramlbt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "Conversation redpacket updateVipInfo");
    }
    String str1 = this.a.a.a.a();
    String str2 = ((TicketManager)this.a.a.a.getManager(2)).getSkey(str1);
    ((VipInfoHandler)this.a.a.a.a(27)).a(str2, str1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lby.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */