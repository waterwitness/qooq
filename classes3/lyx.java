import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.LightalkSwitchManager;
import com.tencent.mobileqq.qcall.LightalkSwitchObserver;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressNotifier;

public class lyx
  extends LightalkSwitchObserver
{
  public lyx(PermisionPrivacyActivity paramPermisionPrivacyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.a.a != null) {
      this.a.a.a();
    }
    if (!paramBoolean) {
      PermisionPrivacyActivity.a(this.a, 2131370267);
    }
    PermisionPrivacyActivity.a(this.a, this.a.h.a(), PermisionPrivacyActivity.a(this.a).b());
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      PermisionPrivacyActivity.a(this.a, this.a.h.a(), paramBoolean2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lyx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */