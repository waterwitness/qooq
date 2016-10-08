import com.tencent.biz.qqstory.model.DoodleEmojiManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.FilenameFilter;

public class ijf
  implements FilenameFilter
{
  public ijf(DoodleEmojiManager paramDoodleEmojiManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".bmp"));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ijf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */