import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.OlympicTorchManager.TorchUpdateListener;
import mqq.os.MqqHandler;

public class kqa
  implements OlympicTorchManager.TorchUpdateListener
{
  public kqa(BaseChatPie paramBaseChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString)
  {
    if (paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
      this.a.jdField_a_of_type_MqqOsMqqHandler.post(new kqb(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kqa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */