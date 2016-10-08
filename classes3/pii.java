import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.activity.selectmember.TroopListAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class pii
  extends ProtoUtils.TroopProtocolObserver
{
  public pii(TroopListAdapter paramTroopListAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.b.get();
    if ((paramInt != 0) || (paramArrayOfByte == null) || (localQQAppInterface == null)) {
      return;
    }
    ThreadManager.a(new pij(this, localQQAppInterface, paramArrayOfByte, paramBundle, new Handler(Looper.getMainLooper())), 8, null, true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pii.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */