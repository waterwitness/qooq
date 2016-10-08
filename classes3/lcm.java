import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class lcm
  extends TroopObserver
{
  public lcm(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onupdaterecentlist");
    }
    this.a.a(0L);
  }
  
  protected void a(int paramInt, byte paramByte, String paramString)
  {
    if (paramInt == 6) {
      if (paramByte == 0)
      {
        TroopAssistantManager.a().c(this.a.a);
        this.a.a(8, paramString, 1);
        this.a.a(8, AppConstants.am, 5000);
      }
    }
    while ((paramInt != 2) || (paramByte != 0)) {
      return;
    }
    TroopAssistantManager.a().b(paramString, this.a.a);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_ontroopmanagersuccess");
    }
    this.a.a(8, paramString, 1);
    this.a.a(8, AppConstants.am, 5000);
  }
  
  protected void a(boolean paramBoolean)
  {
    TroopAssistantManager.a().c(this.a.a);
  }
  
  protected void a(boolean paramBoolean1, byte paramByte, TroopInfo paramTroopInfo, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.a.a(8, AppConstants.am, 5000);
      if (paramTroopInfo != null) {
        this.a.a(8, paramTroopInfo.troopuin, 1);
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.a.a(8, paramString, 1);
      this.a.a(8, AppConstants.am, 5000);
    }
  }
  
  protected void a(boolean paramBoolean1, ArrayList paramArrayList, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = (TroopMemberCardInfo)paramArrayList.get(0);
      if (paramArrayList != null)
      {
        this.a.a(8, paramArrayList.troopuin, 1);
        this.a.a(8, paramArrayList.memberuin, Integer.MIN_VALUE);
        this.a.a(8, AppConstants.am, 5000);
        this.a.s();
      }
    }
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "Conversation.onGetTroopMemberCard isSuccess=" + paramBoolean + " data=" + paramObject);
    }
    if ((paramBoolean) && (paramObject != null))
    {
      long l = ((Long)((Object[])(Object[])paramObject)[0]).longValue();
      this.a.a(8, String.valueOf(l), 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lcm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */