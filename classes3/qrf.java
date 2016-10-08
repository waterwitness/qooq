import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.FileFilter;

public final class qrf
  implements FileFilter
{
  public qrf(String paramString, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean accept(File paramFile)
  {
    String str = paramFile.getName();
    int i = str.lastIndexOf('.');
    if (i <= 0) {}
    do
    {
      do
      {
        return false;
      } while (!str.substring(i).equalsIgnoreCase(".app"));
      str = str.substring(0, i);
    } while ((!ArkLocalAppMgr.b(str)) || (ArkLocalAppMgr.a(str, this.jdField_a_of_type_JavaLangString) >= 0));
    if (this.jdField_a_of_type_Boolean) {
      paramFile.deleteOnExit();
    }
    for (;;)
    {
      return true;
      paramFile.delete();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qrf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */