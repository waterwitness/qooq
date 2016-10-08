package com.tencent.mobileqq.search.model;

import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.ChnSpelling;
import java.util.ArrayList;

public class ContactSearchModelPhoneContact
  extends IContactSearchModel
{
  private static LruCache jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(3);
  private static final int jdField_b_of_type_Int = 0;
  private static final int jdField_c_of_type_Int = 1;
  private static final int d = 2;
  private static final int e = 3;
  public PhoneContact a;
  public ChnToSpell.ChnSpelling a;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long;
  public ChnToSpell.ChnSpelling b;
  private long jdField_c_of_type_Long;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ContactSearchModelPhoneContact(QQAppInterface paramQQAppInterface, int paramInt, PhoneContact paramPhoneContact)
  {
    super(paramQQAppInterface, paramInt, 0L);
    this.c = IContactSearchable.F;
    this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = paramPhoneContact;
    if (TextUtils.isEmpty(paramPhoneContact.uin)) {
      this.c = IContactSearchable.M;
    }
    if (!TextUtils.isEmpty(paramPhoneContact.name))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpelling = ChnToSpell.a(paramPhoneContact.name, 1);
      this.jdField_b_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpelling = ChnToSpell.a(paramPhoneContact.name, 2);
    }
  }
  
  public int a()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin)) || (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin.equals("0"))) {
      return 11;
    }
    return 1;
  }
  
  protected long a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Long = Long.MIN_VALUE;
    long l = SearchUtils.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name, this.jdField_a_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpelling, this.jdField_b_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpelling, IContactSearchable.k);
    if (l > this.jdField_b_of_type_Long) {
      this.jdField_b_of_type_Long = l;
    }
    String str2 = (String)jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
    String str1 = str2;
    if (str2 == null)
    {
      str1 = paramString.replaceAll("-", "");
      jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, str1);
    }
    l = SearchUtils.a(str1, this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileNo, IContactSearchable.n, false);
    if (l > this.jdField_b_of_type_Long) {
      this.jdField_b_of_type_Long = l;
    }
    if (this.jdField_b_of_type_Long != Long.MIN_VALUE) {
      this.jdField_b_of_type_Long += this.c;
    }
    return this.jdField_b_of_type_Long;
  }
  
  public Object a()
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin;
    String str1;
    if (TextUtils.isEmpty(str2)) {
      str1 = "mn:" + this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileNo;
    }
    do
    {
      return str1;
      str1 = str2;
    } while (!str2.equals("0"));
    return this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode;
  }
  
  public String a()
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin;
    String str1;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileNo;
    }
    do
    {
      return str1;
      str1 = str2;
    } while (!str2.equals("0"));
    return this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode;
  }
  
  public void a(View paramView)
  {
    int i = 0;
    if (SearchUtils.a(this.jdField_a_of_type_Int))
    {
      RecentUtil.a = true;
      Object localObject;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin))
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileNo;
        ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(str, 33);
        localAllInOne.a = new ArrayList();
        localAllInOne.k = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name;
        localAllInOne.h = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.nickName;
        String[] arrayOfString = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileNo.split("\\|");
        if (i < arrayOfString.length)
        {
          ArrayList localArrayList = localAllInOne.a;
          StringBuilder localStringBuilder = new StringBuilder().append("电话");
          if (arrayOfString.length > 0) {}
          for (localObject = Integer.valueOf(i + 1);; localObject = "")
          {
            localArrayList.add(new ProfileActivity.CardContactInfo(localObject, arrayOfString[i], this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.nationCode));
            i += 1;
            break;
          }
        }
        localAllInOne.d = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.ability;
        localAllInOne.f = 3;
        ProfileActivity.b(paramView.getContext(), localAllInOne);
        SearchHistoryManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
        SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().toString(), str, "", 56938);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin.equals("0")) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode;
      }
      for (i = 1006;; i = 0)
      {
        RecentUtil.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, i, this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name, false);
        SearchUtils.a(this.jdField_a_of_type_JavaLangString, 20, 1, paramView);
        SearchHistoryManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
        SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().toString(), (String)localObject, "", i);
        SearchUtils.a(this.jdField_a_of_type_JavaLangString, 20, paramView, false);
        SearchUtils.a(this, paramView);
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin;
      }
    }
    SearchUtils.a(paramView, this);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin)) {
      return 56938;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin.equals("0")) {
      return 1006;
    }
    return 0;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public CharSequence c()
  {
    if (SearchUtils.a(this.jdField_a_of_type_Int)) {
      return "来自：手机通讯录";
    }
    return "手机通讯录";
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileNo;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\model\ContactSearchModelPhoneContact.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */