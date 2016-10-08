package com.tencent.bitapp;

import com.tencent.bitapp.module.IDownloadAction;
import com.tencent.bitapp.module.IDownloadListener;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.LolaUpdateRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.UpdateRequestItem;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import hdi;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class BitAppBundleDownload
  implements IDownloadAction
{
  public static final String TAG = "BitAppBundleDownload";
  public AppRuntime app;
  
  public BitAppBundleDownload(AppRuntime paramAppRuntime)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.app = paramAppRuntime;
  }
  
  public void downloadDetail(int paramInt, IDownloadListener paramIDownloadListener)
  {
    if (paramInt <= 0)
    {
      if (paramIDownloadListener != null) {
        paramIDownloadListener.downloadFailure();
      }
      return;
    }
    Object localObject = new mobileqq_mp.UpdateRequestItem();
    ((mobileqq_mp.UpdateRequestItem)localObject).module_id.set(paramInt);
    mobileqq_mp.LolaUpdateRequest localLolaUpdateRequest = new mobileqq_mp.LolaUpdateRequest();
    localLolaUpdateRequest.versionInfo.set(PublicAccountUtil.a());
    localLolaUpdateRequest.request_item.add((MessageMicro)localObject);
    localObject = new NewIntent(BaseApplicationImpl.a(), PublicAccountServlet.class);
    ((NewIntent)localObject).putExtra("cmd", "lola_update_req");
    ((NewIntent)localObject).putExtra("data", localLolaUpdateRequest.toByteArray());
    ((NewIntent)localObject).setObserver(new hdi(this, paramIDownloadListener));
    this.app.startServlet((NewIntent)localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\BitAppBundleDownload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */