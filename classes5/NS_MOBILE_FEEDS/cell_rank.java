package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class cell_rank
  extends JceStruct
{
  static s_rank cache_rank = new s_rank();
  public s_rank rank;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public cell_rank() {}
  
  public cell_rank(s_rank params_rank)
  {
    this.rank = params_rank;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.rank = ((s_rank)paramJceInputStream.read(cache_rank, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.rank != null) {
      paramJceOutputStream.write(this.rank, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\cell_rank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */