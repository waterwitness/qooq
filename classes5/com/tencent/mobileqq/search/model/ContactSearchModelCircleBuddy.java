package com.tencent.mobileqq.search.model;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.data.CircleBuddy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.util.SearchUtils;

public class ContactSearchModelCircleBuddy
  extends IContactSearchModel
{
  private CircleBuddy jdField_a_of_type_ComTencentMobileqqDataCircleBuddy;
  private String jdField_a_of_type_JavaLangString;
  private long b;
  
  public ContactSearchModelCircleBuddy(QQAppInterface paramQQAppInterface, int paramInt, CircleBuddy paramCircleBuddy)
  {
    super(paramQQAppInterface, paramInt, 0L);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy = paramCircleBuddy;
  }
  
  public int a()
  {
    return 1;
  }
  
  protected long a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = Long.MIN_VALUE;
    long l = SearchUtils.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.remark, IContactSearchable.g);
    if (l > this.b) {
      this.b = l;
    }
    l = SearchUtils.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.nickName, IContactSearchable.j);
    if (l > this.b) {
      this.b = l;
    }
    if (this.b != Long.MIN_VALUE) {
      this.b += IContactSearchable.N;
    }
    return this.b;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.uin;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.uin;
  }
  
  public void a(View paramView)
  {
    if (SearchUtils.a(this.jdField_a_of_type_Int))
    {
      RecentUtil.a = true;
      RecentUtil.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.uin, 1021, c(), false);
      SearchUtils.a(this.jdField_a_of_type_JavaLangString, 20, 1, paramView);
      SearchHistoryManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, c(), this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.uin, "", 0);
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
    return 1021;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public CharSequence c()
  {
    if (SearchUtils.a(this.jdField_a_of_type_Int)) {
      return "来自：人脉圈";
    }
    return "人脉圈";
  }
  
  public String c()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.remark)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.nickName;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.remark;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.remark)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.uin;
    }
    return SearchUtils.a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.nickName, this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.uin });
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\model\ContactSearchModelCircleBuddy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */