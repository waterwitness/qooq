package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ForwardChooseFriendOption
  extends ForwardBaseOption
{
  public static final String a = "ForwardOption.ForwardChooseFriendOption";
  protected ResultReceiver a;
  
  public ForwardChooseFriendOption(Intent paramIntent)
  {
    super(paramIntent);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && ((localRecentUser.type != 1006) || (a(ForwardAbility.ForwardAbilityType.i))) && (localRecentUser.type != 9501) && (localRecentUser.type != 7000)) {
        if ((localRecentUser.type == 0) && (!Utils.a(localRecentUser.uin)) && (!Utils.b(localRecentUser.uin)) && (!CrmUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin)))
        {
          if ((localFriendsManager != null) && (localFriendsManager.b(localRecentUser.uin))) {
            localArrayList.add(localRecentUser);
          }
        }
        else if ((localRecentUser.type == 1006) || (((localRecentUser.type == 1004) || (localRecentUser.type == 1000)) && (this.jdField_b_of_type_Boolean))) {
          localArrayList.add(localRecentUser);
        }
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    boolean bool1 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("choose_friend_is_qqfriends", true);
    boolean bool2 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("choose_friend_is_contacts", false);
    if ((bool1) && (k())) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    if ((bool2) && (h())) {
      this.jdField_a_of_type_JavaUtilSet.add(i);
    }
    this.jdField_a_of_type_JavaUtilSet.add(j);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    paramInt = paramBundle.getInt("uintype", -1);
    if ((paramInt == 0) || (paramInt == 1004))
    {
      localArrayList1.add(paramBundle.getString("uin"));
      localArrayList2.add("");
      localArrayList3.add(paramBundle.getString("uinname"));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidOsResultReceiver != null)
      {
        paramBundle = new Bundle();
        paramBundle.putStringArrayList("choose_friend_uins", localArrayList1);
        paramBundle.putStringArrayList("choose_friend_phones", localArrayList2);
        paramBundle.putStringArrayList("choose_friend_names", localArrayList3);
        this.jdField_a_of_type_AndroidOsResultReceiver.send(0, paramBundle);
      }
      if (this.jdField_a_of_type_AndroidAppActivity == null) {
        break;
      }
      this.jdField_a_of_type_AndroidAppActivity.setResult(1);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
      if (paramInt == 1006)
      {
        localArrayList1.add("");
        localArrayList2.add(paramBundle.getString("uin"));
        localArrayList3.add(paramBundle.getString("uinname"));
      }
    }
  }
  
  public boolean a()
  {
    super.a();
    this.jdField_a_of_type_AndroidOsResultReceiver = ((ResultReceiver)this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("choose_friend_callback"));
    return true;
  }
  
  public String b()
  {
    String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("choose_friend_title");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "选择好友";
    }
    return str1;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\forward\ForwardChooseFriendOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */