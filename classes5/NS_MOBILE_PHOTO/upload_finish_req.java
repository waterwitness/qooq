package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class upload_finish_req
  extends JceStruct
{
  static Map cache_busi_param;
  public long albumhandset;
  public String albumid;
  public long albumtype;
  public long batchid;
  public Map busi_param;
  public String clientkey;
  public long photosucc;
  public long photototal;
  public int retry_count;
  
  public upload_finish_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.albumid = "";
    this.clientkey = "";
  }
  
  public upload_finish_req(long paramLong1, long paramLong2, long paramLong3, String paramString1, long paramLong4, long paramLong5, Map paramMap, int paramInt, String paramString2)
  {
    this.albumid = "";
    this.clientkey = "";
    this.batchid = paramLong1;
    this.albumtype = paramLong2;
    this.albumhandset = paramLong3;
    this.albumid = paramString1;
    this.photototal = paramLong4;
    this.photosucc = paramLong5;
    this.busi_param = paramMap;
    this.retry_count = paramInt;
    this.clientkey = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.batchid = paramJceInputStream.read(this.batchid, 0, true);
    this.albumtype = paramJceInputStream.read(this.albumtype, 1, true);
    this.albumhandset = paramJceInputStream.read(this.albumhandset, 2, true);
    this.albumid = paramJceInputStream.readString(3, true);
    this.photototal = paramJceInputStream.read(this.photototal, 4, true);
    this.photosucc = paramJceInputStream.read(this.photosucc, 5, true);
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 6, false));
    this.retry_count = paramJceInputStream.read(this.retry_count, 7, false);
    this.clientkey = paramJceInputStream.readString(8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.batchid, 0);
    paramJceOutputStream.write(this.albumtype, 1);
    paramJceOutputStream.write(this.albumhandset, 2);
    paramJceOutputStream.write(this.albumid, 3);
    paramJceOutputStream.write(this.photototal, 4);
    paramJceOutputStream.write(this.photosucc, 5);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 6);
    }
    paramJceOutputStream.write(this.retry_count, 7);
    if (this.clientkey != null) {
      paramJceOutputStream.write(this.clientkey, 8);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_PHOTO\upload_finish_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */