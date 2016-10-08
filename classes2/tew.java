import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x5RspBQRecommend;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import mqq.app.MobileQQ;

public class tew
  implements Runnable
{
  public tew(EmoticonManager paramEmoticonManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = new File(this.a.a.getApplication().getFilesDir(), "recommemd_emotion_file_" + this.a.a.f());
    if (!((File)localObject).exists()) {}
    try
    {
      ((File)localObject).createNewFile();
      arrayOfByte = FileUtils.a((File)localObject);
      localObject = new EmosmPb.SubCmd0x5RspBQRecommend();
      if (arrayOfByte == null) {}
    }
    catch (IOException localIOException)
    {
      try
      {
        byte[] arrayOfByte;
        ((EmosmPb.SubCmd0x5RspBQRecommend)localObject).mergeFrom(arrayOfByte);
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonManager", 2, "writeRecommendInfoFromFileToCache post to uithread");
          }
          EmoticonManager.a(this.a).post(new tex(this, (EmosmPb.SubCmd0x5RspBQRecommend)localObject));
        }
        return;
        localIOException = localIOException;
        localIOException.printStackTrace();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject = null;
          localException.printStackTrace();
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */