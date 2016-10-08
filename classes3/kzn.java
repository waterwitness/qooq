import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.activity.TroopTagViewActivity;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.troop.activity.troopactivity.GroupInfoCardResp;

public class kzn
  extends Handler
{
  public kzn(ChatSettingForTroop paramChatSettingForTroop)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a.jdField_c_of_type_Boolean) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {}
    Object localObject2;
    Object localObject1;
    Object localObject3;
    Object localObject4;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramMessage.what == 1)
            {
              this.a.d();
              return;
            }
            if (paramMessage.what == 6)
            {
              if (QLog.isColorLevel()) {
                QLog.i("Q.chatopttroop", 2, "MSG_UPDATE_TROOP_MEMBER_CARD");
              }
              if (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard))
              {
                this.a.a(4, this.a.getResources().getString(2131365073), true);
                return;
              }
              this.a.a(4, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard, true);
              return;
            }
          } while (paramMessage.what == 12);
          if (paramMessage.what != 5) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.chatopttroop", 2, "MSG_UPDATE_INFO");
          }
          this.a.a(0, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + "人", true);
          this.a.u();
          this.a.a(true);
          this.a.f();
          this.a.a(this.a.jdField_c_of_type_JavaUtilList);
        } while (((this.a.ap != 1) && (!this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)) || (this.a.b == null) || (this.a.b.size() < this.a.at));
        paramMessage = (ImageView)this.a.b.get(this.a.at - 1);
      } while (((this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mMemberInvitingFlag) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())) && ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 3)));
      paramMessage.setVisibility(8);
      return;
      if (paramMessage.what != 10) {
        break;
      }
      paramMessage = paramMessage.getData();
      localObject2 = paramMessage.getStringArrayList("AVATAR_WALL_LIST");
      boolean bool = paramMessage.getBoolean("IS_DEFAULT_AVATAR");
      localObject1 = paramMessage.getStringArray("VERIFYING_PICTURE_LIST");
      paramMessage = (Message)localObject1;
      if (localObject1 == null) {
        paramMessage = new String[0];
      }
      paramMessage = new HashSet(Arrays.asList(paramMessage));
      localObject1 = new ArrayList();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          localObject4 = new AvatarWallAdapter.AvatarInfo();
          ((AvatarWallAdapter.AvatarInfo)localObject4).c = ((String)localObject3);
          ((AvatarWallAdapter.AvatarInfo)localObject4).d = "AVATAR_URL_STR";
          ((AvatarWallAdapter.AvatarInfo)localObject4).b = paramMessage.contains(localObject3);
          ((List)localObject1).add(localObject4);
        }
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a((List)localObject1, bool);
      }
    } while (this.a.jdField_h_of_type_Boolean);
    this.a.jdField_h_of_type_Boolean = true;
    this.a.t();
    return;
    if (paramMessage.what == 14)
    {
      this.a.t();
      return;
    }
    if (paramMessage.what == 13)
    {
      paramMessage = (ArrayList)paramMessage.obj;
      ChatSettingForTroop.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim(), paramMessage);
      this.a.a("Grp", "Clk_invite_new", "0");
      return;
    }
    if (paramMessage.what == 15)
    {
      ChatSettingForTroop.a(this.a, (troopactivity.GroupInfoCardResp)paramMessage.obj);
      return;
    }
    int i;
    if (paramMessage.what == 16)
    {
      localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags;
      localObject1 = new Intent(this.a, TroopTagViewActivity.class);
      ((Intent)localObject1).putExtra("troopuin", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      ((Intent)localObject1).putExtra("isAdmin", false);
      if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean != null) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean.a)))
      {
        paramMessage = "";
        if (!"其他".equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean.a)) {
          break label903;
        }
        if (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText)) {
          break label1748;
        }
        paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText;
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0) {
        ((Intent)localObject1).putExtra("subclass", paramMessage);
      }
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        paramMessage = new StringBuffer();
        localObject2 = ((List)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            paramMessage.append((String)localObject3 + "\n");
            continue;
            label903:
            paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean.a;
            i = 1;
            break;
          }
        }
        paramMessage.deleteCharAt(paramMessage.length() - 1);
        ((Intent)localObject1).putExtra("tags", paramMessage.toString());
      }
      ((Intent)localObject1).putExtra("act_type", 1);
      ((Intent)localObject1).putExtra("uin", this.a.app.a());
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
      {
        this.a.startActivityForResult((Intent)localObject1, 11);
        return;
      }
      this.a.startActivity((Intent)localObject1);
      return;
      if (paramMessage.what == 17)
      {
        paramMessage = paramMessage.getData();
        if (paramMessage == null) {
          break;
        }
        this.a.a(paramMessage.getLong("uin"), paramMessage.getString("uinname"), paramMessage.getString("extra_type"));
        return;
      }
      if (paramMessage.what == 18)
      {
        paramMessage = paramMessage.getData().getString("troopnick");
        localObject1 = (TextView)this.a.jdField_a_of_type_ArrayOfAndroidViewView[4].findViewById(2131297124);
        if ((!TextUtils.isEmpty(paramMessage)) && (!((TextView)localObject1).getText().equals(paramMessage)))
        {
          ((TextView)localObject1).setText(new QQText(paramMessage, 3));
          return;
        }
        if ((!TextUtils.isEmpty(paramMessage)) || (((TextView)localObject1).getText().equals(paramMessage))) {
          break;
        }
        ((TextView)localObject1).setText(new QQText(this.a.getResources().getString(2131365073), 3));
        return;
      }
      if (paramMessage.what == 19)
      {
        localObject4 = this.a.jdField_a_of_type_ArrayOfAndroidViewView[7];
        View localView = this.a.jdField_a_of_type_ArrayOfAndroidViewView[8];
        Switch localSwitch;
        if ((localView != null) && ((localObject4 instanceof FormSwitchItem)))
        {
          localObject2 = (FormSimpleItem)localView.findViewById(2131302583);
          localSwitch = ((FormSwitchItem)localObject4).a();
          localObject3 = (TextView)localView.findViewById(2131302584);
          localObject1 = "";
          paramMessage = "";
          Boolean localBoolean = (Boolean)this.a.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController.c.get(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          if ((localBoolean != null) && (localBoolean.booleanValue())) {
            break label1614;
          }
          if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
            break;
          }
          i = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopmask;
          if (i != 1) {
            break label1453;
          }
          ((View)localObject4).setBackgroundResource(2130840145);
          ((View)localObject4).getBackground().setAlpha(229);
          if (localSwitch.isChecked())
          {
            localSwitch.setTag(Boolean.TRUE);
            localSwitch.setChecked(false);
          }
          localView.setVisibility(8);
          paramMessage = "";
          localObject1 = "";
          this.a.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        for (;;)
        {
          ((FormSimpleItem)localObject2).setRightText(new QQText((CharSequence)localObject1, 3));
          ((FormSimpleItem)localObject2).b().setTextColor(this.a.getResources().getColor(2131427365));
          ((TextView)localObject3).setText(paramMessage);
          TroopAssistantManager.a().c(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          return;
          label1453:
          ((View)localObject4).setBackgroundResource(2130840146);
          ((View)localObject4).getBackground().setAlpha(229);
          if (!localSwitch.isChecked())
          {
            localSwitch.setTag(Boolean.TRUE);
            localSwitch.setChecked(true);
          }
          localView.setVisibility(0);
          switch (i)
          {
          default: 
            paramMessage = "";
            localObject1 = "";
            break;
          case 2: 
            localObject1 = this.a.getString(2131364690);
            paramMessage = this.a.getString(2131364700);
            break;
          case 3: 
            localObject1 = this.a.getString(2131369935);
            paramMessage = this.a.getString(2131364701);
            break;
          case 4: 
            localObject1 = this.a.getString(2131364689);
            paramMessage = this.a.getString(2131364699);
            break;
            label1614:
            localView.setVisibility(0);
            this.a.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
          }
        }
      }
      if (paramMessage.what != 20) {
        break;
      }
      paramMessage = PublicAccountConfigUtil.a(this.a.app, BaseApplicationImpl.getContext());
      DialogUtil.a(this.a, 230, String.format(this.a.getString(2131364753), new Object[] { paramMessage }), String.format(this.a.getString(2131364754), new Object[] { paramMessage }), this.a.getString(2131364755), this.a.getString(2131364756), new kzo(this), new DialogUtil.DialogOnClickAdapter()).show();
      return;
      label1748:
      i = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */