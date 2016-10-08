package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqVoiceManage
  extends JceStruct
{
  static int cache_eOpType;
  static VoiceInfo cache_stVoiceInfo;
  public int eOpType;
  public long lFriendUin;
  public VoiceInfo stVoiceInfo;
  
  public ReqVoiceManage()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReqVoiceManage(int paramInt, VoiceInfo paramVoiceInfo, long paramLong)
  {
    this.eOpType = paramInt;
    this.stVoiceInfo = paramVoiceInfo;
    this.lFriendUin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.eOpType = paramJceInputStream.read(this.eOpType, 0, true);
    if (cache_stVoiceInfo == null) {
      cache_stVoiceInfo = new VoiceInfo();
    }
    this.stVoiceInfo = ((VoiceInfo)paramJceInputStream.read(cache_stVoiceInfo, 1, true));
    this.lFriendUin = paramJceInputStream.read(this.lFriendUin, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.eOpType, 0);
    paramJceOutputStream.write(this.stVoiceInfo, 1);
    paramJceOutputStream.write(this.lFriendUin, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SummaryCard\ReqVoiceManage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */