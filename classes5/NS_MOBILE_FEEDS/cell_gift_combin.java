package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class cell_gift_combin
  extends JceStruct
{
  static ArrayList cache_gifts;
  public ArrayList gifts;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_gifts = new ArrayList();
    s_gift_item locals_gift_item = new s_gift_item();
    cache_gifts.add(locals_gift_item);
  }
  
  public cell_gift_combin() {}
  
  public cell_gift_combin(ArrayList paramArrayList)
  {
    this.gifts = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.gifts = ((ArrayList)paramJceInputStream.read(cache_gifts, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.gifts != null) {
      paramJceOutputStream.write(this.gifts, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\cell_gift_combin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */