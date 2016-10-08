package com.tencent.mobileqq.search.model;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.util.SearchUtils;

public class ContactSearchModelTroopMember
  extends IContactSearchModel
{
  private static final int jdField_b_of_type_Int = 0;
  private static final int jdField_c_of_type_Int = 1;
  private static final int d = 2;
  private static final int e = 3;
  private TroopMemberInfo jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String jdField_c_of_type_JavaLangString;
  private int f;
  
  public ContactSearchModelTroopMember(QQAppInterface paramQQAppInterface, int paramInt, TroopMemberInfo paramTroopMemberInfo)
  {
    super(paramQQAppInterface, paramInt, 0L);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.f = 1;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo = paramTroopMemberInfo;
  }
  
  private void a()
  {
    switch (this.f)
    {
    default: 
      return;
    case 2: 
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick;
      this.c = SearchUtils.a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin });
      return;
    case 3: 
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.autoremark;
      this.c = SearchUtils.a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin });
      return;
    case 1: 
      this.jdField_b_of_type_JavaLangString = SearchUtils.a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.autoremark });
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        this.c = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick;
        return;
      }
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick;
      this.c = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin;
      return;
    }
    this.jdField_b_of_type_JavaLangString = SearchUtils.a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.autoremark, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick });
    this.c = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin;
  }
  
  public int a()
  {
    return 1;
  }
  
  protected long a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Long = Long.MIN_VALUE;
    long l = SearchUtils.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick, IContactSearchable.g);
    if (l > this.jdField_b_of_type_Long)
    {
      this.jdField_b_of_type_Long = l;
      this.f = 2;
    }
    l = SearchUtils.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.autoremark, IContactSearchable.i);
    if (l > this.jdField_b_of_type_Long)
    {
      this.jdField_b_of_type_Long = l;
      this.f = 3;
    }
    l = SearchUtils.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick, IContactSearchable.j);
    if (l > this.jdField_b_of_type_Long)
    {
      this.jdField_b_of_type_Long = l;
      this.f = 1;
    }
    l = SearchUtils.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin, IContactSearchable.m, false);
    if (l > this.jdField_b_of_type_Long)
    {
      this.jdField_b_of_type_Long = l;
      this.f = 0;
    }
    if (this.jdField_b_of_type_Long != Long.MIN_VALUE)
    {
      this.jdField_b_of_type_Long += IContactSearchable.x;
      a();
    }
    return this.jdField_b_of_type_Long;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin;
  }
  
  public void a(View paramView)
  {
    if (SearchUtils.a(this.jdField_a_of_type_Int))
    {
      RecentUtil.a = true;
      RecentUtil.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopuin, 1000, c(), false);
      SearchUtils.a(this.jdField_a_of_type_JavaLangString, 20, 1, paramView);
      SearchUtils.a(this.jdField_a_of_type_JavaLangString, 20, paramView, false);
      SearchUtils.a(this, paramView);
      return;
    }
    SearchUtils.a(paramView, this);
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
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public CharSequence c()
  {
    if (SearchUtils.a(this.jdField_a_of_type_Int)) {
      return "来自：群成员";
    }
    return "群成员";
  }
  
  public String c()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return this.c;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\model\ContactSearchModelTroopMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */