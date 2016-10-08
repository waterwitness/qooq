import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.PstnObserver;
import com.tencent.qphone.base.util.QLog;

public class ldq
  extends PstnObserver
{
  public ldq(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Boolean paramBoolean, int paramInt)
  {
    super.a(paramBoolean, paramInt);
    PstnManager localPstnManager = (PstnManager)this.a.a.getManager(142);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "onPstnGrayFlag|isSuccess:" + paramBoolean + " lastPstnGrayFlag:" + this.a.an + " grayFlag:" + paramInt + " mIsChatList:" + this.a.e + " needShowRedDot:" + localPstnManager.c());
    }
    if ((paramBoolean.booleanValue()) && (paramInt == 1) && (this.a.an != paramInt) && (this.a.e) && (localPstnManager.c()) && (Conversation.a(this.a) != null)) {
      Conversation.a(this.a).a(true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ldq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */