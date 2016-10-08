package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqTmpChatPicDownload
  extends JceStruct
  implements Cloneable
{
  public byte getPicSize;
  public long lSeq;
  public long lUIN;
  public String strFlieKey = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (!ReqTmpChatPicDownload.class.desiredAssertionStatus()) {}
    for (bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ReqTmpChatPicDownload() {}
  
  public ReqTmpChatPicDownload(long paramLong1, long paramLong2, String paramString, byte paramByte)
  {
    this.lUIN = paramLong1;
    this.lSeq = paramLong2;
    this.strFlieKey = paramString;
    this.getPicSize = paramByte;
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
    paramStringBuilder.display(this.lUIN, "lUIN");
    paramStringBuilder.display(this.lSeq, "lSeq");
    paramStringBuilder.display(this.strFlieKey, "strFlieKey");
    paramStringBuilder.display(this.getPicSize, "getPicSize");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (ReqTmpChatPicDownload)paramObject;
    } while ((!JceUtil.equals(this.lUIN, ((ReqTmpChatPicDownload)paramObject).lUIN)) || (!JceUtil.equals(this.lSeq, ((ReqTmpChatPicDownload)paramObject).lSeq)) || (!JceUtil.equals(this.strFlieKey, ((ReqTmpChatPicDownload)paramObject).strFlieKey)) || (!JceUtil.equals(this.getPicSize, ((ReqTmpChatPicDownload)paramObject).getPicSize)));
    return true;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUIN = paramJceInputStream.read(this.lUIN, 0, true);
    this.lSeq = paramJceInputStream.read(this.lSeq, 1, true);
    this.strFlieKey = paramJceInputStream.readString(2, true);
    this.getPicSize = paramJceInputStream.read(this.getPicSize, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUIN, 0);
    paramJceOutputStream.write(this.lSeq, 1);
    paramJceOutputStream.write(this.strFlieKey, 2);
    paramJceOutputStream.write(this.getPicSize, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\ReqTmpChatPicDownload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */