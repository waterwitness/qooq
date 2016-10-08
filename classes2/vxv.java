import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDecodeTask;
import com.tencent.mobileqq.util.FaceDecodeTask.FaceDecodeThreadInfo;
import java.util.ArrayList;

public class vxv
  extends Thread
{
  private boolean a;
  
  private vxv()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = true;
  }
  
  public void a()
  {
    this.a = false;
  }
  
  public void run()
  {
    setName("FaceDecodeThread" + getId());
    Object localObject1 = BaseApplicationImpl.processName;
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals("com.tencent.mobileqq"))) {
      Process.setThreadPriority(-8);
    }
    for (;;)
    {
      localObject1 = null;
      label53:
      if (this.a) {
        synchronized (FaceDecodeTask.a)
        {
          int i = FaceDecodeTask.a.size();
          if (i == 0) {}
          try
          {
            FaceDecodeTask.a.wait();
            localObject3 = localObject1;
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              Object localObject3;
              Object localObject4 = localObject2;
            }
          }
          localObject1 = localObject3;
          if (localObject3 == null) {
            break label53;
          }
          ((FaceDecodeTask)localObject3).a();
          localObject1 = localObject3;
          break label53;
          if (FaceDecodeTask.b().c != Integer.MIN_VALUE)
          {
            Process.setThreadPriority(FaceDecodeTask.b().c);
            continue;
            localObject3 = (FaceDecodeTask)FaceDecodeTask.a.remove(0);
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vxv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */