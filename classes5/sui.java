import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.hotchat.HotChatPttStageControl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class sui
  implements FileTransferManager.Callback
{
  public sui(HotChatPttStageControl paramHotChatPttStageControl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (!this.a.b) {}
    while ((paramFileMsg.e != 2) || (paramInt1 == 2002) || (paramInt1 == 1002) || (paramInt1 == 2001) || (paramInt1 != 1005)) {
      return;
    }
    paramInt1 = this.a.a.getResources().getDimensionPixelSize(2131492908);
    QQToast.a(BaseApplication.getContext(), 1, "语音消息发布失败，请重试。", 0).b(paramInt1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */