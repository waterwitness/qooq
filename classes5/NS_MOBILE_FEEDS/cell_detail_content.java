package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class cell_detail_content
  extends JceStruct
{
  static ArrayList cache_detail_content;
  public ArrayList detail_content;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_detail_content = new ArrayList();
    byte[] arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    cache_detail_content.add(arrayOfByte);
  }
  
  public cell_detail_content() {}
  
  public cell_detail_content(ArrayList paramArrayList)
  {
    this.detail_content = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.detail_content = ((ArrayList)paramJceInputStream.read(cache_detail_content, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.detail_content != null) {
      paramJceOutputStream.write(this.detail_content, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\cell_detail_content.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */