import android.os.Message;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqpim.QQPimGetTipsInfoIPC.IGetQQPimTipsCallBack;
import cooperation.qqpim.QQPimTipsInfo;
import cooperation.qqpim.QQPimTipsInfoHelper;

public class oot
  implements QQPimGetTipsInfoIPC.IGetQQPimTipsCallBack
{
  public oot(ContactListView paramContactListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(QQPimTipsInfo paramQQPimTipsInfo)
  {
    if (paramQQPimTipsInfo == null) {
      return;
    }
    QLog.i(ContactListView.a(), 2, "getQQPimTips() callback ");
    QQPimTipsInfoHelper.b(this.a.getContext(), paramQQPimTipsInfo);
    Message localMessage = new Message();
    localMessage.what = 6;
    localMessage.obj = paramQQPimTipsInfo;
    this.a.a.sendMessage(localMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\oot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */