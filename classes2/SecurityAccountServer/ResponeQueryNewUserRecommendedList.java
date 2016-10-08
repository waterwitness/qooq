package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class ResponeQueryNewUserRecommendedList
  extends JceStruct
{
  static ArrayList cache_RecommendedContacts;
  public ArrayList RecommendedContacts;
  public long lastUsedFlag = 1L;
  public String mobileNo = "";
  public String nationCode = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_RecommendedContacts = new ArrayList();
    RecommendedContactInfo localRecommendedContactInfo = new RecommendedContactInfo();
    cache_RecommendedContacts.add(localRecommendedContactInfo);
  }
  
  public ResponeQueryNewUserRecommendedList() {}
  
  public ResponeQueryNewUserRecommendedList(ArrayList paramArrayList, String paramString1, String paramString2, long paramLong)
  {
    this.RecommendedContacts = paramArrayList;
    this.nationCode = paramString1;
    this.mobileNo = paramString2;
    this.lastUsedFlag = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.RecommendedContacts = ((ArrayList)paramJceInputStream.read(cache_RecommendedContacts, 1, true));
    this.nationCode = paramJceInputStream.readString(2, true);
    this.mobileNo = paramJceInputStream.readString(3, true);
    this.lastUsedFlag = paramJceInputStream.read(this.lastUsedFlag, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.RecommendedContacts, 1);
    paramJceOutputStream.write(this.nationCode, 2);
    paramJceOutputStream.write(this.mobileNo, 3);
    paramJceOutputStream.write(this.lastUsedFlag, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SecurityAccountServer\ResponeQueryNewUserRecommendedList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */