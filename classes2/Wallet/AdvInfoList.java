package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class AdvInfoList
  extends JceStruct
{
  static ArrayList cache_list;
  public ArrayList list;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_list = new ArrayList();
    AdvInfo localAdvInfo = new AdvInfo();
    cache_list.add(localAdvInfo);
  }
  
  public AdvInfoList() {}
  
  public AdvInfoList(ArrayList paramArrayList)
  {
    this.list = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.list = ((ArrayList)paramJceInputStream.read(cache_list, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.list, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\Wallet\AdvInfoList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */