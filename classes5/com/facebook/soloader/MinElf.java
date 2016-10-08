package com.facebook.soloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

public final class MinElf
{
  public static final int DT_NEEDED = 1;
  public static final int DT_NULL = 0;
  public static final int DT_STRTAB = 5;
  public static final int ELF_MAGIC = 1179403647;
  public static final int PN_XNUM = 65535;
  public static final int PT_DYNAMIC = 2;
  public static final int PT_LOAD = 1;
  
  public static String[] extract_DT_NEEDED(File paramFile)
    throws IOException
  {
    paramFile = new FileInputStream(paramFile);
    try
    {
      String[] arrayOfString = extract_DT_NEEDED(paramFile.getChannel());
      return arrayOfString;
    }
    finally
    {
      paramFile.close();
    }
  }
  
  public static String[] extract_DT_NEEDED(FileChannel paramFileChannel)
    throws IOException
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    if (getu32(paramFileChannel, localByteBuffer, 0L) != 1179403647L) {
      throw new ElfError("file is not ELF");
    }
    int i;
    long l1;
    label85:
    long l2;
    label100:
    label114:
    label141:
    label158:
    long l6;
    if (getu8(paramFileChannel, localByteBuffer, 4L) == 1)
    {
      i = 1;
      if (getu8(paramFileChannel, localByteBuffer, 5L) == 2) {
        localByteBuffer.order(ByteOrder.BIG_ENDIAN);
      }
      if (i == 0) {
        break label247;
      }
      l1 = getu32(paramFileChannel, localByteBuffer, 28L);
      if (i == 0) {
        break label260;
      }
      l2 = getu16(paramFileChannel, localByteBuffer, 44L);
      if (i == 0) {
        break label274;
      }
      j = getu16(paramFileChannel, localByteBuffer, 42L);
      l4 = l2;
      if (l2 == 65535L)
      {
        if (i == 0) {
          break label287;
        }
        l2 = getu32(paramFileChannel, localByteBuffer, 32L);
        if (i == 0) {
          break label300;
        }
        l2 = getu32(paramFileChannel, localByteBuffer, 28L + l2);
        l4 = l2;
      }
      l6 = 0L;
      l5 = l1;
    }
    for (long l3 = 0L;; l3 += 1L)
    {
      l2 = l6;
      if (l3 < l4)
      {
        if (i == 0) {
          break label316;
        }
        l2 = getu32(paramFileChannel, localByteBuffer, 0L + l5);
        label199:
        if (l2 != 2L) {
          break label346;
        }
        if (i == 0) {
          break label330;
        }
      }
      label247:
      label260:
      label274:
      label287:
      label300:
      label316:
      label330:
      for (l2 = getu32(paramFileChannel, localByteBuffer, 4L + l5);; l2 = get64(paramFileChannel, localByteBuffer, 8L + l5))
      {
        if (l2 != 0L) {
          break label363;
        }
        throw new ElfError("ELF file does not contain dynamic linking information");
        i = 0;
        break;
        l1 = get64(paramFileChannel, localByteBuffer, 32L);
        break label85;
        l2 = getu16(paramFileChannel, localByteBuffer, 56L);
        break label100;
        j = getu16(paramFileChannel, localByteBuffer, 54L);
        break label114;
        l2 = get64(paramFileChannel, localByteBuffer, 40L);
        break label141;
        l2 = getu32(paramFileChannel, localByteBuffer, 44L + l2);
        break label158;
        l2 = getu32(paramFileChannel, localByteBuffer, 0L + l5);
        break label199;
      }
      label346:
      l5 += j;
    }
    label363:
    int m = 0;
    long l5 = l2;
    long l7 = 0L;
    if (i != 0) {
      l6 = getu32(paramFileChannel, localByteBuffer, 0L + l5);
    }
    while (l6 == 1L) {
      if (m == Integer.MAX_VALUE)
      {
        throw new ElfError("malformed DT_NEEDED section");
        l6 = get64(paramFileChannel, localByteBuffer, 0L + l5);
      }
      else
      {
        k = m + 1;
        l3 = l7;
        label436:
        if (i == 0) {
          break label541;
        }
      }
    }
    label541:
    for (l7 = 8L;; l7 = 16L)
    {
      l5 += l7;
      m = k;
      l7 = l3;
      if (l6 != 0L) {
        break;
      }
      if (l3 != 0L) {
        break label549;
      }
      throw new ElfError("Dynamic section string-table not found");
      k = m;
      l3 = l7;
      if (l6 != 5L) {
        break label436;
      }
      if (i != 0) {}
      for (l3 = getu32(paramFileChannel, localByteBuffer, 4L + l5);; l3 = get64(paramFileChannel, localByteBuffer, 8L + l5))
      {
        k = m;
        break;
      }
    }
    label549:
    l7 = 0L;
    m = 0;
    l5 = l1;
    for (;;)
    {
      l1 = l7;
      if (m < l4)
      {
        if (i == 0) {
          break label691;
        }
        l1 = getu32(paramFileChannel, localByteBuffer, 0L + l5);
        if (l1 != 1L) {
          break label753;
        }
        if (i == 0) {
          break label705;
        }
        l1 = getu32(paramFileChannel, localByteBuffer, 8L + l5);
        label611:
        if (i == 0) {
          break label721;
        }
        l6 = getu32(paramFileChannel, localByteBuffer, 20L + l5);
        label628:
        if ((l1 > l3) || (l3 >= l1 + l6)) {
          break label753;
        }
        if (i == 0) {
          break label737;
        }
      }
      label691:
      label705:
      label721:
      label737:
      for (l4 = getu32(paramFileChannel, localByteBuffer, 4L + l5);; l4 = get64(paramFileChannel, localByteBuffer, 8L + l5))
      {
        l1 = l4 + (l3 - l1);
        if (l1 != 0L) {
          break label770;
        }
        throw new ElfError("did not find file offset of DT_STRTAB table");
        l1 = getu32(paramFileChannel, localByteBuffer, 0L + l5);
        break;
        l1 = get64(paramFileChannel, localByteBuffer, 16L + l5);
        break label611;
        l6 = get64(paramFileChannel, localByteBuffer, 40L + l5);
        break label628;
      }
      label753:
      l5 += j;
      m += 1;
    }
    label770:
    String[] arrayOfString = new String[k];
    int j = 0;
    if (i != 0)
    {
      l3 = getu32(paramFileChannel, localByteBuffer, 0L + l2);
      k = j;
      if (l3 != 1L) {
        break label889;
      }
      if (i == 0) {
        break label867;
      }
    }
    label867:
    for (long l4 = getu32(paramFileChannel, localByteBuffer, 4L + l2);; l4 = get64(paramFileChannel, localByteBuffer, 8L + l2))
    {
      arrayOfString[j] = getSz(paramFileChannel, localByteBuffer, l1 + l4);
      if (j != Integer.MAX_VALUE) {
        break label883;
      }
      throw new ElfError("malformed DT_NEEDED section");
      l3 = get64(paramFileChannel, localByteBuffer, 0L + l2);
      break;
    }
    label883:
    int k = j + 1;
    label889:
    if (i != 0) {}
    for (l4 = 8L;; l4 = 16L)
    {
      l2 += l4;
      j = k;
      if (l3 != 0L) {
        break;
      }
      if (k == arrayOfString.length) {
        return arrayOfString;
      }
      throw new ElfError("malformed DT_NEEDED section");
    }
    return arrayOfString;
  }
  
  private static long get64(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, long paramLong)
    throws IOException
  {
    read(paramFileChannel, paramByteBuffer, 8, paramLong);
    return paramByteBuffer.getLong();
  }
  
  private static String getSz(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, long paramLong)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i = getu8(paramFileChannel, paramByteBuffer, paramLong);
      if (i == 0) {
        break;
      }
      localStringBuilder.append((char)i);
      paramLong += 1L;
    }
    return localStringBuilder.toString();
  }
  
  private static int getu16(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, long paramLong)
    throws IOException
  {
    read(paramFileChannel, paramByteBuffer, 2, paramLong);
    return paramByteBuffer.getShort() & 0xFFFF;
  }
  
  private static long getu32(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, long paramLong)
    throws IOException
  {
    read(paramFileChannel, paramByteBuffer, 4, paramLong);
    return paramByteBuffer.getInt() & 0xFFFFFFFF;
  }
  
  private static short getu8(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, long paramLong)
    throws IOException
  {
    read(paramFileChannel, paramByteBuffer, 1, paramLong);
    return (short)(paramByteBuffer.get() & 0xFF);
  }
  
  private static void read(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, int paramInt, long paramLong)
    throws IOException
  {
    paramByteBuffer.position(0);
    paramByteBuffer.limit(paramInt);
    if (paramFileChannel.read(paramByteBuffer, paramLong) != paramInt) {
      throw new ElfError("ELF file truncated");
    }
    paramByteBuffer.position(0);
  }
  
  private static class ElfError
    extends RuntimeException
  {
    ElfError(String paramString)
    {
      super();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\soloader\MinElf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */