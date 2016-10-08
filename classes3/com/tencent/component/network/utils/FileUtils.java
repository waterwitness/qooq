package com.tencent.component.network.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;

public class FileUtils
{
  public static final AssetFileComparator SIMPLE_ASSET_COMPARATOR = new b();
  public static final FileComparator SIMPLE_COMPARATOR = new a();
  private static final BytesBufferPool a = new BytesBufferPool(2, 8192);
  
  private static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
  }
  
  /* Error */
  private static boolean a(Context paramContext, String paramString1, String paramString2, AssetFileComparator paramAssetFileComparator)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_1
    //   7: invokestatic 51	com/tencent/component/network/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   10: ifne +10 -> 20
    //   13: aload_2
    //   14: invokestatic 51	com/tencent/component/network/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   17: ifeq +5 -> 22
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_0
    //   23: invokevirtual 57	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   26: astore 7
    //   28: new 59	java/io/File
    //   31: dup
    //   32: aload_2
    //   33: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore 6
    //   38: aload 6
    //   40: invokevirtual 66	java/io/File:exists	()Z
    //   43: ifeq +47 -> 90
    //   46: aload_3
    //   47: ifnull +30 -> 77
    //   50: aload_3
    //   51: aload_0
    //   52: aload_1
    //   53: aload 6
    //   55: invokeinterface 70 4 0
    //   60: istore 9
    //   62: iload 9
    //   64: ifeq +13 -> 77
    //   67: aconst_null
    //   68: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   71: aconst_null
    //   72: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   75: iconst_1
    //   76: ireturn
    //   77: aload 6
    //   79: invokevirtual 75	java/io/File:isDirectory	()Z
    //   82: ifeq +8 -> 90
    //   85: aload 6
    //   87: invokestatic 79	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   90: aload 6
    //   92: invokevirtual 83	java/io/File:getParentFile	()Ljava/io/File;
    //   95: astore_0
    //   96: aload_0
    //   97: invokevirtual 86	java/io/File:isFile	()Z
    //   100: ifeq +7 -> 107
    //   103: aload_0
    //   104: invokestatic 79	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   107: aload_0
    //   108: invokevirtual 66	java/io/File:exists	()Z
    //   111: ifne +24 -> 135
    //   114: aload_0
    //   115: invokevirtual 89	java/io/File:mkdirs	()Z
    //   118: istore 9
    //   120: iload 9
    //   122: ifne +13 -> 135
    //   125: aconst_null
    //   126: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   129: aconst_null
    //   130: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   133: iconst_0
    //   134: ireturn
    //   135: aload 7
    //   137: aload_1
    //   138: invokevirtual 95	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   141: astore_0
    //   142: new 97	java/io/BufferedOutputStream
    //   145: dup
    //   146: new 99	java/io/FileOutputStream
    //   149: dup
    //   150: aload 6
    //   152: invokespecial 101	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   155: invokespecial 104	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   158: astore_1
    //   159: sipush 1024
    //   162: newarray <illegal type>
    //   164: astore_2
    //   165: aload_0
    //   166: aload_2
    //   167: invokevirtual 110	java/io/InputStream:read	([B)I
    //   170: istore 8
    //   172: iload 8
    //   174: ifgt +13 -> 187
    //   177: aload_0
    //   178: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   181: aload_1
    //   182: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   185: iconst_1
    //   186: ireturn
    //   187: aload_1
    //   188: aload_2
    //   189: iconst_0
    //   190: iload 8
    //   192: invokevirtual 116	java/io/OutputStream:write	([BII)V
    //   195: goto -30 -> 165
    //   198: astore_3
    //   199: aload_1
    //   200: astore_2
    //   201: aload_3
    //   202: astore_1
    //   203: ldc 118
    //   205: ldc 120
    //   207: aload_1
    //   208: invokestatic 125	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   211: aload 6
    //   213: invokestatic 79	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   216: aload_0
    //   217: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   220: aload_2
    //   221: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   224: iconst_0
    //   225: ireturn
    //   226: astore_1
    //   227: aconst_null
    //   228: astore_0
    //   229: aload 5
    //   231: astore_2
    //   232: aload_0
    //   233: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   236: aload_2
    //   237: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   240: aload_1
    //   241: athrow
    //   242: astore_1
    //   243: aload 5
    //   245: astore_2
    //   246: goto -14 -> 232
    //   249: astore_3
    //   250: aload_1
    //   251: astore_2
    //   252: aload_3
    //   253: astore_1
    //   254: goto -22 -> 232
    //   257: astore_1
    //   258: goto -26 -> 232
    //   261: astore_1
    //   262: aconst_null
    //   263: astore_0
    //   264: aload 4
    //   266: astore_2
    //   267: goto -64 -> 203
    //   270: astore_1
    //   271: aload 4
    //   273: astore_2
    //   274: goto -71 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	paramContext	Context
    //   0	277	1	paramString1	String
    //   0	277	2	paramString2	String
    //   0	277	3	paramAssetFileComparator	AssetFileComparator
    //   4	268	4	localObject1	Object
    //   1	243	5	localObject2	Object
    //   36	176	6	localFile	File
    //   26	110	7	localAssetManager	android.content.res.AssetManager
    //   170	21	8	i	int
    //   60	61	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   159	165	198	java/lang/Throwable
    //   165	172	198	java/lang/Throwable
    //   187	195	198	java/lang/Throwable
    //   38	46	226	finally
    //   50	62	226	finally
    //   77	90	226	finally
    //   90	107	226	finally
    //   107	120	226	finally
    //   135	142	226	finally
    //   142	159	242	finally
    //   159	165	249	finally
    //   165	172	249	finally
    //   187	195	249	finally
    //   203	216	257	finally
    //   38	46	261	java/lang/Throwable
    //   50	62	261	java/lang/Throwable
    //   77	90	261	java/lang/Throwable
    //   90	107	261	java/lang/Throwable
    //   107	120	261	java/lang/Throwable
    //   135	142	261	java/lang/Throwable
    //   142	159	270	java/lang/Throwable
  }
  
  /* Error */
  private static boolean a(File paramFile1, File paramFile2, FileFilter paramFileFilter, FileComparator paramFileComparator)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: ifnull +7 -> 14
    //   10: aload_1
    //   11: ifnonnull +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_2
    //   17: ifnull +15 -> 32
    //   20: aload_2
    //   21: aload_0
    //   22: invokeinterface 132 2 0
    //   27: ifne +5 -> 32
    //   30: iconst_0
    //   31: ireturn
    //   32: aload_0
    //   33: invokevirtual 66	java/io/File:exists	()Z
    //   36: ifeq +14 -> 50
    //   39: aload_0
    //   40: invokevirtual 86	java/io/File:isFile	()Z
    //   43: istore 6
    //   45: iload 6
    //   47: ifne +13 -> 60
    //   50: aconst_null
    //   51: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   54: aconst_null
    //   55: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   58: iconst_0
    //   59: ireturn
    //   60: aload_1
    //   61: invokevirtual 66	java/io/File:exists	()Z
    //   64: ifeq +37 -> 101
    //   67: aload_3
    //   68: ifnull +28 -> 96
    //   71: aload_3
    //   72: aload_0
    //   73: aload_1
    //   74: invokeinterface 135 3 0
    //   79: istore 6
    //   81: iload 6
    //   83: ifeq +13 -> 96
    //   86: aconst_null
    //   87: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   90: aconst_null
    //   91: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   94: iconst_1
    //   95: ireturn
    //   96: aload_1
    //   97: iconst_0
    //   98: invokestatic 138	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;Z)V
    //   101: aload_1
    //   102: invokevirtual 83	java/io/File:getParentFile	()Ljava/io/File;
    //   105: astore_2
    //   106: aload_2
    //   107: invokevirtual 86	java/io/File:isFile	()Z
    //   110: ifeq +8 -> 118
    //   113: aload_2
    //   114: iconst_0
    //   115: invokestatic 138	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;Z)V
    //   118: aload_2
    //   119: invokevirtual 66	java/io/File:exists	()Z
    //   122: ifne +24 -> 146
    //   125: aload_2
    //   126: invokevirtual 89	java/io/File:mkdirs	()Z
    //   129: istore 6
    //   131: iload 6
    //   133: ifne +13 -> 146
    //   136: aconst_null
    //   137: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   140: aconst_null
    //   141: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   144: iconst_0
    //   145: ireturn
    //   146: new 140	java/io/FileInputStream
    //   149: dup
    //   150: aload_0
    //   151: invokespecial 141	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   154: invokevirtual 145	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   157: astore_0
    //   158: new 99	java/io/FileOutputStream
    //   161: dup
    //   162: aload_1
    //   163: invokespecial 101	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   166: invokevirtual 146	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   169: astore_3
    //   170: aload_3
    //   171: aload_0
    //   172: lconst_0
    //   173: aload_0
    //   174: invokevirtual 152	java/nio/channels/FileChannel:size	()J
    //   177: invokevirtual 156	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   180: pop2
    //   181: aload_0
    //   182: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   185: aload_3
    //   186: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   189: iconst_1
    //   190: ireturn
    //   191: astore_3
    //   192: aconst_null
    //   193: astore_0
    //   194: aload 5
    //   196: astore_2
    //   197: ldc 118
    //   199: ldc -98
    //   201: aload_3
    //   202: invokestatic 125	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   205: aload_1
    //   206: invokestatic 79	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   209: aload_2
    //   210: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   213: aload_0
    //   214: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   217: iconst_0
    //   218: ireturn
    //   219: astore_1
    //   220: aconst_null
    //   221: astore_0
    //   222: aload 4
    //   224: astore_2
    //   225: aload_0
    //   226: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   229: aload_2
    //   230: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   233: aload_1
    //   234: athrow
    //   235: astore_1
    //   236: aload 4
    //   238: astore_2
    //   239: goto -14 -> 225
    //   242: astore_1
    //   243: aload_3
    //   244: astore_2
    //   245: goto -20 -> 225
    //   248: astore_1
    //   249: aload_0
    //   250: astore_3
    //   251: aload_2
    //   252: astore_0
    //   253: aload_3
    //   254: astore_2
    //   255: goto -30 -> 225
    //   258: astore_3
    //   259: aload_0
    //   260: astore_2
    //   261: aconst_null
    //   262: astore_0
    //   263: goto -66 -> 197
    //   266: astore 4
    //   268: aload_0
    //   269: astore_2
    //   270: aload_3
    //   271: astore_0
    //   272: aload 4
    //   274: astore_3
    //   275: goto -78 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	paramFile1	File
    //   0	278	1	paramFile2	File
    //   0	278	2	paramFileFilter	FileFilter
    //   0	278	3	paramFileComparator	FileComparator
    //   1	236	4	localObject1	Object
    //   266	7	4	localThrowable	Throwable
    //   4	191	5	localObject2	Object
    //   43	89	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   32	45	191	java/lang/Throwable
    //   60	67	191	java/lang/Throwable
    //   71	81	191	java/lang/Throwable
    //   96	101	191	java/lang/Throwable
    //   101	118	191	java/lang/Throwable
    //   118	131	191	java/lang/Throwable
    //   146	158	191	java/lang/Throwable
    //   32	45	219	finally
    //   60	67	219	finally
    //   71	81	219	finally
    //   96	101	219	finally
    //   101	118	219	finally
    //   118	131	219	finally
    //   146	158	219	finally
    //   158	170	235	finally
    //   170	181	242	finally
    //   197	209	248	finally
    //   158	170	258	java/lang/Throwable
    //   170	181	266	java/lang/Throwable
  }
  
  private static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static boolean copyAssets(Context paramContext, String paramString1, String paramString2)
  {
    return copyAssets(paramContext, paramString1, paramString2, SIMPLE_ASSET_COMPARATOR);
  }
  
  public static boolean copyAssets(Context paramContext, String paramString1, String paramString2, AssetFileComparator paramAssetFileComparator)
  {
    return a(paramContext, paramString1, paramString2, paramAssetFileComparator);
  }
  
  /* Error */
  public static boolean copyFile(String paramString, java.io.OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +7 -> 11
    //   7: aload_1
    //   8: ifnonnull +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: getstatic 37	com/tencent/component/network/utils/FileUtils:a	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   16: invokevirtual 182	com/tencent/component/network/utils/BytesBufferPool:get	()Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;
    //   19: astore_3
    //   20: new 59	java/io/File
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: astore_0
    //   29: aload_0
    //   30: invokevirtual 66	java/io/File:exists	()Z
    //   33: ifeq +14 -> 47
    //   36: aload_0
    //   37: invokevirtual 86	java/io/File:isFile	()Z
    //   40: istore 5
    //   42: iload 5
    //   44: ifne +12 -> 56
    //   47: getstatic 37	com/tencent/component/network/utils/FileUtils:a	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   50: aload_3
    //   51: invokevirtual 186	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   54: iconst_0
    //   55: ireturn
    //   56: new 140	java/io/FileInputStream
    //   59: dup
    //   60: aload_0
    //   61: invokespecial 141	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   64: astore_2
    //   65: aload_2
    //   66: astore_0
    //   67: aload_2
    //   68: aload_3
    //   69: getfield 192	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   72: iconst_0
    //   73: aload_3
    //   74: getfield 192	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   77: arraylength
    //   78: invokevirtual 195	java/io/InputStream:read	([BII)I
    //   81: istore 4
    //   83: iload 4
    //   85: ifgt +16 -> 101
    //   88: getstatic 37	com/tencent/component/network/utils/FileUtils:a	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   91: aload_3
    //   92: invokevirtual 186	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   95: aload_2
    //   96: invokevirtual 196	java/io/InputStream:close	()V
    //   99: iconst_1
    //   100: ireturn
    //   101: aload_2
    //   102: astore_0
    //   103: aload_1
    //   104: aload_3
    //   105: getfield 192	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   108: iconst_0
    //   109: iload 4
    //   111: invokevirtual 116	java/io/OutputStream:write	([BII)V
    //   114: goto -49 -> 65
    //   117: astore_0
    //   118: aload_2
    //   119: astore_1
    //   120: aload_0
    //   121: astore_2
    //   122: aload_1
    //   123: astore_0
    //   124: ldc 118
    //   126: ldc -58
    //   128: aload_2
    //   129: invokestatic 204	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   132: pop
    //   133: getstatic 37	com/tencent/component/network/utils/FileUtils:a	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   136: aload_3
    //   137: invokevirtual 186	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   140: aload_1
    //   141: ifnull -130 -> 11
    //   144: aload_1
    //   145: invokevirtual 196	java/io/InputStream:close	()V
    //   148: iconst_0
    //   149: ireturn
    //   150: astore_0
    //   151: iconst_0
    //   152: ireturn
    //   153: astore_1
    //   154: aconst_null
    //   155: astore_0
    //   156: getstatic 37	com/tencent/component/network/utils/FileUtils:a	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   159: aload_3
    //   160: invokevirtual 186	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   163: aload_0
    //   164: ifnull +7 -> 171
    //   167: aload_0
    //   168: invokevirtual 196	java/io/InputStream:close	()V
    //   171: aload_1
    //   172: athrow
    //   173: astore_0
    //   174: goto -3 -> 171
    //   177: astore_0
    //   178: goto -79 -> 99
    //   181: astore_1
    //   182: goto -26 -> 156
    //   185: astore_2
    //   186: aconst_null
    //   187: astore_1
    //   188: goto -66 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	paramString	String
    //   0	191	1	paramOutputStream	java.io.OutputStream
    //   64	65	2	localObject	Object
    //   185	1	2	localThrowable	Throwable
    //   19	141	3	localBytesBuffer	BytesBufferPool.BytesBuffer
    //   81	29	4	i	int
    //   40	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   67	83	117	java/lang/Throwable
    //   103	114	117	java/lang/Throwable
    //   144	148	150	java/lang/Throwable
    //   20	42	153	finally
    //   56	65	153	finally
    //   167	171	173	java/lang/Throwable
    //   95	99	177	java/lang/Throwable
    //   67	83	181	finally
    //   103	114	181	finally
    //   124	133	181	finally
    //   20	42	185	java/lang/Throwable
    //   56	65	185	java/lang/Throwable
  }
  
  public static boolean copyFiles(File paramFile1, File paramFile2)
  {
    return copyFiles(paramFile1, paramFile2, null);
  }
  
  public static boolean copyFiles(File paramFile1, File paramFile2, FileFilter paramFileFilter)
  {
    return copyFiles(paramFile1, paramFile2, paramFileFilter, SIMPLE_COMPARATOR);
  }
  
  public static boolean copyFiles(File paramFile1, File paramFile2, FileFilter paramFileFilter, FileComparator paramFileComparator)
  {
    if ((paramFile1 == null) || (paramFile2 == null)) {}
    do
    {
      do
      {
        return false;
      } while (!paramFile1.exists());
      if (paramFile1.isFile()) {
        return a(paramFile1, paramFile2, paramFileFilter, paramFileComparator);
      }
      paramFile1 = paramFile1.listFiles();
    } while (paramFile1 == null);
    boolean bool = true;
    int j = paramFile1.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return bool;
      }
      paramFileComparator = paramFile1[i];
      if (!copyFiles(paramFileComparator, new File(paramFile2, paramFileComparator.getName()), paramFileFilter)) {
        bool = false;
      }
      i += 1;
    }
  }
  
  public static void delete(File paramFile)
  {
    delete(paramFile, false);
  }
  
  public static void delete(File paramFile, boolean paramBoolean)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    File[] arrayOfFile;
    do
    {
      return;
      if (paramFile.isFile())
      {
        paramFile.delete();
        return;
      }
      arrayOfFile = paramFile.listFiles();
    } while (arrayOfFile == null);
    int j = arrayOfFile.length;
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        if (paramBoolean) {
          break;
        }
        paramFile.delete();
        return;
      }
      delete(arrayOfFile[i], paramBoolean);
      i += 1;
    }
  }
  
  public static void delete(String paramString)
  {
    delete(paramString, false);
  }
  
  public static void delete(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    delete(new File(paramString), paramBoolean);
  }
  
  /* Error */
  public static long getAssetLength(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 57	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: astore_2
    //   5: aload_2
    //   6: aload_1
    //   7: invokevirtual 236	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   10: invokevirtual 241	android/content/res/AssetFileDescriptor:getLength	()J
    //   13: lstore 4
    //   15: lload 4
    //   17: lreturn
    //   18: astore_0
    //   19: aconst_null
    //   20: astore_0
    //   21: aload_2
    //   22: aload_1
    //   23: invokevirtual 95	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   26: astore_1
    //   27: aload_1
    //   28: astore_0
    //   29: aload_0
    //   30: invokevirtual 244	java/io/InputStream:available	()I
    //   33: istore_3
    //   34: iload_3
    //   35: i2l
    //   36: lstore 4
    //   38: aload_0
    //   39: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   42: lload 4
    //   44: lreturn
    //   45: astore_1
    //   46: aload_0
    //   47: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   50: ldc2_w 245
    //   53: lreturn
    //   54: astore_0
    //   55: aconst_null
    //   56: astore_2
    //   57: aload_0
    //   58: astore_1
    //   59: aload_2
    //   60: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   63: aload_1
    //   64: athrow
    //   65: astore_1
    //   66: aload_0
    //   67: astore_2
    //   68: goto -9 -> 59
    //   71: astore_1
    //   72: goto -26 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	paramContext	Context
    //   0	75	1	paramString	String
    //   4	64	2	localObject	Object
    //   33	2	3	i	int
    //   13	30	4	l	long
    // Exception table:
    //   from	to	target	type
    //   5	15	18	java/io/IOException
    //   21	27	45	java/io/IOException
    //   21	27	54	finally
    //   29	34	65	finally
    //   29	34	71	java/io/IOException
  }
  
  public static abstract interface AssetFileComparator
  {
    public abstract boolean equals(Context paramContext, String paramString, File paramFile);
  }
  
  public static abstract interface FileComparator
  {
    public abstract boolean equals(File paramFile1, File paramFile2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\utils\FileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */