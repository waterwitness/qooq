import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.freshnews.FreshNewsFeedAdapter;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.FreshNewsUtil;
import com.tencent.mobileqq.freshnews.data.FNBaseItemData;
import com.tencent.mobileqq.freshnews.data.FNHotChatItemData;
import com.tencent.mobileqq.freshnews.hotchat.HotchatFeedInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;

public class spt
  implements View.OnClickListener
{
  public spt(FreshNewsFeedAdapter paramFreshNewsFeedAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    int j = -1;
    int i = j;
    if (paramView.getTag(-1) != null)
    {
      localObject = paramView.getTag(-1);
      i = j;
      if ((localObject instanceof Integer)) {
        i = ((Integer)localObject).intValue();
      }
    }
    Object localObject = (FNHotChatItemData)this.a.a(i);
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby.freshNews", 2, "defaultItemOnClickLis, itemData is null|pos =" + i);
      }
    }
    label343:
    do
    {
      do
      {
        do
        {
          return;
          switch (paramView.getId())
          {
          default: 
            return;
          case 2131296515: 
            paramView = ((FNHotChatItemData)localObject).a;
            if ((paramView == null) && (QLog.isColorLevel())) {
              QLog.d("Q.nearby.freshNews", 2, "hotchat item click content|feed info is null");
            }
            if ((paramView.hotchatInfo == null) || (TextUtils.isEmpty(paramView.hotchatInfo.c))) {
              break label343;
            }
            HotchatFeedInfo.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView.hotchatInfo);
            this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.a("CliOper", "", "", "0X8005D52", "0X8005D52", 0, 0, "", "", "", "");
          }
        } while (!QLog.isColorLevel());
        QLog.d("Q.nearby.freshNews", 2, "jump to Hotchat, url=" + paramView.hotchatInfo.c);
        return;
        paramView = ((FNHotChatItemData)localObject).a;
        if (paramView != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.nearby.freshNews", 2, "hotchat item click head|feed info is null");
      return;
      FreshNewsUtil.a((NearbyAppInterface)this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView);
      return;
      this.a.b((FNBaseItemData)localObject);
      this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.a("CliOper", "", "", "0X800577C", "0X800577C", 0, 0, "", "", "", "");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("Q.nearby.freshNews", 2, "jump to Hotchat, url is empty");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\spt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */