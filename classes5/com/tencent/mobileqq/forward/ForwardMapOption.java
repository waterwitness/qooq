package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForwardMapOption
  extends ForwardBaseOption
{
  public static final String a = "ForwardOption.ForwwardMapOption";
  
  public ForwardMapOption(Intent paramIntent)
  {
    super(paramIntent);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && (localRecentUser.type != 1020) && (localRecentUser.type != 1008) && (localRecentUser.type != 1005) && (localRecentUser.type != 1009) && (localRecentUser.type != 1021) && (localRecentUser.type != 1001) && (localRecentUser.type != 1022) && (localRecentUser.type != 7000) && (localRecentUser.type != 1025) && (localRecentUser.type != 1024) && ((localRecentUser.type != 1) || (!a(localRecentUser.uin))) && ((localRecentUser.type != 1006) || (a(ForwardAbility.ForwardAbilityType.i))) && (localRecentUser.type != 9501) && ((localRecentUser.type != 0) || (!CrmUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin))) && (((localRecentUser.type != 1004) && (localRecentUser.type != 1000)) || (this.b))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  protected void a(Drawable paramDrawable, boolean paramBoolean)
  {
    if (paramBoolean) {
      URLDrawableHelper.a((URLDrawable)paramDrawable, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true);
    }
    if (paramDrawable == null) {
      return;
    }
    paramDrawable.setBounds(0, 0, (int)(264.0F * this.jdField_a_of_type_Float), (int)(138.0F * this.jdField_a_of_type_Float));
  }
  
  protected void a(QQCustomDialog paramQQCustomDialog)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwwardMapOption", 2, "updateImageView:setDefaultDialogPreviewImage");
    }
    a(ForwardOptionUtils.a(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130838482), this.jdField_a_of_type_Float), false, 0);
  }
  
  protected void b()
  {
    String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_location_string");
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(str);
  }
  
  protected boolean c()
  {
    boolean bool1 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromFavorite", false);
    boolean bool2 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromFavorites", false);
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ForwardMapOption realForwardTo isFromFavorite=" + bool1 + "isFromFav=" + bool2);
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    if ((bool1) || (bool2))
    {
      ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
    for (;;)
    {
      return true;
      if (this.f)
      {
        this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
        this.jdField_a_of_type_AndroidAppActivity.finish();
      }
      else
      {
        super.c();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\forward\ForwardMapOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */