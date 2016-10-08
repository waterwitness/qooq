import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ATroopMember;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x406.cmd0x406.GroupFeeMember;

public class mvb
  extends TroopObserver
{
  public mvb(TroopMemberListActivity paramTroopMemberListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (!this.a.k.equals(paramString1)) {
      return;
    }
    ThreadManager.a(new mvd(this, paramString2), 8, null, true);
  }
  
  protected void a(String paramString, boolean paramBoolean, List paramList)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = localStringBuilder1.append("Thread id:").append(Thread.currentThread().getId()).append(",threadName:").append(Thread.currentThread().getName()).append("|onUpdateTroopGetMemberList:").append(paramBoolean).append("|troopMemberInfoList size:");
      if (paramList == null)
      {
        paramString = "";
        localStringBuilder2.append(paramString).append("|time:").append((l - this.a.c) / 1000L).append("s");
        QLog.d("TroopMemberListActivityget_troop_member", 2, localStringBuilder1.toString());
      }
    }
    else
    {
      if (!paramBoolean) {
        break label364;
      }
    }
    for (;;)
    {
      try
      {
        this.a.getSharedPreferences("last_update_time" + this.a.app.a(), 0).edit().putLong("key_last_update_time" + this.a.k, System.currentTimeMillis()).commit();
        this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        if (this.a.J == 13) {
          continue;
        }
        this.a.b(this.a.k, paramList);
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(5, Boolean.valueOf(paramBoolean)));
        return;
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TroopMemberListActivityget_troop_member", 2, "onUpdateTroopGetMemberList:" + paramString.toString());
        return;
      }
      paramString = Integer.valueOf(paramList.size());
      break;
      paramString = this.a.a(this.a.k, this.a.e);
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, paramString));
    }
    label364:
    if (this.a.J != 13) {
      this.a.b(this.a.k, null);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(5, Boolean.valueOf(paramBoolean)));
      return;
      paramString = this.a.a(this.a.k, this.a.e);
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, paramString));
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "onDeleteTroopMember, isSuccess:" + paramBoolean + " errorCode:" + paramInt);
    }
    if (paramBoolean)
    {
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        this.a.l = true;
        this.a.a((String)paramArrayList.get(0));
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(6));
      }
      return;
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(7));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, int paramInt1, List paramList, long paramLong2, int paramInt2, String paramString)
  {
    if (!Utils.a(String.valueOf(paramLong1), this.a.k)) {}
    do
    {
      return;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(150);
        localStringBuilder.append("onOIDB0X899_0_Ret").append("| isSuccess = ").append(paramBoolean).append("| troopuin = ").append(paramLong1).append("| nFlag = ").append(paramInt1).append("| strErorMsg = ").append(paramString);
        QLog.i("TroopMemberListActivityget_troop_member", 2, localStringBuilder.toString());
      }
      if ((paramInt1 == 1) && (paramBoolean)) {
        ThreadManager.a(new mvf(this, paramList), 5, null, true);
      }
    } while ((paramInt1 != 2) || (!paramBoolean));
    ThreadManager.a(new mvg(this, paramList), 8, null, true);
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "onGetTroopInfoResult, isSuccess:" + paramBoolean + " returnUin:" + paramString + " mTroopUin:" + this.a.k + " time:" + (System.currentTimeMillis() - this.a.d) / 1000L + "s");
    }
    if ((!paramBoolean) || (!this.a.k.equals(paramString))) {}
    do
    {
      return;
      this.a.getSharedPreferences("last_update_time" + this.a.app.a(), 0).edit().putLong("key_troop_info_last_update" + this.a.k, System.currentTimeMillis()).commit();
      paramString = ((TroopManager)this.a.app.getManager(51)).a(paramString);
    } while (paramString == null);
    this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramString;
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin != null) {
      this.a.n = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator != null) {
      this.a.o = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator;
    }
    paramString = this.a;
    if ((this.a.app.a().equals(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin)) || ((this.a.o != null) && (this.a.o.contains(this.a.app.a()))))
    {
      paramBoolean = true;
      paramString.jdField_a_of_type_Boolean = paramBoolean;
      if ((this.a.n == null) || (!this.a.n.equals(this.a.app.a()))) {
        break label422;
      }
    }
    for (this.a.F = "0";; this.a.F = "1") {
      label422:
      do
      {
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(9));
        return;
        paramBoolean = false;
        break;
      } while ((this.a.o == null) || (!this.a.o.contains(this.a.app.a())));
    }
  }
  
  protected void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, String paramString3)
  {
    this.a.runOnUiThread(new mvc(this, paramBoolean1, paramString1, paramBoolean2, paramString2, paramString3));
  }
  
  protected void a(boolean paramBoolean, List paramList)
  {
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member.troop.troop_fee", 2, "onGetTroopFeeMemberList : isSuccess=" + paramBoolean);
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      cmd0x406.GroupFeeMember localGroupFeeMember = (cmd0x406.GroupFeeMember)localIterator.next();
      TroopMemberListActivity.ATroopMember localATroopMember = new TroopMemberListActivity.ATroopMember();
      localATroopMember.a = (localGroupFeeMember.uint64_uin.get() + "");
      localATroopMember.b = localGroupFeeMember.string_nick_name.get();
      localArrayList.add(localATroopMember);
    }
    this.a.G = paramList.size();
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, new Object[] { localArrayList }));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mvb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */