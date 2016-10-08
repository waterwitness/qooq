package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class mobile_feeds_piece_list
  extends JceStruct
{
  static ArrayList cache_all_feeds_data;
  public ArrayList all_feeds_data;
  public long offset;
  public String tlv_attach_info = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_all_feeds_data = new ArrayList();
    single_feed localsingle_feed = new single_feed();
    cache_all_feeds_data.add(localsingle_feed);
  }
  
  public mobile_feeds_piece_list() {}
  
  public mobile_feeds_piece_list(ArrayList paramArrayList, long paramLong, String paramString)
  {
    this.all_feeds_data = paramArrayList;
    this.offset = paramLong;
    this.tlv_attach_info = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.all_feeds_data = ((ArrayList)paramJceInputStream.read(cache_all_feeds_data, 0, false));
    this.offset = paramJceInputStream.read(this.offset, 1, false);
    this.tlv_attach_info = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.all_feeds_data != null) {
      paramJceOutputStream.write(this.all_feeds_data, 0);
    }
    paramJceOutputStream.write(this.offset, 1);
    if (this.tlv_attach_info != null) {
      paramJceOutputStream.write(this.tlv_attach_info, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\mobile_feeds_piece_list.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */