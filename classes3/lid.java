import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

public class lid
  implements Runnable
{
  public lid(EmosmActivity paramEmosmActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = AppConstants.bU + this.jdField_a_of_type_JavaLangString;
    File localFile = new File((String)localObject);
    localObject = new File((String)localObject + "del");
    if (localFile.renameTo((File)localObject))
    {
      FileUtils.a(((File)localObject).getAbsolutePath());
      return;
    }
    FileUtils.a(localFile.getAbsolutePath());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */