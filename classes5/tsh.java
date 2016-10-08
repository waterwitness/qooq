import android.view.View;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.transfile.FileMsg;

public class tsh
  implements FileTransferManager.Callback
{
  public tsh(OpenApiManager paramOpenApiManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    this.a.a(paramFileMsg, paramInt1, paramInt2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tsh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */