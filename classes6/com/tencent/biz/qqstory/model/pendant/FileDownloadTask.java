package com.tencent.biz.qqstory.model.pendant;

import android.os.AsyncTask;
import com.tencent.biz.qqstory.base.download.Downloader;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ijr;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.security.MessageDigest;

public class FileDownloadTask
  extends AsyncTask
{
  public static final String a = "FileDownloadTask";
  public static final boolean a = true;
  public final Downloader a;
  
  public FileDownloadTask(Downloader paramDownloader)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (paramDownloader == null) {
      throw new IllegalArgumentException("downloader should not be null");
    }
    this.a = paramDownloader;
  }
  
  public static String a(String paramString)
  {
    MessageDigest localMessageDigest;
    try
    {
      byte[] arrayOfByte = new byte['Ѐ'];
      paramString = new FileInputStream(paramString);
      localMessageDigest = MessageDigest.getInstance("MD5");
      for (;;)
      {
        int i = paramString.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      paramString.close();
    }
    catch (Exception paramString)
    {
      System.out.println("error");
      return null;
    }
    paramString = a(localMessageDigest.digest());
    return paramString;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[16];
    char[] tmp6_5 = arrayOfChar;
    tmp6_5[0] = 48;
    char[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 49;
    char[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 50;
    char[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 51;
    char[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 52;
    char[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 53;
    char[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 54;
    char[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 55;
    char[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 56;
    char[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 57;
    char[] tmp60_54 = tmp54_48;
    tmp60_54[10] = 65;
    char[] tmp66_60 = tmp60_54;
    tmp66_60[11] = 66;
    char[] tmp72_66 = tmp66_60;
    tmp72_66[12] = 67;
    char[] tmp78_72 = tmp72_66;
    tmp78_72[13] = 68;
    char[] tmp84_78 = tmp78_72;
    tmp84_78[14] = 69;
    char[] tmp90_84 = tmp84_78;
    tmp90_84[15] = 70;
    tmp90_84;
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      localStringBuilder.append(arrayOfChar[((k & 0xF0) >>> 4)]);
      localStringBuilder.append(arrayOfChar[(k & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static void a(String paramString)
  {
    SLog.b("FileDownloadTask", paramString);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    File localFile = new File(paramString1);
    if (!localFile.exists()) {}
    while (localFile.isDirectory()) {
      return false;
    }
    if (paramString2 == null) {
      return true;
    }
    paramString1 = a(paramString1);
    SLog.b("FileDownloadTask", "expectedMd5 = " + paramString2);
    SLog.b("FileDownloadTask", "file Md5    = " + paramString1);
    return paramString2.equalsIgnoreCase(paramString1);
  }
  
  protected FileDownloadTask.Output a(FileDownloadTask.Input... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    if (a(paramVarArgs.b, paramVarArgs.c))
    {
      a("already has local file, don't need download");
      return new FileDownloadTask.Output(paramVarArgs, 0, "has local file already");
    }
    this.a.a(new ijr(this, paramVarArgs));
    int i = this.a.a(paramVarArgs.a, paramVarArgs.b, 0L);
    a("download finish : " + i);
    if ((i == 0) && (!a(paramVarArgs.b, paramVarArgs.c)))
    {
      a("delete the downloaded file because of md5 mismatch");
      try
      {
        FileUtils.d(paramVarArgs.b);
        return new FileDownloadTask.Output(paramVarArgs, -1, "file md5 mismatch");
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
    return new FileDownloadTask.Output(paramVarArgs, i, "error=" + i);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\pendant\FileDownloadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */