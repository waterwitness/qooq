package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ForwardAioAlbumOption
  extends ForwardBaseOption
{
  public static final String a = "ForwardOption.ForwardAioAlbumOption";
  
  public ForwardAioAlbumOption(Intent paramIntent)
  {
    super(paramIntent);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = true;
  }
  
  public List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && (localRecentUser.type != 1003) && (localRecentUser.type != 1025) && (localRecentUser.type != 1024) && (localRecentUser.type != 1008) && (localRecentUser.type != 1021) && ((localRecentUser.type != 1) || (!a(localRecentUser.uin))) && ((localRecentUser.type != 1006) || (a(ForwardAbility.ForwardAbilityType.i))) && (localRecentUser.type != 7000) && (localRecentUser.type != 9501) && ((localRecentUser.type != 0) || (!CrmUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin))) && (((localRecentUser.type != 1004) && (localRecentUser.type != 1000)) || (this.b))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_dataline", true))
    {
      this.jdField_a_of_type_JavaUtilSet.add(f);
      this.jdField_a_of_type_JavaUtilSet.add(l);
    }
  }
  
  protected void a(Intent paramIntent)
  {
    ArrayList localArrayList3 = null;
    ArrayList localArrayList4 = this.jdField_a_of_type_AndroidOsBundle.getParcelableArrayList("fileinfo_array");
    ArrayList localArrayList1 = localArrayList3;
    if (localArrayList4 != null) {}
    try
    {
      localArrayList1 = (ArrayList)localArrayList4;
      localArrayList3 = (ArrayList)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
      localArrayList3 = (ArrayList)this.jdField_a_of_type_AndroidOsBundle.get("PhotoConst.PHOTO_PATHS");
      paramIntent.putExtra("dataline_forward_type", 101);
      paramIntent.putExtra("sendMultiple", true);
      if (localArrayList1 == null) {
        paramIntent.putStringArrayListExtra("dataline_forward_pathlist", localArrayList3);
      }
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      for (;;)
      {
        ArrayList localArrayList2 = localArrayList3;
      }
    }
  }
  
  protected void a(Drawable paramDrawable, boolean paramBoolean)
  {
    URLDrawable localURLDrawable;
    if (paramBoolean)
    {
      localURLDrawable = (URLDrawable)paramDrawable;
      if (this.c == null) {
        break label33;
      }
      URLDrawableHelper.a(localURLDrawable, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false);
    }
    while (paramDrawable == null)
    {
      return;
      label33:
      URLDrawableHelper.a(localURLDrawable, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true);
    }
    paramDrawable.setBounds(0, 0, jdField_a_of_type_Int, jdField_a_of_type_Int);
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(null);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageCount(this.c);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\forward\ForwardAioAlbumOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */