import android.os.Environment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class yse
{
  private static final File a;
  public static String a;
  private static File jdField_b_of_type_JavaIoFile;
  private static final String jdField_b_of_type_JavaLangString = "InnerEnvironment";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getAbsolutePath();
    jdField_a_of_type_JavaIoFile = new File(jdField_a_of_type_JavaLangString + File.separator + "Android" + File.separator + "data");
  }
  
  public static File a()
  {
    try
    {
      File localFile1 = a(BaseApplicationImpl.getContext().getPackageName());
      boolean bool = localFile1.exists();
      if (!bool) {
        try
        {
          new File(jdField_a_of_type_JavaIoFile, ".nomedia").createNewFile();
          if (!localFile1.mkdirs())
          {
            if (QLog.isColorLevel()) {
              QLog.w("InnerEnvironment", 2, "Unable to create external cache directory");
            }
            return null;
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            localIOException.printStackTrace();
          }
        }
      }
    }
    finally {}
    return localFile2;
  }
  
  public static File a(String paramString)
  {
    if (b != null) {
      return b;
    }
    b = new File(jdField_a_of_type_JavaIoFile, paramString + File.separator + "qzone");
    return b;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */