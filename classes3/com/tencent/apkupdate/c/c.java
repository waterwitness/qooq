package com.tencent.apkupdate.c;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

public final class c
{
  private static byte[] a = { -128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  private final long[] b = new long[4];
  private final long[] c = new long[2];
  private final byte[] d = new byte[64];
  private final byte[] e = new byte[16];
  
  public c()
  {
    a();
  }
  
  private long a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = (paramLong2 & paramLong3 | (0xFFFFFFFFFFFFFFFF ^ paramLong2) & paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  public static String a(String paramString)
  {
    try
    {
      localObject = paramString.getBytes("ISO8859_1");
      paramString = (String)localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Object localObject;
        paramString = paramString.getBytes();
        continue;
        int i = 120 - i;
      }
    }
    localObject = new c();
    ((c)localObject).a();
    ((c)localObject).a(new ByteArrayInputStream(paramString), paramString.length);
    paramString = new byte[8];
    a(paramString, ((c)localObject).c, 8);
    i = (int)(localObject.c[0] >>> 3) & 0x3F;
    if (i < 56)
    {
      i = 56 - i;
      ((c)localObject).a(a, i);
      ((c)localObject).a(paramString, 8);
      a(((c)localObject).e, ((c)localObject).b, 16);
      localObject = ((c)localObject).e;
      paramString = "";
      i = 0;
      while (i < 16)
      {
        paramString = new StringBuilder().append(paramString);
        int j = localObject[i];
        char[] arrayOfChar = new char[16];
        char[] tmp143_142 = arrayOfChar;
        tmp143_142[0] = 48;
        char[] tmp148_143 = tmp143_142;
        tmp148_143[1] = 49;
        char[] tmp153_148 = tmp148_143;
        tmp153_148[2] = 50;
        char[] tmp158_153 = tmp153_148;
        tmp158_153[3] = 51;
        char[] tmp163_158 = tmp158_153;
        tmp163_158[4] = 52;
        char[] tmp168_163 = tmp163_158;
        tmp168_163[5] = 53;
        char[] tmp173_168 = tmp168_163;
        tmp173_168[6] = 54;
        char[] tmp179_173 = tmp173_168;
        tmp179_173[7] = 55;
        char[] tmp185_179 = tmp179_173;
        tmp185_179[8] = 56;
        char[] tmp191_185 = tmp185_179;
        tmp191_185[9] = 57;
        char[] tmp197_191 = tmp191_185;
        tmp197_191[10] = 65;
        char[] tmp203_197 = tmp197_191;
        tmp203_197[11] = 66;
        char[] tmp209_203 = tmp203_197;
        tmp209_203[12] = 67;
        char[] tmp215_209 = tmp209_203;
        tmp215_209[13] = 68;
        char[] tmp221_215 = tmp215_209;
        tmp221_215[14] = 69;
        char[] tmp227_221 = tmp221_215;
        tmp227_221[15] = 70;
        tmp227_221;
        paramString = new String(new char[] { arrayOfChar[(j >>> 4 & 0xF)], arrayOfChar[(j & 0xF)] });
        i += 1;
      }
    }
    return paramString;
  }
  
  private void a()
  {
    this.c[0] = 0L;
    this.c[1] = 0L;
    this.b[0] = 1732584193L;
    this.b[1] = 4023233417L;
    this.b[2] = 2562383102L;
    this.b[3] = 271733878L;
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    long l8 = this.b[0];
    long l5 = this.b[1];
    long l6 = this.b[2];
    long l7 = this.b[3];
    long[] arrayOfLong = new long[16];
    int j = 0;
    int i = 0;
    if (j < 64)
    {
      int k = paramArrayOfByte[j];
      if (k < 0)
      {
        l1 = k & 0xFF;
        label69:
        k = paramArrayOfByte[(j + 1)];
        if (k >= 0) {
          break label179;
        }
        l2 = k & 0xFF;
        label91:
        k = paramArrayOfByte[(j + 2)];
        if (k >= 0) {
          break label187;
        }
        l3 = k & 0xFF;
        label113:
        k = paramArrayOfByte[(j + 3)];
        if (k >= 0) {
          break label195;
        }
      }
      label179:
      label187:
      label195:
      for (l4 = k & 0xFF;; l4 = k)
      {
        arrayOfLong[i] = (l4 << 24 | l2 << 8 | l1 | l3 << 16);
        j += 4;
        i += 1;
        break;
        l1 = k;
        break label69;
        l2 = k;
        break label91;
        l3 = k;
        break label113;
      }
    }
    long l1 = a(l8, l5, l6, l7, arrayOfLong[0], 7L, 3614090360L);
    long l2 = a(l7, l1, l5, l6, arrayOfLong[1], 12L, 3905402710L);
    long l3 = a(l6, l2, l1, l5, arrayOfLong[2], 17L, 606105819L);
    long l4 = a(l5, l3, l2, l1, arrayOfLong[3], 22L, 3250441966L);
    l1 = a(l1, l4, l3, l2, arrayOfLong[4], 7L, 4118548399L);
    l2 = a(l2, l1, l4, l3, arrayOfLong[5], 12L, 1200080426L);
    l3 = a(l3, l2, l1, l4, arrayOfLong[6], 17L, 2821735955L);
    l4 = a(l4, l3, l2, l1, arrayOfLong[7], 22L, 4249261313L);
    l1 = a(l1, l4, l3, l2, arrayOfLong[8], 7L, 1770035416L);
    l2 = a(l2, l1, l4, l3, arrayOfLong[9], 12L, 2336552879L);
    l3 = a(l3, l2, l1, l4, arrayOfLong[10], 17L, 4294925233L);
    l4 = a(l4, l3, l2, l1, arrayOfLong[11], 22L, 2304563134L);
    l1 = a(l1, l4, l3, l2, arrayOfLong[12], 7L, 1804603682L);
    l2 = a(l2, l1, l4, l3, arrayOfLong[13], 12L, 4254626195L);
    l3 = a(l3, l2, l1, l4, arrayOfLong[14], 17L, 2792965006L);
    l4 = a(l4, l3, l2, l1, arrayOfLong[15], 22L, 1236535329L);
    l1 = b(l1, l4, l3, l2, arrayOfLong[1], 5L, 4129170786L);
    l2 = b(l2, l1, l4, l3, arrayOfLong[6], 9L, 3225465664L);
    l3 = b(l3, l2, l1, l4, arrayOfLong[11], 14L, 643717713L);
    l4 = b(l4, l3, l2, l1, arrayOfLong[0], 20L, 3921069994L);
    l1 = b(l1, l4, l3, l2, arrayOfLong[5], 5L, 3593408605L);
    l2 = b(l2, l1, l4, l3, arrayOfLong[10], 9L, 38016083L);
    l3 = b(l3, l2, l1, l4, arrayOfLong[15], 14L, 3634488961L);
    l4 = b(l4, l3, l2, l1, arrayOfLong[4], 20L, 3889429448L);
    l1 = b(l1, l4, l3, l2, arrayOfLong[9], 5L, 568446438L);
    l2 = b(l2, l1, l4, l3, arrayOfLong[14], 9L, 3275163606L);
    l3 = b(l3, l2, l1, l4, arrayOfLong[3], 14L, 4107603335L);
    l4 = b(l4, l3, l2, l1, arrayOfLong[8], 20L, 1163531501L);
    l1 = b(l1, l4, l3, l2, arrayOfLong[13], 5L, 2850285829L);
    l2 = b(l2, l1, l4, l3, arrayOfLong[2], 9L, 4243563512L);
    l3 = b(l3, l2, l1, l4, arrayOfLong[7], 14L, 1735328473L);
    l4 = b(l4, l3, l2, l1, arrayOfLong[12], 20L, 2368359562L);
    l1 = c(l1, l4, l3, l2, arrayOfLong[5], 4L, 4294588738L);
    l2 = c(l2, l1, l4, l3, arrayOfLong[8], 11L, 2272392833L);
    l3 = c(l3, l2, l1, l4, arrayOfLong[11], 16L, 1839030562L);
    l4 = c(l4, l3, l2, l1, arrayOfLong[14], 23L, 4259657740L);
    l1 = c(l1, l4, l3, l2, arrayOfLong[1], 4L, 2763975236L);
    l2 = c(l2, l1, l4, l3, arrayOfLong[4], 11L, 1272893353L);
    l3 = c(l3, l2, l1, l4, arrayOfLong[7], 16L, 4139469664L);
    l4 = c(l4, l3, l2, l1, arrayOfLong[10], 23L, 3200236656L);
    l1 = c(l1, l4, l3, l2, arrayOfLong[13], 4L, 681279174L);
    l2 = c(l2, l1, l4, l3, arrayOfLong[0], 11L, 3936430074L);
    l3 = c(l3, l2, l1, l4, arrayOfLong[3], 16L, 3572445317L);
    l4 = c(l4, l3, l2, l1, arrayOfLong[6], 23L, 76029189L);
    l1 = c(l1, l4, l3, l2, arrayOfLong[9], 4L, 3654602809L);
    l2 = c(l2, l1, l4, l3, arrayOfLong[12], 11L, 3873151461L);
    l3 = c(l3, l2, l1, l4, arrayOfLong[15], 16L, 530742520L);
    l4 = c(l4, l3, l2, l1, arrayOfLong[2], 23L, 3299628645L);
    l1 = d(l1, l4, l3, l2, arrayOfLong[0], 6L, 4096336452L);
    l2 = d(l2, l1, l4, l3, arrayOfLong[7], 10L, 1126891415L);
    l3 = d(l3, l2, l1, l4, arrayOfLong[14], 15L, 2878612391L);
    l4 = d(l4, l3, l2, l1, arrayOfLong[5], 21L, 4237533241L);
    l1 = d(l1, l4, l3, l2, arrayOfLong[12], 6L, 1700485571L);
    l2 = d(l2, l1, l4, l3, arrayOfLong[3], 10L, 2399980690L);
    l3 = d(l3, l2, l1, l4, arrayOfLong[10], 15L, 4293915773L);
    l4 = d(l4, l3, l2, l1, arrayOfLong[1], 21L, 2240044497L);
    l1 = d(l1, l4, l3, l2, arrayOfLong[8], 6L, 1873313359L);
    l2 = d(l2, l1, l4, l3, arrayOfLong[15], 10L, 4264355552L);
    l3 = d(l3, l2, l1, l4, arrayOfLong[6], 15L, 2734768916L);
    l4 = d(l4, l3, l2, l1, arrayOfLong[13], 21L, 1309151649L);
    l1 = d(l1, l4, l3, l2, arrayOfLong[4], 6L, 4149444226L);
    l2 = d(l2, l1, l4, l3, arrayOfLong[11], 10L, 3174756917L);
    l3 = d(l3, l2, l1, l4, arrayOfLong[2], 15L, 718787259L);
    l4 = d(l4, l3, l2, l1, arrayOfLong[9], 21L, 3951481745L);
    paramArrayOfByte = this.b;
    paramArrayOfByte[0] += l1;
    paramArrayOfByte = this.b;
    paramArrayOfByte[1] = (l4 + paramArrayOfByte[1]);
    paramArrayOfByte = this.b;
    paramArrayOfByte[2] += l3;
    paramArrayOfByte = this.b;
    paramArrayOfByte[3] += l2;
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    int k = 0;
    byte[] arrayOfByte = new byte[64];
    int j = (int)(this.c[0] >>> 3) & 0x3F;
    Object localObject = this.c;
    long l = localObject[0] + (paramInt << 3);
    localObject[0] = l;
    if (l < paramInt << 3)
    {
      localObject = this.c;
      localObject[1] += 1L;
    }
    localObject = this.c;
    localObject[1] += (paramInt >>> 29);
    int m = 64 - j;
    int i;
    if (paramInt >= m)
    {
      localObject = this.d;
      i = 0;
      while (i < m)
      {
        localObject[(j + i)] = paramArrayOfByte[(0 + i)];
        i += 1;
      }
      a(this.d);
      i = m;
      while (i + 63 < paramInt)
      {
        j = 0;
        while (j < 64)
        {
          arrayOfByte[(0 + j)] = paramArrayOfByte[(i + j)];
          j += 1;
        }
        a(arrayOfByte);
        i += 64;
      }
      m = 0;
      j = i;
      i = m;
    }
    for (;;)
    {
      arrayOfByte = this.d;
      while (k < paramInt - j)
      {
        arrayOfByte[(i + k)] = paramArrayOfByte[(j + k)];
        k += 1;
      }
      m = 0;
      i = j;
      j = m;
    }
  }
  
  private static void a(byte[] paramArrayOfByte, long[] paramArrayOfLong, int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < paramInt)
    {
      paramArrayOfByte[i] = ((byte)(int)(paramArrayOfLong[j] & 0xFF));
      paramArrayOfByte[(i + 1)] = ((byte)(int)(paramArrayOfLong[j] >>> 8 & 0xFF));
      paramArrayOfByte[(i + 2)] = ((byte)(int)(paramArrayOfLong[j] >>> 16 & 0xFF));
      paramArrayOfByte[(i + 3)] = ((byte)(int)(paramArrayOfLong[j] >>> 24 & 0xFF));
      j += 1;
      i += 4;
    }
  }
  
  /* Error */
  private boolean a(java.io.InputStream paramInputStream, long paramLong)
  {
    // Byte code:
    //   0: bipush 64
    //   2: newarray <illegal type>
    //   4: astore 4
    //   6: aload_0
    //   7: getfield 25	com/tencent/apkupdate/c/c:c	[J
    //   10: iconst_0
    //   11: laload
    //   12: iconst_3
    //   13: lushr
    //   14: l2i
    //   15: bipush 63
    //   17: iand
    //   18: istore 8
    //   20: aload_0
    //   21: getfield 25	com/tencent/apkupdate/c/c:c	[J
    //   24: astore 5
    //   26: aload 5
    //   28: iconst_0
    //   29: laload
    //   30: lload_2
    //   31: iconst_3
    //   32: lshl
    //   33: ladd
    //   34: lstore 10
    //   36: aload 5
    //   38: iconst_0
    //   39: lload 10
    //   41: lastore
    //   42: lload 10
    //   44: lload_2
    //   45: iconst_3
    //   46: lshl
    //   47: lcmp
    //   48: ifge +19 -> 67
    //   51: aload_0
    //   52: getfield 25	com/tencent/apkupdate/c/c:c	[J
    //   55: astore 5
    //   57: aload 5
    //   59: iconst_1
    //   60: aload 5
    //   62: iconst_1
    //   63: laload
    //   64: lconst_1
    //   65: ladd
    //   66: lastore
    //   67: aload_0
    //   68: getfield 25	com/tencent/apkupdate/c/c:c	[J
    //   71: astore 5
    //   73: aload 5
    //   75: iconst_1
    //   76: aload 5
    //   78: iconst_1
    //   79: laload
    //   80: lload_2
    //   81: bipush 29
    //   83: lushr
    //   84: ladd
    //   85: lastore
    //   86: bipush 64
    //   88: iload 8
    //   90: isub
    //   91: istore 9
    //   93: lload_2
    //   94: iload 9
    //   96: i2l
    //   97: lcmp
    //   98: iflt +176 -> 274
    //   101: iload 9
    //   103: newarray <illegal type>
    //   105: astore 5
    //   107: aload_1
    //   108: aload 5
    //   110: iconst_0
    //   111: iload 9
    //   113: invokevirtual 285	java/io/InputStream:read	([BII)I
    //   116: pop
    //   117: aload_0
    //   118: getfield 27	com/tencent/apkupdate/c/c:d	[B
    //   121: astore 6
    //   123: iconst_0
    //   124: istore 7
    //   126: iload 7
    //   128: iload 9
    //   130: if_icmpge +27 -> 157
    //   133: aload 6
    //   135: iload 8
    //   137: iload 7
    //   139: iadd
    //   140: aload 5
    //   142: iconst_0
    //   143: iload 7
    //   145: iadd
    //   146: baload
    //   147: bastore
    //   148: iload 7
    //   150: iconst_1
    //   151: iadd
    //   152: istore 7
    //   154: goto -28 -> 126
    //   157: aload_0
    //   158: aload_0
    //   159: getfield 27	com/tencent/apkupdate/c/c:d	[B
    //   162: invokespecial 275	com/tencent/apkupdate/c/c:a	([B)V
    //   165: iload 9
    //   167: istore 7
    //   169: iload 7
    //   171: bipush 63
    //   173: iadd
    //   174: i2l
    //   175: lload_2
    //   176: lcmp
    //   177: ifge +26 -> 203
    //   180: aload_1
    //   181: aload 4
    //   183: invokevirtual 288	java/io/InputStream:read	([B)I
    //   186: pop
    //   187: aload_0
    //   188: aload 4
    //   190: invokespecial 275	com/tencent/apkupdate/c/c:a	([B)V
    //   193: iload 7
    //   195: bipush 64
    //   197: iadd
    //   198: istore 7
    //   200: goto -31 -> 169
    //   203: iconst_0
    //   204: istore 9
    //   206: iload 7
    //   208: istore 8
    //   210: iload 9
    //   212: istore 7
    //   214: lload_2
    //   215: iload 8
    //   217: i2l
    //   218: lsub
    //   219: l2i
    //   220: newarray <illegal type>
    //   222: astore 4
    //   224: aload_1
    //   225: aload 4
    //   227: invokevirtual 288	java/io/InputStream:read	([B)I
    //   230: pop
    //   231: aload_0
    //   232: getfield 27	com/tencent/apkupdate/c/c:d	[B
    //   235: astore_1
    //   236: aload 4
    //   238: arraylength
    //   239: istore 9
    //   241: iconst_0
    //   242: istore 8
    //   244: iload 8
    //   246: iload 9
    //   248: if_icmpge +40 -> 288
    //   251: aload_1
    //   252: iload 7
    //   254: iload 8
    //   256: iadd
    //   257: aload 4
    //   259: iconst_0
    //   260: iload 8
    //   262: iadd
    //   263: baload
    //   264: bastore
    //   265: iload 8
    //   267: iconst_1
    //   268: iadd
    //   269: istore 8
    //   271: goto -27 -> 244
    //   274: iconst_0
    //   275: istore 9
    //   277: iload 8
    //   279: istore 7
    //   281: iload 9
    //   283: istore 8
    //   285: goto -71 -> 214
    //   288: iconst_1
    //   289: ireturn
    //   290: astore_1
    //   291: iconst_0
    //   292: ireturn
    //   293: astore_1
    //   294: iconst_0
    //   295: ireturn
    //   296: astore_1
    //   297: iconst_0
    //   298: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	this	c
    //   0	299	1	paramInputStream	java.io.InputStream
    //   0	299	2	paramLong	long
    //   4	254	4	arrayOfByte1	byte[]
    //   24	117	5	localObject	Object
    //   121	13	6	arrayOfByte2	byte[]
    //   124	156	7	i	int
    //   18	266	8	j	int
    //   91	191	9	k	int
    //   34	9	10	l	long
    // Exception table:
    //   from	to	target	type
    //   107	117	290	java/lang/Exception
    //   180	187	293	java/lang/Exception
    //   224	231	296	java/lang/Exception
  }
  
  private long b(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = (paramLong2 & paramLong4 | (0xFFFFFFFFFFFFFFFF ^ paramLong4) & paramLong3) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  /* Error */
  public static String b(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: new 290	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 293	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_0
    //   11: sipush 1024
    //   14: newarray <illegal type>
    //   16: astore_1
    //   17: ldc_w 295
    //   20: invokestatic 301	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   23: astore_2
    //   24: iload_3
    //   25: iconst_m1
    //   26: if_icmpeq +43 -> 69
    //   29: aload_0
    //   30: aload_1
    //   31: invokevirtual 288	java/io/InputStream:read	([B)I
    //   34: istore 4
    //   36: iload 4
    //   38: istore_3
    //   39: iload 4
    //   41: ifle -17 -> 24
    //   44: aload_2
    //   45: aload_1
    //   46: iconst_0
    //   47: iload 4
    //   49: invokevirtual 305	java/security/MessageDigest:update	([BII)V
    //   52: iload 4
    //   54: istore_3
    //   55: goto -31 -> 24
    //   58: astore_1
    //   59: aload_0
    //   60: ifnull +7 -> 67
    //   63: aload_0
    //   64: invokevirtual 308	java/io/InputStream:close	()V
    //   67: aconst_null
    //   68: areturn
    //   69: aload_2
    //   70: invokevirtual 311	java/security/MessageDigest:digest	()[B
    //   73: invokestatic 314	com/tencent/apkupdate/c/c:b	([B)Ljava/lang/String;
    //   76: astore_1
    //   77: aload_0
    //   78: invokevirtual 308	java/io/InputStream:close	()V
    //   81: aload_1
    //   82: areturn
    //   83: astore_0
    //   84: aload_1
    //   85: areturn
    //   86: astore_1
    //   87: aconst_null
    //   88: astore_0
    //   89: aload_0
    //   90: ifnull +7 -> 97
    //   93: aload_0
    //   94: invokevirtual 308	java/io/InputStream:close	()V
    //   97: aload_1
    //   98: athrow
    //   99: astore_0
    //   100: aconst_null
    //   101: areturn
    //   102: astore_0
    //   103: goto -6 -> 97
    //   106: astore_1
    //   107: goto -18 -> 89
    //   110: astore_0
    //   111: aconst_null
    //   112: astore_0
    //   113: goto -54 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramString	String
    //   16	30	1	arrayOfByte	byte[]
    //   58	1	1	localException	Exception
    //   76	9	1	str	String
    //   86	12	1	localObject1	Object
    //   106	1	1	localObject2	Object
    //   23	47	2	localMessageDigest	java.security.MessageDigest
    //   1	54	3	i	int
    //   34	19	4	j	int
    // Exception table:
    //   from	to	target	type
    //   11	24	58	java/lang/Exception
    //   29	36	58	java/lang/Exception
    //   44	52	58	java/lang/Exception
    //   69	77	58	java/lang/Exception
    //   77	81	83	java/lang/Exception
    //   2	11	86	finally
    //   63	67	99	java/lang/Exception
    //   93	97	102	java/lang/Exception
    //   11	24	106	finally
    //   29	36	106	finally
    //   44	52	106	finally
    //   69	77	106	finally
    //   2	11	110	java/lang/Exception
  }
  
  private static String b(byte[] paramArrayOfByte)
  {
    String str = "";
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      str = str + Integer.toString((paramArrayOfByte[i] & 0xFF) + 256, 16).substring(1);
      i += 1;
    }
    return str.toUpperCase();
  }
  
  private long c(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = (paramLong2 ^ paramLong3 ^ paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  private long d(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = ((0xFFFFFFFFFFFFFFFF ^ paramLong4 | paramLong2) ^ paramLong3) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\apkupdate\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */