package com.tencent.component.network.downloader;

import org.apache.http.HttpResponse;

public final class DownloadReport
{
  public String clientip;
  public int concurrent;
  public String content_type;
  public int currAttempCount;
  public String dns;
  public String domain;
  public long endTime;
  public Throwable exception;
  public long fileRealSize;
  public long fileSize;
  public int httpStatus;
  public int id;
  public String localAddress;
  public String refer;
  public String remoteAddress;
  public HttpResponse response;
  public long startTime;
  public String strategyInfo;
  public long t_conn;
  public long t_prepare;
  public long t_process;
  public long t_recvdata;
  public long t_recvrsp;
  public long t_wait;
  public long totaltime;
  public String url;
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\downloader\DownloadReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */