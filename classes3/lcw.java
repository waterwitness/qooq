import android.os.Handler;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

public class lcw
  extends CardObserver
{
  public lcw(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramBoolean) && (paramObject != null) && (!Utils.a(((Card)paramObject).uin, this.a.a.a())))
      {
        this.a.a(8, ((Card)paramObject).uin, Integer.MIN_VALUE);
        this.a.s();
      }
      return;
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "Conversation.onUpdateAvatar: uin:" + paramString + ", success :" + paramBoolean);
    }
    if ((paramBoolean) && (this.a.a != null) && (Utils.a(paramString, this.a.a.a()))) {
      Conversation.a(this.a).a.sendEmptyMessage(3);
    }
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString != null) && (this.a.a.a().equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onGreetingRecv");
      }
      this.a.a(8, AppConstants.ar, 1001);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lcw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */