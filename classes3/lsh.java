import com.tencent.mobileqq.activity.LikeSettingActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class lsh
  extends CardObserver
{
  public lsh(LikeSettingActivity paramLikeSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LikeSettingActivity", 2, "onSetCardSwitch.isSuccess=" + paramBoolean1 + ",uin=" + paramString + ",forNearPeople=" + paramBoolean2 + ",allowed=" + paramBoolean3);
    }
    if ((!this.a.app.a().equals(paramString)) || (!paramBoolean2)) {}
    while (paramBoolean1) {
      return;
    }
    QQToast.a(this.a, 1, 2131370267, 0).b(this.a.getTitleBarHeight());
    LikeSettingActivity.a(this.a, this.a.b.a(), paramBoolean3);
  }
  
  protected void b(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LikeSettingActivity", 2, "onGetCardSwitch.isSuccess=" + paramBoolean1 + ",uin=" + paramString + ",closeVoteAllowed=" + paramBoolean2 + ",praiseStatusAllowed=" + paramBoolean3);
    }
    if (!this.a.app.a().equals(paramString)) {}
    while (!paramBoolean1) {
      return;
    }
    LikeSettingActivity.a(this.a, this.a.b.a(), paramBoolean2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lsh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */