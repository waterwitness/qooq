import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;

public class vae
  implements Runnable
{
  public vae(C2CPicUploadProcessor paramC2CPicUploadProcessor)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    switch (this.a.bm)
    {
    default: 
      return;
    case 0: 
      this.a.c("<BDH_LOG> sendFileNotBlockCallThread() BUT current status is INIT");
      return;
    case 2: 
      this.a.c("<BDH_LOG> sendFileNotBlockCallThread() resume HTTP channel");
      this.a.s();
      return;
    }
    if (this.a.b != null)
    {
      this.a.c("<BDH_LOG> sendFileNotBlockCallThread() resume BDH channel");
      this.a.a.a().resumeTransactionTask(this.a.b);
      return;
    }
    this.a.c("<BDH_LOG> sendFileNotBlockCallThread() resume BDH channel, but trans == null");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */