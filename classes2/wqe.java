import android.graphics.Bitmap;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.util.HandlerPlus;
import com.tencent.protofile.getappinfo.GetAppInfoProto.MsgIconsurl;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

class wqe
  implements Runnable
{
  wqe(wqa paramwqa, GetAppInfoProto.MsgIconsurl paramMsgIconsurl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Bitmap localBitmap = AuthorityActivity.a(this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$MsgIconsurl.url.get());
    this.jdField_a_of_type_Wqa.a.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(AuthorityActivity.y, localBitmap);
    if (localBitmap != null)
    {
      Message localMessage = new Message();
      localMessage.obj = localBitmap;
      localMessage.what = 4;
      this.jdField_a_of_type_Wqa.a.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.sendMessage(localMessage);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wqe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */