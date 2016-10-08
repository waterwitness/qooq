package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class cell_pic_text
  extends JceStruct
{
  static ArrayList cache_data_list;
  public ArrayList data_list;
  public int data_num;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_data_list = new ArrayList();
    st_pic_text localst_pic_text = new st_pic_text();
    cache_data_list.add(localst_pic_text);
  }
  
  public cell_pic_text() {}
  
  public cell_pic_text(int paramInt, ArrayList paramArrayList)
  {
    this.data_num = paramInt;
    this.data_list = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.data_num = paramJceInputStream.read(this.data_num, 0, false);
    this.data_list = ((ArrayList)paramJceInputStream.read(cache_data_list, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.data_num, 0);
    if (this.data_list != null) {
      paramJceOutputStream.write(this.data_list, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\cell_pic_text.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */