import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessagePBElemDecoder;
import cooperation.dingdong.data.OfficeCenterSharedPref;

public class upd
  implements Runnable
{
  public upd(MessagePBElemDecoder paramMessagePBElemDecoder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!OfficeCenterSharedPref.a().a(MessagePBElemDecoder.a(this.a).a() + "officecenter_receive_schedule_message", false)) {
      OfficeCenterSharedPref.a().b(MessagePBElemDecoder.a(this.a).a() + "officecenter_receive_schedule_message", true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\upd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */