import com.tencent.biz.pubaccount.VideoPlayMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnNetVideoInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo.DefnInfo;
import java.util.ArrayList;
import java.util.Iterator;

public class hrx
  implements TVK_IMediaPlayer.OnNetVideoInfoListener
{
  public hrx(VideoPlayMgr paramVideoPlayMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onNetVideoInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, TVK_NetVideoInfo paramTVK_NetVideoInfo)
  {
    paramTVK_IMediaPlayer = paramTVK_NetVideoInfo.getCurDefinition().getmDefnName();
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoPlayMgr", 2, "onNetVideoInfo() currentDefn=" + paramTVK_IMediaPlayer);
    }
    paramTVK_IMediaPlayer = paramTVK_NetVideoInfo.getDefinitionList();
    if (paramTVK_IMediaPlayer != null)
    {
      paramTVK_IMediaPlayer = paramTVK_IMediaPlayer.iterator();
      while (paramTVK_IMediaPlayer.hasNext())
      {
        paramTVK_NetVideoInfo = (TVK_NetVideoInfo.DefnInfo)paramTVK_IMediaPlayer.next();
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.VideoPlayMgr", 2, "onNetVideoInfo() defnList defnName=" + paramTVK_NetVideoInfo.getmDefnName());
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hrx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */