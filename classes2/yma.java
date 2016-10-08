import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.lyric.util.Singleton;
import cooperation.qzone.font.FontManager;

public final class yma
  extends Singleton
{
  public yma()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected FontManager a(Void paramVoid)
  {
    return new FontManager();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yma.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */