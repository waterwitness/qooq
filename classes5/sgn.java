import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class sgn
  implements Runnable
{
  sgn(sgk paramsgk)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("PreviewStep_1", 4, "FAILED OnFileWeiYunPreview harcode[" + FMConfig.a + "]");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sgn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */