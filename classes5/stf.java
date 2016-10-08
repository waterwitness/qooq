import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotchat.HotChatMemberListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x897.cmd0x897.GroupNextVisitor;
import tencent.im.oidb.cmd0x897.cmd0x897.GroupVisitorInfo;
import tencent.im.oidb.cmd0x897.cmd0x897.VisitorInfo;

class stf
  implements Runnable
{
  stf(ste paramste, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int j;
    int k;
    try
    {
      localGroupVisitorInfo = (cmd0x897.GroupVisitorInfo)this.jdField_a_of_type_JavaUtilList.get(0);
      if ((!localGroupVisitorInfo.uint32_flag.has()) || (localGroupVisitorInfo.uint32_flag.get() != 1)) {
        break label185;
      }
      j = 0;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        cmd0x897.GroupVisitorInfo localGroupVisitorInfo;
        localObject2 = this.jdField_a_of_type_Ste.a.a.obtainMessage(2);
        this.jdField_a_of_type_Ste.a.a.sendMessage((Message)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("openTroopMemberList", 2, "", localInvalidProtocolBufferMicroException);
        }
        return;
        j = 1;
      }
      localList = localInvalidProtocolBufferMicroException.rpt_msg_visitor_info.get();
      localArrayList = new ArrayList();
      localFriendsManager = (FriendsManager)this.jdField_a_of_type_Ste.a.app.getManager(50);
      localIterator = localList.iterator();
      localList = null;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label776;
        }
        localVisitorInfo = (cmd0x897.VisitorInfo)localIterator.next();
        if (!localVisitorInfo.uint64_visitor_uin.has()) {
          break;
        }
        str = "" + localVisitorInfo.uint64_visitor_uin.get();
        if (!localVisitorInfo.uint32_visitor_faceid.has()) {
          break label682;
        }
        s = (short)localVisitorInfo.uint32_visitor_faceid.get();
        if (!localVisitorInfo.string_visitor_nick.has()) {
          break label713;
        }
        localObject3 = localVisitorInfo.string_visitor_nick.get().toStringUtf8();
        if (!localVisitorInfo.uint32_role.has()) {
          break label746;
        }
        m = localVisitorInfo.uint32_role.get();
        i = m;
        localObject2 = localList;
        if (m != 0) {
          break label892;
        }
        i = m;
        localObject2 = localList;
        if (this.jdField_a_of_type_Ste.a.b) {
          break label892;
        }
        this.jdField_a_of_type_Ste.a.b = true;
        if ((!localVisitorInfo.uint32_guest_flag.has()) || (localVisitorInfo.uint32_guest_flag.get() <= 0)) {
          break label880;
        }
        bool = true;
        localObject2 = new sts(null);
        ((sts)localObject2).jdField_a_of_type_JavaLangString = str;
        ((sts)localObject2).jdField_a_of_type_Short = s;
        ((sts)localObject2).b = ((String)localObject3);
        ((sts)localObject2).g = ((String)localObject3);
        ((sts)localObject2).jdField_a_of_type_Int = m;
        ((sts)localObject2).jdField_a_of_type_Boolean = bool;
        ((sts)localObject2).c = ChnToSpell.a((String)localObject3, 2);
        ((sts)localObject2).d = ChnToSpell.a((String)localObject3, 1);
        ((sts)localObject2).i = ChnToSpell.a((String)localObject3, 2);
        ((sts)localObject2).h = ChnToSpell.a((String)localObject3, 1);
        localObject3 = localFriendsManager.c(str);
        if ((!this.jdField_a_of_type_Ste.a.app.a().equals(str)) && (localObject3 != null) && (((Friends)localObject3).isFriend()) && (((Friends)localObject3).remark != null) && (((Friends)localObject3).remark.length() > 0))
        {
          ((sts)localObject2).j = ((Friends)localObject3).remark;
          ((sts)localObject2).l = ChnToSpell.a(((Friends)localObject3).remark, 1);
          ((sts)localObject2).k = ChnToSpell.a(((Friends)localObject3).remark, 2);
        }
        localArrayList.add(localObject2);
      }
    }
    catch (Exception localException)
    {
      label185:
      do
      {
        localObject2 = this.jdField_a_of_type_Ste.a.a.obtainMessage(2);
        this.jdField_a_of_type_Ste.a.a.sendMessage((Message)localObject2);
      } while (!QLog.isColorLevel());
      QLog.d("openTroopMemberList", 2, "", localException);
      return;
    }
    if ((localGroupVisitorInfo.msg_group_next_visitor.has()) && (((cmd0x897.GroupNextVisitor)localGroupVisitorInfo.msg_group_next_visitor.get()).uint64_next_visitor.has()))
    {
      k = (int)((cmd0x897.GroupNextVisitor)localGroupVisitorInfo.msg_group_next_visitor.get()).uint64_next_visitor.get();
      if (QLog.isColorLevel()) {
        QLog.i("HotChatMemberListActivity", 2, "onGetOpenTroopMemberList.nextVisitorUin=" + k);
      }
      if (localGroupVisitorInfo.rpt_msg_visitor_info.isEmpty()) {
        throw new InvalidProtocolBufferMicroException("rpt_msg_visitor_info");
      }
    }
    for (;;)
    {
      List localList;
      ArrayList localArrayList;
      FriendsManager localFriendsManager;
      Iterator localIterator;
      cmd0x897.VisitorInfo localVisitorInfo;
      String str;
      throw new InvalidProtocolBufferMicroException("uint64_visitor_uin");
      label682:
      Object localObject2 = localException;
      if (localException == null) {
        localObject2 = new StringBuilder(100);
      }
      ((StringBuilder)localObject2).append("onGetOpenTroopMemberList.uint32_visitor_faceid.has()=false");
      short s = 0;
      Object localObject1 = localObject2;
      continue;
      label713:
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new StringBuilder(100);
      }
      ((StringBuilder)localObject2).append("onGetOpenTroopMemberList.string_visitor_nick.has()=false");
      Object localObject3 = "";
      localObject1 = localObject2;
      continue;
      label746:
      int i = 0;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new StringBuilder(100);
      }
      ((StringBuilder)localObject2).append("onGetOpenTroopMemberList.uint32_role.has()=false");
      break label892;
      label776:
      if (localObject1 != null) {
        QLog.i("HotChatMemberListActivity", 1, ((StringBuilder)localObject1).toString());
      }
      if ((j == 0) && (k != 0))
      {
        localObject1 = this.jdField_a_of_type_Ste.a.a.obtainMessage();
        ((Message)localObject1).what = 3;
        ((Message)localObject1).arg1 = k;
        ((Message)localObject1).obj = localArrayList;
        this.jdField_a_of_type_Ste.a.a.sendMessage((Message)localObject1);
        return;
      }
      localObject1 = this.jdField_a_of_type_Ste.a.a.obtainMessage(1, localArrayList);
      this.jdField_a_of_type_Ste.a.a.sendMessage((Message)localObject1);
      return;
      label880:
      boolean bool = false;
      continue;
      k = 0;
      break;
      label892:
      localObject1 = localObject2;
      int m = i;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\stf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */