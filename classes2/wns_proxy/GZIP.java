package wns_proxy;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class GZIP
{
  private static final int jdField_a_of_type_Int = 1;
  private static byte[] jdField_a_of_type_ArrayOfByte;
  private static short[] jdField_a_of_type_ArrayOfShort;
  private static final int jdField_b_of_type_Int = 2;
  private static byte[] jdField_b_of_type_ArrayOfByte;
  private static short[] jdField_b_of_type_ArrayOfShort;
  private static final int jdField_c_of_type_Int = 4;
  private static byte[] jdField_c_of_type_ArrayOfByte;
  private static final int jdField_d_of_type_Int = 8;
  private static byte[] jdField_d_of_type_ArrayOfByte;
  private static final int jdField_e_of_type_Int = 16;
  private static byte[] jdField_e_of_type_ArrayOfByte;
  private static final int f = 0;
  private static final int g = 1;
  private static final int h = 2;
  private static final int i = 3;
  private static final int j = 16;
  private static final int k = 287;
  private static final int l = 31;
  private static final int m = 18;
  private static final int n = 256;
  private static int o;
  private static int p;
  private static int q;
  private static int r;
  
  public GZIP()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static int a(int paramInt)
  {
    byte[] arrayOfByte;
    int i1;
    if (q == 0)
    {
      arrayOfByte = jdField_a_of_type_ArrayOfByte;
      i1 = o;
      o = i1 + 1;
      i1 = arrayOfByte[i1] & 0xFF;
      p = i1;
    }
    int i2;
    for (;;)
    {
      i2 = q;
      int i3 = 8 - i2;
      i2 = i1;
      i1 = i3;
      while (i1 < paramInt)
      {
        arrayOfByte = jdField_a_of_type_ArrayOfByte;
        i3 = o;
        o = i3 + 1;
        p = arrayOfByte[i3] & 0xFF;
        i2 |= p << i1;
        i1 += 8;
      }
      i1 = p >> q;
    }
    q = q + paramInt & 0x7;
    return (1 << paramInt) - 1 & i2;
  }
  
  private static int a(int[] paramArrayOfInt)
  {
    int i1 = paramArrayOfInt[0];
    if (i1 >= 0)
    {
      if (q == 0)
      {
        byte[] arrayOfByte = jdField_a_of_type_ArrayOfByte;
        int i2 = o;
        o = i2 + 1;
        p = arrayOfByte[i2] & 0xFF;
      }
      if ((p & 1 << q) == 0) {}
      for (i1 = paramArrayOfInt[(i1 >> 16)];; i1 = paramArrayOfInt[(i1 & 0xFFFF)])
      {
        q = q + 1 & 0x7;
        break;
      }
    }
    return i1 & 0xFFFF;
  }
  
  public static DataInputStream a(byte[] paramArrayOfByte)
  {
    return new DataInputStream(new ByteArrayInputStream(a(paramArrayOfByte)));
  }
  
  private static void a()
  {
    q = 0;
    int i1 = a(16);
    a(16);
    System.arraycopy(jdField_a_of_type_ArrayOfByte, o, jdField_b_of_type_ArrayOfByte, r, i1);
    o += i1;
    r = i1 + r;
  }
  
  private static void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    for (;;)
    {
      int i1 = a(paramArrayOfInt1);
      if (i1 == 256) {
        break;
      }
      if (i1 > 256)
      {
        i1 -= 257;
        i2 = jdField_a_of_type_ArrayOfShort[i1];
        int i3 = c[i1];
        i1 = i2;
        if (i3 > 0) {
          i1 = i2 + a(i3);
        }
        i2 = a(paramArrayOfInt2);
        i3 = jdField_b_of_type_ArrayOfShort[i2];
        int i4 = d[i2];
        i2 = i3;
        if (i4 > 0) {
          i2 = i3 + a(i4);
        }
        i4 = r;
        i3 = 0;
        while (i3 < i1)
        {
          arrayOfByte = jdField_b_of_type_ArrayOfByte;
          int i5 = r;
          r = i5 + 1;
          arrayOfByte[i5] = jdField_b_of_type_ArrayOfByte[(i4 - i2 + i3)];
          i3 += 1;
        }
      }
      byte[] arrayOfByte = jdField_b_of_type_ArrayOfByte;
      int i2 = r;
      r = i2 + 1;
      arrayOfByte[i2] = ((byte)i1);
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    return b(paramArrayOfByte, 0);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    return b(paramArrayOfByte, paramInt);
  }
  
  private static byte[] a(int[] paramArrayOfInt, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i2 = 0;
    int i1 = 0;
    if (i1 < paramInt)
    {
      int i5 = a(paramArrayOfInt);
      if (i5 >= 16)
      {
        int i3;
        int i4;
        if (i5 == 16)
        {
          i3 = a(2);
          i4 = i3 + 3;
          i3 = i2;
          for (;;)
          {
            i5 = i3;
            i2 = i1;
            if (i4 <= 0) {
              break;
            }
            arrayOfByte[i1] = ((byte)i3);
            i1 += 1;
            i4 -= 1;
          }
        }
        if (i5 == 17) {}
        for (i2 = a(3) + 3;; i2 = a(7) + 11)
        {
          i3 = 0;
          i4 = i2;
          break;
        }
      }
      if (i5 != 0)
      {
        i2 = i1 + 1;
        arrayOfByte[i1] = ((byte)i5);
      }
      for (;;)
      {
        i1 = i2;
        i2 = i5;
        break;
        i2 = i1 + 1;
      }
    }
    return arrayOfByte;
  }
  
  private static int[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int[] arrayOfInt2 = new int[17];
    int i1 = 0;
    while (i1 < paramArrayOfByte.length)
    {
      i2 = paramArrayOfByte[i1];
      arrayOfInt2[i2] += 1;
      i1 += 1;
    }
    arrayOfInt2[0] = 0;
    int[] arrayOfInt1 = new int[17];
    i1 = 1;
    int i2 = 0;
    while (i1 <= 16)
    {
      i2 = i2 + arrayOfInt2[(i1 - 1)] << 1;
      arrayOfInt1[i1] = i2;
      i1 += 1;
    }
    arrayOfInt2 = new int[(paramInt << 1) + 16];
    int i3 = 0;
    for (i1 = 1; i3 <= paramInt; i1 = i2)
    {
      int i4 = paramArrayOfByte[i3];
      i2 = i1;
      if (i4 != 0)
      {
        int i6 = arrayOfInt1[i4];
        arrayOfInt1[i4] = (i6 + 1);
        i4 -= 1;
        i2 = 0;
        if (i4 >= 0)
        {
          int i5;
          if ((1 << i4 & i6) == 0)
          {
            i5 = arrayOfInt2[i2] >> 16;
            if (i5 == 0)
            {
              arrayOfInt2[i2] |= i1 << 16;
              i2 = i1 + 1;
            }
          }
          for (;;)
          {
            i4 -= 1;
            i5 = i1;
            i1 = i2;
            i2 = i5;
            break;
            i2 = i1;
            i1 = i5;
            continue;
            i5 = arrayOfInt2[i2] & 0xFFFF;
            if (i5 == 0)
            {
              arrayOfInt2[i2] |= i1;
              i2 = i1 + 1;
            }
            else
            {
              i2 = i1;
              i1 = i5;
            }
          }
        }
        arrayOfInt2[i2] = (0x80000000 | i3);
        i2 = i1;
      }
      i3 += 1;
    }
    return arrayOfInt2;
  }
  
  private static void b()
  {
    int i4 = 280;
    int i5 = 256;
    int i6 = 144;
    int i3 = 0;
    Object localObject = new byte['Ġ'];
    int i2 = 0;
    for (;;)
    {
      i1 = i6;
      if (i2 >= 144) {
        break;
      }
      localObject[i2] = 8;
      i2 += 1;
    }
    for (;;)
    {
      i2 = i5;
      if (i1 >= 256) {
        break;
      }
      localObject[i1] = 9;
      i1 += 1;
    }
    for (;;)
    {
      i1 = i4;
      if (i2 >= 280) {
        break;
      }
      localObject[i2] = 7;
      i2 += 1;
    }
    while (i1 < 288)
    {
      localObject[i1] = 8;
      i1 += 1;
    }
    localObject = a((byte[])localObject, 287);
    byte[] arrayOfByte = new byte[32];
    int i1 = i3;
    while (i1 < arrayOfByte.length)
    {
      arrayOfByte[i1] = 5;
      i1 += 1;
    }
    a((int[])localObject, a(arrayOfByte, 31));
  }
  
  private static byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      o += paramInt;
      if ((a(16) != 35615) || (a(8) != 8)) {
        throw new IOException("Invalid GZIP format");
      }
    }
    finally
    {
      try
      {
        r = 0;
        q = 0;
        p = 0;
        o = 0;
        e = null;
        d = null;
        c = null;
        jdField_b_of_type_ArrayOfByte = null;
        jdField_a_of_type_ArrayOfByte = null;
        jdField_b_of_type_ArrayOfShort = null;
        jdField_a_of_type_ArrayOfShort = null;
        throw paramArrayOfByte;
      }
      finally {}
      paramInt = a(8);
      o += 6;
      if ((paramInt & 0x4) != 0) {
        o += a(16);
      }
      int i1;
      do
      {
        if ((paramInt & 0x8) == 0) {
          break;
        }
        paramArrayOfByte = jdField_a_of_type_ArrayOfByte;
        i1 = o;
        o = i1 + 1;
      } while (paramArrayOfByte[i1] != 0);
      do
      {
        if ((paramInt & 0x10) == 0) {
          break;
        }
        paramArrayOfByte = jdField_a_of_type_ArrayOfByte;
        i1 = o;
        o = i1 + 1;
      } while (paramArrayOfByte[i1] != 0);
      if ((paramInt & 0x2) != 0) {
        o += 2;
      }
      paramInt = o;
      o = jdField_a_of_type_ArrayOfByte.length - 4;
      jdField_b_of_type_ArrayOfByte = new byte[a(16) | a(16) << 16];
      o = paramInt;
      c = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 0, 99, 99 };
      jdField_a_of_type_ArrayOfShort = new short[] { 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 15, 17, 19, 23, 27, 31, 35, 43, 51, 59, 67, 83, 99, 115, 131, 163, 195, 227, 258, 0, 0 };
      d = new byte[] { 0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 13 };
      jdField_b_of_type_ArrayOfShort = new short[] { 1, 2, 3, 4, 5, 7, 9, 13, 17, 25, 33, 49, 65, 97, 129, 193, 257, 385, 513, 769, 1025, 1537, 2049, 3073, 4097, 6145, 8193, 12289, 16385, 24577 };
      e = new byte[] { 16, 17, 18, 0, 8, 7, 9, 6, 10, 5, 11, 4, 12, 3, 13, 2, 14, 1, 15 };
      for (;;)
      {
        paramInt = a(1);
        i1 = a(2);
        if (i1 == 0) {
          a();
        }
        while (paramInt != 0)
        {
          paramArrayOfByte = jdField_b_of_type_ArrayOfByte;
          r = 0;
          q = 0;
          p = 0;
          o = 0;
          e = null;
          d = null;
          c = null;
          jdField_b_of_type_ArrayOfByte = null;
          jdField_a_of_type_ArrayOfByte = null;
          jdField_b_of_type_ArrayOfShort = null;
          jdField_a_of_type_ArrayOfShort = null;
          return paramArrayOfByte;
          if (i1 != 1) {
            break label1171;
          }
          b();
        }
      }
      label1171:
      if (i1 == 2) {
        c();
      }
    }
  }
  
  private static void c()
  {
    int i2 = a(5) + 257;
    int i3 = a(5) + 1;
    int i4 = a(4);
    Object localObject = new byte[19];
    int i1 = 0;
    while (i1 < i4 + 4)
    {
      localObject[e[i1]] = ((byte)a(3));
      i1 += 1;
    }
    localObject = a((byte[])localObject, 18);
    a(a(a((int[])localObject, i2), i2 - 1), a(a((int[])localObject, i3), i3 - 1));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wns_proxy\GZIP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */