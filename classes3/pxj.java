import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.FaceDownloader;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class pxj
  implements Runnable
{
  public pxj(FaceDownloader paramFaceDownloader)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.aio_config.name(), "-1|1=0,2=0,3=0,4=0,5=1|1|999|4|1|0_2|1");
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.FaceDownloader", 2, "initDPCFlag headWapConn:" + (String)localObject);
    }
    localObject = ((String)localObject).split("\\|");
    if (localObject.length > 7) {}
    try
    {
      FaceDownloader.a(Integer.parseInt(localObject[7]));
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDownloader", 2, "initDPCFlag DPC_WAP_DIRECT_CONNECT=" + FaceDownloader.b());
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.qqhead.FaceDownloader", 2, "initDPCFlag error :", localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pxj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */