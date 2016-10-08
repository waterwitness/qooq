package com.tencent.qqlive.mediaplayer.api;

import android.content.Context;

public abstract interface TVK_ICacheMgr
{
  public abstract void preLoadVideoById(Context paramContext, TVK_UserInfo paramTVK_UserInfo, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo, String paramString);
  
  public abstract void preLoadVideoByUrl(Context paramContext, String paramString, TVK_UserInfo paramTVK_UserInfo, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\qqlive\mediaplayer\api\TVK_ICacheMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */