package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class operation_addcomment_req
  extends JceStruct
{
  static Map cache_busi_param;
  static MediaInfo cache_mediainfo;
  public int appid;
  public Map busi_param;
  public String content;
  public int isPrivateComment;
  public int isverified;
  public int mediabittype;
  public MediaInfo mediainfo;
  public long ownuin;
  public String srcId;
  public String srcSubid;
  public long uin;
  
  public operation_addcomment_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.srcId = "";
    this.content = "";
    this.srcSubid = "";
  }
  
  public operation_addcomment_req(int paramInt1, long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt2, Map paramMap, String paramString3, MediaInfo paramMediaInfo, int paramInt3, int paramInt4)
  {
    this.srcId = "";
    this.content = "";
    this.srcSubid = "";
    this.appid = paramInt1;
    this.uin = paramLong1;
    this.ownuin = paramLong2;
    this.srcId = paramString1;
    this.content = paramString2;
    this.isverified = paramInt2;
    this.busi_param = paramMap;
    this.srcSubid = paramString3;
    this.mediainfo = paramMediaInfo;
    this.mediabittype = paramInt3;
    this.isPrivateComment = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.uin = paramJceInputStream.read(this.uin, 1, false);
    this.ownuin = paramJceInputStream.read(this.ownuin, 2, false);
    this.srcId = paramJceInputStream.readString(3, false);
    this.content = paramJceInputStream.readString(4, false);
    this.isverified = paramJceInputStream.read(this.isverified, 5, false);
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 6, false));
    this.srcSubid = paramJceInputStream.readString(7, false);
    if (cache_mediainfo == null) {
      cache_mediainfo = new MediaInfo();
    }
    this.mediainfo = ((MediaInfo)paramJceInputStream.read(cache_mediainfo, 8, false));
    this.mediabittype = paramJceInputStream.read(this.mediabittype, 9, false);
    this.isPrivateComment = paramJceInputStream.read(this.isPrivateComment, 10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.ownuin, 2);
    if (this.srcId != null) {
      paramJceOutputStream.write(this.srcId, 3);
    }
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 4);
    }
    paramJceOutputStream.write(this.isverified, 5);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 6);
    }
    if (this.srcSubid != null) {
      paramJceOutputStream.write(this.srcSubid, 7);
    }
    if (this.mediainfo != null) {
      paramJceOutputStream.write(this.mediainfo, 8);
    }
    paramJceOutputStream.write(this.mediabittype, 9);
    paramJceOutputStream.write(this.isPrivateComment, 10);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_OPERATION\operation_addcomment_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */