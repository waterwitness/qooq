import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class rqa
  implements Runnable
{
  rqa(rpz paramrpz)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    UniformDownloadActivity.b(this.a.a).setVisibility(0);
    UniformDownloadActivity.a(this.a.a).setVisibility(0);
    UniformDownloadActivity.b(this.a.a).setText(this.a.a.getString(2131363070, new Object[] { "0%" }));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rqa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */