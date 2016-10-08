package com.tencent.bitapp.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils
{
  private static void close(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  public static void delete(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return;
    }
    paramString.delete();
  }
  
  public static String getDecodedFileNameFromEncoded(String paramString)
  {
    int i = paramString.lastIndexOf(".");
    String str = paramString.substring(0, i);
    paramString = paramString.substring(i + 1, paramString.length());
    return str + "(decoded)" + "." + paramString;
  }
  
  public static boolean isChange(Context paramContext, String paramString)
  {
    boolean bool3 = true;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString))
      {
        localFile = new File(paramString);
        bool1 = bool2;
        if (localFile.exists())
        {
          if (!localFile.isFile()) {
            break label95;
          }
          paramContext = SharedPreferencesUtils.getMd5(paramContext, paramString);
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramContext))
          {
            if (!paramContext.equalsIgnoreCase(Md5Utils.getMd5(new File(paramString)))) {
              break label93;
            }
            bool1 = false;
          }
        }
      }
    }
    label93:
    label95:
    int j;
    int i;
    label129:
    do
    {
      do
      {
        do
        {
          return bool1;
          return true;
          bool1 = bool2;
        } while (!localFile.isDirectory());
        paramString = localFile.list();
        bool1 = bool2;
      } while (paramString == null);
      j = paramString.length;
      i = 0;
      bool2 = bool3;
      bool1 = bool2;
    } while (i >= j);
    File localFile = paramString[i];
    if ((bool2) && (isChange(paramContext, localFile))) {}
    for (bool2 = true;; bool2 = false)
    {
      bool1 = bool2;
      if (!bool2) {
        break;
      }
      i += 1;
      break label129;
    }
  }
  
  public static boolean isFileExist(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (!paramString.isFile()));
    return true;
  }
  
  public static boolean isFolderExist(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (!paramString.isDirectory()));
    return true;
  }
  
  public static List<File> listFolder(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = new File(paramString);
    int i;
    if (paramString.isDirectory())
    {
      paramString = paramString.listFiles();
      if (paramString != null)
      {
        i = paramString.length;
        paramInt = 0;
      }
    }
    for (;;)
    {
      if (paramInt >= i) {
        return localArrayList;
      }
      Object localObject = paramString[paramInt];
      if (((File)localObject).isDirectory()) {
        localArrayList.add(localObject);
      }
      paramInt += 1;
    }
  }
  
  /* Error */
  public static byte[] readFile(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_1
    //   4: aconst_null
    //   5: astore 6
    //   7: aconst_null
    //   8: astore 5
    //   10: aload 5
    //   12: astore_2
    //   13: aload 6
    //   15: astore 4
    //   17: new 122	java/io/FileInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 123	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   25: invokestatic 129	java/nio/channels/Channels:newChannel	(Ljava/io/InputStream;)Ljava/nio/channels/ReadableByteChannel;
    //   28: astore_0
    //   29: aload_0
    //   30: astore_1
    //   31: aload 5
    //   33: astore_2
    //   34: aload_0
    //   35: astore_3
    //   36: aload 6
    //   38: astore 4
    //   40: new 131	java/io/ByteArrayOutputStream
    //   43: dup
    //   44: invokespecial 132	java/io/ByteArrayOutputStream:<init>	()V
    //   47: astore 7
    //   49: aload_0
    //   50: astore_1
    //   51: aload 5
    //   53: astore_2
    //   54: aload_0
    //   55: astore_3
    //   56: aload 6
    //   58: astore 4
    //   60: aload 7
    //   62: invokestatic 135	java/nio/channels/Channels:newChannel	(Ljava/io/OutputStream;)Ljava/nio/channels/WritableByteChannel;
    //   65: astore 5
    //   67: aload_0
    //   68: astore_1
    //   69: aload 5
    //   71: astore_2
    //   72: aload_0
    //   73: astore_3
    //   74: aload 5
    //   76: astore 4
    //   78: sipush 1024
    //   81: invokestatic 141	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   84: astore 6
    //   86: aload_0
    //   87: astore_1
    //   88: aload 5
    //   90: astore_2
    //   91: aload_0
    //   92: astore_3
    //   93: aload 5
    //   95: astore 4
    //   97: aload_0
    //   98: aload 6
    //   100: invokeinterface 147 2 0
    //   105: iconst_m1
    //   106: if_icmpne +33 -> 139
    //   109: aload_0
    //   110: astore_1
    //   111: aload 5
    //   113: astore_2
    //   114: aload_0
    //   115: astore_3
    //   116: aload 5
    //   118: astore 4
    //   120: aload 7
    //   122: invokevirtual 151	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   125: astore 6
    //   127: aload_0
    //   128: invokestatic 153	com/tencent/bitapp/utils/FileUtils:close	(Ljava/io/Closeable;)V
    //   131: aload 5
    //   133: invokestatic 153	com/tencent/bitapp/utils/FileUtils:close	(Ljava/io/Closeable;)V
    //   136: aload 6
    //   138: areturn
    //   139: aload_0
    //   140: astore_1
    //   141: aload 5
    //   143: astore_2
    //   144: aload_0
    //   145: astore_3
    //   146: aload 5
    //   148: astore 4
    //   150: aload 6
    //   152: invokevirtual 157	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   155: pop
    //   156: aload_0
    //   157: astore_1
    //   158: aload 5
    //   160: astore_2
    //   161: aload_0
    //   162: astore_3
    //   163: aload 5
    //   165: astore 4
    //   167: aload 5
    //   169: aload 6
    //   171: invokeinterface 162 2 0
    //   176: pop
    //   177: aload_0
    //   178: astore_1
    //   179: aload 5
    //   181: astore_2
    //   182: aload_0
    //   183: astore_3
    //   184: aload 5
    //   186: astore 4
    //   188: aload 6
    //   190: invokevirtual 165	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   193: pop
    //   194: goto -108 -> 86
    //   197: astore_0
    //   198: aload_1
    //   199: astore_3
    //   200: aload_2
    //   201: astore 4
    //   203: aload_0
    //   204: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   207: aload_1
    //   208: invokestatic 153	com/tencent/bitapp/utils/FileUtils:close	(Ljava/io/Closeable;)V
    //   211: aload_2
    //   212: invokestatic 153	com/tencent/bitapp/utils/FileUtils:close	(Ljava/io/Closeable;)V
    //   215: aconst_null
    //   216: areturn
    //   217: astore_0
    //   218: aload_3
    //   219: invokestatic 153	com/tencent/bitapp/utils/FileUtils:close	(Ljava/io/Closeable;)V
    //   222: aload 4
    //   224: invokestatic 153	com/tencent/bitapp/utils/FileUtils:close	(Ljava/io/Closeable;)V
    //   227: aload_0
    //   228: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	paramString	String
    //   3	205	1	str	String
    //   12	200	2	localWritableByteChannel1	java.nio.channels.WritableByteChannel
    //   1	218	3	localObject1	Object
    //   15	208	4	localObject2	Object
    //   8	177	5	localWritableByteChannel2	java.nio.channels.WritableByteChannel
    //   5	184	6	localObject3	Object
    //   47	74	7	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   17	29	197	java/io/IOException
    //   40	49	197	java/io/IOException
    //   60	67	197	java/io/IOException
    //   78	86	197	java/io/IOException
    //   97	109	197	java/io/IOException
    //   120	127	197	java/io/IOException
    //   150	156	197	java/io/IOException
    //   167	177	197	java/io/IOException
    //   188	194	197	java/io/IOException
    //   17	29	217	finally
    //   40	49	217	finally
    //   60	67	217	finally
    //   78	86	217	finally
    //   97	109	217	finally
    //   120	127	217	finally
    //   150	156	217	finally
    //   167	177	217	finally
    //   188	194	217	finally
    //   203	207	217	finally
  }
  
  /* Error */
  public static StringBuilder readFileByBytes(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 21	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 23	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: invokestatic 176	com/tencent/bitapp/utils/StringBuilderUtils:obtain	()Ljava/lang/StringBuilder;
    //   12: astore 5
    //   14: aload_1
    //   15: ifnull +10 -> 25
    //   18: aload_1
    //   19: invokevirtual 75	java/io/File:isFile	()Z
    //   22: ifne +6 -> 28
    //   25: aload 5
    //   27: areturn
    //   28: new 131	java/io/ByteArrayOutputStream
    //   31: dup
    //   32: aload_1
    //   33: invokevirtual 179	java/io/File:length	()J
    //   36: l2i
    //   37: invokespecial 182	java/io/ByteArrayOutputStream:<init>	(I)V
    //   40: astore 4
    //   42: aconst_null
    //   43: astore_0
    //   44: aconst_null
    //   45: astore_3
    //   46: new 184	java/io/BufferedInputStream
    //   49: dup
    //   50: new 122	java/io/FileInputStream
    //   53: dup
    //   54: aload_1
    //   55: invokespecial 187	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   58: invokespecial 190	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   61: astore_1
    //   62: sipush 8192
    //   65: newarray <illegal type>
    //   67: astore_0
    //   68: aload_1
    //   69: aload_0
    //   70: iconst_0
    //   71: sipush 8192
    //   74: invokevirtual 193	java/io/BufferedInputStream:read	([BII)I
    //   77: istore 6
    //   79: iconst_m1
    //   80: iload 6
    //   82: if_icmpne +42 -> 124
    //   85: aload 5
    //   87: new 35	java/lang/String
    //   90: dup
    //   91: aload 4
    //   93: invokevirtual 151	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   96: invokespecial 196	java/lang/String:<init>	([B)V
    //   99: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload_1
    //   104: ifnull +7 -> 111
    //   107: aload_1
    //   108: invokevirtual 197	java/io/BufferedInputStream:close	()V
    //   111: aload 4
    //   113: ifnull +117 -> 230
    //   116: aload 4
    //   118: invokevirtual 198	java/io/ByteArrayOutputStream:close	()V
    //   121: aload 5
    //   123: areturn
    //   124: aload 4
    //   126: aload_0
    //   127: iconst_0
    //   128: iload 6
    //   130: invokevirtual 201	java/io/ByteArrayOutputStream:write	([BII)V
    //   133: goto -65 -> 68
    //   136: astore_2
    //   137: aload_1
    //   138: astore_0
    //   139: aload_2
    //   140: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   143: aload_1
    //   144: ifnull +7 -> 151
    //   147: aload_1
    //   148: invokevirtual 197	java/io/BufferedInputStream:close	()V
    //   151: aload 4
    //   153: ifnull -128 -> 25
    //   156: aload 4
    //   158: invokevirtual 198	java/io/ByteArrayOutputStream:close	()V
    //   161: aload 5
    //   163: areturn
    //   164: astore_0
    //   165: aload_0
    //   166: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   169: aload 5
    //   171: areturn
    //   172: astore_0
    //   173: aload_0
    //   174: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   177: goto -26 -> 151
    //   180: astore_1
    //   181: aload_0
    //   182: ifnull +7 -> 189
    //   185: aload_0
    //   186: invokevirtual 197	java/io/BufferedInputStream:close	()V
    //   189: aload 4
    //   191: ifnull +8 -> 199
    //   194: aload 4
    //   196: invokevirtual 198	java/io/ByteArrayOutputStream:close	()V
    //   199: aload_1
    //   200: athrow
    //   201: astore_0
    //   202: aload_0
    //   203: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   206: goto -17 -> 189
    //   209: astore_0
    //   210: aload_0
    //   211: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   214: goto -15 -> 199
    //   217: astore_0
    //   218: aload_0
    //   219: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   222: goto -111 -> 111
    //   225: astore_0
    //   226: aload_0
    //   227: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   230: aload 5
    //   232: areturn
    //   233: astore_2
    //   234: aload_1
    //   235: astore_0
    //   236: aload_2
    //   237: astore_1
    //   238: goto -57 -> 181
    //   241: astore_2
    //   242: aload_3
    //   243: astore_1
    //   244: goto -107 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	paramString1	String
    //   0	247	1	paramString2	String
    //   136	4	2	localIOException1	IOException
    //   233	4	2	localObject1	Object
    //   241	1	2	localIOException2	IOException
    //   45	198	3	localObject2	Object
    //   40	155	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   12	219	5	localStringBuilder	StringBuilder
    //   77	52	6	i	int
    // Exception table:
    //   from	to	target	type
    //   62	68	136	java/io/IOException
    //   68	79	136	java/io/IOException
    //   85	103	136	java/io/IOException
    //   124	133	136	java/io/IOException
    //   156	161	164	java/io/IOException
    //   147	151	172	java/io/IOException
    //   46	62	180	finally
    //   139	143	180	finally
    //   185	189	201	java/io/IOException
    //   194	199	209	java/io/IOException
    //   107	111	217	java/io/IOException
    //   116	121	225	java/io/IOException
    //   62	68	233	finally
    //   68	79	233	finally
    //   85	103	233	finally
    //   124	133	233	finally
    //   46	62	241	java/io/IOException
  }
  
  public static String readFileByBytesToString(String paramString1, String paramString2)
  {
    return readFileByBytes(paramString1, paramString2).toString();
  }
  
  /* Error */
  public static String readFileByLine(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 21	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 23	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: invokestatic 176	com/tencent/bitapp/utils/StringBuilderUtils:obtain	()Ljava/lang/StringBuilder;
    //   13: astore_2
    //   14: aload 4
    //   16: ifnull +11 -> 27
    //   19: aload 4
    //   21: invokevirtual 75	java/io/File:isFile	()Z
    //   24: ifne +10 -> 34
    //   27: aload_2
    //   28: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: astore_2
    //   32: aload_2
    //   33: areturn
    //   34: aconst_null
    //   35: astore_0
    //   36: aconst_null
    //   37: astore_3
    //   38: new 208	java/io/BufferedReader
    //   41: dup
    //   42: new 210	java/io/InputStreamReader
    //   45: dup
    //   46: new 122	java/io/FileInputStream
    //   49: dup
    //   50: aload 4
    //   52: invokespecial 187	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   55: aload_1
    //   56: invokespecial 213	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   59: invokespecial 216	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   62: astore_1
    //   63: aload_1
    //   64: invokevirtual 219	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   67: astore_0
    //   68: aload_0
    //   69: ifnonnull +27 -> 96
    //   72: aload_2
    //   73: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: astore_0
    //   77: aload_0
    //   78: astore_2
    //   79: aload_1
    //   80: ifnull -48 -> 32
    //   83: aload_1
    //   84: invokevirtual 220	java/io/BufferedReader:close	()V
    //   87: aload_0
    //   88: areturn
    //   89: astore_1
    //   90: aload_1
    //   91: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   94: aload_0
    //   95: areturn
    //   96: aload_2
    //   97: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: ldc -34
    //   102: invokevirtual 225	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   105: ifne +10 -> 115
    //   108: aload_2
    //   109: ldc -29
    //   111: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload_2
    //   116: aload_0
    //   117: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: goto -58 -> 63
    //   124: astore_2
    //   125: aload_1
    //   126: astore_0
    //   127: aload_2
    //   128: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   131: aload_1
    //   132: ifnull +7 -> 139
    //   135: aload_1
    //   136: invokevirtual 220	java/io/BufferedReader:close	()V
    //   139: ldc -34
    //   141: areturn
    //   142: astore_0
    //   143: aload_0
    //   144: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   147: goto -8 -> 139
    //   150: astore_1
    //   151: aload_0
    //   152: ifnull +7 -> 159
    //   155: aload_0
    //   156: invokevirtual 220	java/io/BufferedReader:close	()V
    //   159: aload_1
    //   160: athrow
    //   161: astore_0
    //   162: aload_0
    //   163: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   166: goto -7 -> 159
    //   169: astore_2
    //   170: aload_1
    //   171: astore_0
    //   172: aload_2
    //   173: astore_1
    //   174: goto -23 -> 151
    //   177: astore_2
    //   178: aload_3
    //   179: astore_1
    //   180: goto -55 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	paramString1	String
    //   0	183	1	paramString2	String
    //   13	103	2	localObject1	Object
    //   124	4	2	localIOException1	IOException
    //   169	4	2	localObject2	Object
    //   177	1	2	localIOException2	IOException
    //   37	142	3	localObject3	Object
    //   8	43	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   83	87	89	java/io/IOException
    //   63	68	124	java/io/IOException
    //   72	77	124	java/io/IOException
    //   96	115	124	java/io/IOException
    //   115	121	124	java/io/IOException
    //   135	139	142	java/io/IOException
    //   38	63	150	finally
    //   127	131	150	finally
    //   155	159	161	java/io/IOException
    //   63	68	169	finally
    //   72	77	169	finally
    //   96	115	169	finally
    //   115	121	169	finally
    //   38	63	177	java/io/IOException
  }
  
  /* Error */
  public static boolean writeFile(java.io.InputStream paramInputStream, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 11
    //   3: iload 11
    //   5: istore 10
    //   7: aload_0
    //   8: ifnull +123 -> 131
    //   11: iload 11
    //   13: istore 10
    //   15: aload_1
    //   16: invokestatic 72	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifne +112 -> 131
    //   22: aconst_null
    //   23: astore 7
    //   25: aconst_null
    //   26: astore 4
    //   28: aconst_null
    //   29: astore 5
    //   31: aconst_null
    //   32: astore 8
    //   34: aconst_null
    //   35: astore 6
    //   37: aload 7
    //   39: astore_2
    //   40: aload 8
    //   42: astore_3
    //   43: new 21	java/io/File
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 23	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: invokevirtual 233	java/io/File:getParentFile	()Ljava/io/File;
    //   54: invokevirtual 236	java/io/File:mkdirs	()Z
    //   57: pop
    //   58: aload 7
    //   60: astore_2
    //   61: aload 8
    //   63: astore_3
    //   64: new 238	java/io/FileOutputStream
    //   67: dup
    //   68: aload_1
    //   69: invokespecial 239	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   72: astore_1
    //   73: sipush 1024
    //   76: newarray <illegal type>
    //   78: astore_2
    //   79: aload_0
    //   80: aload_2
    //   81: invokevirtual 244	java/io/InputStream:read	([B)I
    //   84: istore 9
    //   86: iload 9
    //   88: ifgt +46 -> 134
    //   91: new 246	java/io/BufferedOutputStream
    //   94: dup
    //   95: aload_1
    //   96: invokespecial 249	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   99: astore_0
    //   100: aload_0
    //   101: invokevirtual 252	java/io/BufferedOutputStream:flush	()V
    //   104: iconst_1
    //   105: istore 11
    //   107: aload_0
    //   108: ifnull +7 -> 115
    //   111: aload_0
    //   112: invokevirtual 253	java/io/BufferedOutputStream:close	()V
    //   115: iload 11
    //   117: istore 10
    //   119: aload_1
    //   120: ifnull +11 -> 131
    //   123: aload_1
    //   124: invokevirtual 254	java/io/FileOutputStream:close	()V
    //   127: iload 11
    //   129: istore 10
    //   131: iload 10
    //   133: ireturn
    //   134: aload_1
    //   135: aload_2
    //   136: iconst_0
    //   137: iload 9
    //   139: invokevirtual 255	java/io/FileOutputStream:write	([BII)V
    //   142: goto -63 -> 79
    //   145: astore 4
    //   147: aload_1
    //   148: astore_0
    //   149: aload 5
    //   151: astore_1
    //   152: aload_1
    //   153: astore_2
    //   154: aload_0
    //   155: astore_3
    //   156: aload 4
    //   158: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   161: aload_1
    //   162: ifnull +7 -> 169
    //   165: aload_1
    //   166: invokevirtual 253	java/io/BufferedOutputStream:close	()V
    //   169: iload 11
    //   171: istore 10
    //   173: aload_0
    //   174: ifnull -43 -> 131
    //   177: aload_0
    //   178: invokevirtual 254	java/io/FileOutputStream:close	()V
    //   181: iconst_0
    //   182: ireturn
    //   183: astore_0
    //   184: aload_0
    //   185: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   188: iconst_0
    //   189: ireturn
    //   190: astore_0
    //   191: aload_2
    //   192: ifnull +7 -> 199
    //   195: aload_2
    //   196: invokevirtual 253	java/io/BufferedOutputStream:close	()V
    //   199: aload_3
    //   200: ifnull +7 -> 207
    //   203: aload_3
    //   204: invokevirtual 254	java/io/FileOutputStream:close	()V
    //   207: aload_0
    //   208: athrow
    //   209: astore_1
    //   210: aload_1
    //   211: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   214: goto -7 -> 207
    //   217: astore_0
    //   218: aload_0
    //   219: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   222: iconst_1
    //   223: ireturn
    //   224: astore_0
    //   225: aload 4
    //   227: astore_2
    //   228: aload_1
    //   229: astore_3
    //   230: goto -39 -> 191
    //   233: astore 4
    //   235: aload_0
    //   236: astore_2
    //   237: aload_1
    //   238: astore_3
    //   239: aload 4
    //   241: astore_0
    //   242: goto -51 -> 191
    //   245: astore 4
    //   247: aload 5
    //   249: astore_1
    //   250: aload 6
    //   252: astore_0
    //   253: goto -101 -> 152
    //   256: astore 4
    //   258: aload_1
    //   259: astore_2
    //   260: aload_0
    //   261: astore_1
    //   262: aload_2
    //   263: astore_0
    //   264: goto -112 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	paramInputStream	java.io.InputStream
    //   0	267	1	paramString	String
    //   39	224	2	localObject1	Object
    //   42	197	3	localObject2	Object
    //   26	1	4	localObject3	Object
    //   145	81	4	localIOException1	IOException
    //   233	7	4	localObject4	Object
    //   245	1	4	localIOException2	IOException
    //   256	1	4	localIOException3	IOException
    //   29	219	5	localObject5	Object
    //   35	216	6	localObject6	Object
    //   23	36	7	localObject7	Object
    //   32	30	8	localObject8	Object
    //   84	54	9	i	int
    //   5	167	10	bool1	boolean
    //   1	169	11	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   73	79	145	java/io/IOException
    //   79	86	145	java/io/IOException
    //   91	100	145	java/io/IOException
    //   134	142	145	java/io/IOException
    //   165	169	183	java/io/IOException
    //   177	181	183	java/io/IOException
    //   43	58	190	finally
    //   64	73	190	finally
    //   156	161	190	finally
    //   195	199	209	java/io/IOException
    //   203	207	209	java/io/IOException
    //   111	115	217	java/io/IOException
    //   123	127	217	java/io/IOException
    //   73	79	224	finally
    //   79	86	224	finally
    //   91	100	224	finally
    //   134	142	224	finally
    //   100	104	233	finally
    //   43	58	245	java/io/IOException
    //   64	73	245	java/io/IOException
    //   100	104	256	java/io/IOException
  }
  
  public static boolean writeFile(String paramString1, String paramString2)
  {
    TextUtils.isEmpty(paramString1);
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    return writeFile(paramString1.getBytes(), paramString2);
  }
  
  /* Error */
  public static boolean writeFile(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: iload 10
    //   5: istore 9
    //   7: aload_0
    //   8: ifnull +99 -> 107
    //   11: aconst_null
    //   12: astore 7
    //   14: aconst_null
    //   15: astore 4
    //   17: aconst_null
    //   18: astore 5
    //   20: aconst_null
    //   21: astore 8
    //   23: aconst_null
    //   24: astore 6
    //   26: aload 7
    //   28: astore_2
    //   29: aload 8
    //   31: astore_3
    //   32: new 21	java/io/File
    //   35: dup
    //   36: aload_1
    //   37: invokespecial 23	java/io/File:<init>	(Ljava/lang/String;)V
    //   40: invokevirtual 233	java/io/File:getParentFile	()Ljava/io/File;
    //   43: invokevirtual 236	java/io/File:mkdirs	()Z
    //   46: pop
    //   47: aload 7
    //   49: astore_2
    //   50: aload 8
    //   52: astore_3
    //   53: new 238	java/io/FileOutputStream
    //   56: dup
    //   57: aload_1
    //   58: invokespecial 239	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   61: astore_1
    //   62: aload_1
    //   63: aload_0
    //   64: invokevirtual 264	java/io/FileOutputStream:write	([B)V
    //   67: new 246	java/io/BufferedOutputStream
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 249	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   75: astore_0
    //   76: aload_0
    //   77: invokevirtual 252	java/io/BufferedOutputStream:flush	()V
    //   80: iconst_1
    //   81: istore 10
    //   83: aload_0
    //   84: ifnull +7 -> 91
    //   87: aload_0
    //   88: invokevirtual 253	java/io/BufferedOutputStream:close	()V
    //   91: iload 10
    //   93: istore 9
    //   95: aload_1
    //   96: ifnull +11 -> 107
    //   99: aload_1
    //   100: invokevirtual 254	java/io/FileOutputStream:close	()V
    //   103: iload 10
    //   105: istore 9
    //   107: iload 9
    //   109: ireturn
    //   110: astore 4
    //   112: aload 6
    //   114: astore_0
    //   115: aload 5
    //   117: astore_1
    //   118: aload_1
    //   119: astore_2
    //   120: aload_0
    //   121: astore_3
    //   122: aload 4
    //   124: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   127: aload_1
    //   128: ifnull +7 -> 135
    //   131: aload_1
    //   132: invokevirtual 253	java/io/BufferedOutputStream:close	()V
    //   135: iload 10
    //   137: istore 9
    //   139: aload_0
    //   140: ifnull -33 -> 107
    //   143: aload_0
    //   144: invokevirtual 254	java/io/FileOutputStream:close	()V
    //   147: iconst_0
    //   148: ireturn
    //   149: astore_0
    //   150: aload_0
    //   151: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   154: iconst_0
    //   155: ireturn
    //   156: astore_0
    //   157: aload_2
    //   158: ifnull +7 -> 165
    //   161: aload_2
    //   162: invokevirtual 253	java/io/BufferedOutputStream:close	()V
    //   165: aload_3
    //   166: ifnull +7 -> 173
    //   169: aload_3
    //   170: invokevirtual 254	java/io/FileOutputStream:close	()V
    //   173: aload_0
    //   174: athrow
    //   175: astore_1
    //   176: aload_1
    //   177: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   180: goto -7 -> 173
    //   183: astore_0
    //   184: aload_0
    //   185: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   188: iconst_1
    //   189: ireturn
    //   190: astore_0
    //   191: aload 4
    //   193: astore_2
    //   194: aload_1
    //   195: astore_3
    //   196: goto -39 -> 157
    //   199: astore 4
    //   201: aload_0
    //   202: astore_2
    //   203: aload_1
    //   204: astore_3
    //   205: aload 4
    //   207: astore_0
    //   208: goto -51 -> 157
    //   211: astore 4
    //   213: aload_1
    //   214: astore_0
    //   215: aload 5
    //   217: astore_1
    //   218: goto -100 -> 118
    //   221: astore 4
    //   223: aload_1
    //   224: astore_2
    //   225: aload_0
    //   226: astore_1
    //   227: aload_2
    //   228: astore_0
    //   229: goto -111 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	paramArrayOfByte	byte[]
    //   0	232	1	paramString	String
    //   28	200	2	localObject1	Object
    //   31	174	3	localObject2	Object
    //   15	1	4	localObject3	Object
    //   110	82	4	localIOException1	IOException
    //   199	7	4	localObject4	Object
    //   211	1	4	localIOException2	IOException
    //   221	1	4	localIOException3	IOException
    //   18	198	5	localObject5	Object
    //   24	89	6	localObject6	Object
    //   12	36	7	localObject7	Object
    //   21	30	8	localObject8	Object
    //   5	133	9	bool1	boolean
    //   1	135	10	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   32	47	110	java/io/IOException
    //   53	62	110	java/io/IOException
    //   131	135	149	java/io/IOException
    //   143	147	149	java/io/IOException
    //   32	47	156	finally
    //   53	62	156	finally
    //   122	127	156	finally
    //   161	165	175	java/io/IOException
    //   169	173	175	java/io/IOException
    //   87	91	183	java/io/IOException
    //   99	103	183	java/io/IOException
    //   62	76	190	finally
    //   76	80	199	finally
    //   62	76	211	java/io/IOException
    //   76	80	221	java/io/IOException
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\utils\FileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */