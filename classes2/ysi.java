import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.readinjoy.ReadInJoyPluginInstallActivity;

public class ysi
  implements Runnable
{
  public ysi(ReadInJoyPluginInstallActivity paramReadInJoyPluginInstallActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (ReadInJoyPluginInstallActivity.a(this.a) != null)
    {
      Toast.makeText(this.a.getApplicationContext(), this.a.centerView.getText() + this.a.getString(2131366423), 0).show();
      this.a.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ysi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */