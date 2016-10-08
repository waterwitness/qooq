package com.tencent.mobileqq.t9search;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class T9MatchPinyinUnits
{
  public T9MatchPinyinUnits()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static boolean a(List paramList, int paramInt1, int paramInt2, String paramString, StringBuffer paramStringBuffer1, StringBuffer paramStringBuffer2)
  {
    if ((paramList == null) || (paramString == null) || (paramStringBuffer1 == null) || (paramStringBuffer2 == null)) {
      return false;
    }
    String str1 = paramStringBuffer1.toString();
    if (str1.length() <= 0) {
      return true;
    }
    if (paramInt1 >= paramList.size()) {
      return false;
    }
    PinyinUnit localPinyinUnit = (PinyinUnit)paramList.get(paramInt1);
    if (paramInt2 >= localPinyinUnit.jdField_a_of_type_JavaUtilList.size()) {
      return false;
    }
    PinyinBaseUnit localPinyinBaseUnit = (PinyinBaseUnit)localPinyinUnit.jdField_a_of_type_JavaUtilList.get(paramInt2);
    if (localPinyinUnit.jdField_a_of_type_Boolean)
    {
      if (str1.startsWith(String.valueOf(localPinyinBaseUnit.c.charAt(0))))
      {
        paramStringBuffer1.delete(0, 1);
        paramStringBuffer2.append(paramString.charAt(localPinyinUnit.jdField_a_of_type_Int));
        if (true == a(paramList, paramInt1 + 1, 0, paramString, paramStringBuffer1, paramStringBuffer2)) {
          return true;
        }
        paramStringBuffer1.insert(0, localPinyinBaseUnit.c.charAt(0));
        paramStringBuffer2.deleteCharAt(paramStringBuffer2.length() - 1);
      }
      if (localPinyinBaseUnit.c.startsWith(str1))
      {
        paramStringBuffer2.append(paramString.charAt(localPinyinUnit.jdField_a_of_type_Int));
        paramStringBuffer1.delete(0, paramStringBuffer1.length());
        return true;
      }
      if (str1.startsWith(localPinyinBaseUnit.c))
      {
        paramStringBuffer1.delete(0, localPinyinBaseUnit.c.length());
        paramStringBuffer2.append(paramString.charAt(localPinyinUnit.jdField_a_of_type_Int));
        if (true == a(paramList, paramInt1 + 1, 0, paramString, paramStringBuffer1, paramStringBuffer2)) {
          return true;
        }
        paramStringBuffer1.insert(0, localPinyinBaseUnit.c);
        paramStringBuffer2.deleteCharAt(paramStringBuffer2.length() - 1);
      }
    }
    do
    {
      do
      {
        for (;;)
        {
          return false;
          if (a(paramList, paramInt1, paramInt2 + 1, paramString, paramStringBuffer1, paramStringBuffer2) == true)
          {
            return true;
            if (localPinyinBaseUnit.c.startsWith(str1))
            {
              paramStringBuffer2.append(paramString.substring(localPinyinUnit.jdField_a_of_type_Int + 0, 0 + localPinyinUnit.jdField_a_of_type_Int + str1.length()));
              paramStringBuffer1.delete(0, paramStringBuffer1.length());
              return true;
            }
            if (!str1.startsWith(localPinyinBaseUnit.c)) {
              break;
            }
            paramStringBuffer1.delete(0, localPinyinBaseUnit.c.length());
            paramStringBuffer2.append(paramString.substring(localPinyinUnit.jdField_a_of_type_Int + 0, 0 + localPinyinUnit.jdField_a_of_type_Int + localPinyinBaseUnit.c.length()));
            if (true == a(paramList, paramInt1 + 1, 0, paramString, paramStringBuffer1, paramStringBuffer2)) {
              return true;
            }
            paramStringBuffer1.insert(0, localPinyinBaseUnit.c);
            paramStringBuffer2.delete(paramStringBuffer2.length() - localPinyinBaseUnit.c.length(), paramStringBuffer2.length());
          }
        }
        if (paramStringBuffer2.length() > 0) {
          break;
        }
        if (localPinyinBaseUnit.c.contains(str1))
        {
          paramInt1 = localPinyinBaseUnit.c.indexOf(str1);
          paramStringBuffer2.append(paramString.substring(localPinyinUnit.jdField_a_of_type_Int + paramInt1, paramInt1 + localPinyinUnit.jdField_a_of_type_Int + str1.length()));
          paramStringBuffer1.delete(0, paramStringBuffer1.length());
          return true;
        }
        int j = localPinyinBaseUnit.c.length();
        int i = 0;
        while (i < j)
        {
          String str2 = localPinyinBaseUnit.c.substring(i);
          if (str1.startsWith(str2))
          {
            paramStringBuffer1.delete(0, str2.length());
            paramStringBuffer2.append(paramString.substring(localPinyinUnit.jdField_a_of_type_Int + i, localPinyinUnit.jdField_a_of_type_Int + i + str2.length()));
            if (true == a(paramList, paramInt1 + 1, 0, paramString, paramStringBuffer1, paramStringBuffer2)) {
              return true;
            }
            paramStringBuffer1.insert(0, localPinyinBaseUnit.c.substring(i));
            paramStringBuffer2.delete(paramStringBuffer2.length() - str2.length(), paramStringBuffer2.length());
          }
          i += 1;
        }
      } while (true != a(paramList, paramInt1, paramInt2 + 1, paramString, paramStringBuffer1, paramStringBuffer2));
      return true;
    } while (true != a(paramList, paramInt1, paramInt2 + 1, paramString, paramStringBuffer1, paramStringBuffer2));
    return true;
  }
  
  public static boolean a(List paramList, String paramString1, String paramString2, StringBuffer paramStringBuffer)
  {
    if ((paramList == null) || (paramString2 == null) || (paramStringBuffer == null)) {}
    for (;;)
    {
      return false;
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.delete(0, localStringBuffer.length());
      paramStringBuffer.delete(0, paramStringBuffer.length());
      int j = paramList.size();
      localStringBuffer = new StringBuffer();
      int i = 0;
      while (i < j)
      {
        paramStringBuffer.delete(0, paramStringBuffer.length());
        localStringBuffer.delete(0, localStringBuffer.length());
        localStringBuffer.append(paramString2);
        if (true == a(paramList, i, 0, paramString1, localStringBuffer, paramStringBuffer)) {
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\t9search\T9MatchPinyinUnits.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */