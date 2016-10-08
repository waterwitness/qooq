import android.os.Handler;
import android.os.Message;
import com.tencent.arrange.ui.CreateArrageActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.MyGridView;

public class gdj
  extends Handler
{
  public gdj(CreateArrageActivity paramCreateArrageActivity)
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
    } while (CreateArrageActivity.a(this.a) == null);
    CreateArrageActivity.a(this.a).setPadding(CreateArrageActivity.b(this.a), CreateArrageActivity.c(this.a), CreateArrageActivity.d(this.a), CreateArrageActivity.e(this.a));
    CreateArrageActivity.a(this.a).notifyDataSetChanged();
    removeMessages(0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gdj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */