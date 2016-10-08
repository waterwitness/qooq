import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rzz
  implements Runnable
{
  public rzz(UniformDownloadMgr paramUniformDownloadMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    UniformDownloadMgr.b(this.a, null);
    UniformDownloadMgr.b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */