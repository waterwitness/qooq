import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class lzg
  implements IStatusListener
{
  public lzg(PermisionPrivacyActivity paramPermisionPrivacyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, RichStatus paramRichStatus, String paramString) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    PermisionPrivacyActivity.a(this.a, this.a.e.a(), paramBoolean);
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    if (paramInt == -1) {
      PermisionPrivacyActivity.a(this.a, 2131370267);
    }
    PermisionPrivacyActivity.a(this.a, this.a.e.a(), PermisionPrivacyActivity.a(this.a).b());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */