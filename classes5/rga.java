import com.tencent.mobileqq.dating.CarrierHelper;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rga
  implements Runnable
{
  public rga(MsgBoxListActivity paramMsgBoxListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (MsgBoxListActivity.a(this.a) != null) {
      MsgBoxListActivity.a(this.a).b("msglist_carrier_5.8");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */