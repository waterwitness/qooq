package com.tencent.mobileqq.search.model;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.ContactUtils;

public class ContactSearchModelGlobalTroopMember
  extends IContactSearchModel
{
  private static final int jdField_b_of_type_Int = 0;
  private static final int jdField_c_of_type_Int = 1;
  private static final int jdField_d_of_type_Int = 2;
  public String a;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String jdField_c_of_type_JavaLangString;
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private String f;
  private String g;
  
  public ContactSearchModelGlobalTroopMember(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramQQAppInterface, paramInt, 0L);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.d = paramString4;
  }
  
  private void a()
  {
    switch (this.jdField_e_of_type_Int)
    {
    default: 
      this.jdField_e_of_type_JavaLangString = "";
      this.f = null;
      return;
    case 0: 
      if (!TextUtils.isEmpty(this.c))
      {
        this.jdField_e_of_type_JavaLangString = this.c;
        this.f = this.jdField_b_of_type_JavaLangString;
        return;
      }
      if (!TextUtils.isEmpty(this.d))
      {
        this.jdField_e_of_type_JavaLangString = this.d;
        this.f = this.jdField_b_of_type_JavaLangString;
        return;
      }
      this.jdField_e_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      this.f = null;
      return;
    case 2: 
      this.jdField_e_of_type_JavaLangString = this.c;
      if (!TextUtils.isEmpty(this.d))
      {
        this.f = this.d;
        return;
      }
      this.f = this.jdField_b_of_type_JavaLangString;
      return;
    }
    if (!TextUtils.isEmpty(this.c))
    {
      this.jdField_e_of_type_JavaLangString = this.c;
      this.f = this.d;
      return;
    }
    this.jdField_e_of_type_JavaLangString = this.d;
    this.f = this.jdField_b_of_type_JavaLangString;
  }
  
  public int a()
  {
    return 1;
  }
  
  protected long a(String paramString)
  {
    this.g = paramString;
    this.jdField_b_of_type_Long = Long.MIN_VALUE;
    long l = SearchUtils.a(paramString, this.c, IContactSearchable.o, false, false, true);
    if (l > this.jdField_b_of_type_Long)
    {
      this.jdField_b_of_type_Long = l;
      this.jdField_e_of_type_Int = 2;
    }
    l = SearchUtils.a(paramString, this.d, IContactSearchable.j, false, false, true);
    if (l > this.jdField_b_of_type_Long)
    {
      this.jdField_b_of_type_Long = l;
      this.jdField_e_of_type_Int = 1;
    }
    l = SearchUtils.a(paramString, this.jdField_b_of_type_JavaLangString, IContactSearchable.m, false, true, true);
    if (l > this.jdField_b_of_type_Long)
    {
      this.jdField_b_of_type_Long = l;
      this.jdField_e_of_type_Int = 0;
    }
    if (this.jdField_b_of_type_Long != Long.MIN_VALUE)
    {
      this.jdField_b_of_type_Long += IContactSearchable.R;
      a();
    }
    return this.jdField_b_of_type_Long;
  }
  
  public Object a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(View paramView)
  {
    String str;
    if (SearchUtils.a(this.jdField_a_of_type_Int))
    {
      RecentUtil.a = true;
      str = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).d(this.jdField_a_of_type_JavaLangString);
      Friends localFriends = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(this.jdField_b_of_type_JavaLangString);
      if ((localFriends == null) || (!localFriends.isFriend())) {
        break label144;
      }
      RecentUtil.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, 0, ContactUtils.a(localFriends), false);
      SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ContactUtils.a(localFriends), this.jdField_b_of_type_JavaLangString, "", 0);
    }
    for (;;)
    {
      SearchHistoryManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.g);
      SearchUtils.a(this.g, 20, 1, paramView);
      SearchUtils.a(this.g, 20, paramView, false);
      SearchUtils.a(this, paramView);
      return;
      label144:
      RecentUtil.a(paramView.getContext(), this.jdField_b_of_type_JavaLangString, str, 1000, a().toString(), false);
      SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().toString(), this.jdField_b_of_type_JavaLangString, str, 1000);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return 1000;
  }
  
  public String b()
  {
    return this.g;
  }
  
  public CharSequence c()
  {
    String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, true);
    if (str != null) {
      return "来自群：" + str;
    }
    return "来自：群成员";
  }
  
  public String c()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return this.f;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\model\ContactSearchModelGlobalTroopMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */