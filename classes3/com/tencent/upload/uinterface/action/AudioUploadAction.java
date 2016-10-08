package com.tencent.upload.uinterface.action;

import android.util.Log;
import com.tencent.upload.a.d;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.data.AudioUploadResult;
import com.tencent.upload.uinterface.data.AudioUploadTask;

public class AudioUploadAction
  extends d
{
  public AudioUploadAction(AudioUploadTask paramAudioUploadTask)
    throws Exception
  {
    super(paramAudioUploadTask);
    b.a locala = new b.a();
    locala.a = paramAudioUploadTask.iUin;
    locala.c = paramAudioUploadTask.appid;
    locala.b = paramAudioUploadTask.format;
    locala.e = paramAudioUploadTask.voice_length;
    locala.f = paramAudioUploadTask.client_ip;
    locala.d = new byte[0];
    locala.h = 0L;
    locala.i = new byte[0];
    locala.g = 0L;
    com.tencent.upload.a.b.b("FlowWrapper", "UploadReq [uin=" + locala.a + ", format=" + locala.b + ", appid=" + locala.c + ", voice_length=" + locala.e + ", client_ip=" + locala.f + ", server_ip=" + locala.g + ", key_type=" + locala.h + "]");
    Object localObject = null;
    try
    {
      this.mUploadFileInfoReqBytes = com.tencent.upload.b.a.a.a(locala.getClass().getSimpleName(), locala);
      if (this.mUploadFileInfoReqBytes == null)
      {
        paramAudioUploadTask = (AudioUploadTask)localObject;
        if (localObject == null) {
          paramAudioUploadTask = new Exception("AudioUploadAction() pack UploadReq=null. " + locala);
        }
        throw paramAudioUploadTask;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.upload.a.b.a("FlowWrapper", localException);
      }
      this.mSvcRequestHead = createSvcRequestHead(paramAudioUploadTask);
    }
  }
  
  protected void processFileUploadFinishRsp(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      localb = (b.b)com.tencent.upload.b.a.a.a(b.b.class.getSimpleName(), paramArrayOfByte);
      localObject1 = null;
    }
    catch (Exception localException)
    {
      Object localObject2;
      for (;;)
      {
        b.b localb;
        localObject1 = Log.getStackTraceString(localException);
        com.tencent.upload.a.b.a("FlowWrapper", localException);
        localObject2 = null;
      }
      com.tencent.upload.a.b.b("FlowWrapper", "UploadRsp [result=" + ((b.b)localObject2).a + ", voice_id=" + ((b.b)localObject2).b + "]");
      if (this.mUploadTaskCallback == null) {
        break label200;
      }
      Object localObject1 = (AudioUploadTask)this.mAbstractUploadTask;
      AudioUploadResult localAudioUploadResult = new AudioUploadResult();
      localAudioUploadResult.result = ((b.b)localObject2).a;
      localAudioUploadResult.voice_id = ((b.b)localObject2).b;
      localAudioUploadResult.flowId = ((AudioUploadTask)localObject1).flowId;
      localAudioUploadResult.voice_length = ((AudioUploadTask)localObject1).voice_length;
      this.mUploadTaskCallback.onUploadSucceed(this.mAbstractUploadTask, localAudioUploadResult);
      label200:
      super.processFileUploadFinishRsp(paramArrayOfByte, this.mAbstractUploadTask.flowId);
      return;
    }
    if (localb == null)
    {
      if (localObject1 != null) {
        break label213;
      }
      localObject1 = "processFileUploadFinishRsp() unpack UploadRsp=null. " + paramArrayOfByte;
    }
    label213:
    for (boolean bool = true;; bool = false)
    {
      cancelActionForException(500, 0, true, bool, (String)localObject1, null);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\action\AudioUploadAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */