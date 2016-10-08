import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.MPFileVerifyPwdView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class rpd
  implements Runnable
{
  rpd(rpc paramrpc)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    MPFileVerifyPwdView.b(this.a.a.a).setEnabled(true);
    MPFileVerifyPwdView.b(this.a.a.a).setTextColor(Color.parseColor("#00a5e0"));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rpd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */