import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.DeviceApiPlugin;
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

public class sxp
  implements FileFilter
{
  public sxp(DeviceApiPlugin paramDeviceApiPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean accept(File paramFile)
  {
    return Pattern.matches("cpu[0-9]", paramFile.getName());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sxp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */