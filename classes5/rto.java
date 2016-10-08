import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;

public class rto
  implements Runnable
{
  public rto(QfileLocalFileMediaTabView paramQfileLocalFileMediaTabView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    HashMap localHashMap1 = new HashMap();
    String str = FMSettings.a().a();
    if ((QfileLocalFileMediaTabView.a(this.a) & 0x1) > 0)
    {
      FileCategoryUtil.a(FMSettings.a().b(), ".mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|", ".mpg", localHashMap1, null);
      if (str != null) {
        FileCategoryUtil.a(str, ".mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|", ".mpg", localHashMap1, null);
      }
      FileCategoryUtil.a(localHashMap1);
    }
    HashMap localHashMap2 = new HashMap();
    if ((QfileLocalFileMediaTabView.a(this.a) & 0x2) > 0)
    {
      FileCategoryUtil.a(FMSettings.a().b(), ".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4a|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|", "", localHashMap2, null);
      if (str != null) {
        FileCategoryUtil.a(str, ".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4a|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|", "", localHashMap2, null);
      }
      FileCategoryUtil.a(localHashMap2);
    }
    QfileLocalFileMediaTabView.a(this.a, new rtp(this, localHashMap2, localHashMap1));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */