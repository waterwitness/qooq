import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class lcx
  extends DiscussionObserver
{
  public lcx(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    this.a.a(9, null, Integer.MIN_VALUE);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onDelDiscussion");
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList paramArrayList)
  {
    this.a.a(8, Long.toString(paramLong), 3000);
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onChangeDiscussionName");
      }
      this.a.a(8, paramString, 3000);
      this.a.s();
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "conversation onUpdateDiscussionFaceIcon|[" + paramBoolean1 + ", " + paramBoolean2 + ", " + paramString + "]");
    }
    if (paramBoolean1) {
      this.a.b(new lcy(this, paramString));
    }
  }
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    if ((paramBoolean) && (bool))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_updateDiscussionInfo");
      }
      this.a.a(0L);
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onQuitDiscussion");
      }
      this.a.a(8, paramString, 3000);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lcx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */