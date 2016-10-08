package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqGetVisitorList
  extends JceStruct
{
  static ReqHead cache_stHeader;
  static UserCntlData cache_stUserData;
  public int iPageSize;
  public ReqHead stHeader;
  public UserCntlData stUserData;
  
  public ReqGetVisitorList()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.iPageSize = -1;
  }
  
  public ReqGetVisitorList(ReqHead paramReqHead, UserCntlData paramUserCntlData, int paramInt)
  {
    this.iPageSize = -1;
    this.stHeader = paramReqHead;
    this.stUserData = paramUserCntlData;
    this.iPageSize = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHead();
    }
    this.stHeader = ((ReqHead)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_stUserData == null) {
      cache_stUserData = new UserCntlData();
    }
    this.stUserData = ((UserCntlData)paramJceInputStream.read(cache_stUserData, 1, true));
    this.iPageSize = paramJceInputStream.read(this.iPageSize, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.stUserData, 1);
    paramJceOutputStream.write(this.iPageSize, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\ReqGetVisitorList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */