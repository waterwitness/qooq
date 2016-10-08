package com.tencent.proxyinner.utility;

import android.content.Context;
import android.os.Environment;
import com.tencent.proxyinner.log.XLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import org.apache.http.util.EncodingUtils;

public class UtilFile
{
  public static String getSixgodPluginRootDir(Context paramContext)
  {
    paramContext = paramContext.getDir("SixGodPlugin", 0).getAbsolutePath() + File.separator;
    File localFile = new File(paramContext);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return paramContext;
  }
  
  public static String readSDCardFile(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + paramString);
      str1 = str2;
      paramString = new byte[localFileInputStream.available()];
      str1 = str2;
      localFileInputStream.read(paramString);
      str1 = str2;
      paramString = EncodingUtils.getString(paramString, "UTF-8");
      str1 = paramString;
      localFileInputStream.close();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return str1;
  }
  
  public static void writeTextToFile(String paramString1, String paramString2)
  {
    paramString2 = "sdcard/" + paramString2;
    try
    {
      paramString2 = new FileOutputStream(paramString2);
      OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(paramString2);
      localOutputStreamWriter.write(paramString1);
      localOutputStreamWriter.flush();
      paramString2.close();
      return;
    }
    catch (Exception paramString1)
    {
      XLog.i("UtilFile", "写Json数据失败 ");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\proxyinner\utility\UtilFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */