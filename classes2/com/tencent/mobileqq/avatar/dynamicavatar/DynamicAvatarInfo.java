package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.RspBody;

public class DynamicAvatarInfo
{
  public ArrayList a;
  
  public DynamicAvatarInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static DynamicAvatarInfo a(oidb_0x74b.RspBody paramRspBody)
  {
    Object localObject;
    if (paramRspBody == null) {
      localObject = null;
    }
    DynamicAvatarInfo localDynamicAvatarInfo;
    do
    {
      return (DynamicAvatarInfo)localObject;
      localDynamicAvatarInfo = new DynamicAvatarInfo();
      localObject = localDynamicAvatarInfo;
    } while (!paramRspBody.rpt_msg_uin_head_list.has());
    localDynamicAvatarInfo.a = DynamicAvatarInfo.OneUinHeadInfo.a(paramRspBody.rpt_msg_uin_head_list.get());
    return localDynamicAvatarInfo;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\avatar\dynamicavatar\DynamicAvatarInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */