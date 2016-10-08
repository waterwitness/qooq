package com.tencent.mobileqq.music;

public abstract interface QQPlayerService$QQPlayerCallback
{
  public abstract String getToken();
  
  public abstract void onPlaySongChanged(SongInfo paramSongInfo);
  
  public abstract void onPlayStateChanged(int paramInt);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\music\QQPlayerService$QQPlayerCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */