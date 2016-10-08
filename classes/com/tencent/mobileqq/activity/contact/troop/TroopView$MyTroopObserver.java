package com.tencent.mobileqq.activity.contact.troop;

import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.SlideDetectListView;
import java.util.ArrayList;
import okq;

public class TroopView$MyTroopObserver
  extends TroopObserver
{
  protected TroopView$MyTroopObserver(TroopView paramTroopView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(int paramInt, byte paramByte, String paramString)
  {
    if (paramInt == 6) {
      if (paramByte == 0) {
        this.a.a();
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt != 2) {
          break;
        }
      } while (paramByte != 0);
      this.a.a();
      return;
    } while ((paramInt != 9) || (paramByte != 0));
    this.a.a();
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      TroopView.a(this.a);
    }
    if (this.a.c)
    {
      this.a.c = false;
      if (!paramBoolean) {
        break label79;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      this.a.a(101, 800L);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.postDelayed(new okq(this), 1200L);
      return;
      label79:
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.H();
      this.a.b(2131368597);
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (paramBoolean) {
      this.a.a();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.a();
    }
  }
  
  protected void a(boolean paramBoolean, ArrayList paramArrayList)
  {
    if (paramBoolean) {
      this.a.a();
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.a();
    }
  }
  
  protected void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\contact\troop\TroopView$MyTroopObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */