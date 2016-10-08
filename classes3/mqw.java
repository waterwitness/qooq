import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class mqw
  extends Handler
{
  public mqw(TroopInfoActivity paramTroopInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    if (paramMessage.what == 1)
    {
      this.a.f();
      return;
    }
    if (paramMessage.what == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "MSG_UPDATE_TROOP_OWNER_NAME");
      }
      this.a.a(2, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getTroopOwnerName(), this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isFetchedTroopOwnerUin());
      return;
    }
    if (paramMessage.what == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "MSG_UPDATE_INFO");
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) != 0L) {
        this.a.a(7, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthenticateInfo, false);
      }
      this.a.a(2, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopOwnerNick, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isFetchedTroopOwnerUin());
      if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopOwnerNick == null) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin))) {
        TroopInfoActivity.c(this.a);
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) && ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) == 0L))
      {
        this.a.a(3, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, bool);
        this.a.k();
        if (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
          break label335;
        }
      }
      label335:
      for (paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;; paramMessage = this.a.getResources().getString(2131367329))
      {
        this.a.a(6, paramMessage, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopClass == null) {
          TroopInfoActivity.d(this.a);
        }
        this.a.m();
        return;
        bool = false;
        break;
      }
    }
    if (paramMessage.what == 5)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "MSG_UPDATE_TROOP_CLASS");
      }
      this.a.a(4, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopClass, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      return;
    }
    if (paramMessage.what == 6)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "MSG_UPDATE_TROOP_TAGS");
      }
      paramMessage = TroopInfoActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
      this.a.a(8, paramMessage, true, 2, true);
      return;
    }
    if (paramMessage.what == 9)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "MSG_UPDATE_TROOP_INTEREST");
      }
      paramMessage = new ArrayList();
      if (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeName)) {
        paramMessage.add(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeName);
      }
      this.a.a(9, paramMessage, true, 1, true);
      TroopInfoActivity.e(this.a);
      return;
    }
    if (paramMessage.what == 10)
    {
      TroopInfoActivity.e(this.a);
      return;
    }
    Object localObject;
    if (paramMessage.what == 8)
    {
      paramMessage = paramMessage.getData();
      localObject = paramMessage.getStringArrayList("AVATAR_WALL_LIST");
      bool = paramMessage.getBoolean("IS_DEFAULT_AVATAR");
      paramMessage = paramMessage.getStringArray("VERIFYING_PICTURE_LIST");
      if (paramMessage != null) {
        break label732;
      }
      paramMessage = new String[0];
    }
    label732:
    for (;;)
    {
      paramMessage = new HashSet(Arrays.asList(paramMessage));
      ArrayList localArrayList = new ArrayList();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          AvatarWallAdapter.AvatarInfo localAvatarInfo = new AvatarWallAdapter.AvatarInfo();
          localAvatarInfo.c = str;
          localAvatarInfo.d = "AVATAR_URL_STR";
          localAvatarInfo.b = paramMessage.contains(str);
          localArrayList.add(localAvatarInfo);
        }
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter == null) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(localArrayList, bool);
      return;
      if (paramMessage.what != 11) {
        break;
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mqw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */