package com.tencent.upload.a;

import android.util.SparseArray;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadAction;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import com.tencent.upload.uinterface.IUploadService.IUploadServiceContext;

final class i
  implements IUploadService.IUploadServiceContext
{
  i(g paramg) {}
  
  public final boolean compressUploadTask(AbstractUploadTask paramAbstractUploadTask, IUploadConfig.UploadImageSize paramUploadImageSize, boolean paramBoolean1, boolean paramBoolean2)
  {
    b localb = g.c(this.a);
    if (localb == null) {
      return false;
    }
    SparseArray localSparseArray = g.d(this.a);
    if (localSparseArray.get(paramAbstractUploadTask.flowId) != null)
    {
      b.e("ServiceImpl", "compressUploadTask() repeating taskId=" + paramAbstractUploadTask.flowId + " file=" + paramAbstractUploadTask.uploadFilePath);
      return true;
    }
    if (localb.a(paramAbstractUploadTask.flowId, paramAbstractUploadTask.uploadFilePath, paramAbstractUploadTask.md5, paramUploadImageSize.width, paramUploadImageSize.height, paramUploadImageSize.quality, paramBoolean1, paramBoolean2))
    {
      paramUploadImageSize = new a(paramAbstractUploadTask, paramUploadImageSize.width, paramUploadImageSize.height, paramUploadImageSize.quality, paramBoolean1, paramBoolean2);
      localSparseArray.put(paramAbstractUploadTask.flowId, paramUploadImageSize);
      if (localSparseArray.size() == 1) {
        g.e(this.a);
      }
      return true;
    }
    return false;
  }
  
  public final void uploadAction(IUploadAction paramIUploadAction)
  {
    paramIUploadAction.setSessionService$191f3d4e(g.b(this.a));
    g.b(this.a).a(paramIUploadAction);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */