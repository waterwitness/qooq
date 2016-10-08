import com.tencent.mobileqq.activity.Call;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

public class kro
  extends FriendListObserver
{
  public kro(Call paramCall)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CallTab", 2, "onUpdateFriendInfo uin = " + paramString + ", isSc = " + paramBoolean);
    }
    if (!paramBoolean) {}
    while (Utils.a(paramString, this.a.a.getAccount())) {
      return;
    }
    this.a.i();
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean == true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CallTab", 2, "refresh CallTab, from_onupdatedelfriend");
      }
      this.a.i();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CallTab", 2, " call.onUpdateCustomHead: uin:" + paramString + ", success :" + paramBoolean);
    }
    if (!paramBoolean) {}
    while (Utils.a(paramString, this.a.a.a())) {
      return;
    }
    this.a.b(new krp(this, paramString));
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      if (QLog.isColorLevel()) {
        QLog.i("CallTab", 2, "refresh CallTab, from_onupdatefriendlist");
      }
      this.a.i();
    }
  }
  
  protected void b(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("CallTab", 4, "onUpdateOnlineFriend| isSuc = " + paramBoolean);
    }
    if ((Call.a(this.a) != null) && (Call.a(this.a).c))
    {
      this.a.b(new krq(this, paramBoolean));
      return;
    }
    if ((paramBoolean) && (Call.a(this.a) != null)) {
      this.a.b(new krr(this));
    }
    this.a.i();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */