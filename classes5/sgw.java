import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TroopLocalVideoFileView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class sgw
  implements View.OnClickListener
{
  public sgw(TroopLocalVideoFileView paramTroopLocalVideoFileView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.a != null)
    {
      if (this.a.a.isPlaying()) {
        TroopLocalVideoFileView.a(this.a);
      }
    }
    else {
      return;
    }
    TroopLocalVideoFileView.b(this.a);
    new Handler().postDelayed(new sgx(this), 2000L);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sgw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */