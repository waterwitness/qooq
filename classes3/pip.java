import com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class pip
  implements Runnable
{
  public pip(TroopMemberListInnerFrame paramTroopMemberListInnerFrame)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListInnerFrame", 2, "read troop members from database before updating data from server");
    }
    TroopMemberListInnerFrame.a(this.a, this.a.b, null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */