package com.tencent.upload.uinterface.action;

import FileUpload.HeadDesc;
import FileUpload.PicExtendInfo;
import FileUpload.PicUploadControlInfo;
import FileUpload.SvcRequestHead;
import FileUpload.UploadPicInfoReq;
import FileUpload.UploadPicInfoRsp;
import FileUpload.stWaterTemplate;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.imageservice.BitmapUtils;
import com.tencent.imageservice.ImageProcessUtil;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.f;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.IUploadTaskType;
import com.tencent.upload.uinterface.Utility;
import com.tencent.upload.uinterface.data.ImageUploadResult;
import com.tencent.upload.uinterface.data.ImageUploadTask;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ImageUploadAction
  extends com.tencent.upload.a.d
{
  private boolean a;
  private PicUploadControlInfo b;
  
  public ImageUploadAction(ImageUploadTask paramImageUploadTask, boolean paramBoolean)
    throws Exception
  {
    super(paramImageUploadTask);
    this.a = paramBoolean;
    Object localObject1;
    if (paramImageUploadTask.isHead)
    {
      localObject1 = new HeadDesc();
      ((HeadDesc)localObject1).a = 0L;
      ((HeadDesc)localObject1).b = 0L;
    }
    for (;;)
    {
      String str = localObject1.getClass().getSimpleName();
      Object localObject2 = null;
      try
      {
        this.mUploadFileInfoReqBytes = com.tencent.upload.b.a.a.a(str, localObject1);
        if (this.mUploadFileInfoReqBytes == null)
        {
          paramImageUploadTask = (ImageUploadTask)localObject2;
          if (localObject2 == null) {
            paramImageUploadTask = new Exception("ImageUploadAction() pack " + str + " =null. " + localObject1);
          }
          throw paramImageUploadTask;
          localObject1 = createUploadPicInfoReq(paramImageUploadTask);
          printUploadPicInfoReq((UploadPicInfoReq)localObject1, paramImageUploadTask.flowId);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.upload.a.b.a("FlowWrapper", localException);
        }
      }
    }
    if (!(localObject1 instanceof UploadPicInfoReq)) {
      localObject1 = createUploadPicInfoReq(paramImageUploadTask);
    }
    for (;;)
    {
      localObject1 = (UploadPicInfoReq)localObject1;
      PicUploadControlInfo localPicUploadControlInfo = new PicUploadControlInfo();
      localPicUploadControlInfo.iAlbumTypeID = paramImageUploadTask.iAlbumTypeID;
      localPicUploadControlInfo.sAlbumID = paramImageUploadTask.sAlbumID;
      localPicUploadControlInfo.iNeedCheckAlbum = 1;
      if (paramImageUploadTask.preupload != 1) {
        localPicUploadControlInfo.picinfoReq = ((UploadPicInfoReq)localObject1);
      }
      for (;;)
      {
        this.b = localPicUploadControlInfo;
        localObject1 = this.b;
        com.tencent.upload.a.b.b("FlowWrapper", "PicUploadControlInfo [sAlbumID=" + ((PicUploadControlInfo)localObject1).sAlbumID + ", iAlbumTypeID=" + ((PicUploadControlInfo)localObject1).iAlbumTypeID + "]");
        this.mSvcRequestHead = createSvcRequestHead(paramImageUploadTask);
        com.tencent.upload.a.b.b("FlowWrapper", "ImageUploadAction flowId = " + paramImageUploadTask.flowId + " sDescMD5 = " + this.mSvcRequestHead.i + " sFileMD5 = " + this.mSvcRequestHead.h);
        return;
        localPicUploadControlInfo.iNeedCheckAlbum = 0;
      }
    }
  }
  
  public static UploadPicInfoReq createUploadPicInfoReq(ImageUploadTask paramImageUploadTask)
  {
    UploadPicInfoReq localUploadPicInfoReq = new UploadPicInfoReq();
    localUploadPicInfoReq.sPicTitle = com.tencent.upload.common.d.a(paramImageUploadTask.sPicTitle);
    localUploadPicInfoReq.sPicDesc = com.tencent.upload.common.d.a(paramImageUploadTask.sPicDesc);
    localUploadPicInfoReq.sAlbumID = com.tencent.upload.common.d.a(paramImageUploadTask.sAlbumID);
    localUploadPicInfoReq.sAlbumName = com.tencent.upload.common.d.a(paramImageUploadTask.sAlbumName);
    localUploadPicInfoReq.iAlbumTypeID = paramImageUploadTask.iAlbumTypeID;
    localUploadPicInfoReq.iBitmap = paramImageUploadTask.iBitmap;
    localUploadPicInfoReq.iUploadType = paramImageUploadTask.iUploadType;
    localUploadPicInfoReq.iUpPicType = paramImageUploadTask.iUpPicType;
    localUploadPicInfoReq.iBatchID = paramImageUploadTask.iBatchID;
    localUploadPicInfoReq.mutliPicInfo = paramImageUploadTask.mutliPicInfo;
    localUploadPicInfoReq.mapExt = paramImageUploadTask.mapExt;
    localUploadPicInfoReq.stExtendInfo = paramImageUploadTask.stExtendInfo;
    localUploadPicInfoReq.stExternalMapExt = paramImageUploadTask.stExternalMapExt;
    localUploadPicInfoReq.sPicPath = paramImageUploadTask.getOriginalUploadFilePath();
    Object localObject1 = ImageProcessUtil.decodeBitmapSize(paramImageUploadTask.uploadFilePath);
    localUploadPicInfoReq.iPicWidth = ((IUploadConfig.UploadImageSize)localObject1).width;
    localUploadPicInfoReq.iPicHight = ((IUploadConfig.UploadImageSize)localObject1).height;
    int i;
    if (paramImageUploadTask.bWaterType) {
      i = 1;
    }
    for (;;)
    {
      localUploadPicInfoReq.iWaterType = i;
      label207:
      Object localObject3;
      Object localObject2;
      if (Build.VERSION.SDK_INT >= 5)
      {
        if (localUploadPicInfoReq.stExtendInfo != null) {
          break label1236;
        }
        localObject1 = null;
        if (localObject1 != null)
        {
          localObject3 = (String)((Map)localObject1).get(UploadConfiguration.getExifTagCode("Make"));
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          localUploadPicInfoReq.sExif_CameraMaker = ((String)localObject2);
          localObject3 = (String)((Map)localObject1).get(UploadConfiguration.getExifTagCode("Model"));
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          localUploadPicInfoReq.sExif_CameraModel = ((String)localObject2);
          localObject3 = (String)((Map)localObject1).get(UploadConfiguration.getExifTagCode("GPSLatitude"));
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          localUploadPicInfoReq.sExif_Latitude = ((String)localObject2);
          localObject3 = (String)((Map)localObject1).get(UploadConfiguration.getExifTagCode("GPSLatitudeRef"));
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          localUploadPicInfoReq.sExif_LatitudeRef = ((String)localObject2);
          localObject3 = (String)((Map)localObject1).get(UploadConfiguration.getExifTagCode("GPSLongitude"));
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          localUploadPicInfoReq.sExif_Longitude = ((String)localObject2);
          localObject3 = (String)((Map)localObject1).get(UploadConfiguration.getExifTagCode("GPSLongitudeRef"));
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          localUploadPicInfoReq.sExif_LongitudeRef = ((String)localObject2);
          if (paramImageUploadTask.iUploadType == 3) {
            localObject1 = (String)((Map)localObject1).get(UploadConfiguration.getExifTagCode("Orientation"));
          }
        }
      }
      try
      {
        switch (Integer.parseInt((String)localObject1))
        {
        case 4: 
        case 5: 
        case 7: 
          localObject1 = "0";
          if (localUploadPicInfoReq.stExtendInfo.mapParams == null) {
            localUploadPicInfoReq.stExtendInfo.mapParams = new HashMap();
          }
          localObject3 = localUploadPicInfoReq.stExtendInfo.mapParams;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          ((Map)localObject3).put("rotation", localObject2);
          localUploadPicInfoReq.sExif_Time = paramImageUploadTask.exifTime;
          localUploadPicInfoReq.iUploadTime = paramImageUploadTask.iUploadTime;
          localObject1 = (HashMap)localUploadPicInfoReq.mapExt;
          if (localObject1 == null)
          {
            localObject1 = new HashMap();
            ((HashMap)localObject1).put("mobile_fakefeeds_clientkey", com.tencent.upload.common.d.a(paramImageUploadTask.clientFakeKey));
            if ((localUploadPicInfoReq.stExtendInfo != null) && (localUploadPicInfoReq.stExtendInfo.mapParams == null)) {
              localUploadPicInfoReq.stExtendInfo.mapParams = new HashMap();
            }
            if (localUploadPicInfoReq.stExtendInfo == null) {
              break;
            }
          }
          break;
        case 6: 
        case 8: 
          try
          {
            label472:
            localObject2 = paramImageUploadTask.getOriginalUploadFilePath();
            localObject3 = ImageProcessUtil.decodeBitmapOptions((String)localObject2);
            localUploadPicInfoReq.stExtendInfo.mapParams.put("raw_width", Integer.toString(((BitmapFactory.Options)localObject3).outWidth));
            localUploadPicInfoReq.stExtendInfo.mapParams.put("raw_height", Integer.toString(((BitmapFactory.Options)localObject3).outHeight));
            localUploadPicInfoReq.stExtendInfo.mapParams.put("raw_size", Long.toString(new File((String)localObject2).length()));
            localObject3 = (String)paramImageUploadTask.stExtendInfo.mapParams.get("geo_x");
            Map localMap = localUploadPicInfoReq.stExtendInfo.mapParams;
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localMap.put("geo_x", localObject2);
            localObject3 = (String)paramImageUploadTask.stExtendInfo.mapParams.get("geo_y");
            localMap = localUploadPicInfoReq.stExtendInfo.mapParams;
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localMap.put("geo_y", localObject2);
            localObject3 = (String)paramImageUploadTask.stExtendInfo.mapParams.get("geo_id");
            localMap = localUploadPicInfoReq.stExtendInfo.mapParams;
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localMap.put("geo_id", localObject2);
            localObject3 = (String)paramImageUploadTask.stExtendInfo.mapParams.get("geo_idname");
            localMap = localUploadPicInfoReq.stExtendInfo.mapParams;
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localMap.put("geo_idname", localObject2);
            localObject3 = (String)paramImageUploadTask.stExtendInfo.mapParams.get("geo_name");
            localMap = localUploadPicInfoReq.stExtendInfo.mapParams;
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localMap.put("geo_name", localObject2);
            localObject3 = (String)paramImageUploadTask.stExtendInfo.mapParams.get("show_geo");
            localMap = localUploadPicInfoReq.stExtendInfo.mapParams;
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "0";
            }
            localMap.put("show_geo", localObject2);
          }
          catch (Exception localException)
          {
            label1236:
            for (;;) {}
          }
          localObject2 = com.tencent.upload.a.b.a(paramImageUploadTask, "appid");
          if ((localObject2 != null) && ((localObject2 instanceof String))) {
            ((HashMap)localObject1).put("appid", (String)localObject2);
          }
          localObject2 = com.tencent.upload.a.b.a(paramImageUploadTask, "userid");
          if ((localObject2 != null) && (((localObject2 instanceof String)) || ((localObject2 instanceof Long)))) {
            ((HashMap)localObject1).put("userid", localObject2.toString());
          }
          localObject2 = com.tencent.upload.a.b.a(paramImageUploadTask, "a2_key");
          if ((localObject2 != null) && ((localObject2 instanceof byte[]))) {
            ((HashMap)localObject1).put("a2_key", new String((byte[])localObject2));
          }
          if (!TextUtils.isEmpty(paramImageUploadTask.uiRefer)) {
            ((HashMap)localObject1).put("refer", paramImageUploadTask.uiRefer);
          }
          localUploadPicInfoReq.mapExt = ((Map)localObject1);
          localUploadPicInfoReq.iDistinctUse = paramImageUploadTask.iDistinctUse;
          localUploadPicInfoReq.uploadPoi = paramImageUploadTask.uploadPoi;
          localUploadPicInfoReq.waterTemplate = new stWaterTemplate(paramImageUploadTask.waterTemplateId, paramImageUploadTask.watermarkPoiName);
          localUploadPicInfoReq.iBusiNessType = paramImageUploadTask.iBusiNessType;
          if (localUploadPicInfoReq.iBusiNessType == 1)
          {
            if (paramImageUploadTask.vBusiNessData == null) {}
            for (paramImageUploadTask = new byte[0];; paramImageUploadTask = paramImageUploadTask.vBusiNessData)
            {
              localUploadPicInfoReq.vBusiNessData = paramImageUploadTask;
              return localUploadPicInfoReq;
              i = 0;
              break;
              localObject1 = localUploadPicInfoReq.stExtendInfo.mapExif;
              break label207;
              localObject1 = "90";
              break label472;
              localObject1 = "270";
              break label472;
            }
          }
          localUploadPicInfoReq.vBusiNessData = new byte[0];
          return localUploadPicInfoReq;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          continue;
          continue;
          continue;
          localObject1 = "180";
        }
      }
    }
  }
  
  public static final void printUploadPicInfoReq(UploadPicInfoReq paramUploadPicInfoReq, int paramInt)
  {
    com.tencent.upload.a.b.b("FlowWrapper", "UploadPicInfoReq flow:" + paramInt + "[sPicTitle=" + paramUploadPicInfoReq.sPicTitle + ", sPicDesc=" + paramUploadPicInfoReq.sPicDesc + ", sAlbumName=" + paramUploadPicInfoReq.sAlbumName + ", sAlbumID=" + paramUploadPicInfoReq.sAlbumID + ", iAlbumTypeID=" + paramUploadPicInfoReq.iAlbumTypeID + ", iBitmap=" + paramUploadPicInfoReq.iBitmap + ", iUploadType=" + paramUploadPicInfoReq.iUploadType + ", iUpPicType=" + paramUploadPicInfoReq.iUpPicType + ", iBatchID=" + paramUploadPicInfoReq.iBatchID + ", sPicPath=" + paramUploadPicInfoReq.sPicPath + ", iPicWidth=" + paramUploadPicInfoReq.iPicWidth + ", iPicHight=" + paramUploadPicInfoReq.iPicHight + ", iWaterType=" + paramUploadPicInfoReq.iWaterType + ", sExif_CameraMaker=" + paramUploadPicInfoReq.sExif_CameraMaker + ", sExif_CameraModel=" + paramUploadPicInfoReq.sExif_CameraModel + ", sExif_Time=" + paramUploadPicInfoReq.sExif_Time + ", sExif_LatitudeRef=" + paramUploadPicInfoReq.sExif_LatitudeRef + ", sExif_Latitude=" + paramUploadPicInfoReq.sExif_Latitude + ", sExif_LongitudeRef=" + paramUploadPicInfoReq.sExif_LongitudeRef + ", sExif_Longitude=" + paramUploadPicInfoReq.sExif_Longitude + ", iNeedFeeds=" + paramUploadPicInfoReq.iNeedFeeds + ", iUploadTime=" + paramUploadPicInfoReq.iUploadTime + ", iDistinctUse=" + paramUploadPicInfoReq.iDistinctUse + ", uploadPoi=" + paramUploadPicInfoReq.uploadPoi + ", otherParams=" + paramUploadPicInfoReq.otherParams + "]");
  }
  
  protected byte[] getControlRequestData()
  {
    Object localObject2 = null;
    try
    {
      localObject1 = com.tencent.upload.b.a.a.a(this.b.getClass().getSimpleName(), this.b);
      localObject2 = localObject1;
      localObject1 = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1 = Log.getStackTraceString(localException);
        com.tencent.upload.a.b.a("FlowWrapper", localException);
      }
    }
    if (localObject2 == null)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "getControlRequestData() pack PicUploadControlInfo=null. " + this.b;
      }
      com.tencent.upload.a.b.e("FlowWrapper", (String)localObject2);
      return super.getControlRequestData();
    }
    return (byte[])localObject2;
  }
  
  protected com.tencent.upload.common.a getMd5$774aca96(File paramFile)
  {
    return new com.tencent.upload.common.a(1, com.tencent.upload.common.b.a(paramFile));
  }
  
  protected void onDestroy(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a)) {
      com.tencent.upload.common.b.c(this.mAbstractUploadTask.uploadFilePath);
    }
  }
  
  public void onError(com.tencent.upload.network.c.a parama, int paramInt, String paramString, boolean paramBoolean)
  {
    boolean bool1;
    int i;
    if ((paramInt != 30500) && (paramInt != 30600))
    {
      bool1 = false;
      com.tencent.upload.a.b.b("FlowWrapper", "needRetryCompress:" + bool1);
      if (!bool1) {
        break label784;
      }
      i = 31500;
    }
    for (;;)
    {
      super.onError(parama, i, paramString, paramBoolean);
      return;
      ImageUploadTask localImageUploadTask = (ImageUploadTask)this.mAbstractUploadTask;
      if ((localImageUploadTask == null) || (TextUtils.isEmpty(localImageUploadTask.getOriginalUploadFilePath())))
      {
        bool1 = false;
        break;
      }
      if ((localImageUploadTask.iUploadType == 3) || (TextUtils.isEmpty(localImageUploadTask.uploadFilePath)) || (!localImageUploadTask.uploadFilePath.endsWith(".qtmp")))
      {
        bool1 = false;
        break;
      }
      Object localObject1 = new File(localImageUploadTask.getOriginalUploadFilePath());
      if ((!((File)localObject1).exists()) || (((File)localObject1).length() <= 0L))
      {
        bool1 = false;
        break;
      }
      localImageUploadTask.uploadFilePath = localImageUploadTask.getOriginalUploadFilePath();
      Object localObject2 = ImageProcessUtil.decodeBitmapOptions(localImageUploadTask.uploadFilePath);
      label279:
      String str;
      if ("image/gif".equalsIgnoreCase(((BitmapFactory.Options)localObject2).outMimeType))
      {
        long l = ((File)localObject1).length();
        i = UploadConfiguration.getCurrentNetworkCategory();
        if (((i == 1) && (l < 5242880L)) || ((i == 3) && (l < 819200L)) || ((i == 2) && (l < 2097152L)) || ((i == 4) && (l < 2097152L)))
        {
          i = 1;
          if (i == 0)
          {
            localObject1 = BitmapUtils.getOptions();
            localObject2 = ImageProcessUtil.decodeFileWithRetry(localImageUploadTask.uploadFilePath, (BitmapFactory.Options)localObject1);
            str = com.tencent.upload.common.b.a(f.a(), localImageUploadTask.uploadFilePath, localImageUploadTask.md5, localImageUploadTask.flowId);
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              if (str != null)
              {
                localObject1 = localObject2;
                if (ImageProcessUtil.bitmapToFile((Bitmap)localObject2, str, 80, false, false, null))
                {
                  localImageUploadTask.uploadFilePath = str;
                  ((Bitmap)localObject2).recycle();
                  localObject1 = null;
                }
              }
            }
            if (localObject1 != null) {
              ((Bitmap)localObject1).recycle();
            }
          }
          com.tencent.upload.a.b.f(localImageUploadTask);
        }
      }
      for (;;)
      {
        bool1 = true;
        break;
        i = 0;
        break label279;
        i = 100;
        if ("image/jpeg".equalsIgnoreCase(((BitmapFactory.Options)localObject2).outMimeType)) {
          i = UploadConfiguration.getPictureQuality(localImageUploadTask.uploadFilePath);
        }
        int j = i;
        if (i <= 0) {
          j = 100;
        }
        localObject2 = new IUploadConfig.UploadImageSize(((BitmapFactory.Options)localObject2).outWidth, ((BitmapFactory.Options)localObject2).outHeight, 100);
        if ((((IUploadConfig.UploadImageSize)localObject2).width == 0) && (((IUploadConfig.UploadImageSize)localObject2).height == 0))
        {
          bool1 = false;
          break;
        }
        localObject1 = f.b().getUploadImageSize((IUploadConfig.UploadImageSize)localObject2, localImageUploadTask.iUploadType, localImageUploadTask);
        if ((localObject1 == null) || (((IUploadConfig.UploadImageSize)localObject1).height <= 0) || (((IUploadConfig.UploadImageSize)localObject1).width <= 0) || (((IUploadConfig.UploadImageSize)localObject1).quality <= 0)) {}
        for (i = 1;; i = 0)
        {
          if ((i == 0) && ((((IUploadConfig.UploadImageSize)localObject2).width > ((IUploadConfig.UploadImageSize)localObject1).width) || (((IUploadConfig.UploadImageSize)localObject2).height > ((IUploadConfig.UploadImageSize)localObject1).height) || (j > ((IUploadConfig.UploadImageSize)localObject1).quality))) {
            break label595;
          }
          com.tencent.upload.a.b.f(localImageUploadTask);
          break;
        }
        label595:
        if (j < ((IUploadConfig.UploadImageSize)localObject1).quality) {
          ((IUploadConfig.UploadImageSize)localObject1).quality = j;
        }
        bool1 = Utility.isCompressToWebp(this.mConfig.getCompressToWebpFlag(), localImageUploadTask.iUploadType);
        localObject2 = this.mAbstractUploadTask.getUploadTaskType();
        label658:
        int k;
        int m;
        boolean bool2;
        if ((localObject2 != null) && (((IUploadTaskType)localObject2).getProtocolUploadType() == 0))
        {
          i = 1;
          localObject2 = com.tencent.upload.common.b.a(f.a(), localImageUploadTask.uploadFilePath, localImageUploadTask.md5, localImageUploadTask.flowId);
          str = localImageUploadTask.uploadFilePath;
          j = ((IUploadConfig.UploadImageSize)localObject1).width;
          k = ((IUploadConfig.UploadImageSize)localObject1).height;
          m = ((IUploadConfig.UploadImageSize)localObject1).quality;
          bool2 = localImageUploadTask.autoRotate;
          if ((!bool1) || (i == 0)) {
            break label769;
          }
        }
        label769:
        for (bool1 = true;; bool1 = false)
        {
          localObject1 = ImageProcessUtil.compressFile(str, (String)localObject2, j, k, m, bool2, bool1);
          if (localObject1 == null) {
            break label775;
          }
          localImageUploadTask.uploadFilePath = ((String)localObject1);
          break;
          i = 0;
          break label658;
        }
        label775:
        com.tencent.upload.a.b.f(localImageUploadTask);
      }
      label784:
      if (paramInt != 30500)
      {
        i = paramInt;
        if (paramInt != 30600) {}
      }
      else
      {
        i = 31600;
      }
    }
  }
  
  protected void processFileUploadFinishRsp(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject2 = null;
    ImageUploadTask localImageUploadTask = (ImageUploadTask)this.mAbstractUploadTask;
    Object localObject1 = localObject2;
    if (!localImageUploadTask.isHead)
    {
      localObject1 = localObject2;
      if (paramArrayOfByte != null)
      {
        localObject1 = localObject2;
        if (paramArrayOfByte.length > 0)
        {
          try
          {
            localObject1 = (UploadPicInfoRsp)com.tencent.upload.b.a.a.a(UploadPicInfoRsp.class.getSimpleName(), paramArrayOfByte);
            localObject2 = null;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localObject2 = Log.getStackTraceString(localException);
              com.tencent.upload.a.b.a("FlowWrapper", localException);
              localImageUploadResult = null;
            }
            com.tencent.upload.a.b.b("FlowWrapper", "UploadPicInfoRsp [sSURL=" + localImageUploadResult.sSURL + ", sBURL=" + localImageUploadResult.sBURL + ", sAlbumID=" + localImageUploadResult.sAlbumID + ", sPhotoID=" + localImageUploadResult.sPhotoID + ", sSloc=" + localImageUploadResult.sSloc + ", iWidth=" + localImageUploadResult.iWidth + ", iHeight=" + localImageUploadResult.iHeight + ", sOriUrl=" + localImageUploadResult.sOriUrl + ", iOriWidth=" + localImageUploadResult.iOriWidth + ", iOriHeight=" + localImageUploadResult.iOriHeight + ", sOriPhotoID=" + localImageUploadResult.sOriPhotoID + ", iPicType=" + localImageUploadResult.iPicType + " ...]");
          }
          if (localObject1 == null)
          {
            if (localObject2 != null) {
              break label410;
            }
            localObject2 = "processFileUploadFinishRsp() unpack UploadPicInfoRsp=null. " + paramArrayOfByte;
          }
        }
      }
    }
    label410:
    for (boolean bool = true;; bool = false)
    {
      cancelActionForException(500, 0, true, bool, (String)localObject2, null);
      return;
      localObject2 = localImageUploadResult;
      if (localImageUploadResult == null) {
        localObject2 = new UploadPicInfoRsp();
      }
      ImageUploadResult localImageUploadResult = new ImageUploadResult(localImageUploadTask.iUin, localImageUploadTask.flowId, localImageUploadTask.iBatchID, (UploadPicInfoRsp)localObject2);
      if (this.mUploadTaskCallback != null)
      {
        com.tencent.upload.a.b.b("FlowWrapper", "onUploadSucceed flowid = " + this.mAbstractUploadTask.flowId + " filepath = " + this.mAbstractUploadTask.uploadFilePath);
        this.mUploadTaskCallback.onUploadSucceed(this.mAbstractUploadTask, localImageUploadResult);
      }
      super.processFileUploadFinishRsp(paramArrayOfByte, localImageUploadTask.flowId);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\action\ImageUploadAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */