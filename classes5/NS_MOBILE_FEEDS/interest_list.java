package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class interest_list
  extends JceStruct
{
  static ArrayList cache_uinlist;
  static ArrayList cache_users;
  public int allcount;
  public ArrayList uinlist;
  public ArrayList users;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_uinlist = new ArrayList();
    cache_uinlist.add(Long.valueOf(0L));
    cache_users = new ArrayList();
    s_user locals_user = new s_user();
    cache_users.add(locals_user);
  }
  
  public interest_list() {}
  
  public interest_list(ArrayList paramArrayList1, int paramInt, ArrayList paramArrayList2)
  {
    this.uinlist = paramArrayList1;
    this.allcount = paramInt;
    this.users = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uinlist = ((ArrayList)paramJceInputStream.read(cache_uinlist, 0, false));
    this.allcount = paramJceInputStream.read(this.allcount, 1, false);
    this.users = ((ArrayList)paramJceInputStream.read(cache_users, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.uinlist != null) {
      paramJceOutputStream.write(this.uinlist, 0);
    }
    paramJceOutputStream.write(this.allcount, 1);
    if (this.users != null) {
      paramJceOutputStream.write(this.users, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\interest_list.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */