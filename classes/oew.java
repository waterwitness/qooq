import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.tips.ReaderTipsBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oew
  implements View.OnClickListener
{
  public oew(ReaderTipsBar paramReaderTipsBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.setAction("cooperation.qqreader.aioback2reader");
    paramView.putExtra("bookid", ReaderTipsBar.a(this.a));
    ReaderTipsBar.a(this.a).sendBroadcast(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */