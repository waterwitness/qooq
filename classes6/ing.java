import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.pgc.view.VideoContentView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class ing
  implements DialogInterface.OnClickListener
{
  public ing(VideoContentView paramVideoContentView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.pause();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */