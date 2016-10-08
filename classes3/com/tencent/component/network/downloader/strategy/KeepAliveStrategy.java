package com.tencent.component.network.downloader.strategy;

import org.apache.http.HttpRequest;

public abstract interface KeepAliveStrategy
{
  public abstract KeepAlive keepAlive(String paramString, HttpRequest paramHttpRequest);
  
  public abstract boolean supportKeepAlive(String paramString);
  
  public static enum KeepAlive {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\downloader\strategy\KeepAliveStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */