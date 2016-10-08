package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class s_imgcrop
  extends JceStruct
{
  public long centerx_scale;
  public long centery_scale;
  
  public s_imgcrop()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public s_imgcrop(long paramLong1, long paramLong2)
  {
    this.centerx_scale = paramLong1;
    this.centery_scale = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.centerx_scale = paramJceInputStream.read(this.centerx_scale, 0, false);
    this.centery_scale = paramJceInputStream.read(this.centery_scale, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.centerx_scale, 0);
    paramJceOutputStream.write(this.centery_scale, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\s_imgcrop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */