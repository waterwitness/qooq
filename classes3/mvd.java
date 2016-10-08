import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ATroopMember;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DBUtils;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

class mvd
  implements Runnable
{
  mvd(mvb parammvb, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_Mvb.a.app.getManager(50);
    TroopMemberInfo localTroopMemberInfo = DBUtils.a().a(this.jdField_a_of_type_Mvb.a.app, this.jdField_a_of_type_Mvb.a.k, this.jdField_a_of_type_JavaLangString);
    TroopMemberCardInfo localTroopMemberCardInfo = DBUtils.a().a(this.jdField_a_of_type_Mvb.a.app, this.jdField_a_of_type_Mvb.a.k, this.jdField_a_of_type_Mvb.a.L);
    if ((localTroopMemberCardInfo != null) && (this.jdField_a_of_type_Mvb.a.a != null) && (this.jdField_a_of_type_Mvb.a.J == 6)) {}
    synchronized (this.jdField_a_of_type_Mvb.a.a)
    {
      this.jdField_a_of_type_Mvb.a.a.put(this.jdField_a_of_type_Mvb.a.L, localTroopMemberCardInfo);
      if ((localTroopMemberInfo != null) && (localFriendsManager != null))
      {
        ??? = this.jdField_a_of_type_Mvb.a.a(localTroopMemberInfo, localFriendsManager);
        ThreadManager.c().post(new mve(this, (TroopMemberListActivity.ATroopMember)???));
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mvd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */