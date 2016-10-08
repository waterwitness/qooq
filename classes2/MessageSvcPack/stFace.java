package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class stFace
  extends JceStruct
{
  public long index;
  
  public stFace()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public stFace(long paramLong)
  {
    this.index = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.index = paramJceInputStream.read(this.index, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.index, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\MessageSvcPack\stFace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */