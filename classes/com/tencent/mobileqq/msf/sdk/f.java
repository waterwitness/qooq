package com.tencent.mobileqq.msf.sdk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class f
{
  FileOutputStream a = null;
  byte b = 0;
  byte c = 0;
  boolean d = true;
  
  public f(File paramFile, boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean) {}
    do
    {
      do
      {
        for (;;)
        {
          FileInputStream localFileInputStream;
          try
          {
            long l = paramFile.length();
            if (l < 5L) {}
          }
          catch (FileNotFoundException paramFile)
          {
            paramFile.printStackTrace();
            this.a = null;
            throw new IOException();
          }
          try
          {
            localFileInputStream = new FileInputStream(paramFile);
            try
            {
              byte[] arrayOfByte = new byte[5];
              int j = localFileInputStream.read(arrayOfByte);
              if ((j >= 1) && (arrayOfByte[0] != 0))
              {
                this.d = false;
                localFileInputStream.close();
                this.a = new FileOutputStream(paramFile, paramBoolean);
                return;
              }
              if ((j == 5) && (arrayOfByte[0] == 0))
              {
                this.d = true;
                this.b = 0;
                if (i < 5)
                {
                  this.b = ((byte)(this.b ^ arrayOfByte[i]));
                  i += 1;
                }
              }
              else
              {
                localFileInputStream.close();
                throw new Exception();
              }
            }
            catch (Exception paramFile) {}
          }
          catch (Exception paramFile)
          {
            localFileInputStream = null;
          }
        }
        paramFile.printStackTrace();
        localFileInputStream.close();
        throw new IOException();
      } while (paramFile.length() <= 0L);
      this.d = false;
      this.a = new FileOutputStream(paramFile, paramBoolean);
      return;
      this.a = new FileOutputStream(paramFile, paramBoolean);
    } while (!this.d);
    paramFile = new byte[4];
    while (this.b == 0)
    {
      new Random().nextBytes(paramFile);
      i = 0;
      while (i < 4)
      {
        this.b = ((byte)(this.b ^ paramFile[i]));
        i += 1;
      }
    }
    this.a.write(this.c);
    this.a.write(paramFile);
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: iconst_1
    //   3: istore 9
    //   5: new 40	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 79	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: new 52	java/io/FileOutputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 80	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   22: astore_1
    //   23: aload_1
    //   24: astore_2
    //   25: aload_0
    //   26: astore_3
    //   27: sipush 1024
    //   30: newarray <illegal type>
    //   32: astore 4
    //   34: aload_1
    //   35: astore_2
    //   36: aload_0
    //   37: astore_3
    //   38: sipush 1024
    //   41: newarray <illegal type>
    //   43: astore 5
    //   45: aload_1
    //   46: astore_2
    //   47: aload_0
    //   48: astore_3
    //   49: aload_0
    //   50: aload 4
    //   52: iconst_0
    //   53: iconst_5
    //   54: invokevirtual 83	java/io/FileInputStream:read	([BII)I
    //   57: iconst_5
    //   58: if_icmpne +219 -> 277
    //   61: aload 4
    //   63: iconst_0
    //   64: baload
    //   65: ifne +212 -> 277
    //   68: iconst_1
    //   69: istore 7
    //   71: iconst_0
    //   72: istore 6
    //   74: goto +294 -> 368
    //   77: aload_1
    //   78: astore_2
    //   79: aload_0
    //   80: astore_3
    //   81: aload_1
    //   82: aload 5
    //   84: iconst_0
    //   85: iload 8
    //   87: invokevirtual 86	java/io/FileOutputStream:write	([BII)V
    //   90: aload_1
    //   91: astore_2
    //   92: aload_0
    //   93: astore_3
    //   94: aload_0
    //   95: invokevirtual 90	java/io/FileInputStream:available	()I
    //   98: ifle +154 -> 252
    //   101: aload_1
    //   102: astore_2
    //   103: aload_0
    //   104: astore_3
    //   105: aload_0
    //   106: aload 4
    //   108: invokevirtual 47	java/io/FileInputStream:read	([B)I
    //   111: istore 8
    //   113: iconst_0
    //   114: istore 7
    //   116: iload 7
    //   118: iload 8
    //   120: if_icmpge -43 -> 77
    //   123: aload 5
    //   125: iload 7
    //   127: aload 4
    //   129: iload 7
    //   131: baload
    //   132: iload 6
    //   134: ixor
    //   135: i2b
    //   136: bastore
    //   137: iload 7
    //   139: iconst_1
    //   140: iadd
    //   141: istore 7
    //   143: goto -27 -> 116
    //   146: astore_3
    //   147: aconst_null
    //   148: astore_0
    //   149: aload_2
    //   150: astore_1
    //   151: aload_3
    //   152: astore_2
    //   153: aload_2
    //   154: invokevirtual 60	java/io/FileNotFoundException:printStackTrace	()V
    //   157: aload_1
    //   158: ifnull +7 -> 165
    //   161: aload_1
    //   162: invokevirtual 50	java/io/FileInputStream:close	()V
    //   165: aload_0
    //   166: ifnull +7 -> 173
    //   169: aload_0
    //   170: invokevirtual 91	java/io/FileOutputStream:close	()V
    //   173: iconst_0
    //   174: istore 9
    //   176: iload 9
    //   178: ireturn
    //   179: astore 4
    //   181: aconst_null
    //   182: astore_1
    //   183: aconst_null
    //   184: astore_0
    //   185: aload_1
    //   186: astore_2
    //   187: aload_0
    //   188: astore_3
    //   189: aload 4
    //   191: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   194: aload_0
    //   195: ifnull +7 -> 202
    //   198: aload_0
    //   199: invokevirtual 50	java/io/FileInputStream:close	()V
    //   202: aload_1
    //   203: ifnull -30 -> 173
    //   206: aload_1
    //   207: invokevirtual 91	java/io/FileOutputStream:close	()V
    //   210: goto -37 -> 173
    //   213: astore_0
    //   214: aload_0
    //   215: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   218: goto -45 -> 173
    //   221: astore_1
    //   222: aconst_null
    //   223: astore_2
    //   224: aconst_null
    //   225: astore_0
    //   226: aload_0
    //   227: ifnull +7 -> 234
    //   230: aload_0
    //   231: invokevirtual 50	java/io/FileInputStream:close	()V
    //   234: aload_2
    //   235: ifnull +7 -> 242
    //   238: aload_2
    //   239: invokevirtual 91	java/io/FileOutputStream:close	()V
    //   242: aload_1
    //   243: athrow
    //   244: astore_0
    //   245: aload_0
    //   246: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   249: goto -7 -> 242
    //   252: aload_0
    //   253: ifnull +7 -> 260
    //   256: aload_0
    //   257: invokevirtual 50	java/io/FileInputStream:close	()V
    //   260: aload_1
    //   261: ifnull -85 -> 176
    //   264: aload_1
    //   265: invokevirtual 91	java/io/FileOutputStream:close	()V
    //   268: iconst_1
    //   269: ireturn
    //   270: astore_0
    //   271: aload_0
    //   272: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   275: iconst_1
    //   276: ireturn
    //   277: aload_0
    //   278: ifnull +7 -> 285
    //   281: aload_0
    //   282: invokevirtual 50	java/io/FileInputStream:close	()V
    //   285: aload_1
    //   286: ifnull -113 -> 173
    //   289: aload_1
    //   290: invokevirtual 91	java/io/FileOutputStream:close	()V
    //   293: goto -120 -> 173
    //   296: astore_0
    //   297: goto -83 -> 214
    //   300: astore_0
    //   301: goto -87 -> 214
    //   304: astore_0
    //   305: goto -91 -> 214
    //   308: astore_0
    //   309: goto -95 -> 214
    //   312: astore_1
    //   313: aconst_null
    //   314: astore_2
    //   315: goto -89 -> 226
    //   318: astore_1
    //   319: aload_3
    //   320: astore_0
    //   321: goto -95 -> 226
    //   324: astore_2
    //   325: aload_1
    //   326: astore_3
    //   327: aload_2
    //   328: astore_1
    //   329: aload_0
    //   330: astore_2
    //   331: aload_3
    //   332: astore_0
    //   333: goto -107 -> 226
    //   336: astore 4
    //   338: aconst_null
    //   339: astore_1
    //   340: goto -155 -> 185
    //   343: astore 4
    //   345: goto -160 -> 185
    //   348: astore_2
    //   349: aconst_null
    //   350: astore_3
    //   351: aload_0
    //   352: astore_1
    //   353: aload_3
    //   354: astore_0
    //   355: goto -202 -> 153
    //   358: astore_2
    //   359: aload_0
    //   360: astore_3
    //   361: aload_1
    //   362: astore_0
    //   363: aload_3
    //   364: astore_1
    //   365: goto -212 -> 153
    //   368: iload 7
    //   370: iconst_5
    //   371: if_icmpge -281 -> 90
    //   374: iload 6
    //   376: aload 4
    //   378: iload 7
    //   380: baload
    //   381: ixor
    //   382: i2b
    //   383: istore 6
    //   385: iload 7
    //   387: iconst_1
    //   388: iadd
    //   389: istore 7
    //   391: goto -23 -> 368
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	394	0	paramString1	String
    //   0	394	1	paramString2	String
    //   1	314	2	localObject1	Object
    //   324	4	2	localObject2	Object
    //   330	1	2	str1	String
    //   348	1	2	localFileNotFoundException1	FileNotFoundException
    //   358	1	2	localFileNotFoundException2	FileNotFoundException
    //   26	79	3	str2	String
    //   146	6	3	localFileNotFoundException3	FileNotFoundException
    //   188	176	3	str3	String
    //   32	96	4	arrayOfByte1	byte[]
    //   179	11	4	localIOException1	IOException
    //   336	1	4	localIOException2	IOException
    //   343	34	4	localIOException3	IOException
    //   43	81	5	arrayOfByte2	byte[]
    //   72	312	6	i	int
    //   69	321	7	j	int
    //   85	36	8	k	int
    //   3	174	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	14	146	java/io/FileNotFoundException
    //   5	14	179	java/io/IOException
    //   206	210	213	java/io/IOException
    //   5	14	221	finally
    //   230	234	244	java/io/IOException
    //   238	242	244	java/io/IOException
    //   256	260	270	java/io/IOException
    //   264	268	270	java/io/IOException
    //   289	293	296	java/io/IOException
    //   281	285	300	java/io/IOException
    //   198	202	304	java/io/IOException
    //   161	165	308	java/io/IOException
    //   169	173	308	java/io/IOException
    //   14	23	312	finally
    //   27	34	318	finally
    //   38	45	318	finally
    //   49	61	318	finally
    //   81	90	318	finally
    //   94	101	318	finally
    //   105	113	318	finally
    //   189	194	318	finally
    //   153	157	324	finally
    //   14	23	336	java/io/IOException
    //   27	34	343	java/io/IOException
    //   38	45	343	java/io/IOException
    //   49	61	343	java/io/IOException
    //   81	90	343	java/io/IOException
    //   94	101	343	java/io/IOException
    //   105	113	343	java/io/IOException
    //   14	23	348	java/io/FileNotFoundException
    //   27	34	358	java/io/FileNotFoundException
    //   38	45	358	java/io/FileNotFoundException
    //   49	61	358	java/io/FileNotFoundException
    //   81	90	358	java/io/FileNotFoundException
    //   94	101	358	java/io/FileNotFoundException
    //   105	113	358	java/io/FileNotFoundException
  }
  
  public static byte[] b(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        byte[] arrayOfByte2 = paramString.getBytes("UTF-8");
        int j = arrayOfByte2.length;
        byte[] arrayOfByte1 = new byte[j];
        int i = 0;
        for (;;)
        {
          paramString = arrayOfByte1;
          if (i >= j) {
            break;
          }
          arrayOfByte1[i] = ((byte)(arrayOfByte2[i] ^ 0xCC));
          i += 1;
        }
        return null;
      }
      catch (UnsupportedEncodingException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void a()
    throws IOException
  {
    if (this.a != null) {
      this.a.flush();
    }
  }
  
  public void a(String paramString)
    throws IOException
  {
    if ((this.a == null) || (paramString == null) || (paramString.length() == 0)) {
      return;
    }
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int j = paramString.length;
      if (this.d)
      {
        byte[] arrayOfByte = new byte[j];
        int i = 0;
        while (i < j)
        {
          arrayOfByte[i] = ((byte)(paramString[i] ^ this.b));
          i += 1;
        }
        this.a.write(arrayOfByte);
        return;
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    this.a.write(paramString);
  }
  
  public void b()
    throws IOException
  {
    if (this.a != null) {
      this.a.close();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\sdk\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */