import android.app.Activity;
import com.tencent.mobileqq.filemanager.activity.MPFileVerifyPwdView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.TimerTask;

class rpc
  extends TimerTask
{
  rpc(rpb paramrpb)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    MPFileVerifyPwdView.a(this.a.a).runOnUiThread(new rpd(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */