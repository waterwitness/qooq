package com.tencent.mobileqq.text;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.GetChars;
import android.text.Layout.Alignment;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.view.View;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mtt.MttBrowerWrapper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.Patterns;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.lang.reflect.Array;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import uze;
import uzf;

public class QQText
  implements GetChars, Spannable, CharSequence, Cloneable
{
  public static final char a = '\n';
  public static final int a = 0;
  public static Spannable.Factory a;
  private static String jdField_a_of_type_JavaLangString;
  static final Pattern jdField_a_of_type_JavaUtilRegexPattern;
  public static final boolean a;
  public static final char b = 'ú';
  public static final int b = 1;
  private static String jdField_b_of_type_JavaLangString;
  public static final Pattern b;
  public static final boolean b;
  static final Object[] jdField_b_of_type_ArrayOfJavaLangObject;
  public static final char c = '\024';
  public static final int c = 2;
  static final Pattern c;
  public static final char d = '\r';
  public static final int d = 4;
  static final String d = "[emoji]";
  public static final Pattern d;
  public static final char e = 'þ';
  public static final int e = 8;
  public static final String e = "[小表情]";
  public static final char f = 'ý';
  public static final int f = 3;
  static final String f = "(\\+[0-9]+[\\-]*)?(\\([0-9]+\\)[\\-]*)?([0-9][0-9\\-][0-9\\-]+[0-9])";
  public static final int g = 5;
  static final String g = "((100)(00|10|11|50|60|86))|(11185)|(12110)|((123)(10|15|18|20|33|36|45|48|51|55|58|61|65|66|69|80|95|98))|((950)(00|01|03|05|06|08|09|10|11|13|15|16|18|19|22|28|29|30|33|50|51|52|53|55|56|57|58|59|61|63|66|70|71|77|78|80|88|90|95|98|99))|((951)(00|01|02|03|05|06|07|08|09|11|13|15|16|17|18|19|21|22|23|28|30|31|32|33|35|37|38|39|48|51|55|58|60|66|68|69|77|78|80|81|85|86|88|90|95|98|99))|((955)(00|01|02|05|08|09|10|11|12|15|16|18|19|22|28|33|55|56|58|59|61|65|66|67|68|69|77|80|85|86|88|89|90|91|95|96|98|99))|((957)(00|01|02|68|77|88|98|99))|((958)(03|08|10|11|15|16|21|22|25|26|27|28|29|30|32|38|39|55|56|59|65|66|68|82|87|88))|((959)(02|06|09|33|50|51|56|59|63|68|69|93|96|98|99))|((96011))|((961)(02|03|10|30|48|56|89|98))|(96315)|(96677)|(96678)|(96822)";
  public static final int h = 7;
  static String h;
  public static final int i = 6;
  static final String i = "\\d{6,16}";
  public static final int j = 13;
  public static final String j = "(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w{2,3}){1,3})";
  public static final int k = 32;
  protected static final String k;
  public static final int l = 10;
  public static final int m = 16;
  public static final int o = 0;
  public static final int p = 1;
  public static final int q = 2;
  private static final int r = 0;
  private static final int s = 1;
  private static final int t = 2;
  private static final int u = 3;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private int[] jdField_a_of_type_ArrayOfInt;
  public Object[] a;
  public String l;
  protected String m;
  public int n;
  private int v = -1;
  
  static
  {
    bool = NotVerifyClass.DO_VERIFY_CLASS;
    h = "((100)(00|10|11|50|60|86))|(11185)|(12110)|((123)(10|15|18|20|33|36|45|48|51|55|58|61|65|66|69|80|95|98))|((950)(00|01|03|05|06|08|09|10|11|13|15|16|18|19|22|28|29|30|33|50|51|52|53|55|56|57|58|59|61|63|66|70|71|77|78|80|88|90|95|98|99))|((951)(00|01|02|03|05|06|07|08|09|11|13|15|16|17|18|19|21|22|23|28|30|31|32|33|35|37|38|39|48|51|55|58|60|66|68|69|77|78|80|81|85|86|88|90|95|98|99))|((955)(00|01|02|05|08|09|10|11|12|15|16|18|19|22|28|33|55|56|58|59|61|65|66|67|68|69|77|80|85|86|88|89|90|91|95|96|98|99))|((957)(00|01|02|68|77|88|98|99))|((958)(03|08|10|11|15|16|21|22|25|26|27|28|29|30|32|38|39|55|56|59|65|66|68|82|87|88))|((959)(02|06|09|33|50|51|56|59|63|68|69|93|96|98|99))|((96011))|((961)(02|03|10|30|48|56|89|98))|(96315)|(96677)|(96678)|(96822)|(\\+[0-9]+[\\-]*)?(\\([0-9]+\\)[\\-]*)?([0-9][0-9\\-][0-9\\-]+[0-9])";
    k = Patterns.jdField_b_of_type_JavaUtilRegexPattern.pattern() + "|" + Patterns.c.pattern() + "|" + "(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w{2,3}){1,3})" + "|" + "\\d{6,16}" + "|" + h;
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile(k, 2);
    jdField_b_of_type_JavaUtilRegexPattern = Pattern.compile("\\d{6,16}");
    c = Pattern.compile("((100)(00|10|11|50|60|86))|(11185)|(12110)|((123)(10|15|18|20|33|36|45|48|51|55|58|61|65|66|69|80|95|98))|((950)(00|01|03|05|06|08|09|10|11|13|15|16|18|19|22|28|29|30|33|50|51|52|53|55|56|57|58|59|61|63|66|70|71|77|78|80|88|90|95|98|99))|((951)(00|01|02|03|05|06|07|08|09|11|13|15|16|17|18|19|21|22|23|28|30|31|32|33|35|37|38|39|48|51|55|58|60|66|68|69|77|78|80|81|85|86|88|90|95|98|99))|((955)(00|01|02|05|08|09|10|11|12|15|16|18|19|22|28|33|55|56|58|59|61|65|66|67|68|69|77|80|85|86|88|89|90|91|95|96|98|99))|((957)(00|01|02|68|77|88|98|99))|((958)(03|08|10|11|15|16|21|22|25|26|27|28|29|30|32|38|39|55|56|59|65|66|68|82|87|88))|((959)(02|06|09|33|50|51|56|59|63|68|69|93|96|98|99))|((96011))|((961)(02|03|10|30|48|56|89|98))|(96315)|(96677)|(96678)|(96822)");
    d = Pattern.compile(h);
    jdField_b_of_type_ArrayOfJavaLangObject = new Object[0];
    jdField_a_of_type_AndroidTextSpannable$Factory = new uze();
    try
    {
      StaticLayout.class.getDeclaredMethod("generate2", new Class[] { CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, Float.TYPE, Float.TYPE, Boolean.TYPE, Boolean.TYPE });
      bool = true;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        bool = false;
        continue;
        jdField_b_of_type_Boolean = false;
      }
    }
    if ((Build.MANUFACTURER.equals("motorola")) && (Build.VERSION.SDK_INT < 14))
    {
      jdField_b_of_type_Boolean = true;
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public QQText(CharSequence paramCharSequence, int paramInt)
  {
    this(paramCharSequence, paramInt, 32);
  }
  
  public QQText(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    this(paramCharSequence, 0, paramCharSequence.length(), paramInt1, paramInt2, -1);
  }
  
  public QQText(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected QQText(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    jdField_a_of_type_JavaLangString = BaseApplicationImpl.a().a().getAccount();
    String str;
    if (jdField_a_of_type_JavaLangString == null) {
      str = "";
    }
    for (;;)
    {
      jdField_a_of_type_JavaLangString = str;
      this.v = paramInt5;
      paramInt5 = a(3);
      try
      {
        this.jdField_a_of_type_ArrayOfJavaLangObject = new Object[paramInt5];
        this.jdField_a_of_type_ArrayOfInt = new int[paramInt5 * 3];
        paramInt4 = (int)(paramInt4 * BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density + 0.5F);
        if (paramCharSequence == null)
        {
          this.m = "";
          this.l = "";
          return;
          str = jdField_a_of_type_JavaLangString;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
        this.l = paramCharSequence.toString();
        this.m = this.l;
        if ((paramInt3 & 0x1) == 1) {
          break label161;
        }
      }
    }
    label161:
    Object localObject1;
    if ((paramInt3 & 0x6) > 0)
    {
      localObject1 = new StringBuilder(this.l);
      paramInt4 = a(0, ((StringBuilder)localObject1).length(), paramInt3, paramInt4, (StringBuilder)localObject1);
      this.m = ((StringBuilder)localObject1).toString();
      if (!jdField_a_of_type_Boolean) {
        this.l = this.m;
      }
      if (paramInt4 < 10) {}
    }
    for (paramInt4 = 1;; paramInt4 = 0)
    {
      if (paramInt4 != 0)
      {
        localObject1 = (QQText.EmotcationSpan[])getSpans(paramInt1, paramInt2, QQText.EmotcationSpan.class);
        if (localObject1 != null)
        {
          paramInt5 = localObject1.length;
          paramInt4 = 0;
          if (paramInt4 < paramInt5)
          {
            Object localObject2 = localObject1[paramInt4];
            if (((QQText.EmotcationSpan)localObject2).c == 1) {
              ((QQText.EmotcationSpan)localObject2).a &= 0x7FFFFFFF;
            }
            for (;;)
            {
              paramInt4 += 1;
              break;
              if (((QQText.EmotcationSpan)localObject2).c == 2) {
                ((QQText.SmallEmojiSpan)localObject2).jdField_a_of_type_Boolean = false;
              }
            }
          }
        }
      }
      if (((paramInt3 & 0x8) == 8) && (this.m != null) && (this.m.length() < 1000)) {
        a();
      }
      if (!(paramCharSequence instanceof Spanned)) {
        break;
      }
      paramCharSequence = (Spanned)paramCharSequence;
      localObject1 = paramCharSequence.getSpans(paramInt1, paramInt2, Object.class);
      paramInt3 = i1;
      while (paramInt3 < localObject1.length)
      {
        paramInt5 = paramCharSequence.getSpanStart(localObject1[paramInt3]);
        i1 = paramCharSequence.getSpanEnd(localObject1[paramInt3]);
        int i2 = paramCharSequence.getSpanFlags(localObject1[paramInt3]);
        paramInt4 = paramInt5;
        if (paramInt5 < paramInt1) {
          paramInt4 = paramInt1;
        }
        paramInt5 = i1;
        if (i1 > paramInt2) {
          paramInt5 = paramInt2;
        }
        setSpan(localObject1[paramInt3], paramInt4 - paramInt1, paramInt5 - paramInt1, i2);
        paramInt3 += 1;
      }
      break;
    }
  }
  
  public QQText(CharSequence paramCharSequence, int paramInt1, int paramInt2, MessageRecord paramMessageRecord)
  {
    this(paramCharSequence, 0, paramCharSequence.length(), paramInt1, paramInt2, -1);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
  
  private static int a(int paramInt)
  {
    int i2 = paramInt * 4;
    paramInt = 4;
    for (;;)
    {
      int i1 = i2;
      if (paramInt < 32)
      {
        if (i2 <= (1 << paramInt) - 12) {
          i1 = (1 << paramInt) - 12;
        }
      }
      else {
        return i1 / 4;
      }
      paramInt += 1;
    }
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, StringBuilder paramStringBuilder)
  {
    int i9 = paramStringBuilder.length();
    int i1 = 0;
    float f1 = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
    int i6 = (int)(22.0F * f1 + 0.5F);
    int i10 = (int)(f1 * 32.0F + 0.5F);
    int i2 = paramInt1;
    paramInt1 = i1;
    int i11;
    label79:
    int i3;
    label142:
    label209:
    label231:
    label478:
    label562:
    int i7;
    int i4;
    if (i2 < paramInt2)
    {
      i11 = paramStringBuilder.codePointAt(i2);
      boolean bool;
      if ((paramInt3 & 0x4) == 4)
      {
        bool = true;
        if (((paramInt3 & 0x6) <= 0) || (i11 != 20) || (i2 >= i9 - 1)) {
          break label562;
        }
        i3 = paramStringBuilder.charAt(i2 + 1);
        if (i3 >= EmotcationConstants.b) {
          break label231;
        }
        if (!jdField_a_of_type_Boolean) {
          break label209;
        }
        paramStringBuilder.replace(i2, i2 + 2, "##");
        i1 = i3;
        if (bool) {
          i1 = i3 | 0x80000000;
        }
        a(new QQText.EmotcationSpan(this, i1, paramInt4, 1), i2, i2 + 2, 33);
        i1 = i2 + 1;
        paramInt1 += 1;
      }
      for (;;)
      {
        i2 = i1 + 1;
        break;
        bool = false;
        break label79;
        if (i3 != 10) {
          break label142;
        }
        paramStringBuilder.setCharAt(i2 + 1, 'ú');
        break label142;
        if ((255 != i3) || (i2 + 4 >= i9)) {
          break label478;
        }
        char[] arrayOfChar = new char[4];
        arrayOfChar[0] = paramStringBuilder.charAt(i2 + 4);
        arrayOfChar[1] = paramStringBuilder.charAt(i2 + 3);
        arrayOfChar[2] = paramStringBuilder.charAt(i2 + 2);
        arrayOfChar[3] = paramStringBuilder.charAt(i2 + 1);
        i1 = 0;
        if (i1 < 3)
        {
          if (arrayOfChar[i1] == 'ú') {
            arrayOfChar[i1] = '\n';
          }
          for (;;)
          {
            i1 += 1;
            break;
            if (arrayOfChar[i1] == 'þ') {
              arrayOfChar[i1] = '\r';
            }
          }
        }
        a(new QQText.SmallEmojiSpan(this, arrayOfChar, paramInt4, bool), i2, i2 + 5, 33);
        i1 = 2;
        if (i1 < 5)
        {
          if (paramStringBuilder.charAt(i2 + i1) == '\n') {
            paramStringBuilder.setCharAt(i2 + i1, 'ú');
          }
          for (;;)
          {
            i1 += 1;
            break;
            if (paramStringBuilder.charAt(i2 + i1) == '\r') {
              paramStringBuilder.setCharAt(i2 + i1, 'þ');
            }
          }
        }
        i1 = i2 + 4;
        paramInt1 += 1;
      }
      if (i3 != 250) {
        break label1046;
      }
      if (jdField_a_of_type_Boolean) {
        paramStringBuilder.replace(i2, i2 + 2, "##");
      }
      if (bool) {}
      for (i1 = -2147483638;; i1 = 10)
      {
        a(new QQText.EmotcationSpan(this, i1, paramInt4, 1), i2, i2 + 2, 33);
        i1 = i2 + 1;
        paramInt1 += 1;
        break;
      }
      if ((paramInt3 & 0x1) != 1) {
        break label1046;
      }
      i3 = EmotcationConstants.a(i11);
      i1 = -1;
      i5 = 0;
      i7 = 0;
      if (i11 > 65535)
      {
        i4 = i7;
        if (i9 > i2 + 2)
        {
          i1 = paramStringBuilder.codePointAt(i2 + 2);
          i4 = i7;
        }
        label621:
        if (EmotcationConstants.a(i1)) {
          i5 = 1;
        }
        if ((i3 != -1) && (i5 == 0)) {
          break label1053;
        }
        i5 = EmotcationConstants.a(i11, i1);
        if (i5 != -1) {
          break label893;
        }
      }
    }
    label658:
    label713:
    label759:
    label770:
    label893:
    label927:
    label1043:
    label1046:
    label1053:
    for (int i5 = 1;; i5 = 0)
    {
      if (i3 != -1)
      {
        if (i5 != 0) {
          if ((i11 > 65535) && (i9 >= i2 + 2))
          {
            if (jdField_a_of_type_Boolean) {
              paramStringBuilder.replace(i2, i2 + 2, "##");
            }
            i5 = 2;
            if ((i1 <= 65535) || (i9 < i2 + 2)) {
              break label927;
            }
            if (jdField_a_of_type_Boolean) {
              paramStringBuilder.replace(i2 + 2, i2 + 4, "##");
            }
            i1 = i5 + 2;
            if (i4 == 0) {
              break label1043;
            }
            i1 += 1;
          }
        }
        for (;;)
        {
          if (paramInt4 == i10) {}
          for (i4 = i6;; i4 = paramInt4)
          {
            a(new QQText.EmotcationSpan(this, i3, i4, 0), i2, i2 + i1, 33);
            i1 = i1 - 1 + i2;
            break;
            i4 = i7;
            if (i9 <= i2 + 1) {
              break label621;
            }
            int i8 = paramStringBuilder.codePointAt(i2 + 1);
            i4 = i7;
            i1 = i8;
            if (i8 != 65039) {
              break label621;
            }
            i4 = i7;
            i1 = i8;
            if (i9 <= i2 + 2) {
              break label621;
            }
            i1 = paramStringBuilder.codePointAt(i2 + 2);
            i4 = 1;
            break label621;
            i3 = i5;
            break label658;
            if (jdField_a_of_type_Boolean) {
              paramStringBuilder.replace(i2, i2 + 1, "#");
            }
            i5 = 1;
            break label713;
            if (jdField_a_of_type_Boolean) {
              paramStringBuilder.replace(i2 + 2, i2 + 3, "#");
            }
            i1 = i5 + 1;
            break label759;
            if ((i11 > 65535) && (i9 >= i2 + 2))
            {
              if (jdField_a_of_type_Boolean) {
                paramStringBuilder.replace(i2, i2 + 2, "##");
              }
              i1 = 2;
              break label770;
            }
            if (jdField_a_of_type_Boolean) {
              paramStringBuilder.replace(i2, i2 + 1, "#");
            }
            i1 = 1;
            break label770;
          }
          if (paramInt1 > 0) {}
          return paramInt1;
        }
      }
      i1 = i2;
      break;
    }
  }
  
  private static String a(int paramInt1, int paramInt2)
  {
    return "(" + paramInt1 + " ... " + paramInt2 + ")";
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    ActionSheet localActionSheet = ActionSheet.a(paramContext);
    localActionSheet.a(2131369290, 1);
    localActionSheet.a(2131369291, 1);
    if (paramBoolean)
    {
      localActionSheet.a(2131367277, 1);
      localActionSheet.a(2131367291, 1);
    }
    localActionSheet.d(2131367262);
    if (paramBoolean) {
      localActionSheet.a(String.format(paramContext.getString(2131369306), new Object[] { paramString }));
    }
    for (;;)
    {
      localActionSheet.a(new uzf(paramString, paramContext, localActionSheet));
      localActionSheet.show();
      return;
      localActionSheet.a(String.format(paramContext.getString(2131369307), new Object[] { paramString }));
    }
  }
  
  private void a(Object paramObject, int paramInt1, int paramInt2)
  {
    SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])getSpans(paramInt1, paramInt2, SpanWatcher.class);
    int i2 = arrayOfSpanWatcher.length;
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfSpanWatcher[i1].onSpanAdded(this, paramObject, paramInt1, paramInt2);
      i1 += 1;
    }
  }
  
  private void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])getSpans(Math.min(paramInt1, paramInt3), Math.max(paramInt2, paramInt4), SpanWatcher.class);
    int i2 = arrayOfSpanWatcher.length;
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfSpanWatcher[i1].onSpanChanged(this, paramObject, paramInt1, paramInt2, paramInt3, paramInt4);
      i1 += 1;
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 < paramInt1) {
      throw new IndexOutOfBoundsException(paramString + " " + a(paramInt1, paramInt2) + " has end before start");
    }
    int i1 = length();
    if ((paramInt1 > i1) || (paramInt2 > i1)) {
      throw new IndexOutOfBoundsException(paramString + " " + a(paramInt1, paramInt2) + " ends beyond length " + i1);
    }
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      throw new IndexOutOfBoundsException(paramString + " " + a(paramInt1, paramInt2) + " starts before 0");
    }
  }
  
  private static final boolean a()
  {
    StackTraceElement localStackTraceElement = new Exception().getStackTrace()[2];
    return (("android.text.StaticLayout".equals(localStackTraceElement.getClassName())) && ("generate2".equals(localStackTraceElement.getMethodName()))) || (("android.text.Layout".equals(localStackTraceElement.getClassName())) && ("expandTab".equals(localStackTraceElement.getMethodName())));
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < paramString.length())
      {
        i2 = paramString.codePointAt(i1);
        if (EmotcationConstants.jdField_a_of_type_AndroidUtilSparseIntArray.get(i2, -1) < 0) {
          break label43;
        }
      }
      label43:
      for (int i2 = 1; i2 != 0; i2 = 0)
      {
        bool1 = true;
        return bool1;
      }
      i1 += 1;
    }
  }
  
  private void b(Object paramObject, int paramInt1, int paramInt2)
  {
    SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])getSpans(paramInt1, paramInt2, SpanWatcher.class);
    int i2 = arrayOfSpanWatcher.length;
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfSpanWatcher[i1].onSpanRemoved(this, paramObject, paramInt1, paramInt2);
      i1 += 1;
    }
  }
  
  private static void b(String paramString1, String paramString2)
  {
    if (jdField_b_of_type_JavaLangString == null) {
      return;
    }
    try
    {
      QQAppInterface localQQAppInterface1 = (QQAppInterface)BaseApplicationImpl.a().getAppRuntime(jdField_a_of_type_JavaLangString);
      if (paramString2 != null)
      {
        ReportController.b(localQQAppInterface1, "P_CliOper", "Grp_join", "", "send", "Clk_url", 0, 0, jdField_b_of_type_JavaLangString, "" + paramString1, "" + paramString2, "");
        return;
      }
    }
    catch (ClassCastException localClassCastException)
    {
      QQAppInterface localQQAppInterface2;
      for (;;)
      {
        localClassCastException.printStackTrace();
        localQQAppInterface2 = null;
      }
      ReportController.b(localQQAppInterface2, "P_CliOper", "Grp_join", "", "send", "Clk_item", 0, 0, jdField_b_of_type_JavaLangString, "" + paramString1, "" + paramString1, "");
      return;
    }
    catch (AccountNotMatchException paramString1) {}
  }
  
  public static boolean b(String paramString)
  {
    boolean bool2 = false;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < paramString.length())
      {
        if (20 == paramString.codePointAt(i1)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  SpannableString a()
  {
    SpannableString localSpannableString = new SpannableString(this.m);
    TextUtils.copySpansFrom(this, 0, length(), Object.class, localSpannableString, 0);
    return localSpannableString;
  }
  
  public QQText a(String paramString, boolean paramBoolean, int... paramVarArgs)
  {
    QQText localQQText = new QQText("", 0);
    localQQText.v = this.v;
    localQQText.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    localQQText.n = this.n;
    localQQText.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_ArrayOfInt.length];
    System.arraycopy(this.jdField_a_of_type_ArrayOfInt, 0, localQQText.jdField_a_of_type_ArrayOfInt, 0, this.jdField_a_of_type_ArrayOfInt.length);
    localQQText.jdField_a_of_type_ArrayOfJavaLangObject = new Object[this.jdField_a_of_type_ArrayOfJavaLangObject.length];
    System.arraycopy(this.jdField_a_of_type_ArrayOfJavaLangObject, 0, localQQText.jdField_a_of_type_ArrayOfJavaLangObject, 0, this.jdField_a_of_type_ArrayOfJavaLangObject.length);
    int i1;
    int i2;
    if (paramVarArgs.length >= 2)
    {
      i1 = paramVarArgs[0];
      i2 = (int)(paramVarArgs[1] * BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density + 0.5F);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        paramVarArgs = new StringBuilder().append(paramString).append(this.m);
        int i4 = paramString.length();
        int i3 = 0;
        while (i3 < localQQText.jdField_a_of_type_ArrayOfJavaLangObject.length)
        {
          this.jdField_a_of_type_ArrayOfInt[(i3 * 3 + 0)] += i4;
          this.jdField_a_of_type_ArrayOfInt[(i3 * 3 + 1)] += i4;
          i3 += 1;
        }
        if (i1 != 0) {
          localQQText.a(0, paramString.length(), i1, i2, paramVarArgs);
        }
        localQQText.l = (paramString + this.l);
        localQQText.m = paramVarArgs.toString();
        return localQQText;
      }
      paramVarArgs = new StringBuilder().append(paramString).append(this.m);
      if (i1 != 0) {
        localQQText.a(this.m.length(), this.m.length() + paramString.length(), i1, i2, paramVarArgs);
      }
      this.l += paramString;
      localQQText.m = paramVarArgs.toString();
      return localQQText;
      i2 = 0;
      i1 = 0;
    }
  }
  
  public String a()
  {
    StringBuffer localStringBuffer = new StringBuffer(this.m);
    int i4 = "[emoji]".length();
    int i2 = 0;
    int i3 = 0;
    if (i2 < this.n)
    {
      Object localObject = this.jdField_a_of_type_ArrayOfJavaLangObject[i2];
      int i1 = i3;
      int i5;
      if ((localObject instanceof QQText.EmotcationSpan))
      {
        i1 = this.jdField_a_of_type_ArrayOfInt[(i2 * 3 + 0)];
        i5 = this.jdField_a_of_type_ArrayOfInt[(i2 * 3 + 1)];
        localObject = (QQText.EmotcationSpan)localObject;
        switch (((QQText.EmotcationSpan)localObject).c)
        {
        default: 
          i1 = i3;
        }
      }
      for (;;)
      {
        i2 += 1;
        i3 = i1;
        break;
        localStringBuffer.replace(i1 + i3, i5 + i3, "[emoji]");
        i1 = i3 + (i4 - (i5 - i1));
        continue;
        localObject = ((QQText.EmotcationSpan)localObject).a();
        localStringBuffer.replace(i1 + i3, i5 + i3, (String)localObject);
        i1 = i3 + (((String)localObject).length() - (i5 - i1));
        continue;
        localObject = EmotcationConstants.jdField_a_of_type_ArrayOfJavaLangString[(localObject.a & 0x7FFFFFFF)];
        localStringBuffer.replace(i1 + i3, i5 + i3, (String)localObject);
        i1 = i3 + (((String)localObject).length() - (i5 - i1));
      }
    }
    return localStringBuffer.toString();
  }
  
  public void a()
  {
    Matcher localMatcher1 = jdField_a_of_type_JavaUtilRegexPattern.matcher(this.m);
    while (localMatcher1.find())
    {
      int i1 = localMatcher1.start();
      int i2 = localMatcher1.end();
      String str = this.m.substring(i1, i2);
      if (QLog.isColorLevel()) {
        QLog.d("LinkSpan", 2, "isfind1====s=" + i1 + "e=" + i2 + "findStr=" + this.m.substring(i1, i2));
      }
      Matcher localMatcher2 = c.matcher(str);
      if ((i2 - i1 != 5) || (localMatcher2.find())) {
        if (Patterns.jdField_b_of_type_JavaUtilRegexPattern.matcher(str).find())
        {
          a(new QQText.LinkSpan(this, str), i1, i2, 33);
        }
        else
        {
          if (!Patterns.c.matcher(str).find())
          {
            if ((i2 - i1 < 5) || (i2 - i1 > 16))
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("LinkSpan", 2, "text less than 5 or more than 16");
              continue;
            }
            char c1;
            if (i1 > 0)
            {
              c1 = this.m.charAt(i1 - 1);
              if (QLog.isColorLevel()) {
                QLog.d("LinkSpan", 2, "isfind====c_pre" + c1);
              }
              if (a(c1)) {
                continue;
              }
            }
            if (i2 < this.m.length())
            {
              c1 = this.m.charAt(i2);
              if (QLog.isColorLevel()) {
                QLog.d("LinkSpan", 2, "isfind====last" + c1);
              }
              if (a(c1)) {
                continue;
              }
            }
          }
          a(new QQText.LinkSpan(this, str), i1, i2, 33);
        }
      }
    }
  }
  
  protected void a(View paramView, String paramString)
  {
    String str = null;
    int i1 = paramString.lastIndexOf("#");
    if (i1 > 0) {
      str = paramString.substring(i1);
    }
    paramString = URLUtil.guessUrl(paramString);
    if (str != null) {
      paramString = paramString + str;
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", "0X80061B1", "0X80061B1", 0, 0, "", "", "", "");
      MttBrowerWrapper.a(paramView.getContext(), paramString, true, true, true, false, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      return;
    }
  }
  
  protected void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.n + 1 >= this.jdField_a_of_type_ArrayOfJavaLangObject.length)
    {
      int i1 = a(this.n + 1);
      Object[] arrayOfObject = new Object[i1];
      int[] arrayOfInt = new int[i1 * 3];
      System.arraycopy(this.jdField_a_of_type_ArrayOfJavaLangObject, 0, arrayOfObject, 0, this.n);
      System.arraycopy(this.jdField_a_of_type_ArrayOfInt, 0, arrayOfInt, 0, this.n * 3);
      this.jdField_a_of_type_ArrayOfJavaLangObject = arrayOfObject;
      this.jdField_a_of_type_ArrayOfInt = arrayOfInt;
    }
    this.jdField_a_of_type_ArrayOfJavaLangObject[this.n] = paramObject;
    this.jdField_a_of_type_ArrayOfInt[(this.n * 3 + 0)] = paramInt1;
    this.jdField_a_of_type_ArrayOfInt[(this.n * 3 + 1)] = paramInt2;
    this.jdField_a_of_type_ArrayOfInt[(this.n * 3 + 2)] = paramInt3;
    this.n += 1;
  }
  
  public boolean a(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }
  
  public String b()
  {
    char[] arrayOfChar = this.l.toCharArray();
    int i3 = this.l.length() - 1;
    int i1 = 0;
    while ((i1 <= i3) && (arrayOfChar[i1] <= ' ') && (arrayOfChar[i1] != '\024')) {
      i1 += 1;
    }
    for (;;)
    {
      int i2;
      if ((i2 >= i1) && (arrayOfChar[i2] <= ' ') && ((i2 == 0) || (arrayOfChar[(i2 - 1)] != '\024')))
      {
        i2 -= 1;
      }
      else
      {
        if ((i1 == 0) && (i2 == i3)) {
          return this.l;
        }
        return this.l.substring(i1, i2 + 1);
        i2 = i3;
      }
    }
  }
  
  public final char charAt(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > length())) {
      return '\000';
    }
    return this.m.charAt(paramInt);
  }
  
  public Object clone()
  {
    QQText localQQText = (QQText)super.clone();
    localQQText.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_ArrayOfInt.length];
    System.arraycopy(this.jdField_a_of_type_ArrayOfInt, 0, localQQText.jdField_a_of_type_ArrayOfInt, 0, this.jdField_a_of_type_ArrayOfInt.length);
    localQQText.jdField_a_of_type_ArrayOfJavaLangObject = new Object[this.jdField_a_of_type_ArrayOfJavaLangObject.length];
    System.arraycopy(this.jdField_a_of_type_ArrayOfJavaLangObject, 0, localQQText.jdField_a_of_type_ArrayOfJavaLangObject, 0, this.jdField_a_of_type_ArrayOfJavaLangObject.length);
    return localQQText;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof QQText)) {
      return this.l.equals(((QQText)paramObject).l);
    }
    return false;
  }
  
  public final void getChars(int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3)
  {
    int i1 = paramInt1;
    if (paramInt1 < 0) {
      i1 = 0;
    }
    int i2 = length();
    paramInt1 = paramInt2;
    if (paramInt2 > i2) {
      paramInt1 = i2;
    }
    this.m.getChars(i1, paramInt1, paramArrayOfChar, paramInt3);
  }
  
  public int getSpanEnd(Object paramObject)
  {
    int i1 = this.n;
    Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    i1 -= 1;
    while (i1 >= 0)
    {
      if (arrayOfObject[i1] == paramObject) {
        return arrayOfInt[(i1 * 3 + 1)];
      }
      i1 -= 1;
    }
    return -1;
  }
  
  public int getSpanFlags(Object paramObject)
  {
    int i1 = this.n;
    Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    i1 -= 1;
    while (i1 >= 0)
    {
      if (arrayOfObject[i1] == paramObject) {
        return arrayOfInt[(i1 * 3 + 2)];
      }
      i1 -= 1;
    }
    return 0;
  }
  
  public int getSpanStart(Object paramObject)
  {
    int i1 = this.n;
    Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    i1 -= 1;
    while (i1 >= 0)
    {
      if (arrayOfObject[i1] == paramObject) {
        return arrayOfInt[(i1 * 3 + 0)];
      }
      i1 -= 1;
    }
    return -1;
  }
  
  public Object[] getSpans(int paramInt1, int paramInt2, Class paramClass)
  {
    int i4 = this.n;
    Object[] arrayOfObject2 = this.jdField_a_of_type_ArrayOfJavaLangObject;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    Object localObject = null;
    int i2 = 0;
    Object[] arrayOfObject1 = null;
    int i1 = 0;
    if (i2 < i4)
    {
      if ((paramClass != null) && (!paramClass.isInstance(arrayOfObject2[i2]))) {}
      for (;;)
      {
        i2 += 1;
        break;
        int i3 = arrayOfInt[(i2 * 3 + 0)];
        int i5 = arrayOfInt[(i2 * 3 + 1)];
        if ((i3 <= paramInt2) && (i5 >= paramInt1) && ((i3 == i5) || (paramInt1 == paramInt2) || ((i3 != paramInt2) && (i5 != paramInt1)))) {
          if (i1 == 0)
          {
            localObject = arrayOfObject2[i2];
            i1 += 1;
          }
          else
          {
            if (i1 == 1)
            {
              arrayOfObject1 = (Object[])Array.newInstance(paramClass, i4 - i2 + 1);
              arrayOfObject1[0] = localObject;
            }
            i5 = 0xFF0000 & arrayOfInt[(i2 * 3 + 2)];
            if (i5 != 0)
            {
              i3 = 0;
              for (;;)
              {
                if ((i3 >= i1) || (i5 > (getSpanFlags(arrayOfObject1[i3]) & 0xFF0000)))
                {
                  System.arraycopy(arrayOfObject1, i3, arrayOfObject1, i3 + 1, i1 - i3);
                  arrayOfObject1[i3] = arrayOfObject2[i2];
                  i1 += 1;
                  break;
                }
                i3 += 1;
              }
            }
            arrayOfObject1[i1] = arrayOfObject2[i2];
            i1 += 1;
          }
        }
      }
    }
    if (i1 == 0) {
      return (Object[])Array.newInstance(paramClass, 0);
    }
    if (i1 == 1)
    {
      arrayOfObject1 = (Object[])Array.newInstance(paramClass, 1);
      if (arrayOfObject1 == null) {
        return (Object[])Array.newInstance(paramClass, 0);
      }
      arrayOfObject1[0] = localObject;
      return (Object[])arrayOfObject1;
    }
    if (i1 == arrayOfObject1.length) {
      return (Object[])arrayOfObject1;
    }
    paramClass = (Object[])Array.newInstance(paramClass, i1);
    System.arraycopy(arrayOfObject1, 0, paramClass, 0, i1);
    return (Object[])paramClass;
  }
  
  public final int length()
  {
    return this.m.length();
  }
  
  public int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    int i4 = this.n;
    Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    Class localClass = paramClass;
    if (paramClass == null) {
      localClass = Object.class;
    }
    int i1 = 0;
    int i2;
    if (i1 < i4)
    {
      int i3 = arrayOfInt[(i1 * 3 + 0)];
      i2 = arrayOfInt[(i1 * 3 + 1)];
      if ((i3 <= paramInt1) || (i3 >= paramInt2) || (!localClass.isInstance(arrayOfObject[i1]))) {
        break label131;
      }
      paramInt2 = i3;
    }
    label131:
    for (;;)
    {
      if ((i2 > paramInt1) && (i2 < paramInt2) && (localClass.isInstance(arrayOfObject[i1]))) {
        paramInt2 = i2;
      }
      for (;;)
      {
        i1 += 1;
        break;
        return paramInt2;
      }
    }
  }
  
  public void removeSpan(Object paramObject)
  {
    int i2 = this.n;
    Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    int i1 = i2 - 1;
    for (;;)
    {
      if (i1 >= 0)
      {
        if (arrayOfObject[i1] == paramObject)
        {
          int i3 = arrayOfInt[(i1 * 3 + 0)];
          int i4 = arrayOfInt[(i1 * 3 + 1)];
          i2 -= i1 + 1;
          System.arraycopy(arrayOfObject, i1 + 1, arrayOfObject, i1, i2);
          System.arraycopy(arrayOfInt, (i1 + 1) * 3, arrayOfInt, i1 * 3, i2 * 3);
          this.n -= 1;
          b(paramObject, i3, i4);
        }
      }
      else {
        return;
      }
      i1 -= 1;
    }
  }
  
  public void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    a("setSpan", paramInt1, paramInt2);
    if ((paramInt3 & 0x33) == 51)
    {
      char c1;
      if ((paramInt1 != 0) && (paramInt1 != length()))
      {
        c1 = charAt(paramInt1 - 1);
        if (c1 != '\n') {
          throw new RuntimeException("PARAGRAPH span must start at paragraph boundary (" + paramInt1 + " follows " + c1 + ")");
        }
      }
      if ((paramInt2 != 0) && (paramInt2 != length()))
      {
        c1 = charAt(paramInt2 - 1);
        if (c1 != '\n') {
          throw new RuntimeException("PARAGRAPH span must end at paragraph boundary (" + paramInt2 + " follows " + c1 + ")");
        }
      }
    }
    int i2 = this.n;
    Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    int i1 = 0;
    if (i1 < i2) {
      if (arrayOfObject[i1] == paramObject)
      {
        i2 = arrayOfInt[(i1 * 3 + 0)];
        int i3 = arrayOfInt[(i1 * 3 + 1)];
        arrayOfInt[(i1 * 3 + 0)] = paramInt1;
        arrayOfInt[(i1 * 3 + 1)] = paramInt2;
        arrayOfInt[(i1 * 3 + 2)] = paramInt3;
        a(paramObject, i2, i3, paramInt1, paramInt2);
      }
    }
    do
    {
      return;
      i1 += 1;
      break;
      if (this.n + 1 >= this.jdField_a_of_type_ArrayOfJavaLangObject.length)
      {
        i1 = a(this.n + 1);
        arrayOfObject = new Object[i1];
        arrayOfInt = new int[i1 * 3];
        System.arraycopy(this.jdField_a_of_type_ArrayOfJavaLangObject, 0, arrayOfObject, 0, this.n);
        System.arraycopy(this.jdField_a_of_type_ArrayOfInt, 0, arrayOfInt, 0, this.n * 3);
        this.jdField_a_of_type_ArrayOfJavaLangObject = arrayOfObject;
        this.jdField_a_of_type_ArrayOfInt = arrayOfInt;
      }
      this.jdField_a_of_type_ArrayOfJavaLangObject[this.n] = paramObject;
      this.jdField_a_of_type_ArrayOfInt[(this.n * 3 + 0)] = paramInt1;
      this.jdField_a_of_type_ArrayOfInt[(this.n * 3 + 1)] = paramInt2;
      this.jdField_a_of_type_ArrayOfInt[(this.n * 3 + 2)] = paramInt3;
      this.n += 1;
    } while (!(this instanceof Spannable));
    a(paramObject, paramInt1, paramInt2);
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    int i1 = paramInt1;
    if (paramInt1 < 0) {
      i1 = 0;
    }
    int i2 = length();
    paramInt1 = paramInt2;
    if (paramInt2 > i2) {
      paramInt1 = i2;
    }
    if ((jdField_a_of_type_Boolean) && (a())) {
      return this.m.subSequence(i1, paramInt1);
    }
    return new QQText(this, i1, paramInt1);
  }
  
  public String toString()
  {
    if ((jdField_a_of_type_Boolean) && (a())) {
      return this.m;
    }
    return this.l;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\text\QQText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */