import android.os.Bundle;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.TroopFileProtocol.ReqFeedsObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.Map;
import java.util.UUID;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.FeedsRspBody;

public class vqh
  extends TroopFileProtocol.ReqFeedsObserver
{
  public vqh(TroopFileTransferManager paramTroopFileTransferManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d9.FeedsRspBody paramFeedsRspBody, Bundle paramBundle)
  {
    if (!paramBoolean) {}
    do
    {
      do
      {
        return;
        paramInt = paramFeedsRspBody.int32_ret_code.get();
        paramFeedsRspBody = paramBundle.getString("itemKey");
      } while (paramFeedsRspBody == null);
      paramFeedsRspBody = UUID.fromString(paramFeedsRspBody);
      paramFeedsRspBody = (TroopFileInfo)this.a.a().b.get(paramFeedsRspBody);
    } while ((paramFeedsRspBody == null) || (paramInt != 0));
    TroopFileProtocol.a(this.a.a, this.a.g, paramFeedsRspBody.a, paramFeedsRspBody.b, TroopFileTransferManager.a(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vqh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */