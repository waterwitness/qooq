import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.AppleEmojiManager;
import java.io.File;

public final class uzd
  implements Runnable
{
  public uzd(File paramFile1, File paramFile2, File paramFile3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.exists()) {
      this.a.delete();
    }
    if (this.b.exists()) {
      this.b.delete();
    }
    AppleEmojiManager.a(this.c);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */