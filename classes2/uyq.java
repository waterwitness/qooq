import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.testassister.ShareAppLogHelper;
import java.io.File;

public class uyq
  extends Thread
{
  public uyq(ShareAppLogHelper paramShareAppLogHelper, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      if (localFile.exists()) {
        localFile.delete();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uyq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */