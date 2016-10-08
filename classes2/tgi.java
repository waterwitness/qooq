import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class tgi
  extends Handler
{
  public tgi(MusicGeneWebViewPlugin paramMusicGeneWebViewPlugin, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = paramMessage.getData();
    if (localObject != null) {}
    for (localObject = ((Bundle)localObject).getString("BUNDLE_KEY_FILE_PATH");; localObject = null)
    {
      paramMessage = (Bitmap)paramMessage.obj;
      if ((paramMessage != null) && (localObject != null))
      {
        localObject = new File((String)localObject);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
      }
      try
      {
        localObject = new FileOutputStream((File)localObject);
        paramMessage.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject);
        ((FileOutputStream)localObject).flush();
        ((FileOutputStream)localObject).close();
        return;
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tgi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */