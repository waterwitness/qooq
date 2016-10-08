package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class Type_1_QQDataTextMsg
  extends JceStruct
{
  static ArrayList cache_msg_item;
  public ArrayList msg_item;
  
  public Type_1_QQDataTextMsg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Type_1_QQDataTextMsg(ArrayList paramArrayList)
  {
    this.msg_item = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_msg_item == null)
    {
      cache_msg_item = new ArrayList();
      MsgType0x210SubMsgType0x13_MsgItem localMsgType0x210SubMsgType0x13_MsgItem = new MsgType0x210SubMsgType0x13_MsgItem();
      cache_msg_item.add(localMsgType0x210SubMsgType0x13_MsgItem);
    }
    this.msg_item = ((ArrayList)paramJceInputStream.read(cache_msg_item, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.msg_item != null) {
      paramJceOutputStream.write(this.msg_item, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\IMMsgBodyPack\Type_1_QQDataTextMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */