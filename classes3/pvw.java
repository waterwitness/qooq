import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import java.io.File;
import java.net.URL;

public class pvw
  implements Runnable
{
  public pvw(ConfigHandler paramConfigHandler, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    File localFile = new File(this.jdField_a_of_type_JavaLangString);
    try
    {
      if (HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.b, new URL(this.b), localFile)) {
        this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a(3, true, this.jdField_a_of_type_JavaLangString);
      }
      ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler, this.b);
      return;
    }
    catch (Exception localException)
    {
      localException = localException;
      ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler, this.b);
      return;
    }
    finally
    {
      localObject = finally;
      ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler, this.b);
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pvw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */