import android.content.res.Resources;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;
import com.tencent.mobileqq.troop.activity.NearbyTroopsBaseView;
import com.tencent.mobileqq.troop.activity.NearbyTroopsBaseView.INearbyTroopContext;
import com.tencent.mobileqq.widget.GraphicTabBarView;
import com.tencent.mobileqq.widget.GraphicTabBarView.OnTabChangeListener;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.util.MqqWeakReferenceHandler;

public class veq
  implements GraphicTabBarView.OnTabChangeListener
{
  public veq(NearbyTroopsActivity paramNearbyTroopsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.f();
    }
    Object localObject;
    String str;
    label123:
    int i;
    if (this.a.j != paramInt2)
    {
      if (this.a.j != -1) {
        this.a.s = -1;
      }
      switch (this.a.j)
      {
      default: 
        localObject = "";
        switch (paramInt2)
        {
        default: 
          localObject = "";
          str = "";
          RedDotTextView localRedDotTextView = this.a.jdField_a_of_type_ComTencentMobileqqWidgetGraphicTabBarView.a(paramInt2);
          if (localRedDotTextView != null) {
            if (localRedDotTextView.a())
            {
              i = 0;
              label152:
              if (!TextUtils.isEmpty((CharSequence)localObject))
              {
                if (this.a.j != -1) {
                  ReportController.b(this.a.app, "P_CliOper", "Grp_nearby", "", (String)localObject, "Clk_tab", 0, 0, String.valueOf(this.a.r), "", "", "");
                }
                ReportController.b(this.a.app, "P_CliOper", "Grp_nearby", "", (String)localObject, "exp", 0, 0, String.valueOf(this.a.r), this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.b() + "", "", i + "");
              }
              j = i;
              if (this.a.b == 0)
              {
                j = i;
                if (!TextUtils.isEmpty(str))
                {
                  this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(str);
                  j = i;
                  if (localRedDotTextView != null) {
                    localRedDotTextView.a(false);
                  }
                }
              }
            }
          }
          break;
        }
        break;
      }
    }
    for (int j = i;; j = 1)
    {
      this.a.j = paramInt2;
      this.a.startTitleProgress();
      if (paramInt1 != paramInt2)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetGraphicTabBarView.a(paramInt1, this.a.jdField_a_of_type_Array2dOfInt[paramInt1][1], this.a.getResources().getColor(2131427603));
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetGraphicTabBarView.a(paramInt2, this.a.jdField_a_of_type_Array2dOfInt[paramInt2][0], this.a.getResources().getColor(2131427602));
      }
      localObject = Message.obtain();
      ((Message)localObject).arg1 = j;
      ((Message)localObject).what = 1229;
      this.a.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendMessageDelayed((Message)localObject, 200L);
      return;
      this.a.r = 0;
      this.a.s = this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.b();
      break;
      this.a.r = 1;
      break;
      this.a.r = 2;
      break;
      if (this.a.j != -1) {
        localObject = "grp";
      }
      str = "886.100170";
      break label123;
      localObject = "ac";
      str = "886.100171";
      break label123;
      localObject = "recom";
      str = "886.100172";
      break label123;
      i = 1;
      break label152;
      i = 1;
      break label152;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\veq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */