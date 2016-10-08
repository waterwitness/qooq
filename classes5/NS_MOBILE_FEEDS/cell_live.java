package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class cell_live
  extends JceStruct
{
  static Map cache_extendInfo;
  static ArrayList cache_vctCommentList;
  public String exception_tips = "";
  public Map extendInfo;
  public int giftNum;
  public int likeNum;
  public int livetime;
  public String roomid = "";
  public int roomstat;
  public String tipsMessage = "";
  public int usercount;
  public ArrayList vctCommentList;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_extendInfo = new HashMap();
    cache_extendInfo.put("", "");
    cache_vctCommentList = new ArrayList();
    SpecialMsg localSpecialMsg = new SpecialMsg();
    cache_vctCommentList.add(localSpecialMsg);
  }
  
  public cell_live() {}
  
  public cell_live(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, Map paramMap, String paramString3, ArrayList paramArrayList)
  {
    this.roomid = paramString1;
    this.roomstat = paramInt1;
    this.usercount = paramInt2;
    this.livetime = paramInt3;
    this.giftNum = paramInt4;
    this.likeNum = paramInt5;
    this.tipsMessage = paramString2;
    this.extendInfo = paramMap;
    this.exception_tips = paramString3;
    this.vctCommentList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.roomid = paramJceInputStream.readString(0, false);
    this.roomstat = paramJceInputStream.read(this.roomstat, 1, false);
    this.usercount = paramJceInputStream.read(this.usercount, 2, false);
    this.livetime = paramJceInputStream.read(this.livetime, 3, false);
    this.giftNum = paramJceInputStream.read(this.giftNum, 5, false);
    this.likeNum = paramJceInputStream.read(this.likeNum, 6, false);
    this.tipsMessage = paramJceInputStream.readString(7, false);
    this.extendInfo = ((Map)paramJceInputStream.read(cache_extendInfo, 8, false));
    this.exception_tips = paramJceInputStream.readString(9, false);
    this.vctCommentList = ((ArrayList)paramJceInputStream.read(cache_vctCommentList, 10, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.roomid != null) {
      paramJceOutputStream.write(this.roomid, 0);
    }
    paramJceOutputStream.write(this.roomstat, 1);
    paramJceOutputStream.write(this.usercount, 2);
    paramJceOutputStream.write(this.livetime, 3);
    paramJceOutputStream.write(this.giftNum, 5);
    paramJceOutputStream.write(this.likeNum, 6);
    if (this.tipsMessage != null) {
      paramJceOutputStream.write(this.tipsMessage, 7);
    }
    if (this.extendInfo != null) {
      paramJceOutputStream.write(this.extendInfo, 8);
    }
    if (this.exception_tips != null) {
      paramJceOutputStream.write(this.exception_tips, 9);
    }
    if (this.vctCommentList != null) {
      paramJceOutputStream.write(this.vctCommentList, 10);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\cell_live.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */