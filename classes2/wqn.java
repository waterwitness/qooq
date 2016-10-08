import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.BindGroupConfirmActivity;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.qphone.base.util.QLog;

public class wqn
  implements Runnable
{
  public wqn(BindGroupConfirmActivity paramBindGroupConfirmActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a == null) {}
    for (;;)
    {
      return;
      Object localObject2 = null;
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeResource(this.a.a, 2130839485);
        if (localBitmap == null) {
          continue;
        }
        localBitmap = AuthorityUtil.a(this.a, localBitmap, 50, 50);
        if (localBitmap == null) {
          continue;
        }
        this.a.runOnUiThread(new wqo(this, localBitmap));
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          Object localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("BindGroupConfirmActivity", 2, "initUI decodeResource has OutOfMemoryError!");
            localObject1 = localObject2;
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wqn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */