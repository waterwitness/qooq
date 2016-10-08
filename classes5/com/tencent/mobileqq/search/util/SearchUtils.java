package com.tencent.mobileqq.search.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil.PublicAccountConfigFolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.activity.GroupSearchActivity;
import com.tencent.mobileqq.search.model.ContactSearchModelDiscussion;
import com.tencent.mobileqq.search.model.ContactSearchModelDiscussionMember;
import com.tencent.mobileqq.search.model.ContactSearchModelPhoneContact;
import com.tencent.mobileqq.search.model.ContactSearchModelRecentUser;
import com.tencent.mobileqq.search.model.ContactSearchModelTroop;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.search.model.IFaceModel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.ChnSpelling;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import und;
import une;

public class SearchUtils
{
  public static final int a = 10;
  public static long a = 0L;
  public static Paint a;
  public static boolean a = false;
  public static char[] a;
  public static final int b = 6;
  public static boolean b = false;
  public static final int c = 0;
  public static final int d = 4;
  public static int e;
  public static int f;
  private static int g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Long = 0L;
    e = 11;
    jdField_a_of_type_ArrayOfChar = new char[] { 44, 46, 8230, -244, 12290, -225, -255, -162, 35, -230, 12289, 8220, 8221, 8216, 8217, -248, -247, 45, 8212, -229, 64, 64, 35, 215, 37, 37, 46, 183, 47, 92, 12298, 12299, 12304, 12305, 60, 62 };
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 80000000: 
      return 90;
    case 80000001: 
      return 80;
    }
    return 70;
  }
  
  private static long a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l2 = Long.MIN_VALUE;
    long l1 = l2;
    if (paramInt1 >= 0)
    {
      if (paramInt2 != paramInt3) {
        break label35;
      }
      if (!paramBoolean2) {
        break label31;
      }
      l1 = IContactSearchable.u;
    }
    label31:
    label35:
    do
    {
      return l1;
      return IContactSearchable.s;
      if (paramInt1 == 0)
      {
        if (paramBoolean2) {
          return IContactSearchable.u;
        }
        return IContactSearchable.t;
      }
      l1 = l2;
    } while (paramBoolean1);
    return IContactSearchable.u;
  }
  
  private static long a(String paramString, ChnToSpell.ChnSpelling paramChnSpelling, boolean paramBoolean)
  {
    paramString = a(paramChnSpelling, paramString);
    return a(paramString[0], paramString[1], paramChnSpelling.jdField_a_of_type_JavaUtilList.size(), false, paramBoolean);
  }
  
  public static long a(String paramString1, String paramString2, long paramLong)
  {
    return a(paramString1, paramString2, paramLong, true, false, true);
  }
  
  public static long a(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    return a(paramString1, paramString2, paramLong, paramBoolean, false, false);
  }
  
  public static long a(String paramString1, String paramString2, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 1;
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {}
    long l;
    label123:
    do
    {
      for (;;)
      {
        return Long.MIN_VALUE;
        paramString1 = paramString1.toLowerCase();
        paramString2 = paramString2.toLowerCase();
        l = a(paramString1, paramString2, paramBoolean2, paramBoolean3);
        if (l != Long.MIN_VALUE) {
          return IContactSearchable.p + l + paramLong;
        }
        if (paramBoolean1)
        {
          ChnToSpell.ChnSpelling localChnSpelling = ChnToSpell.a(paramString2, 1);
          if (!paramString2.equals(localChnSpelling.jdField_a_of_type_JavaLangString)) {}
          while (i != 0)
          {
            l = a(paramString1, localChnSpelling, paramBoolean3);
            if (l == Long.MIN_VALUE) {
              break label123;
            }
            return IContactSearchable.q + l + paramLong;
            i = 0;
          }
        }
      }
      l = a(paramString1, ChnToSpell.a(paramString2, 2), paramBoolean3);
    } while (l == Long.MIN_VALUE);
    return IContactSearchable.q + l + paramLong;
  }
  
  public static long a(String paramString1, String paramString2, ChnToSpell.ChnSpelling paramChnSpelling1, ChnToSpell.ChnSpelling paramChnSpelling2, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {}
    long l;
    label116:
    do
    {
      for (;;)
      {
        return Long.MIN_VALUE;
        paramString1 = paramString1.toLowerCase();
        paramString2 = paramString2.toLowerCase();
        l = a(paramString1, paramString2, false, false);
        if (l != Long.MIN_VALUE) {
          return IContactSearchable.p + l + paramLong;
        }
        if ((paramChnSpelling1 != null) && (paramChnSpelling2 != null))
        {
          if (!paramString2.equals(paramChnSpelling1.jdField_a_of_type_JavaLangString)) {}
          for (int i = 1; i != 0; i = 0)
          {
            l = a(paramString1, paramChnSpelling1, false);
            if (l == Long.MIN_VALUE) {
              break label116;
            }
            return IContactSearchable.q + l + paramLong;
          }
        }
      }
      l = a(paramString1, paramChnSpelling2, false);
    } while (l == Long.MIN_VALUE);
    return IContactSearchable.q + l + paramLong;
  }
  
  private static long a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramString2.indexOf(paramString1), paramString1.length(), paramString2.length(), paramBoolean1, paramBoolean2);
  }
  
  public static Drawable a(Bitmap paramBitmap)
  {
    Drawable localDrawable = BaseApplicationImpl.a.getResources().getDrawable(2130838594);
    if ((localDrawable instanceof SkinnableBitmapDrawable)) {
      ((SkinnableBitmapDrawable)localDrawable).setGravity(81);
    }
    if ((localDrawable instanceof BitmapDrawable)) {
      ((BitmapDrawable)localDrawable).setGravity(81);
    }
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    return new LayerDrawable(new Drawable[] { new BitmapDrawable(paramBitmap), localDrawable });
  }
  
  public static Drawable a(FaceDecoder paramFaceDecoder, IFaceModel paramIFaceModel)
  {
    return a(paramFaceDecoder, paramIFaceModel.a(), paramIFaceModel.a());
  }
  
  public static Drawable a(FaceDecoder paramFaceDecoder, String paramString, int paramInt)
  {
    if (paramInt == 103) {}
    for (int i = 1;; i = paramInt)
    {
      Bitmap localBitmap = paramFaceDecoder.a(i, paramString);
      if (localBitmap != null)
      {
        if (paramInt == 103) {
          return a(localBitmap);
        }
        return new BitmapDrawable(localBitmap);
      }
      if (!paramFaceDecoder.b()) {
        paramFaceDecoder.a(paramString, i, true, (byte)1);
      }
      if (paramInt == 1) {
        return ImageUtil.b();
      }
      if (paramInt == 101) {
        return ImageUtil.d();
      }
      if (paramInt == 4) {
        return ImageUtil.c();
      }
      if (paramInt == 11) {
        return new BitmapDrawable(ImageUtil.b());
      }
      if (paramInt == 102) {
        return BaseApplicationImpl.a.getResources().getDrawable(2130840319);
      }
      if (paramInt == 106) {
        return BaseApplicationImpl.a.getResources().getDrawable(2130841642);
      }
      if (paramInt == 105)
      {
        paramFaceDecoder = PublicAccountConfigUtil.a((QQAppInterface)BaseApplicationImpl.a.a(), com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext(), 1);
        if ((paramFaceDecoder != null) && (paramFaceDecoder.a() != null)) {
          return paramFaceDecoder.a();
        }
        return PublicAccountConfigUtil.a(BaseApplicationImpl.a, 1);
      }
      if (String.valueOf(9999L).equals(paramString)) {
        return BaseApplicationImpl.a.getResources().getDrawable(2130838599);
      }
      if (String.valueOf(9994L).equals(paramString)) {
        return BaseApplicationImpl.a.getResources().getDrawable(2130838607);
      }
      if (String.valueOf(9992L).equals(paramString)) {
        return BaseApplicationImpl.a.getResources().getDrawable(2130838605);
      }
      if (AppConstants.bb.equals(paramString)) {
        return ServiceAccountFolderManager.a();
      }
      if (String.valueOf(9980L).equals(paramString)) {
        return BaseApplicationImpl.a.getResources().getDrawable(2130838606);
      }
      if (String.valueOf(9973L).equals(paramString)) {
        return BaseApplicationImpl.a.getResources().getDrawable(2130840519);
      }
      if (paramInt == 9889987) {
        return BaseApplicationImpl.a.getResources().getDrawable(2130839446);
      }
      if (paramInt == 108)
      {
        paramFaceDecoder = BaseApplicationImpl.a.a();
        if (paramFaceDecoder != null) {
          return ((BlessManager)paramFaceDecoder.getManager(137)).a();
        }
      }
      else
      {
        if (String.valueOf(AppConstants.an).equals(paramString)) {
          return BaseApplicationImpl.a.getResources().getDrawable(2130838598);
        }
        if (paramInt == 110)
        {
          paramFaceDecoder = PublicAccountConfigUtil.a((QQAppInterface)BaseApplicationImpl.a.a(), BaseApplicationImpl.a, 2);
          if ((paramFaceDecoder != null) && (paramFaceDecoder.a() != null)) {
            return paramFaceDecoder.a().getConstantState().newDrawable();
          }
          return PublicAccountConfigUtil.a(BaseApplicationImpl.a, 2).getConstantState().newDrawable();
        }
        if (paramInt == 111)
        {
          paramFaceDecoder = PublicAccountConfigUtil.a((QQAppInterface)BaseApplicationImpl.a.a(), BaseApplicationImpl.a, 3);
          if ((paramFaceDecoder != null) && (paramFaceDecoder.a() != null)) {
            return paramFaceDecoder.a().getConstantState().newDrawable();
          }
          return PublicAccountConfigUtil.a(BaseApplicationImpl.a, 3).getConstantState().newDrawable();
        }
        if (AppConstants.bc.equals(paramString)) {
          return BaseApplicationImpl.a.getResources().getDrawable(2130840132);
        }
      }
      return ImageUtil.b();
    }
  }
  
  public static CharSequence a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    int n = 0;
    if (jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      jdField_a_of_type_AndroidGraphicsPaint = ((TextView)LayoutInflater.from(paramQQAppInterface.a()).inflate(2130904946, null).findViewById(2131297123)).getPaint();
      if (g == 0) {
        g = paramQQAppInterface.a().getResources().getDimensionPixelOffset(2131493523);
      }
    }
    String str = paramString1.toLowerCase();
    int m = str.indexOf(paramString2);
    int k = paramString2.length();
    int j = k;
    int i = m;
    paramQQAppInterface = paramString2;
    if (m < 0)
    {
      paramString2 = paramString2.toLowerCase();
      m = str.indexOf(paramString2);
      j = k;
      i = m;
      paramQQAppInterface = paramString2;
      if (m < 0)
      {
        paramQQAppInterface = a(str, paramString2, 1);
        if (paramQQAppInterface[0] < 0) {
          break label423;
        }
        i = paramQQAppInterface[0];
        j = paramQQAppInterface[1];
        paramQQAppInterface = paramString2;
      }
    }
    float f1 = jdField_a_of_type_AndroidGraphicsPaint.measureText(paramString1);
    float f2 = jdField_a_of_type_AndroidGraphicsPaint.measureText(paramQQAppInterface);
    if ((f1 >= g) && (i > 0))
    {
      f1 = Math.min(f2 + jdField_a_of_type_AndroidGraphicsPaint.measureText("…"), f1);
      f2 = g - f1;
      paramString2 = paramString1.substring(0, i);
      float[] arrayOfFloat = new float[paramString2.length()];
      jdField_a_of_type_AndroidGraphicsPaint.getTextWidths(paramString2, arrayOfFloat);
      k = arrayOfFloat.length - 1;
      f1 = 0.0F;
      m = 0;
      label249:
      if (k >= 0)
      {
        m += 1;
        f1 += arrayOfFloat[k];
        if ((f1 > f2) || (m >= paramInt))
        {
          if (f2 > 0.0F) {
            break label472;
          }
          paramInt = n;
          label294:
          paramString1 = "…" + paramString1.substring(i - paramInt);
          paramString2 = "…" + str.substring(i - paramInt);
          i = paramInt + 1;
        }
      }
    }
    for (;;)
    {
      paramString1 = new SpannableStringBuilder(paramString1);
      for (;;)
      {
        if (i >= 0)
        {
          paramString1.setSpan(new ForegroundColorSpan(BaseApplicationImpl.a.getResources().getColor(2131428332)), i, i + j, 17);
          i = paramString2.indexOf(paramQQAppInterface, j + i);
          j = paramQQAppInterface.length();
          continue;
          label423:
          paramQQAppInterface = a(str, paramString2, 2);
          if (paramQQAppInterface[0] >= 0)
          {
            i = paramQQAppInterface[0];
            j = paramQQAppInterface[1];
            paramQQAppInterface = paramString2;
            break;
          }
          return new SpannableStringBuilder(paramString1);
          k -= 1;
          break label249;
        }
      }
      return paramString1;
      label472:
      paramInt = m;
      break label294;
      paramString2 = str;
    }
  }
  
  public static CharSequence a(CharSequence paramCharSequence)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append("(").append(paramCharSequence).append(")");
    return localSpannableStringBuilder;
  }
  
  public static CharSequence a(CharSequence paramCharSequence, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return b(paramCharSequence.toString(), paramString2, paramInt, paramBoolean);
    }
    Object localObject2 = paramString1.toLowerCase();
    Object localObject1 = paramString2.toLowerCase();
    int k = ((String)localObject2).indexOf((String)localObject1);
    int i = paramString2.length();
    int j;
    if (k < 0) {
      if (paramBoolean)
      {
        int[] arrayOfInt = a((String)localObject2, (String)localObject1, 1);
        if (arrayOfInt[0] >= 0)
        {
          i = arrayOfInt[0];
          j = arrayOfInt[1];
          k = i;
          i = j;
        }
      }
    }
    for (;;)
    {
      if ((k > paramInt) || ((k > 6) && (k + i > paramInt)))
      {
        localObject1 = "(…" + paramString1.substring(k - 6) + ")";
        paramString1 = "(…" + ((String)localObject2).substring(k - 6) + ")";
      }
      for (paramInt = 8;; paramInt = k + 1)
      {
        localObject2 = new SpannableStringBuilder((CharSequence)localObject1);
        ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(BaseApplicationImpl.a.getResources().getColor(2131428303)), 0, ((String)localObject1).length(), 17);
        while (paramInt >= 0)
        {
          ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(BaseApplicationImpl.a.getResources().getColor(2131428332)), paramInt, paramInt + i, 17);
          paramInt = paramString1.indexOf(paramString2, paramInt + i);
          i = paramString2.length();
        }
        localObject1 = a((String)localObject2, (String)localObject1, 2);
        if (localObject1[0] >= 0)
        {
          i = localObject1[0];
          j = localObject1[1];
          break;
        }
        return b(paramCharSequence.toString(), paramString2, paramInt, paramBoolean);
        return b(paramCharSequence.toString(), paramString2, paramInt, paramBoolean);
        localObject1 = "(" + paramString1 + ")";
        paramString1 = "(" + (String)localObject2 + ")";
      }
      return new SpannableStringBuilder(paramCharSequence).append((CharSequence)localObject2);
    }
  }
  
  public static CharSequence a(String paramString, int paramInt, ArrayList paramArrayList)
  {
    int j = 0;
    if (paramString == null) {
      return null;
    }
    if ((paramInt < 0) || (paramArrayList == null) || (paramArrayList.isEmpty())) {
      return new SpannableStringBuilder(paramString);
    }
    Object localObject1 = paramString.getBytes();
    if (paramInt >= localObject1.length) {
      return new SpannableStringBuilder(paramString);
    }
    Object localObject2;
    if (paramInt > 0)
    {
      localObject2 = new byte[paramInt];
      System.arraycopy(localObject1, 0, localObject2, 0, localObject2.length);
    }
    for (paramInt = new String((byte[])localObject2).length();; paramInt = 0)
    {
      localObject1 = paramArrayList.iterator();
      do
      {
        i = j;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (String)((Iterator)localObject1).next();
      } while (paramString.toLowerCase().indexOf(((String)localObject2).toLowerCase()) != paramInt);
      int i = ((String)localObject2).length();
      if (paramInt <= 10)
      {
        localObject1 = paramString;
        if (paramInt > 6)
        {
          localObject1 = paramString;
          if (paramInt + i <= 10) {}
        }
      }
      else
      {
        localObject1 = "…" + paramString.substring(paramInt - 6);
      }
      paramString = new SpannableStringBuilder((CharSequence)localObject1);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject2 = (String)paramArrayList.next();
        paramInt = ((String)localObject1).toLowerCase().indexOf(((String)localObject2).toLowerCase());
        if (paramInt >= 0)
        {
          i = ((String)localObject2).length();
          while (paramInt >= 0)
          {
            paramString.setSpan(new ForegroundColorSpan(BaseApplicationImpl.a.getResources().getColor(2131428332)), paramInt, paramInt + i, 17);
            paramInt = ((String)localObject1).toLowerCase().indexOf(((String)localObject2).toLowerCase(), paramInt + i);
          }
        }
      }
      return paramString;
    }
  }
  
  public static CharSequence a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, 10);
  }
  
  public static CharSequence a(String paramString1, String paramString2, int paramInt)
  {
    return a(paramString1, paramString2, paramInt, true);
  }
  
  public static CharSequence a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    String str = paramString1.toLowerCase();
    int m = str.indexOf(paramString2);
    int k = paramString2.length();
    int i = m;
    int j = k;
    Object localObject = paramString2;
    if (m < 0)
    {
      paramString2 = paramString2.toLowerCase();
      m = str.indexOf(paramString2);
      i = m;
      j = k;
      localObject = paramString2;
      if (m < 0)
      {
        if (!paramBoolean) {
          break label290;
        }
        localObject = a(str, paramString2, 1);
        if (localObject[0] < 0) {
          break label250;
        }
        i = localObject[0];
        j = localObject[1];
        localObject = paramString2;
      }
    }
    if ((i > paramInt) || ((i > 4) && (i + j > paramInt)))
    {
      paramString1 = "…" + paramString1.substring(i - 4);
      paramString2 = "…" + str.substring(i - 4);
      i = 5;
    }
    for (;;)
    {
      paramString1 = new SpannableStringBuilder(paramString1);
      for (;;)
      {
        if (i >= 0)
        {
          paramString1.setSpan(new ForegroundColorSpan(BaseApplicationImpl.a.getResources().getColor(2131428332)), i, i + j, 17);
          i = paramString2.indexOf((String)localObject, i + j);
          j = ((String)localObject).length();
          continue;
          label250:
          localObject = a(str, paramString2, 2);
          if (localObject[0] >= 0)
          {
            i = localObject[0];
            j = localObject[1];
            break;
          }
          return new SpannableStringBuilder(paramString1);
          label290:
          return new SpannableStringBuilder(paramString1);
        }
      }
      return paramString1;
      paramString2 = str;
    }
  }
  
  public static CharSequence a(String paramString, ArrayList paramArrayList, int paramInt)
  {
    int i = 0;
    Object localObject = paramArrayList.iterator();
    int j = 0;
    String str1;
    String str2;
    int k;
    if (((Iterator)localObject).hasNext())
    {
      str1 = (String)((Iterator)localObject).next();
      str2 = paramString.toLowerCase();
      i = str2.indexOf(str1);
      j = str1.length();
      if (i >= 0) {
        k = j;
      }
    }
    for (;;)
    {
      if (i < 0)
      {
        return new SpannableStringBuilder(paramString);
        int m = str2.indexOf(str1.toLowerCase());
        i = m;
        k = j;
        if (m >= 0) {
          continue;
        }
        i = j;
        j = m;
        break;
      }
      if (i <= paramInt)
      {
        localObject = paramString;
        if (i > 6)
        {
          localObject = paramString;
          if (k + i <= paramInt) {}
        }
      }
      else
      {
        localObject = "…" + paramString.substring(i - 6);
      }
      paramString = new SpannableStringBuilder((CharSequence)localObject);
      paramArrayList = paramArrayList.iterator();
      do
      {
        if (!paramArrayList.hasNext()) {
          break;
        }
        str1 = (String)paramArrayList.next();
        str2 = ((String)localObject).toLowerCase();
        paramInt = str2.indexOf(str1);
        i = str1.length();
        if (paramInt >= 0) {
          break label276;
        }
        paramInt = str2.indexOf(str1.toLowerCase());
      } while (paramInt < 0);
      label276:
      for (;;)
      {
        paramString.setSpan(new ForegroundColorSpan(BaseApplicationImpl.a.getResources().getColor(2131428332)), paramInt, paramInt + i, 17);
        break;
        return paramString;
      }
      k = i;
      i = j;
    }
  }
  
  public static String a(String... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return null;
    }
    int i = 0;
    while (i < paramVarArgs.length)
    {
      if (!TextUtils.isEmpty(paramVarArgs[i])) {
        return paramVarArgs[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static HashMap a(HashMap paramHashMap)
  {
    HashMap localHashMap = paramHashMap;
    if (paramHashMap == null) {
      localHashMap = new HashMap();
    }
    localHashMap.put("input_type", String.valueOf(jdField_a_of_type_Long));
    localHashMap.put("support_sougou_ime", String.valueOf(b));
    return localHashMap;
  }
  
  public static void a()
  {
    int i = 70;
    int k = 1;
    int j;
    if (SearchStatisticsConstants.a(70) != 0)
    {
      j = 1;
      if (SearchStatisticsConstants.a(80) == 0) {
        break label77;
      }
      label23:
      if ((j == 0) || (k == 0)) {
        break label82;
      }
      i = 90;
    }
    for (;;)
    {
      if (i != 0) {
        ReportController.b(null, "CliOper", "", "", "0X8005ECF", "0X8005ECF", i, 0, "", "", "", "");
      }
      return;
      j = 0;
      break;
      label77:
      k = 0;
      break label23;
      label82:
      if (j == 0) {
        if (k != 0) {
          i = 80;
        } else {
          i = 0;
        }
      }
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString1, String paramString2, int paramInt4)
  {
    int i = -1;
    HashMap localHashMap;
    switch (paramInt1)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("searchUtils", 2, "moduleType:" + i + " moduleIndex:" + paramInt2 + " itemLinePosition:" + paramInt3 + " isGroupSearch:" + paramBoolean);
      }
      if (paramBoolean)
      {
        localHashMap = new HashMap();
        localHashMap.put("moduleType", Integer.toString(i));
        localHashMap.put("moduleIndex", Integer.toString(paramInt2));
        localHashMap.put("itemLinePosition", Integer.toString(paramInt3));
        localHashMap.put("toUin", paramString1);
        localHashMap.put("keyword", paramString2);
        if (paramInt4 == 12)
        {
          localHashMap.put("isFolder", "1");
          label190:
          StatisticCollector.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).a(null, "NetGroupSearchItemClick", true, 0L, 0L, localHashMap, null);
          paramString1 = "";
          switch (paramInt1)
          {
          }
        }
      }
      break;
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", paramString1, paramString1, 0, 0, String.valueOf(paramInt3), "", "", "");
      return;
      i = 70;
      break;
      i = 80;
      break;
      i = 90;
      break;
      localHashMap.put("isFolder", "0");
      break label190;
      localHashMap = new HashMap();
      localHashMap.put("moduleType", Integer.toString(i));
      localHashMap.put("itemLinePosition", Integer.toString(paramInt3));
      localHashMap.put("toUin", paramString1);
      localHashMap.put("keyword", paramString2);
      if (paramInt4 == 12) {
        localHashMap.put("isFolder", "1");
      }
      for (;;)
      {
        StatisticCollector.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).a(null, "NetModelSearchItemClick", true, 0L, 0L, localHashMap, null);
        break;
        localHashMap.put("isFolder", "0");
      }
      if (paramInt3 == 0)
      {
        paramString1 = "0X80061BA";
      }
      else
      {
        paramString1 = "0X80061B9";
        continue;
        if (paramInt3 == 0)
        {
          paramString1 = "0X80061BD";
        }
        else
        {
          paramString1 = "0X80061BC";
          continue;
          if (paramInt3 == 0)
          {
            paramString1 = "0X80061C0";
          }
          else
          {
            paramString1 = "0X80061BF";
            continue;
            if (paramInt3 == 0) {
              paramString1 = "0X80061C3";
            } else {
              paramString1 = "0X80061C2";
            }
          }
        }
      }
    }
  }
  
  public static void a(Intent paramIntent, ForwardBaseOption paramForwardBaseOption)
  {
    String str1;
    String str2;
    int j;
    int i;
    if ((paramIntent != null) && (paramForwardBaseOption != null))
    {
      str1 = paramIntent.getStringExtra("contactSearchResultUin");
      str2 = paramIntent.getStringExtra("contactSearchResultTroopUin");
      j = paramIntent.getIntExtra("contactSearchResultUinType", 0);
      paramIntent = paramIntent.getStringExtra("contactSearchResultName");
      i = ForwardAbility.ForwardAbilityType.a.intValue();
      switch (j)
      {
      }
    }
    for (;;)
    {
      if (!StringUtil.b(str1))
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("uin", str1);
        localBundle.putInt("uintype", j);
        localBundle.putString("uinname", paramIntent);
        localBundle.putString("troop_uin", str2);
        paramForwardBaseOption.a(i, localBundle);
        paramForwardBaseOption.e();
      }
      return;
      i = ForwardAbility.ForwardAbilityType.b.intValue();
      continue;
      i = ForwardAbility.ForwardAbilityType.c.intValue();
      continue;
      i = ForwardAbility.ForwardAbilityType.d.intValue();
      continue;
      i = ForwardAbility.ForwardAbilityType.i.intValue();
      continue;
      i = ForwardAbility.ForwardAbilityType.j.intValue();
      continue;
      i = ForwardAbility.ForwardAbilityType.h.intValue();
    }
  }
  
  public static void a(View paramView, IContactSearchModel paramIContactSearchModel)
  {
    Activity localActivity = (Activity)paramView.getContext();
    Intent localIntent = new Intent();
    localIntent.putExtra("contactSearchResultUin", paramIContactSearchModel.a());
    localIntent.putExtra("contactSearchResultUinType", paramIContactSearchModel.b());
    localIntent.putExtra("contactSearchResultName", paramIContactSearchModel.c());
    if (((paramIContactSearchModel instanceof ContactSearchModelDiscussion)) || ((paramIContactSearchModel instanceof ContactSearchModelTroop))) {
      paramView = paramIContactSearchModel.a();
    }
    for (;;)
    {
      if ((paramIContactSearchModel instanceof ContactSearchModelPhoneContact))
      {
        localIntent.putExtra("contactSearchResultPhoneContactOriginBinder", ((ContactSearchModelPhoneContact)paramIContactSearchModel).a.originBinder);
        localIntent.putExtra("contactSearchResultPhoneContactMobileCode", ((ContactSearchModelPhoneContact)paramIContactSearchModel).a.mobileCode);
        localIntent.putExtra("contactSearchResultPhoneContactNationCode", ((ContactSearchModelPhoneContact)paramIContactSearchModel).a.nationCode);
        localIntent.putExtra("contactSearchResultPhoneContactAbility", ((ContactSearchModelPhoneContact)paramIContactSearchModel).a.ability);
      }
      localIntent.putExtra("contactSearchResultTroopUin", paramView);
      localActivity.setResult(-1, localIntent);
      localActivity.finish();
      localActivity.overridePendingTransition(0, 0);
      return;
      if ((paramIContactSearchModel instanceof ContactSearchModelDiscussionMember)) {
        paramView = ((ContactSearchModelDiscussionMember)paramIContactSearchModel).e();
      } else if ((paramIContactSearchModel instanceof ContactSearchModelRecentUser)) {
        paramView = ((ContactSearchModelRecentUser)paramIContactSearchModel).e();
      } else {
        paramView = "";
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    ThreadManager.a(new und(paramInt, paramString2, paramString3, paramString1, paramQQAppInterface), null, false);
  }
  
  public static void a(IContactSearchModel paramIContactSearchModel, View paramView)
  {
    ThreadManager.a(new une(paramView, paramIContactSearchModel), null, true);
  }
  
  public static void a(String paramString)
  {
    String[] arrayOfString;
    if (!TextUtils.isEmpty(paramString))
    {
      arrayOfString = paramString.split(" ");
      if (arrayOfString == null) {}
    }
    for (int i = arrayOfString.length;; i = 0)
    {
      if (i > 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("searchUtils", 2, "discuss -searchKey:" + paramString + " count:" + i);
        }
        ReportController.b(null, "CliOper", "", "", "0X8005E0F", "0X8005E0F", 0, 0, "" + i, "", "", "");
      }
      return;
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, View paramView)
  {
    boolean bool = a(paramView.getContext());
    int i = ((Integer)paramView.getTag(2131296490)).intValue() + 1;
    if (QLog.isColorLevel()) {
      QLog.d("searchUtils", 2, "moduleType:" + paramInt1 + " itemLinePosition:" + i);
    }
    if (bool)
    {
      int j = SearchStatisticsConstants.a(paramInt1);
      if (QLog.isColorLevel()) {
        QLog.d("searchUtils", 2, "moduleIndex:" + j + " searchKey:" + paramString);
      }
      ReportController.b(null, "CliOper", "", "", "0X8005E10", "0X8005E10", paramInt1, 0, String.valueOf(j), String.valueOf(i), String.valueOf(paramInt2), "");
      paramView = new HashMap();
      paramView.put("moduleType", Integer.toString(paramInt1));
      paramView.put("moduleIndex", Integer.toString(j));
      paramView.put("moduleChildType", Integer.toString(paramInt2));
      paramView.put("itemLinePosition", Integer.toString(i));
      paramView.put("keyword", paramString);
      if (GroupSearchActivity.b != -1L) {
        paramView.put("stay_time", String.valueOf(System.currentTimeMillis() - GroupSearchActivity.b));
      }
      StatisticCollector.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).a(null, "GroupSearchItemClick", true, 0L, 0L, a(paramView), null);
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8005E11", "0X8005E11", paramInt1, 0, "", String.valueOf(i), String.valueOf(paramInt2), "");
    paramView = new HashMap();
    paramView.put("moduleType", Integer.toString(paramInt1));
    paramView.put("moduleChildType", Integer.toString(paramInt2));
    paramView.put("itemLinePosition", Integer.toString(i));
    paramView.put("keyword", paramString);
    StatisticCollector.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).a(null, "ModelSearchItemClick", true, 0L, 0L, paramView, null);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, View paramView, String paramString2, boolean paramBoolean, int paramInt3)
  {
    boolean bool = a(paramView.getContext());
    int i = ((Integer)paramView.getTag(2131296490)).intValue() + 1;
    if (QLog.isColorLevel()) {
      QLog.d("searchUtils", 2, "moduleType:" + paramInt1 + " itemLinePosition:" + i);
    }
    if (bool)
    {
      int j = SearchStatisticsConstants.a(paramInt1);
      if (QLog.isColorLevel()) {
        QLog.d("searchUtils", 2, "moduleIndex:" + j + " searchKey:" + paramString1);
      }
      ReportController.b(null, "CliOper", "", "", "0X8005E10", "0X8005E10", paramInt1, 0, String.valueOf(j), String.valueOf(i), String.valueOf(paramInt2), "");
      paramView = new HashMap();
      paramView.put("moduleType", Integer.toString(paramInt1));
      paramView.put("moduleIndex", Integer.toString(j));
      paramView.put("moduleChildType", Integer.toString(paramInt2));
      paramView.put("itemLinePosition", Integer.toString(i));
      paramView.put("toUin", paramString2);
      paramView.put("keyword", paramString1);
      if (paramBoolean)
      {
        paramString1 = "1";
        paramView.put("sFrom", paramString1);
        if (paramInt3 != 12) {
          break label333;
        }
        paramView.put("isFolder", "1");
      }
      for (;;)
      {
        if (GroupSearchActivity.b != -1L) {
          paramView.put("stay_time", String.valueOf(System.currentTimeMillis() - GroupSearchActivity.b));
        }
        StatisticCollector.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).a(null, "GroupSearchItemClick", true, 0L, 0L, a(paramView), null);
        return;
        paramString1 = "0";
        break;
        label333:
        paramView.put("isFolder", "0");
      }
    }
    ReportController.b(null, "CliOper", "", "", "0X8005E11", "0X8005E11", paramInt1, 0, "", String.valueOf(i), String.valueOf(paramInt2), "");
    paramView = new HashMap();
    paramView.put("moduleType", Integer.toString(paramInt1));
    paramView.put("moduleChildType", Integer.toString(paramInt2));
    paramView.put("itemLinePosition", Integer.toString(i));
    paramView.put("keyword", paramString1);
    paramView.put("toUin", paramString2);
    if (paramBoolean)
    {
      paramString1 = "1";
      paramView.put("sFrom", paramString1);
      if (paramInt3 != 12) {
        break label509;
      }
      paramView.put("isFolder", "1");
    }
    for (;;)
    {
      StatisticCollector.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).a(null, "ModelSearchItemClick", true, 0L, 0L, paramView, null);
      return;
      paramString1 = "0";
      break;
      label509:
      paramView.put("isFolder", "0");
    }
  }
  
  public static void a(String paramString, int paramInt, View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("searchUtils", 2, "moduleType:40 -3 searchKey:" + "");
      }
      ReportController.b(null, "CliOper", "", "", "0X8005E12", "0X8005E12", 40, 0, "3", "", "", "");
      return;
    }
    if (a(paramView.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("searchUtils", 2, "moduleType:" + paramInt + " -1" + " searchKey:" + "");
      }
      ReportController.b(null, "CliOper", "", "", "0X8005E12", "0X8005E12", paramInt, 0, "1", "", "", "");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("searchUtils", 2, "moduleType:" + paramInt + " -2" + " searchKey:" + "");
    }
    ReportController.b(null, "CliOper", "", "", "0X8005E12", "0X8005E12", paramInt, 0, "2", "", "", "");
  }
  
  public static boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private static boolean a(Context paramContext)
  {
    return ((Activity)paramContext instanceof GroupSearchActivity);
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return false;
      paramString = paramString.trim();
      i = paramString.length();
    } while ((i < 5) || (i > 15));
    try
    {
      Long.parseLong(paramString);
      return true;
    }
    catch (NumberFormatException paramString) {}
    return false;
  }
  
  public static int[] a(ChnToSpell.ChnSpelling paramChnSpelling, String paramString)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = -1;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    int j = paramChnSpelling.jdField_a_of_type_JavaLangString.indexOf(paramString);
    if (j < 0) {
      return arrayOfInt;
    }
    int i = 0;
    int k;
    if (i < paramChnSpelling.jdField_a_of_type_JavaUtilList.size())
    {
      if (j == ((Integer)paramChnSpelling.jdField_a_of_type_JavaUtilList.get(i)).intValue())
      {
        arrayOfInt[0] = i;
        k = i + 1;
        for (;;)
        {
          if ((k >= paramChnSpelling.jdField_a_of_type_JavaUtilList.size()) || (j + paramString.length() <= ((Integer)paramChnSpelling.jdField_a_of_type_JavaUtilList.get(k)).intValue()))
          {
            arrayOfInt[1] = (k - i);
            return arrayOfInt;
          }
          k += 1;
        }
      }
      if (j >= ((Integer)paramChnSpelling.jdField_a_of_type_JavaUtilList.get(i)).intValue()) {
        break label214;
      }
      k = paramChnSpelling.jdField_a_of_type_JavaLangString.indexOf(paramString, ((Integer)paramChnSpelling.jdField_a_of_type_JavaUtilList.get(i)).intValue());
      if (k < 0) {
        return arrayOfInt;
      }
      j = i - 1;
    }
    for (i = k;; i = k)
    {
      k = i;
      i = j + 1;
      j = k;
      break;
      return arrayOfInt;
      label214:
      k = j;
      j = i;
    }
  }
  
  public static int[] a(String paramString1, String paramString2, int paramInt)
  {
    return a(ChnToSpell.a(paramString1, paramInt), paramString2);
  }
  
  public static long b(String paramString1, String paramString2, long paramLong)
  {
    return a(paramString1, paramString2, paramLong, true);
  }
  
  public static CharSequence b(String paramString1, String paramString2, int paramInt)
  {
    String str2 = paramString1.toLowerCase().substring(paramInt);
    int m = str2.indexOf(paramString2);
    int k = paramString2.length();
    int j = m;
    int i = k;
    Object localObject = paramString2;
    if (m < 0)
    {
      paramString2 = paramString2.toLowerCase();
      m = str2.indexOf(paramString2);
      j = m;
      i = k;
      localObject = paramString2;
      if (m < 0)
      {
        localObject = a(str2, paramString2, 1);
        if (localObject[0] < 0) {
          break label267;
        }
        j = localObject[0];
        i = localObject[1];
      }
    }
    for (localObject = paramString2;; localObject = paramString2)
    {
      j += paramInt;
      String str1;
      if (j <= 10)
      {
        paramInt = j;
        paramString2 = str2;
        str1 = paramString1;
        if (j > 6)
        {
          paramInt = j;
          paramString2 = str2;
          str1 = paramString1;
          if (j + i <= 10) {}
        }
      }
      else
      {
        str1 = "…" + paramString1.substring(j - 6);
        paramString2 = "…" + str2.substring(j - 6);
        paramInt = 7;
      }
      paramString1 = new SpannableStringBuilder(str1);
      while (paramInt >= 0)
      {
        paramString1.setSpan(new ForegroundColorSpan(BaseApplicationImpl.a.getResources().getColor(2131428332)), paramInt, paramInt + i, 17);
        paramInt = paramString2.indexOf((String)localObject, paramInt + i);
        i = ((String)localObject).length();
      }
      label267:
      localObject = a(str2, paramString2, 2);
      if (localObject[0] < 0) {
        break;
      }
      j = localObject[0];
      i = localObject[1];
    }
    return new SpannableStringBuilder(paramString1);
    return paramString1;
  }
  
  public static CharSequence b(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    String str = paramString1.toLowerCase();
    Object localObject = paramString2.toLowerCase();
    int k = str.indexOf((String)localObject);
    int i = ((String)localObject).length();
    int j = k;
    if (k < 0)
    {
      if (!paramBoolean) {
        break label277;
      }
      int[] arrayOfInt = a(str, (String)localObject, 1);
      if (arrayOfInt[0] >= 0)
      {
        i = arrayOfInt[0];
        j = arrayOfInt[1];
        k = i;
        i = j;
        j = k;
      }
    }
    else
    {
      if ((j <= paramInt) && ((j <= 6) || (j + i <= paramInt))) {
        break label288;
      }
      paramString1 = "…" + paramString1.substring(j - 6);
      str = "…" + str.substring(j - 6);
      j = 7;
    }
    label277:
    label288:
    for (;;)
    {
      paramString1 = new SpannableStringBuilder(paramString1);
      for (;;)
      {
        if (j >= 0)
        {
          paramString1.setSpan(new ForegroundColorSpan(BaseApplicationImpl.a.getResources().getColor(2131428332)), j, j + i, 17);
          j = str.indexOf(paramString2, j + i);
          i = paramString2.length();
          continue;
          localObject = a(str, (String)localObject, 2);
          if (localObject[0] >= 0)
          {
            i = localObject[0];
            j = localObject[1];
            break;
          }
          return new SpannableStringBuilder(paramString1);
          return new SpannableStringBuilder(paramString1);
        }
      }
      return paramString1;
    }
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = paramString.trim();
    int i = 0;
    for (;;)
    {
      if (i >= paramString.length()) {
        break label51;
      }
      if ((paramString.charAt(i) < '0') && (paramString.charAt(i) > '9')) {
        break;
      }
      i += 1;
    }
    label51:
    return true;
  }
  
  public static CharSequence c(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    Object localObject2 = paramString1.toLowerCase();
    Object localObject1 = paramString2.toLowerCase();
    int k = ((String)localObject2).indexOf((String)localObject1);
    int i = ((String)localObject1).length();
    int j;
    if (k < 0) {
      if (paramBoolean)
      {
        int[] arrayOfInt = a((String)localObject2, (String)localObject1, 1);
        if (arrayOfInt[0] >= 0)
        {
          i = arrayOfInt[0];
          j = arrayOfInt[1];
          k = i;
          i = j;
        }
      }
    }
    for (;;)
    {
      if ((k > paramInt) || ((k > 6) && (k + i > paramInt)))
      {
        localObject1 = "(…" + paramString1.substring(k - 6) + ")";
        paramString1 = "(…" + ((String)localObject2).substring(k - 6) + ")";
      }
      for (paramInt = 8;; paramInt = k + 1)
      {
        localObject2 = new SpannableStringBuilder((CharSequence)localObject1);
        ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(BaseApplicationImpl.a.getResources().getColor(2131428303)), 0, ((String)localObject1).length(), 17);
        while (paramInt >= 0)
        {
          ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(BaseApplicationImpl.a.getResources().getColor(2131428332)), paramInt, paramInt + i, 17);
          paramInt = paramString1.indexOf(paramString2, paramInt + i);
          i = paramString2.length();
        }
        localObject1 = a((String)localObject2, (String)localObject1, 2);
        if (localObject1[0] >= 0)
        {
          i = localObject1[0];
          j = localObject1[1];
          break;
        }
        return new SpannableStringBuilder(paramString1);
        return new SpannableStringBuilder(paramString1);
        localObject1 = "(" + paramString1 + ")";
        paramString1 = "(" + (String)localObject2 + ")";
      }
      return (CharSequence)localObject2;
    }
  }
  
  public static boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = paramString.toLowerCase().trim();
    int i = 0;
    for (;;)
    {
      if (i >= paramString.length()) {
        break label54;
      }
      if ((paramString.charAt(i) < 'a') && (paramString.charAt(i) > 'z')) {
        break;
      }
      i += 1;
    }
    label54:
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\util\SearchUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */