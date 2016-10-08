package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class ModGroupSort
  extends JceStruct
{
  static ArrayList cache_vMsgGroupSort;
  public ArrayList vMsgGroupSort;
  
  public ModGroupSort()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ModGroupSort(ArrayList paramArrayList)
  {
    this.vMsgGroupSort = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vMsgGroupSort == null)
    {
      cache_vMsgGroupSort = new ArrayList();
      GroupSort localGroupSort = new GroupSort();
      cache_vMsgGroupSort.add(localGroupSort);
    }
    this.vMsgGroupSort = ((ArrayList)paramJceInputStream.read(cache_vMsgGroupSort, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vMsgGroupSort != null) {
      paramJceOutputStream.write(this.vMsgGroupSort, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\IMMsgBodyPack\ModGroupSort.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */