package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class cell_interest
  extends JceStruct
{
  static ArrayList cache_users;
  public String desc = "";
  public int is_interested;
  public int num;
  public ArrayList users;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_users = new ArrayList();
    s_user locals_user = new s_user();
    cache_users.add(locals_user);
  }
  
  public cell_interest() {}
  
  public cell_interest(int paramInt1, ArrayList paramArrayList, String paramString, int paramInt2)
  {
    this.num = paramInt1;
    this.users = paramArrayList;
    this.desc = paramString;
    this.is_interested = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.num = paramJceInputStream.read(this.num, 0, false);
    this.users = ((ArrayList)paramJceInputStream.read(cache_users, 1, false));
    this.desc = paramJceInputStream.readString(2, false);
    this.is_interested = paramJceInputStream.read(this.is_interested, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.num, 0);
    if (this.users != null) {
      paramJceOutputStream.write(this.users, 1);
    }
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 2);
    }
    paramJceOutputStream.write(this.is_interested, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\cell_interest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */