package com.tencent.upload.a;

import FileUpload.FileUploadControlReq;
import FileUpload.FileUploadControlRsp;
import FileUpload.FileUploadProgressRsp;
import FileUpload.SvcRequestHead;
import FileUpload.SvcResponsePacket;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.f;
import com.tencent.upload.network.b.m;
import com.tencent.upload.network.base.ConnectionImpl;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.AbstractUploadTask.IProgressDelegate;
import com.tencent.upload.uinterface.IUploadAction;
import com.tencent.upload.uinterface.IUploadAction.SessionError;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadReport;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.IUploadTaskType;
import com.tencent.upload.uinterface.Report;
import com.tencent.upload.uinterface.data.ImageUploadTask;
import java.io.File;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class d
  implements IUploadAction
{
  public static final String REPORT_MSG_DIVIDER = " || ";
  protected static final int STATE_CANCEL = 50;
  protected static final int STATE_INIT = 0;
  protected static final int STATE_RECEIVE_UPLOAD_SUCCESS = 40;
  protected static final int STATE_SEND_CONTROL = 10;
  protected static final int STATE_SEND_FILE = 30;
  protected static final int STATE_SEND_OVER_INDEED = 35;
  protected static final int STATE_SEND_PART_FILE = 20;
  protected static volatile Map<String, String> reportSession = new HashMap();
  private static Set<String> s = new HashSet();
  protected static final String tag = "FlowWrapper";
  private WeakReference<com.tencent.upload.network.b.b> a;
  private long b;
  private long c;
  private long d;
  private int e;
  private int f;
  private boolean g = false;
  private long h = 0L;
  private long i = 0L;
  private long j = 0L;
  private long k = 0L;
  private long l = 0L;
  private long m = 0L;
  protected AbstractUploadTask mAbstractUploadTask;
  protected String mClientIp;
  protected IUploadConfig mConfig;
  protected String mConnectedIp;
  protected int mRetryControlCount = 0;
  protected int mRetryPartFileCount = 0;
  protected volatile int mState;
  protected SvcRequestHead mSvcRequestHead;
  protected byte[] mUploadFileInfoReqBytes;
  protected IUploadTaskCallback mUploadTaskCallback;
  private long n = 0L;
  private int o = 0;
  private m p;
  private String q;
  private int r;
  
  public d(AbstractUploadTask paramAbstractUploadTask)
  {
    this.mUploadTaskCallback = paramAbstractUploadTask.uploadTaskCallback;
    this.mAbstractUploadTask = paramAbstractUploadTask;
    this.mConfig = f.b();
  }
  
  private String a()
  {
    Object localObject1 = new StringBuilder();
    if (this.p != null)
    {
      if (com.tencent.upload.common.d.b(this.p.b())) {
        break label117;
      }
      ((StringBuilder)localObject1).append(this.mConnectedIp);
    }
    for (;;)
    {
      localObject2 = reportSession;
      if (localObject2 == null) {
        break;
      }
      Iterator localIterator = ((Map)localObject2).keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((StringBuilder)localObject1).append("&");
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append("=");
        ((StringBuilder)localObject1).append((String)((Map)localObject2).get(str));
      }
      label117:
      ((StringBuilder)localObject1).append(this.p.b());
    }
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = localObject2;
    if (((String)localObject2).length() == 0) {
      localObject1 = "ip is null";
    }
    return (String)localObject1;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    WeakReference localWeakReference = this.a;
    if (localWeakReference == null) {}
    String str;
    do
    {
      return;
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "cancelTaskInner";
      }
      paramString = (com.tencent.upload.network.b.b)localWeakReference.get();
    } while (paramString == null);
    paramString.a(paramInt1, paramInt2);
    b.b("FlowWrapper", str + " cancel flowId=" + paramInt1);
  }
  
  private void a(com.tencent.upload.network.c.a parama)
  {
    com.tencent.upload.network.a.d locald = getBodyRequest();
    if (locald == null) {
      return;
    }
    if (parama.a(locald))
    {
      if (this.g) {}
      for (int i1 = 20;; i1 = 30)
      {
        this.mState = i1;
        b.b("FlowWrapper", "sendFilePkg() " + locald.toString());
        return;
      }
    }
    cancelActionForException(504, 0, true, true, "sendFilePkg() session send fail", null);
  }
  
  private void a(com.tencent.upload.network.c.a parama, FileUploadControlRsp paramFileUploadControlRsp)
  {
    int i1 = 1;
    b.b("FlowWrapper", "FileUploadControlRsp [iOffset=" + paramFileUploadControlRsp.a + ", iRetCode=" + paramFileUploadControlRsp.b + ", iServerTime=" + paramFileUploadControlRsp.c + "]");
    this.l = 0L;
    this.k = 0L;
    if (paramFileUploadControlRsp.a < 0L)
    {
      cancelActionForException(501, 0, true, true, "processFileUploadControlRsp fileUploadControlRsp.iOffset:" + paramFileUploadControlRsp.a, "文件不存在");
      return;
    }
    this.i = paramFileUploadControlRsp.a;
    this.j = paramFileUploadControlRsp.a;
    if (this.mUploadTaskCallback != null)
    {
      this.mUploadTaskCallback.onUploadStateChange(this.mAbstractUploadTask, 1);
      b.a("FlowWrapper", "onUploadStateChange=1");
    }
    a(parama);
    if (this.g)
    {
      int i2 = UploadConfiguration.getVideoPartConcurrentCount();
      while (i1 < i2)
      {
        b.b("FlowWrapper", "多线程分片 i=" + i1 + " mFileLength=" + this.f + " mSendFileOffset=" + this.l + " mSendFileLen=" + this.k);
        if (this.l + this.k < this.f)
        {
          this.i += this.h;
          a(parama);
        }
        i1 += 1;
      }
    }
    this.b = System.currentTimeMillis();
  }
  
  protected static final void printSvcRequestHead(SvcRequestHead paramSvcRequestHead)
  {
    b.b("FlowWrapper", "SvcRequestHead [iVersionId=" + paramSvcRequestHead.a + ", iUin=" + paramSvcRequestHead.b + ", sRefer=" + paramSvcRequestHead.c + ", iLoginType=" + paramSvcRequestHead.d + ", iUploadType=" + paramSvcRequestHead.f + ", iCmdID=" + paramSvcRequestHead.g + ", iFileLen=" + paramSvcRequestHead.j + ", iOffset=" + paramSvcRequestHead.k + ", iNetType=" + paramSvcRequestHead.l + ", sOperator=" + paramSvcRequestHead.m + ", iSync=" + paramSvcRequestHead.n + ", iSource=" + paramSvcRequestHead.o + ", iFileType=" + paramSvcRequestHead.p + ", iDescLen=" + paramSvcRequestHead.r + ", sQua=" + paramSvcRequestHead.s + ", iPartDataLen=" + paramSvcRequestHead.u + ", md5type=" + paramSvcRequestHead.v + ", md5filelen=" + paramSvcRequestHead.w + ", noRspProcess=" + paramSvcRequestHead.x + ", seq=" + paramSvcRequestHead.y + ", httpRspProcess=" + paramSvcRequestHead.z + ", uintype=" + paramSvcRequestHead.A + ", preupload=" + paramSvcRequestHead.B + "]");
    if ((paramSvcRequestHead.e == null) || (paramSvcRequestHead.e.length == 0)) {
      b.d("FlowWrapper", "svcRequestHead.vLoginData is null or length=0");
    }
    if ((paramSvcRequestHead.q == null) || (paramSvcRequestHead.q.length == 0)) {
      b.d("FlowWrapper", "svcRequestHead.vLoginKey is null or length=0");
    }
  }
  
  protected static final void printSvcResponsePacket(SvcResponsePacket paramSvcResponsePacket)
  {
    b.b("FlowWrapper", "SvcResponsePacket [iRetCode=" + paramSvcResponsePacket.a + ", iRetSubCode=" + paramSvcResponsePacket.b + ", sResultDes=" + paramSvcResponsePacket.c + ", iUploadType=" + paramSvcResponsePacket.d + ", iCmdID=" + paramSvcResponsePacket.e + ", seq=" + paramSvcResponsePacket.g + ", iUin=" + paramSvcResponsePacket.h + "]");
  }
  
  protected final void cancelActionForException(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    int i2 = 1;
    int i1 = paramInt1;
    if (!ConnectionImpl.isLibraryPrepared())
    {
      paramString2 = "库加载失败，请尝试退出程序重启或重新安装";
      i1 = -70;
      paramString1 = "库加载失败，请尝试退出程序重启或重新安装";
    }
    b.b("FlowWrapper", "cancelActionForException() flowId=" + this.mAbstractUploadTask.flowId + " errorCode=" + i1 + " errorMsg=" + paramString1 + " errorSubCode=" + paramInt2 + " path=" + this.mAbstractUploadTask.uploadFilePath);
    this.mState = 50;
    String str1;
    if (paramString2 != null)
    {
      str1 = paramString2;
      if (paramString2.length() != 0) {}
    }
    else
    {
      str1 = "上传错误";
    }
    String str2 = paramString1;
    if (ConnectionImpl.isLibraryPrepared()) {
      if ((paramBoolean1) && (this.mAbstractUploadTask.preupload != 1))
      {
        paramString2 = paramString1;
        if (paramBoolean2) {
          paramString2 = Log.getStackTraceString(new Exception(paramString1));
        }
        str2 = paramString2;
        if (paramInt2 != 0) {
          report(paramInt2, paramString2, this.mAbstractUploadTask);
        }
      }
      else
      {
        if (this.mUploadTaskCallback == null) {
          break label290;
        }
        if (-7 != i1)
        {
          paramInt1 = i2;
          if (61536 == i1)
          {
            paramInt1 = i2;
            if (paramInt2 != 65136) {}
          }
        }
        else
        {
          paramInt1 = 2;
        }
        this.mUploadTaskCallback.onUploadError(this.mAbstractUploadTask, i1, str1);
        b.b("FlowWrapper", "onUploadError");
      }
    }
    for (;;)
    {
      a(this.mAbstractUploadTask.flowId, paramInt1, "cancelActionForException()");
      return;
      report(i1, str2, this.mAbstractUploadTask);
      break;
      label290:
      paramInt1 = 64536;
    }
  }
  
  protected final SvcRequestHead createSvcRequestHead(AbstractUploadTask paramAbstractUploadTask)
  {
    SvcRequestHead localSvcRequestHead = new SvcRequestHead();
    localSvcRequestHead.a = 1;
    localSvcRequestHead.b = paramAbstractUploadTask.iUin;
    if (paramAbstractUploadTask.sRefer == null)
    {
      localObject = "";
      localSvcRequestHead.c = ((String)localObject);
      localSvcRequestHead.d = paramAbstractUploadTask.iLoginType;
      if (paramAbstractUploadTask.vLoginData != null) {
        break label444;
      }
      localObject = new byte[0];
      label56:
      localSvcRequestHead.e = ((byte[])localObject);
      localSvcRequestHead.q = paramAbstractUploadTask.vLoginKey;
      localSvcRequestHead.B = paramAbstractUploadTask.preupload;
      localObject = paramAbstractUploadTask.getUploadTaskType();
      localSvcRequestHead.f = ((IUploadTaskType)localObject).getProtocolUploadType();
      localSvcRequestHead.p = ((IUploadTaskType)localObject).getProtocolFileType();
      localSvcRequestHead.g = 0;
      if (TextUtils.isEmpty(paramAbstractUploadTask.uploadFilePath)) {
        break label491;
      }
    }
    label248:
    label289:
    label444:
    label464:
    label477:
    label491:
    for (Object localObject = new File(paramAbstractUploadTask.uploadFilePath);; localObject = null)
    {
      if (localObject != null) {
        this.f = ((int)((File)localObject).length());
      }
      if ((localObject != null) && (this.f == 0)) {
        b.d("FlowWrapper", "createSvcRequestHead() mFileLength==0");
      }
      com.tencent.upload.common.a locala = getMd5$774aca96((File)localObject);
      localObject = locala.b();
      paramAbstractUploadTask.sFileMD5 = ((String)localObject);
      String str = b.a(this.mAbstractUploadTask, this.mUploadFileInfoReqBytes);
      paramAbstractUploadTask.sDescMD5 = str;
      localSvcRequestHead.v = locala.a();
      localSvcRequestHead.w = this.f;
      localSvcRequestHead.h = ((String)localObject);
      localSvcRequestHead.i = str;
      if (this.mUploadFileInfoReqBytes != null)
      {
        localSvcRequestHead.j = (this.mUploadFileInfoReqBytes.length + this.f);
        localSvcRequestHead.k = 0L;
        localSvcRequestHead.l = UploadConfiguration.getCurrentNetworkCategory();
        localSvcRequestHead.m = UploadConfiguration.getProviderName();
        localSvcRequestHead.n = paramAbstractUploadTask.iSync;
        localSvcRequestHead.o = 1;
        if (this.mConfig != null) {
          break label464;
        }
        localObject = null;
        localSvcRequestHead.s = ((String)localObject);
        if (this.mConfig != null) {
          localSvcRequestHead.t = this.mConfig.getDeviceInfo();
        }
        localSvcRequestHead.u = 0L;
        localSvcRequestHead.y = String.valueOf(this.mAbstractUploadTask.flowId);
        if (this.mConfig != null) {
          break label477;
        }
      }
      for (int i1 = 0;; i1 = this.mConfig.getAppId())
      {
        localSvcRequestHead.C = i1;
        localSvcRequestHead.D = reportSession;
        b.b("FlowWrapper", "UploadActionFlowWrapper createSvcRequestHead flowid = " + localSvcRequestHead.y + " descMd5 = " + localSvcRequestHead.i + " fileMd5 = " + localSvcRequestHead.h + " type = " + locala.a() + " path = " + paramAbstractUploadTask.uploadFilePath);
        return localSvcRequestHead;
        localObject = paramAbstractUploadTask.sRefer;
        break;
        localObject = paramAbstractUploadTask.vLoginData;
        break label56;
        localSvcRequestHead.j = this.f;
        break label248;
        localObject = this.mConfig.getQUA3();
        break label289;
      }
    }
  }
  
  public int getActionSequence()
  {
    return this.mAbstractUploadTask.flowId;
  }
  
  protected com.tencent.upload.network.a.d getBodyRequest()
  {
    Object localObject2 = null;
    if (!TextUtils.isEmpty(this.mAbstractUploadTask.uploadFilePath)) {
      localObject2 = new File(this.mAbstractUploadTask.uploadFilePath);
    }
    if ((localObject2 == null) || (this.f == 0))
    {
      cancelActionForException(-7, 0, true, true, "getBodyRequest() file !exist or length=0. path=" + this.mAbstractUploadTask.uploadFilePath, "文件不存在");
      return null;
    }
    int i3 = com.tencent.upload.b.a.a.a();
    this.mSvcRequestHead.g = 1;
    this.mSvcRequestHead.k = this.i;
    int i1;
    int i2;
    int i4;
    if (this.mUploadFileInfoReqBytes != null)
    {
      i1 = this.mUploadFileInfoReqBytes.length;
      this.e = i1;
      this.mSvcRequestHead.j = (this.e + this.f - this.i);
      this.mSvcRequestHead.r = this.e;
      this.mSvcRequestHead.u = 0L;
      this.mSvcRequestHead.y = com.tencent.upload.b.a.a.a(this.mAbstractUploadTask.flowId, i3);
      i2 = 0;
      i1 = 0;
      i4 = UploadConfiguration.getVideoPartSizeByNetworkSetting();
      if (this.e <= this.i) {
        break label321;
      }
      i1 = (int)this.i;
      i2 = this.e - i1;
      this.l = 0L;
      if (!this.g) {
        break label309;
      }
      this.h = Math.min(i4, this.mSvcRequestHead.j);
      this.k = (this.h - (this.e - this.i));
    }
    for (;;)
    {
      if (!this.g) {
        break label387;
      }
      this.mSvcRequestHead.u = this.h;
      if (this.l != this.f) {
        break label387;
      }
      return null;
      i1 = 0;
      break;
      label309:
      this.k = this.f;
      continue;
      label321:
      this.l = (this.i - this.e);
      if (this.g)
      {
        this.h = Math.min(i4, this.mSvcRequestHead.j);
        this.k = this.h;
      }
      else
      {
        this.k = (this.f - this.l);
      }
    }
    label387:
    if ((this.l < 0L) || (this.l >= this.f))
    {
      cancelActionForException(501, 0, true, true, "not valid: mSendFileOffset=" + this.l + " mFileLength=" + this.f, null);
      return null;
    }
    if ((this.k <= 0L) || (this.l + this.k > this.f))
    {
      cancelActionForException(501, 0, true, true, "not valid: mSendFileLen=" + this.k + " mSendFileOffset=" + this.l + " mFileLength=" + this.f, null);
      return null;
    }
    hookSvcRequestHead();
    printSvcRequestHead(this.mSvcRequestHead);
    Object localObject1 = null;
    try
    {
      byte[] arrayOfByte1 = com.tencent.upload.b.a.a.a(this.mSvcRequestHead.getClass().getSimpleName(), this.mSvcRequestHead);
      if (arrayOfByte1 == null)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "getBodyRequest() pack SvcRequestHead=null. " + this.mSvcRequestHead;
        }
        b.e("FlowWrapper", (String)localObject2);
        cancelActionForException(499, 0, true, true, (String)localObject2, null);
        return null;
      }
    }
    catch (Exception localException)
    {
      byte[] arrayOfByte2;
      for (;;)
      {
        localObject1 = Log.getStackTraceString(localException);
        b.a("FlowWrapper", localException);
        arrayOfByte2 = null;
      }
      localObject1 = ByteBuffer.allocate(arrayOfByte2.length + i2);
      ((ByteBuffer)localObject1).put(arrayOfByte2);
      if (this.mUploadFileInfoReqBytes != null) {
        ((ByteBuffer)localObject1).put(this.mUploadFileInfoReqBytes, i1, i2);
      }
      b.a("FlowWrapper", "getBodyRequest() mSendDescFileOffset=" + this.i + " descOffset=" + i1 + " descBufferSize=" + i2 + " mSendFileOffset=" + this.l + " mSendFileLen=" + this.k + " mFileLength=" + this.f + " mSendDescFileLen=" + this.h + " mDescLength=" + this.e + " headLength=" + arrayOfByte2.length);
    }
    return new e(((ByteBuffer)localObject1).array(), (File)localObject2, this.g, (int)this.l, (int)this.k, this.mAbstractUploadTask.flowId, this.mSvcRequestHead.g, i3);
  }
  
  protected com.tencent.upload.network.a.d getControlRequest()
  {
    arrayOfByte3 = getFileUploadControlReq();
    localObject = this.mSvcRequestHead;
    if (arrayOfByte3 != null) {}
    for (i1 = arrayOfByte3.length;; i1 = 0)
    {
      ((SvcRequestHead)localObject).r = i1;
      i2 = com.tencent.upload.b.a.a.a();
      this.mSvcRequestHead.y = com.tencent.upload.b.a.a.a(this.mAbstractUploadTask.flowId, i2);
      hookSvcRequestHead();
      try
      {
        arrayOfByte1 = com.tencent.upload.b.a.a.a(this.mSvcRequestHead.getClass().getSimpleName(), this.mSvcRequestHead);
        localObject = null;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          byte[] arrayOfByte1;
          localObject = Log.getStackTraceString(localException);
          b.a("FlowWrapper", localException);
          byte[] arrayOfByte2 = null;
          continue;
          if (arrayOfByte3 != null) {}
          for (i1 = arrayOfByte2.length + arrayOfByte3.length;; i1 = arrayOfByte2.length)
          {
            localObject = ByteBuffer.allocate(i1);
            ((ByteBuffer)localObject).put(arrayOfByte2);
            if (arrayOfByte3 != null) {
              ((ByteBuffer)localObject).put(arrayOfByte3);
            }
            return new e(((ByteBuffer)localObject).array(), null, this.g, 0, 0, this.mAbstractUploadTask.flowId, 0, i2);
          }
        }
      }
      printSvcRequestHead(this.mSvcRequestHead);
      if (arrayOfByte1 != null) {
        break;
      }
      if (localObject != null) {
        break label214;
      }
      localObject = "getControlRequest() pack SvcRequestHead=null. " + this.mSvcRequestHead;
      cancelActionForException(499, 0, true, true, (String)localObject, null);
      return null;
    }
  }
  
  protected byte[] getControlRequestData()
  {
    return new byte[0];
  }
  
  protected byte[] getFileUploadControlReq()
  {
    FileUploadControlReq localFileUploadControlReq = new FileUploadControlReq();
    localFileUploadControlReq.a = getControlRequestData();
    try
    {
      localObject = com.tencent.upload.b.a.a.a(localFileUploadControlReq.getClass().getSimpleName(), localFileUploadControlReq);
      str = null;
    }
    catch (Exception localException)
    {
      byte[] arrayOfByte;
      for (;;)
      {
        Object localObject;
        String str = Log.getStackTraceString(localException);
        b.a("FlowWrapper", localException);
        arrayOfByte = null;
      }
      return arrayOfByte;
    }
    if (localObject == null)
    {
      localObject = str;
      if (str == null) {
        localObject = "getControlRequest() pack fileUploadControlReq=null. " + localFileUploadControlReq;
      }
      cancelActionForException(499, 0, true, true, (String)localObject, null);
      return null;
    }
  }
  
  protected com.tencent.upload.common.a getMd5$774aca96(File paramFile)
  {
    return com.tencent.upload.common.b.b(paramFile);
  }
  
  public int getSendState()
  {
    switch (this.mState)
    {
    default: 
      b.e("FlowWrapper", "getSendState() state error");
    case 40: 
    case 50: 
      return 3;
    case 0: 
      return 0;
    case 10: 
    case 20: 
    case 30: 
      return 1;
    }
    return 2;
  }
  
  public final int getServerCategory()
  {
    return this.mAbstractUploadTask.getUploadTaskType().getServerCategory();
  }
  
  protected void hookSvcRequestHead() {}
  
  public void onCancel(int paramInt)
  {
    int i1 = 2;
    boolean bool2 = true;
    b.c("FlowWrapper", "onCancel() actionId=" + this.mAbstractUploadTask.flowId + " mState=" + this.mState + "cancelState:" + paramInt);
    switch (paramInt)
    {
    default: 
      i1 = 64536;
    case 1: 
    case 4: 
      if ((i1 != 64536) && (this.mUploadTaskCallback != null))
      {
        this.mUploadTaskCallback.onUploadStateChange(this.mAbstractUploadTask, i1);
        b.b("FlowWrapper", "onUploadStateChange=" + i1);
      }
      if (paramInt == 3)
      {
        String str = "user cancel task, RetryControlCount:" + this.mRetryControlCount + " RetryPartFileCount:" + this.mRetryPartFileCount;
        if ((this.mAbstractUploadTask.preupload != 1) && (getSendState() != 0))
        {
          b.c("FlowWrapper", "report -20," + str);
          report(-20, str, this.mAbstractUploadTask);
        }
      }
      this.mState = 50;
      bool1 = bool2;
      if (paramInt != 0) {
        if (paramInt != 3) {
          break label283;
        }
      }
      break;
    }
    label283:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      onDestroy(bool1);
      return;
      i1 = 64536;
      break;
      i1 = 5;
      break;
      i1 = 5;
      break;
    }
  }
  
  public void onConnecting()
  {
    this.mUploadTaskCallback.onUploadStateChange(this.mAbstractUploadTask, 4);
    b.a("FlowWrapper", "onUploadStateChange=4");
  }
  
  protected void onDestroy(boolean paramBoolean) {}
  
  public void onError(com.tencent.upload.network.c.a parama, int paramInt, String paramString, boolean paramBoolean)
  {
    parama = null;
    int i1;
    label95:
    boolean bool;
    switch (paramInt)
    {
    default: 
      i1 = paramInt;
      bool = IUploadAction.SessionError.isRetryable(paramInt);
      paramString = "onError() actionId=" + this.mAbstractUploadTask.flowId + " isRetryable=" + bool + " sessionError=" + paramInt + " description=" + paramString + " causedByNoNetwork:" + paramBoolean;
      if (!paramBoolean) {
        break;
      }
    }
    for (paramInt = 35000;; paramInt = i1)
    {
      if ((paramInt == 35000) && (this.mRetryControlCount > 0)) {
        this.mRetryControlCount -= 1;
      }
      if (this.mAbstractUploadTask.preupload == 1)
      {
        i1 = 1;
        label214:
        if ((!paramBoolean) && (i1 != 0)) {
          break label391;
        }
        paramBoolean = true;
        label227:
        if ((this.mRetryControlCount <= UploadConfiguration.getVideoFileRetryCount()) && (bool) && (i1 == 0)) {
          break label397;
        }
        b.b("FlowWrapper", "onError cancel flowid = " + this.mAbstractUploadTask.flowId);
        cancelActionForException(paramInt, 0, paramBoolean, true, paramString, parama);
      }
      label391:
      label397:
      while (!paramBoolean)
      {
        return;
        i1 = -18;
        parama = "连接服务器失败";
        break label95;
        i1 = -7;
        parama = "文件不存在.";
        break label95;
        i1 = -15;
        parama = "读取本地数据异常";
        break label95;
        i1 = -8;
        parama = "解析服务器回应数据失败";
        break label95;
        i1 = -4;
        parama = "服务器回应数据超时";
        break label95;
        i1 = -60;
        parama = "服务器断开";
        break label95;
        parama = "发送数据超时";
        i1 = -11;
        break label95;
        parama = "网络不可用";
        break;
        parama = "上传压缩文件不存在";
        break;
        parama = "上传文件被删除或不存在";
        break;
        i1 = 0;
        break label214;
        paramBoolean = false;
        break label227;
      }
      b.b("FlowWrapper", "onError report flowid = " + this.mAbstractUploadTask.flowId);
      report(paramInt, paramString, this.mAbstractUploadTask);
      return;
    }
  }
  
  public void onRequest(com.tencent.upload.network.c.a parama, com.tencent.upload.network.a.d paramd)
  {
    b.b("FlowWrapper", "onRequest() actionId=" + paramd.f() + " commandId=" + paramd.g());
    if ((30 == this.mState) && (paramd.g() == 1)) {
      this.mState = 35;
    }
  }
  
  public void onResponse(com.tencent.upload.network.c.a parama, com.tencent.upload.network.a.a parama1)
  {
    b.a("FlowWrapper", "onResponse() actionId=" + this.mAbstractUploadTask.flowId + " mState=" + this.mState);
    if ((parama == null) || (parama1 == null))
    {
      cancelActionForException(503, 0, false, true, "onResponse() null param. state=" + this.mState, null);
      return;
    }
    if ((this.mState == 40) || (this.mState == 50) || (this.mState == 0))
    {
      cancelActionForException(503, 0, false, true, "onResponse() error state=" + this.mState, null);
      return;
    }
    Object localObject = parama1.a();
    if (localObject == null)
    {
      cancelActionForException(500, 0, true, true, "SvcResponsePacket==null", null);
      return;
    }
    if (((SvcResponsePacket)localObject).a < 0) {
      b.b("FlowWrapper", "ret: " + ((SvcResponsePacket)localObject).a + " " + ((SvcResponsePacket)localObject).b + " des:" + ((SvcResponsePacket)localObject).c + " flow:" + ((SvcResponsePacket)localObject).g + " desMd5:" + ((SvcResponsePacket)localObject).j + " fileMd5:" + ((SvcResponsePacket)localObject).i);
    }
    if (((SvcResponsePacket)localObject).a == 0)
    {
      processSvcResponsePacket(parama, (SvcResponsePacket)localObject);
      return;
    }
    if ((((SvcResponsePacket)localObject).b != 65231) && ((((SvcResponsePacket)localObject).a == 62536) || ((((SvcResponsePacket)localObject).b <= 65236) && (((SvcResponsePacket)localObject).b >= 65137))))
    {
      int i2 = ((SvcResponsePacket)localObject).b;
      parama1 = "iRetSubCode=" + ((SvcResponsePacket)localObject).b + " sResultDes=" + ((SvcResponsePacket)localObject).c;
      localObject = ((SvcResponsePacket)localObject).c;
      b.b("FlowWrapper", String.format("reSend() mState=%d mRetryPartFileCount=%d mRetryControlCount=%d", new Object[] { Integer.valueOf(this.mState), Integer.valueOf(this.mRetryPartFileCount), Integer.valueOf(this.mRetryControlCount) }));
      int i1;
      if (this.mAbstractUploadTask.preupload == 1)
      {
        i1 = 1;
        if (this.g) {
          switch (this.mState)
          {
          }
        }
      }
      for (;;)
      {
        if ((this.mRetryControlCount <= UploadConfiguration.getVideoFileRetryCount()) && (this.o < UploadConfiguration.getResendCount()) && (i1 == 0))
        {
          sendFirstPkg(parama);
          this.mRetryControlCount += 1;
          this.o += 1;
          return;
          i1 = 0;
          break;
          if ((this.mRetryPartFileCount <= this.mConfig.getVideoPartRetryCount()) && (i1 == 0))
          {
            a(parama);
            this.mRetryPartFileCount += 1;
            return;
          }
        }
      }
      cancelActionForException(i2, 0, true, true, parama1, (String)localObject);
      return;
    }
    if (((SvcResponsePacket)localObject).b == 65231) {
      b.g(this.mAbstractUploadTask);
    }
    if (((SvcResponsePacket)localObject).a == 64536) {
      switch (((SvcResponsePacket)localObject).b)
      {
      }
    }
    for (boolean bool = true;; bool = false)
    {
      cancelActionForException(((SvcResponsePacket)localObject).a, ((SvcResponsePacket)localObject).b, bool, true, "iRetSubCode=" + ((SvcResponsePacket)localObject).b + " sResultDes=" + ((SvcResponsePacket)localObject).c, ((SvcResponsePacket)localObject).c);
      return;
    }
  }
  
  public boolean onSend(com.tencent.upload.network.c.a parama)
  {
    if (parama == null)
    {
      b.e("FlowWrapper", "onSend() session==null");
      return false;
    }
    b.c("FlowWrapper", "onSend() uin=" + this.mAbstractUploadTask.iUin + " flowId=" + this.mAbstractUploadTask.flowId);
    this.p = parama.b();
    this.mConnectedIp = parama.c();
    this.mClientIp = parama.d();
    if (this.p == null)
    {
      b.e("FlowWrapper", "onSend() 在session里获取不到UploadRoute");
      return false;
    }
    b.c("FlowWrapper", "mUploadRoute=" + this.p.toString());
    if (this.p.f() == 2) {
      this.g = true;
    }
    for (this.mSvcRequestHead.z = 0;; this.mSvcRequestHead.z = 1)
    {
      this.mState = 0;
      this.o = 0;
      this.mRetryControlCount += 1;
      return sendFirstPkg(parama);
      this.g = false;
    }
  }
  
  public void onTimeout(com.tencent.upload.network.c.a parama, com.tencent.upload.network.a.d paramd)
  {
    if (!this.g) {
      return;
    }
    String str = "onTimeout(). actionId=" + paramd.f() + " mPartFileMode=" + this.g + " mState=" + this.mState + " mRetryControlCount=" + this.mRetryControlCount + " mRetryPartFileCount=" + this.mRetryPartFileCount + " path=" + this.mAbstractUploadTask.uploadFilePath + " cmdId=" + paramd.g() + " iFileOffset=" + paramd.d();
    switch (this.mState)
    {
    default: 
    case 10: 
      do
      {
        cancelActionForException(-4, 0, true, true, str, null);
        return;
      } while (this.mRetryControlCount > UploadConfiguration.getVideoFileRetryCount());
      this.mRetryControlCount += 1;
      if (parama.a(paramd))
      {
        b.b("FlowWrapper", "onTimeout() send control " + paramd.toString());
        return;
      }
      cancelActionForException(504, 0, true, true, "onTimeout() send control fail", null);
      return;
    }
    if (this.mRetryPartFileCount <= this.mConfig.getVideoPartRetryCount())
    {
      this.mRetryPartFileCount += 1;
      if (parama.a(paramd))
      {
        b.b("FlowWrapper", "onTimeout() send file " + paramd.toString());
        return;
      }
      cancelActionForException(504, 0, true, true, "onTimeout() send file fail", null);
      return;
    }
    this.mRetryControlCount += 1;
    boolean bool = sendFirstPkg(parama);
    b.b("FlowWrapper", "onTimeout() send control2 " + paramd.toString() + " ret:" + bool);
  }
  
  protected void processFileUploadFinishRsp(byte[] paramArrayOfByte, int paramInt)
  {
    b.g(this.mAbstractUploadTask);
    b.b("FlowWrapper", "processFileUploadFinishRsp flowid = " + this.mAbstractUploadTask.flowId + " path = " + this.mAbstractUploadTask.uploadFilePath);
    this.mState = 40;
    if (this.mSvcRequestHead.g == 0)
    {
      paramInt = -55555;
      b.b("FlowWrapper", "PreUploadHit");
    }
    for (;;)
    {
      report(paramInt, null, this.mAbstractUploadTask);
      a(this.mAbstractUploadTask.flowId, 0, "processFileUploadFinishRsp");
      return;
      paramInt = 0;
    }
  }
  
  protected void processSvcResponsePacket(com.tencent.upload.network.c.a parama, SvcResponsePacket paramSvcResponsePacket)
  {
    reportSession = paramSvcResponsePacket.k;
    Object localObject1;
    switch (paramSvcResponsePacket.e)
    {
    default: 
      cancelActionForException(502, 0, true, true, "svcResponsePacket.iCmdID=" + paramSvcResponsePacket.e, null);
      return;
    case 0: 
      this.d = System.currentTimeMillis();
      printSvcResponsePacket(paramSvcResponsePacket);
      try
      {
        localFileUploadControlRsp1 = (FileUploadControlRsp)com.tencent.upload.b.a.a.a(FileUploadControlRsp.class.getSimpleName(), paramSvcResponsePacket.f);
        localObject1 = null;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          FileUploadControlRsp localFileUploadControlRsp1;
          localObject1 = Log.getStackTraceString(localException2);
          b.a("FlowWrapper", localException2);
          localFileUploadControlRsp2 = null;
        }
        a(parama, localFileUploadControlRsp2);
        return;
      }
      if (localFileUploadControlRsp1 == null)
      {
        if (localObject1 != null) {
          break label677;
        }
        localObject1 = "processFileUploadFinishRsp() unpack FileUploadControlRsp=null. " + paramSvcResponsePacket.f;
      }
      break;
    }
    label412:
    label671:
    label677:
    for (boolean bool = true;; bool = false)
    {
      cancelActionForException(500, 0, true, bool, (String)localObject1, null);
      return;
      try
      {
        FileUploadControlRsp localFileUploadControlRsp2;
        localObject1 = (FileUploadProgressRsp)com.tencent.upload.b.a.a.a(FileUploadProgressRsp.class.getSimpleName(), paramSvcResponsePacket.f);
        parama = null;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          parama = Log.getStackTraceString(localException1);
          b.a("FlowWrapper", localException1);
          localObject2 = null;
        }
        b.b("FlowWrapper", "ProgressRsp [" + ((FileUploadProgressRsp)localObject2).b + ", " + ((FileUploadProgressRsp)localObject2).a + "] flowid = " + this.mAbstractUploadTask.flowId + " path = " + this.mAbstractUploadTask.uploadFilePath);
        this.m = ((FileUploadProgressRsp)localObject2).a;
        this.n = ((FileUploadProgressRsp)localObject2).b;
        if (this.mUploadTaskCallback == null) {
          break label412;
        }
        this.mUploadTaskCallback.onUploadProgress(this.mAbstractUploadTask, this.m, this.n);
        b.a("FlowWrapper", "processFileUploadProgressRsp() mUploadTaskCallback progress");
        parama = this.mAbstractUploadTask.progressListener;
        if (parama == null) {
          break label412;
        }
        parama.onProgress(this.mAbstractUploadTask, this.m, this.n);
        this.mRetryControlCount = 0;
        this.mRetryPartFileCount = 0;
        return;
      }
      if (localObject1 == null)
      {
        if (parama != null) {
          break label671;
        }
        parama = "processFileUploadFinishRsp() unpack FileUploadProgressRsp=null. " + paramSvcResponsePacket.f;
      }
      for (bool = true;; bool = false)
      {
        cancelActionForException(500, 0, true, bool, parama, null);
        return;
        Object localObject2;
        printSvcResponsePacket(paramSvcResponsePacket);
        processFileUploadFinishRsp(paramSvcResponsePacket.f, this.mAbstractUploadTask.flowId);
        return;
        this.i += this.h;
        this.j += this.h;
        long l2 = this.j - this.e;
        long l1 = l2;
        if (l2 > this.f) {
          l1 = this.f;
        }
        this.m = this.f;
        this.n = l1;
        this.mUploadTaskCallback.onUploadProgress(this.mAbstractUploadTask, this.m, this.n);
        paramSvcResponsePacket = this.mAbstractUploadTask.progressListener;
        if (paramSvcResponsePacket != null) {
          paramSvcResponsePacket.onProgress(this.mAbstractUploadTask, this.m, this.n);
        }
        this.mRetryControlCount = 0;
        this.mRetryPartFileCount = 0;
        b.a("FlowWrapper", "_CMD_PART mSendDescFileOffset=" + this.i + " mSendDescFileLen=" + this.h + " progress=" + (this.i - this.e) + "/" + this.f + " taskId=" + this.mAbstractUploadTask.flowId);
        a(parama);
        return;
      }
    }
  }
  
  protected void report(int paramInt, String paramString, AbstractUploadTask paramAbstractUploadTask)
  {
    int i1 = paramInt;
    if (this.r == -60)
    {
      i1 = paramInt;
      if (paramInt == 0) {
        i1 = -65;
      }
    }
    if ((i1 == 65329) && ((paramAbstractUploadTask instanceof ImageUploadTask)))
    {
      localObject = ((ImageUploadTask)paramAbstractUploadTask).sAlbumID;
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        if (s.contains(localObject)) {
          return;
        }
        s.add(localObject);
      }
    }
    b.b("FlowWrapper", "report() errorCode=" + i1 + " lastErrorCode = " + this.r + " flow:" + paramAbstractUploadTask.flowId + " errorMsg=" + paramString + " retry=" + (this.mRetryPartFileCount + this.mRetryControlCount));
    this.r = i1;
    Object localObject = new Report();
    ((Report)localObject).source = b.e(paramAbstractUploadTask);
    ((Report)localObject).retCode = i1;
    ((Report)localObject).errMsg = paramString;
    ((Report)localObject).refer = paramAbstractUploadTask.reportRefer;
    if (i1 != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder(50);
      localStringBuilder.append(paramString);
      localStringBuilder.append(" || ");
      localStringBuilder.append(" clientIp=");
      if (this.mClientIp == null)
      {
        paramString = "";
        localStringBuilder.append(paramString);
        localStringBuilder.append(" mState=");
        localStringBuilder.append(this.mState);
        localStringBuilder.append(" mPartFileMode=");
        localStringBuilder.append(this.g);
        localStringBuilder.append(" mProgressTotalLen=");
        localStringBuilder.append(this.m);
        localStringBuilder.append(" mProgressRecvDataLen=");
        localStringBuilder.append(this.n);
        localStringBuilder.append(" || ");
        localStringBuilder.append(this.q);
        this.q = null;
        if ((i1 == -7) || (i1 == -15) || (i1 == 30700) || (i1 == 31500))
        {
          boolean bool = Environment.getExternalStorageState().equals("mounted");
          long l1 = com.tencent.upload.common.b.a();
          paramString = this.mConfig.getDeviceInfo();
          localStringBuilder.append(" || ");
          localStringBuilder.append(" sdExsit=");
          localStringBuilder.append(bool);
          localStringBuilder.append(" sdCardAvailableSize=");
          localStringBuilder.append(l1);
          localStringBuilder.append("M deviceInfo=");
          localStringBuilder.append(paramString);
        }
        localStringBuilder.append(" || ");
        localStringBuilder.append("contolPackTimeCost=");
        localStringBuilder.append(this.d - this.c);
        ((Report)localObject).errMsg = localStringBuilder.toString();
      }
    }
    else
    {
      ((Report)localObject).flowId = paramAbstractUploadTask.flowId;
      ((Report)localObject).filePath = paramAbstractUploadTask.uploadFilePath;
      ((Report)localObject).uploadType = paramAbstractUploadTask.getUploadTaskType();
      ((Report)localObject).fileSize = this.f;
      if (this.b != 0L)
      {
        ((Report)localObject).startTime = this.b;
        ((Report)localObject).endTime = System.currentTimeMillis();
      }
      ((Report)localObject).serverIp = a();
      if (this.p != null) {
        break label734;
      }
      paramInt = 0;
      label603:
      ((Report)localObject).ipsrctype = paramInt;
      ((Report)localObject).networkType = UploadConfiguration.getCurrentNetworkCategory();
      switch (i1)
      {
      }
    }
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        ((Report)localObject).networkType = 0;
      }
      ((Report)localObject).retry = (this.mRetryPartFileCount + this.mRetryControlCount);
      ((Report)localObject).uppAppId = b.d(paramAbstractUploadTask);
      ((Report)localObject).transfer = this.mAbstractUploadTask.transferData;
      f.c().onUploadReport((Report)localObject);
      return;
      paramString = this.mClientIp;
      break;
      label734:
      paramInt = this.p.a();
      break label603;
    }
  }
  
  protected boolean sendFirstPkg(com.tencent.upload.network.c.a parama)
  {
    this.mSvcRequestHead.g = 0;
    this.mSvcRequestHead.k = 0L;
    this.mSvcRequestHead.u = 0L;
    if (this.mUploadFileInfoReqBytes != null) {}
    com.tencent.upload.network.a.d locald;
    for (this.mSvcRequestHead.j = (this.mUploadFileInfoReqBytes.length + this.f);; this.mSvcRequestHead.j = this.f)
    {
      locald = getControlRequest();
      if (locald != null) {
        break;
      }
      return false;
    }
    this.c = System.currentTimeMillis();
    if (parama.a(locald))
    {
      this.mState = 10;
      b.b("FlowWrapper", "sendControlPkg() " + locald.toString() + " preupload:" + this.mSvcRequestHead.B);
      return true;
    }
    cancelActionForException(504, 0, true, true, "sendControlPkg() session send fail", null);
    return false;
  }
  
  public final void setReportAppendMsg(String paramString)
  {
    this.q = paramString;
  }
  
  public void setSessionService$191f3d4e(com.tencent.upload.network.b.b paramb)
  {
    this.a = new WeakReference(paramb);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */