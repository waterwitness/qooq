package com.tencent.mobileqq.shortvideo.mediadevice;

import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.maxvideo.common.ControlFlagEnum;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.common.GloableValue;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder.HwFrame;
import com.tencent.mobileqq.shortvideo.tools.QzoneBaseThread;
import com.tencent.mobileqq.shortvideo.tools.QzoneHandlerThreadFactory;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class PreviewContext
{
  public static final boolean SG_SUPPORT_CALLBACK = true;
  private static final String TAG = "PreviewContext";
  static final boolean USE_USER_BUFFER = false;
  private static final int sCheckSizeLimt = 32;
  AVCodec mAVCodec;
  int mBlockIndex;
  List mCacheFrameNeedAdd;
  public CameraProxy mCamera;
  private boolean mCheckedDataValid;
  private boolean mDisablePrivilage;
  public AtomicReference mEncodeRef;
  ArrayList mFrameCountArray;
  private int mFrameIndex;
  private volatile boolean mFrameProcessEnd;
  List mFrameSrcList;
  private boolean mInitHwEncode;
  int mLastFrameIndex;
  public Handler mMsghandler;
  public boolean mPTVRealBeauty;
  private AVIOStruct mPTVRealBeautyCache;
  private int mRecordToCache;
  private long[] mTimeStamp;
  public AtomicInteger mVideoFrameProcess;
  public AtomicInteger mVideoFrameWrite;
  int mWriteFrameCount;
  private Object mlock;
  Object mlockFrame;
  public boolean notifyFirstFrame;
  
  public PreviewContext(CameraProxy paramCameraProxy, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mFrameSrcList = new ArrayList();
    this.mPTVRealBeautyCache = new AVIOStruct();
    this.mlockFrame = new Object();
    this.mCacheFrameNeedAdd = new ArrayList();
    this.mWriteFrameCount = 0;
    this.mAVCodec = null;
    this.mBlockIndex = 0;
    this.mLastFrameIndex = 0;
    this.mFrameCountArray = new ArrayList();
    this.mVideoFrameWrite = new AtomicInteger(0);
    this.mVideoFrameProcess = new AtomicInteger(0);
    this.mEncodeRef = new AtomicReference(null);
    this.mTimeStamp = new long[1];
    this.mlock = new Object();
    this.mAVCodec = RecordManager.a().a();
    this.mCamera = paramCameraProxy;
    paramCameraProxy.jdField_b_of_type_Int = paramInt1;
    paramCameraProxy.c = paramInt2;
    this.mInitHwEncode = initHwCallBackSecurity();
    this.mFrameProcessEnd = false;
    this.mVideoFrameWrite.getAndSet(0);
    this.mVideoFrameProcess.getAndSet(0);
    this.mCheckedDataValid = false;
    this.mDisablePrivilage = false;
  }
  
  public static boolean checkIsDisablePrivilage(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return true;
    }
    if (paramArrayOfByte.length < paramInt) {
      return true;
    }
    int j = 0;
    int i = 0;
    while (j < paramInt)
    {
      i += (paramArrayOfByte[j] & 0xFF);
      j += 1;
    }
    paramInt = paramArrayOfByte.length - paramInt;
    while (paramInt < paramArrayOfByte.length)
    {
      i += (paramArrayOfByte[paramInt] & 0xFF);
      paramInt += 1;
    }
    return i == 0;
  }
  
  private boolean checkPreviewDataLength(AVIOStruct paramAVIOStruct, byte[] paramArrayOfByte)
  {
    int i = paramAVIOStruct.vHeight;
    int j = paramAVIOStruct.vWidth;
    int k = paramAVIOStruct.vFormat;
    if (QLog.isColorLevel()) {
      QLog.d("PreviewContext", 2, "[@] checkPreviewDataLength,height = " + i + ",width = " + j + ",imgFmt = " + k + ",data.length = " + paramArrayOfByte.length + " Build.MODEL=" + Build.MODEL + " Build.CPU_ABI=" + Build.CPU_ABI);
    }
    switch (k)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("PreviewContext", 2, "[@] checkPreviewDataLength error 3,imgFmt  = " + k);
      }
      break;
    }
    do
    {
      do
      {
        return true;
        if (i * j * 2 == paramArrayOfByte.length) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("PreviewContext", 2, "[@] checkPreviewDataLength error 1 [Build.MODEL=" + Build.MODEL + "]");
      return true;
      if (i * j * 3 / 2 == paramArrayOfByte.length) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PreviewContext", 2, "[@] checkPreviewDataLength error 2 [Build.MODEL=" + Build.MODEL + "]");
    return true;
    return false;
  }
  
  private native int getProcessedFrameData(byte[] paramArrayOfByte, long[] paramArrayOfLong, int paramInt);
  
  private native boolean initHwCallBack();
  
  private boolean initHwCallBackSecurity()
  {
    try
    {
      boolean bool = initHwCallBack();
      return bool;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
    return false;
  }
  
  public void addUserBufferRecycle(byte[] paramArrayOfByte)
  {
    synchronized (this.mlockFrame)
    {
      if (!this.mCacheFrameNeedAdd.contains(paramArrayOfByte)) {
        this.mCacheFrameNeedAdd.add(paramArrayOfByte);
      }
      return;
    }
  }
  
  public void encodeOneFrameNotify()
  {
    SVHwEncoder localSVHwEncoder = (SVHwEncoder)this.mEncodeRef.get();
    if (localSVHwEncoder != null)
    {
      localHwFrame = localSVHwEncoder.a();
      if (localHwFrame == null) {
        if (QLog.isColorLevel()) {
          QLog.d("PreviewContext", 2, "[@] encodeOneFrameNotify frame is null");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      int i;
      do
      {
        SVHwEncoder.HwFrame localHwFrame;
        return;
        int j = localSVHwEncoder.G;
        try
        {
          i = getProcessedFrameData(localHwFrame.jdField_a_of_type_ArrayOfByte, this.mTimeStamp, j);
          if (QLog.isColorLevel()) {
            QLog.d("PreviewContext", 2, "[@] HandleVideo: error=" + i + " colorspace=" + j);
          }
          if (i == 0)
          {
            localHwFrame.jdField_a_of_type_Int = 0;
            localHwFrame.jdField_b_of_type_Int = localHwFrame.jdField_a_of_type_ArrayOfByte.length;
            localHwFrame.jdField_a_of_type_Long = this.mTimeStamp[0];
            localHwFrame.jdField_a_of_type_Boolean = false;
            localHwFrame.jdField_b_of_type_Boolean = true;
            localSVHwEncoder.a(localHwFrame, true);
            return;
          }
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          for (;;)
          {
            i = 64535;
          }
          this.mEncodeRef.getAndSet(null);
        }
      } while (!QLog.isColorLevel());
      QLog.d("PreviewContext", 2, "[@] HandleVideo: error=" + i + " set encode to null...");
      return;
    }
    QLog.d("PreviewContext", 2, "[@] HandleVideo: [encodeOneFrameNotify] encode=null");
  }
  
  public int getFrameIndex()
  {
    return this.mFrameIndex;
  }
  
  public void getPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PreviewContext", 2, "[@] onPreviewFrame start Build.MODEL=" + Build.MODEL + "Build.CPU_ABI=" + Build.CPU_ABI + "notifyFirstFrame=" + this.notifyFirstFrame);
    }
    if (!this.mCheckedDataValid) {
      if (CameraCompatibleList.a(CameraCompatibleList.p))
      {
        this.mDisablePrivilage = checkIsDisablePrivilage(paramArrayOfByte, 32);
        this.mCheckedDataValid = true;
        if (!this.mDisablePrivilage) {
          break label135;
        }
        this.mCamera.a.a(12, new Object[] { "camera disabled zero data." });
      }
    }
    while (this.mDisablePrivilage) {
      for (;;)
      {
        return;
        this.mDisablePrivilage = false;
      }
    }
    label135:
    if (paramArrayOfByte == null)
    {
      CameraControl.a().a(false);
      return;
    }
    this.mRecordToCache = 0;
    if (!this.mPTVRealBeauty) {
      sendFirstFrameMsg();
    }
    if (!this.mFrameSrcList.isEmpty()) {}
    for (paramCamera = (AVIOStruct)this.mFrameSrcList.get(this.mFrameSrcList.size() - 1);; paramCamera = null)
    {
      Object localObject;
      int i;
      if (paramCamera != null)
      {
        if (!Lock.jdField_a_of_type_Boolean) {
          break label467;
        }
        if (paramCamera.pControlFlag != ControlFlagEnum.NONE.getValue()) {
          break label441;
        }
        localObject = CameraControl.a().a();
        i = CameraControl.a().a();
        paramCamera.vWidth = ((CameraControl.CustomSize)localObject).jdField_a_of_type_Int;
        paramCamera.vHeight = ((CameraControl.CustomSize)localObject).jdField_b_of_type_Int;
        paramCamera.vFormat = i;
        paramCamera.vOrientation = CameraControl.a().b();
        paramCamera.vFPS = CodecParam.g;
        paramCamera.pControlFlag = ControlFlagEnum.OPEN_FILE_AND_WRITE_FRAME_DATA.getValue();
        paramCamera.vBitrate = CodecParam.f;
        paramCamera.pCodec = CodecParam.c;
      }
      for (;;)
      {
        if ((paramCamera != null) && (paramCamera.isWriteFrame()))
        {
          boolean bool = checkPreviewDataLength(paramCamera, paramArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("PreviewContext", 2, "[@] onPreviewFrame PreviewDataLength error : " + bool + " Build.MODEL=" + Build.MODEL + " Build.CPU_ABI=" + Build.CPU_ABI);
          }
          if (bool)
          {
            this.mCamera.a.a(8, new Object[] { "unacceptable camera preview data" });
            if (1 != FlowCameraMqqAction.jdField_a_of_type_Int) {
              break;
            }
            QzoneVideoBeaconReport.a(GloableValue.jdField_a_of_type_Long + "", "qzone_video_record", "8", null);
            return;
            label441:
            if (paramCamera.pControlFlag != ControlFlagEnum.OPEN_FILE_AND_WRITE_FRAME_DATA.getValue()) {
              continue;
            }
            paramCamera.pControlFlag = ControlFlagEnum.WRITE_FRAME_DATA.getValue();
            continue;
            label467:
            if (paramCamera.pControlFlag == ControlFlagEnum.WRITE_FRAME_DATA.getValue())
            {
              paramCamera.pControlFlag = ControlFlagEnum.WRITE_FRAME_DATA_AND_CLOSE_FILE.getValue();
              continue;
            }
            if (paramCamera.pControlFlag != ControlFlagEnum.WRITE_FRAME_DATA_AND_CLOSE_FILE.getValue()) {
              continue;
            }
            paramCamera.pControlFlag = ControlFlagEnum.NONE.getValue();
            continue;
          }
          i = this.mFrameIndex;
          this.mFrameIndex = (i + 1);
          paramCamera.pFrameIndex = i;
          paramCamera.vFrameTime = SystemClock.elapsedRealtime();
          this.mWriteFrameCount += 1;
          this.mRecordToCache = 1;
          if (!this.mPTVRealBeauty)
          {
            this.mVideoFrameWrite.incrementAndGet();
            this.mAVCodec.copyQQBuf(paramArrayOfByte, paramCamera);
            QzoneHandlerThreadFactory.a("Normal_HandlerThread", false).a(new PreviewContext.HandleVideo(this));
          }
        }
      }
      if (this.mPTVRealBeauty)
      {
        localObject = Message.obtain(this.mMsghandler);
        ((Message)localObject).what = -16716526;
        ((Message)localObject).arg1 = this.mRecordToCache;
        ((Message)localObject).arg2 = 0;
        ((Message)localObject).obj = paramArrayOfByte;
        if (this.mRecordToCache == 1)
        {
          PreviewContext.VFrameData localVFrameData = new PreviewContext.VFrameData();
          localVFrameData.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
          localVFrameData.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct = ((AVIOStruct)paramCamera.clone());
          ((Message)localObject).obj = localVFrameData;
          label685:
          if (this.mMsghandler != null) {
            this.mMsghandler.sendMessage((Message)localObject);
          }
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label883;
        }
        QLog.d("PreviewContext", 2, "[@] onPreviewFrame end,mFrameIndex  = " + this.mFrameIndex);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("PreviewContext", 2, "[@] mPTVRealBeauty: [Build.MODEL=" + Build.MODEL + "]" + "  mMsghandler=" + this.mMsghandler);
        }
        paramCamera = CameraControl.a().a();
        if (paramCamera == null) {
          break;
        }
        i = CameraControl.a().a();
        this.mPTVRealBeautyCache.vWidth = paramCamera.jdField_a_of_type_Int;
        this.mPTVRealBeautyCache.vHeight = paramCamera.jdField_b_of_type_Int;
        this.mPTVRealBeautyCache.vFormat = i;
        if (!checkPreviewDataLength(this.mPTVRealBeautyCache, paramArrayOfByte)) {
          break label685;
        }
        this.mCamera.a.a(8, new Object[] { "unacceptable camera preview data" });
        return;
        CameraControl.a().a(false, paramArrayOfByte);
      }
      label883:
      break;
    }
  }
  
  public int getRemainedRecordFrames(int paramInt)
  {
    if (paramInt >= this.mFrameCountArray.size()) {
      return 0;
    }
    int j = this.mFrameIndex;
    int i = 0;
    while (i < paramInt)
    {
      j -= ((Integer)this.mFrameCountArray.get(this.mFrameCountArray.size() - (i + 1))).intValue();
      i += 1;
    }
    return j;
  }
  
  public int getSegmentCount()
  {
    if (this.mFrameSrcList != null) {
      return this.mFrameSrcList.size();
    }
    return 0;
  }
  
  public void lockFrameSync()
  {
    if (!this.mFrameProcessEnd)
    {
      synchronized (this.mlock)
      {
        boolean bool = this.mFrameProcessEnd;
        if (bool) {}
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreviewContext", 2, "lockFrameSync start wait");
        }
        this.mlock.wait(2000L);
        if (QLog.isColorLevel()) {
          QLog.d("PreviewContext", 2, "lockFrameSync wait finish");
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;) {}
      }
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public void removeLatestVideo()
  {
    if ((this.mFrameSrcList != null) && (this.mFrameSrcList.size() > 0)) {
      this.mFrameSrcList.remove(this.mFrameSrcList.size() - 1);
    }
    if (this.mFrameCountArray.size() > 0)
    {
      this.mFrameIndex -= ((Integer)this.mFrameCountArray.get(this.mFrameCountArray.size() - 1)).intValue();
      if (this.mFrameIndex <= 0) {
        this.mFrameIndex = 0;
      }
      this.mFrameCountArray.remove(this.mFrameCountArray.size() - 1);
      if (this.mFrameCountArray.size() == 0)
      {
        this.mFrameIndex = 0;
        this.mFrameSrcList.clear();
      }
    }
  }
  
  public void reset()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreviewContext", 2, "[@] reset");
    }
    if (this.mFrameSrcList != null) {
      this.mFrameSrcList.clear();
    }
    this.mFrameCountArray.clear();
    this.mBlockIndex = 0;
    this.mLastFrameIndex = 0;
    this.mWriteFrameCount = 0;
    this.mFrameIndex = 0;
  }
  
  public void sendFirstFrameMsg()
  {
    if (this.notifyFirstFrame)
    {
      this.mCamera.a.a(10, new Object[] { "getted" });
      this.notifyFirstFrame = false;
    }
  }
  
  public void setFrameIndex(int paramInt)
  {
    this.mFrameIndex = paramInt;
  }
  
  public void startCapture()
  {
    if (!Lock.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.mFrameSrcList == null) {
      this.mFrameSrcList = new ArrayList();
    }
    AVIOStruct localAVIOStruct = new AVIOStruct();
    int i = this.mBlockIndex;
    this.mBlockIndex = (i + 1);
    localAVIOStruct.pBlockIndex = i;
    this.mFrameSrcList.add(localAVIOStruct);
    this.mLastFrameIndex = this.mFrameIndex;
  }
  
  public void stopCapture()
  {
    this.mFrameCountArray.add(Integer.valueOf(this.mFrameIndex - this.mLastFrameIndex));
  }
  
  public void unlockFrameSync()
  {
    synchronized (this.mlock)
    {
      this.mFrameProcessEnd = true;
      this.mlock.notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("PreviewContext", 2, "unlockFrameSync notifyAll");
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\mediadevice\PreviewContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */