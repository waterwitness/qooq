import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class uiy
  implements Runnable
{
  public uiy(StatusHistoryActivity paramStatusHistoryActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "get ower head is called,time is:" + System.currentTimeMillis());
    }
    Object localObject1 = null;
    int i = this.a.getResources().getDimensionPixelSize(2131493004);
    if (this.a.app.a().equals(StatusHistoryActivity.a(this.a))) {}
    for (;;)
    {
      try
      {
        Object localObject2 = ProfileCardUtil.b();
        Object localObject4 = new File((String)localObject2);
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localObject4 = new FileInputStream((File)localObject4);
        localOptions.inSampleSize = ((int)ImageUtil.a((InputStream)localObject4, i, i));
        ((InputStream)localObject4).close();
        localObject2 = BitmapManager.a((String)localObject2, localOptions);
        localObject1 = localObject2;
        if (localObject2 != null) {}
        if (!QLog.isColorLevel()) {
          break label232;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          localObject1 = this.a.app.a((Bitmap)localObject2, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.a.app.a(StatusHistoryActivity.a(this.a), true);
          }
          if (localObject2 != null)
          {
            localObject1 = StatusHistoryActivity.a(this.a).obtainMessage(2);
            ((Message)localObject1).obj = localObject2;
            StatusHistoryActivity.a(this.a).sendMessage((Message)localObject1);
          }
          return;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            localObject1 = localException1;
            Object localObject3 = localException2;
          }
        }
        localException1 = localException1;
      }
      QLog.d("Q.richstatus.history", 2, localException1.toString());
      label232:
      continue;
      localObject1 = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uiy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */