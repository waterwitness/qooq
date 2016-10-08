import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EqqDetail;
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

public class hkp
  implements BusinessObserver
{
  public hkp(EqqAccountDetailActivity paramEqqAccountDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "follow isSuccess:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      this.a.d(2131364487);
    }
    for (;;)
    {
      EqqAccountDetailActivity.e(this.a);
      if (EqqAccountDetailActivity.f(this.a) == 0) {
        EqqAccountDetailActivity.d(this.a);
      }
      EqqAccountDetailActivity.b(this.a).postDelayed(new hkq(this), 1000L);
      return;
      Object localObject = new JSONObject();
      ((FriendListHandler)EqqAccountDetailActivity.j(this.a).a(1)).a(true, false);
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {}
      try
      {
        ((JSONObject)localObject).put("uin", this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.uin);
        ((JSONObject)localObject).put("name", this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name);
        ((JSONObject)localObject).put("summary", this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.summary);
        ((JSONObject)localObject).put("certified", this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.certifiedGrade);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("find.mp.qq.com");
        localArrayList.add("post.mp.qq.com");
        localArrayList.add("article.mp.qq.com");
        EventApiPlugin.a("follow", (JSONObject)localObject, localArrayList, null);
        if (!paramBoolean) {
          break label519;
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
          if (paramInt == 0)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.followType = 1;
            EqqAccountDetailActivity.a(this.a).setEnabled(false);
            EqqAccountDetailActivity.b(this.a);
            this.a.h();
            EqqAccountDetailActivity.c(this.a);
            AccountDetailActivity.a(EqqAccountDetailActivity.k(this.a), EqqAccountDetailActivity.k(this.a), EqqAccountDetailActivity.a(this.a));
            if ((TextUtils.isEmpty(this.a.k)) || (TextUtils.isEmpty(this.a.l))) {
              continue;
            }
            ReportController.b(EqqAccountDetailActivity.l(this.a), "CliOper", "", "", this.a.k, this.a.l, 0, 0, "", "", EqqAccountDetailActivity.m(this.a).a(), EqqAccountDetailActivity.l(this.a));
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "----[follow report done]----");
          }
        }
        catch (Exception paramBundle) {}
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
        if (paramInt == 58)
        {
          this.a.d(2131364494);
          continue;
        }
        this.a.d(2131364487);
      }
      continue;
      label519:
      this.a.d(2131364487);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hkp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */