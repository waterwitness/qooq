import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForHotChat;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x897.cmd0x897.GroupVisitorInfo;
import tencent.im.oidb.cmd0x897.cmd0x897.VisitorInfo;

public class kyt
  extends HotChatObserver
{
  public kyt(ChatSettingForHotChat paramChatSettingForHotChat)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatSettingForHotChat", 2, "onExitHotChat  isSuccess= " + paramBoolean + ",troopUin=" + paramString1 + ",errorMsg=" + paramString2);
    }
    if (paramBoolean) {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!this.a.isFinishing()))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString2);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2130838452);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(false);
        this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new kyw(this), 1500L);
      }
    }
    while ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) || (this.a.isFinishing())) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString2);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2130838442);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(false);
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new kyx(this), 1500L);
  }
  
  protected void a(boolean paramBoolean, int paramInt, List paramList, Long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatSettingForHotChat", 2, "onGetOpenTroopMemberList.isSuccess= " + paramBoolean);
    }
    int i;
    if (paramBoolean)
    {
      paramList = (cmd0x897.GroupVisitorInfo)paramList.get(0);
      if (!paramList.rpt_msg_visitor_info.isEmpty())
      {
        paramList = paramList.rpt_msg_visitor_info.get();
        i = paramList.size();
        if (i > 0)
        {
          this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.a.jdField_a_of_type_JavaUtilList.clear();
          paramBoolean = false;
        }
      }
    }
    label358:
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.ownerUin);
        paramInt = 0;
        if (paramInt < i)
        {
          if (!((cmd0x897.VisitorInfo)paramList.get(paramInt)).uint64_visitor_uin.has()) {
            break label358;
          }
          long l2 = ((cmd0x897.VisitorInfo)paramList.get(paramInt)).uint64_visitor_uin.get();
          paramLong = ((cmd0x897.VisitorInfo)paramList.get(paramInt)).string_visitor_nick.get().toStringUtf8();
          int j = ((cmd0x897.VisitorInfo)paramList.get(paramInt)).uint32_role.get();
          localHashMap = new HashMap();
          localHashMap.put("memberUin", String.valueOf(l2));
          localHashMap.put("memberName", String.valueOf(paramLong));
          if (j == 0)
          {
            this.a.jdField_a_of_type_JavaUtilList.add(localHashMap);
            if (l1 != l2) {
              break label358;
            }
            paramBoolean = true;
            paramInt += 1;
            continue;
          }
        }
      }
      catch (Exception paramLong)
      {
        HashMap localHashMap;
        paramLong.printStackTrace();
        long l1 = 0L;
        continue;
        this.a.jdField_a_of_type_JavaUtilList.add(0, localHashMap);
        continue;
        this.a.c();
        if ((this.a.jdField_a_of_type_JavaLangBoolean == null) || ((!this.a.jdField_a_of_type_JavaLangBoolean.booleanValue()) && (paramBoolean == true)))
        {
          this.a.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramBoolean);
          this.a.a();
        }
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatSettingForHotChat", 2, "onDismissHotChat  isSuccess= " + paramBoolean + ",groupuin=" + paramString1 + ",result=" + paramInt + ",groupcode=" + paramString2);
    }
    if ((paramBoolean) && (paramInt == 0)) {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!this.a.isFinishing()))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("已解散该热聊房间");
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2130838452);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(false);
        this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new kyu(this), 1500L);
      }
    }
    while ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) || (this.a.isFinishing())) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("解散热聊房间失败");
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2130838442);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(false);
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new kyv(this), 1500L);
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, Long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatSettingForHotChat", 2, "onGetUserCreateHotChatAnnounce  isSuccess= " + paramBoolean + ",result=" + paramInt + ",memo=" + paramString2 + ",troopOwner=" + paramLong);
    }
    if ((paramBoolean) && (paramInt == 0))
    {
      if ((paramLong.longValue() > 0L) && (this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.ownerUin = String.valueOf(paramLong);
      }
      this.a.b();
      this.a.c();
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, String paramString3, List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatSettingForHotChat", 2, "onGetHotChatAnnounce  isSuccess= " + paramBoolean + ",result=" + paramInt + ",memo=" + paramString2 + ",jumpurl=" + paramString3);
    }
    if ((paramBoolean) && (paramInt == 0)) {
      this.a.b();
    }
  }
  
  protected void a(boolean paramBoolean, oidb_0x88d.GroupInfo paramGroupInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatSettingForHotChat", 2, "onGetHotChatInfo memberCount isSuccess= " + paramBoolean);
    }
    if ((paramBoolean) && (paramGroupInfo != null))
    {
      int i = paramGroupInfo.uint32_group_member_num.get() + paramGroupInfo.uint32_group_visitor_cur_num.get();
      this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memberCount = i;
      if (QLog.isColorLevel()) {
        QLog.d("ChatSettingForHotChat", 2, "onGetHotChatInfo memberCount isSuccess= " + paramBoolean + ",memberCount=" + i + ",membernum=" + paramGroupInfo.uint32_group_member_num.get() + ",visitornum=" + paramGroupInfo.uint32_group_visitor_cur_num.get());
      }
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(i + "人");
      this.a.jdField_a_of_type_AndroidViewView.setContentDescription("房间成员，  " + i + "人");
      this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatHandler.a(this.a.d, 0L, 0, true, new int[] { 10 });
      ThreadManager.b().post(new kyy(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kyt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */