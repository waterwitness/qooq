import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.VideoUIController;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;

public class htj
  implements TVK_IMediaPlayer.OnErrorListener
{
  public htj(VideoUIController paramVideoUIController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoUIController", 2, "mMediaPlayer onError model=" + paramInt1 + ", what, " + paramInt2 + ", extra=" + paramInt3 + ", detailInfo=" + paramString);
    }
    paramTVK_IMediaPlayer = "";
    if (TextUtils.isEmpty(this.a.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"))) {
      paramTVK_IMediaPlayer = this.a.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID");
    }
    VideoReporter.a("0X8006757", this.a.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_AIO_UIN_TYPE"), paramInt2, paramTVK_IMediaPlayer, Integer.toString(this.a.s));
    this.a.l = 1;
    this.a.jdField_a_of_type_AndroidOsHandler.post(new htk(this, paramInt2));
    PublicAccountUtil.a(this.a.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID"), this.a.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"), 1, paramInt2);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\htj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */