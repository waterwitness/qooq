package com.tencent.mobileqq.activity.contact.addcontact;

import android.os.SystemClock;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.PhoneCodeUtils;
import com.tencent.qphone.base.util.QLog;
import ohp;

public class ContactSearchFacade
{
  public static final int a = 80000000;
  public static final String a;
  private static int[] jdField_a_of_type_ArrayOfInt;
  public static final int b = 80000001;
  private static int[] b;
  public static final int c = 80000002;
  private static int[] jdField_c_of_type_ArrayOfInt = { 80000002 };
  public static final int d = 80000003;
  private static int[] d = { 80000003 };
  public static final int e = 80000004;
  private static int[] e = { 80000000, 80000001, 80000002, 80000003 };
  public static final int f = 80000005;
  private static int[] f = { 80000002, 80000003 };
  private long jdField_a_of_type_Long;
  private ContactSearchFacade.ISearchListener jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade$ISearchListener;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ohp(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public String b;
  private String jdField_c_of_type_JavaLangString;
  private int g;
  private int h;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = ContactSearchFacade.class.getName();
    jdField_a_of_type_ArrayOfInt = new int[] { 80000000 };
    jdField_b_of_type_ArrayOfInt = new int[] { 80000001 };
  }
  
  public ContactSearchFacade(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_c_of_type_JavaLangString = PhoneCodeUtils.a(paramQQAppInterface.getApplication());
  }
  
  public int a()
  {
    return this.g;
  }
  
  final void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
    }
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void a(ContactSearchFacade.ISearchListener paramISearchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade$ISearchListener = paramISearchListener;
  }
  
  public void a(String paramString, int[] paramArrayOfInt, double paramDouble1, double paramDouble2, boolean paramBoolean, int paramInt)
  {
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(paramString, this.jdField_c_of_type_JavaLangString, 3, this.g, paramArrayOfInt, paramDouble1, paramDouble2, paramBoolean, paramInt, this.jdField_a_of_type_Long);
  }
  
  public boolean a(String paramString)
  {
    a();
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(paramString, this.jdField_c_of_type_JavaLangString, 2, 0, null, 0.0D, 0.0D, true, 0L);
    return true;
  }
  
  public boolean a(String paramString, int paramInt1, double paramDouble1, double paramDouble2, int paramInt2)
  {
    a();
    this.jdField_b_of_type_JavaLangString = paramString;
    this.h = paramInt1;
    int[] arrayOfInt = null;
    switch (paramInt1)
    {
    }
    while (arrayOfInt == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "warning! wrong request type = " + paramInt1);
      }
      return false;
      arrayOfInt = jdField_a_of_type_ArrayOfInt;
      continue;
      arrayOfInt = jdField_b_of_type_ArrayOfInt;
      continue;
      arrayOfInt = jdField_c_of_type_ArrayOfInt;
      continue;
      arrayOfInt = d;
      continue;
      arrayOfInt = e;
      continue;
      arrayOfInt = f;
    }
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(paramString, this.jdField_c_of_type_JavaLangString, 3, this.g, arrayOfInt, paramDouble1, paramDouble2, true, paramInt2, this.jdField_a_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "searchFriend nextPage = " + this.g);
    }
    return true;
  }
  
  public final void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
  }
  
  public void c()
  {
    this.g = 0;
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade$ISearchListener = null;
    this.g = 0;
    b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\contact\addcontact\ContactSearchFacade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */