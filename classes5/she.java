import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TroopLocalVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;

public class she
  implements TVK_IMediaPlayer.OnErrorListener
{
  public she(TroopLocalVideoFileView paramTroopLocalVideoFileView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (paramString != null) {
      FMToastUtil.a("对不起，该音频文件无法播放！");
    }
    for (;;)
    {
      if (TroopLocalVideoFileView.c(this.a) != null) {
        TroopLocalVideoFileView.d(this.a).d();
      }
      if (TroopLocalVideoFileView.d(this.a) != null) {
        TroopLocalVideoFileView.e(this.a).runOnUiThread(new shf(this));
      }
      if (QLog.isColorLevel())
      {
        paramTVK_IMediaPlayer = new StringBuilder();
        paramTVK_IMediaPlayer.append("video player error model=" + paramInt1);
        paramTVK_IMediaPlayer.append(",what=" + paramInt2);
        paramTVK_IMediaPlayer.append(",extra=" + paramInt3);
        paramTVK_IMediaPlayer.append(",detailInfo=" + paramString);
        QLog.d("LocalVideoFileView", 2, paramTVK_IMediaPlayer.toString());
      }
      return false;
      FMToastUtil.a(paramString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\she.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */