import NS_MOBILE_AIONewestFeed.AIONewestFeedRsp;
import NS_MOBILE_AIONewestFeed.NewestFeedInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.observer.QZoneObserver;
import java.util.ArrayList;

public class mtz
  extends QZoneObserver
{
  public QQAppInterface a;
  
  public mtz(TroopMemberCardActivity paramTroopMemberCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    paramBundle = paramBundle.getSerializable("data");
    if ((paramBoolean) && (paramBundle != null) && ((paramBundle instanceof AIONewestFeedRsp)))
    {
      paramBundle = (AIONewestFeedRsp)paramBundle;
      if ((paramBundle.uFeedInfos != null) && (paramBundle.uFeedInfos.size() > 0))
      {
        paramBundle = (NewestFeedInfo)paramBundle.uFeedInfos.get(0);
        if (paramBundle != null) {
          if (!TextUtils.isEmpty(paramBundle.strContent)) {
            paramBundle = paramBundle.strContent;
          }
        }
      }
    }
    for (;;)
    {
      Object localObject = paramBundle;
      if (TextUtils.isEmpty(paramBundle)) {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.a.nick)) {
          break label166;
        }
      }
      label166:
      for (localObject = "空间";; localObject = String.format("%s的空间", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c() }))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.a.mQzoneFeed = ((String)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.runOnUiThread(new mua(this, (String)localObject));
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(TroopMemberCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity));
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
        return;
        paramBundle = paramBundle.strSummary;
        break;
      }
      paramBundle = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mtz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */