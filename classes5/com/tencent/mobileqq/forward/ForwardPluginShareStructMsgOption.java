package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.device.utils.LightAppUtil;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import slh;

public class ForwardPluginShareStructMsgOption
  extends ForwardBaseOption
{
  public static final String a = "ForwardOption.ForwardPluginShareStructMsgOption";
  public static final int b = 20001;
  public static final String g = "k_back";
  int c;
  String h;
  
  public ForwardPluginShareStructMsgOption(Intent paramIntent)
  {
    super(paramIntent);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void b(String paramString)
  {
    ThreadManager.a(new slh(this, paramString), 5, null, true);
  }
  
  public List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_c_of_type_Int == 13) || ("public_account".equals(this.h)) || ("web_share".equals(this.h)) || ("struct_msg_from_h5".equals(this.h)) || ("struct_favorite".equals(this.h)))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RecentUser localRecentUser = (RecentUser)paramList.next();
        if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && (!CrmUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin)) && (localRecentUser.type != 1020) && (localRecentUser.type != 1008) && (localRecentUser.type != 1005) && (localRecentUser.type != 1009) && (localRecentUser.type != 1021) && (localRecentUser.type != 1001) && (localRecentUser.type != 1022) && (localRecentUser.type != 1024) && (localRecentUser.type != 1025) && ((localRecentUser.type != 1006) || (a(ForwardAbility.ForwardAbilityType.i))) && (localRecentUser.type != 7000) && (localRecentUser.type != 9501) && (((localRecentUser.type == 0) && (a(jdField_b_of_type_JavaLangInteger))) || ((localRecentUser.type == 1) && (!a(localRecentUser.uin)) && (a(jdField_c_of_type_JavaLangInteger))) || ((localRecentUser.type == 3000) && (a(jdField_d_of_type_JavaLangInteger)) && (((localRecentUser.type != 1004) && (localRecentUser.type != 1000)) || (this.jdField_b_of_type_Boolean))))) {
          localArrayList.add(localRecentUser);
        }
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("shareQQType", 13);
    if (((i & 0x8) != 0) && (i())) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_d_of_type_JavaLangInteger);
    }
    if (((i & 0x4) != 0) && (j())) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_c_of_type_JavaLangInteger);
    }
    if (((i & 0x1) != 0) && (k())) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    if (super.m()) {
      this.jdField_a_of_type_JavaUtilSet.add(k);
    }
  }
  
  public void a(AbsStructMsg paramAbsStructMsg)
  {
    if ((paramAbsStructMsg == null) || (!(paramAbsStructMsg instanceof StructMsgForGeneralShare))) {}
    label98:
    label448:
    label453:
    label454:
    label459:
    for (;;)
    {
      return;
      paramAbsStructMsg = ((StructMsgForGeneralShare)paramAbsStructMsg).getStructMsgItemLists();
      if ((paramAbsStructMsg != null) && (paramAbsStructMsg.size() != 0))
      {
        paramAbsStructMsg = paramAbsStructMsg.iterator();
        Object localObject1;
        do
        {
          if (!paramAbsStructMsg.hasNext()) {
            break;
          }
          localObject1 = (AbsStructMsgElement)paramAbsStructMsg.next();
        } while (!(localObject1 instanceof StructMsgItemLayout2));
        for (paramAbsStructMsg = (StructMsgItemLayout2)localObject1;; paramAbsStructMsg = null)
        {
          if (paramAbsStructMsg == null) {
            break label459;
          }
          paramAbsStructMsg = paramAbsStructMsg.a;
          if ((paramAbsStructMsg == null) || (paramAbsStructMsg.size() == 0)) {
            break;
          }
          localObject1 = paramAbsStructMsg.iterator();
          paramAbsStructMsg = null;
          Object localObject2;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (AbsStructMsgElement)((Iterator)localObject1).next();
            if (!(localObject2 instanceof StructMsgItemSummary)) {
              break label453;
            }
            paramAbsStructMsg = (StructMsgItemSummary)localObject2;
          }
          for (;;)
          {
            break label98;
            if (paramAbsStructMsg == null) {
              break label454;
            }
            localObject1 = paramAbsStructMsg.b();
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break;
            }
            EmoticonManager localEmoticonManager = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
            StringBuilder localStringBuilder = new StringBuilder((String)localObject1);
            int i = 0;
            int j;
            int[] arrayOfInt;
            if (i < localStringBuilder.length())
            {
              j = i;
              if ('ÿ' == localStringBuilder.charAt(i))
              {
                j = i;
                if (i + 3 < localStringBuilder.length())
                {
                  localObject1 = new char[4];
                  localObject1[0] = localStringBuilder.charAt(i + 3);
                  localObject1[1] = localStringBuilder.charAt(i + 2);
                  localObject1[2] = localStringBuilder.charAt(i + 1);
                  localObject1[3] = localStringBuilder.charAt(i);
                  j = 0;
                  if (j < 4)
                  {
                    if (localObject1[j] == 'ú') {
                      localObject1[j] = 10;
                    }
                    for (;;)
                    {
                      j += 1;
                      break;
                      if (localObject1[j] == 'þ') {
                        localObject1[j] = 13;
                      } else if (localObject1[j] == 'ý') {
                        localObject1[j] = 20;
                      }
                    }
                  }
                  arrayOfInt = EmosmUtils.a((char[])localObject1);
                  localObject2 = "[小表情]";
                  if (localEmoticonManager == null) {
                    break label448;
                  }
                }
              }
            }
            for (localObject1 = localEmoticonManager.a(Integer.toString(arrayOfInt[0]), Integer.toString(arrayOfInt[1]));; localObject1 = null)
            {
              if (localObject1 != null) {}
              for (localObject1 = ((Emoticon)localObject1).character;; localObject1 = localObject2)
              {
                localStringBuilder.replace(i, i + 3, (String)localObject1);
                j = i + ((String)localObject1).length();
                i = j + 1;
                break;
                b(Integer.toString(arrayOfInt[0]));
              }
              if (TextUtils.isEmpty(localStringBuilder)) {
                break;
              }
              paramAbsStructMsg.a(localStringBuilder.toString());
              return;
            }
          }
          break;
        }
      }
    }
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ForwardPluginShareStructMsgOption preloadData");
    }
    super.a();
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("req_type", Integer.MAX_VALUE);
    this.h = this.jdField_a_of_type_AndroidOsBundle.getString("pluginName");
    this.e = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward _key_nojump", false);
    return true;
  }
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentIntent.getByteArrayExtra("stuctmsg_bytes");
    LinearLayout.LayoutParams localLayoutParams;
    if (localObject != null)
    {
      localObject = StructMsgFactory.a((byte[])localObject);
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      a((AbsStructMsg)localObject);
      if (!(localObject instanceof StructMsgForAudioShare)) {
        break label101;
      }
      localLayoutParams.setMargins(0, AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    }
    for (;;)
    {
      paramQQCustomDialog.addView(((AbsStructMsg)localObject).getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null), localLayoutParams);
      a(((AbsStructMsg)localObject).getSourceName(), paramQQCustomDialog);
      return true;
      label101:
      localLayoutParams.setMargins(AIOUtils.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    }
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    localObject = new LightAppUtil();
    int j = paramArrayOfDeviceInfo.length;
    int i = 0;
    while (i < j)
    {
      DeviceInfo localDeviceInfo = paramArrayOfDeviceInfo[i];
      if (localDeviceInfo != null)
      {
        LightAppSettingInfo localLightAppSettingInfo = ((LightAppUtil)localObject).a(localDeviceInfo);
        if ((a(k)) && (super.a(localLightAppSettingInfo))) {
          localArrayList.add(localDeviceInfo);
        }
      }
      i += 1;
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  protected int d()
  {
    String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("detail_url");
    if ((!TextUtils.isEmpty(str)) && (QfavBuilder.a(str).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null))) {}
    for (int i = 0;; i = -1)
    {
      if (i == 0) {
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_AddFav", -1, 0, 69, 0, "", "");
      }
      return i;
    }
  }
  
  protected void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ForwardPluginShareStructMsgOption forwardOnConfirm");
    }
    if (this.jdField_d_of_type_Boolean)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
      this.jdField_d_of_type_Boolean = false;
    }
    this.jdField_a_of_type_AndroidContentIntent.getAction();
    Object localObject1 = Boolean.valueOf(this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_flag_from_plugin", false));
    Object localObject3 = Boolean.valueOf(this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_back", false));
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ForwardPluginShareStructMsgOption forwardOnConfirm isFromPlugin=" + localObject1 + "iskeyBack=" + localObject3 + "isNOneedJumpToAIO=" + this.e);
    }
    Object localObject2;
    int i;
    Object localObject4;
    if (((Boolean)localObject1).booleanValue())
    {
      localObject2 = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), new int[] { 2 });
      i = c();
      localObject1 = "";
      if (i != 0) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getInputValue();
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("share_comment_message", (String)localObject1);
      ((Intent)localObject2).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      a((Intent)localObject2);
      if (((Boolean)localObject3).booleanValue())
      {
        localObject1 = StructMsgFactory.a(((Intent)localObject2).getExtras());
        if ((this.jdField_c_of_type_Int == 13) && ((localObject1 instanceof StructMsgForGeneralShare)))
        {
          localObject3 = (StructMsgForGeneralShare)localObject1;
          localObject4 = new StringBuilder(((Intent)localObject2).getStringExtra("struct_share_key_content_action_DATA"));
          ((StringBuilder)localObject4).append("&msg=").append(((Intent)localObject2).getStringExtra("title")).append("&toUin=").append(this.jdField_a_of_type_AndroidOsBundle.getString("uin"));
          ((StructMsgForGeneralShare)localObject3).mMsgActionData = ((StringBuilder)localObject4).toString();
        }
        ShareMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidOsBundle.getString("uin"), this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), (AbsStructMsg)localObject1, null);
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1);
        if (!"public_account".equals(this.h)) {
          break label679;
        }
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("pubUin");
        if (localObject1 != null) {
          break label800;
        }
        localObject1 = "";
      }
    }
    label454:
    label679:
    label800:
    for (;;)
    {
      int j;
      switch (this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"))
      {
      default: 
        i = -1;
        j = 0;
        if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_struct_forward", false))
        {
          if (this.jdField_a_of_type_AndroidContentIntent.getStringExtra("struct_uin") == null) {}
          localObject3 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("strurt_msgid");
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          localObject4 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("detail_url");
          localObject3 = localObject4;
          if (localObject4 == null) {
            localObject3 = "";
          }
          localObject4 = StructingMsgItemBuilder.a();
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005456", "0X8005456", 0, 0, (String)localObject4, (String)localObject2, (String)localObject3, "" + i);
        }
        PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, "Pb_account_lifeservice", "mp_msg_sys_11", "pbshare_success", j);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidAppActivity.finish();
        return;
        if (this.e)
        {
          localObject1 = ForwardUtils.a((Intent)localObject2);
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (SessionInfo)localObject1, (Intent)localObject2);
          break;
        }
        this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
        break;
        i = 1;
        j = 1001;
        break label454;
        i = 2;
        j = 1002;
        break label454;
        i = 3;
        j = 1003;
        break label454;
        if ("struct_msg_from_h5".equals(this.h))
        {
          localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("pubUin");
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, "Pb_account_lifeservice", "mp_msg_sys_31", "share_succ");
          }
        }
        else if ("Music_gene_aio".equals(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("report")))
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_AndroidOsBundle.getString("uin"), "Music_gene", "Music_gene_send", 0, 1, 0, "", "", "", "");
        }
      }
      p();
      return;
    }
  }
  
  protected void l()
  {
    super.l();
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_struct_forward", false)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005457", "0X8005457", 0, 0, "", "", "android", "");
    }
  }
  
  protected void t()
  {
    AbsStructMsg localAbsStructMsg = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle);
    if (localAbsStructMsg != null) {
      ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(this.jdField_a_of_type_AndroidOsBundle.getString("uin"), localAbsStructMsg);
    }
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\forward\ForwardPluginShareStructMsgOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */