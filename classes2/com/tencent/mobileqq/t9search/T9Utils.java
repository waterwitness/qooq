package com.tencent.mobileqq.t9search;

import android.text.Html;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class T9Utils
{
  public T9Utils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static char a(char paramChar)
  {
    switch (paramChar)
    {
    case '[': 
    case '\\': 
    case ']': 
    case '^': 
    case '_': 
    case '`': 
    default: 
      return paramChar;
    case 'A': 
    case 'B': 
    case 'C': 
    case 'a': 
    case 'b': 
    case 'c': 
      return '2';
    case 'D': 
    case 'E': 
    case 'F': 
    case 'd': 
    case 'e': 
    case 'f': 
      return '3';
    case 'G': 
    case 'H': 
    case 'I': 
    case 'g': 
    case 'h': 
    case 'i': 
      return '4';
    case 'J': 
    case 'K': 
    case 'L': 
    case 'j': 
    case 'k': 
    case 'l': 
      return '5';
    case 'M': 
    case 'N': 
    case 'O': 
    case 'm': 
    case 'n': 
    case 'o': 
      return '6';
    case 'P': 
    case 'Q': 
    case 'R': 
    case 'S': 
    case 'p': 
    case 'q': 
    case 'r': 
    case 's': 
      return '7';
    case 'T': 
    case 'U': 
    case 'V': 
    case 't': 
    case 'u': 
    case 'v': 
      return '8';
    }
    return '9';
  }
  
  public static String a(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    do
    {
      do
      {
        return null;
        paramList = ((PinyinUnit)paramList.get(0)).jdField_a_of_type_JavaUtilList;
      } while ((paramList == null) || (paramList.size() <= 0));
      paramList = ((PinyinBaseUnit)paramList.get(0)).b;
    } while ((paramList == null) || (paramList.length() <= 0));
    return String.valueOf(paramList.charAt(0));
  }
  
  public static List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      T9SearchableData localT9SearchableData = (T9SearchableData)paramList.next();
      if ((localT9SearchableData.j == 1) || (localT9SearchableData.j == 2))
      {
        if (!localConcurrentHashMap.containsKey(localT9SearchableData.h))
        {
          localArrayList.add(localT9SearchableData);
          localConcurrentHashMap.put(localT9SearchableData.h, localT9SearchableData);
        }
      }
      else if ((localT9SearchableData.j == 3) && (!localConcurrentHashMap.containsKey(localT9SearchableData.e)))
      {
        localConcurrentHashMap.put(localT9SearchableData.e, localT9SearchableData);
        localArrayList.add(localT9SearchableData);
      }
    }
    return localArrayList;
  }
  
  public static void a(TextView paramTextView, String paramString1, String paramString2)
  {
    if ((paramTextView == null) || (paramString1 == null) || (paramString2 == null)) {
      return;
    }
    int i = paramString1.indexOf(paramString2);
    if (i < 0)
    {
      paramTextView.setText(paramString1);
      return;
    }
    int j = paramString2.length();
    paramTextView.setText(Html.fromHtml(paramString1.substring(0, i) + "<font color=#00a5e0>" + paramString1.substring(i, i + j) + "</font>" + paramString1.substring(i + j, paramString1.length())));
  }
  
  private static void a(PinyinBaseUnit paramPinyinBaseUnit, String paramString1, String paramString2)
  {
    if ((paramPinyinBaseUnit == null) || (paramString1 == null) || (paramString2 == null)) {
      return;
    }
    paramPinyinBaseUnit.a = new String(paramString1);
    paramPinyinBaseUnit.b = new String(paramString2);
    int j = paramString2.length();
    paramString1 = new StringBuffer();
    paramString1.delete(0, paramString1.length());
    int i = 0;
    while (i < j)
    {
      paramString1.append(a(paramString2.charAt(i)));
      i += 1;
    }
    paramPinyinBaseUnit.c = new String(paramString1.toString());
    paramString1.delete(0, paramString1.length());
  }
  
  private static void a(PinyinUnit paramPinyinUnit, boolean paramBoolean, String paramString, String[] paramArrayOfString, int paramInt)
  {
    int i = 0;
    if ((paramPinyinUnit == null) || (paramString == null) || (paramArrayOfString == null)) {}
    int j;
    for (;;)
    {
      return;
      j = paramArrayOfString.length;
      paramPinyinUnit.jdField_a_of_type_Boolean = paramBoolean;
      paramPinyinUnit.jdField_a_of_type_Int = paramInt;
      paramInt = i;
      if (paramBoolean)
      {
        if (j <= 1) {
          paramInt = i;
        }
      }
      else {
        while (paramInt < j)
        {
          localPinyinBaseUnit = new PinyinBaseUnit();
          a(localPinyinBaseUnit, paramString, paramArrayOfString[paramInt]);
          paramPinyinUnit.jdField_a_of_type_JavaUtilList.add(localPinyinBaseUnit);
          paramInt += 1;
        }
      }
    }
    PinyinBaseUnit localPinyinBaseUnit = new PinyinBaseUnit();
    a(localPinyinBaseUnit, paramString, paramArrayOfString[0]);
    paramPinyinUnit.jdField_a_of_type_JavaUtilList.add(localPinyinBaseUnit);
    paramInt = 1;
    label129:
    int k;
    if (paramInt < j)
    {
      k = paramPinyinUnit.jdField_a_of_type_JavaUtilList.size();
      i = 0;
    }
    for (;;)
    {
      if ((i >= k) || (((PinyinBaseUnit)paramPinyinUnit.jdField_a_of_type_JavaUtilList.get(i)).b.equals(paramArrayOfString[paramInt])))
      {
        if (i == k)
        {
          localPinyinBaseUnit = new PinyinBaseUnit();
          a(localPinyinBaseUnit, paramString, paramArrayOfString[paramInt]);
          paramPinyinUnit.jdField_a_of_type_JavaUtilList.add(localPinyinBaseUnit);
        }
        paramInt += 1;
        break label129;
        break;
      }
      i += 1;
    }
  }
  
  public static void a(String paramString, List paramList)
  {
    if ((paramString == null) || (paramList == null)) {
      return;
    }
    String str = paramString.toLowerCase();
    int m = str.length();
    StringBuffer localStringBuffer = new StringBuffer();
    paramString = null;
    int j = 1;
    int k = -1;
    int i = 0;
    label40:
    char c;
    String[] arrayOfString;
    if (i < m)
    {
      c = str.charAt(i);
      arrayOfString = ChnToSpell.a(c);
      if (arrayOfString == null)
      {
        if (1 != j) {
          break label234;
        }
        paramString = new PinyinUnit();
        j = 0;
        localStringBuffer.delete(0, localStringBuffer.length());
        k = i;
      }
    }
    label105:
    label234:
    for (;;)
    {
      localStringBuffer.append(c);
      i += 1;
      break label40;
      if (j == 0)
      {
        a(paramList, paramString, false, localStringBuffer.toString(), new String[] { localStringBuffer.toString() }, k);
        localStringBuffer.delete(0, localStringBuffer.length());
        j = 1;
      }
      for (;;)
      {
        paramString = new PinyinUnit();
        a(paramList, paramString, true, String.valueOf(c), arrayOfString, i);
        k = i;
        break label105;
        if (j != 0) {
          break;
        }
        a(paramList, paramString, false, localStringBuffer.toString(), new String[] { localStringBuffer.toString() }, k);
        localStringBuffer.delete(0, localStringBuffer.length());
        return;
      }
    }
  }
  
  private static void a(List paramList, PinyinUnit paramPinyinUnit, boolean paramBoolean, String paramString, String[] paramArrayOfString, int paramInt)
  {
    if ((paramList == null) || (paramPinyinUnit == null) || (paramString == null) || (paramArrayOfString == null)) {
      return;
    }
    a(paramPinyinUnit, paramBoolean, paramString, paramArrayOfString, paramInt);
    paramList.add(paramPinyinUnit);
  }
  
  public static String b(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    do
    {
      do
      {
        return null;
        paramList = ((PinyinUnit)paramList.get(0)).jdField_a_of_type_JavaUtilList;
      } while ((paramList == null) || (paramList.size() <= 0));
      paramList = ((PinyinBaseUnit)paramList.get(0)).a;
    } while ((paramList == null) || (paramList.length() <= 0));
    return String.valueOf(paramList.charAt(0));
  }
  
  public static String c(List paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.delete(0, localStringBuffer.length());
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PinyinUnit localPinyinUnit = (PinyinUnit)paramList.next();
      if (localPinyinUnit.jdField_a_of_type_Boolean)
      {
        localStringBuffer.append(((PinyinBaseUnit)localPinyinUnit.jdField_a_of_type_JavaUtilList.get(0)).b).append(" ");
        localStringBuffer.append(((PinyinBaseUnit)localPinyinUnit.jdField_a_of_type_JavaUtilList.get(0)).a).append(" ");
      }
      else
      {
        localStringBuffer.append(((PinyinBaseUnit)localPinyinUnit.jdField_a_of_type_JavaUtilList.get(0)).a).append(" ");
      }
    }
    return localStringBuffer.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\t9search\T9Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */