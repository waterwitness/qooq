package com.tencent.mobileqq.earlydownload;

import com.tencent.mobileqq.earlydownload.xmldata.XmlData;

public abstract interface EarlyDownloadManager$EarlyDownLoadListener
{
  public abstract void a(XmlData paramXmlData);
  
  public abstract void a(XmlData paramXmlData, long paramLong1, long paramLong2);
  
  public abstract void a(XmlData paramXmlData, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString);
  
  public abstract void b(XmlData paramXmlData);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\EarlyDownloadManager$EarlyDownLoadListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */