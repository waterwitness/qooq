package com.tencent.av.mediacodec.config;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.config.ConfigBaseParser;
import com.tencent.av.utils.ArrayUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class CodecConfigParser
  extends ConfigBaseParser
{
  public static String A = c + g + j;
  public static String B = d + f + h;
  public static String C = d + g + i;
  public static String D = d + g + k;
  public static String E = d + g + l;
  public static String F = d + g + j;
  public static String G = b + o + p;
  public static String H = b + o + q;
  public static final int a = 0;
  static final String a = "CodecConfigParser";
  public static final int b = 1;
  public static String b;
  public static final int c = 2;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static String i;
  public static String j;
  public static String k;
  public static String l;
  public static String m;
  public static String n;
  public static String o;
  public static String p;
  public static String q;
  public static String r;
  public static String s;
  public static String t;
  public static String u;
  public static String v;
  public static String w;
  public static String x;
  public static String y;
  public static String z;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    b = "sharp/hwcodec_new/";
    c = b + "avc_decoder/";
    d = b + "avc_encoder/";
    e = b + "test/";
    f = "white_list/";
    g = "black_list/";
    h = "min_sdk";
    i = "model";
    j = "sdk";
    k = "product";
    l = "fingerprint";
    m = "codec";
    n = "disable_sdk";
    o = "async/";
    p = "min_sdk";
    q = "codec";
    r = "async_min_sdk";
    s = e + h;
    t = e + n;
    u = e + m;
    v = e + r;
    w = c + f + h;
    x = c + g + i;
    y = c + g + k;
    z = c + g + l;
  }
  
  public CodecConfigParser(String paramString)
  {
    super(paramString);
  }
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CodecConfigParser", 2, "getAVCDecoderTestFlag sdk: " + Build.VERSION.SDK_INT);
    }
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      return 0;
      try
      {
        int[] arrayOfInt = a(u);
        if ((arrayOfInt != null) && ((arrayOfInt[0] & 0x1) == 1))
        {
          arrayOfInt = a(s);
          if ((arrayOfInt != null) && (Build.VERSION.SDK_INT >= arrayOfInt[0]) && (!ArrayUtils.a(a(t), Build.VERSION.SDK_INT)))
          {
            arrayOfInt = a(v);
            if ((Build.VERSION.SDK_INT >= 21) && (arrayOfInt != null))
            {
              int i1 = Build.VERSION.SDK_INT;
              int i2 = arrayOfInt[0];
              if (i1 >= i2) {
                return 2;
              }
            }
            return 1;
          }
        }
      }
      catch (Exception localException) {}
    }
    return 0;
  }
  
  public boolean a()
  {
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject = a(w);
        if ((localObject != null) && (Build.VERSION.SDK_INT >= localObject[0]))
        {
          localObject = a(A);
          int i1;
          if (localObject != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= localObject.length) {
                break label67;
              }
              if (Build.VERSION.SDK_INT == localObject[i1]) {
                break;
              }
              i1 += 1;
            }
          }
          label67:
          localObject = a(x);
          if (localObject != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= localObject.length) {
                break label106;
              }
              if (Build.MODEL.equalsIgnoreCase(localObject[i1])) {
                break;
              }
              i1 += 1;
            }
          }
          label106:
          localObject = a(y);
          if (localObject != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= localObject.length) {
                break label145;
              }
              if (Build.PRODUCT.equalsIgnoreCase(localObject[i1])) {
                break;
              }
              i1 += 1;
            }
          }
          label145:
          localObject = a(z);
          if (localObject != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= localObject.length) {
                break label186;
              }
              boolean bool = Build.PRODUCT.equalsIgnoreCase(localObject[i1]);
              if (bool) {
                break;
              }
              i1 += 1;
            }
          }
          label186:
          return true;
        }
      }
      catch (Exception localException) {}
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    try
    {
      int[] arrayOfInt = a(G);
      if (arrayOfInt == null) {
        return false;
      }
      if ((Build.VERSION.SDK_INT >= 21) && (Build.VERSION.SDK_INT >= arrayOfInt[0]))
      {
        arrayOfInt = a(H);
        if (arrayOfInt != null)
        {
          boolean bool = ArrayUtils.a(arrayOfInt, paramInt);
          if (bool) {
            return true;
          }
        }
      }
    }
    catch (Exception localException) {}
    return false;
  }
  
  public int[] a(String paramString)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return null;
    }
    return super.a(paramString);
  }
  
  public String[] a(String paramString)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return null;
    }
    return super.a(paramString);
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CodecConfigParser", 2, "getAVCEncoderTestFlag sdk: " + Build.VERSION.SDK_INT);
    }
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      return 0;
      try
      {
        int[] arrayOfInt = a(u);
        if ((arrayOfInt != null) && ((arrayOfInt[0] & 0x2) == 2))
        {
          arrayOfInt = a(s);
          if ((arrayOfInt != null) && (Build.VERSION.SDK_INT >= arrayOfInt[0]) && (!ArrayUtils.a(a(t), Build.VERSION.SDK_INT)))
          {
            arrayOfInt = a(v);
            if ((Build.VERSION.SDK_INT >= 21) && (arrayOfInt != null))
            {
              int i1 = Build.VERSION.SDK_INT;
              int i2 = arrayOfInt[0];
              if (i1 >= i2) {
                return 2;
              }
            }
            return 1;
          }
        }
      }
      catch (Exception localException) {}
    }
    return 0;
  }
  
  public boolean b()
  {
    if (Build.VERSION.SDK_INT < 19) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject = a(B);
        if ((localObject != null) && (Build.VERSION.SDK_INT >= localObject[0]))
        {
          localObject = a(F);
          int i1;
          if (localObject != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= localObject.length) {
                break label67;
              }
              if (Build.VERSION.SDK_INT == localObject[i1]) {
                break;
              }
              i1 += 1;
            }
          }
          label67:
          localObject = a(C);
          if (localObject != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= localObject.length) {
                break label106;
              }
              if (Build.MODEL.equalsIgnoreCase(localObject[i1])) {
                break;
              }
              i1 += 1;
            }
          }
          label106:
          localObject = a(D);
          if (localObject != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= localObject.length) {
                break label145;
              }
              if (Build.PRODUCT.equalsIgnoreCase(localObject[i1])) {
                break;
              }
              i1 += 1;
            }
          }
          label145:
          localObject = a(E);
          if (localObject != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= localObject.length) {
                break label186;
              }
              boolean bool = Build.PRODUCT.equalsIgnoreCase(localObject[i1]);
              if (bool) {
                break;
              }
              i1 += 1;
            }
          }
          label186:
          return true;
        }
      }
      catch (Exception localException) {}
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\mediacodec\config\CodecConfigParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */