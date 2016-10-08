package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.List;

public class PokeItemHelper
{
  public static int a = 0;
  public static long a = 0L;
  public static String a;
  private static boolean a = false;
  public static int b = 0;
  private static String b;
  public static int c = 0;
  public static final int d = 15;
  public static int e = -1;
  public static int f = -1;
  public static int g = 10;
  public static int h = 60;
  public static int i = -1;
  public static int j = -1;
  public static int k = 10;
  public static int l = 60;
  public static final int m = 1;
  public static final int n = 0;
  public static final int o = 2;
  public static final int p = 3;
  private static int q;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "PokeItemHelper";
    jdField_b_of_type_Int = 10;
    c = 60;
    q = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().densityDpi;
    jdField_b_of_type_JavaLangString = "";
  }
  
  public static int a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface != null)
    {
      String str = paramQQAppInterface.getAccount();
      if ((!jdField_a_of_type_Boolean) || (!jdField_b_of_type_JavaLangString.equals(str)))
      {
        paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.a());
        if (paramQQAppInterface.contains(str + "_" + "poke_bar_config_version"))
        {
          e = paramQQAppInterface.getInt(str + "_" + "poke_bar_switch", i);
          f = paramQQAppInterface.getInt(str + "_" + "poke_pad_switch", j);
          h = paramQQAppInterface.getInt(str + "_" + "aio_poke_unittime", l);
          g = paramQQAppInterface.getInt(str + "_" + "aio_poke_unitcount", k);
        }
        jdField_b_of_type_JavaLangString = str;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("msgFold", 2, String.format("getPokeSwitch, first init, bad switch: %d, pad switch: %d, uin: %s ,limited count:%d,limited time:%d", new Object[] { Integer.valueOf(e), Integer.valueOf(f), jdField_b_of_type_JavaLangString, Integer.valueOf(g), Integer.valueOf(h) }));
    }
    jdField_a_of_type_Boolean = true;
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return e;
    case 0: 
      return f;
    case 2: 
      return g;
    }
    return h;
  }
  
  public static Drawable a(int paramInt)
  {
    Drawable localDrawable2 = (Drawable)BaseApplicationImpl.a.get("chat_item_for_poke" + paramInt);
    Drawable localDrawable1 = localDrawable2;
    if (localDrawable2 == null)
    {
      localDrawable1 = BaseApplicationImpl.getContext().getResources().getDrawable(2130838528 + paramInt);
      BaseApplicationImpl.a.put("chat_item_for_poke" + paramInt, localDrawable1);
    }
    return localDrawable1;
  }
  
  public static Drawable a(Bitmap paramBitmap)
  {
    int i1 = paramBitmap.getWidth();
    int i2 = paramBitmap.getHeight();
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(-1.0F, 1.0F);
    try
    {
      paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i1, i2, localMatrix, true);
      if ((QLog.isColorLevel()) && (paramBitmap != null)) {
        Log.d("test", "convertBmp w=" + paramBitmap.getWidth());
      }
      paramBitmap = new BitmapDrawable(paramBitmap);
      ((BitmapDrawable)paramBitmap).setTargetDensity(q);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "get pokeFriendPokeImage oom" + paramBitmap);
        }
        paramBitmap = null;
      }
    }
  }
  
  public static void a()
  {
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_Long = 0L;
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    jdField_a_of_type_Boolean = true;
    f = paramInt1;
    f = paramInt2;
    g = paramInt3;
    h = paramInt4;
  }
  
  public static boolean a(long paramLong)
  {
    boolean bool2 = true;
    if (jdField_a_of_type_Int == 0) {
      jdField_a_of_type_Long = System.currentTimeMillis();
    }
    jdField_a_of_type_Int += 1;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isCanSendPoke mSendCount=" + jdField_a_of_type_Int);
    }
    boolean bool1 = bool2;
    if (jdField_a_of_type_Int >= jdField_b_of_type_Int + 1)
    {
      paramLong = System.currentTimeMillis();
      long l1 = paramLong - jdField_a_of_type_Long;
      if (l1 <= c) {
        break label174;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isCanSendPoke diff=" + l1);
      }
      jdField_a_of_type_Int = 1;
      jdField_a_of_type_Long = paramLong;
    }
    label174:
    for (bool1 = bool2;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isCanSendPoke isCansend=" + bool1);
      }
      return bool1;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    long l1 = MessageCache.a();
    paramSessionInfo = paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
    int i1;
    MessageRecord localMessageRecord;
    boolean bool;
    if ((paramSessionInfo != null) && (paramSessionInfo.size() > 0))
    {
      int i2 = paramSessionInfo.size() - 1;
      i1 = 0;
      for (;;)
      {
        if (i2 >= 0)
        {
          localMessageRecord = (MessageRecord)paramSessionInfo.get(i2);
          if (!localMessageRecord.isSend()) {
            i2 -= 1;
          } else if (l1 - localMessageRecord.time > a(paramQQAppInterface, 3)) {
            bool = true;
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isCanSendPoke, isCansend= " + bool);
      }
      return bool;
      if ((localMessageRecord instanceof MessageForPoke))
      {
        int i3 = i1 + 1;
        i1 = i3;
        if (i3 < a(paramQQAppInterface, 2)) {
          break;
        }
        bool = false;
        continue;
      }
      break;
      bool = true;
    }
  }
  
  public static Drawable[] a()
  {
    Drawable[] arrayOfDrawable = new Drawable[15];
    int i1 = 0;
    while (i1 < 15)
    {
      arrayOfDrawable[i1] = a(i1);
      i1 += 1;
    }
    return arrayOfDrawable;
  }
  
  public static Drawable b(int paramInt)
  {
    Drawable localDrawable2 = (Drawable)BaseApplicationImpl.a.get("chat_item_for_friend_poke" + paramInt);
    Drawable localDrawable1 = localDrawable2;
    Object localObject;
    if (localDrawable2 == null)
    {
      localObject = a(paramInt);
      if (!(localObject instanceof BitmapDrawable)) {
        break label69;
      }
      localObject = ((BitmapDrawable)localObject).getBitmap();
    }
    for (;;)
    {
      localDrawable1 = localDrawable2;
      if (localObject != null) {
        localDrawable1 = a((Bitmap)localObject);
      }
      return localDrawable1;
      label69:
      if ((localObject instanceof SkinnableBitmapDrawable)) {
        localObject = ((SkinnableBitmapDrawable)localObject).getBitmap();
      } else {
        localObject = null;
      }
    }
  }
  
  public static Drawable[] b()
  {
    Drawable[] arrayOfDrawable = new Drawable[15];
    int i1 = 0;
    while (i1 < 15)
    {
      arrayOfDrawable[i1] = b(i1);
      i1 += 1;
    }
    return arrayOfDrawable;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\PokeItemHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */