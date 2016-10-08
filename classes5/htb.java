import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.biz.pubaccount.VideoUIController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class htb
  implements SeekBar.OnSeekBarChangeListener
{
  public htb(VideoUIController paramVideoUIController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (this.a.a == null) {
      return;
    }
    long l = this.a.a.getDuration();
    int i = (int)(paramInt / 100.0D * l);
    paramInt = i;
    if (Math.abs(l - i) < 3000L)
    {
      paramInt = i;
      if (l > 20000L) {
        paramInt = (int)l - 3000;
      }
    }
    this.a.b(paramInt);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.a.i = true;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (this.a.a == null) {
      return;
    }
    this.a.i = false;
    int i = paramSeekBar.getProgress();
    long l = this.a.a.getDuration();
    int j = (int)(i / 100.0D * l);
    i = j;
    if (Math.abs(l - j) < 3000L)
    {
      i = j;
      if (l > 20000L) {
        i = (int)l - 3000;
      }
    }
    this.a.a.seekTo(i);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\htb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */