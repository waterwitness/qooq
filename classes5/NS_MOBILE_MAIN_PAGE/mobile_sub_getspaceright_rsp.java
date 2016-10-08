package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class mobile_sub_getspaceright_rsp
  extends JceStruct
{
  static Map cache_allGroups;
  static s_question cache_question;
  static Map cache_white_list;
  public Map allGroups;
  public long cur_seq;
  public s_question question;
  public int rightval;
  public Map white_list;
  
  public mobile_sub_getspaceright_rsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public mobile_sub_getspaceright_rsp(int paramInt, Map paramMap1, long paramLong, s_question params_question, Map paramMap2)
  {
    this.rightval = paramInt;
    this.allGroups = paramMap1;
    this.cur_seq = paramLong;
    this.question = params_question;
    this.white_list = paramMap2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.rightval = paramJceInputStream.read(this.rightval, 0, true);
    Object localObject;
    if (cache_allGroups == null)
    {
      cache_allGroups = new HashMap();
      localObject = new GROUP_RIGHT_INFO();
      cache_allGroups.put(Short.valueOf((short)0), localObject);
    }
    this.allGroups = ((Map)paramJceInputStream.read(cache_allGroups, 1, false));
    this.cur_seq = paramJceInputStream.read(this.cur_seq, 2, false);
    if (cache_question == null) {
      cache_question = new s_question();
    }
    this.question = ((s_question)paramJceInputStream.read(cache_question, 3, false));
    if (cache_white_list == null)
    {
      cache_white_list = new HashMap();
      localObject = new FRIEND_INFO();
      cache_white_list.put(Long.valueOf(0L), localObject);
    }
    this.white_list = ((Map)paramJceInputStream.read(cache_white_list, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.rightval, 0);
    if (this.allGroups != null) {
      paramJceOutputStream.write(this.allGroups, 1);
    }
    paramJceOutputStream.write(this.cur_seq, 2);
    if (this.question != null) {
      paramJceOutputStream.write(this.question, 3);
    }
    if (this.white_list != null) {
      paramJceOutputStream.write(this.white_list, 4);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\mobile_sub_getspaceright_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */