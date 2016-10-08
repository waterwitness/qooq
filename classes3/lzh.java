import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbyRelevantObserver;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressNotifier;

public class lzh
  extends NearbyRelevantObserver
{
  public lzh(PermisionPrivacyActivity paramPermisionPrivacyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.a.a != null) {
      this.a.a.a();
    }
    if (!paramBoolean) {
      PermisionPrivacyActivity.a(this.a, 2131370267);
    }
    paramBoolean = this.a.app.a().a();
    PermisionPrivacyActivity.a(this.a, this.a.f.a(), paramBoolean);
  }
  
  public void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      PermisionPrivacyActivity.a(this.a, this.a.f.a(), paramBoolean2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */