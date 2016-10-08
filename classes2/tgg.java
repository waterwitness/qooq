import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.music.IQQPlayerCallback.Stub;
import com.tencent.mobileqq.music.IQQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin;

public class tgg
  extends IQQPlayerCallback.Stub
{
  public tgg(MusicGeneWebViewPlugin paramMusicGeneWebViewPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    MusicGeneWebViewPlugin.a(this.a, paramInt);
    if (paramInt == 2) {
      MusicGeneWebViewPlugin.a(this.a, MusicGeneWebViewPlugin.a(this.a).c());
    }
  }
  
  public void a(SongInfo paramSongInfo)
  {
    if (MusicGeneWebViewPlugin.a(this.a) != null) {
      MusicGeneWebViewPlugin.a(this.a, MusicGeneWebViewPlugin.a(this.a).a());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tgg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */