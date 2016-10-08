package com.tencent.mobileqq.troopinfo;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.List;

public class TroopInfoData
  implements Serializable
{
  public static final String TAG = "TroopInfoData";
  private static final int a = 1;
  private static final int b = 2;
  private static final int c = 4;
  private static final int d = 8;
  public String Administrator;
  public boolean bAdmin;
  public boolean bOwner;
  public short cGroupOption;
  public byte cGroupRankSysFlag;
  public int cityId;
  public String currentTroopLocationStruct;
  public long dwAuthGroupType;
  public long dwGroupClassExt;
  public long dwGroupFlagExt;
  public boolean isMember;
  public int isShowInNearbyTroops;
  public boolean mMemberInvitingFlag;
  public int mNewGroupActivityNum;
  public int mNewTroopNotificationNum;
  public long mPoiId;
  public String mRichFingerMemo;
  public String mStrJoinAnswer;
  public String mStrJoinQuestion;
  public String mTroopClassExtText;
  public long mTroopCreateTime;
  public float mTroopNeedPayNumber;
  public int mTroopPrivilegeFlag;
  public int modifyCount;
  public int nActiveMemberNum;
  public int nGroupFlagExt;
  public int nNewFileMsgNum;
  public int nNewPhotoNum;
  public int nStatOption;
  public int nTroopGrade;
  public int nTroopMask;
  public int nTroopMaskToSet;
  public int nUnreadFileMsgnum;
  public int nUnreadMsgNum;
  private int nViewExtraFlag;
  public int pa;
  public long publicAccountUin;
  public String remark;
  public long tribeId;
  public String tribeName;
  public int tribeStatus;
  public String troopAuthen;
  public String troopAuthenticateInfo;
  public String troopCard;
  public String troopClass;
  public String troopCode;
  public long troopInterestId;
  public String troopInterestName;
  public String troopIntro;
  public int troopLat;
  public String troopLocation;
  public int troopLon;
  public String troopMemberMaxNum;
  public String troopMemo;
  public String troopName;
  public String troopOwnerNick;
  public List troopPhotos;
  public List troopTags;
  public int troopTypeExt;
  public String troopUin;
  public short troopface;
  public String troopowneruin;
  public int wMemberNum;
  
  public TroopInfoData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.dwGroupClassExt = -1L;
    this.mTroopNeedPayNumber = 0.0F;
    this.isShowInNearbyTroops = -1;
    this.currentTroopLocationStruct = "";
    this.troopTypeExt = -1;
    this.modifyCount = 5;
    this.nViewExtraFlag |= 0x4;
    this.nViewExtraFlag |= 0x2;
  }
  
  public boolean canInviteMember()
  {
    return (this.bOwner) || (this.bAdmin) || (this.mMemberInvitingFlag);
  }
  
  public int getStatOption()
  {
    if (this.nStatOption == 0) {
      switch (this.pa)
      {
      }
    }
    for (;;)
    {
      return this.nStatOption;
      this.nStatOption = 10;
      continue;
      this.nStatOption = 11;
      continue;
      this.nStatOption = 12;
      continue;
      this.nStatOption = 26;
      continue;
      this.nStatOption = 14;
      continue;
      this.nStatOption = 19;
      continue;
      this.nStatOption = 21;
      continue;
      this.nStatOption = 31;
      continue;
      this.nStatOption = 3;
      continue;
      this.nStatOption = 24;
      continue;
      this.nStatOption = 18;
      continue;
      this.nStatOption = 13;
      continue;
      this.nStatOption = 15;
      continue;
      this.nStatOption = 30;
      continue;
      this.nStatOption = 38;
    }
  }
  
  public String getTroopOwnerName()
  {
    if (!TextUtils.isEmpty(this.troopOwnerNick)) {}
    for (String str1 = this.troopOwnerNick;; str1 = this.troopowneruin)
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1)) {
        str2 = "";
      }
      return str2;
    }
  }
  
  public boolean isFetchedTroopOwnerUin()
  {
    return !TextUtils.isEmpty(this.troopowneruin);
  }
  
  public boolean isHideTroop()
  {
    return (this.dwGroupFlagExt & 0x10000000) == 268435456L;
  }
  
  public boolean isOwnerOrAdim()
  {
    return (this.bOwner) || (this.bAdmin);
  }
  
  public boolean isPhotoAndFileVisible()
  {
    return ((this.nGroupFlagExt & 0x80000) != 0) || ((this.nGroupFlagExt & 0x4000) != 0);
  }
  
  public boolean isShowActivityGrade()
  {
    return (this.dwGroupFlagExt & 0x800000) == 8388608L;
  }
  
  public boolean isShowInNearbyTroops()
  {
    if (this.isShowInNearbyTroops == -1) {
      if ((this.dwGroupFlagExt & 0x8000000) == 134217728L) {}
    }
    while (this.isShowInNearbyTroops == 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public boolean isTroopAPPVisible()
  {
    return (this.nViewExtraFlag & 0x8) == 8;
  }
  
  public boolean isTroopBBSVisible()
  {
    return (this.nViewExtraFlag & 0x1) == 1;
  }
  
  public boolean isTroopFileVisible()
  {
    return (this.nViewExtraFlag & 0x2) == 2;
  }
  
  public boolean isTroopPhotosVisible()
  {
    return (this.nViewExtraFlag & 0x4) == 4;
  }
  
  public void setTroopAppVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.nViewExtraFlag |= 0x8;
      return;
    }
    this.nViewExtraFlag &= 0xFFFFFFF7;
  }
  
  public void setTroopBBSVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.nViewExtraFlag |= 0x1;
      return;
    }
    this.nViewExtraFlag &= 0xFFFFFFFE;
  }
  
  public void setTroopFileVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.nViewExtraFlag |= 0x2;
      return;
    }
    this.nViewExtraFlag &= 0xFFFFFFFD;
  }
  
  public void updateAdminFlag(String paramString)
  {
    if (paramString.equals(this.troopowneruin)) {
      this.bAdmin = true;
    }
    for (;;)
    {
      return;
      if ((!this.bAdmin) && (!TextUtils.isEmpty(this.Administrator)))
      {
        String[] arrayOfString = this.Administrator.split("\\|");
        if (arrayOfString == null) {
          break;
        }
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          if (arrayOfString[i].equalsIgnoreCase(paramString))
          {
            this.bAdmin = true;
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  public void updateForTroopChatSetting(TroopInfo paramTroopInfo, Resources paramResources, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopInfoData", 2, "updateTroopInfoData(), troopinfo = " + paramTroopInfo);
    }
    long l = System.currentTimeMillis();
    if (paramTroopInfo != null)
    {
      this.troopCode = paramTroopInfo.troopcode;
      this.troopface = paramTroopInfo.troopface;
      this.troopName = paramTroopInfo.troopname;
      this.cGroupOption = paramTroopInfo.cGroupOption;
      this.troopMemo = paramTroopInfo.troopmemo;
      this.troopIntro = paramTroopInfo.fingertroopmemo;
      this.mRichFingerMemo = paramTroopInfo.mRichFingerMemo;
      this.dwGroupClassExt = paramTroopInfo.dwGroupClassExt;
      this.mTroopCreateTime = paramTroopInfo.troopCreateTime;
      this.wMemberNum = paramTroopInfo.wMemberNum;
      this.troopMemberMaxNum = String.format(paramResources.getString(2131369422), new Object[] { Integer.valueOf(paramTroopInfo.wMemberMax) });
      this.mStrJoinQuestion = paramTroopInfo.joinTroopQuestion;
      this.mStrJoinAnswer = paramTroopInfo.joinTroopAnswer;
      this.mTroopPrivilegeFlag = ((int)paramTroopInfo.troopPrivilegeFlag);
      this.mTroopNeedPayNumber = paramTroopInfo.mTroopNeedPayNumber;
      this.publicAccountUin = paramTroopInfo.associatePubAccount;
      if ((!TroopInfo.hasPayPrivilege(paramTroopInfo.troopPrivilegeFlag, 128)) || (!TroopInfo.hasPayPrivilege(paramTroopInfo.troopPrivilegeFlag, 512))) {
        break label499;
      }
      this.troopAuthen = paramResources.getString(2131367920);
      if (!Utils.a(this.troopowneruin, paramTroopInfo.troopowneruin))
      {
        this.troopowneruin = paramTroopInfo.troopowneruin;
        this.troopOwnerNick = null;
        updateOwnerFlag(paramString);
      }
      if (!Utils.a(this.Administrator, paramTroopInfo.Administrator))
      {
        this.Administrator = paramTroopInfo.Administrator;
        updateAdminFlag(paramString);
      }
      if ((!this.bOwner) && ((paramTroopInfo.dwAdditionalFlag & 1L) == 1L)) {
        this.bOwner = true;
      }
      if ((!this.bAdmin) && ((paramTroopInfo.dwCmdUinUinFlag & 1L) == 1L)) {
        this.bAdmin = true;
      }
      this.mMemberInvitingFlag = paramTroopInfo.mMemberInvitingFlag;
      this.troopface = paramTroopInfo.troopface;
      this.cGroupRankSysFlag = paramTroopInfo.cGroupRankSysFlag;
      if (paramTroopInfo.cAlbumResult != 33) {
        break label609;
      }
    }
    label499:
    label609:
    for (this.nViewExtraFlag &= 0xFFFFFFFB;; this.nViewExtraFlag |= 0x4)
    {
      this.troopPhotos = paramTroopInfo.getQZonePhotoUrls();
      this.dwGroupFlagExt = paramTroopInfo.dwGroupFlagExt;
      this.troopAuthenticateInfo = paramTroopInfo.troopAuthenticateInfo;
      this.dwAuthGroupType = paramTroopInfo.dwAuthGroupType;
      this.nTroopGrade = paramTroopInfo.nTroopGrade;
      this.troopLocation = paramTroopInfo.strLocation;
      if ((paramTroopInfo.troopLat != 0) && (paramTroopInfo.troopLon != 0))
      {
        this.troopLat = paramTroopInfo.troopLat;
        this.troopLon = paramTroopInfo.troopLon;
      }
      this.isShowInNearbyTroops = paramTroopInfo.isShowInNearbyTroops;
      if (QLog.isColorLevel()) {
        QLog.i("TroopInfoData", 2, "updateTroopInfoData: time = " + (System.currentTimeMillis() - l));
      }
      return;
      switch (paramTroopInfo.cGroupOption)
      {
      default: 
        break;
      case 1: 
        this.troopAuthen = paramResources.getString(2131367918);
        break;
      case 2: 
        this.troopAuthen = paramResources.getString(2131367919);
        break;
      case 4: 
        this.troopAuthen = paramResources.getString(2131367922);
        break;
      case 5: 
        this.troopAuthen = paramResources.getString(2131367923);
        break;
      case 3: 
        this.troopAuthen = paramResources.getString(2131367921);
        break;
      }
    }
  }
  
  public void updateForTroopInfo(TroopInfo paramTroopInfo, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopInfoData", 2, "updateTroopInfoData(), troopinfo = " + paramTroopInfo);
    }
    long l = System.currentTimeMillis();
    if (paramTroopInfo != null)
    {
      this.troopCode = paramTroopInfo.troopcode;
      this.troopface = paramTroopInfo.troopface;
      this.troopName = paramTroopInfo.troopname;
      this.cGroupOption = paramTroopInfo.cGroupOption;
      this.mStrJoinQuestion = paramTroopInfo.joinTroopQuestion;
      this.mStrJoinAnswer = paramTroopInfo.joinTroopAnswer;
      this.troopMemo = paramTroopInfo.troopmemo;
      this.troopIntro = paramTroopInfo.fingertroopmemo;
      this.mRichFingerMemo = paramTroopInfo.mRichFingerMemo;
      if ((this.troopClass == null) || (this.dwGroupClassExt != paramTroopInfo.dwGroupClassExt))
      {
        this.dwGroupClassExt = paramTroopInfo.dwGroupClassExt;
        this.troopClass = null;
      }
      if (this.mTroopClassExtText == null) {
        this.mTroopClassExtText = paramTroopInfo.mGroupClassExtText;
      }
      if (!Utils.a(this.troopowneruin, paramTroopInfo.troopowneruin))
      {
        this.troopowneruin = paramTroopInfo.troopowneruin;
        this.troopOwnerNick = null;
        updateOwnerFlag(paramString);
      }
      if (!Utils.a(this.Administrator, paramTroopInfo.Administrator))
      {
        this.Administrator = paramTroopInfo.Administrator;
        updateAdminFlag(paramString);
      }
      if ((!this.bOwner) && ((paramTroopInfo.dwAdditionalFlag & 1L) == 1L)) {
        this.bOwner = true;
      }
      if ((!this.bAdmin) && ((paramTroopInfo.dwCmdUinUinFlag & 1L) == 1L)) {
        this.bAdmin = true;
      }
      this.troopLocation = paramTroopInfo.strLocation;
      if ((paramTroopInfo.troopLat != 0) && (paramTroopInfo.troopLon != 0))
      {
        this.troopLat = paramTroopInfo.troopLat;
        this.troopLon = paramTroopInfo.troopLon;
      }
      this.dwGroupFlagExt = paramTroopInfo.dwGroupFlagExt;
      this.troopAuthenticateInfo = paramTroopInfo.troopAuthenticateInfo;
      this.dwAuthGroupType = paramTroopInfo.dwAuthGroupType;
      this.mTroopPrivilegeFlag = ((int)paramTroopInfo.troopPrivilegeFlag);
      this.mTroopNeedPayNumber = paramTroopInfo.mTroopNeedPayNumber;
      this.troopTags = TroopInfo.getTags(paramTroopInfo.mTags);
      this.isShowInNearbyTroops = paramTroopInfo.isShowInNearbyTroops;
      this.troopTypeExt = paramTroopInfo.troopTypeExt;
      this.wMemberNum = paramTroopInfo.wMemberNum;
      this.publicAccountUin = paramTroopInfo.associatePubAccount;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopInfoData", 2, "updateTroopInfoData: time = " + (System.currentTimeMillis() - l));
    }
  }
  
  public void updateOwnerFlag(String paramString)
  {
    this.bOwner = Utils.a(paramString, this.troopowneruin);
    if (this.bOwner) {
      this.bAdmin = true;
    }
  }
  
  public void updateTroopAdmMemberNum(String paramString1, int paramInt, String paramString2, Resources paramResources)
  {
    this.Administrator = paramString1;
    updateAdminFlag(paramString2);
    this.wMemberNum = paramInt;
  }
  
  public void updateTroopOwner(String paramString1, String paramString2)
  {
    this.troopowneruin = paramString1;
    this.troopOwnerNick = null;
    updateAdminFlag(paramString2);
    updateOwnerFlag(paramString2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troopinfo\TroopInfoData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */