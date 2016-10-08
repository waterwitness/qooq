import android.util.Base64;
import com.tencent.mobileqq.activity.qwallet.fragment.QzoneHbFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.FileInputStream;
import org.json.JSONObject;

public class our
  implements Runnable
{
  public our(QzoneHbFragment paramQzoneHbFragment, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = new File(this.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder;
    if (((File)localObject).exists()) {
      try
      {
        localObject = new FileInputStream((File)localObject);
        byte[] arrayOfByte = new byte['Ѐ'];
        localStringBuilder = new StringBuilder();
        for (;;)
        {
          int i = ((FileInputStream)localObject).read(arrayOfByte);
          if (i <= 0) {
            break;
          }
          localStringBuilder.append(new String(arrayOfByte, 0, i));
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    JSONObject localJSONObject;
    do
    {
      localException.close();
      localJSONObject = new JSONObject(new String(Base64.decode(localStringBuilder.toString(), 0)));
    } while (localJSONObject == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment.a(localJSONObject);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\our.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */