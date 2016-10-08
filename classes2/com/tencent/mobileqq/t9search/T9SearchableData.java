package com.tencent.mobileqq.t9search;

import android.text.TextUtils;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;
import java.util.List;
import uyi;
import uym;

public class T9SearchableData
  implements uyi, uym
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 0;
  public static final int f = 1;
  public static final int g = 2;
  public static final int h = 3;
  public static final int i = 4;
  private static final String j = "T9SearchData";
  public long a;
  public String a;
  private StringBuffer jdField_a_of_type_JavaLangStringBuffer;
  private List jdField_a_of_type_JavaUtilList;
  public boolean a;
  public String b;
  private List b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  public int o;
  private final int p;
  
  public T9SearchableData(Friends paramFriends)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangStringBuffer = new StringBuffer();
    this.p = 10;
    this.j = 1;
    this.h = paramFriends.uin;
    this.o = 0;
    this.c = paramFriends.remark;
    this.d = paramFriends.name;
    this.g = paramFriends.uin;
    T9Utils.a(this.c, this.jdField_b_of_type_JavaUtilList);
    T9Utils.a(this.d, this.jdField_a_of_type_JavaUtilList);
  }
  
  public T9SearchableData(PhoneContact paramPhoneContact, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangStringBuffer = new StringBuffer();
    this.p = 10;
    this.j = 3;
    int i1;
    int i2;
    if (!TextUtils.isEmpty(paramPhoneContact.uin))
    {
      i1 = 1;
      if ((i1 == 0) || (paramPhoneContact.uin.equals("0"))) {
        break label212;
      }
      i2 = 1;
      label82:
      paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(50);
      if ((i2 != 0) && (paramQQAppInterface != null)) {
        break label218;
      }
      paramQQAppInterface = null;
      label103:
      if ((paramQQAppInterface == null) || (!paramQQAppInterface.isFriend())) {
        break label230;
      }
      i2 = i3;
      label118:
      if (i2 == 0) {
        break label236;
      }
      this.h = paramPhoneContact.uin;
      this.o = 0;
      this.g = this.h;
    }
    for (;;)
    {
      this.c = paramPhoneContact.remark;
      this.d = paramPhoneContact.name;
      this.e = paramPhoneContact.mobileNo;
      this.n = paramPhoneContact.contactID;
      this.f = this.e;
      T9Utils.a(this.c, this.jdField_b_of_type_JavaUtilList);
      T9Utils.a(this.d, this.jdField_a_of_type_JavaUtilList);
      return;
      i1 = 0;
      break;
      label212:
      i2 = 0;
      break label82;
      label218:
      paramQQAppInterface = paramQQAppInterface.c(paramPhoneContact.uin);
      break label103;
      label230:
      i2 = 0;
      break label118;
      label236:
      if (i1 != 0)
      {
        this.h = paramPhoneContact.unifiedCode;
        this.o = 1006;
      }
      else
      {
        this.h = paramPhoneContact.mobileNo;
        this.o = 56938;
      }
    }
  }
  
  public T9SearchableData(QCallRecent paramQCallRecent, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangStringBuffer = new StringBuffer();
    this.p = 10;
    this.j = 2;
    this.h = paramQCallRecent.uin;
    this.o = paramQCallRecent.type;
    if (this.o == 3000)
    {
      paramQQAppInterface = (DiscussionManager)paramQQAppInterface.getManager(52);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.a(this.h);
        if (paramQQAppInterface != null) {
          this.c = paramQQAppInterface.discussionName;
        }
      }
      this.i = paramQCallRecent.pstnInfo;
      if ((this.o != 2016) && (this.o != 56938)) {
        break label180;
      }
    }
    label180:
    for (this.e = paramQCallRecent.uin;; this.e = paramQCallRecent.phoneNumber)
    {
      this.f = this.e;
      T9Utils.a(this.c, this.jdField_b_of_type_JavaUtilList);
      return;
      this.c = ContactUtils.c(paramQQAppInterface, paramQCallRecent.uin, false);
      break;
    }
  }
  
  public T9SearchableData(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangStringBuffer = new StringBuffer();
    this.p = 10;
    this.j = 4;
    this.h = paramString;
    this.o = -1;
    this.c = paramString;
  }
  
  private int a(char paramChar)
  {
    if ((paramChar >= 'a') && (paramChar <= 'z')) {
      return 'z' - paramChar + 1;
    }
    if ((paramChar >= 'A') && (paramChar <= 'Z')) {
      return 'Z' - paramChar + 1;
    }
    return 0;
  }
  
  private int a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return 0;
      if (paramString1.startsWith(paramString2)) {
        return 2;
      }
      if (paramString1.contains(paramString2)) {
        return 1;
      }
    } while (!paramString1.equals(paramString2));
    return 3;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    int i1 = 0;
    switch (paramInt2)
    {
    default: 
      paramInt2 = i1;
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_Long += paramInt1 * 1000000000L;
      this.jdField_a_of_type_Long += paramInt2 * 100000000L;
      this.jdField_a_of_type_Long += paramInt3 * 10000000L;
      this.jdField_a_of_type_Long += a(paramInt4) * 100000L;
      this.jdField_a_of_type_Long += a(paramString) * 1L;
      return;
      paramInt2 = 3;
      continue;
      paramInt2 = 2;
      continue;
      paramInt2 = 1;
    }
  }
  
  private boolean a(String paramString, int paramInt)
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(this.c))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      bool = T9MatchPinyinUnits.a(this.jdField_b_of_type_JavaUtilList, this.c, paramString, localStringBuffer);
      if (bool)
      {
        a(localStringBuffer.toString());
        localStringBuffer.delete(0, localStringBuffer.length());
        this.l = 1;
        this.m = this.c.indexOf(a().toString());
        this.k = a(this.c, a().toString());
        a(paramInt, this.k, 4, this.m, this.c);
      }
    }
    return bool;
  }
  
  private void b(String paramString)
  {
    if ((!a(paramString, 1)) && (!b(paramString, 1))) {
      d(paramString, 1);
    }
  }
  
  private boolean b(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(this.d))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      if (T9MatchPinyinUnits.a(this.jdField_a_of_type_JavaUtilList, this.d, paramString, localStringBuffer))
      {
        a(localStringBuffer.toString());
        localStringBuffer.delete(0, localStringBuffer.length());
        this.l = 2;
        this.m = this.d.indexOf(a().toString());
        this.k = a(this.d, a().toString());
        a(paramInt, this.k, 4, this.m, this.d);
      }
    }
    return false;
  }
  
  private void c(String paramString)
  {
    if (!a(paramString, 2)) {
      c(paramString, 2);
    }
  }
  
  private boolean c(String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(this.f))
    {
      if (!this.f.equals(paramString)) {
        break label66;
      }
      this.k = 3;
      this.l = 4;
      this.m = 0;
      this.jdField_a_of_type_Boolean = true;
      a(paramInt, 3, 3, this.m, b());
      bool1 = true;
    }
    label66:
    do
    {
      return bool1;
      if (this.f.startsWith(paramString))
      {
        this.k = 2;
        this.l = 4;
        this.m = 0;
        a(paramInt, 2, 3, this.m, b());
        return true;
      }
      bool1 = bool2;
    } while (!this.f.contains(paramString));
    this.k = 1;
    this.l = 4;
    this.m = this.f.indexOf(paramString);
    a(paramInt, 1, 3, this.m, b());
    return true;
  }
  
  private void d(String paramString)
  {
    if ((!a(paramString, 4)) && (!b(paramString, 4)) && (!c(paramString, 4))) {
      d(paramString, 4);
    }
  }
  
  private boolean d(String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(this.g))
    {
      if (!this.g.equals(paramString)) {
        break label61;
      }
      this.k = 3;
      this.l = 3;
      this.m = 0;
      a(paramInt, 3, 2, this.m, b());
      bool1 = true;
    }
    label61:
    do
    {
      return bool1;
      if (this.g.startsWith(paramString))
      {
        this.k = 2;
        this.l = 3;
        this.m = 0;
        a(paramInt, 2, 2, this.m, b());
        return true;
      }
      bool1 = bool2;
    } while (!this.g.contains(paramString));
    this.k = 1;
    this.l = 3;
    this.m = this.g.indexOf(paramString);
    a(paramInt, 1, 2, this.m, b());
    return true;
  }
  
  public int a(int paramInt)
  {
    if (paramInt < 0) {
      return 0;
    }
    if (paramInt < 10) {
      return 10 - paramInt;
    }
    return 1;
  }
  
  public int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return 0;
      paramString = ChnToSpell.a(paramString, 2);
      if (paramString.length() >= 3) {
        return 0 + a(paramString.charAt(0)) * 900 + a(paramString.charAt(1)) * 30 + a(paramString.charAt(2));
      }
      if (paramString.length() == 2) {
        return 0 + a(paramString.charAt(0)) * 900 + a(paramString.charAt(1)) * 30 + 27;
      }
    } while (paramString.length() != 1);
    return 0 + a(paramString.charAt(0)) * 900 + 810 + 27;
  }
  
  public String a()
  {
    if (!TextUtils.isEmpty(this.h)) {
      return this.h;
    }
    return this.e;
  }
  
  public StringBuffer a()
  {
    return this.jdField_a_of_type_JavaLangStringBuffer;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangStringBuffer.delete(0, this.jdField_a_of_type_JavaLangStringBuffer.length());
    this.jdField_a_of_type_JavaLangStringBuffer.append(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.m = -1;
    this.jdField_a_of_type_Long = 0L;
    this.k = 0;
    this.l = 0;
    this.jdField_a_of_type_Boolean = false;
    if (this.j == 1) {
      b(paramString1);
    }
    do
    {
      return;
      if (this.j == 2)
      {
        c(paramString1);
        return;
      }
    } while (this.j != 3);
    d(paramString1);
  }
  
  public String b()
  {
    if (TextUtils.isEmpty(this.c)) {
      return this.d;
    }
    return this.c;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[T9SearchData:uin=").append(this.h).append(" uinType=").append(this.o).append(" type=").append(this.j).append(" remark=").append(this.c).append(" name=").append(this.d).append(" phone=").append(this.e).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\t9search\T9SearchableData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */