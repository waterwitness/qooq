package com.tencent.mobileqq.troop.activity;

import android.os.Handler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SlideDetectListView;
import vdo;

public class ContactsTroopActivity$MyTroopObserver
  extends TroopObserver
{
  protected ContactsTroopActivity$MyTroopObserver(ContactsTroopActivity paramContactsTroopActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      ContactsTroopActivity.a(this.a);
    }
    if (this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_Boolean = false;
      if (!paramBoolean) {
        break label83;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 800L);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.postDelayed(new vdo(this), 1200L);
      return;
      label83:
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.H();
      QQToast.a(this.a, this.a.getString(2131368597), 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\ContactsTroopActivity$MyTroopObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */