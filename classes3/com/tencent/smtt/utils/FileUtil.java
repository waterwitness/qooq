package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;

@SuppressLint({"NewApi"})
public class FileUtil
{
  private static final String APK_ASSETS = "assets/";
  private static final String APK_LIB = "lib/";
  private static final int APK_LIB_LEN = "lib/".length();
  private static final int DEFAULT_BUFFER_SIZE = 4096;
  public static final int ENU_NEW_TBS_BACKUP_PATH = 4;
  public static final int ENU_OLD_TBS_BACKUP_PATH1 = 1;
  public static final int ENU_OLD_TBS_BACKUP_PATH2 = 2;
  public static final int ENU_OLD_TBS_BACKUP_PATH3 = 3;
  public static final int ENU_TBS_LOCALINSTALL = 5;
  public static final int ENU_TBS_LOG = 6;
  private static final String LIB_SUFFIX = ".so";
  public static final FileComparator SIMPLE_COMPARATOR = new FileComparator()
  {
    public boolean equals(File paramAnonymousFile1, File paramAnonymousFile2)
    {
      return (paramAnonymousFile1.length() == paramAnonymousFile2.length()) && (paramAnonymousFile1.lastModified() == paramAnonymousFile2.lastModified());
    }
  };
  private static final String TAG = "FileHelper";
  public static String TBSLOG_PATH = null;
  public static final String TBS_CORE_LOCK_FILE = "tbslock.txt";
  public static final String TBS_CORE_PRIVATE = "core_private";
  public static final String TBS_DOWNLOADING_LOCK_FILE_PRENAME = "tbs_download_lock_file";
  public static final String TBS_FILE_CORE_SHARE = "core_share";
  public static final String TBS_FILE_SHARE = "share";
  private static final String TBS_SDCARD_DIR = "tbs";
  private static final String TBS_SDCARD_SHARE_DIR = ".tbs";
  public static final int ZIP_BUFFER_SIZE = 4096;
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable == null) {
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception paramCloseable)
    {
      paramCloseable.printStackTrace();
    }
  }
  
  public static int copy(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException, OutOfMemoryError
  {
    long l = copyLarge(paramInputStream, paramOutputStream);
    if (l > 2147483647L) {
      return -1;
    }
    return (int)l;
  }
  
  /* Error */
  @SuppressLint({"NewApi"})
  private static boolean copyFileIfChanged(InputStream paramInputStream, ZipEntry paramZipEntry, String paramString1, String paramString2)
    throws Exception
  {
    // Byte code:
    //   0: new 122	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 125	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokestatic 129	com/tencent/smtt/utils/FileUtil:ensureDirectory	(Ljava/io/File;)Z
    //   11: pop
    //   12: new 131	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   19: aload_2
    //   20: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: getstatic 139	java/io/File:separator	Ljava/lang/String;
    //   26: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_3
    //   30: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore 5
    //   38: new 122	java/io/File
    //   41: dup
    //   42: aload 5
    //   44: invokespecial 125	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: astore 4
    //   49: new 145	java/io/FileOutputStream
    //   52: dup
    //   53: aload 4
    //   55: invokespecial 148	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   58: astore_3
    //   59: aload_3
    //   60: astore_2
    //   61: sipush 8192
    //   64: newarray <illegal type>
    //   66: astore 6
    //   68: aload_3
    //   69: astore_2
    //   70: aload_0
    //   71: aload 6
    //   73: invokevirtual 154	java/io/InputStream:read	([B)I
    //   76: istore 7
    //   78: iload 7
    //   80: ifle +69 -> 149
    //   83: aload_3
    //   84: astore_2
    //   85: aload_3
    //   86: aload 6
    //   88: iconst_0
    //   89: iload 7
    //   91: invokevirtual 158	java/io/FileOutputStream:write	([BII)V
    //   94: goto -26 -> 68
    //   97: astore_1
    //   98: aload_3
    //   99: astore_0
    //   100: aload_0
    //   101: astore_2
    //   102: aload 4
    //   104: invokestatic 161	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   107: aload_0
    //   108: astore_2
    //   109: new 112	java/io/IOException
    //   112: dup
    //   113: new 131	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   120: ldc -93
    //   122: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload 4
    //   127: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: aload_1
    //   134: invokespecial 169	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   137: athrow
    //   138: astore_0
    //   139: aload_2
    //   140: ifnull +7 -> 147
    //   143: aload_2
    //   144: invokevirtual 170	java/io/FileOutputStream:close	()V
    //   147: aload_0
    //   148: athrow
    //   149: aload_3
    //   150: ifnull +7 -> 157
    //   153: aload_3
    //   154: invokevirtual 170	java/io/FileOutputStream:close	()V
    //   157: aload 5
    //   159: aload_1
    //   160: invokevirtual 176	java/util/zip/ZipEntry:getSize	()J
    //   163: aload_1
    //   164: invokevirtual 179	java/util/zip/ZipEntry:getTime	()J
    //   167: aload_1
    //   168: invokevirtual 182	java/util/zip/ZipEntry:getCrc	()J
    //   171: invokestatic 186	com/tencent/smtt/utils/FileUtil:isFileDifferent	(Ljava/lang/String;JJJ)Z
    //   174: ifeq +30 -> 204
    //   177: ldc 48
    //   179: new 131	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   186: ldc -68
    //   188: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload 5
    //   193: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 194	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   202: iconst_0
    //   203: ireturn
    //   204: aload 4
    //   206: aload_1
    //   207: invokevirtual 179	java/util/zip/ZipEntry:getTime	()J
    //   210: invokevirtual 198	java/io/File:setLastModified	(J)Z
    //   213: ifne +28 -> 241
    //   216: ldc 48
    //   218: new 131	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   225: ldc -56
    //   227: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload 4
    //   232: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 194	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: iconst_1
    //   242: ireturn
    //   243: astore_0
    //   244: aconst_null
    //   245: astore_2
    //   246: goto -107 -> 139
    //   249: astore_1
    //   250: aconst_null
    //   251: astore_0
    //   252: goto -152 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	paramInputStream	InputStream
    //   0	255	1	paramZipEntry	ZipEntry
    //   0	255	2	paramString1	String
    //   0	255	3	paramString2	String
    //   47	184	4	localFile	File
    //   36	156	5	str	String
    //   66	21	6	arrayOfByte	byte[]
    //   76	14	7	i	int
    // Exception table:
    //   from	to	target	type
    //   61	68	97	java/io/IOException
    //   70	78	97	java/io/IOException
    //   85	94	97	java/io/IOException
    //   61	68	138	finally
    //   70	78	138	finally
    //   85	94	138	finally
    //   102	107	138	finally
    //   109	138	138	finally
    //   49	59	243	finally
    //   49	59	249	java/io/IOException
  }
  
  public static boolean copyFiles(File paramFile1, File paramFile2)
    throws Exception
  {
    return copyFiles(paramFile1, paramFile2, null);
  }
  
  public static boolean copyFiles(File paramFile1, File paramFile2, FileFilter paramFileFilter)
    throws Exception
  {
    return copyFiles(paramFile1, paramFile2, paramFileFilter, SIMPLE_COMPARATOR);
  }
  
  public static boolean copyFiles(File paramFile1, File paramFile2, FileFilter paramFileFilter, FileComparator paramFileComparator)
    throws Exception
  {
    if ((paramFile1 == null) || (paramFile2 == null)) {}
    do
    {
      do
      {
        return false;
      } while (!paramFile1.exists());
      if (paramFile1.isFile()) {
        return performCopyFile(paramFile1, paramFile2, paramFileFilter, paramFileComparator);
      }
      paramFile1 = paramFile1.listFiles();
    } while (paramFile1 == null);
    boolean bool = true;
    int j = paramFile1.length;
    int i = 0;
    while (i < j)
    {
      paramFileComparator = paramFile1[i];
      if (!copyFiles(paramFileComparator, new File(paramFile2, paramFileComparator.getName()), paramFileFilter)) {
        bool = false;
      }
      i += 1;
    }
    return bool;
  }
  
  public static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException, OutOfMemoryError
  {
    long l2;
    if (paramInputStream == null)
    {
      l2 = -1L;
      return l2;
    }
    byte[] arrayOfByte = new byte['က'];
    int i;
    for (long l1 = 0L;; l1 += i)
    {
      i = paramInputStream.read(arrayOfByte);
      l2 = l1;
      if (-1 == i) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public static boolean copyTbsFilesIfNeeded(File paramFile1, File paramFile2)
    throws Exception
  {
    return copyTbsFilesIfNeeded(paramFile1.getPath(), paramFile2.getPath());
  }
  
  @SuppressLint({"InlinedApi"})
  public static boolean copyTbsFilesIfNeeded(String paramString1, String paramString2)
    throws Exception
  {
    String str2 = Build.CPU_ABI;
    if (Build.VERSION.SDK_INT >= 8) {}
    for (String str1 = Build.CPU_ABI2;; str1 = null) {
      return copyTbsFilesIfNeeded(paramString1, paramString2, str2, str1, PropertyUtils.getQuickly("ro.product.cpu.upgradeabi", "armeabi"));
    }
  }
  
  private static boolean copyTbsFilesIfNeeded(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws Exception
  {
    iterateOverTbsFiles(paramString1, paramString3, paramString4, paramString5, new IterateHandler()
    {
      public boolean handleEntry(InputStream paramAnonymousInputStream, ZipEntry paramAnonymousZipEntry, String paramAnonymousString)
        throws Exception
      {
        try
        {
          boolean bool = FileUtil.copyFileIfChanged(paramAnonymousInputStream, paramAnonymousZipEntry, this.val$dstDir, paramAnonymousString);
          return bool;
        }
        catch (Exception paramAnonymousInputStream)
        {
          throw new Exception("copyFileIfChanged Exception", paramAnonymousInputStream);
        }
      }
    });
  }
  
  public static void delete(File paramFile)
  {
    delete(paramFile, false);
  }
  
  public static void delete(File paramFile, boolean paramBoolean)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    do
    {
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
      while (i < j)
      {
        delete(arrayOfFile[i], paramBoolean);
        i += 1;
      }
    } while (paramBoolean);
    paramFile.delete();
  }
  
  public static boolean ensureDirectory(File paramFile)
  {
    if (paramFile == null) {
      return false;
    }
    if ((paramFile.exists()) && (paramFile.isDirectory())) {
      return true;
    }
    delete(paramFile);
    return paramFile.mkdirs();
  }
  
  public static void freeFileLock(FileLock paramFileLock, FileOutputStream paramFileOutputStream)
  {
    if (paramFileLock != null) {}
    try
    {
      paramFileLock.release();
      if (paramFileOutputStream == null) {}
    }
    catch (Exception paramFileLock)
    {
      for (;;)
      {
        try
        {
          paramFileOutputStream.close();
          return;
        }
        catch (Exception paramFileLock)
        {
          paramFileLock.printStackTrace();
        }
        paramFileLock = paramFileLock;
        paramFileLock.printStackTrace();
      }
    }
  }
  
  public static String getFileLockPath(Context paramContext)
  {
    return Environment.getExternalStorageDirectory() + File.separator + "tbs" + File.separator + "file_locks";
  }
  
  public static long getFreeSpace(String paramString)
  {
    try
    {
      StatFs localStatFs = new StatFs(paramString);
      localStatFs.restat(paramString);
      long l = localStatFs.getBlockSize();
      int i = localStatFs.getAvailableBlocks();
      return i * l;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  public static File getLockFile(Context paramContext, boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      paramContext = getTbsCorePrivateDir(paramContext);
      if (paramContext != null) {
        break label23;
      }
    }
    label23:
    do
    {
      return null;
      paramContext = getFileLockPath(paramContext);
      break;
      paramContext = new File(paramContext);
      if ((paramContext != null) && (!paramContext.exists())) {
        paramContext.mkdirs();
      }
    } while (!paramContext.canWrite());
    paramContext = new File(paramContext, paramString);
    if (!paramContext.exists()) {}
    try
    {
      paramContext.createNewFile();
      return paramContext;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static FileOutputStream getLockFos(Context paramContext, boolean paramBoolean, String paramString)
  {
    paramContext = getLockFile(paramContext, paramBoolean, paramString);
    if (paramContext != null) {
      try
      {
        paramContext = new FileOutputStream(paramContext);
        return paramContext;
      }
      catch (FileNotFoundException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return null;
  }
  
  public static File getSDcardDir()
  {
    try
    {
      File localFile = Environment.getExternalStorageDirectory();
      return localFile;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  private static String getStandardExternalFilesDir(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return "";
    }
    paramContext = paramContext.getApplicationContext();
    try
    {
      String str = paramContext.getExternalFilesDir(paramString).getAbsolutePath();
      return str;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      try
      {
        paramContext = Environment.getExternalStorageDirectory() + File.separator + "Android" + File.separator + "data" + File.separator + paramContext.getApplicationInfo().packageName + File.separator + "files" + File.separator + paramString;
        return paramContext;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return "";
  }
  
  public static String getTBSSdcardFilePath(Context paramContext, int paramInt)
  {
    String str1;
    if (paramContext == null) {
      str1 = "";
    }
    String str2;
    do
    {
      File localFile;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return str1;
                try
                {
                  str2 = Environment.getExternalStorageDirectory() + File.separator;
                  switch (paramInt)
                  {
                  default: 
                    return "";
                  }
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    localException.printStackTrace();
                    str2 = "";
                  }
                  localObject = str2;
                }
              } while (str2.equals(""));
              return str2 + "tencent" + File.separator + "tbs" + File.separator + paramContext.getApplicationInfo().packageName;
              localObject = str2;
            } while (str2.equals(""));
            return str2 + "tbs" + File.separator + "backup" + File.separator + paramContext.getApplicationInfo().packageName;
            localObject = str2;
          } while (str2.equals(""));
          return str2 + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + paramContext.getApplicationInfo().packageName;
          if (str2.equals("")) {
            return getStandardExternalFilesDir(paramContext, "backup");
          }
          str2 = str2 + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + paramContext.getApplicationInfo().packageName;
          localFile = new File(str2);
          if (!localFile.exists()) {
            break;
          }
          localObject = str2;
        } while (localFile.canWrite());
        if (localFile.exists()) {
          break;
        }
        localFile.mkdirs();
        localObject = str2;
      } while (localFile.canWrite());
      return getStandardExternalFilesDir(paramContext, "backup");
      return getStandardExternalFilesDir(paramContext, "backup");
      Object localObject = str2;
    } while (str2.equals(""));
    return str2 + "tencent" + File.separator + "tbs" + File.separator + paramContext.getApplicationInfo().packageName;
    if (TBSLOG_PATH != null) {
      return TBSLOG_PATH;
    }
    TBSLOG_PATH = getStandardExternalFilesDir(paramContext, "tbslog");
    return TBSLOG_PATH;
  }
  
  static String getTbsCorePrivateDir(Context paramContext)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), "core_private");
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
      return null;
    }
    return paramContext.getAbsolutePath();
  }
  
  public static File getTbsSdcardShareDir()
  {
    File localFile = new File(getSDcardDir().getAbsolutePath() + "/" + ".tbs");
    if ((localFile != null) && (!localFile.exists())) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public static boolean hasSDcard()
  {
    try
    {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  private static boolean isFileDifferent(String paramString, long paramLong1, long paramLong2, long paramLong3)
    throws Exception
  {
    paramString = new File(paramString);
    if (paramString.length() != paramLong1) {
      TbsLog.e("FileHelper", "file size doesn't match: " + paramString.length() + " vs " + paramLong1);
    }
    label122:
    do
    {
      return true;
      try
      {
        localFileInputStream = new FileInputStream(paramString);
        try
        {
          localCRC32 = new CRC32();
          byte[] arrayOfByte = new byte[' '];
          for (;;)
          {
            int i = localFileInputStream.read(arrayOfByte);
            if (i <= 0) {
              break;
            }
            localCRC32.update(arrayOfByte, 0, i);
          }
          if (localFileInputStream == null) {
            break label122;
          }
        }
        finally {}
      }
      finally
      {
        for (;;)
        {
          CRC32 localCRC32;
          FileInputStream localFileInputStream = null;
        }
      }
      localFileInputStream.close();
      throw paramString;
      paramLong1 = localCRC32.getValue();
      TbsLog.i("FileHelper", "" + paramString.getName() + ": crc = " + paramLong1 + ", zipCrc = " + paramLong3);
      if (paramLong1 == paramLong3) {
        break;
      }
    } while (localFileInputStream == null);
    localFileInputStream.close();
    return true;
    if (localFileInputStream != null) {
      localFileInputStream.close();
    }
    return false;
  }
  
  public static boolean isFileValid(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists()) && (paramFile.isFile()) && (paramFile.length() > 0L);
  }
  
  public static boolean isSdcardDirWritable(Context paramContext)
  {
    boolean bool2 = false;
    if (Build.VERSION.SDK_INT < 23) {
      return true;
    }
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      paramContext = ReflectionUtils.invokeInstance(paramContext.getApplicationContext(), "checkSelfPermission", new Class[] { String.class }, new Object[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
      bool1 = bool2;
      if ((paramContext instanceof Integer)) {
        if (((Integer)paramContext).intValue() != 0) {
          break label71;
        }
      }
    }
    label71:
    for (bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  /* Error */
  private static boolean iterateOverTbsFiles(String paramString1, String paramString2, String paramString3, String paramString4, IterateHandler paramIterateHandler)
    throws Exception
  {
    // Byte code:
    //   0: new 456	java/util/zip/ZipFile
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 457	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: iconst_0
    //   10: istore 10
    //   12: iconst_0
    //   13: istore 9
    //   15: aload_0
    //   16: invokevirtual 461	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   19: astore 5
    //   21: aload 5
    //   23: invokeinterface 466 1 0
    //   28: ifeq +318 -> 346
    //   31: aload 5
    //   33: invokeinterface 470 1 0
    //   38: checkcast 172	java/util/zip/ZipEntry
    //   41: astore 6
    //   43: aload 6
    //   45: invokevirtual 471	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   48: astore 8
    //   50: aload 8
    //   52: ifnull -31 -> 21
    //   55: aload 8
    //   57: ldc 24
    //   59: invokevirtual 475	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   62: ifne +13 -> 75
    //   65: aload 8
    //   67: ldc 21
    //   69: invokevirtual 475	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   72: ifeq -51 -> 21
    //   75: aload 8
    //   77: aload 8
    //   79: bipush 47
    //   81: invokevirtual 479	java/lang/String:lastIndexOf	(I)I
    //   84: invokevirtual 483	java/lang/String:substring	(I)Ljava/lang/String;
    //   87: astore 7
    //   89: iload 9
    //   91: istore 11
    //   93: iload 10
    //   95: istore 12
    //   97: aload 7
    //   99: ldc 43
    //   101: invokevirtual 486	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   104: ifeq +45 -> 149
    //   107: aload 8
    //   109: getstatic 81	com/tencent/smtt/utils/FileUtil:APK_LIB_LEN	I
    //   112: aload_1
    //   113: iconst_0
    //   114: aload_1
    //   115: invokevirtual 79	java/lang/String:length	()I
    //   118: invokevirtual 490	java/lang/String:regionMatches	(ILjava/lang/String;II)Z
    //   121: ifeq +80 -> 201
    //   124: aload 8
    //   126: getstatic 81	com/tencent/smtt/utils/FileUtil:APK_LIB_LEN	I
    //   129: aload_1
    //   130: invokevirtual 79	java/lang/String:length	()I
    //   133: iadd
    //   134: invokevirtual 494	java/lang/String:charAt	(I)C
    //   137: bipush 47
    //   139: if_icmpne +62 -> 201
    //   142: iconst_1
    //   143: istore 12
    //   145: iload 9
    //   147: istore 11
    //   149: aload_0
    //   150: aload 6
    //   152: invokevirtual 498	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   155: astore 8
    //   157: aload 4
    //   159: aload 8
    //   161: aload 6
    //   163: aload 7
    //   165: iconst_1
    //   166: invokevirtual 483	java/lang/String:substring	(I)Ljava/lang/String;
    //   169: invokeinterface 502 4 0
    //   174: istore 13
    //   176: iload 13
    //   178: ifne +178 -> 356
    //   181: aload 8
    //   183: ifnull +8 -> 191
    //   186: aload 8
    //   188: invokevirtual 503	java/io/InputStream:close	()V
    //   191: aload_0
    //   192: ifnull +7 -> 199
    //   195: aload_0
    //   196: invokevirtual 504	java/util/zip/ZipFile:close	()V
    //   199: iconst_0
    //   200: ireturn
    //   201: aload_2
    //   202: ifnull +56 -> 258
    //   205: aload 8
    //   207: getstatic 81	com/tencent/smtt/utils/FileUtil:APK_LIB_LEN	I
    //   210: aload_2
    //   211: iconst_0
    //   212: aload_2
    //   213: invokevirtual 79	java/lang/String:length	()I
    //   216: invokevirtual 490	java/lang/String:regionMatches	(ILjava/lang/String;II)Z
    //   219: ifeq +39 -> 258
    //   222: aload 8
    //   224: getstatic 81	com/tencent/smtt/utils/FileUtil:APK_LIB_LEN	I
    //   227: aload_2
    //   228: invokevirtual 79	java/lang/String:length	()I
    //   231: iadd
    //   232: invokevirtual 494	java/lang/String:charAt	(I)C
    //   235: bipush 47
    //   237: if_icmpne +21 -> 258
    //   240: iconst_1
    //   241: istore 11
    //   243: iconst_1
    //   244: istore 9
    //   246: iload 10
    //   248: istore 12
    //   250: iload 10
    //   252: ifeq -103 -> 149
    //   255: goto -234 -> 21
    //   258: aload_3
    //   259: ifnull -238 -> 21
    //   262: aload 8
    //   264: getstatic 81	com/tencent/smtt/utils/FileUtil:APK_LIB_LEN	I
    //   267: aload_3
    //   268: iconst_0
    //   269: aload_3
    //   270: invokevirtual 79	java/lang/String:length	()I
    //   273: invokevirtual 490	java/lang/String:regionMatches	(ILjava/lang/String;II)Z
    //   276: ifeq -255 -> 21
    //   279: aload 8
    //   281: getstatic 81	com/tencent/smtt/utils/FileUtil:APK_LIB_LEN	I
    //   284: aload_3
    //   285: invokevirtual 79	java/lang/String:length	()I
    //   288: iadd
    //   289: invokevirtual 494	java/lang/String:charAt	(I)C
    //   292: bipush 47
    //   294: if_icmpne -273 -> 21
    //   297: iload 10
    //   299: ifne -278 -> 21
    //   302: iload 9
    //   304: istore 11
    //   306: iload 10
    //   308: istore 12
    //   310: iload 9
    //   312: ifeq -163 -> 149
    //   315: goto -294 -> 21
    //   318: astore_1
    //   319: aload 8
    //   321: ifnull +8 -> 329
    //   324: aload 8
    //   326: invokevirtual 503	java/io/InputStream:close	()V
    //   329: aload_1
    //   330: athrow
    //   331: astore_2
    //   332: aload_0
    //   333: astore_1
    //   334: aload_2
    //   335: astore_0
    //   336: aload_1
    //   337: ifnull +7 -> 344
    //   340: aload_1
    //   341: invokevirtual 504	java/util/zip/ZipFile:close	()V
    //   344: aload_0
    //   345: athrow
    //   346: aload_0
    //   347: ifnull +7 -> 354
    //   350: aload_0
    //   351: invokevirtual 504	java/util/zip/ZipFile:close	()V
    //   354: iconst_1
    //   355: ireturn
    //   356: iload 11
    //   358: istore 9
    //   360: iload 12
    //   362: istore 10
    //   364: aload 8
    //   366: ifnull -345 -> 21
    //   369: aload 8
    //   371: invokevirtual 503	java/io/InputStream:close	()V
    //   374: iload 11
    //   376: istore 9
    //   378: iload 12
    //   380: istore 10
    //   382: goto -361 -> 21
    //   385: astore_0
    //   386: aconst_null
    //   387: astore_1
    //   388: goto -52 -> 336
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	paramString1	String
    //   0	391	1	paramString2	String
    //   0	391	2	paramString3	String
    //   0	391	3	paramString4	String
    //   0	391	4	paramIterateHandler	IterateHandler
    //   19	13	5	localEnumeration	java.util.Enumeration
    //   41	121	6	localZipEntry	ZipEntry
    //   87	77	7	str	String
    //   48	322	8	localObject	Object
    //   13	364	9	i	int
    //   10	371	10	j	int
    //   91	284	11	k	int
    //   95	284	12	m	int
    //   174	3	13	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   157	176	318	finally
    //   15	21	331	finally
    //   21	50	331	finally
    //   55	75	331	finally
    //   75	89	331	finally
    //   97	142	331	finally
    //   149	157	331	finally
    //   186	191	331	finally
    //   205	240	331	finally
    //   262	297	331	finally
    //   324	329	331	finally
    //   329	331	331	finally
    //   369	374	331	finally
    //   0	9	385	finally
  }
  
  public static FileInputStream openInputStream(File paramFile)
    throws IOException
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory()) {
        throw new IOException("File '" + paramFile + "' exists but is a directory");
      }
      if (!paramFile.canRead()) {
        throw new IOException("File '" + paramFile + "' cannot be read");
      }
    }
    else
    {
      throw new FileNotFoundException("File '" + paramFile + "' does not exist");
    }
    return new FileInputStream(paramFile);
  }
  
  public static FileOutputStream openOutputStream(File paramFile)
    throws IOException
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory()) {
        throw new IOException("File '" + paramFile + "' exists but is a directory");
      }
      if (!paramFile.canWrite()) {
        throw new IOException("File '" + paramFile + "' cannot be written to");
      }
    }
    else
    {
      File localFile = paramFile.getParentFile();
      if ((localFile != null) && (!localFile.exists()) && (!localFile.mkdirs())) {
        throw new IOException("File '" + paramFile + "' could not be created");
      }
    }
    return new FileOutputStream(paramFile);
  }
  
  /* Error */
  private static boolean performCopyFile(File paramFile1, File paramFile2, FileFilter paramFileFilter, FileComparator paramFileComparator)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnull +7 -> 11
    //   7: aload_1
    //   8: ifnonnull +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_2
    //   14: ifnull +15 -> 29
    //   17: aload_2
    //   18: aload_0
    //   19: invokeinterface 533 2 0
    //   24: ifne +5 -> 29
    //   27: iconst_0
    //   28: ireturn
    //   29: aload_0
    //   30: invokevirtual 213	java/io/File:exists	()Z
    //   33: ifeq +14 -> 47
    //   36: aload_0
    //   37: invokevirtual 216	java/io/File:isFile	()Z
    //   40: istore 7
    //   42: iload 7
    //   44: ifne +29 -> 73
    //   47: iconst_0
    //   48: ifeq +11 -> 59
    //   51: new 535	java/lang/NullPointerException
    //   54: dup
    //   55: invokespecial 536	java/lang/NullPointerException:<init>	()V
    //   58: athrow
    //   59: iconst_0
    //   60: ifeq +11 -> 71
    //   63: new 535	java/lang/NullPointerException
    //   66: dup
    //   67: invokespecial 536	java/lang/NullPointerException:<init>	()V
    //   70: athrow
    //   71: iconst_0
    //   72: ireturn
    //   73: aload_1
    //   74: invokevirtual 213	java/io/File:exists	()Z
    //   77: ifeq +52 -> 129
    //   80: aload_3
    //   81: ifnull +44 -> 125
    //   84: aload_3
    //   85: aload_0
    //   86: aload_1
    //   87: invokeinterface 538 3 0
    //   92: istore 7
    //   94: iload 7
    //   96: ifeq +29 -> 125
    //   99: iconst_0
    //   100: ifeq +11 -> 111
    //   103: new 535	java/lang/NullPointerException
    //   106: dup
    //   107: invokespecial 536	java/lang/NullPointerException:<init>	()V
    //   110: athrow
    //   111: iconst_0
    //   112: ifeq +11 -> 123
    //   115: new 535	java/lang/NullPointerException
    //   118: dup
    //   119: invokespecial 536	java/lang/NullPointerException:<init>	()V
    //   122: athrow
    //   123: iconst_1
    //   124: ireturn
    //   125: aload_1
    //   126: invokestatic 161	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   129: aload_1
    //   130: invokevirtual 526	java/io/File:getParentFile	()Ljava/io/File;
    //   133: astore_2
    //   134: aload_2
    //   135: invokevirtual 216	java/io/File:isFile	()Z
    //   138: ifeq +7 -> 145
    //   141: aload_2
    //   142: invokestatic 161	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   145: aload_2
    //   146: invokevirtual 213	java/io/File:exists	()Z
    //   149: ifne +40 -> 189
    //   152: aload_2
    //   153: invokevirtual 284	java/io/File:mkdirs	()Z
    //   156: istore 7
    //   158: iload 7
    //   160: ifne +29 -> 189
    //   163: iconst_0
    //   164: ifeq +11 -> 175
    //   167: new 535	java/lang/NullPointerException
    //   170: dup
    //   171: invokespecial 536	java/lang/NullPointerException:<init>	()V
    //   174: athrow
    //   175: iconst_0
    //   176: ifeq +11 -> 187
    //   179: new 535	java/lang/NullPointerException
    //   182: dup
    //   183: invokespecial 536	java/lang/NullPointerException:<init>	()V
    //   186: athrow
    //   187: iconst_0
    //   188: ireturn
    //   189: new 415	java/io/FileInputStream
    //   192: dup
    //   193: aload_0
    //   194: invokespecial 416	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   197: invokevirtual 542	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   200: astore_2
    //   201: new 145	java/io/FileOutputStream
    //   204: dup
    //   205: aload_1
    //   206: invokespecial 148	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   209: invokevirtual 543	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   212: astore_3
    //   213: aload_2
    //   214: invokevirtual 548	java/nio/channels/FileChannel:size	()J
    //   217: lstore 5
    //   219: aload_3
    //   220: aload_2
    //   221: lconst_0
    //   222: lload 5
    //   224: invokevirtual 552	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   227: lload 5
    //   229: lcmp
    //   230: ifeq +49 -> 279
    //   233: aload_1
    //   234: invokestatic 161	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   237: aload_2
    //   238: ifnull +7 -> 245
    //   241: aload_2
    //   242: invokevirtual 553	java/nio/channels/FileChannel:close	()V
    //   245: aload_3
    //   246: ifnull +7 -> 253
    //   249: aload_3
    //   250: invokevirtual 553	java/nio/channels/FileChannel:close	()V
    //   253: iconst_0
    //   254: ireturn
    //   255: astore_0
    //   256: aconst_null
    //   257: astore_1
    //   258: aload 4
    //   260: astore_2
    //   261: aload_2
    //   262: ifnull +7 -> 269
    //   265: aload_2
    //   266: invokevirtual 553	java/nio/channels/FileChannel:close	()V
    //   269: aload_1
    //   270: ifnull +7 -> 277
    //   273: aload_1
    //   274: invokevirtual 553	java/nio/channels/FileChannel:close	()V
    //   277: aload_0
    //   278: athrow
    //   279: aload_2
    //   280: ifnull +7 -> 287
    //   283: aload_2
    //   284: invokevirtual 553	java/nio/channels/FileChannel:close	()V
    //   287: aload_3
    //   288: ifnull +7 -> 295
    //   291: aload_3
    //   292: invokevirtual 553	java/nio/channels/FileChannel:close	()V
    //   295: iconst_1
    //   296: ireturn
    //   297: astore_0
    //   298: aconst_null
    //   299: astore_1
    //   300: goto -39 -> 261
    //   303: astore_0
    //   304: aload_3
    //   305: astore_1
    //   306: goto -45 -> 261
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	paramFile1	File
    //   0	309	1	paramFile2	File
    //   0	309	2	paramFileFilter	FileFilter
    //   0	309	3	paramFileComparator	FileComparator
    //   1	258	4	localObject	Object
    //   217	11	5	l	long
    //   40	119	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   29	42	255	finally
    //   73	80	255	finally
    //   84	94	255	finally
    //   125	129	255	finally
    //   129	145	255	finally
    //   145	158	255	finally
    //   189	201	255	finally
    //   201	213	297	finally
    //   213	237	303	finally
  }
  
  /* Error */
  public static byte[] read(File paramFile)
    throws OutOfMemoryError
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: ifnonnull +8 -> 14
    //   9: aload 4
    //   11: astore_2
    //   12: aload_2
    //   13: areturn
    //   14: aload_0
    //   15: invokestatic 556	com/tencent/smtt/utils/FileUtil:openInputStream	(Ljava/io/File;)Ljava/io/FileInputStream;
    //   18: astore_0
    //   19: aload_0
    //   20: astore_1
    //   21: aload_0
    //   22: invokestatic 560	com/tencent/smtt/utils/FileUtil:toByteArrayOutputStream	(Ljava/io/InputStream;)Ljava/io/ByteArrayOutputStream;
    //   25: invokevirtual 566	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   28: astore_2
    //   29: aload_2
    //   30: astore_1
    //   31: aload_1
    //   32: astore_2
    //   33: aload_0
    //   34: ifnull -22 -> 12
    //   37: aload_0
    //   38: invokestatic 568	com/tencent/smtt/utils/FileUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   41: aload_1
    //   42: areturn
    //   43: astore_2
    //   44: aconst_null
    //   45: astore_0
    //   46: aload_0
    //   47: astore_1
    //   48: aload_2
    //   49: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   52: aload 4
    //   54: astore_2
    //   55: aload_0
    //   56: ifnull -44 -> 12
    //   59: aload_3
    //   60: astore_1
    //   61: goto -24 -> 37
    //   64: aload_0
    //   65: astore_1
    //   66: aload_2
    //   67: invokevirtual 569	java/lang/OutOfMemoryError:printStackTrace	()V
    //   70: aload_0
    //   71: astore_1
    //   72: aload_2
    //   73: athrow
    //   74: astore_0
    //   75: aload_1
    //   76: ifnull +7 -> 83
    //   79: aload_1
    //   80: invokestatic 568	com/tencent/smtt/utils/FileUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   83: aload_0
    //   84: athrow
    //   85: astore_0
    //   86: aconst_null
    //   87: astore_1
    //   88: goto -13 -> 75
    //   91: astore_2
    //   92: goto -28 -> 64
    //   95: astore_2
    //   96: goto -50 -> 46
    //   99: astore_2
    //   100: aconst_null
    //   101: astore_0
    //   102: goto -38 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramFile	File
    //   20	68	1	localObject1	Object
    //   11	22	2	localObject2	Object
    //   43	6	2	localException1	Exception
    //   54	19	2	localObject3	Object
    //   91	1	2	localOutOfMemoryError1	OutOfMemoryError
    //   95	1	2	localException2	Exception
    //   99	1	2	localOutOfMemoryError2	OutOfMemoryError
    //   1	59	3	localObject4	Object
    //   3	50	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   14	19	43	java/lang/Exception
    //   21	29	74	finally
    //   48	52	74	finally
    //   66	70	74	finally
    //   72	74	74	finally
    //   14	19	85	finally
    //   21	29	91	java/lang/OutOfMemoryError
    //   21	29	95	java/lang/Exception
    //   14	19	99	java/lang/OutOfMemoryError
  }
  
  public static boolean removeTbsFiles(File paramFile)
  {
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = bool2;
    if (paramFile.exists())
    {
      paramFile = paramFile.listFiles();
      bool1 = bool2;
      if (paramFile != null)
      {
        bool1 = false;
        if (i < paramFile.length)
        {
          if (!paramFile[i].delete()) {
            TbsLog.w("FileHelper", "Could not delete native binary: " + paramFile[i].getPath());
          }
          for (;;)
          {
            i += 1;
            break;
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean removeTbsFiles(String paramString)
  {
    return removeTbsFiles(new File(paramString));
  }
  
  public static byte[] toByteArray(InputStream paramInputStream)
    throws IOException, OutOfMemoryError
  {
    return toByteArrayOutputStream(paramInputStream).toByteArray();
  }
  
  public static ByteArrayOutputStream toByteArrayOutputStream(InputStream paramInputStream)
    throws IOException, OutOfMemoryError
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    copy(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream;
  }
  
  public static FileLock tryFileLock(Context paramContext, FileOutputStream paramFileOutputStream)
  {
    if (paramFileOutputStream == null) {
      return null;
    }
    try
    {
      paramContext = paramFileOutputStream.getChannel().tryLock();
      boolean bool = paramContext.isValid();
      if (bool) {
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      try
      {
        paramFileOutputStream.close();
        return null;
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return null;
  }
  
  public static abstract interface FileComparator
  {
    public abstract boolean equals(File paramFile1, File paramFile2);
  }
  
  public static abstract interface IterateHandler
  {
    public abstract boolean handleEntry(InputStream paramInputStream, ZipEntry paramZipEntry, String paramString)
      throws Exception;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\utils\FileUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */