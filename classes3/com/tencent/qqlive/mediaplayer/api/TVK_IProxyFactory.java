package com.tencent.qqlive.mediaplayer.api;

import android.content.Context;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;

public abstract interface TVK_IProxyFactory
{
  public abstract TVK_IMediaPlayer createMediaPlayer(Context paramContext, IVideoViewBase paramIVideoViewBase);
  
  public abstract IVideoViewBase createVideoView(Context paramContext);
  
  public abstract IVideoViewBase createVideoView(Context paramContext, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract IVideoViewBase createVideoView_Scroll(Context paramContext);
  
  public abstract IVideoViewBase createVideoView_Scroll_Vr_360(Context paramContext);
  
  public abstract IVideoViewBase createVideoView_Vr_360(Context paramContext);
  
  public abstract TVK_ICacheMgr getCacheMgr(Context paramContext);
  
  public abstract TVK_IDownloadMgr getDownloadMgr(Context paramContext);
  
  public abstract TVK_ISDKInitBridge getSdkMgrInstance();
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\qqlive\mediaplayer\api\TVK_IProxyFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */