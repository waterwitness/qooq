package com.tencent.sc.qzonepush.QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class SvcMsgInfo
  extends JceStruct
{
  static Map cache_msgByteInfos;
  static Map cache_msgInfos;
  public int iMsgType;
  public long lFromUin;
  public Map msgByteInfos;
  public Map msgInfos;
  public String strOther = "";
  public int tTimeStamp;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (!SvcMsgInfo.class.desiredAssertionStatus()) {}
    for (bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SvcMsgInfo() {}
  
  public SvcMsgInfo(long paramLong, int paramInt1, int paramInt2, String paramString, Map paramMap1, Map paramMap2)
  {
    this.lFromUin = paramLong;
    this.tTimeStamp = paramInt1;
    this.iMsgType = paramInt2;
    this.strOther = paramString;
    this.msgInfos = paramMap1;
    this.msgByteInfos = paramMap2;
  }
  
  public String className()
  {
    return "QQService.SvcMsgInfo";
  }
  
  public Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.lFromUin, "lFromUin");
    paramStringBuilder.display(this.tTimeStamp, "tTimeStamp");
    paramStringBuilder.display(this.iMsgType, "iMsgType");
    paramStringBuilder.display(this.strOther, "strOther");
    paramStringBuilder.display(this.msgInfos, "msgInfos");
    paramStringBuilder.display(this.msgByteInfos, "msgByteInfos");
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (SvcMsgInfo)paramObject;
    return (JceUtil.equals(this.lFromUin, ((SvcMsgInfo)paramObject).lFromUin)) && (JceUtil.equals(this.tTimeStamp, ((SvcMsgInfo)paramObject).tTimeStamp)) && (JceUtil.equals(this.iMsgType, ((SvcMsgInfo)paramObject).iMsgType)) && (JceUtil.equals(this.strOther, ((SvcMsgInfo)paramObject).strOther)) && (JceUtil.equals(this.msgInfos, ((SvcMsgInfo)paramObject).msgInfos)) && (JceUtil.equals(this.msgByteInfos, ((SvcMsgInfo)paramObject).msgByteInfos));
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lFromUin = paramJceInputStream.read(this.lFromUin, 0, true);
    this.tTimeStamp = paramJceInputStream.read(this.tTimeStamp, 1, true);
    this.iMsgType = paramJceInputStream.read(this.iMsgType, 2, true);
    this.strOther = paramJceInputStream.readString(3, true);
    if (cache_msgInfos == null)
    {
      cache_msgInfos = new HashMap();
      cache_msgInfos.put("", "");
    }
    this.msgInfos = ((Map)paramJceInputStream.read(cache_msgInfos, 4, false));
    if (cache_msgByteInfos == null)
    {
      cache_msgByteInfos = new HashMap();
      byte[] arrayOfByte = (byte[])new byte[1];
      ((byte[])arrayOfByte)[0] = 0;
      cache_msgByteInfos.put("", arrayOfByte);
    }
    this.msgByteInfos = ((Map)paramJceInputStream.read(cache_msgByteInfos, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lFromUin, 0);
    paramJceOutputStream.write(this.tTimeStamp, 1);
    paramJceOutputStream.write(this.iMsgType, 2);
    paramJceOutputStream.write(this.strOther, 3);
    if (this.msgInfos != null) {
      paramJceOutputStream.write(this.msgInfos, 4);
    }
    if (this.msgByteInfos != null) {
      paramJceOutputStream.write(this.msgByteInfos, 5);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\sc\qzonepush\QQService\SvcMsgInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */