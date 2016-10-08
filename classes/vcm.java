import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class vcm
  implements UpCallBack
{
  vcm(vcl paramvcl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    Object localObject;
    boolean bool;
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append(" onSend result is null ? ");
      if (paramSendResult == null)
      {
        bool = true;
        localObject = ((StringBuilder)localObject).append(bool).append(" result is: ");
        if (paramSendResult != null) {
          break label70;
        }
        i = -99;
        label45:
        QLog.i("NearbyPeoplePhotoUploadProcessor", 2, i);
      }
    }
    else
    {
      if (paramSendResult != null) {
        break label78;
      }
    }
    label70:
    label78:
    label149:
    label156:
    do
    {
      return;
      bool = false;
      break;
      i = paramSendResult.a;
      break label45;
      if (paramSendResult.a == 0)
      {
        bool = true;
        localObject = (CardHandler)this.a.a.a(2);
        if (localObject == null) {
          break label149;
        }
        ((CardHandler)localObject).a(bool, this.a.a.a(), 0);
      }
      for (;;)
      {
        if (bool) {
          break label156;
        }
        ProfileCardUtil.a("TransferRequest.onSend", paramSendResult.b, paramSendResult.toString());
        return;
        bool = false;
        break;
        ProfileCardUtil.a(null);
      }
    } while (((Integer)NearbySPUtil.a(this.a.a.getAccount(), "qq_avatar_type", Integer.valueOf(-1))).intValue() == 1);
    NearbySPUtil.a(this.a.a.getAccount(), "qq_avatar_type", Integer.valueOf(1));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\vcm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */