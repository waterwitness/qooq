package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class RespCondSearch
  extends JceStruct
{
  static ArrayList cache_vUserList;
  public byte cEndFlag;
  public long dwSessionID;
  public int iPage;
  public ArrayList vUserList;
  
  public RespCondSearch()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RespCondSearch(byte paramByte, int paramInt, long paramLong, ArrayList paramArrayList)
  {
    this.cEndFlag = paramByte;
    this.iPage = paramInt;
    this.dwSessionID = paramLong;
    this.vUserList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cEndFlag = paramJceInputStream.read(this.cEndFlag, 0, true);
    this.iPage = paramJceInputStream.read(this.iPage, 1, true);
    this.dwSessionID = paramJceInputStream.read(this.dwSessionID, 2, true);
    if (cache_vUserList == null)
    {
      cache_vUserList = new ArrayList();
      CondFitUser localCondFitUser = new CondFitUser();
      cache_vUserList.add(localCondFitUser);
    }
    this.vUserList = ((ArrayList)paramJceInputStream.read(cache_vUserList, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cEndFlag, 0);
    paramJceOutputStream.write(this.iPage, 1);
    paramJceOutputStream.write(this.dwSessionID, 2);
    if (this.vUserList != null) {
      paramJceOutputStream.write(this.vUserList, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SummaryCard\RespCondSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */