package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;

public class TroopMessageProcessor$DecodeParam
{
  public ArrayList a;
  public List a;
  public msg_comm.Msg a;
  
  public TroopMessageProcessor$DecodeParam(List paramList, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public TroopMessageProcessor$DecodeParam(msg_comm.Msg paramMsg, ArrayList paramArrayList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_MsfMsgcommMsg_comm$Msg = paramMsg;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\TroopMessageProcessor$DecodeParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */