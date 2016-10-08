import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader.OnVideoDownloadListener;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class iol
  implements PlayingListPreloader.OnVideoDownloadListener
{
  public iol(StoryPlayVideoActivity paramStoryPlayVideoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(String paramString1, String paramString2, ErrorMessage paramErrorMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory.player.StoryPlayVideoActivity", 2, "Download video failed,vid=" + paramString1);
    }
    this.a.runOnUiThread(new ion(this, paramString1, paramString2));
  }
  
  public void a(String paramString1, String paramString2, File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.player.StoryPlayVideoActivity", 2, "get video download finish,vid=" + paramString1);
    }
    this.a.runOnUiThread(new iom(this, paramString1, paramFile));
  }
  
  public void b(String paramString1, String paramString2, File paramFile) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */