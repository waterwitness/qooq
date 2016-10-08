import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.hotchat.HCSeatInfo;
import com.tencent.mobileqq.hotchat.HCTopicSeatsView;
import com.tencent.mobileqq.hotchat.HCTopicSeatsView.MenuItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class ssv
  implements View.OnClickListener
{
  public ssv(HCTopicSeatsView paramHCTopicSeatsView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.b();
    paramView = paramView.getTag();
    if ((paramView instanceof HCTopicSeatsView.MenuItem)) {}
    for (paramView = (HCTopicSeatsView.MenuItem)paramView;; paramView = null)
    {
      Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.a.d);
      if ((paramView == null) || (paramView.a == null) || (localObject == null))
      {
        if (QLog.isColorLevel())
        {
          if (paramView != null) {
            break label101;
          }
          paramView = "item is null";
          if (localObject != null) {
            break label120;
          }
        }
        label101:
        label120:
        for (localObject = "info is null";; localObject = "info is not null")
        {
          NearbyUtils.a("HCTopicSeatsView", new Object[] { "mMenuClkLis, invalide params", paramView, localObject });
          return;
          if (paramView.a == null)
          {
            paramView = "item.extra is null";
            break;
          }
          paramView = "item.extra not null";
          break;
        }
      }
      switch (paramView.c)
      {
      default: 
        return;
      case 0: 
        HotChatUtil.a(this.a.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.d, Long.toString(paramView.a.guestUin));
        this.a.a("0X8006583");
        return;
      case 1: 
        if (!NetworkUtil.h(this.a.getContext()))
        {
          this.a.a(0, "操作失败，请检查网络连接。");
          return;
        }
        this.a.a(0, "正在操作，请稍候...", 800);
        if (this.a.e == 1) {
          this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatHandler.a((HotChatInfo)localObject, String.valueOf(paramView.a.guestUin), 4, paramView.a.seatID, 0);
        }
        for (;;)
        {
          this.a.a("0X8006584");
          return;
          this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatHandler.a((HotChatInfo)localObject, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2, paramView.a.seatID, 0);
        }
      case 2: 
        this.a.a(paramView.a.seatID);
        this.a.a("0X8006585");
        return;
      case 3: 
        if (!NetworkUtil.h(this.a.getContext()))
        {
          this.a.a(0, "操作失败，请检查网络连接。");
          return;
        }
        this.a.a(0, "正在操作，请稍候...", 800);
        this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatHandler.a((HotChatInfo)localObject, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 5, paramView.a.seatID, 1);
        return;
      }
      if (!NetworkUtil.h(this.a.getContext()))
      {
        this.a.a(0, "操作失败，请检查网络连接。");
        return;
      }
      this.a.a(0, "正在操作，请稍候...", 800);
      this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatHandler.a((HotChatInfo)localObject, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 5, paramView.a.seatID, 0);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ssv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */