package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class cell_like
  extends JceStruct
{
  static ArrayList cache_likemans;
  public int isliked;
  public ArrayList likemans;
  public int num;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_likemans = new ArrayList();
    s_likeman locals_likeman = new s_likeman();
    cache_likemans.add(locals_likeman);
  }
  
  public cell_like() {}
  
  public cell_like(int paramInt1, int paramInt2, ArrayList paramArrayList)
  {
    this.num = paramInt1;
    this.isliked = paramInt2;
    this.likemans = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.num = paramJceInputStream.read(this.num, 0, false);
    this.isliked = paramJceInputStream.read(this.isliked, 1, false);
    this.likemans = ((ArrayList)paramJceInputStream.read(cache_likemans, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.num, 0);
    paramJceOutputStream.write(this.isliked, 1);
    if (this.likemans != null) {
      paramJceOutputStream.write(this.likemans, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\cell_like.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */