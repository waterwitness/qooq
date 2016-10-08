package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class MsgType0x210SubMsgType0x24
  extends JceStruct
{
  static ArrayList cache_vPluginNumList;
  public ArrayList vPluginNumList;
  
  public MsgType0x210SubMsgType0x24()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MsgType0x210SubMsgType0x24(ArrayList paramArrayList)
  {
    this.vPluginNumList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vPluginNumList == null)
    {
      cache_vPluginNumList = new ArrayList();
      PluginNum localPluginNum = new PluginNum();
      cache_vPluginNumList.add(localPluginNum);
    }
    this.vPluginNumList = ((ArrayList)paramJceInputStream.read(cache_vPluginNumList, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vPluginNumList != null) {
      paramJceOutputStream.write(this.vPluginNumList, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\IMMsgBodyPack\MsgType0x210SubMsgType0x24.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */