package com.tencent.sc.qzonepush.QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class SvcMsgPush
  extends JceStruct
{
  static ArrayList cache_vecMsgInfos;
  public byte cMore;
  public int iUnread;
  public ArrayList vecMsgInfos;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (!SvcMsgPush.class.desiredAssertionStatus()) {}
    for (bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SvcMsgPush() {}
  
  public SvcMsgPush(byte paramByte, int paramInt, ArrayList paramArrayList)
  {
    this.cMore = paramByte;
    this.iUnread = paramInt;
    this.vecMsgInfos = paramArrayList;
  }
  
  public String className()
  {
    return "com.tencent.sc.qzonepush.QQService.SvcMsgPush";
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
    paramStringBuilder.display(this.cMore, "cMore");
    paramStringBuilder.display(this.iUnread, "iUnread");
    paramStringBuilder.display(this.vecMsgInfos, "vecMsgInfos");
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (SvcMsgPush)paramObject;
    return (JceUtil.equals(this.cMore, ((SvcMsgPush)paramObject).cMore)) && (JceUtil.equals(this.iUnread, ((SvcMsgPush)paramObject).iUnread)) && (JceUtil.equals(this.vecMsgInfos, ((SvcMsgPush)paramObject).vecMsgInfos));
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cMore = paramJceInputStream.read(this.cMore, 0, true);
    this.iUnread = paramJceInputStream.read(this.iUnread, 1, true);
    if (cache_vecMsgInfos == null)
    {
      cache_vecMsgInfos = new ArrayList();
      SvcMsgInfo localSvcMsgInfo = new SvcMsgInfo();
      cache_vecMsgInfos.add(localSvcMsgInfo);
    }
    this.vecMsgInfos = ((ArrayList)paramJceInputStream.read(cache_vecMsgInfos, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cMore, 0);
    paramJceOutputStream.write(this.iUnread, 1);
    paramJceOutputStream.write(this.vecMsgInfos, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\sc\qzonepush\QQService\SvcMsgPush.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */