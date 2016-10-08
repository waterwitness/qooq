package com.tencent.mobileqq.data;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import friendlist.stLevelRankPair;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import tencent.im.oidb.cmd0x787.oidb_0x787.LevelName;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupHeadPortrait;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupHeadPortraitInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.TagRecord;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.cmd0x8fd.Oidb_0x8fd.LevelName;

public class TroopInfo
  extends Entity
  implements Serializable
{
  public static final int DEL_PIC_REQ = 2;
  public static final int MODIFY_ORDER = 0;
  public static final int PAY_CHOICE_PAY_TO_JOIN_TROOP = 512;
  public static final int PAY_PRIVILEGE_ALL = 448;
  public static final int PAY_PRIVILEGE_DELIVER_GIFT = 32;
  public static final int PAY_PRIVILEGE_GIFT_SETTLEMENT_ABILITY = 256;
  public static final int PAY_PRIVILEGE_GROUP_FEE = 64;
  public static final int PAY_PRIVILEGE_PAY_TO_JOIN_TROOP = 128;
  public static final int SET_DEFAULT_PIC = 1;
  public String Administrator;
  public String adminNameShow;
  public long associatePubAccount;
  public byte cAlbumResult;
  public short cGroupLevel;
  public short cGroupOption;
  public byte cGroupRankSysFlag;
  public byte cGroupRankUserFlag;
  public long dwAdditionalFlag;
  public long dwAppPrivilegeFlag;
  public long dwAuthGroupType;
  public long dwCmdUinUinFlag;
  public long dwGagTimeStamp;
  public long dwGagTimeStamp_me;
  public long dwGroupClassExt;
  public long dwGroupFlag;
  public long dwGroupFlagExt;
  public long dwGroupInfoSeq;
  public long dwGroupLevelSeq;
  public long dwOfficeMode;
  public long dwTimeStamp;
  public String fingertroopmemo;
  public int isShowInNearbyTroops;
  public String joinTroopAnswer;
  public String joinTroopQuestion;
  HashMap mCachedLevelMap;
  public int mComparePartInt;
  public String mCompareSpell;
  public String mGroupClassExtText;
  public long mMemberCardSeq;
  public boolean mMemberInvitingFlag;
  public long mMemberNumSeq;
  public long mOldMemberCardSeq;
  public long mOldMemberNumSeq;
  public int mQZonePhotoNum;
  public String mRichFingerMemo;
  public String mSomeMemberUins;
  public String mTags;
  public int mTribeStatus;
  public int mTroopAvatarId;
  public int mTroopFileVideoIsWhite;
  public long mTroopFileVideoReqInterval;
  public float mTroopNeedPayNumber;
  public List mTroopPicList;
  public Set mTroopVerifyingPics;
  public int maxAdminNum;
  public int nTroopGrade;
  public String ownerNameShow;
  public String strLocation;
  public String strQZonePhotoUrls;
  public long timeSec;
  public String topicId;
  public String troopAuthenticateInfo;
  public long troopCreateTime;
  public long troopCreditLevel;
  public long troopCreditLevelInfo;
  public int troopLat;
  public String troopLevelMap;
  public int troopLon;
  public long troopPrivilegeFlag;
  public int troopTypeExt;
  public String troopcode;
  public short troopface;
  public int troopmask;
  public String troopmemo;
  public String troopname;
  public String troopowneruin;
  public int trooptype;
  @unique
  public String troopuin;
  public String uin;
  public int wMemberMax;
  public int wMemberNum;
  public int wSpecialClass;
  
  public TroopInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.troopmask = -1;
    this.mMemberNumSeq = -1L;
    this.mOldMemberNumSeq = -1L;
    this.mMemberCardSeq = -1L;
    this.mOldMemberCardSeq = -1L;
    this.isShowInNearbyTroops = -1;
    this.troopTypeExt = -1;
    this.mTroopNeedPayNumber = 0.0F;
    this.troopCreditLevel = 5L;
  }
  
  public static List getTags(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("\n");
      int i = 0;
      while (i < paramString.length)
      {
        localArrayList.add(paramString[i]);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static boolean hasPayPrivilege(long paramLong, int paramInt)
  {
    return ((0x20 | paramLong) & paramInt) != 0L;
  }
  
  public static final boolean isTroopMember(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(51);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.a(paramString) != null;
    }
    return false;
  }
  
  public static boolean isVisitorSpeakEnabled(int paramInt)
  {
    return (paramInt & 0x2000) == 8192;
  }
  
  public static List setAvatarPicId(oidb_0x88d.GroupHeadPortrait paramGroupHeadPortrait)
  {
    if (paramGroupHeadPortrait.uint32_pic_cnt.get() != paramGroupHeadPortrait.rpt_msg_info.size()) {}
    ArrayList localArrayList = new ArrayList();
    paramGroupHeadPortrait = paramGroupHeadPortrait.rpt_msg_info.get().iterator();
    while (paramGroupHeadPortrait.hasNext()) {
      localArrayList.add(String.valueOf(((oidb_0x88d.GroupHeadPortraitInfo)paramGroupHeadPortrait.next()).rpt_uint32_pic_id.get()));
    }
    return localArrayList;
  }
  
  public static String setTags(List paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if ((paramList != null) && (paramList.size() > 0))
    {
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          paramList = (oidb_0x88d.TagRecord)localIterator.next();
          if (!paramList.bytes_tag_value.has()) {
            continue;
          }
          paramList = paramList.bytes_tag_value.get().toStringUtf8();
          try
          {
            paramList = new String(paramList.getBytes("utf-8"));
            localStringBuffer.append(paramList + "\n");
          }
          catch (UnsupportedEncodingException paramList)
          {
            for (;;)
            {
              paramList.printStackTrace();
              paramList = "";
            }
          }
        }
      }
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    }
    return localStringBuffer.toString();
  }
  
  public static Set setVerifyingAvatarPicId(oidb_0x88d.GroupHeadPortrait paramGroupHeadPortrait)
  {
    int i = paramGroupHeadPortrait.uint32_verifying_pic_cnt.get();
    int j = paramGroupHeadPortrait.rpt_msg_verifyingpic_info.size();
    if ((i != j) && (QLog.isColorLevel())) {
      QLog.d("TroopInfo", 2, String.format("wrong data from server! uint32_verifying_pic_cnt = %d not equals rpt_msg_verifyingpic_info's size = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
    }
    HashSet localHashSet = new HashSet();
    paramGroupHeadPortrait = paramGroupHeadPortrait.rpt_msg_verifyingpic_info.get().iterator();
    while (paramGroupHeadPortrait.hasNext()) {
      localHashSet.add(String.valueOf(((oidb_0x88d.GroupHeadPortraitInfo)paramGroupHeadPortrait.next()).rpt_uint32_pic_id.get()));
    }
    return localHashSet;
  }
  
  protected static String troopLevelMapToString(HashMap paramHashMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramHashMap.size();
    paramHashMap = paramHashMap.entrySet().iterator();
    int i = 0;
    while (paramHashMap.hasNext())
    {
      Object localObject = (Map.Entry)paramHashMap.next();
      int k = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      localObject = (String)((Map.Entry)localObject).getValue();
      localStringBuilder.append(k).append("\000").append((String)localObject);
      if (i != j - 1) {
        localStringBuilder.append("\001");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public void coverAdministrators(QQAppInterface paramQQAppInterface, ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramQQAppInterface == null)) {
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      localStringBuffer.append(str + "|");
    }
    this.Administrator = localStringBuffer.toString();
    ((TroopManager)paramQQAppInterface.getManager(51)).b(this);
  }
  
  protected boolean entityByCursor(Cursor paramCursor)
  {
    this.Administrator = paramCursor.getString(paramCursor.getColumnIndex("Administrator"));
    this.cAlbumResult = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cAlbumResult")));
    this.cGroupLevel = paramCursor.getShort(paramCursor.getColumnIndex("cGroupLevel"));
    this.cGroupOption = paramCursor.getShort(paramCursor.getColumnIndex("cGroupOption"));
    this.cGroupRankSysFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cGroupRankSysFlag")));
    this.cGroupRankUserFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cGroupRankUserFlag")));
    this.dwAdditionalFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("dwAdditionalFlag")));
    this.dwAuthGroupType = paramCursor.getLong(paramCursor.getColumnIndex("dwAuthGroupType"));
    this.dwCmdUinUinFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwCmdUinUinFlag"));
    this.dwGagTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("dwGagTimeStamp"));
    this.dwGagTimeStamp_me = paramCursor.getLong(paramCursor.getColumnIndex("dwGagTimeStamp_me"));
    this.dwGroupClassExt = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupClassExt"));
    this.dwGroupFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlag"));
    this.dwGroupFlagExt = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlagExt"));
    this.dwGroupInfoSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupInfoSeq"));
    this.dwGroupLevelSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupLevelSeq"));
    this.dwTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("dwTimeStamp"));
    this.fingertroopmemo = paramCursor.getString(paramCursor.getColumnIndex("fingertroopmemo"));
    this.isShowInNearbyTroops = paramCursor.getInt(paramCursor.getColumnIndex("isShowInNearbyTroops"));
    this.joinTroopAnswer = paramCursor.getString(paramCursor.getColumnIndex("joinTroopAnswer"));
    this.joinTroopQuestion = paramCursor.getString(paramCursor.getColumnIndex("joinTroopQuestion"));
    this.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
    this.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
    this.mGroupClassExtText = paramCursor.getString(paramCursor.getColumnIndex("mGroupClassExtText"));
    boolean bool;
    if (paramCursor.getInt(paramCursor.getColumnIndex("mMemberInvitingFlag")) == 1) {
      bool = true;
    }
    for (;;)
    {
      this.mMemberInvitingFlag = bool;
      this.mQZonePhotoNum = paramCursor.getInt(paramCursor.getColumnIndex("mQZonePhotoNum"));
      this.mRichFingerMemo = paramCursor.getString(paramCursor.getColumnIndex("mRichFingerMemo"));
      this.mSomeMemberUins = paramCursor.getString(paramCursor.getColumnIndex("mSomeMemberUins"));
      this.mTags = paramCursor.getString(paramCursor.getColumnIndex("mTags"));
      this.mTroopAvatarId = paramCursor.getInt(paramCursor.getColumnIndex("mTroopAvatarId"));
      this.maxAdminNum = paramCursor.getInt(paramCursor.getColumnIndex("maxAdminNum"));
      this.nTroopGrade = paramCursor.getInt(paramCursor.getColumnIndex("nTroopGrade"));
      this.strLocation = paramCursor.getString(paramCursor.getColumnIndex("strLocation"));
      this.strQZonePhotoUrls = paramCursor.getString(paramCursor.getColumnIndex("strQZonePhotoUrls"));
      this.timeSec = paramCursor.getLong(paramCursor.getColumnIndex("timeSec"));
      this.troopAuthenticateInfo = paramCursor.getString(paramCursor.getColumnIndex("troopAuthenticateInfo"));
      this.troopCreateTime = paramCursor.getLong(paramCursor.getColumnIndex("troopCreateTime"));
      this.troopLat = paramCursor.getInt(paramCursor.getColumnIndex("troopLat"));
      this.troopLevelMap = paramCursor.getString(paramCursor.getColumnIndex("troopLevelMap"));
      this.troopLon = paramCursor.getInt(paramCursor.getColumnIndex("troopLon"));
      this.troopTypeExt = paramCursor.getInt(paramCursor.getColumnIndex("troopTypeExt"));
      this.troopcode = paramCursor.getString(paramCursor.getColumnIndex("troopcode"));
      this.troopface = paramCursor.getShort(paramCursor.getColumnIndex("troopface"));
      this.troopmask = paramCursor.getInt(paramCursor.getColumnIndex("troopmask"));
      this.troopmemo = paramCursor.getString(paramCursor.getColumnIndex("troopmemo"));
      this.troopname = paramCursor.getString(paramCursor.getColumnIndex("troopname"));
      this.troopowneruin = paramCursor.getString(paramCursor.getColumnIndex("troopowneruin"));
      this.trooptype = paramCursor.getInt(paramCursor.getColumnIndex("trooptype"));
      this.troopuin = paramCursor.getString(paramCursor.getColumnIndex("troopuin"));
      this.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      this.wMemberMax = paramCursor.getInt(paramCursor.getColumnIndex("wMemberMax"));
      this.wMemberNum = paramCursor.getInt(paramCursor.getColumnIndex("wMemberNum"));
      this.wSpecialClass = paramCursor.getInt(paramCursor.getColumnIndex("wSpecialClass"));
      this.troopPrivilegeFlag = paramCursor.getLong(paramCursor.getColumnIndex("troopPrivilegeFlag"));
      this.associatePubAccount = paramCursor.getLong(paramCursor.getColumnIndex("associatePubAccount"));
      this.mTroopNeedPayNumber = paramCursor.getFloat(paramCursor.getColumnIndex("mTroopNeedPayNumber"));
      this.dwOfficeMode = paramCursor.getLong(paramCursor.getColumnIndex("dwOfficeMode"));
      this.mMemberCardSeq = paramCursor.getLong(paramCursor.getColumnIndex("mMemberCardSeq"));
      this.mOldMemberCardSeq = paramCursor.getLong(paramCursor.getColumnIndex("mOldMemberCardSeq"));
      this.mMemberNumSeq = paramCursor.getLong(paramCursor.getColumnIndex("mMemberNumSeq"));
      this.mOldMemberNumSeq = paramCursor.getLong(paramCursor.getColumnIndex("mOldMemberNumSeq"));
      try
      {
        this.ownerNameShow = paramCursor.getString(paramCursor.getColumnIndex("ownerNameShow"));
        this.adminNameShow = paramCursor.getString(paramCursor.getColumnIndex("adminNameShow"));
        this.dwAppPrivilegeFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwAppPrivilegeFlag"));
        this.topicId = paramCursor.getString(paramCursor.getColumnIndex("topicId"));
        int i = paramCursor.getColumnIndex("troopCreditLevel");
        if (i >= 0) {
          this.troopCreditLevel = paramCursor.getLong(i);
        }
        i = paramCursor.getColumnIndex("troopCreditLevelInfo");
        if (i >= 0) {
          this.troopCreditLevelInfo = paramCursor.getLong(i);
        }
        return true;
        bool = false;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public int getAdminCount()
  {
    int j = 0;
    if (this.Administrator != null)
    {
      String[] arrayOfString = this.Administrator.split("\\|");
      for (int i = 0;; i = k)
      {
        k = i;
        if (j >= arrayOfString.length) {
          break;
        }
        k = i;
        if (!TextUtils.isEmpty(arrayOfString[j])) {
          k = i + 1;
        }
        j += 1;
      }
    }
    int k = 0;
    return k;
  }
  
  public String getAdminShow(Context paramContext)
  {
    if (TextUtils.isEmpty(this.adminNameShow)) {
      return paramContext.getString(2131367401);
    }
    return this.adminNameShow;
  }
  
  public String getOwnerOrAdminString(String paramString, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (paramString.equals(this.troopowneruin)) {
        return getOwnerShow(paramContext);
      }
    } while ((this.Administrator == null) || (!this.Administrator.contains(paramString)));
    return getAdminShow(paramContext);
  }
  
  public String getOwnerShow(Context paramContext)
  {
    if (TextUtils.isEmpty(this.ownerNameShow)) {
      return paramContext.getString(2131367400);
    }
    return this.ownerNameShow;
  }
  
  public String getPercentage()
  {
    return "66";
  }
  
  public ArrayList getQZonePhotoUrls()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.strQZonePhotoUrls != null)
    {
      String[] arrayOfString = this.strQZonePhotoUrls.split(";");
      localObject1 = localObject2;
      if (arrayOfString != null)
      {
        localObject1 = localObject2;
        if (arrayOfString.length > 0)
        {
          localObject1 = new ArrayList();
          int i = 0;
          while (i < arrayOfString.length)
          {
            if ((arrayOfString[i] != null) && (arrayOfString[i].length() > 0)) {
              ((ArrayList)localObject1).add(arrayOfString[i]);
            }
            i += 1;
          }
        }
      }
    }
    return (ArrayList)localObject1;
  }
  
  public List getSomeMemberUins()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.mSomeMemberUins != null) && (this.mSomeMemberUins.length() > 0))
    {
      int j = 0;
      int i = this.mSomeMemberUins.indexOf('|', 0);
      int k = this.mSomeMemberUins.length();
      String str2;
      String str1;
      while ((i >= j) && (i < k))
      {
        if (j < i)
        {
          str2 = this.mSomeMemberUins.substring(j, i);
          str1 = str2;
          if (str2 != null) {
            str1 = str2.trim();
          }
          if ((str1 != null) && (str1.length() > 0)) {
            localArrayList.add(str1);
          }
        }
        j = i + 1;
        i = this.mSomeMemberUins.indexOf('|', j);
      }
      if (j < k)
      {
        str2 = this.mSomeMemberUins.substring(j, k);
        str1 = str2;
        if (str2 != null) {
          str1 = str2.trim();
        }
        if ((str1 != null) && (str1.length() > 0)) {
          localArrayList.add(str1);
        }
      }
    }
    return localArrayList;
  }
  
  public HashMap getTroopLevelMap()
  {
    int i = 0;
    if (this.mCachedLevelMap == null)
    {
      try
      {
        if (this.mCachedLevelMap != null) {
          break label214;
        }
        this.mCachedLevelMap = new HashMap();
        if (this.troopLevelMap != null)
        {
          String[] arrayOfString1 = this.troopLevelMap.split("\001");
          for (;;)
          {
            if ((arrayOfString1 != null) && (arrayOfString1.length > 0) && (i < arrayOfString1.length))
            {
              String[] arrayOfString2 = arrayOfString1[i].split("\000");
              int j = arrayOfString2.length;
              if (j == 2) {}
              try
              {
                this.mCachedLevelMap.put(Integer.valueOf(Integer.parseInt(arrayOfString2[0])), arrayOfString2[1]);
                i += 1;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("TroopInfo", 2, "getTroopLevelMap, catch exception, key: " + arrayOfString2[0] + " value: " + arrayOfString2[1]);
                  }
                }
              }
            }
          }
        }
        if (!QLog.isColorLevel()) {
          break label214;
        }
      }
      finally {}
      QLog.d("Q.getTroopMemberLevelInfo", 2, "getTroopLevelMap:" + this.troopuin + ", create cache");
    }
    label214:
    return this.mCachedLevelMap;
  }
  
  public boolean hasOrgs()
  {
    return false;
  }
  
  public boolean isAdmin()
  {
    return ((this.dwAdditionalFlag & 1L) == 1L) || ((this.dwCmdUinUinFlag & 1L) == 1L);
  }
  
  public boolean isAllowCreateDiscuss()
  {
    return (this.dwAppPrivilegeFlag & 0x8000) == 0L;
  }
  
  public boolean isAllowCreateTempConv()
  {
    return (this.dwAppPrivilegeFlag & 0x10000) == 0L;
  }
  
  public boolean isTroopAdmin(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    String[] arrayOfString;
    int i;
    if (this.Administrator != null)
    {
      arrayOfString = this.Administrator.split("\\|");
      bool1 = bool2;
      if (arrayOfString != null)
      {
        bool1 = bool2;
        if (arrayOfString.length > 0) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < arrayOfString.length)
      {
        if ((paramString != null) && (paramString.equals(arrayOfString[i]))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean isTroopOwner(String paramString)
  {
    return (paramString != null) && (paramString.equals(this.troopowneruin));
  }
  
  public void setTroopLevelMap(List paramList)
  {
    if (paramList != null) {}
    try
    {
      if (paramList.size() > 0)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.putAll(getTroopLevelMap());
        int i = 0;
        while (i < paramList.size())
        {
          stLevelRankPair localstLevelRankPair = (stLevelRankPair)paramList.get(i);
          localHashMap.put(Integer.valueOf((int)localstLevelRankPair.dwLevel), localstLevelRankPair.strRank);
          i += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.getTroopMemberLevelInfo", 2, "setTroopLevelMap:" + this.troopuin + ", old=" + this.troopLevelMap);
        }
        this.troopLevelMap = troopLevelMapToString(localHashMap);
        this.mCachedLevelMap = localHashMap;
        if (QLog.isColorLevel()) {
          QLog.d("Q.getTroopMemberLevelInfo", 2, "setTroopLevelMap:" + this.troopuin + ", new=" + this.troopLevelMap);
        }
      }
      return;
    }
    finally {}
  }
  
  public void setTroopLevelMap2(List paramList)
  {
    if (paramList != null) {}
    try
    {
      if (paramList.size() > 0)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.putAll(getTroopLevelMap());
        int i = 0;
        while (i < paramList.size())
        {
          Oidb_0x8fd.LevelName localLevelName = (Oidb_0x8fd.LevelName)paramList.get(i);
          localHashMap.put(Integer.valueOf(localLevelName.uint32_level.get()), localLevelName.str_name.get());
          i += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.getTroopMemberLevelInfo", 2, "setTroopLevelMap2:" + this.troopuin + ", old=" + this.troopLevelMap);
        }
        this.troopLevelMap = troopLevelMapToString(localHashMap);
        this.mCachedLevelMap = localHashMap;
        if (QLog.isColorLevel()) {
          QLog.d("Q.getTroopMemberLevelInfo", 2, "setTroopLevelMap2:" + this.troopuin + ", new=" + this.troopLevelMap);
        }
      }
      return;
    }
    finally {}
  }
  
  public void setTroopLevelMap787(List paramList)
  {
    if (paramList != null) {}
    try
    {
      if (paramList.size() > 0)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.putAll(getTroopLevelMap());
        int i = 0;
        while (i < paramList.size())
        {
          oidb_0x787.LevelName localLevelName = (oidb_0x787.LevelName)paramList.get(i);
          localHashMap.put(Integer.valueOf(localLevelName.uint32_level.get()), localLevelName.str_name.get().toStringUtf8());
          i += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.getTroopMemberLevelInfo", 2, "setTroopLevelMap787:" + this.troopuin + ", old=" + this.troopLevelMap);
        }
        this.troopLevelMap = troopLevelMapToString(localHashMap);
        this.mCachedLevelMap = localHashMap;
        if (QLog.isColorLevel()) {
          QLog.d("Q.getTroopMemberLevelInfo", 2, "setTroopLevelMap787:" + this.troopuin + ", new=" + this.troopLevelMap);
        }
      }
      return;
    }
    finally {}
  }
  
  public void updateQZonePhotoUrls(ArrayList paramArrayList)
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    int i;
    if (paramArrayList != null) {
      i = paramArrayList.size();
    }
    while (j < i)
    {
      String str = (String)paramArrayList.get(j);
      if ((str != null) && (str.length() > 0)) {
        localStringBuilder.append(str).append(";");
      }
      j += 1;
      continue;
      i = 0;
    }
    this.strQZonePhotoUrls = localStringBuilder.toString();
  }
  
  public void updateSomeMemberUins(List paramList)
  {
    int j = 0;
    int i;
    StringBuilder localStringBuilder;
    label23:
    oidb_0x899.memberlist localmemberlist;
    if (paramList != null)
    {
      i = paramList.size();
      localStringBuilder = new StringBuilder();
      if (j >= i) {
        break label91;
      }
      localmemberlist = (oidb_0x899.memberlist)paramList.get(j);
      if ((localmemberlist != null) && (localmemberlist.uint64_member_uin.has())) {
        break label71;
      }
    }
    for (;;)
    {
      j += 1;
      break label23;
      i = 0;
      break;
      label71:
      localStringBuilder.append(localmemberlist.uint64_member_uin.get()).append('|');
    }
    label91:
    this.mSomeMemberUins = localStringBuilder.toString();
    if ((i < 6) && (i > 0)) {
      this.wMemberNum = i;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\data\TroopInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */