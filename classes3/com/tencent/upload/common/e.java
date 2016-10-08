package com.tencent.upload.common;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

public final class e
{
  private byte[] a;
  private byte[] b;
  private byte[] c;
  private int d;
  private int e;
  private int f;
  private int g;
  private byte[] h;
  private boolean i = true;
  private Random j = new Random();
  
  private static long a(byte[] paramArrayOfByte, int paramInt)
  {
    long l = 0L;
    int k = paramInt;
    while (k < paramInt + 4)
    {
      l = l << 8 | paramArrayOfByte[k] & 0xFF;
      k += 1;
    }
    return l | l >>> 32;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknown";
    case 0: 
      return "noDetection";
    case 1: 
      return "detecting";
    }
    return "detected";
  }
  
  private void a()
  {
    this.f = 0;
    int k;
    byte[] arrayOfByte;
    if (this.f < 8)
    {
      if (this.i)
      {
        k = this.f;
        arrayOfByte = this.a;
        if ((this.b != null) && (this.b.length > this.f)) {
          arrayOfByte[k] = ((byte)(arrayOfByte[k] ^ this.b[this.f]));
        }
      }
      for (;;)
      {
        this.f += 1;
        break;
        k = this.f;
        arrayOfByte = this.a;
        arrayOfByte[k] = ((byte)(arrayOfByte[k] ^ this.c[(this.e + this.f)]));
      }
    }
    System.arraycopy(a(this.a), 0, this.c, this.d, 8);
    if ((this.b != null) && (this.b.length >= 8)) {
      for (this.f = 0; this.f < 8; this.f += 1)
      {
        k = this.d + this.f;
        arrayOfByte = this.c;
        arrayOfByte[k] = ((byte)(arrayOfByte[k] ^ this.b[this.f]));
      }
    }
    System.arraycopy(this.a, 0, this.b, 0, 8);
    this.e = this.d;
    this.d += 8;
    this.f = 0;
    this.i = false;
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    int k = 16;
    for (;;)
    {
      long l3;
      long l2;
      long l4;
      long l5;
      long l6;
      long l7;
      long l1;
      try
      {
        l3 = a(paramArrayOfByte, 0);
        l2 = a(paramArrayOfByte, 4);
        l4 = a(this.h, 0);
        l5 = a(this.h, 4);
        l6 = a(this.h, 8);
        l7 = a(this.h, 12);
        l1 = 0L;
      }
      catch (IOException paramArrayOfByte)
      {
        DataOutputStream localDataOutputStream;
        return null;
      }
      paramArrayOfByte = new ByteArrayOutputStream(8);
      localDataOutputStream = new DataOutputStream(paramArrayOfByte);
      localDataOutputStream.writeInt((int)l3);
      localDataOutputStream.writeInt((int)l2);
      localDataOutputStream.close();
      paramArrayOfByte = paramArrayOfByte.toByteArray();
      return paramArrayOfByte;
      while (k > 0)
      {
        l1 = l1 + 2654435769L & 0xFFFFFFFF;
        l3 = l3 + ((l2 << 4) + l4 ^ l2 + l1 ^ (l2 >>> 5) + l5) & 0xFFFFFFFF;
        l2 = l2 + ((l3 << 4) + l6 ^ l3 + l1 ^ (l3 >>> 5) + l7) & 0xFFFFFFFF;
        k -= 1;
      }
    }
  }
  
  protected final byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int m = paramArrayOfByte1.length;
    this.a = new byte[8];
    this.b = new byte[8];
    this.f = 1;
    this.g = 0;
    this.e = 0;
    this.d = 0;
    this.h = paramArrayOfByte2;
    this.i = true;
    this.f = ((m + 10) % 8);
    if (this.f != 0) {
      this.f = (8 - this.f);
    }
    this.c = new byte[this.f + m + 10];
    this.a[0] = ((byte)(this.j.nextInt() & 0xF8 | this.f));
    int k = 1;
    while (k <= this.f)
    {
      this.a[k] = ((byte)this.j.nextInt());
      k += 1;
    }
    this.f += 1;
    k = 0;
    while (k < 8)
    {
      this.b[k] = 0;
      k += 1;
    }
    this.g = 1;
    while (this.g <= 2)
    {
      if (this.f < 8)
      {
        paramArrayOfByte2 = this.a;
        k = this.f;
        this.f = (k + 1);
        paramArrayOfByte2[k] = ((byte)this.j.nextInt());
        this.g += 1;
      }
      if (this.f == 8) {
        a();
      }
    }
    k = 0;
    if (m > 0)
    {
      if (this.f >= 8) {
        break label408;
      }
      paramArrayOfByte2 = this.a;
      int i1 = this.f;
      this.f = (i1 + 1);
      int n = k + 1;
      paramArrayOfByte2[i1] = paramArrayOfByte1[k];
      m -= 1;
      k = n;
    }
    label408:
    for (;;)
    {
      if (this.f == 8)
      {
        a();
        break;
        this.g = 1;
        while (this.g <= 7)
        {
          if (this.f < 8)
          {
            paramArrayOfByte1 = this.a;
            k = this.f;
            this.f = (k + 1);
            paramArrayOfByte1[k] = 0;
            this.g += 1;
          }
          if (this.f == 8) {
            a();
          }
        }
        return this.c;
      }
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\common\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */