import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.browser.TroopQQBrowserHelper;
import com.tencent.mobileqq.troop.data.TroopCreateAdvanceData;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateCallback;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateInfo;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateResult;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;

public class vmb
  extends BizTroopObserver
{
  public vmb(TroopCreateLogic paramTroopCreateLogic)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void i(boolean paramBoolean, Object paramObject)
  {
    if (this.a.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.a.jdField_a_of_type_JavaUtilTimer.cancel();
      this.a.jdField_a_of_type_JavaUtilTimer = null;
    }
    Object localObject = new StringBuilder().append("onGetTroopCreateAdvance: isSuccess=").append(paramBoolean).append(", ");
    if (paramObject != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.troopCreate", 2, bool);
      TroopCreateLogic.a(this.a);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      localObject = (BaseActivity)this.a.jdField_a_of_type_AndroidAppActivity;
      if (localObject != null) {
        break;
      }
      QLog.d("Q.troopCreate", 2, "onGetTroopCreateAdvance, permissionQueryActivity==null, return");
      this.a.a();
      return;
    }
    if (!paramBoolean)
    {
      this.a.a();
      this.a.a((BaseActivity)localObject);
      this.a.a((Activity)localObject);
      return;
    }
    paramObject = (TroopCreateAdvanceData)paramObject;
    if (paramObject == null)
    {
      this.a.a();
      this.a.a((BaseActivity)localObject);
      this.a.a((Activity)localObject);
      return;
    }
    if (!((TroopCreateAdvanceData)paramObject).a())
    {
      paramObject = ((BaseActivity)localObject).getString(((TroopCreateAdvanceData)paramObject).a());
      QLog.d("Q.troopCreate", 2, "onGetTroopCreateAdvance, resultData.isSuccess==false, " + (String)paramObject);
      QQToast.a((Context)localObject, (CharSequence)paramObject, 1).b(((BaseActivity)localObject).getTitleBarHeight());
      this.a.a();
      this.a.a((Activity)localObject);
      return;
    }
    this.a.l = 2;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.a = ((TroopCreateAdvanceData)paramObject);
    switch (this.a.m)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("TroopCreate_Log", 2, String.format("Entering default create troop session, From type: %s...", new Object[] { Integer.valueOf(this.a.m) }));
      }
      TroopQQBrowserHelper.a((Context)localObject, this.a.m);
    case 0: 
      for (;;)
      {
        this.a.jdField_a_of_type_AndroidAppActivity = null;
        return;
        if (QLog.isColorLevel()) {
          QLog.d("TroopCreate_Log", 2, String.format("Entering default create troop session, From type: %s...", new Object[] { Integer.valueOf(this.a.m) }));
        }
        TroopQQBrowserHelper.a((Context)localObject);
      }
    }
    if (("1".equals(this.a.d)) || ("0".equals(this.a.d)) || ("2".equals(this.a.d)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopCreate_Log", 2, String.format("Entering create troop session, From type: %s, Troop type: %s...", new Object[] { Integer.valueOf(this.a.m), this.a.d }));
      }
      TroopQQBrowserHelper.a((Context)localObject, this.a.d);
    }
    for (;;)
    {
      ((BaseActivity)localObject).finish();
      break;
      if (QLog.isColorLevel()) {
        QLog.d("TroopCreate_Log", 2, String.format("Entering default create troop session, From type: %s...", new Object[] { Integer.valueOf(this.a.m) }));
      }
      TroopQQBrowserHelper.a((Context)localObject);
    }
  }
  
  protected void j(boolean paramBoolean, Object paramObject)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback == null) {
      return;
    }
    int i = -1;
    if (!paramBoolean) {}
    try
    {
      j = ((TroopCreateLogic.TroopCreateResult)paramObject).b;
      i = j;
    }
    catch (Exception paramObject)
    {
      int j;
      String str;
      for (;;) {}
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback.a(i, "");
    this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback = null;
    return;
    if (paramObject == null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback.a(-1, "");
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback = null;
      return;
    }
    str = ((TroopInfo)paramObject).troopuin;
    if (TextUtils.isEmpty(str))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback.a(-1, "");
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback = null;
      return;
    }
    this.a.e = str;
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_create", "", "new_create", "number", 0, 0, str, Integer.toString(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_c_of_type_Int), "", "");
    if (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.d)) {}
    for (paramObject = "no_place";; paramObject = "place")
    {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_create", "", "create_suc", (String)paramObject, 0, 0, str, Integer.toString(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_c_of_type_Int), "", "");
      ((TroopHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(str, (byte)1, 0L, 0);
      paramObject = ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(str);
      if (paramObject != null)
      {
        ((TroopInfo)paramObject).dwGroupClassExt = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_c_of_type_Int;
        ((TroopInfo)paramObject).mRichFingerMemo = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_c_of_type_JavaLangString;
        Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.d.split("\\|");
        j = 0;
        i = 0;
        if (localObject.length == 4)
        {
          j = (int)(Float.valueOf(localObject[1]).floatValue() * 1000000.0F);
          i = (int)(Float.valueOf(localObject[2]).floatValue() * 1000000.0F);
        }
        ((TroopInfo)paramObject).troopLat = j;
        ((TroopInfo)paramObject).troopLon = i;
        localObject = (TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if (localObject != null) {
          ((TroopManager)localObject).b((TroopInfo)paramObject);
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback.a(0, str);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback = null;
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vmb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */