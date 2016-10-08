package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class a
{
  public int a = 11;
  public int b = 0;
  public int c = 5;
  public int d = 0;
  protected int e = 1;
  
  public static int a(byte[] paramArrayOfByte, h paramh)
  {
    Object localObject = b(paramArrayOfByte);
    int i = localObject[0];
    int j = localObject[1];
    if (i == 64527) {}
    int k;
    do
    {
      return i;
      if (j + 1 > paramArrayOfByte.length) {
        return 64527;
      }
      paramh.d = (util.buf_to_int8(paramArrayOfByte, j) & 0xFF);
      k = j + 1;
      if (k + 2 > paramArrayOfByte.length) {
        return 64527;
      }
      j = util.buf_to_int16(paramArrayOfByte, k);
      k += 2;
      if (k + j > paramArrayOfByte.length) {
        return 64527;
      }
      localObject = new byte[j];
      System.arraycopy(paramArrayOfByte, k, localObject, 0, j);
      k += j;
      if (k + 1 > paramArrayOfByte.length) {
        return 64527;
      }
      j = util.buf_to_int8(paramArrayOfByte, k);
      k += 1;
      if (k + j > paramArrayOfByte.length) {
        return 64527;
      }
      paramh.e = new byte[j];
      System.arraycopy(paramArrayOfByte, k, paramh.e, 0, j);
      k += j;
      if (k + 2 > paramArrayOfByte.length) {
        return 64527;
      }
      j = util.buf_to_int16(paramArrayOfByte, k);
      k += 2;
      if (k + j > paramArrayOfByte.length) {
        return 64527;
      }
      paramh.f = new byte[j];
      System.arraycopy(paramArrayOfByte, k, paramh.f, 0, j);
    } while (localObject.length <= 0);
    switch (paramh.d)
    {
    default: 
      util.LOGW("unhandle return code int parse_checkvalid_rsp", "", "");
      return i;
    case 0: 
      if (4 > localObject.length) {
        return 64527;
      }
      paramh.l = util.buf_to_int32((byte[])localObject, 0);
      if (5 > localObject.length) {
        return 64527;
      }
      j = util.buf_to_int8((byte[])localObject, 4);
      if (j + 5 > localObject.length) {
        return 64527;
      }
      paramh.m = new byte[j];
      System.arraycopy(localObject, 5, paramh.m, 0, j);
      return i;
    case 2: 
      if (1 > localObject.length) {
        return 64527;
      }
      j = util.buf_to_int8((byte[])localObject, 0);
      if (j + 1 > localObject.length) {
        return 64527;
      }
      paramh.n = new byte[j];
      System.arraycopy(localObject, 1, paramh.n, 0, j);
      k = j + 1;
      j = k + 1;
      k = util.buf_to_int8((byte[])localObject, k);
      if (j + k > localObject.length) {
        return 64527;
      }
      paramh.o = new byte[k];
      System.arraycopy(localObject, j, paramh.o, 0, k);
      k += j;
      j = util.buf_to_int16((byte[])localObject, k);
      k += 2;
      if (k + j > localObject.length) {
        return 64527;
      }
      paramh.p = new byte[j];
      System.arraycopy(localObject, k, paramh.p, 0, j);
      return i;
    case 3: 
    case 6: 
    case 44: 
      if (2 > localObject.length) {
        return 64527;
      }
      j = util.buf_to_int16((byte[])localObject, 0);
      if (j + 2 > localObject.length) {
        return 64527;
      }
      paramh.q = new byte[j];
      System.arraycopy(localObject, 2, paramh.q, 0, j);
      return i;
    case 4: 
      if (2 > localObject.length) {
        return 64527;
      }
      paramh.r = util.buf_to_int16((byte[])localObject, 0);
      if (4 > localObject.length) {
        return 64527;
      }
      paramh.s = util.buf_to_int16((byte[])localObject, 2);
      return i;
    case 31: 
      paramh.r = 0;
      paramh.s = 0;
      return i;
    }
    if (2 > localObject.length) {
      return 64527;
    }
    paramh.r = util.buf_to_int16((byte[])localObject, 0);
    if (4 > localObject.length) {
      return 64527;
    }
    paramh.s = util.buf_to_int16((byte[])localObject, 2);
    return i;
  }
  
  public static int b(byte[] paramArrayOfByte, h paramh)
  {
    int[] arrayOfInt = b(paramArrayOfByte);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    if (i == 64527) {
      return i;
    }
    if (j + 1 > paramArrayOfByte.length) {
      return 64527;
    }
    paramh.d = util.buf_to_int8(paramArrayOfByte, j);
    int k = j + 1;
    if (k + 1 > paramArrayOfByte.length) {
      return 64527;
    }
    j = util.buf_to_int8(paramArrayOfByte, k);
    k += 1;
    if (k + j > paramArrayOfByte.length) {
      return 64527;
    }
    paramh.e = new byte[j];
    System.arraycopy(paramArrayOfByte, k, paramh.e, 0, j);
    k += j;
    if (k + 2 > paramArrayOfByte.length) {
      return 64527;
    }
    j = util.buf_to_int16(paramArrayOfByte, k);
    k += 2;
    if (k + j > paramArrayOfByte.length) {
      return 64527;
    }
    paramh.f = new byte[j];
    System.arraycopy(paramArrayOfByte, k, paramh.f, 0, j);
    return i;
  }
  
  private static int[] b(byte[] paramArrayOfByte)
  {
    if (1 > paramArrayOfByte.length) {
      return new int[] { 64527, 0 };
    }
    if (3 > paramArrayOfByte.length) {
      return new int[] { 64527, 1 };
    }
    if (util.buf_to_int16(paramArrayOfByte, 1) != paramArrayOfByte.length) {
      return new int[] { 64527, 3 };
    }
    if (7 > paramArrayOfByte.length) {
      return new int[] { 64527, 3 };
    }
    if (8 > paramArrayOfByte.length) {
      return new int[] { 64527, 7 };
    }
    int i = util.buf_to_int8(paramArrayOfByte, 7);
    if (i + 8 > paramArrayOfByte.length) {
      return new int[] { 64527, 8 };
    }
    return new int[] { 0, i + 8 };
  }
  
  public static int c(byte[] paramArrayOfByte, h paramh)
  {
    Object localObject = b(paramArrayOfByte);
    int k = localObject[0];
    int i = localObject[1];
    if (k == 64527) {
      return k;
    }
    if (i + 1 > paramArrayOfByte.length) {
      return 64527;
    }
    paramh.d = util.buf_to_int8(paramArrayOfByte, i);
    int j = i + 1;
    if (j + 1 > paramArrayOfByte.length) {
      return 64527;
    }
    i = util.buf_to_int8(paramArrayOfByte, j);
    j += 1;
    if (j + i > paramArrayOfByte.length) {
      return 64527;
    }
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramArrayOfByte, j, arrayOfByte, 0, i);
    int m = j + i;
    if (paramh.d == 0)
    {
      if ((paramh.j == null) || (paramh.j.length <= 0)) {}
      for (localObject = h.a.getBytes();; localObject = MD5.toMD5Byte(paramh.j))
      {
        localObject = cryptor.decrypt(arrayOfByte, 0, arrayOfByte.length, (byte[])localObject);
        if (localObject != null) {
          break;
        }
        return 64527;
      }
      if (1 > localObject.length) {
        return 64527;
      }
      i = util.buf_to_int8((byte[])localObject, 0);
      if (i + 1 > localObject.length) {
        return 64527;
      }
      i += 1;
      if (i + 8 > localObject.length) {
        return 64527;
      }
      paramh.t = util.buf_to_int64((byte[])localObject, i);
      j = i + 8;
      if (j + 2 > localObject.length) {
        return 64527;
      }
      i = util.buf_to_int16((byte[])localObject, j);
      j += 2;
      if (j + i > localObject.length) {
        return 64527;
      }
      paramh.u = new byte[i];
      System.arraycopy(localObject, j, paramh.u, 0, i);
      i = j + i;
      if (i + 1 > localObject.length) {
        return 64527;
      }
      int n = util.buf_to_int8((byte[])localObject, i);
      j = i + 1;
      i = 0;
      if (i < n)
      {
        if (j + 2 > localObject.length) {
          return 64527;
        }
        int i1 = util.buf_to_int8((byte[])localObject, j);
        int i2 = j + 1;
        j = util.buf_to_int8((byte[])localObject, i2);
        i2 += 1;
        if (i2 + j > localObject.length) {
          return 64527;
        }
        switch (i1)
        {
        }
        for (;;)
        {
          j = i2 + j;
          i += 1;
          break;
          paramh.v = new byte[j];
          System.arraycopy(localObject, i2, paramh.v, 0, j);
          continue;
          arrayOfByte = new byte[j];
          System.arraycopy(localObject, i2, arrayOfByte, 0, j);
          h.x = util.buf_to_int64(arrayOfByte, 0);
        }
      }
    }
    if (m + 1 > paramArrayOfByte.length) {
      return 64527;
    }
    i = util.buf_to_int8(paramArrayOfByte, m);
    j = m + 1;
    if (j + i > paramArrayOfByte.length) {
      return 64527;
    }
    paramh.e = new byte[i];
    System.arraycopy(paramArrayOfByte, j, paramh.e, 0, i);
    j = i + j;
    if (j + 2 > paramArrayOfByte.length) {
      return 64527;
    }
    i = util.buf_to_int16(paramArrayOfByte, j);
    j += 2;
    if (j + i > paramArrayOfByte.length) {
      return 64527;
    }
    paramh.f = new byte[i];
    System.arraycopy(paramArrayOfByte, j, paramh.f, 0, i);
    return k;
  }
  
  public static int d(byte[] paramArrayOfByte, h paramh)
  {
    Object localObject = b(paramArrayOfByte);
    int i = localObject[0];
    int j = localObject[1];
    if (i == 64527) {}
    int k;
    do
    {
      do
      {
        return i;
        if (j + 1 > paramArrayOfByte.length) {
          return 64527;
        }
        paramh.d = util.buf_to_int8(paramArrayOfByte, j);
        k = j + 1;
        if (k + 2 > paramArrayOfByte.length) {
          return 64527;
        }
        j = util.buf_to_int16(paramArrayOfByte, k);
        k += 2;
        if (k + j > paramArrayOfByte.length) {
          return 64527;
        }
        paramh.f = new byte[j];
        System.arraycopy(paramArrayOfByte, k, paramh.f, 0, j);
        k += j;
      } while (k + 2 > paramArrayOfByte.length);
      j = util.buf_to_int16(paramArrayOfByte, k);
      k += 2;
      if (k + j > paramArrayOfByte.length) {
        return 64527;
      }
    } while (j <= 0);
    localObject = new byte[j + 2];
    System.arraycopy(paramArrayOfByte, k, localObject, 1, j);
    localObject[0] = 40;
    localObject[(j + 1)] = 41;
    paramh.f = new String(paramh.f).replace("。", new String((byte[])localObject) + "。").getBytes();
    return i;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[this.a + 2 + paramArrayOfByte.length];
    util.int8_to_buf(arrayOfByte, 0, 2);
    util.int16_to_buf(arrayOfByte, 1, this.a + paramArrayOfByte.length + 2);
    util.int16_to_buf(arrayOfByte, 3, this.e);
    util.int16_to_buf(arrayOfByte, 5, this.b);
    util.int8_to_buf(arrayOfByte, 7, 4);
    util.int32_to_buf(arrayOfByte, 8, 0);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 12, paramArrayOfByte.length);
    int i = paramArrayOfByte.length + 12;
    util.int8_to_buf(arrayOfByte, i, 3);
    return arrayOfByte;
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + 1];
    util.int8_to_buf(arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 1, paramArrayOfByte1.length);
    paramArrayOfByte1 = MD5.toMD5Byte(paramArrayOfByte2);
    return cryptor.encrypt(arrayOfByte, 0, arrayOfByte.length, paramArrayOfByte1);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */