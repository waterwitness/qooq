package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class NetSegConf
  extends JceStruct
{
  public long uint32_curconnnum;
  public long uint32_net_type;
  public long uint32_segnum;
  public long uint32_segsize;
  
  public NetSegConf()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public NetSegConf(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.uint32_net_type = paramLong1;
    this.uint32_segsize = paramLong2;
    this.uint32_segnum = paramLong3;
    this.uint32_curconnnum = paramLong4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uint32_net_type = paramJceInputStream.read(this.uint32_net_type, 0, false);
    this.uint32_segsize = paramJceInputStream.read(this.uint32_segsize, 1, false);
    this.uint32_segnum = paramJceInputStream.read(this.uint32_segnum, 2, false);
    this.uint32_curconnnum = paramJceInputStream.read(this.uint32_curconnnum, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uint32_net_type, 0);
    paramJceOutputStream.write(this.uint32_segsize, 1);
    paramJceOutputStream.write(this.uint32_segnum, 2);
    paramJceOutputStream.write(this.uint32_curconnnum, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ConfigPush\NetSegConf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */