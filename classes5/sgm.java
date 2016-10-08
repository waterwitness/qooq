import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class sgm
  implements Runnable
{
  sgm(sgk paramsgk)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("PreviewStep_1", 4, "FAILED OnFileDiscOfflinePreview harcode[" + FMConfig.a + "]");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sgm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */