import android.os.AsyncTask;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;

public class odi
  extends AsyncTask
{
  public odi(TroopChatPie paramTroopChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected TroopGagMgr.SelfGagInfo a(Void... paramVarArgs)
  {
    this.a.aQ();
    return ((TroopGagMgr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, true);
  }
  
  protected void a(TroopGagMgr.SelfGagInfo paramSelfGagInfo)
  {
    this.a.a(paramSelfGagInfo, true);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\odi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */