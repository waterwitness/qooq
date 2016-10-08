import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotchat.HCSeatInfo;
import com.tencent.mobileqq.hotchat.HCTopicSeatsView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ssw
  implements View.OnClickListener
{
  public ssw(HCTopicSeatsView paramHCTopicSeatsView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if ((localObject1 instanceof HCSeatInfo)) {}
    for (localObject1 = (HCSeatInfo)localObject1;; localObject1 = null)
    {
      if (localObject1 == null) {
        if (QLog.isColorLevel()) {
          NearbyUtils.a("HCTopicSeatsView", new Object[] { "onClic seat is null" });
        }
      }
      int i;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localObject2 = new ArrayList(2);
              i = this.a.a((HCSeatInfo)localObject1, (List)localObject2);
              if (QLog.isColorLevel()) {
                NearbyUtils.a("HCTopicSeatsView", new Object[] { "onClick", localObject1, Integer.valueOf(i), Integer.valueOf(((List)localObject2).size()) });
              }
              if (i != 0) {
                break;
              }
            } while (((List)localObject2).size() == 0);
            this.a.b();
            this.a.jdField_a_of_type_AndroidWidgetPopupWindow = this.a.a(paramView, (List)localObject2);
          } while (this.a.jdField_a_of_type_AndroidWidgetPopupWindow == null);
          paramView = this.a.jdField_a_of_type_AndroidWidgetPopupWindow.getContentView();
        } while (paramView == null);
        Object localObject2 = new HCSeatInfo();
        ((HCSeatInfo)localObject2).seatID = ((HCSeatInfo)localObject1).seatID;
        ((HCSeatInfo)localObject2).seatFlag = ((HCSeatInfo)localObject1).seatFlag;
        ((HCSeatInfo)localObject2).guestUin = ((HCSeatInfo)localObject1).guestUin;
        ((HCSeatInfo)localObject2).seatSeq = ((HCSeatInfo)localObject1).seatSeq;
        paramView.setTag(localObject2);
        return;
      } while (i <= 0);
      if (this.a.a(((HCSeatInfo)localObject1).seatID))
      {
        this.a.a(0, "该座位已被房主关闭。");
        return;
      }
      if (!NetworkUtil.h(this.a.getContext()))
      {
        this.a.a(0, "操作失败，请检查网络连接。");
        return;
      }
      this.a.a(0, "正在操作，请稍候...", 800);
      paramView = this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.a.d);
      this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatHandler.a(paramView, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 1, ((HCSeatInfo)localObject1).seatID, 0);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ssw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */