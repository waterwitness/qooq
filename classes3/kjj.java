import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kjj
  extends Handler
{
  public kjj(AddRequestActivity paramAddRequestActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      if ((AddRequestActivity.a(this.a) != null) && (AddRequestActivity.a(this.a).isShowing()))
      {
        AddRequestActivity.a(this.a).setText(this.a.getString(2131368655));
        AddRequestActivity.a(this.a).setVisibility(8);
        AddRequestActivity.a(this.a).setVisibility(0);
        AddRequestActivity.a(this.a).setImageResource(2130838452);
        postDelayed(new kjk(this), 1500L);
        return;
      }
      this.a.finish();
      return;
      this.a.a(true);
    } while ((AddRequestActivity.a(this.a) == null) || (!AddRequestActivity.a(this.a).isShowing()));
    AddRequestActivity.a(this.a).setText(this.a.getString(2131368656));
    AddRequestActivity.a(this.a).setVisibility(8);
    AddRequestActivity.a(this.a).setVisibility(0);
    AddRequestActivity.a(this.a).setImageResource(2130838442);
    postDelayed(new kjl(this), 1500L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kjj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */