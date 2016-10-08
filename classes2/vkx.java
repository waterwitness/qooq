import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.mobileqq.troop.activity.VideoRecordActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.io.File;

public class vkx
  extends Handler
{
  public vkx(VideoRecordActivity paramVideoRecordActivity, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1: 
    default: 
      return;
    case 2: 
      VideoRecordActivity.a(this.a).a(this.a.getString(2131364820, new Object[] { Integer.valueOf(paramMessage.arg1) }));
      return;
    }
    switch (paramMessage.arg1)
    {
    default: 
      return;
    }
    this.a.a(-1);
    this.a.d(false);
    VideoRecordActivity.a(this.a).dismiss();
    long l = new File(VideoRecordActivity.a(this.a).a).length();
    paramMessage = new Intent();
    paramMessage.putExtra("video_path", VideoRecordActivity.a(this.a).a);
    ThreadManager.a(new vky(this), 5, null, true);
    if (VideoRecordActivity.a(this.a) == 1)
    {
      String str = String.format("%.2fMB", new Object[] { Double.valueOf(l / 1024.0D / 1024.0D) });
      DialogUtil.a(this.a, 232, null, this.a.getString(2131365290, new Object[] { str }), new vkz(this, paramMessage), new vla(this)).show();
      return;
    }
    this.a.setResult(-1, paramMessage);
    VideoRecordActivity.d(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vkx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */