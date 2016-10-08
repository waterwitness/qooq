package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class ReqAddDiscussMember
  extends JceStruct
{
  static ArrayList cache_Members;
  public long DiscussUin;
  public ArrayList Members;
  
  public ReqAddDiscussMember()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReqAddDiscussMember(long paramLong, ArrayList paramArrayList)
  {
    this.DiscussUin = paramLong;
    this.Members = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.DiscussUin = paramJceInputStream.read(this.DiscussUin, 0, true);
    if (cache_Members == null)
    {
      cache_Members = new ArrayList();
      AddDiscussMemberInfo localAddDiscussMemberInfo = new AddDiscussMemberInfo();
      cache_Members.add(localAddDiscussMemberInfo);
    }
    this.Members = ((ArrayList)paramJceInputStream.read(cache_Members, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.DiscussUin, 0);
    paramJceOutputStream.write(this.Members, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\ReqAddDiscussMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */