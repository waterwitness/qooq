import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mhd
  extends FriendListObserver
{
  public mhd(QQSettingSettingActivity paramQQSettingSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (paramString == null)) {
      return;
    }
    this.a.a(this.a.app.a());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mhd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */