package com.tencent.mobileqq.shortvideo.mediadevice;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

public class CodecParam
{
  public static final int A = 7;
  public static final int B = 44100;
  public static int C = 16000;
  public static int D = 450000;
  public static int E = 100000;
  public static int F = 31;
  public static int G = 1;
  public static int H = 3;
  public static int I = 1;
  public static int J = 1;
  public static int K = 1000;
  public static int L = 1;
  public static int M = 0;
  public static int N = 0;
  public static int O = 0;
  public static int P = 0;
  public static int Q = 65537;
  public static int R = 0;
  private static int S = 0;
  public static final int a = 65537;
  public static int b = 0;
  public static int c = 0;
  public static int d = 0;
  public static int e = 0;
  public static int f = 0;
  public static int g = 0;
  public static int h = 0;
  public static int i = 0;
  public static int j = 0;
  public static int k = 0;
  public static int l = 0;
  public static int m = 0;
  public static int n = 0;
  public static int o = 0;
  public static int p = 0;
  public static final int q = 8000;
  public static final int r = 16000;
  public static final int s = 15;
  public static final int t = 0;
  public static final int u = 1;
  public static final int v = 2;
  public static final int w = 3;
  public static final int x = 4;
  public static final int y = 5;
  public static final int z = 6;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    b = 1;
    d = 8000;
    e = 2000;
    f = 500000;
    g = 30;
    h = 2;
    i = 3;
    j = 480;
    k = 360;
    l = 320;
    m = 240;
    n = 64000;
    o = 16;
    p = 2;
  }
  
  public static void a()
  {
    N = 0;
    O = 0;
    P = 0;
    Q = 65537;
  }
  
  public static void a(long paramLong)
  {
    N = 1;
    O = (int)(paramLong & 0xFFFFFFFFFFFFFFFF);
    P = (int)(paramLong >>> 32 & 0xFFFFFFFFFFFFFFFF);
  }
  
  public static void a(short paramShort1, short paramShort2)
  {
    Q = (paramShort1 & 0xFFFF) << 16 | 0xFFFF & paramShort2;
  }
  
  public static void a(boolean paramBoolean)
  {
    S = 0;
    if (paramBoolean) {
      S = 1;
    }
  }
  
  public static boolean a(int[] paramArrayOfInt, int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {}
    while ((paramArrayOfInt == null) || (paramArrayOfInt.length < 16)) {
      return false;
    }
    paramArrayOfInt[15] = paramInt;
    return true;
  }
  
  public static int[] a()
  {
    if (VideoEnvironment.b(5)) {
      return new int[] { D, E, F, G, H, I, J, K, L, M, N, O, P, Q, S, R };
    }
    return new int[] { D, E, F, G, H, I, J, K, L };
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\mediadevice\CodecParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */