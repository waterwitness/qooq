package com.weiyun.sdk.job.schedule;

import com.weiyun.sdk.IWyTaskManager.UploadTask;
import com.weiyun.sdk.job.BaseUploadJob;
import com.weiyun.sdk.job.Job;
import com.weiyun.sdk.job.UploadJobContext;

public class UploadJobProxy
  extends JobProxy
  implements IWyTaskManager.UploadTask
{
  public volatile String mFileId = null;
  
  public UploadJobProxy(BaseUploadJob paramBaseUploadJob, Object paramObject, JobManager paramJobManager)
  {
    super(paramBaseUploadJob, paramObject, paramJobManager);
  }
  
  public String getFileId()
  {
    return this.mFileId;
  }
  
  public void notifyStateChanged(int paramInt, Job paramJob)
  {
    if (paramInt == 5) {
      this.mFileId = ((BaseUploadJob)paramJob).getUploadJobContext().getFileId();
    }
    super.notifyStateChanged(paramInt, paramJob);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\weiyun\sdk\job\schedule\UploadJobProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */