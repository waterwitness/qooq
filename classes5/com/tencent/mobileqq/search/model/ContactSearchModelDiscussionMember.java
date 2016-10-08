package com.tencent.mobileqq.search.model;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.util.SearchUtils;

public class ContactSearchModelDiscussionMember
  extends IContactSearchModel
{
  private static final int jdField_b_of_type_Int = 0;
  private static final int jdField_c_of_type_Int = 1;
  private static final int d = 2;
  private DiscussionMemberInfo jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String jdField_c_of_type_JavaLangString;
  private int e;
  
  public ContactSearchModelDiscussionMember(QQAppInterface paramQQAppInterface, int paramInt, DiscussionMemberInfo paramDiscussionMemberInfo)
  {
    super(paramQQAppInterface, paramInt, 0L);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo = paramDiscussionMemberInfo;
  }
  
  private void a()
  {
    switch (this.e)
    {
    default: 
      this.jdField_a_of_type_JavaLangString = "";
      return;
    case 0: 
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark))
      {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark;
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin;
        return;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName))
      {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName;
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin;
        return;
      }
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin;
      this.jdField_b_of_type_JavaLangString = null;
      return;
    case 2: 
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName))
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName;
        return;
      }
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin;
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark))
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName;
      return;
    }
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin;
  }
  
  public int a()
  {
    return 1;
  }
  
  protected long a(String paramString)
  {
    this.c = paramString;
    this.jdField_b_of_type_Long = Long.MIN_VALUE;
    long l = SearchUtils.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark, IContactSearchable.i);
    if (l > this.jdField_b_of_type_Long)
    {
      this.jdField_b_of_type_Long = l;
      this.e = 2;
    }
    l = SearchUtils.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName, IContactSearchable.j);
    if (l > this.jdField_b_of_type_Long)
    {
      this.jdField_b_of_type_Long = l;
      this.e = 1;
    }
    l = SearchUtils.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin, IContactSearchable.m, false);
    if (l > this.jdField_b_of_type_Long)
    {
      this.jdField_b_of_type_Long = l;
      this.e = 0;
    }
    if (this.jdField_b_of_type_Long != Long.MIN_VALUE)
    {
      this.jdField_b_of_type_Long += IContactSearchable.E;
      a();
    }
    return this.jdField_b_of_type_Long;
  }
  
  public Pair a()
  {
    switch (this.e)
    {
    default: 
      return null;
    case 0: 
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark)) {
        return new Pair(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark, SearchUtils.c(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin, this.c, 6, false));
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName)) {
        return new Pair(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName, SearchUtils.c(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin, this.c, 6, false));
      }
      return new Pair(SearchUtils.b(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin, this.c, 6, false), null);
    case 2: 
      return new Pair(SearchUtils.b(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark, this.c, 6, true), null);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark)) {
      return new Pair(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark, SearchUtils.c(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName, this.c, 6, true));
    }
    return new Pair(SearchUtils.b(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName, this.c, 6, true), null);
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin;
  }
  
  public void a(View paramView)
  {
    if (SearchUtils.a(this.jdField_a_of_type_Int))
    {
      RecentUtil.a = true;
      RecentUtil.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.discussionUin, 1004, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName, false);
      SearchUtils.a(this.c, 20, 1, paramView);
      SearchHistoryManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.c);
      SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().toString(), this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.discussionUin, 1004);
      SearchUtils.a(this.c, 20, paramView, false);
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
    return 1004;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public CharSequence c()
  {
    if (SearchUtils.a(this.jdField_a_of_type_Int)) {
      return "来自：多人聊天";
    }
    return "多人聊天成员";
  }
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public CharSequence e()
  {
    Object localObject = a();
    CharSequence localCharSequence = b();
    switch (this.e)
    {
    }
    do
    {
      localObject = super.e();
      SpannableStringBuilder localSpannableStringBuilder;
      do
      {
        return (CharSequence)localObject;
        localSpannableStringBuilder = new SpannableStringBuilder();
        if (localObject != null) {
          localSpannableStringBuilder.append((CharSequence)localObject);
        }
        localObject = localSpannableStringBuilder;
      } while (localCharSequence == null);
      localSpannableStringBuilder.append(localCharSequence);
      return localSpannableStringBuilder;
      return (CharSequence)localObject;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark)) {
        return (CharSequence)localObject;
      }
    } while ((localCharSequence == null) || (localCharSequence.length() <= 2));
    return localCharSequence.subSequence(1, localCharSequence.length() - 1);
  }
  
  public String e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.discussionUin;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\model\ContactSearchModelDiscussionMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */