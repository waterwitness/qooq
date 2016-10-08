package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class cell_comment
  extends JceStruct
{
  static ArrayList cache_commments;
  static s_commment cache_main_comment = new s_commment();
  public ArrayList commments;
  public s_commment main_comment;
  public int num;
  public int unreadCnt;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_commments = new ArrayList();
    s_commment locals_commment = new s_commment();
    cache_commments.add(locals_commment);
  }
  
  public cell_comment() {}
  
  public cell_comment(int paramInt1, ArrayList paramArrayList, s_commment params_commment, int paramInt2)
  {
    this.num = paramInt1;
    this.commments = paramArrayList;
    this.main_comment = params_commment;
    this.unreadCnt = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.num = paramJceInputStream.read(this.num, 0, false);
    this.commments = ((ArrayList)paramJceInputStream.read(cache_commments, 1, false));
    this.main_comment = ((s_commment)paramJceInputStream.read(cache_main_comment, 2, false));
    this.unreadCnt = paramJceInputStream.read(this.unreadCnt, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.num, 0);
    if (this.commments != null) {
      paramJceOutputStream.write(this.commments, 1);
    }
    if (this.main_comment != null) {
      paramJceOutputStream.write(this.main_comment, 2);
    }
    paramJceOutputStream.write(this.unreadCnt, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\cell_comment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */