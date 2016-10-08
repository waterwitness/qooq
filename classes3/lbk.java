import android.text.TextUtils;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.adapter.BuddyListAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class lbk
  extends BizTroopObserver
{
  public lbk(Contacts paramContacts)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (paramInt2 == 0) {
      if (this.a.a != null) {
        this.a.a.notifyDataSetChanged();
      }
    }
    while ((TextUtils.isEmpty(paramString2)) || (this.a.a().isFinishing())) {
      return;
    }
    QQToast.a(this.a.a(), paramString2, 0).b(this.a.a().getTitleBarHeight());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lbk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */