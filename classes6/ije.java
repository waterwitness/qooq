import com.tencent.biz.qqstory.model.DoodleEmojiManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.FileFilter;

public class ije
  implements FileFilter
{
  public ije(DoodleEmojiManager paramDoodleEmojiManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean accept(File paramFile)
  {
    return (paramFile.isDirectory()) && (paramFile.getName().startsWith("emoji_folder_"));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ije.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */