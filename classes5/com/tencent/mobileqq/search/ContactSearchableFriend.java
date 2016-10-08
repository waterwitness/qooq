package com.tencent.mobileqq.search;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import mqq.app.MobileQQ;

public class ContactSearchableFriend
  extends IContactSearchable
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Friends jdField_a_of_type_ComTencentMobileqqDataFriends;
  public String a;
  public String b;
  public String c;
  public String d;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private String f;
  
  public ContactSearchableFriend(Context paramContext, QQAppInterface paramQQAppInterface, Friends paramFriends, String paramString, long paramLong)
  {
    this(paramContext, paramQQAppInterface, paramFriends, paramString, 0L, paramLong);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ContactSearchableFriend(Context paramContext, QQAppInterface paramQQAppInterface, Friends paramFriends, String paramString, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataFriends = paramFriends;
    this.aa = paramLong2;
    this.jdField_e_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark != null) && (this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark.length() != 0))
    {
      this.jdField_a_of_type_JavaLangString = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, 1).toLowerCase();
      this.b = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, 2).toLowerCase();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.name != null) && (this.jdField_a_of_type_ComTencentMobileqqDataFriends.name.length() != 0))
    {
      this.c = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, 1).toLowerCase();
      this.d = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, 2).toLowerCase();
    }
    b();
  }
  
  private String e()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
  }
  
  public int a()
  {
    return this.jdField_e_of_type_Int;
  }
  
  protected long a()
  {
    QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, 0);
    if (localMessage != null) {
      return localMessage.time;
    }
    return 0L;
  }
  
  public Drawable a()
  {
    return null;
  }
  
  public Friends a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataFriends;
  }
  
  public String a()
  {
    if (CrmUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin)) {
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131369705);
    }
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public void a(String paramString)
  {
    String str1;
    String str2;
    label42:
    String str3;
    label61:
    String str4;
    label80:
    String str5;
    String str6;
    String str7;
    String str8;
    long l1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark != null)
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark.toLowerCase();
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.name == null) {
        break label587;
      }
      str2 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.name.toLowerCase();
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin == null) {
        break label592;
      }
      str3 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias == null) {
        break label598;
      }
      str4 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias;
      str5 = this.jdField_a_of_type_JavaLangString;
      str6 = this.b;
      str7 = this.c;
      str8 = this.d;
      paramString = paramString.toLowerCase();
      l2 = Long.MIN_VALUE;
      this.Z = Long.MIN_VALUE;
      l1 = l2;
      if (str1 != null)
      {
        l1 = l2;
        if (str1.length() != 0)
        {
          if ((!str1.equals(paramString)) && ((str5 == null) || (!str5.equals(paramString))) && ((str6 == null) || (!str6.equals(paramString)))) {
            break label615;
          }
          l1 = IContactSearchable.s;
          if ((str1.equals(paramString)) || (str1.equals(str5))) {
            break label604;
          }
          l1 += IContactSearchable.q;
          label206:
          l2 = l1 + 0L;
          l1 = l2;
          if (this.Z < l2)
          {
            this.Z = l2;
            this.jdField_e_of_type_Int = 2;
            l1 = l2;
          }
        }
      }
      if ((str2 == null) || (str2.length() == 0)) {
        break label1091;
      }
      if ((!str2.equals(paramString)) && ((str7 == null) || (!str7.equals(paramString))) && ((str8 == null) || (!str8.equals(paramString)))) {
        break label765;
      }
      l1 = IContactSearchable.s;
      if ((str2.equals(paramString)) || (str2.equals(str7))) {
        break label745;
      }
      l1 = IContactSearchable.q + l1;
      label318:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) {
        break label756;
      }
      l1 += 0L;
      label337:
      l2 = l1;
      if (this.Z < l1)
      {
        this.Z = l1;
        this.jdField_e_of_type_Int = 1;
      }
    }
    label437:
    label587:
    label592:
    label598:
    label604:
    label615:
    label635:
    label648:
    label683:
    label720:
    label724:
    label726:
    label734:
    label745:
    label756:
    label765:
    label785:
    label798:
    label833:
    label883:
    label889:
    label897:
    label908:
    label917:
    label926:
    label992:
    label1001:
    label1079:
    label1088:
    label1091:
    for (long l2 = l1;; l2 = l1)
    {
      long l3 = l2;
      if (str4 != null)
      {
        l3 = l2;
        if (str4.length() != 0)
        {
          if (!str4.equals(paramString)) {
            break label926;
          }
          l1 = IContactSearchable.s + IContactSearchable.p;
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name))) {
            break label917;
          }
          l1 += 0L;
          l3 = l1;
          if (this.Z < l1)
          {
            this.Z = l1;
            this.jdField_e_of_type_Int = 3;
            l3 = l1;
          }
        }
      }
      if (1 != this.jdField_a_of_type_ComTencentMobileqqDataFriends.cSpecialFlag)
      {
        l1 = l3;
        if (str3 != null)
        {
          if (!str3.equals(paramString)) {
            break label1001;
          }
          l1 = IContactSearchable.s + IContactSearchable.p;
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name))) {
            break label992;
          }
          l1 += 0L;
        }
      }
      for (;;)
      {
        if (this.Z < l1)
        {
          this.Z = l1;
          this.jdField_e_of_type_Int = 0;
        }
        if (this.Z != Long.MIN_VALUE) {
          this.Z += this.aa;
        }
        return;
        str1 = null;
        break;
        str2 = null;
        break label42;
        str3 = null;
        break label61;
        str4 = null;
        break label80;
        l1 += IContactSearchable.p;
        break label206;
        int k = str1.indexOf(paramString);
        int j;
        if (str5 != null)
        {
          i = str5.indexOf(paramString);
          if (str6 == null) {
            break label720;
          }
          j = str6.indexOf(paramString);
          if ((k < 0) && (i < 0) && (j < 0)) {
            break label724;
          }
          if ((k != 0) && (i != 0) && (j != 0)) {
            break label726;
          }
          l1 = IContactSearchable.t;
          if ((k >= 0) || (str1.equals(str5))) {
            break label734;
          }
        }
        for (l1 += IContactSearchable.q;; l1 += IContactSearchable.p)
        {
          l2 = l1 + 0L;
          break;
          i = -1;
          break label635;
          j = -1;
          break label648;
          break;
          l1 = IContactSearchable.u;
          break label683;
        }
        l1 = IContactSearchable.p + l1;
        break label318;
        l1 += 0L;
        break label337;
        k = str2.indexOf(paramString);
        if (str7 != null)
        {
          i = str7.indexOf(paramString);
          if (str8 == null) {
            break label883;
          }
          j = str8.indexOf(paramString);
          if ((k < 0) && (i < 0) && (j < 0)) {
            break label1088;
          }
          if ((k != 0) && (i != 0) && (j != 0)) {
            break label889;
          }
          l1 = IContactSearchable.t;
          if ((k >= 0) || (str2.equals(str7))) {
            break label897;
          }
        }
        for (l1 = IContactSearchable.q + l1;; l1 = IContactSearchable.p + l1)
        {
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) {
            break label908;
          }
          l1 += 0L;
          break;
          i = -1;
          break label785;
          j = -1;
          break label798;
          l1 = IContactSearchable.u;
          break label833;
        }
        l1 += 0L;
        break label337;
        l1 += 0L;
        break label437;
        l1 = l2;
        if (str4.indexOf(paramString) < 0) {
          break label437;
        }
        l1 = IContactSearchable.u + IContactSearchable.p;
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name)))
        {
          l1 += 0L;
          break label437;
        }
        l1 += 0L;
        break label437;
        l1 += 0L;
        continue;
        int i = str3.indexOf(paramString);
        l1 = l3;
        if (i >= 0)
        {
          if (i == 0) {}
          for (l1 = IContactSearchable.t;; l1 = IContactSearchable.u)
          {
            l1 += IContactSearchable.p;
            if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name))) {
              break label1079;
            }
            l1 += 0L;
            break;
          }
          l1 += 0L;
        }
      }
      break label337;
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  public String b()
  {
    if (this.f != null) {
      return String.format("(%s)", new Object[] { this.f });
    }
    return null;
  }
  
  public int c()
  {
    return 1;
  }
  
  public String c()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark;
    String str1 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.name;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias;
    String str2 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
    switch (this.jdField_e_of_type_Int)
    {
    default: 
      localObject2 = null;
    case 0: 
    case 2: 
      do
      {
        do
        {
          return (String)localObject2;
          if (((str1 != null) && (str1.length() != 0)) || ((localObject1 != null) && (((String)localObject1).length() != 0)))
          {
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject1 = str1;
            }
            for (;;)
            {
              localObject1 = String.format("%s", new Object[] { localObject1 });
              this.f = e();
              return (String)localObject1;
            }
          }
          return str2;
          localObject2 = localObject1;
        } while (str1 == null);
        localObject2 = localObject1;
      } while (str1.length() == 0);
      localObject1 = String.format("%s", new Object[] { localObject1 });
      this.f = str1;
      return (String)localObject1;
    case 1: 
      if ((localObject1 != null) && (((String)localObject1).length() != 0))
      {
        localObject1 = String.format("%s", new Object[] { localObject1 });
        this.f = str1;
        return (String)localObject1;
      }
      localObject1 = String.format("%s", new Object[] { str1 });
      this.f = e();
      return (String)localObject1;
    }
    if (((str1 != null) && (str1.length() != 0)) || ((localObject1 != null) && (((String)localObject1).length() != 0)))
    {
      localObject1 = String.format("%s", new Object[] { ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends) });
      this.f = ((String)localObject2);
      return (String)localObject1;
    }
    return (String)localObject2;
  }
  
  public String d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\ContactSearchableFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */