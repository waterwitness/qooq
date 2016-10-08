package com.tencent.upload.a;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.imageservice.BitmapUtils;
import com.tencent.imageservice.ImageProcessData;
import com.tencent.imageservice.ImageProcessService;
import com.tencent.imageservice.ImageProcessUtil;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.f;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadAction;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import com.tencent.upload.uinterface.IUploadLog;
import com.tencent.upload.uinterface.IUploadReport;
import com.tencent.upload.uinterface.IUploadService.IUploadServiceContext;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.IUploadTaskType;
import com.tencent.upload.uinterface.Report;
import com.tencent.upload.uinterface.Utility;
import com.tencent.upload.uinterface.Utility.ServerCategory;
import com.tencent.upload.uinterface.data.BatchCommitUploadTask;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;

public final class b
{
  volatile boolean a;
  byte[] b = new byte[0];
  final Messenger c = new Messenger(new b((byte)0));
  a d;
  Messenger e = null;
  private final ServiceConnection f = new c(this);
  private Context g = f.a();
  
  public b(a parama)
  {
    this.d = parama;
  }
  
  public static Object a(AbstractUploadTask paramAbstractUploadTask, String paramString)
  {
    if ((paramAbstractUploadTask == null) || (paramString == null)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = paramAbstractUploadTask.getClass().getField(paramString);
        if (paramString != null)
        {
          paramAbstractUploadTask = paramString.get(paramAbstractUploadTask);
          return paramAbstractUploadTask;
        }
      }
      catch (NoSuchFieldException paramAbstractUploadTask)
      {
        a(Utility.class.getSimpleName(), paramAbstractUploadTask.toString());
        return null;
      }
      catch (IllegalArgumentException paramAbstractUploadTask)
      {
        a(Utility.class.getSimpleName(), paramAbstractUploadTask.toString());
        return null;
      }
      catch (IllegalAccessException paramAbstractUploadTask)
      {
        a(Utility.class.getSimpleName(), paramAbstractUploadTask.toString());
        return null;
      }
      catch (NullPointerException paramAbstractUploadTask)
      {
        a(Utility.class.getSimpleName(), paramAbstractUploadTask.toString());
      }
    }
    return null;
  }
  
  public static String a(com.tencent.upload.network.a.d paramd)
  {
    if (paramd == null) {
      return "null";
    }
    return Integer.toString(paramd.f());
  }
  
  public static String a(com.tencent.upload.network.b.d paramd)
  {
    if (paramd == null) {
      return "null";
    }
    return Utility.ServerCategory.print(paramd.d());
  }
  
  public static String a(AbstractUploadTask paramAbstractUploadTask, byte[] paramArrayOfByte)
  {
    if ((paramAbstractUploadTask == null) || (paramArrayOfByte == null)) {
      return "";
    }
    Object localObject = String.format("upload_info_%d", new Object[] { Long.valueOf(f.b().getCurrentUin()) });
    localObject = f.a().getSharedPreferences((String)localObject, 0);
    if ((paramAbstractUploadTask instanceof BatchCommitUploadTask))
    {
      paramArrayOfByte = com.tencent.upload.common.b.a(paramArrayOfByte);
      b("ServiceImpl", "BatchCommitUploadTask calc descMd5 = " + paramArrayOfByte + " flowId = " + paramAbstractUploadTask.flowId + " sFileMD5 = " + paramAbstractUploadTask.sFileMD5 + " iUploadTime = " + paramAbstractUploadTask.iUploadTime);
      return paramArrayOfByte;
    }
    String str1 = String.valueOf(paramAbstractUploadTask.flowId) + "_" + paramAbstractUploadTask.sFileMD5 + "_" + paramAbstractUploadTask.iUploadTime;
    String str2 = ((SharedPreferences)localObject).getString(str1, null);
    if (str2 != null)
    {
      b("ServiceImpl", "load descMd5 = " + str2 + " flowId = " + paramAbstractUploadTask.flowId + " sFileMD5 = " + paramAbstractUploadTask.sFileMD5 + " iUploadTime = " + paramAbstractUploadTask.iUploadTime);
      return str2;
    }
    paramArrayOfByte = com.tencent.upload.common.b.a(paramArrayOfByte);
    ((SharedPreferences)localObject).edit().putString(str1, paramArrayOfByte).commit();
    b("ServiceImpl", "save descMd5 = " + paramArrayOfByte + " flowId = " + paramAbstractUploadTask.flowId + " sFileMD5 = " + paramAbstractUploadTask.sFileMD5 + " iUploadTime = " + paramAbstractUploadTask.iUploadTime);
    return paramArrayOfByte;
  }
  
  public static String a(IUploadAction paramIUploadAction)
  {
    if (paramIUploadAction == null) {
      return "null";
    }
    return Integer.toString(paramIUploadAction.getActionSequence());
  }
  
  public static String a(Object paramObject)
  {
    if (paramObject == null) {
      return "null";
    }
    return Integer.toString(paramObject.hashCode());
  }
  
  private static void a(AbstractUploadTask paramAbstractUploadTask, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramAbstractUploadTask.uploadTaskCallback != null)
    {
      paramAbstractUploadTask.uploadTaskCallback.onUploadError(paramAbstractUploadTask, paramInt, paramString2);
      paramAbstractUploadTask.uploadTaskCallback.onUploadStateChange(paramAbstractUploadTask, 5);
      a("ServiceImpl", "onUploadStateChange=5");
    }
    if (paramBoolean)
    {
      int i = 0;
      if (paramInt == 700) {
        i = UploadConfiguration.getCurrentNetworkCategory();
      }
      paramAbstractUploadTask = new Report(paramInt, paramString1, paramAbstractUploadTask.flowId, paramAbstractUploadTask.uploadFilePath, paramAbstractUploadTask.getUploadTaskType(), d(paramAbstractUploadTask), 0L, 0L, 0L, "", 0, i, 0, e(paramAbstractUploadTask));
      f.c().onUploadReport(paramAbstractUploadTask);
    }
    d("ServiceImpl", paramString1);
  }
  
  public static void a(IUploadService.IUploadServiceContext paramIUploadServiceContext, AbstractUploadTask paramAbstractUploadTask)
  {
    if (paramAbstractUploadTask == null) {
      return;
    }
    if ((paramAbstractUploadTask.iLoginType == 1) && (paramAbstractUploadTask.b2Gt != null)) {
      paramAbstractUploadTask.vLoginData = com.tencent.upload.common.a.a(paramAbstractUploadTask.vLoginData, paramAbstractUploadTask.b2Gt);
    }
    if ((paramAbstractUploadTask.vLoginData == null) || (paramAbstractUploadTask.vLoginData.length == 0))
    {
      a(paramAbstractUploadTask, 505, "startUploadTask taskId=" + paramAbstractUploadTask.flowId + " file=" + paramAbstractUploadTask.uploadFilePath, "账号加密失败，请稍后重试或重新登录", true);
      return;
    }
    paramAbstractUploadTask.onProcessUploadTask(paramIUploadServiceContext);
  }
  
  public static void a(IUploadService.IUploadServiceContext paramIUploadServiceContext, AbstractUploadTask paramAbstractUploadTask, int paramInt, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = true;
    Object localObject1 = new File(paramAbstractUploadTask.uploadFilePath);
    b("ServiceImpl", paramAbstractUploadTask.getClass().getSimpleName() + " processPictureTypeUploadTask() flowId=" + paramAbstractUploadTask.flowId + " file=" + paramAbstractUploadTask.uploadFilePath + " size= " + ((File)localObject1).length() + " uploadType:" + paramInt + " autoRotate:" + paramBoolean);
    if (!((File)localObject1).exists())
    {
      a(paramIUploadServiceContext, paramAbstractUploadTask, null, "processPictureTypeUploadTask");
      return;
    }
    localObject1 = ImageProcessUtil.decodeBitmapOptions(paramAbstractUploadTask.uploadFilePath);
    Object localObject2;
    if ("image/gif".equalsIgnoreCase(((BitmapFactory.Options)localObject1).outMimeType))
    {
      paramInt = UploadConfiguration.getCurrentNetworkCategory();
      long l = new File(paramAbstractUploadTask.uploadFilePath).length();
      c("ServiceImpl", "processGif, networkType:" + paramInt + " length:" + l + " flowId:" + paramAbstractUploadTask.flowId);
      if (((paramInt == 1) && (l < 5242880L)) || ((paramInt == 3) && (l < 819200L)) || ((paramInt == 2) && (l < 2097152L)) || ((paramInt == 4) && (l < 2097152L)))
      {
        a("ServiceImpl", "processGif() 满足上传原图条件 flowId=" + paramAbstractUploadTask.flowId);
        if (f(paramAbstractUploadTask)) {
          paramInt = 2;
        }
      }
      for (;;)
      {
        if ((paramInt != 2) && (paramInt != 3))
        {
          paramBoolean = bool2;
          if (paramInt != 5) {}
        }
        else
        {
          paramBoolean = true;
        }
        a(paramIUploadServiceContext, paramAbstractUploadTask, paramBoolean, "Gif=" + paramInt);
        return;
        paramInt = 1;
        continue;
        localObject1 = BitmapUtils.getOptions();
        localObject1 = ImageProcessUtil.decodeFileWithRetry(paramAbstractUploadTask.uploadFilePath, (BitmapFactory.Options)localObject1);
        localObject2 = com.tencent.upload.common.b.a(f.a(), paramAbstractUploadTask.uploadFilePath, paramAbstractUploadTask.md5, paramAbstractUploadTask.flowId);
        if ((localObject1 != null) && (localObject2 != null) && (ImageProcessUtil.bitmapToFile((Bitmap)localObject1, (String)localObject2, 80, false, false, null)))
        {
          paramAbstractUploadTask.uploadFilePath = ((String)localObject2);
          ((Bitmap)localObject1).recycle();
          a("ServiceImpl", "processGif() 取第一帧上传 flowId=" + paramAbstractUploadTask.flowId);
          paramInt = 3;
        }
        else
        {
          if (localObject1 != null) {
            ((Bitmap)localObject1).recycle();
          }
          a("ServiceImpl", "processGif() 上传原图 flowId=" + paramAbstractUploadTask.flowId);
          if (f(paramAbstractUploadTask)) {
            paramInt = 5;
          } else {
            paramInt = 4;
          }
        }
      }
    }
    bool2 = "image/jpeg".equalsIgnoreCase(((BitmapFactory.Options)localObject1).outMimeType);
    if (bool2) {}
    for (int i = UploadConfiguration.getPictureQuality(paramAbstractUploadTask.uploadFilePath);; i = 100)
    {
      int j = i;
      if (i <= 0) {
        j = 100;
      }
      Object localObject3 = new IUploadConfig.UploadImageSize(((BitmapFactory.Options)localObject1).outWidth, ((BitmapFactory.Options)localObject1).outHeight, 100);
      if ((((IUploadConfig.UploadImageSize)localObject3).width == 0) && (((IUploadConfig.UploadImageSize)localObject3).height == 0))
      {
        a(paramAbstractUploadTask, -7, "processPictureTypeUploadTask() size illegal. path=" + paramAbstractUploadTask.uploadFilePath, "文件不存在或无效文件", true);
        return;
      }
      localObject1 = f.b();
      localObject2 = ((IUploadConfig)localObject1).getUploadImageSize((IUploadConfig.UploadImageSize)localObject3, paramInt, paramAbstractUploadTask);
      b("ServiceImpl", "processPictureTypeUploadTask() size=" + localObject3 + " targetSize=" + localObject2 + " q:" + j + " jpg:" + bool2);
      if ((localObject2 == null) || (((IUploadConfig.UploadImageSize)localObject2).height <= 0) || (((IUploadConfig.UploadImageSize)localObject2).width <= 0) || (((IUploadConfig.UploadImageSize)localObject2).quality <= 0))
      {
        i = 1;
        if ((i == 0) && ((((IUploadConfig.UploadImageSize)localObject3).width > ((IUploadConfig.UploadImageSize)localObject2).width) || (((IUploadConfig.UploadImageSize)localObject3).height > ((IUploadConfig.UploadImageSize)localObject2).height) || (j > ((IUploadConfig.UploadImageSize)localObject2).quality))) {
          break label791;
        }
        if (i == 0) {
          break label783;
        }
      }
      label783:
      for (localObject1 = "illegelTargetSize";; localObject1 = "size<targetSize")
      {
        b(paramIUploadServiceContext, paramAbstractUploadTask, (String)localObject1);
        return;
        i = 0;
        break;
      }
      label791:
      if (j < ((IUploadConfig.UploadImageSize)localObject2).quality) {
        ((IUploadConfig.UploadImageSize)localObject2).quality = j;
      }
      localObject3 = paramAbstractUploadTask.getUploadTaskType();
      if ((localObject3 != null) && (((IUploadTaskType)localObject3).getProtocolUploadType() == 0))
      {
        i = 1;
        if ((!Utility.isCompressToWebp(((IUploadConfig)localObject1).getCompressToWebpFlag(), paramInt)) || (i == 0)) {
          break label889;
        }
      }
      for (;;)
      {
        if (paramIUploadServiceContext.compressUploadTask(paramAbstractUploadTask, (IUploadConfig.UploadImageSize)localObject2, paramBoolean, bool1)) {
          break label893;
        }
        b(paramIUploadServiceContext, paramAbstractUploadTask, "processPictureTypeUploadTask=noCompress");
        b("ServiceImpl", "processPictureTypeUploadTask()没有发到图片压缩进程");
        return;
        i = 0;
        break;
        label889:
        bool1 = false;
      }
      label893:
      break;
    }
  }
  
  public static void a(IUploadService.IUploadServiceContext paramIUploadServiceContext, AbstractUploadTask paramAbstractUploadTask, String paramString)
  {
    try
    {
      IUploadAction localIUploadAction = paramAbstractUploadTask.onCreateUploadAction(false);
      if ((paramString != null) && ((localIUploadAction instanceof d))) {
        ((d)localIUploadAction).setReportAppendMsg(paramString);
      }
      paramIUploadServiceContext.uploadAction(localIUploadAction);
      return;
    }
    catch (Exception paramIUploadServiceContext)
    {
      a(paramAbstractUploadTask, 499, Log.getStackTraceString(paramIUploadServiceContext), null, true);
    }
  }
  
  public static void a(IUploadService.IUploadServiceContext paramIUploadServiceContext, AbstractUploadTask paramAbstractUploadTask, String paramString, int paramInt)
  {
    File localFile = new File(paramAbstractUploadTask.uploadFilePath);
    boolean bool;
    if ((paramInt > 0) && (localFile.length() < paramInt))
    {
      bool = f(paramAbstractUploadTask);
      paramString = paramString + " copy pic sizeThreshold ";
    }
    for (;;)
    {
      if (bool) {}
      for (paramString = paramString + " || uploadCopy=copy";; paramString = paramString + " || uploadCopy=original")
      {
        a(paramIUploadServiceContext, paramAbstractUploadTask, bool, paramString);
        return;
      }
      bool = false;
    }
  }
  
  public static void a(IUploadService.IUploadServiceContext paramIUploadServiceContext, AbstractUploadTask paramAbstractUploadTask, String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = com.tencent.upload.common.b.a(f.a(), paramAbstractUploadTask.uploadFilePath, paramAbstractUploadTask.md5, paramAbstractUploadTask.flowId);
    }
    if (com.tencent.upload.common.b.b(paramString2))
    {
      paramAbstractUploadTask.uploadFilePath = paramString2;
      a(paramIUploadServiceContext, paramAbstractUploadTask, true, str + " uploadTaskByTempFile || uploadCopy=cache");
      return;
    }
    a(paramAbstractUploadTask, 700, str + " uploadTaskByTempFile() file inexistent. path=" + paramAbstractUploadTask.uploadFilePath, "文件不存在", true);
  }
  
  public static void a(IUploadService.IUploadServiceContext paramIUploadServiceContext, AbstractUploadTask paramAbstractUploadTask, boolean paramBoolean, String paramString)
  {
    boolean bool = true;
    Object localObject = paramAbstractUploadTask.getClass().getSimpleName();
    long l = new File(paramAbstractUploadTask.uploadFilePath).length();
    b("ServiceImpl", (String)localObject + " uploadTask() flowId=" + paramAbstractUploadTask.flowId + " file=" + paramAbstractUploadTask.uploadFilePath + " size= " + l + " deleteAfter=" + paramBoolean + " errMsg:" + paramString);
    if (l == 0L)
    {
      paramIUploadServiceContext = (String)localObject + " uploadTask(), not exist path:" + paramAbstractUploadTask.uploadFilePath + " errMsg:" + paramString;
      if (!paramAbstractUploadTask.hasRetried) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        a(paramAbstractUploadTask, 700, paramIUploadServiceContext, "文件不存在", paramBoolean);
        return;
      }
    }
    try
    {
      localObject = paramAbstractUploadTask.onCreateUploadAction(paramBoolean);
      if ((paramString != null) && ((localObject instanceof d))) {
        ((d)localObject).setReportAppendMsg(paramString);
      }
      paramIUploadServiceContext.uploadAction((IUploadAction)localObject);
      return;
    }
    catch (Exception paramIUploadServiceContext)
    {
      a(paramAbstractUploadTask, 499, Log.getStackTraceString(paramIUploadServiceContext), null, true);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    IUploadLog localIUploadLog = f.d();
    if (localIUploadLog == null)
    {
      Log.v("upload2: " + paramString1, paramString2);
      return;
    }
    localIUploadLog.v("upload2: " + paramString1, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    IUploadLog localIUploadLog = f.d();
    if (localIUploadLog == null)
    {
      Log.w("upload2: " + paramString1, paramString2, paramThrowable);
      return;
    }
    localIUploadLog.w("upload2: " + paramString1, paramString2, paramThrowable);
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    IUploadLog localIUploadLog = f.d();
    if (localIUploadLog == null)
    {
      Log.w("upload2: " + paramString, paramThrowable);
      return;
    }
    localIUploadLog.w("upload2: " + paramString, paramThrowable);
  }
  
  public static boolean a(AbstractUploadTask paramAbstractUploadTask)
  {
    boolean bool2 = true;
    Object localObject2;
    Object localObject1;
    boolean bool1;
    if (!com.tencent.upload.common.b.a(paramAbstractUploadTask.uploadFilePath))
    {
      localObject2 = f.a();
      localObject1 = com.tencent.upload.common.b.a((Context)localObject2, paramAbstractUploadTask.uploadFilePath, paramAbstractUploadTask.md5, paramAbstractUploadTask.flowId);
      if (com.tencent.upload.common.b.b((String)localObject1)) {
        break label208;
      }
      localObject2 = com.tencent.upload.common.b.a((Context)localObject2, paramAbstractUploadTask.uploadFilePath, paramAbstractUploadTask.md5);
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        bool1 = false;
      }
    }
    for (;;)
    {
      if (!bool1)
      {
        localObject1 = "verifyUploadFileFully() file !exist. path=" + paramAbstractUploadTask.uploadFilePath;
        if (!paramAbstractUploadTask.hasRetried) {}
        for (bool1 = bool2;; bool1 = false)
        {
          a(paramAbstractUploadTask, 700, (String)localObject1, "文件不存在", bool1);
          return false;
          bool1 = com.tencent.upload.common.b.a((String)localObject2, (String)localObject1);
          break;
        }
        localObject1 = new SoftReference(new byte[0]);
        localObject2 = ImageProcessUtil.decodeBitmapSize(paramAbstractUploadTask.uploadFilePath);
        if (((SoftReference)localObject1).get() != null) {
          break label203;
        }
      }
      label203:
      for (bool1 = true;; bool1 = false)
      {
        if ((((IUploadConfig.UploadImageSize)localObject2).height <= 0) || (((IUploadConfig.UploadImageSize)localObject2).width <= 0))
        {
          a(paramAbstractUploadTask, 701, "verifyUploadFileFully() file !valid. path=" + paramAbstractUploadTask.uploadFilePath, "无效文件", bool1);
          return false;
        }
        return true;
      }
      label208:
      bool1 = true;
    }
  }
  
  public static String b(com.tencent.upload.network.a.d paramd)
  {
    if (paramd == null) {
      return "null";
    }
    return Integer.toString(paramd.h());
  }
  
  public static void b(IUploadService.IUploadServiceContext paramIUploadServiceContext, AbstractUploadTask paramAbstractUploadTask)
  {
    a(paramIUploadServiceContext, paramAbstractUploadTask, false, null);
  }
  
  public static void b(IUploadService.IUploadServiceContext paramIUploadServiceContext, AbstractUploadTask paramAbstractUploadTask, String paramString)
  {
    boolean bool = f(paramAbstractUploadTask);
    if (bool) {}
    for (paramString = paramString + " || uploadCopy=copy";; paramString = paramString + " || uploadCopy=original")
    {
      a(paramIUploadServiceContext, paramAbstractUploadTask, bool, paramString);
      return;
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    IUploadLog localIUploadLog = f.d();
    if (localIUploadLog == null)
    {
      Log.d("upload2: " + paramString1, paramString2);
      return;
    }
    localIUploadLog.d("upload2: " + paramString1, paramString2);
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    IUploadLog localIUploadLog = f.d();
    if (localIUploadLog == null)
    {
      Log.e("upload2: " + paramString1, paramString2, paramThrowable);
      return;
    }
    localIUploadLog.e("upload2: " + paramString1, paramString2, paramThrowable);
  }
  
  public static boolean b(AbstractUploadTask paramAbstractUploadTask)
  {
    boolean bool = true;
    if (!com.tencent.upload.common.b.a(paramAbstractUploadTask.uploadFilePath))
    {
      String str = "verifyUploadFileDirectly() file !exist. path=" + paramAbstractUploadTask.uploadFilePath;
      if (!paramAbstractUploadTask.hasRetried) {}
      for (;;)
      {
        a(paramAbstractUploadTask, 700, str, "文件不存在", bool);
        return false;
        bool = false;
      }
    }
    return true;
  }
  
  public static void c(String paramString1, String paramString2)
  {
    IUploadLog localIUploadLog = f.d();
    if (localIUploadLog == null)
    {
      Log.i("upload2: " + paramString1, paramString2);
      return;
    }
    localIUploadLog.i("upload2: " + paramString1, paramString2);
  }
  
  public static boolean c(AbstractUploadTask paramAbstractUploadTask)
  {
    if (paramAbstractUploadTask == null) {
      e("ServiceImpl", "verifyUploadTask task==null");
    }
    do
    {
      return false;
      if (paramAbstractUploadTask.iUin == 0L)
      {
        a(paramAbstractUploadTask, 703, " iUin=0", "登录账号出错", true);
        return false;
      }
      if (paramAbstractUploadTask.iLoginType == 1)
      {
        if ((paramAbstractUploadTask.vLoginData == null) || (paramAbstractUploadTask.vLoginData.length == 0) || (paramAbstractUploadTask.vLoginKey == null) || (paramAbstractUploadTask.vLoginKey.length == 0))
        {
          a(paramAbstractUploadTask, 702, " verifyUploadTask a2b2=0. iloginType=" + paramAbstractUploadTask.iLoginType + " path=" + paramAbstractUploadTask.uploadFilePath, "登录账号出错", true);
          return false;
        }
      }
      else if ((paramAbstractUploadTask.vLoginData == null) || (paramAbstractUploadTask.vLoginData.length == 0))
      {
        a(paramAbstractUploadTask, 702, " verifyUploadTask a2=0, iLoginType=" + paramAbstractUploadTask.iLoginType + " path=" + paramAbstractUploadTask.uploadFilePath, "登录账号出错", true);
        return false;
      }
    } while (!paramAbstractUploadTask.onVerifyUploadFile());
    return true;
  }
  
  public static String d(AbstractUploadTask paramAbstractUploadTask)
  {
    paramAbstractUploadTask = a(paramAbstractUploadTask, "sfUppAppId");
    if ((paramAbstractUploadTask instanceof String)) {
      return (String)paramAbstractUploadTask;
    }
    return null;
  }
  
  public static void d(String paramString1, String paramString2)
  {
    IUploadLog localIUploadLog = f.d();
    if (localIUploadLog == null)
    {
      Log.w("upload2: " + paramString1, paramString2);
      return;
    }
    localIUploadLog.w("upload2: " + paramString1, paramString2);
  }
  
  public static int e(AbstractUploadTask paramAbstractUploadTask)
  {
    paramAbstractUploadTask = a(paramAbstractUploadTask, "iIsNew");
    if ((paramAbstractUploadTask instanceof Integer))
    {
      if (((Integer)paramAbstractUploadTask).intValue() == 1) {
        return 2;
      }
      return 1;
    }
    return 0;
  }
  
  public static void e(String paramString1, String paramString2)
  {
    IUploadLog localIUploadLog = f.d();
    if (localIUploadLog == null)
    {
      Log.e("upload2: " + paramString1, paramString2);
      return;
    }
    localIUploadLog.e("upload2: " + paramString1, paramString2);
  }
  
  public static boolean f(AbstractUploadTask paramAbstractUploadTask)
  {
    String str = com.tencent.upload.common.b.a(f.a(), paramAbstractUploadTask.uploadFilePath, paramAbstractUploadTask.md5, paramAbstractUploadTask.flowId);
    boolean bool1;
    if (TextUtils.isEmpty(str)) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = com.tencent.upload.common.b.a(paramAbstractUploadTask.uploadFilePath, str);
      bool1 = bool2;
    } while (!bool2);
    paramAbstractUploadTask.uploadFilePath = str;
    return bool2;
  }
  
  public static void g(AbstractUploadTask paramAbstractUploadTask)
  {
    if (paramAbstractUploadTask == null) {
      return;
    }
    Object localObject = String.format("upload_info_%d", new Object[] { Long.valueOf(f.b().getCurrentUin()) });
    localObject = f.a().getSharedPreferences((String)localObject, 0);
    String str = String.valueOf(paramAbstractUploadTask.flowId) + "_" + paramAbstractUploadTask.sFileMD5 + "_" + paramAbstractUploadTask.iUploadTime;
    ((SharedPreferences)localObject).edit().remove(str).commit();
    b("ServiceImpl", "remove  flowId = " + paramAbstractUploadTask.flowId + " sFileMD5 = " + paramAbstractUploadTask.sFileMD5 + " iUploadTime = " + paramAbstractUploadTask.iUploadTime);
  }
  
  public final boolean a()
  {
    if (this.a) {
      return true;
    }
    a("ServiceImpl", "start bindService");
    synchronized (this.b)
    {
      this.g.bindService(new Intent(this.g, ImageProcessService.class), this.f, 1);
    }
    try
    {
      this.b.wait(10000L);
      a("ServiceImpl", "end bindService mBound = " + this.a);
      return this.a;
      localObject = finally;
      throw ((Throwable)localObject);
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  public final boolean a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    b("ServiceImpl", "send MSG_COPY_AND_COMPRESS_IMAGE_REQUEST mBound = " + this.a + " flowId=" + paramInt1 + " originalFilePath = " + paramString1 + " md5 = " + paramString2 + " targetWidth = " + paramInt2 + " targetHeight = " + paramInt3 + " quality = " + paramInt4 + " autoRotate = " + paramBoolean1 + " compressToWebp = " + paramBoolean2);
    if (!this.a) {
      return false;
    }
    Message localMessage = Message.obtain(null, 1);
    localMessage.arg1 = paramInt1;
    localMessage.replyTo = this.c;
    paramString2 = com.tencent.upload.common.b.a(this.g, paramString1, paramString2, paramInt1);
    if (TextUtils.isEmpty(paramString2)) {
      return false;
    }
    localMessage.getData().putParcelable("KEY_MSG_COMPRESS", new ImageProcessData(paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2, null));
    try
    {
      if (this.e != null)
      {
        this.e.send(localMessage);
        return true;
      }
    }
    catch (Exception paramString1)
    {
      a("ServiceImpl", "ImageCompressor", paramString1);
    }
    return false;
  }
  
  public final void b()
  {
    if (!this.a) {
      return;
    }
    this.g.unbindService(this.f);
    this.a = false;
  }
  
  public static final class a
  {
    a(g paramg) {}
    
    public final void a()
    {
      if ((g.f(this.a) == null) || (g.f(this.a).size() == 0)) {
        return;
      }
      b.b("ServiceImpl", "re asyncCopyAndCompressFile count=" + g.f(this.a).size());
      int j = g.f(this.a).size();
      int i = 0;
      label67:
      if (i < j)
      {
        if ((g.f(this.a).valueAt(i) instanceof a)) {
          break label103;
        }
        b.d("ServiceImpl", "onServiceConnected() not instance of ImageCompressPendingTask");
      }
      for (;;)
      {
        i += 1;
        break label67;
        break;
        label103:
        a locala = (a)g.f(this.a).valueAt(i);
        if (!g.k(this.a).a(locala.a.flowId, locala.a.uploadFilePath, locala.a.md5, locala.b, locala.c, locala.d, locala.e, locala.f)) {
          b.b(g.j(this.a), locala.a, "asyncCopyAndCompressFile=false");
        }
      }
    }
  }
  
  final class b
    extends Handler
  {
    private b() {}
    
    public final void handleMessage(Message paramMessage)
    {
      Object localObject1 = null;
      Object localObject3;
      switch (paramMessage.what)
      {
      default: 
        super.handleMessage(paramMessage);
        return;
      case 101: 
        b.a("ServiceImpl", "receive MSG_COPY_AND_COMPRESS_IMAGE_RESPONSE flowId=" + paramMessage.arg1);
        paramMessage.getData().setClassLoader(ImageProcessData.class.getClassLoader());
        localObject2 = paramMessage.getData().getParcelable("KEY_MSG_COMPRESS");
        if ((localObject2 instanceof ImageProcessData))
        {
          ImageProcessData localImageProcessData = (ImageProcessData)localObject2;
          localObject3 = localImageProcessData.originalFilePath;
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(localImageProcessData.msg))
          {
            b.b("ServiceImpl", localImageProcessData.msg);
            localObject1 = localImageProcessData.msg;
          }
        }
        break;
      }
      for (Object localObject2 = localObject3;; localObject2 = null)
      {
        localObject3 = b.this.d;
        int i = paramMessage.arg1;
        b.a("ServiceImpl", "UploadServiceImpl onCompressFinish taskId=" + i + " " + (String)localObject2);
        if (g.f(((b.a)localObject3).a) == null)
        {
          b.b("ServiceImpl", "onCompressFinish() mImageCompressingTasks==null, ignored");
          return;
        }
        paramMessage = (a)g.f(((b.a)localObject3).a).get(i);
        if (paramMessage == null)
        {
          b.b("ServiceImpl", "onCompressFinish() task==null, ignored");
          return;
        }
        g.f(((b.a)localObject3).a).remove(i);
        g.g(((b.a)localObject3).a);
        if (g.f(((b.a)localObject3).a).size() == 0) {
          g.h(((b.a)localObject3).a);
        }
        while ((TextUtils.isEmpty((CharSequence)localObject2)) || (paramMessage.a.uploadFilePath.equals(localObject2)))
        {
          b.b(g.j(((b.a)localObject3).a), paramMessage.a, (String)localObject1);
          return;
          g.i(((b.a)localObject3).a);
        }
        paramMessage.a.uploadFilePath = ((String)localObject2);
        b.a(g.j(((b.a)localObject3).a), paramMessage.a, true, (String)localObject1 + " || uploadCopy=compress");
        return;
        b.a("ServiceImpl", "receive MSG_OBTAIN_PID_RESPONSE pid:" + paramMessage.arg1);
        localObject1 = b.this.d;
        i = paramMessage.arg1;
        g.a(((b.a)localObject1).a, i);
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */