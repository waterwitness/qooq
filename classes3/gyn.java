import android.text.TextUtils;
import com.tencent.av.ui.SysCallTransparentActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class gyn
  implements Runnable
{
  public gyn(SysCallTransparentActivity paramSysCallTransparentActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.d == 1) {
      DialogUtil.a(this.a, this.a.e, this.a.f, 2131363161, 2131363162, new gyo(this), null).show();
    }
    while ((this.a.d != 2) && (this.a.d != 3)) {
      return;
    }
    int i;
    SysCallTransparentActivity localSysCallTransparentActivity;
    String str2;
    String str3;
    String str4;
    if (this.a.d == 2)
    {
      i = 1;
      localSysCallTransparentActivity = this.a;
      str2 = this.a.e;
      str3 = this.a.f;
      str4 = this.a.getString(2131363161);
      if (!TextUtils.isEmpty(this.a.g)) {
        break label182;
      }
    }
    label182:
    for (String str1 = this.a.getString(2131364008);; str1 = this.a.g)
    {
      DialogUtil.a(localSysCallTransparentActivity, 230, str2, str3, str4, str1, new gyp(this, i), new gyq(this)).show();
      return;
      i = 2;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gyn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */