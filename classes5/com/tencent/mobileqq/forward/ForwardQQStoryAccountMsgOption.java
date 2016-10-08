package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForwardQQStoryAccountMsgOption
  extends ForwardPluginShareStructMsgOption
{
  public ForwardQQStoryAccountMsgOption(Intent paramIntent)
  {
    super(paramIntent);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.e = true;
  }
  
  public List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && (localRecentUser.type != 1020) && (localRecentUser.type != 1008) && (localRecentUser.type != 1005) && ((localRecentUser.type != 1006) || (a(ForwardAbility.ForwardAbilityType.i))) && (localRecentUser.type != 1009) && (localRecentUser.type != 1021) && (localRecentUser.type != 1001) && (localRecentUser.type != 1022) && (localRecentUser.type != 7000) && (localRecentUser.type != 1025) && (localRecentUser.type != 1024) && (localRecentUser.type != 9501) && ((localRecentUser.type != 1) || (!a(localRecentUser.uin))) && ((localRecentUser.type != 0) || (!CrmUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin))) && (((localRecentUser.type != 1004) && (localRecentUser.type != 1000)) || (this.b))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  protected void k()
  {
    u();
    super.k();
  }
  
  public void u()
  {
    Object localObject1 = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle);
    if ((localObject1 == null) || (TextUtils.isEmpty(((AbsStructMsg)localObject1).mMsg_A_ActionData))) {}
    Object localObject2;
    do
    {
      do
      {
        return;
        localObject2 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, ((AbsStructMsg)localObject1).mMsg_A_ActionData);
      } while (localObject2 == null);
      localObject1 = ((JumpAction)localObject2).a("usertype");
      localObject2 = ((JumpAction)localObject2).a("unionid");
    } while ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)));
    try
    {
      i = Integer.parseInt((String)localObject1);
      StoryReportor.a("share_uin", "qq_suc", TroopUtils.b(this.jdField_a_of_type_AndroidOsBundle.getInt("uintype")), i, new String[] { localObject2 });
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int i = 0;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\forward\ForwardQQStoryAccountMsgOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */