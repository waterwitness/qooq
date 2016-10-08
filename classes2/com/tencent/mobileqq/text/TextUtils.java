package com.tencent.mobileqq.text;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.v4.util.MQLruCache;
import android.text.Editable;
import android.util.Pair;
import android.widget.EditText;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.app.AccountNotMatchException;

public class TextUtils
{
  private static final String a = "TextUtils";
  
  public TextUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static final int a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= EmotcationConstants.jdField_b_of_type_Int)) {
      throw new IllegalArgumentException("invaid sys emotcation index: " + paramInt);
    }
    return EmotcationConstants.jdField_b_of_type_ArrayOfInt[paramInt];
  }
  
  public static final Drawable a(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("invaid emoji index: " + paramInt);
    }
    int j = 2130839942;
    if (QLog.isColorLevel()) {
      QLog.d("AppleEmojiManager", 2, "getEmojiDrawable index=" + paramInt);
    }
    if (paramInt >= 1000) {
      return b(BaseApplicationImpl.getContext().getResources(), paramInt);
    }
    int i = j;
    if (paramInt >= 0)
    {
      i = j;
      if (paramInt < EmotcationConstants.e) {
        i = 2130839808 + paramInt;
      }
    }
    if (BaseApplicationImpl.a != null) {
      return a(BaseApplicationImpl.getContext().getResources(), i);
    }
    return BaseApplicationImpl.getContext().getResources().getDrawable(i);
  }
  
  public static final Drawable a(int paramInt, boolean paramBoolean)
  {
    localObject1 = null;
    if ((paramInt < 0) || (paramInt >= EmotcationConstants.jdField_b_of_type_Int)) {
      throw new IllegalArgumentException("invaid sys emotcation index: " + paramInt);
    }
    localResources = BaseApplicationImpl.getContext().getResources();
    if (!paramBoolean)
    {
      paramInt = EmotcationConstants.jdField_b_of_type_ArrayOfInt[paramInt];
      if (BaseApplicationImpl.a != null) {
        localObject1 = a(localResources, paramInt);
      }
    }
    do
    {
      do
      {
        return (Drawable)localObject1;
        return localResources.getDrawable(paramInt);
        int i = EmotcationConstants.jdField_a_of_type_ArrayOfInt[paramInt];
        int j = EmotcationConstants.jdField_b_of_type_ArrayOfInt[paramInt];
        try
        {
          localObject2 = localResources.getResourceEntryName(i);
          if (QLog.isColorLevel()) {
            QLog.d("TextUtils", 2, "getDrawable host:" + (String)localObject2);
          }
          localObject2 = new URL("emotion", localResources.getResourceEntryName(i), "");
        }
        catch (MalformedURLException localMalformedURLException)
        {
          for (;;)
          {
            Object localObject2;
            if (QLog.isColorLevel()) {
              QLog.d("TextUtils", 2, "getDrawable ,", localMalformedURLException);
            }
            Object localObject3 = null;
            continue;
            localObject1 = localResources.getDrawable(j);
            localObject3 = URLDrawable.getDrawable((URL)localObject3, (Drawable)localObject1, (Drawable)localObject1, true);
          }
        }
      } while (localObject2 == null);
      localObject1 = ((URL)localObject2).toString();
      if ((BaseApplicationImpl.a == null) || (BaseApplicationImpl.a.get(localObject1) == null)) {
        break label232;
      }
      localObject1 = new ColorDrawable();
      localObject2 = URLDrawable.getDrawable((URL)localObject2, (Drawable)localObject1, (Drawable)localObject1, true);
      localObject1 = localObject2;
    } while (localObject2 == null);
    ((URLDrawable)localObject2).addHeader("faceIdx", Integer.toString(paramInt));
    return (Drawable)localObject2;
  }
  
  public static Drawable a(Resources paramResources, int paramInt)
  {
    String str = "android.resource://" + paramInt;
    Object localObject = (Pair)BaseApplicationImpl.a.get(str);
    if (localObject != null) {
      paramResources = ((Drawable.ConstantState)((Pair)localObject).first).newDrawable(paramResources);
    }
    for (;;)
    {
      return paramResources;
      try
      {
        localObject = paramResources.getDrawable(paramInt);
        paramInt = SkinUtils.a((Drawable)localObject);
        paramResources = (Resources)localObject;
        if (paramInt > 0)
        {
          BaseApplicationImpl.a.put(str, new Pair(((Drawable)localObject).getConstantState(), Integer.valueOf(paramInt)));
          return (Drawable)localObject;
        }
      }
      catch (Exception paramResources) {}
    }
    return null;
  }
  
  public static final String a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= EmotcationConstants.c.length)) {
      throw new IllegalArgumentException("invaid sys emotcation index: " + paramInt);
    }
    return String.valueOf(Character.toChars(EmotcationConstants.c[paramInt]));
  }
  
  public static String a(String paramString)
  {
    String str1;
    if (android.text.TextUtils.isEmpty(paramString)) {
      str1 = "";
    }
    int i;
    int j;
    do
    {
      return str1;
      i = 0;
      while (i < EmotcationConstants.c.length)
      {
        j = paramString.indexOf(EmotcationConstants.c[i], 0);
        str1 = paramString;
        if (j != -1)
        {
          str1 = paramString;
          if (j + 2 <= paramString.length()) {
            str1 = paramString.replace(paramString.substring(j, j + 2), "");
          }
        }
        i += 1;
        paramString = str1;
      }
      str1 = paramString;
    } while (!a(paramString));
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    paramString = BaseApplicationImpl.getContext();
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    }
    for (;;)
    {
      paramString = paramString.getSharedPreferences("Last_Login", i).getString("uin", "");
      str1 = null;
      try
      {
        paramString = (AppInterface)BaseApplicationImpl.a().getAppRuntime(paramString);
        if (paramString != null)
        {
          for (;;)
          {
            try
            {
              if ((paramString instanceof NearbyAppInterface)) {
                break label556;
              }
              paramString = (EmoticonManager)paramString.getManager(13);
              i = 0;
              str1 = paramString;
            }
            catch (Throwable paramString)
            {
              paramString.printStackTrace();
              i = 0;
              continue;
              j = i;
              if (k != 255) {
                continue;
              }
              if (i + 4 < localStringBuilder.length()) {
                continue;
              }
              localStringBuilder.replace(i, localStringBuilder.length(), "[小表情]");
              i += "[小表情]".length() - 1;
              continue;
              paramString = new char[4];
              paramString[0] = localStringBuilder.charAt(i + 4);
              paramString[1] = localStringBuilder.charAt(i + 3);
              paramString[2] = localStringBuilder.charAt(i + 2);
              paramString[3] = localStringBuilder.charAt(i + 1);
              j = 0;
              if (j >= 3) {
                continue;
              }
              if (paramString[j] != 'ú') {
                continue;
              }
              paramString[j] = 10;
              j += 1;
              continue;
              if (paramString[j] != 'þ') {
                continue;
              }
              paramString[j] = 13;
              continue;
              paramString = EmosmUtils.a(paramString);
              if (paramString == null) {
                break label547;
              }
            }
            if (i >= localStringBuilder.length()) {
              break label536;
            }
            j = i;
            if (localStringBuilder.codePointAt(i) == 20)
            {
              j = i;
              if (i < localStringBuilder.length() - 1)
              {
                k = localStringBuilder.charAt(i + 1);
                if (k >= EmotcationConstants.jdField_b_of_type_Int) {
                  continue;
                }
                paramString = EmotcationConstants.jdField_a_of_type_ArrayOfJavaLangString[k];
                localStringBuilder.replace(i, i + 2, paramString);
                j = i + (paramString.length() - 1);
              }
            }
            i = j + 1;
          }
          i = 0;
        }
      }
      catch (AccountNotMatchException paramString)
      {
        for (;;)
        {
          int k;
          paramString.printStackTrace();
          paramString = null;
          continue;
          if (paramString.length == 2)
          {
            k = paramString[0];
            j = paramString[1];
          }
          for (;;)
          {
            if (str1 != null) {}
            for (paramString = str1.a(Integer.toString(k), Integer.toString(j));; paramString = "")
            {
              String str2 = paramString;
              if (android.text.TextUtils.isEmpty(paramString)) {
                str2 = "[小表情]";
              }
              localStringBuilder.replace(i, i + 5, str2);
              j = i + (str2.length() - 1);
              break;
              label536:
              return localStringBuilder.toString();
            }
            label547:
            j = 0;
            k = 0;
          }
          label556:
          paramString = null;
        }
      }
    }
  }
  
  public static String a(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder().append("**");
    if (paramInt >= paramString.length()) {}
    for (paramString = "-";; paramString = paramString.substring(paramInt)) {
      return paramString;
    }
  }
  
  public static final void a(EditText paramEditText)
  {
    try
    {
      Editable localEditable = paramEditText.getText();
      int j = paramEditText.getSelectionStart();
      int i = 0;
      if (j > 1) {
        i = android.text.TextUtils.getOffsetBefore(paramEditText.getText(), j);
      }
      if (j != i) {
        localEditable.delete(Math.min(j, i), Math.max(j, i));
      }
      return;
    }
    catch (Exception paramEditText)
    {
      paramEditText.printStackTrace();
    }
  }
  
  public static boolean a(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {}
    while (-1 == paramString.indexOf('\024')) {
      return false;
    }
    return true;
  }
  
  /* Error */
  public static final Drawable b(Resources paramResources, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +29 -> 32
    //   6: ldc 62
    //   8: iconst_2
    //   9: new 30	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 335
    //   19: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_1
    //   23: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: new 30	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 337
    //   42: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: iload_1
    //   46: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: astore 4
    //   54: getstatic 90	com/tencent/common/app/BaseApplicationImpl:a	Landroid/support/v4/util/MQLruCache;
    //   57: ifnull +65 -> 122
    //   60: getstatic 90	com/tencent/common/app/BaseApplicationImpl:a	Landroid/support/v4/util/MQLruCache;
    //   63: aload 4
    //   65: invokevirtual 124	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   68: checkcast 153	android/util/Pair
    //   71: astore_2
    //   72: aload_2
    //   73: ifnull +49 -> 122
    //   76: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq +29 -> 108
    //   82: ldc 62
    //   84: iconst_2
    //   85: new 30	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   92: ldc_w 339
    //   95: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: iload_1
    //   99: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   102: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: aload_2
    //   109: getfield 157	android/util/Pair:first	Ljava/lang/Object;
    //   112: checkcast 159	android/graphics/drawable/Drawable$ConstantState
    //   115: aload_0
    //   116: invokevirtual 163	android/graphics/drawable/Drawable$ConstantState:newDrawable	(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;
    //   119: astore_0
    //   120: aload_0
    //   121: areturn
    //   122: invokestatic 344	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   125: getstatic 348	com/tencent/mobileqq/text/AppleEmojiManager:c	Ljava/lang/String;
    //   128: invokevirtual 351	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;)Ljava/io/RandomAccessFile;
    //   131: astore_2
    //   132: iload_1
    //   133: sipush 1000
    //   136: isub
    //   137: i2l
    //   138: lstore 6
    //   140: aload_2
    //   141: astore_0
    //   142: aload_2
    //   143: lload 6
    //   145: invokevirtual 357	java/io/RandomAccessFile:seek	(J)V
    //   148: aload_2
    //   149: astore_0
    //   150: invokestatic 363	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   153: iconst_4
    //   154: invokevirtual 367	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   157: astore_3
    //   158: aload_2
    //   159: astore_0
    //   160: aload_2
    //   161: aload_3
    //   162: iconst_0
    //   163: iconst_4
    //   164: invokevirtual 371	java/io/RandomAccessFile:read	([BII)I
    //   167: pop
    //   168: aload_2
    //   169: astore_0
    //   170: aload_3
    //   171: invokestatic 374	com/tencent/mobileqq/text/AppleEmojiManager:a	([B)I
    //   174: istore 5
    //   176: aload_2
    //   177: astore_0
    //   178: invokestatic 363	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   181: aload_3
    //   182: invokevirtual 378	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   185: aload_2
    //   186: astore_0
    //   187: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +415 -> 605
    //   193: aload_2
    //   194: astore_0
    //   195: ldc 62
    //   197: iconst_2
    //   198: new 30	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   205: ldc_w 380
    //   208: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: iload 5
    //   213: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   216: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: goto +383 -> 605
    //   225: aload_2
    //   226: astore_0
    //   227: ldc 62
    //   229: iconst_4
    //   230: new 30	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   237: ldc_w 382
    //   240: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: iload_1
    //   244: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: aload_2
    //   254: ifnull +12 -> 266
    //   257: invokestatic 344	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   260: getstatic 348	com/tencent/mobileqq/text/AppleEmojiManager:c	Ljava/lang/String;
    //   263: invokevirtual 384	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;)V
    //   266: aconst_null
    //   267: areturn
    //   268: aload_2
    //   269: astore_0
    //   270: invokestatic 363	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   273: sipush 4096
    //   276: invokevirtual 367	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   279: astore_3
    //   280: aload_2
    //   281: astore_0
    //   282: aload_3
    //   283: iconst_0
    //   284: aload_2
    //   285: aload_3
    //   286: iconst_0
    //   287: iload 5
    //   289: invokevirtual 371	java/io/RandomAccessFile:read	([BII)I
    //   292: invokestatic 390	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   295: astore_3
    //   296: aload_2
    //   297: astore_0
    //   298: aload_3
    //   299: invokestatic 395	com/tencent/mobileqq/util/Utils:a	(Landroid/graphics/Bitmap;)I
    //   302: istore 5
    //   304: aload_2
    //   305: astore_0
    //   306: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   309: ifeq +32 -> 341
    //   312: aload_2
    //   313: astore_0
    //   314: ldc 62
    //   316: iconst_2
    //   317: new 30	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   324: ldc_w 397
    //   327: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: iload 5
    //   332: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   335: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: iload 5
    //   343: ifle +140 -> 483
    //   346: aload_2
    //   347: astore_0
    //   348: new 399	android/graphics/drawable/BitmapDrawable
    //   351: dup
    //   352: aload_3
    //   353: invokespecial 402	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   356: astore_3
    //   357: aload_2
    //   358: astore_0
    //   359: getstatic 90	com/tencent/common/app/BaseApplicationImpl:a	Landroid/support/v4/util/MQLruCache;
    //   362: ifnull +66 -> 428
    //   365: aload_2
    //   366: astore_0
    //   367: getstatic 90	com/tencent/common/app/BaseApplicationImpl:a	Landroid/support/v4/util/MQLruCache;
    //   370: aload 4
    //   372: new 153	android/util/Pair
    //   375: dup
    //   376: aload_3
    //   377: invokevirtual 174	android/graphics/drawable/Drawable:getConstantState	()Landroid/graphics/drawable/Drawable$ConstantState;
    //   380: iload 5
    //   382: invokestatic 178	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   385: invokespecial 181	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   388: invokevirtual 185	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   391: pop
    //   392: aload_2
    //   393: astore_0
    //   394: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   397: ifeq +31 -> 428
    //   400: aload_2
    //   401: astore_0
    //   402: ldc 62
    //   404: iconst_2
    //   405: new 30	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   412: ldc_w 404
    //   415: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: iload_1
    //   419: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   422: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   428: aload_2
    //   429: astore_0
    //   430: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   433: ifeq +33 -> 466
    //   436: aload_2
    //   437: astore_0
    //   438: ldc 62
    //   440: iconst_2
    //   441: invokestatic 409	com/tencent/mobileqq/activity/aio/AIOUtils:a	()Ljava/lang/StringBuilder;
    //   444: ldc_w 411
    //   447: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: iload_1
    //   451: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   454: ldc_w 413
    //   457: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   466: aload_3
    //   467: astore_0
    //   468: aload_2
    //   469: ifnull -349 -> 120
    //   472: invokestatic 344	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   475: getstatic 348	com/tencent/mobileqq/text/AppleEmojiManager:c	Ljava/lang/String;
    //   478: invokevirtual 384	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;)V
    //   481: aload_3
    //   482: areturn
    //   483: aload_2
    //   484: ifnull +12 -> 496
    //   487: invokestatic 344	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   490: getstatic 348	com/tencent/mobileqq/text/AppleEmojiManager:c	Ljava/lang/String;
    //   493: invokevirtual 384	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;)V
    //   496: aconst_null
    //   497: areturn
    //   498: astore_3
    //   499: aconst_null
    //   500: astore_2
    //   501: aload_2
    //   502: astore_0
    //   503: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   506: ifeq +15 -> 521
    //   509: aload_2
    //   510: astore_0
    //   511: ldc 62
    //   513: iconst_2
    //   514: ldc_w 415
    //   517: aload_3
    //   518: invokestatic 417	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   521: aload_2
    //   522: ifnonnull +8 -> 530
    //   525: aload_2
    //   526: astore_0
    //   527: invokestatic 419	com/tencent/mobileqq/text/EmotcationConstants:b	()V
    //   530: aload_2
    //   531: ifnull +12 -> 543
    //   534: invokestatic 344	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   537: getstatic 348	com/tencent/mobileqq/text/AppleEmojiManager:c	Ljava/lang/String;
    //   540: invokevirtual 384	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;)V
    //   543: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   546: ifeq +31 -> 577
    //   549: ldc 62
    //   551: iconst_2
    //   552: invokestatic 409	com/tencent/mobileqq/activity/aio/AIOUtils:a	()Ljava/lang/StringBuilder;
    //   555: ldc_w 411
    //   558: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: iload_1
    //   562: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   565: ldc_w 421
    //   568: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   577: aconst_null
    //   578: areturn
    //   579: astore_2
    //   580: aconst_null
    //   581: astore_0
    //   582: aload_0
    //   583: ifnull +12 -> 595
    //   586: invokestatic 344	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   589: getstatic 348	com/tencent/mobileqq/text/AppleEmojiManager:c	Ljava/lang/String;
    //   592: invokevirtual 384	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;)V
    //   595: aload_2
    //   596: athrow
    //   597: astore_2
    //   598: goto -16 -> 582
    //   601: astore_3
    //   602: goto -101 -> 501
    //   605: iload 5
    //   607: iflt -382 -> 225
    //   610: iload 5
    //   612: sipush 4096
    //   615: if_icmple -347 -> 268
    //   618: goto -393 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	621	0	paramResources	Resources
    //   0	621	1	paramInt	int
    //   71	460	2	localObject1	Object
    //   579	17	2	localObject2	Object
    //   597	1	2	localObject3	Object
    //   157	325	3	localObject4	Object
    //   498	20	3	localThrowable1	Throwable
    //   601	1	3	localThrowable2	Throwable
    //   52	319	4	str	String
    //   174	442	5	i	int
    //   138	6	6	l	long
    // Exception table:
    //   from	to	target	type
    //   122	132	498	java/lang/Throwable
    //   122	132	579	finally
    //   142	148	597	finally
    //   150	158	597	finally
    //   160	168	597	finally
    //   170	176	597	finally
    //   178	185	597	finally
    //   187	193	597	finally
    //   195	222	597	finally
    //   227	253	597	finally
    //   270	280	597	finally
    //   282	296	597	finally
    //   298	304	597	finally
    //   306	312	597	finally
    //   314	341	597	finally
    //   348	357	597	finally
    //   359	365	597	finally
    //   367	392	597	finally
    //   394	400	597	finally
    //   402	428	597	finally
    //   430	436	597	finally
    //   438	466	597	finally
    //   503	509	597	finally
    //   511	521	597	finally
    //   527	530	597	finally
    //   142	148	601	java/lang/Throwable
    //   150	158	601	java/lang/Throwable
    //   160	168	601	java/lang/Throwable
    //   170	176	601	java/lang/Throwable
    //   178	185	601	java/lang/Throwable
    //   187	193	601	java/lang/Throwable
    //   195	222	601	java/lang/Throwable
    //   227	253	601	java/lang/Throwable
    //   270	280	601	java/lang/Throwable
    //   282	296	601	java/lang/Throwable
    //   298	304	601	java/lang/Throwable
    //   306	312	601	java/lang/Throwable
    //   314	341	601	java/lang/Throwable
    //   348	357	601	java/lang/Throwable
    //   359	365	601	java/lang/Throwable
    //   367	392	601	java/lang/Throwable
    //   394	400	601	java/lang/Throwable
    //   402	428	601	java/lang/Throwable
    //   430	436	601	java/lang/Throwable
    //   438	466	601	java/lang/Throwable
  }
  
  public static final String b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= EmotcationConstants.jdField_b_of_type_Int)) {
      throw new IllegalArgumentException("invaid sys emotcation index: " + paramInt);
    }
    return String.valueOf(new char[] { '\024', (char)paramInt });
  }
  
  public static String b(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      localObject1 = "";
    }
    do
    {
      return (String)localObject1;
      localObject1 = paramString;
    } while (!a(paramString));
    Object localObject1 = BaseApplicationImpl.getContext();
    int i;
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    }
    StringBuilder localStringBuilder;
    int j;
    int k;
    label239:
    Object localObject3;
    label244:
    label297:
    String str;
    for (;;)
    {
      localObject1 = ((BaseApplication)localObject1).getSharedPreferences("Last_Login", i).getString("uin", "");
      try
      {
        localObject1 = (AppInterface)BaseApplicationImpl.a().getAppRuntime((String)localObject1);
        if (localObject1 == null) {}
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        for (;;)
        {
          try
          {
            if ((localObject1 instanceof NearbyAppInterface)) {
              break label239;
            }
            localObject1 = (EmoticonManager)((AppInterface)localObject1).getManager(13);
            localStringBuilder = new StringBuilder(paramString);
            i = 0;
            if (i >= localStringBuilder.length()) {
              break label481;
            }
            j = i;
            if (localStringBuilder.codePointAt(i) == 20)
            {
              j = i;
              if (i < localStringBuilder.length() - 1)
              {
                k = localStringBuilder.charAt(i + 1);
                if ((k >= EmotcationConstants.jdField_b_of_type_Int) && (250 != k)) {
                  break label244;
                }
                j = k;
                if (250 == k) {
                  j = 10;
                }
                paramString = EmotcationConstants.jdField_a_of_type_ArrayOfJavaLangString[j];
                localStringBuilder.replace(i, i + 2, paramString);
                j = i + (paramString.length() - 1);
              }
            }
            i = j + 1;
            continue;
            i = 0;
          }
          catch (Throwable localThrowable)
          {
            Object localObject2;
            localThrowable.printStackTrace();
          }
          localAccountNotMatchException = localAccountNotMatchException;
          localAccountNotMatchException.printStackTrace();
          localObject2 = null;
          continue;
          localObject3 = null;
          continue;
          j = i;
          if (k == 255)
          {
            if (i + 4 < localStringBuilder.length()) {
              break label297;
            }
            localStringBuilder.replace(i, localStringBuilder.length(), "[小表情]");
            i += "[小表情]".length() - 1;
          }
        }
        paramString = new char[4];
        paramString[0] = localStringBuilder.charAt(i + 4);
        paramString[1] = localStringBuilder.charAt(i + 3);
        paramString[2] = localStringBuilder.charAt(i + 2);
        paramString[3] = localStringBuilder.charAt(i + 1);
        j = 0;
        if (j < 3)
        {
          if (paramString[j] == 'ú') {
            paramString[j] = 10;
          }
          for (;;)
          {
            j += 1;
            break;
            if (paramString[j] == 'þ') {
              paramString[j] = 13;
            }
          }
        }
        paramString = EmosmUtils.a(paramString);
        str = "[小表情]";
        if (paramString == null) {
          break label491;
        }
      }
    }
    if (paramString.length == 2)
    {
      k = paramString[0];
      j = paramString[1];
    }
    for (;;)
    {
      if (localObject3 != null) {}
      for (paramString = ((EmoticonManager)localObject3).a(Integer.toString(k), Integer.toString(j));; paramString = null)
      {
        if (paramString != null) {
          str = paramString.character;
        }
        localStringBuilder.replace(i, i + 5, str);
        j = i + (str.length() - 1);
        break;
        label481:
        return localStringBuilder.toString();
      }
      label491:
      j = 0;
      k = 0;
    }
  }
  
  public static final String c(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= EmotcationConstants.jdField_b_of_type_Int)) {
      throw new IllegalArgumentException("invaid sys emotcation index: " + paramInt);
    }
    return EmotcationConstants.jdField_a_of_type_ArrayOfJavaLangString[paramInt];
  }
  
  public static String c(String paramString)
  {
    Object localObject;
    if (android.text.TextUtils.isEmpty(paramString)) {
      localObject = "";
    }
    int i;
    int j;
    do
    {
      return (String)localObject;
      i = 0;
      while (i < EmotcationConstants.c.length)
      {
        j = paramString.indexOf(EmotcationConstants.c[i], 0);
        localObject = paramString;
        if (j != -1)
        {
          localObject = paramString;
          if (j + 2 <= paramString.length())
          {
            localObject = EmotcationConstants.a(i);
            localObject = paramString.replace(paramString.substring(j, j + 2), (CharSequence)localObject);
          }
        }
        i += 1;
        paramString = (String)localObject;
      }
      localObject = paramString;
    } while (!a(paramString));
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    paramString = BaseApplicationImpl.getContext();
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    }
    for (;;)
    {
      paramString = paramString.getSharedPreferences("Last_Login", i).getString("uin", "");
      try
      {
        paramString = (AppInterface)BaseApplicationImpl.a().getAppRuntime(paramString);
        if (paramString == null) {}
      }
      catch (AccountNotMatchException paramString)
      {
        for (;;)
        {
          try
          {
            if ((paramString instanceof NearbyAppInterface)) {
              break label340;
            }
            paramString = (EmoticonManager)paramString.getManager(13);
            k = 0;
            i = 0;
            if (i >= localStringBuilder.length()) {
              break label588;
            }
            if ((localStringBuilder.codePointAt(i) != 20) || (i >= localStringBuilder.length() - 1)) {
              break label582;
            }
            m = localStringBuilder.charAt(i + 1);
            if (m >= EmotcationConstants.jdField_b_of_type_Int) {
              break label345;
            }
            localObject = EmotcationConstants.jdField_a_of_type_ArrayOfJavaLangString[m];
            if (k != 0) {
              break label607;
            }
            localObject = "表情" + (String)localObject;
            localStringBuilder.replace(i, i + 2, (String)localObject);
            j = i + (((String)localObject).length() - 1);
            k = 1;
            i = j;
            j = k;
            i += 1;
            k = j;
            continue;
            i = 0;
          }
          catch (Throwable paramString)
          {
            paramString.printStackTrace();
          }
          paramString = paramString;
          paramString.printStackTrace();
          paramString = null;
        }
      }
      catch (ClassCastException paramString)
      {
        label296:
        label340:
        label345:
        label582:
        label588:
        label607:
        for (;;)
        {
          int k;
          int m;
          paramString.printStackTrace();
          paramString = null;
          continue;
          paramString = null;
          continue;
          j = i;
          if (m == 255) {
            if (i + 4 >= localStringBuilder.length())
            {
              localStringBuilder.replace(i, localStringBuilder.length(), "[小表情]");
              i += "[小表情]".length() - 1;
            }
            else
            {
              localObject = new char[4];
              localObject[0] = localStringBuilder.charAt(i + 4);
              localObject[1] = localStringBuilder.charAt(i + 3);
              localObject[2] = localStringBuilder.charAt(i + 2);
              localObject[3] = localStringBuilder.charAt(i + 1);
              j = 0;
              if (j < 3)
              {
                if (localObject[j] == 'ú') {
                  localObject[j] = 10;
                }
                for (;;)
                {
                  j += 1;
                  break;
                  if (localObject[j] == 'þ') {
                    localObject[j] = 13;
                  }
                }
              }
              localObject = EmosmUtils.a((char[])localObject);
              String str = "[小表情]";
              if ((localObject != null) && (localObject.length == 2))
              {
                k = localObject[0];
                j = localObject[1];
              }
              for (;;)
              {
                if (paramString != null) {}
                for (localObject = paramString.a(Integer.toString(k), Integer.toString(j));; localObject = null)
                {
                  if (localObject != null) {
                    str = ((Emoticon)localObject).character;
                  }
                  localStringBuilder.replace(i, i + 5, str);
                  j = i + (str.length() - 1);
                  break;
                  j = 0;
                  break label296;
                  return localStringBuilder.toString();
                }
                j = 0;
                k = 0;
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\text\TextUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */