import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.Map;
import java.util.UUID;

public class vqc
  extends Handler
{
  public vqc(TroopFileTransferManager paramTroopFileTransferManager, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = (UUID)paramMessage.getData().get("UUID");
    if (paramMessage == null) {}
    do
    {
      return;
      paramMessage = (TroopFileTransferManager.Item)this.a.b.get(paramMessage);
    } while (paramMessage == null);
    this.a.b.remove(paramMessage.Id);
    paramMessage.ErrorCode = 0;
    this.a.a(paramMessage, 7);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vqc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */