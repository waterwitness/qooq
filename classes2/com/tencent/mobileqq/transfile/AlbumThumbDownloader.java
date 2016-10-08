package com.tencent.mobileqq.transfile;

import android.app.Application;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader.Adapter;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public class AlbumThumbDownloader
  extends ProtocolDownloader.Adapter
{
  public static int a = 200;
  public static final String c = "AlbumThumb";
  public static final String d = "DEFAULT";
  public static final String e = "FLOW_THUMB";
  public static final String f = "VIDEO";
  public static final String g = "APP_VIDEO";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public AlbumThumbDownloader(Application paramApplication) {}
  
  /* Error */
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: getstatic 47	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   3: astore_3
    //   4: ldc 49
    //   6: aload_2
    //   7: getfield 55	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   10: invokevirtual 61	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   13: ifne +13 -> 26
    //   16: new 63	java/lang/RuntimeException
    //   19: dup
    //   20: ldc 65
    //   22: invokespecial 68	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   25: athrow
    //   26: aload_2
    //   27: getfield 55	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   30: checkcast 49	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   33: astore_1
    //   34: aload_2
    //   35: getfield 72	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   38: invokevirtual 78	java/net/URL:getRef	()Ljava/lang/String;
    //   41: astore 4
    //   43: ldc 20
    //   45: aload 4
    //   47: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   50: ifeq +26 -> 76
    //   53: new 85	com/tencent/mobileqq/activity/photo/VideoDecoder
    //   56: dup
    //   57: aload_3
    //   58: aload_1
    //   59: invokespecial 88	com/tencent/mobileqq/activity/photo/VideoDecoder:<init>	(Landroid/content/Context;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V
    //   62: astore_1
    //   63: aload_3
    //   64: invokestatic 93	com/tencent/mobileqq/activity/photo/AlbumThumbManager:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/activity/photo/AlbumThumbManager;
    //   67: aload_2
    //   68: getfield 72	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   71: aload_1
    //   72: invokevirtual 97	com/tencent/mobileqq/activity/photo/AlbumThumbManager:b	(Ljava/net/URL;Lcom/tencent/mobileqq/transfile/bitmapcreator/BitmapDecoder;)Landroid/graphics/Bitmap;
    //   75: areturn
    //   76: ldc 17
    //   78: aload 4
    //   80: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   83: ifeq +16 -> 99
    //   86: new 99	com/tencent/mobileqq/activity/photo/FlowThumbDecoder
    //   89: dup
    //   90: aload_3
    //   91: aload_1
    //   92: invokespecial 100	com/tencent/mobileqq/activity/photo/FlowThumbDecoder:<init>	(Landroid/content/Context;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V
    //   95: astore_1
    //   96: goto -33 -> 63
    //   99: ldc 23
    //   101: aload 4
    //   103: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   106: ifeq +16 -> 122
    //   109: new 102	com/tencent/mobileqq/activity/photo/AppVideoDecoder
    //   112: dup
    //   113: aload_3
    //   114: aload_1
    //   115: invokespecial 103	com/tencent/mobileqq/activity/photo/AppVideoDecoder:<init>	(Landroid/content/Context;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V
    //   118: astore_1
    //   119: goto -56 -> 63
    //   122: new 105	com/tencent/mobileqq/activity/photo/ThumbDecoder
    //   125: dup
    //   126: aload_3
    //   127: aload_1
    //   128: invokespecial 106	com/tencent/mobileqq/activity/photo/ThumbDecoder:<init>	(Landroid/content/Context;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V
    //   131: astore_1
    //   132: goto -69 -> 63
    //   135: astore_1
    //   136: new 63	java/lang/RuntimeException
    //   139: dup
    //   140: ldc 108
    //   142: invokespecial 68	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	AlbumThumbDownloader
    //   0	146	1	paramFile	File
    //   0	146	2	paramDownloadParams	DownloadParams
    //   0	146	3	paramURLDrawableHandler	URLDrawableHandler
    //   41	61	4	str	String
    // Exception table:
    //   from	to	target	type
    //   34	63	135	java/lang/NumberFormatException
    //   63	76	135	java/lang/NumberFormatException
    //   76	96	135	java/lang/NumberFormatException
    //   99	119	135	java/lang/NumberFormatException
    //   122	132	135	java/lang/NumberFormatException
  }
  
  public boolean hasDiskFile(DownloadParams paramDownloadParams)
  {
    return true;
  }
  
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return new File(AppConstants.bh);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\AlbumThumbDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */