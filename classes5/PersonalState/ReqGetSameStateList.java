package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqGetSameStateList
  extends JceStruct
{
  static int cache_eFetchSex;
  static int cache_eSelfSex;
  static BusiReqHead cache_oHead;
  static LBSInfo cache_oLbsInfo;
  static stRishState cache_oSelfRishState;
  static byte[] cache_vCookie;
  public int eFetchSex;
  public int eSelfSex;
  public int iPageSize;
  public long lFriendUin;
  public BusiReqHead oHead;
  public LBSInfo oLbsInfo;
  public stRishState oSelfRishState;
  public byte[] vCookie;
  
  public ReqGetSameStateList()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.iPageSize = -1;
    this.eSelfSex = 2;
    this.eFetchSex = -1;
  }
  
  public ReqGetSameStateList(BusiReqHead paramBusiReqHead, byte[] paramArrayOfByte, stRishState paramstRishState, int paramInt1, LBSInfo paramLBSInfo, int paramInt2, int paramInt3, long paramLong)
  {
    this.iPageSize = -1;
    this.eSelfSex = 2;
    this.eFetchSex = -1;
    this.oHead = paramBusiReqHead;
    this.vCookie = paramArrayOfByte;
    this.oSelfRishState = paramstRishState;
    this.iPageSize = paramInt1;
    this.oLbsInfo = paramLBSInfo;
    this.eSelfSex = paramInt2;
    this.eFetchSex = paramInt3;
    this.lFriendUin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_oHead == null) {
      cache_oHead = new BusiReqHead();
    }
    this.oHead = ((BusiReqHead)paramJceInputStream.read(cache_oHead, 0, true));
    if (cache_vCookie == null)
    {
      cache_vCookie = (byte[])new byte[1];
      ((byte[])cache_vCookie)[0] = 0;
    }
    this.vCookie = ((byte[])paramJceInputStream.read(cache_vCookie, 1, true));
    if (cache_oSelfRishState == null) {
      cache_oSelfRishState = new stRishState();
    }
    this.oSelfRishState = ((stRishState)paramJceInputStream.read(cache_oSelfRishState, 2, true));
    this.iPageSize = paramJceInputStream.read(this.iPageSize, 3, false);
    if (cache_oLbsInfo == null) {
      cache_oLbsInfo = new LBSInfo();
    }
    this.oLbsInfo = ((LBSInfo)paramJceInputStream.read(cache_oLbsInfo, 4, false));
    this.eSelfSex = paramJceInputStream.read(this.eSelfSex, 5, false);
    this.eFetchSex = paramJceInputStream.read(this.eFetchSex, 6, false);
    this.lFriendUin = paramJceInputStream.read(this.lFriendUin, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.oHead, 0);
    paramJceOutputStream.write(this.vCookie, 1);
    paramJceOutputStream.write(this.oSelfRishState, 2);
    paramJceOutputStream.write(this.iPageSize, 3);
    if (this.oLbsInfo != null) {
      paramJceOutputStream.write(this.oLbsInfo, 4);
    }
    paramJceOutputStream.write(this.eSelfSex, 5);
    paramJceOutputStream.write(this.eFetchSex, 6);
    paramJceOutputStream.write(this.lFriendUin, 7);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\PersonalState\ReqGetSameStateList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */