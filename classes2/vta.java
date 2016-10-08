import android.os.Handler;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.MediaControllerX;
import com.tencent.mobileqq.troop.widget.MediaControllerX.MediaPlayerControlX;

public class vta
  implements SeekBar.OnSeekBarChangeListener
{
  public vta(MediaControllerX paramMediaControllerX)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    long l;
    do
    {
      return;
      MediaControllerX.a(this.a).d();
      l = MediaControllerX.a(this.a).a() * paramInt / 1000L;
      MediaControllerX.a(this.a).a((int)l);
    } while (MediaControllerX.a(this.a) == null);
    MediaControllerX.a(this.a).setText(MediaControllerX.a(this.a, (int)l));
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.a.a(3600000);
    MediaControllerX.b(this.a, true);
    MediaControllerX.a(this.a).removeMessages(2);
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    MediaControllerX.b(this.a, false);
    MediaControllerX.a(this.a);
    this.a.d();
    this.a.a(5000);
    MediaControllerX.a(this.a).sendEmptyMessage(2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */