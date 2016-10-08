import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import com.tencent.widget.TraceUtils;

public class qmd
  implements Runnable
{
  public qmd(QQMessageFacade paramQQMessageFacade)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    TraceUtils.a("initMsgCache");
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "before refreshCache");
    }
    this.a.a().a();
    this.a.d();
    QQMessageFacade.a(this.a);
    this.a.notifyObservers(new RecentUser());
    if (QLog.isColorLevel())
    {
      QLog.d("Q.msg.QQMessageFacade", 2, "after refreshCache");
      long l2 = System.currentTimeMillis();
      MsgAutoMonitorUtil.a().a("MSG_InitCostTime", l2 - l1 + "");
    }
    TraceUtils.a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */