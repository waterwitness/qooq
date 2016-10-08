import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class pkn
  implements DialogInterface.OnClickListener
{
  public pkn(ShortVideoPlayActivity paramShortVideoPlayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.a != null) {
      this.a.a.pauseDownload();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pkn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */