import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.PhotoWallViewForAccountDetail.PhotoWallCallback;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.biz.troopbar.ShareActionSheet;
import com.tencent.biz.troopbar.ShareActionSheet.Detail;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hmv
  implements PhotoWallViewForAccountDetail.PhotoWallCallback
{
  public hmv(AccountDetailActivity paramAccountDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if (paramPaConfigInfo == null) {}
    label635:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    String str = paramPaConfigInfo.jdField_c_of_type_JavaLangString;
                    localObject = str;
                    if (str == null) {
                      localObject = "";
                    }
                    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.a.p, "0X8005A28", "0X8005A28", 0, 0, (String)localObject, "", "", "");
                    if (paramPaConfigInfo.a != 3) {
                      break label635;
                    }
                    if (paramPaConfigInfo.jdField_c_of_type_Int != 7) {
                      break;
                    }
                  } while ((TextUtils.isEmpty(paramPaConfigInfo.g)) || (TextUtils.isEmpty(paramPaConfigInfo.f)) || (TextUtils.isEmpty(paramPaConfigInfo.b)));
                  Object localObject = new Intent(this.a, QQMapActivity.class);
                  ((Intent)localObject).putExtra("lat", paramPaConfigInfo.g);
                  ((Intent)localObject).putExtra("lon", paramPaConfigInfo.f);
                  ((Intent)localObject).putExtra("loc", paramPaConfigInfo.b);
                  this.a.startActivity((Intent)localObject);
                  return;
                  if (paramPaConfigInfo.jdField_c_of_type_Int != 8) {
                    break;
                  }
                  paramPaConfigInfo = paramPaConfigInfo.h;
                } while (TextUtils.isEmpty(paramPaConfigInfo));
                paramPaConfigInfo = paramPaConfigInfo.trim();
              } while (!Pattern.compile("[\\d-]+?").matcher(paramPaConfigInfo).matches());
              this.a.d(paramPaConfigInfo);
              return;
            } while (paramPaConfigInfo.jdField_c_of_type_Int == 13);
            if (paramPaConfigInfo.jdField_c_of_type_Int == 11)
            {
              paramPaConfigInfo = new Intent(this.a, ScannerActivity.class);
              paramPaConfigInfo.putExtra("from", AccountDetailActivity.class.getName());
              paramPaConfigInfo.putExtra("finishAfterSucc", true);
              this.a.startActivity(paramPaConfigInfo);
              return;
            }
          } while (paramPaConfigInfo.jdField_c_of_type_Int == 16);
          if (paramPaConfigInfo.jdField_c_of_type_Int == 20)
          {
            this.a.M();
            return;
          }
          if (paramPaConfigInfo.jdField_c_of_type_Int == 2)
          {
            ShareActionSheet.a(this.a, new ShareActionSheet.Detail(this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), this.a.b(), this.a.b());
            return;
          }
          if (paramPaConfigInfo.jdField_c_of_type_Int == 17)
          {
            ShareActionSheet.a(this.a, new ShareActionSheet.Detail(this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), this.a.b(), this.a.b());
            return;
          }
          if (paramPaConfigInfo.jdField_c_of_type_Int == 19)
          {
            ShareActionSheet.a(this.a, new ShareActionSheet.Detail(this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), this.a.b(), this.a.b(), 9);
            return;
          }
          if (paramPaConfigInfo.jdField_c_of_type_Int == 18)
          {
            ShareActionSheet.a(this.a, new ShareActionSheet.Detail(this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), this.a.b(), this.a.b(), 10);
            return;
          }
        } while (paramPaConfigInfo.jdField_c_of_type_Int == 21);
        if (paramPaConfigInfo.jdField_c_of_type_Int == 22)
        {
          paramPaConfigInfo = paramPaConfigInfo.jdField_c_of_type_JavaLangString;
          this.a.b(paramPaConfigInfo);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "unhandled event_id: " + paramPaConfigInfo.jdField_c_of_type_Int);
      return;
    } while (paramPaConfigInfo.a != 1);
    paramPaConfigInfo = paramPaConfigInfo.jdField_c_of_type_JavaLangString;
    this.a.b(paramPaConfigInfo);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hmv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */