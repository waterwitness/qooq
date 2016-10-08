package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class ModFriendGroup
  extends JceStruct
{
  static ArrayList cache_vMsgFrdGroup;
  public ArrayList vMsgFrdGroup;
  
  public ModFriendGroup()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ModFriendGroup(ArrayList paramArrayList)
  {
    this.vMsgFrdGroup = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vMsgFrdGroup == null)
    {
      cache_vMsgFrdGroup = new ArrayList();
      FriendGroup localFriendGroup = new FriendGroup();
      cache_vMsgFrdGroup.add(localFriendGroup);
    }
    this.vMsgFrdGroup = ((ArrayList)paramJceInputStream.read(cache_vMsgFrdGroup, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vMsgFrdGroup != null) {
      paramJceOutputStream.write(this.vMsgFrdGroup, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\IMMsgBodyPack\ModFriendGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */