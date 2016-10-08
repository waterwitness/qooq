package cooperation.secmsg.ipc;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class BaseIpc
{
  public static final int a = 1;
  protected static SparseArray a;
  public static final int b = 2;
  protected static SparseArray b;
  public static final int c = 3;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a = new SparseArray();
    b = new SparseArray();
    a.put(1, RefreshRecentReq.class);
    a.put(3, UserFaceDrawableReq.class);
    b.put(3, UserFaceDrawableResp.class);
  }
  
  public abstract int a();
  
  public void a(Bundle paramBundle)
  {
    paramBundle.putInt("_secmsg_ipc_code", a());
  }
  
  public void b(Bundle paramBundle) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\secmsg\ipc\BaseIpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */