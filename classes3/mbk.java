import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.PublicAccountManagePopBar;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.activity.PublicAccountSearchActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.huangye.C2BUtils;

public class mbk
  implements View.OnClickListener
{
  public mbk(PublicAccountListActivity paramPublicAccountListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    label242:
    Object localObject;
    do
    {
      do
      {
        return;
        this.a.finish();
        return;
        if (PublicAccountConfigUtil.d)
        {
          if (PublicAccountListActivity.a(this.a) == null) {
            PublicAccountListActivity.a(this.a, new PublicAccountManagePopBar(this.a));
          }
          PublicAccountListActivity.a(this.a).a(this.a.jdField_a_of_type_AndroidViewView, this.a.jdField_a_of_type_AndroidViewView.getWidth() - this.a.getResources().getDimensionPixelSize(2131493351) - this.a.getResources().getDimensionPixelSize(2131493355), this.a.getResources().getDimensionPixelSize(2131493356));
          if ((PublicAccountListActivity.a(this.a) != null) && (PublicAccountListActivity.a(this.a).a()))
          {
            i = 1;
            paramView = this.a.app;
            if (i == 0) {
              break label242;
            }
          }
          for (int i = 1;; i = 0)
          {
            ReportController.b(paramView, "dc00899", "Pb_account_lifeservice", "", "0X800679A", "0X800679A", i, 0, "", "", "", "");
            return;
            i = 0;
            break;
          }
        }
        PublicAccountSearchActivity.a(this.a);
        ReportController.b(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800573A", "0X800573A", 0, 1, 0, "", "", "", "");
        paramView = (RedTouchManager)this.a.app.getManager(35);
        localObject = paramView.a("101000.101001");
        if ((localObject != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 1)) {
          ReportController.b(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "0X80060E3", "0X80060E3", 0, 0, "", "", "", "");
        }
        paramView.b("101000.101001");
        return;
        localObject = (String)paramView.getTag(-1);
        paramView = (String)paramView.getTag(-2);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramView))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w(PublicAccountListActivity.jdField_a_of_type_JavaLangString, 2, "onClick - uin = " + (String)localObject + ", name = " + paramView);
      return;
      CrmUtils.a(this.a.app, this.a, paramView, (String)localObject, "IvrEnterpriseDetailEngineFalse");
      return;
      PublicAccountSearchActivity.a(this.a, (String)this.a.d.getTag());
      ReportController.b(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800573D", "0X800573D", 0, 1, 0, "", "", "", "");
      return;
      PublicAccountSearchActivity.a(this.a, (String)this.a.d.getTag());
      return;
      localObject = (String)paramView.getTag(-1);
      paramView = (String)paramView.getTag(-2);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramView)))
      {
        C2BUtils.a(this.a.app, this.a, (String)localObject, paramView, "publicAccountList");
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.w(PublicAccountListActivity.jdField_a_of_type_JavaLangString, 2, "c2bcall button click error :" + (String)localObject + ", name = " + paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mbk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */