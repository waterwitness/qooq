package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class operation_publishmessage_req
  extends JceStruct
{
  static Map cache_busi_param;
  static MediaInfo cache_mediainfo;
  public Map busi_param;
  public String content;
  public int iMsgType;
  public boolean isverified;
  public int mediabittype;
  public MediaInfo mediainfo;
  public long ownuin;
  public long uin;
  
  public operation_publishmessage_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.content = "";
    this.isverified = true;
  }
  
  public operation_publishmessage_req(long paramLong1, long paramLong2, String paramString, boolean paramBoolean, int paramInt1, MediaInfo paramMediaInfo, Map paramMap, int paramInt2)
  {
    this.content = "";
    this.isverified = true;
    this.uin = paramLong1;
    this.ownuin = paramLong2;
    this.content = paramString;
    this.isverified = paramBoolean;
    this.mediabittype = paramInt1;
    this.mediainfo = paramMediaInfo;
    this.busi_param = paramMap;
    this.iMsgType = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.ownuin = paramJceInputStream.read(this.ownuin, 1, false);
    this.content = paramJceInputStream.readString(2, false);
    this.isverified = paramJceInputStream.read(this.isverified, 3, false);
    this.mediabittype = paramJceInputStream.read(this.mediabittype, 4, false);
    if (cache_mediainfo == null) {
      cache_mediainfo = new MediaInfo();
    }
    this.mediainfo = ((MediaInfo)paramJceInputStream.read(cache_mediainfo, 5, false));
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 6, false));
    this.iMsgType = paramJceInputStream.read(this.iMsgType, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.ownuin, 1);
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 2);
    }
    paramJceOutputStream.write(this.isverified, 3);
    paramJceOutputStream.write(this.mediabittype, 4);
    if (this.mediainfo != null) {
      paramJceOutputStream.write(this.mediainfo, 5);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 6);
    }
    paramJceOutputStream.write(this.iMsgType, 7);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_OPERATION\operation_publishmessage_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */