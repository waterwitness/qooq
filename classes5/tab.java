import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.lyric.widget.LyricViewInternal;

public class tab
  extends Handler
{
  public tab(LyricViewInternal paramLyricViewInternal, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.a.requestLayout();
    this.a.invalidate();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */