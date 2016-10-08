import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.c2b.C2BUploadFileActivity;
import java.util.TimerTask;

public class xzv
  extends TimerTask
{
  public xzv(C2BUploadFileActivity paramC2BUploadFileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (System.currentTimeMillis() - this.a.a.longValue() >= 15000L) {
      this.a.a("网络超时，上传文件失败！");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */