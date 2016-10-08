import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ova
  implements AsyncBack
{
  public ova(PreloadManager paramPreloadManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(PreloadManager.a(), 2, "checkUpByBusinessId progress:" + paramInt);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(PreloadManager.a(), 2, "checkUpByBusinessId loaded, code:" + paramInt);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ova.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */