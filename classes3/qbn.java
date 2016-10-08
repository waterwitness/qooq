import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.FriendAnniver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class qbn
  extends FriendListObserver
{
  public qbn(NewFriendManager paramNewFriendManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, FriendAnniver paramFriendAnniver)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onGetFriendAnniverInfo|isSuccess : ").append(paramBoolean).append(",data is");
      if (paramFriendAnniver != null) {
        break label74;
      }
    }
    label74:
    for (String str = "is null";; str = "is not null")
    {
      QLog.d("NewFriendManager", 2, str);
      if ((paramBoolean) && (paramFriendAnniver != null))
      {
        this.a.b();
        NewFriendManager.a(this.a);
      }
      return;
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      this.a.b();
      NewFriendManager.a(this.a);
    }
  }
  
  protected void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.b();
      NewFriendManager.a(this.a);
    }
  }
  
  protected void d(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.a.b();
      NewFriendManager.a(this.a);
    }
  }
  
  protected void e(boolean paramBoolean)
  {
    this.a.a.runOnUiThread(new qbo(this, paramBoolean));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qbn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */