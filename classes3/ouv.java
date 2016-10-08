import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public class ouv
  implements Runnable
{
  public ouv(PreloadManager paramPreloadManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      Object localObject = new File(PreloadManager.a(this.a.a));
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      localObject = PreloadManager.b(this.a.a);
      String str = PreloadManager.c(this.a.a);
      if (TextUtils.isEmpty(str)) {}
      for (;;)
      {
        localObject = new File((String)localObject).listFiles();
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          str = localObject[i];
          if (str.exists()) {
            str.delete();
          }
          i += 1;
        }
        localObject = str;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ouv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */