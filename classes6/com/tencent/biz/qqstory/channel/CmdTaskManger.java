package com.tencent.biz.qqstory.channel;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import iir;

public class CmdTaskManger
{
  public static volatile CmdTaskManger a;
  public static final String a = "Q.qqstory:CmdTaskManager";
  
  private CmdTaskManger()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static CmdTaskManger a()
  {
    Object localObject = a;
    if (localObject == null) {
      try
      {
        CmdTaskManger localCmdTaskManger2 = a;
        localObject = localCmdTaskManger2;
        if (localCmdTaskManger2 == null)
        {
          localObject = new CmdTaskManger();
          a = (CmdTaskManger)localObject;
        }
        return (CmdTaskManger)localObject;
      }
      finally {}
    }
    return localCmdTaskManger1;
  }
  
  public void a(NetworkRequest paramNetworkRequest, CmdTaskManger.CommandCallback paramCommandCallback)
  {
    System.currentTimeMillis();
    paramNetworkRequest = new iir(paramNetworkRequest);
    paramNetworkRequest.jdField_a_of_type_ComTencentBizQqstoryChannelCmdTaskManger$CommandCallback = paramCommandCallback;
    paramNetworkRequest.jdField_a_of_type_ComTencentBizQqstoryChannelNetworkRequest.a(paramNetworkRequest);
    QQStoryContext.a().a().a(paramNetworkRequest.jdField_a_of_type_ComTencentBizQqstoryChannelNetworkRequest);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\channel\CmdTaskManger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */