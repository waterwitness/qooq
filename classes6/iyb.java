import com.tencent.biz.qqstory.takevideo.doodle.ui.face.NormalFacePackage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.FileFilter;

public class iyb
  implements FileFilter
{
  public iyb(NormalFacePackage paramNormalFacePackage)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    return (paramFile.endsWith(".jpg")) || (paramFile.endsWith(".png")) || (paramFile.endsWith(".bmp"));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iyb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */