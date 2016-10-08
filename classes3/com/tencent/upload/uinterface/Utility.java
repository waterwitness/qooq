package com.tencent.upload.uinterface;

import android.content.Context;
import android.content.Intent;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.network.b.m;
import java.util.StringTokenizer;

public class Utility
{
  public static volatile String CUSTOM_IP = "119.147.14.28";
  public static volatile int CUSTOM_PORT = 19994;
  public static final String DB_IP = "113.108.67.20";
  public static final int DB_PORT = 19995;
  public static final String DEBUG1_IP = "180.153.160.39";
  public static final int DEBUG1_PORT = 19994;
  public static final String DEBUG2_IP = "183.61.40.170";
  public static final int DEBUG2_PORT = 8080;
  public static final String DEBUG3_IP = "113.108.84.33";
  public static final int DEBUG3_PORT = 8080;
  public static final String DEBUG4_IP = "113.108.89.186";
  public static final int DEBUG4_PORT = 8080;
  public static final String DEV_IP = "113.108.67.16";
  public static final int DEV_PORT = 19994;
  
  public static final boolean clearUploadTempCache(Context paramContext)
  {
    return IUploadService.UploadServiceCreator.getInstance().clearCacheWhenIdle(paramContext);
  }
  
  public static String decrypt(String paramString)
  {
    try
    {
      String str = new String();
      StringTokenizer localStringTokenizer = new StringTokenizer(paramString, "%");
      int i;
      for (paramString = str; localStringTokenizer.hasMoreElements(); paramString = paramString + (char)(i - 27)) {
        i = Integer.parseInt((String)localStringTokenizer.nextElement());
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static final long getCurrentUploadServerTime()
  {
    long[] arrayOfLong = UploadConfiguration.getUploadServerTimePair();
    if ((arrayOfLong == null) || (arrayOfLong.length != 2) || (arrayOfLong[0] <= 0L) || (arrayOfLong[1] <= 0L)) {
      return System.currentTimeMillis() / 1000L;
    }
    return arrayOfLong[0] + System.currentTimeMillis() / 1000L - arrayOfLong[1];
  }
  
  public static final boolean isCompressToWebp(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 2) && ((paramInt1 & 0x10) == 16)) {}
    while ((paramInt2 != 2) && (paramInt2 != 3) && ((paramInt1 & 0x1) == 1)) {
      return true;
    }
    return false;
  }
  
  public static final void keepLongConnection(Context paramContext, Long paramLong, String paramString)
  {
    keepLongConnection(paramContext, paramLong, paramString, "126%138%136%73%140%149%138%137%128%", "126%138%136%73%143%128%137%126%128%137%143%73%146%137%142%73%128%147%139%138%141%143%73%96%136%139%143%148%110%128%141%145%132%126%128%");
  }
  
  public static final void keepLongConnection(Context paramContext, Long paramLong, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("param_from", 0);
    localIntent.putExtra("param_uin", paramLong);
    localIntent.putExtra("param_scene", 2);
    localIntent.putExtra("param_push_data", paramString1);
    localIntent.setClassName(decrypt(paramString2), decrypt(paramString3));
    paramContext.startService(localIntent);
  }
  
  public static class AlbumTypeID
  {
    public static final int ALBUM_BLOG = 2;
    public static final int ALBUM_BLOGFACE = 9;
    public static final int ALBUM_CAMPUS = 5;
    public static final int ALBUM_COMMON = 0;
    public static final int ALBUM_MICRO = 11;
    public static final int ALBUM_MOBILE = 1;
    public static final int ALBUM_OLDMICRO = 12;
    public static final int ALBUM_OLDPYHEAD = 18;
    public static final int ALBUM_OLDQPAI = 14;
    public static final int ALBUM_OLDQPAI_SYNC = 16;
    public static final int ALBUM_OLDQZONEAPP = 20;
    public static final int ALBUM_PPT = 10;
    public static final int ALBUM_PRIVBLOG = 7;
    public static final int ALBUM_PYHEAD = 17;
    public static final int ALBUM_QPAI = 13;
    public static final int ALBUM_QPAI_SYNC = 15;
    public static final int ALBUM_QQSHOW = 4;
    public static final int ALBUM_QZONEAPP = 19;
  }
  
  public static final class ServerCategory
  {
    public static final int LOG = 2;
    public static final int OTHER = 1;
    public static final int PICTURE = 0;
    public static final int TOTAL_COUNT = 3;
    
    public static final String print(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return "SUnknown";
      case 0: 
        return "SPic";
      case 1: 
        return "SOther";
      }
      return "SLog";
    }
  }
  
  public static final class TestServerCategory
  {
    public static final int CUSTOM = 5;
    public static final int DB = 1;
    public static final int DEBUG1 = 3;
    public static final int DEBUG2 = 4;
    public static final int DEBUG3 = 6;
    public static final int DEBUG4 = 7;
    public static final int DEV = 2;
    public static final int NORMAL = 0;
    
    public static final m getTestRoute(int paramInt1, int paramInt2)
    {
      paramInt1 = 19994;
      String str;
      switch (paramInt2)
      {
      default: 
        str = "113.108.67.20";
        paramInt1 = 19995;
      }
      for (;;)
      {
        return new m(str, paramInt1, 3);
        str = "113.108.67.16";
        continue;
        str = "180.153.160.39";
        continue;
        str = "183.61.40.170";
        paramInt1 = 8080;
        continue;
        str = "113.108.84.33";
        paramInt1 = 8080;
        continue;
        str = "113.108.89.186";
        paramInt1 = 8080;
        continue;
        str = Utility.CUSTOM_IP;
        paramInt1 = Utility.CUSTOM_PORT;
      }
    }
    
    public static final String getTestServerInfo(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return "上传正式环境";
      case 2: 
        return "开发(113.108.67.16:19994)";
      case 3: 
        return "联调1(180.153.160.39:19994)";
      case 4: 
        return "联调2(183.61.40.170:8080)";
      case 6: 
        return "联调3(113.108.84.33:8080)";
      case 7: 
        return "联调4(113.108.89.186:8080)";
      case 1: 
        return "DB(113.108.67.20:19995)";
      }
      return "自定义(" + Utility.CUSTOM_IP + ":" + Utility.CUSTOM_PORT + ")";
    }
    
    public static final String print(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return "unknownServer";
      case 0: 
        return "normalServer";
      case 1: 
        return "dbServer";
      case 2: 
        return "devServer";
      case 3: 
        return "debug1Server";
      case 4: 
        return "debug2Server";
      case 6: 
        return "debug3Server";
      case 7: 
        return "debug4Server";
      }
      return "customServer";
    }
    
    public static final boolean useTestServer(int paramInt)
    {
      return paramInt != 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\Utility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */