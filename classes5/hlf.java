import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

public class hlf
  implements BusinessObserver
{
  public hlf(AccountDetailActivity paramAccountDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "follow isSuccess:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      this.a.d(2131364487);
    }
    for (;;)
    {
      paramBundle = this.a;
      paramBundle.E -= 1;
      if (this.a.E == 0) {
        this.a.J();
      }
      this.a.b.postDelayed(new hlg(this), 1000L);
      return;
      Object localObject = new JSONObject();
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {}
      try
      {
        ((JSONObject)localObject).put("uin", this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
        ((JSONObject)localObject).put("name", this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
        ((JSONObject)localObject).put("summary", this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
        ((JSONObject)localObject).put("certified", this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedGrade);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("find.mp.qq.com");
        localArrayList.add("post.mp.qq.com");
        localArrayList.add("article.mp.qq.com");
        EventApiPlugin.a("follow", (JSONObject)localObject, localArrayList, null);
        if (!paramBoolean) {
          break label593;
        }
        try
        {
          paramBundle = paramBundle.getByteArray("data");
          if (paramBundle == null) {
            continue;
          }
          localObject = new mobileqq_mp.FollowResponse();
          ((mobileqq_mp.FollowResponse)localObject).mergeFrom(paramBundle);
          paramInt = ((mobileqq_mp.RetInfo)((mobileqq_mp.FollowResponse)localObject).ret_info.get()).ret_code.get();
          if (paramInt == 0) {
            if (this.a.g)
            {
              if (this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null)
              {
                paramBundle = this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin;
                ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.a.p, "mp_msg_sys_12", "scan_via", 0, 0, paramBundle, "", "", this.a.r);
              }
            }
            else
            {
              this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType = 1;
              this.a.b.setEnabled(false);
              this.a.F();
              this.a.h();
              this.a.x();
              AccountDetailActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.p, this.a.jdField_a_of_type_AndroidContentIntent);
              if ((!TextUtils.isEmpty(this.a.k)) && (!TextUtils.isEmpty(this.a.l)))
              {
                ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", this.a.k, this.a.l, 0, 0, "", "", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.a.p);
                if (QLog.isColorLevel()) {
                  QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "----[follow report done]----");
                }
              }
              if (this.a.K != 50) {
                continue;
              }
              AccountDetailActivity.a(this.a, 1);
            }
          }
        }
        catch (Exception paramBundle) {}
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
          continue;
          paramBundle = "";
        }
        if (paramInt == 58)
        {
          this.a.d(2131364494);
          continue;
        }
        this.a.d(2131364487);
      }
      continue;
      label593:
      this.a.d(2131364487);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hlf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */