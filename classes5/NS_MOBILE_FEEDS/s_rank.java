package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class s_rank
  extends JceStruct
{
  public int half_star_num;
  public int max;
  
  public s_rank()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public s_rank(int paramInt1, int paramInt2)
  {
    this.max = paramInt1;
    this.half_star_num = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.max = paramJceInputStream.read(this.max, 0, false);
    this.half_star_num = paramJceInputStream.read(this.half_star_num, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.max, 0);
    paramJceOutputStream.write(this.half_star_num, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\s_rank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */