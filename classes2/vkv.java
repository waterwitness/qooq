import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.mobileqq.troop.activity.VideoRecordActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class vkv
  extends QQProgressDialog
{
  public vkv(VideoRecordActivity paramVideoRecordActivity, Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    EncodeThread.a();
    this.a.a(this.a.getResources().getString(2131364819));
    this.a.j.postDelayed(new vkw(this), 100L);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vkv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */