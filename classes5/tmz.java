import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.Utils;

public class tmz
  implements View.OnClickListener
{
  public tmz(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.i = true;
    int j = NearbyProfileUtil.a(NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel).vGiftInfo);
    Object localObject;
    if ((j <= 0) && (this.jdField_a_of_type_Int == 3))
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.a.a;
      localObject = Utils.a(NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel));
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (Friends.isValidUin(paramView))
        {
          paramView = String.format("http://imgcache.qq.com/club/client/flower/release/html/index.html?strangerUin=%s&sign=%s&sourceType=%d&ADTAG=%s&groupCode=%s&_wv=2147347&_bid=2050", new Object[] { NearbyURLSafeUtil.a(paramView), ((String)localObject).toLowerCase(), Integer.valueOf(1), "near.card.s", "" });
          localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("portraitOnly", true);
          ((Intent)localObject).putExtra("url", paramView);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.startActivity((Intent)localObject);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.getString(2131369645));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.getString(2131371565));
      return;
    }
    int i;
    switch (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.a.e)
    {
    default: 
      i = 1;
      label266:
      if (this.jdField_a_of_type_Int == 2)
      {
        paramView = String.format("http://imgcache.qq.com/club/client/flower/release/html/received_list.html?_wv=2147347&visit=owner&sourceType=%d&ADTAG=%s&totalFlower=%d&_bid=2050&isfresh=%d", new Object[] { Integer.valueOf(i), "near.card.ro", Integer.valueOf(j), Integer.valueOf(0) });
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.app, "CliOper", "", "", "0X80052C1", "0X80052C1", 0, 0, "", "", "", "");
      }
      break;
    }
    while (paramView != null)
    {
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("portraitOnly", true);
      ((Intent)localObject).putExtra("url", paramView);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.startActivity((Intent)localObject);
      return;
      i = 1;
      break label266;
      i = 2;
      break label266;
      i = 3;
      break label266;
      i = 4;
      break label266;
      if (this.jdField_a_of_type_Int == 3)
      {
        paramView = Utils.a(NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel));
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.a.a;
        if (!TextUtils.isEmpty(paramView))
        {
          if (Friends.isValidUin((String)localObject))
          {
            localObject = NearbyURLSafeUtil.a((String)localObject);
            if (paramView != null) {}
            for (;;)
            {
              paramView = String.format("http://imgcache.qq.com/club/client/flower/release/html/received_list.html?_wv=2147347&visit=guest&strangerUin=%s&sourceType=%d&ADTAG=%s&sign=%s&totalFlower=%d&_bid=2050", new Object[] { localObject, Integer.valueOf(i), "near.card.rg", paramView, Integer.valueOf(j) });
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.app, "CliOper", "", "", "0X80052C2", "0X80052C2", 0, 0, "", "", "", "");
              break;
              paramView = "";
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.getString(2131369645));
          paramView = null;
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.getString(2131371565));
        }
      }
      else
      {
        paramView = null;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tmz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */