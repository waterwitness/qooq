import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import cooperation.c2b.C2BUploadFileActivity;

public class xzu
  implements INetEventHandler
{
  public xzu(C2BUploadFileActivity paramC2BUploadFileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    this.a.d("onNetChangeEvent var1=" + paramBoolean);
    this.a.a("网络变化，上传文件失败！");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */