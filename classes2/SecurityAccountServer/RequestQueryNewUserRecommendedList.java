package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RequestQueryNewUserRecommendedList
  extends JceStruct
{
  public String MobileUniqueNo;
  public long WantNum;
  
  public RequestQueryNewUserRecommendedList()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.MobileUniqueNo = "";
  }
  
  public RequestQueryNewUserRecommendedList(String paramString, long paramLong)
  {
    this.MobileUniqueNo = "";
    this.MobileUniqueNo = paramString;
    this.WantNum = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.MobileUniqueNo = paramJceInputStream.readString(1, false);
    this.WantNum = paramJceInputStream.read(this.WantNum, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.MobileUniqueNo != null) {
      paramJceOutputStream.write(this.MobileUniqueNo, 1);
    }
    paramJceOutputStream.write(this.WantNum, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SecurityAccountServer\RequestQueryNewUserRecommendedList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */