import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class msz
  extends TroopObserver
{
  public msz(TroopMemberCardActivity paramTroopMemberCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onSetTroopAdminFail: errorCode=" + paramInt);
    }
    this.a.o();
    Object localObject;
    switch (paramInt)
    {
    case 5: 
    case 6: 
    default: 
      localObject = this.a.getString(2131367375);
      this.a.a(1, (String)localObject);
      return;
    case 4: 
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null)
      {
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.a.t);
        if (localObject == null) {
          break;
        }
      }
      break;
    }
    for (paramInt = ((TroopInfo)localObject).maxAdminNum;; paramInt = 0)
    {
      if (paramInt > 0)
      {
        localObject = String.format(this.a.getString(2131367379), new Object[] { Integer.valueOf(paramInt) });
        break;
      }
      localObject = this.a.getString(2131367380);
      break;
      localObject = this.a.getString(2131367381);
      break;
    }
  }
  
  protected void a(String paramString1, String paramString2, byte paramByte)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onSetTroopAdminSuccess: mTroopUin=" + paramString1 + " memberUin=" + paramString2 + " operation=" + paramByte);
    }
    if ((this.a.t.equals(paramString1)) && (this.a.v.equals(paramString2)))
    {
      paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.a.t);
      if (paramString1 != null)
      {
        if (paramString1.Administrator == null) {
          break label288;
        }
        if (paramString1.Administrator.startsWith("|")) {
          paramString1.Administrator = paramString1.Administrator.substring(1);
        }
        if (paramString1.Administrator.endsWith("|")) {
          paramString1.Administrator = paramString1.Administrator.substring(0, paramString1.Administrator.length() - 1);
        }
        if (paramByte != 0) {
          break label297;
        }
        paramString1.Administrator = paramString1.Administrator.replace(paramString2 + "|", "").replace("|" + paramString2, "").replace(paramString2, "");
        label229:
        this.a.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(paramString1);
      }
      if (paramByte != 0) {
        break label335;
      }
      this.a.a(2, this.a.getString(2131367377));
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole = 1;
    }
    for (;;)
    {
      this.a.a(4);
      this.a.o();
      return;
      label288:
      paramString1.Administrator = "";
      break;
      label297:
      if (paramByte != 1) {
        break label229;
      }
      paramString1.Administrator = (paramString1.Administrator + "|" + paramString2);
      break label229;
      label335:
      if (paramByte == 1)
      {
        this.a.a(2, this.a.getString(2131367374));
        this.a.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole = 2;
        ReportController.b(this.a.app, "P_CliOper", "Grp_manage", "", "mber_card", "suc_setadmin", 0, 0, this.a.t, "", "", "");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\msz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */