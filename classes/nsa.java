import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.TroopRewardItemBuilder;
import com.tencent.mobileqq.activity.aio.item.TroopRewardItemBuilder.JumpClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;

public class nsa
  implements DialogInterface.OnClickListener
{
  public nsa(TroopRewardItemBuilder.JumpClickListener paramJumpClickListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TVK_SDKMgr.installPlugin(this.a.a.a.getApplicationContext(), new nsc(this.a.a.b));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nsa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */