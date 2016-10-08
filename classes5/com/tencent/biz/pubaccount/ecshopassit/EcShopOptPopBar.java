package com.tencent.biz.pubaccount.ecshopassit;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import hug;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class EcShopOptPopBar
  implements View.OnClickListener
{
  public BaseActivity a;
  private PopupMenuDialog a;
  
  public EcShopOptPopBar(BaseActivity paramBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  public void a()
  {
    ArrayList localArrayList = new ArrayList();
    List localList = EcShopAssistantManager.b;
    int i = 0;
    for (;;)
    {
      if (i < localList.size())
      {
        PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
        EcShopAssistantManager.DiscoveryConfig localDiscoveryConfig = (EcShopAssistantManager.DiscoveryConfig)localList.get(i);
        localMenuItem.jdField_a_of_type_Int = i;
        localMenuItem.jdField_a_of_type_JavaLangString = localDiscoveryConfig.jdField_b_of_type_JavaLangString;
        localMenuItem.jdField_b_of_type_JavaLangString = localDiscoveryConfig.jdField_b_of_type_JavaLangString;
        localMenuItem.jdField_b_of_type_Int = 2130838381;
        localMenuItem.c = localDiscoveryConfig.c;
        if (!TextUtils.isEmpty(localDiscoveryConfig.jdField_a_of_type_JavaLangString)) {}
        try
        {
          Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838381);
          Object localObject = localDiscoveryConfig.jdField_a_of_type_JavaLangString.split("/");
          localObject = EcShopAssistantManager.m + localObject[(localObject.length - 1)];
          localMenuItem.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(new URL("profile_img_icon", localDiscoveryConfig.jdField_a_of_type_JavaLangString, (String)localObject), localDrawable, localDrawable);
          localArrayList.add(localMenuItem);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("EcShopOptPopBar", 2, "initOptionBar error:" + localException.getMessage());
            }
          }
        }
      }
    }
    if (localArrayList.size() > 0) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localArrayList, new hug(this));
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog == null) {
      a();
    }
    if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog != null) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown(paramView, paramInt1, paramInt2);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("EcShopOptPopBar", 2, "optBar show error, sDiscoveryConfigs size :" + EcShopAssistantManager.b.size());
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog != null) && (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
    }
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\ecshopassit\EcShopOptPopBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */