package com.tencent.mobileqq.activity.pendant;

import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.adapter.AvatarPendantAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import ons;

public class AvatarPendantActivity$AnimationScrollListener
  implements AbsListView.OnScrollListener
{
  public AvatarPendantActivity$AnimationScrollListener(AvatarPendantActivity paramAvatarPendantActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      ((AvatarPendantManager)this.b.app.getManager(45)).a(this.b.jdField_a_of_type_Long).a(false);
    }
    for (;;)
    {
      this.b.u = paramInt;
      if (paramInt != 0) {
        break label127;
      }
      if (!this.b.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a) {
        break;
      }
      this.b.jdField_a_of_type_ComTencentWidgetXListView.postDelayed(new ons(this), 80L);
      return;
      ((AvatarPendantManager)this.b.app.getManager(45)).a(this.b.jdField_a_of_type_Long).a(true);
    }
    URLDrawable.resume();
    this.b.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.notifyDataSetChanged();
    return;
    label127:
    URLDrawable.pause();
    this.b.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a = true;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\mobileqq\activity\pendant\AvatarPendantActivity$AnimationScrollListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */