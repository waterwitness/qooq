package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Comparator;

public class ContactSorter$PhoneNameComparator
  implements Comparator
{
  public ContactSorter$PhoneNameComparator()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(String paramString1, String paramString2)
  {
    int i = 1;
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ContactUtils.PhoneNameComparator", 2, "lhsName is null");
      }
      throw new NullPointerException("com.tencent.mobileqq.utils.ContactUtils int compare lhsName is null for check ");
    }
    if ((paramString2 == null) || (paramString2.length() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ContactUtils.PhoneNameComparator", 2, "rhsName is null");
      }
      throw new NullPointerException("com.tencent.mobileqq.utils.ContactUtils  int compare rhsName is null for check ");
    }
    if ((Character.isDigit(paramString1.charAt(0))) || (Character.isDigit(paramString2.charAt(0)))) {
      if ((Character.isDigit(paramString1.charAt(0))) && (Character.isDigit(paramString2.charAt(0)))) {
        i = paramString1.charAt(0) - paramString2.charAt(0);
      }
    }
    String str1;
    String str2;
    do
    {
      do
      {
        return i;
      } while (Character.isDigit(paramString1.charAt(0)));
      return -1;
      str1 = ChnToSpell.a(paramString1, 1);
      str2 = ChnToSpell.a(paramString2, 1);
      if ((str1.length() == 0) || (str2.length() == 0)) {
        return -str1.compareTo(str2);
      }
      if (str1.charAt(0) != str2.charAt(0)) {
        break;
      }
      if ((StringUtil.c(paramString1.charAt(0))) && (StringUtil.c(paramString2.charAt(0)))) {
        return paramString1.charAt(0) - paramString2.charAt(0);
      }
    } while (Character.isLetter(paramString1.charAt(0)));
    if (Character.isLetter(paramString2.charAt(0))) {
      return -1;
    }
    return str1.compareTo(str2);
    return str1.charAt(0) - str2.charAt(0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\ContactSorter$PhoneNameComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */