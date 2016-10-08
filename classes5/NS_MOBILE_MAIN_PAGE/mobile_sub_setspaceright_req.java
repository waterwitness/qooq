package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class mobile_sub_setspaceright_req
  extends JceStruct
{
  static byte[] cache_allowGroupsId;
  static s_question cache_questions;
  public byte[] allowGroupsId;
  public long cur_seq;
  public s_question questions;
  public int rightval;
  public long uin;
  
  public mobile_sub_setspaceright_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public mobile_sub_setspaceright_req(long paramLong1, int paramInt, byte[] paramArrayOfByte, long paramLong2, s_question params_question)
  {
    this.uin = paramLong1;
    this.rightval = paramInt;
    this.allowGroupsId = paramArrayOfByte;
    this.cur_seq = paramLong2;
    this.questions = params_question;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.rightval = paramJceInputStream.read(this.rightval, 1, true);
    if (cache_allowGroupsId == null)
    {
      cache_allowGroupsId = (byte[])new byte[1];
      ((byte[])cache_allowGroupsId)[0] = 0;
    }
    this.allowGroupsId = ((byte[])paramJceInputStream.read(cache_allowGroupsId, 2, false));
    this.cur_seq = paramJceInputStream.read(this.cur_seq, 3, false);
    if (cache_questions == null) {
      cache_questions = new s_question();
    }
    this.questions = ((s_question)paramJceInputStream.read(cache_questions, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.rightval, 1);
    if (this.allowGroupsId != null) {
      paramJceOutputStream.write(this.allowGroupsId, 2);
    }
    paramJceOutputStream.write(this.cur_seq, 3);
    if (this.questions != null) {
      paramJceOutputStream.write(this.questions, 4);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\mobile_sub_setspaceright_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */