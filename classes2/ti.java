import com.etrump.mixlayout.FontInfo;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FilenameFilter;
import java.util.concurrent.ConcurrentHashMap;

class ti
  implements FilenameFilter
{
  ti(th paramth)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    if (paramString.endsWith(".ttf")) {
      paramString = paramFile.getAbsolutePath() + File.separatorChar + paramString;
    }
    try
    {
      paramFile = paramFile.getAbsolutePath().split(File.separator);
      paramFile = new FontInfo(Integer.parseInt(paramFile[(paramFile.length - 1)]), paramString);
      FontManager.a.putIfAbsent(Integer.valueOf(paramFile.a), paramFile);
      return false;
    }
    catch (Exception paramFile)
    {
      for (;;)
      {
        QLog.e("FontManager", 1, "updateFontList listFile error: " + paramFile.getMessage());
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ti.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */