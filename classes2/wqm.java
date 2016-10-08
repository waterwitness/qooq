import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.BindGroupConfirmActivity;
import com.tencent.protofile.getappinfo.GetAppInfoProto.MsgIconsurl;

class wqm
  implements Runnable
{
  wqm(wql paramwql, GetAppInfoProto.MsgIconsurl paramMsgIconsurl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Bitmap localBitmap = AuthorityActivity.a(this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$MsgIconsurl.url.get());
    if (localBitmap != null)
    {
      Message localMessage = new Message();
      localMessage.obj = localBitmap;
      localMessage.what = 4;
      this.jdField_a_of_type_Wql.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wqm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */