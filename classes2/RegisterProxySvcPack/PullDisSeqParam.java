package RegisterProxySvcPack;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class PullDisSeqParam
  extends JceStruct
  implements Cloneable
{
  public long lDisCode;
  public long lLastSeqId;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (!PullDisSeqParam.class.desiredAssertionStatus()) {}
    for (bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public PullDisSeqParam() {}
  
  public PullDisSeqParam(long paramLong1, long paramLong2)
  {
    this.lDisCode = paramLong1;
    this.lLastSeqId = paramLong2;
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
    paramStringBuilder.display(this.lDisCode, "lDisCode");
    paramStringBuilder.display(this.lLastSeqId, "lLastSeqId");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.lDisCode, true);
    paramStringBuilder.displaySimple(this.lLastSeqId, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (PullDisSeqParam)paramObject;
    } while ((!JceUtil.equals(this.lDisCode, ((PullDisSeqParam)paramObject).lDisCode)) || (!JceUtil.equals(this.lLastSeqId, ((PullDisSeqParam)paramObject).lLastSeqId)));
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
    this.lDisCode = paramJceInputStream.read(this.lDisCode, 0, true);
    this.lLastSeqId = paramJceInputStream.read(this.lLastSeqId, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lDisCode, 0);
    paramJceOutputStream.write(this.lLastSeqId, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\RegisterProxySvcPack\PullDisSeqParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */