import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.audiopanel.RecordSoundPanel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class ngz
  extends Handler
{
  public ngz(RecordSoundPanel paramRecordSoundPanel, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.a.e(1);
    this.a.d();
    QQToast.a(this.a.a.a(), this.a.a.a().getString(2131367635), 1).a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ngz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */