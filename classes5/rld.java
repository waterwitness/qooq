import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public final class rld
  implements Runnable
{
  public rld(String paramString1, Activity paramActivity, Emoticon paramEmoticon, String paramString2, String paramString3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool = new File(this.jdField_a_of_type_JavaLangString).exists();
    new Handler(Looper.getMainLooper()).post(new rle(this, bool));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */