import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.BaseApplication;

public class uij
  implements IStatusListener
{
  public uij(EditActivity paramEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, RichStatus paramRichStatus, String paramString)
  {
    paramRichStatus = (SignatureManager)this.a.app.getManager(57);
    EditActivity.b(this.a, false);
    this.a.b = false;
    if (paramInt == 100)
    {
      paramRichStatus = this.a.app.a().getSharedPreferences(this.a.app.a(), 0).edit();
      paramRichStatus.putBoolean("tipsbar_clicked", false);
      if (Build.VERSION.SDK_INT <= 8) {
        paramRichStatus.commit();
      }
      for (;;)
      {
        this.a.a(2131370629);
        this.a.setResult(-1);
        this.a.finish();
        return;
        paramRichStatus.apply();
      }
    }
    if (paramInt == -210006)
    {
      this.a.a(16);
      return;
    }
    if (paramInt == -210007)
    {
      this.a.a(18);
      return;
    }
    if (paramInt == -210008)
    {
      this.a.a(19);
      return;
    }
    if (paramInt == -210011)
    {
      paramRichStatus.a.c = paramString;
      this.a.a(20);
      return;
    }
    this.a.a(17);
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt, boolean paramBoolean) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uij.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */