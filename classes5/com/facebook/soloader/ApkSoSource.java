package com.facebook.soloader;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApkSoSource
  extends DirectorySoSource
{
  private static final boolean DEBUG = false;
  private static final String TAG = "SoLoader";
  
  /* Error */
  public ApkSoSource(android.content.Context paramContext)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokestatic 26	com/facebook/soloader/SysUtil:createLibsDirectory	(Landroid/content/Context;)Ljava/io/File;
    //   5: iconst_1
    //   6: invokespecial 29	com/facebook/soloader/DirectorySoSource:<init>	(Ljava/io/File;I)V
    //   9: aconst_null
    //   10: astore_2
    //   11: new 31	java/util/jar/JarFile
    //   14: dup
    //   15: aload_1
    //   16: invokevirtual 37	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   19: getfield 42	android/content/pm/ApplicationInfo:publicSourceDir	Ljava/lang/String;
    //   22: invokespecial 45	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   25: astore_3
    //   26: aload_0
    //   27: getfield 49	com/facebook/soloader/DirectorySoSource:soDirectory	Ljava/io/File;
    //   30: astore 6
    //   32: aload_3
    //   33: invokestatic 53	com/facebook/soloader/ApkSoSource:findProvidedLibraries	(Ljava/util/jar/JarFile;)Ljava/util/Map;
    //   36: astore 5
    //   38: aconst_null
    //   39: astore_2
    //   40: aload_1
    //   41: invokestatic 57	com/facebook/soloader/SysUtil:lockLibsDirectory	(Landroid/content/Context;)Lcom/facebook/soloader/FileLocker;
    //   44: astore 4
    //   46: aload 4
    //   48: astore_2
    //   49: aload 6
    //   51: invokevirtual 63	java/io/File:listFiles	()[Ljava/io/File;
    //   54: astore_1
    //   55: iconst_0
    //   56: istore 10
    //   58: aload 4
    //   60: astore_2
    //   61: iload 10
    //   63: aload_1
    //   64: arraylength
    //   65: if_icmpge +118 -> 183
    //   68: aload_1
    //   69: iload 10
    //   71: aaload
    //   72: astore 7
    //   74: aload 4
    //   76: astore_2
    //   77: aload 7
    //   79: invokevirtual 67	java/io/File:getName	()Ljava/lang/String;
    //   82: astore 8
    //   84: aload 4
    //   86: astore_2
    //   87: aload 5
    //   89: aload 8
    //   91: invokeinterface 73 2 0
    //   96: checkcast 6	com/facebook/soloader/ApkSoSource$SoInfo
    //   99: astore 9
    //   101: aload 9
    //   103: ifnull +287 -> 390
    //   106: aload 4
    //   108: astore_2
    //   109: aload 9
    //   111: getfield 77	com/facebook/soloader/ApkSoSource$SoInfo:entry	Ljava/util/jar/JarEntry;
    //   114: invokevirtual 83	java/util/jar/JarEntry:getSize	()J
    //   117: aload 7
    //   119: invokevirtual 86	java/io/File:length	()J
    //   122: lcmp
    //   123: ifne +267 -> 390
    //   126: aload 4
    //   128: astore_2
    //   129: aload 9
    //   131: getfield 77	com/facebook/soloader/ApkSoSource$SoInfo:entry	Ljava/util/jar/JarEntry;
    //   134: invokevirtual 89	java/util/jar/JarEntry:getTime	()J
    //   137: aload 7
    //   139: invokevirtual 92	java/io/File:lastModified	()J
    //   142: lcmp
    //   143: ifeq +275 -> 418
    //   146: goto +244 -> 390
    //   149: iload 11
    //   151: ifeq +11 -> 162
    //   154: aload 4
    //   156: astore_2
    //   157: aload 7
    //   159: invokestatic 96	com/facebook/soloader/SysUtil:deleteOrThrow	(Ljava/io/File;)V
    //   162: iload 12
    //   164: ifeq +245 -> 409
    //   167: aload 4
    //   169: astore_2
    //   170: aload 5
    //   172: aload 8
    //   174: invokeinterface 99 2 0
    //   179: pop
    //   180: goto +229 -> 409
    //   183: aload 4
    //   185: astore_2
    //   186: aload 5
    //   188: invokeinterface 103 1 0
    //   193: invokeinterface 109 1 0
    //   198: astore 7
    //   200: aload 4
    //   202: astore_2
    //   203: aload 7
    //   205: invokeinterface 115 1 0
    //   210: ifeq +135 -> 345
    //   213: aload 4
    //   215: astore_2
    //   216: aload 7
    //   218: invokeinterface 119 1 0
    //   223: checkcast 6	com/facebook/soloader/ApkSoSource$SoInfo
    //   226: astore 8
    //   228: aload 4
    //   230: astore_2
    //   231: aload 8
    //   233: getfield 77	com/facebook/soloader/ApkSoSource$SoInfo:entry	Ljava/util/jar/JarEntry;
    //   236: astore 9
    //   238: aconst_null
    //   239: astore_1
    //   240: aload_3
    //   241: aload 9
    //   243: invokevirtual 123	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   246: astore 5
    //   248: aload 5
    //   250: astore_1
    //   251: aload 5
    //   253: new 59	java/io/File
    //   256: dup
    //   257: aload 6
    //   259: aload 8
    //   261: getfield 126	com/facebook/soloader/ApkSoSource$SoInfo:soName	Ljava/lang/String;
    //   264: invokespecial 129	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   267: aload 9
    //   269: invokevirtual 83	java/util/jar/JarEntry:getSize	()J
    //   272: aload 9
    //   274: invokevirtual 89	java/util/jar/JarEntry:getTime	()J
    //   277: invokestatic 133	com/facebook/soloader/SysUtil:reliablyCopyExecutable	(Ljava/io/InputStream;Ljava/io/File;JJ)V
    //   280: aload 5
    //   282: ifnull +11 -> 293
    //   285: aload 4
    //   287: astore_2
    //   288: aload 5
    //   290: invokevirtual 139	java/io/InputStream:close	()V
    //   293: aload 4
    //   295: astore_2
    //   296: invokestatic 142	com/facebook/soloader/SysUtil:freeCopyBuffer	()V
    //   299: goto -99 -> 200
    //   302: astore_1
    //   303: aload_2
    //   304: ifnull +7 -> 311
    //   307: aload_2
    //   308: invokevirtual 145	com/facebook/soloader/FileLocker:close	()V
    //   311: aload_1
    //   312: athrow
    //   313: astore_1
    //   314: aload_3
    //   315: astore_2
    //   316: aload_2
    //   317: ifnull +7 -> 324
    //   320: aload_2
    //   321: invokevirtual 146	java/util/jar/JarFile:close	()V
    //   324: aload_1
    //   325: athrow
    //   326: astore 5
    //   328: aload_1
    //   329: ifnull +10 -> 339
    //   332: aload 4
    //   334: astore_2
    //   335: aload_1
    //   336: invokevirtual 139	java/io/InputStream:close	()V
    //   339: aload 4
    //   341: astore_2
    //   342: aload 5
    //   344: athrow
    //   345: aload 4
    //   347: ifnull +8 -> 355
    //   350: aload 4
    //   352: invokevirtual 145	com/facebook/soloader/FileLocker:close	()V
    //   355: aload_3
    //   356: ifnull +7 -> 363
    //   359: aload_3
    //   360: invokevirtual 146	java/util/jar/JarFile:close	()V
    //   363: return
    //   364: astore_1
    //   365: goto -72 -> 293
    //   368: astore_1
    //   369: goto -30 -> 339
    //   372: astore_1
    //   373: goto -18 -> 355
    //   376: astore_2
    //   377: goto -66 -> 311
    //   380: astore_1
    //   381: return
    //   382: astore_2
    //   383: goto -59 -> 324
    //   386: astore_1
    //   387: goto -71 -> 316
    //   390: iconst_1
    //   391: istore 11
    //   393: aload 9
    //   395: ifnull +29 -> 424
    //   398: iload 11
    //   400: ifne +24 -> 424
    //   403: iconst_1
    //   404: istore 12
    //   406: goto -257 -> 149
    //   409: iload 10
    //   411: iconst_1
    //   412: iadd
    //   413: istore 10
    //   415: goto -357 -> 58
    //   418: iconst_0
    //   419: istore 11
    //   421: goto -28 -> 393
    //   424: iconst_0
    //   425: istore 12
    //   427: goto -278 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	430	0	this	ApkSoSource
    //   0	430	1	paramContext	android.content.Context
    //   10	332	2	localObject1	Object
    //   376	1	2	localException1	Exception
    //   382	1	2	localException2	Exception
    //   25	335	3	localJarFile	JarFile
    //   44	307	4	localFileLocker	FileLocker
    //   36	253	5	localObject2	Object
    //   326	17	5	localObject3	Object
    //   30	228	6	localFile	java.io.File
    //   72	145	7	localObject4	Object
    //   82	178	8	localObject5	Object
    //   99	295	9	localObject6	Object
    //   56	358	10	i	int
    //   149	271	11	j	int
    //   162	264	12	k	int
    // Exception table:
    //   from	to	target	type
    //   40	46	302	finally
    //   49	55	302	finally
    //   61	68	302	finally
    //   77	84	302	finally
    //   87	101	302	finally
    //   109	126	302	finally
    //   129	146	302	finally
    //   157	162	302	finally
    //   170	180	302	finally
    //   186	200	302	finally
    //   203	213	302	finally
    //   216	228	302	finally
    //   231	238	302	finally
    //   288	293	302	finally
    //   296	299	302	finally
    //   335	339	302	finally
    //   342	345	302	finally
    //   26	38	313	finally
    //   307	311	313	finally
    //   311	313	313	finally
    //   350	355	313	finally
    //   240	248	326	finally
    //   251	280	326	finally
    //   288	293	364	java/lang/Exception
    //   335	339	368	java/lang/Exception
    //   350	355	372	java/lang/Exception
    //   307	311	376	java/lang/Exception
    //   359	363	380	java/lang/Exception
    //   320	324	382	java/lang/Exception
    //   11	26	386	finally
  }
  
  private static Map<String, SoInfo> findProvidedLibraries(JarFile paramJarFile)
  {
    Pattern localPattern = Pattern.compile("^lib/([^/]+)/([^/]+\\.so)$");
    HashMap localHashMap = new HashMap();
    String[] arrayOfString = SysUtil.getSupportedAbis();
    paramJarFile = paramJarFile.entries();
    while (paramJarFile.hasMoreElements())
    {
      JarEntry localJarEntry = (JarEntry)paramJarFile.nextElement();
      Object localObject2 = localPattern.matcher(localJarEntry.getName());
      if (((Matcher)localObject2).matches())
      {
        Object localObject1 = ((Matcher)localObject2).group(1);
        localObject2 = ((Matcher)localObject2).group(2);
        int i = SysUtil.findAbiScore(arrayOfString, (String)localObject1);
        if (i >= 0)
        {
          localObject1 = (SoInfo)localHashMap.get(localObject2);
          if ((localObject1 == null) || (i < ((SoInfo)localObject1).abiScore)) {
            localHashMap.put(localObject2, new SoInfo((String)localObject2, localJarEntry, i));
          }
        }
      }
    }
    return localHashMap;
  }
  
  private static final class SoInfo
  {
    public final int abiScore;
    public final JarEntry entry;
    public final String soName;
    
    SoInfo(String paramString, JarEntry paramJarEntry, int paramInt)
    {
      this.soName = paramString;
      this.entry = paramJarEntry;
      this.abiScore = paramInt;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\soloader\ApkSoSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */