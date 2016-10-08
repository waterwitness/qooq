package com.tencent.mobileqq.data;

import android.database.Cursor;
import com.dataline.mpfile.MpfileTaskRecord;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.dating.GodEntity;
import com.tencent.mobileqq.dating.GodListConfig;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.FreshNewsNotify;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.OGEntityManager;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rcg;

public class QQEntityManagerFactory
  extends EntityManagerFactory
{
  private static final String CORRUPT_DATABASE_PATH = "/tencent/msflogs/corruptInfo";
  private static final int DB_VERSION = 149;
  private static final int FLAG_CHECK_AUTHENTICATION = -1;
  protected static boolean isUpdateFromLowV74;
  public String TAG;
  protected boolean bUpdated;
  protected SQLiteOpenHelper dbHelper;
  protected QQEntityManagerFactory.SQLiteOpenHelperImpl mInnerDbHelper;
  public String name;
  
  public QQEntityManagerFactory(String paramString)
  {
    super(paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.TAG = "QQEntityManagerFactory";
    this.name = paramString;
  }
  
  public static void checkColumnChange(String paramString, android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    System.currentTimeMillis();
    Cursor localCursor1 = paramSQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
    ArrayList localArrayList = new ArrayList();
    if (localCursor1 != null)
    {
      while (localCursor1.moveToNext())
      {
        String str = SecurityUtile.a(localCursor1.getString(0));
        Cursor localCursor2 = paramSQLiteDatabase.rawQuery("select sql from sqlite_master where type=? and name=?", new String[] { "table", str });
        if (localCursor2 != null) {
          for (;;)
          {
            try
            {
              if (!str.equals("mr_fileManager")) {
                continue;
              }
              localClass = FileManagerEntity.class;
              OGEntityManager.a(localArrayList, str, localCursor2, localClass);
            }
            catch (ClassNotFoundException localClassNotFoundException)
            {
              Class localClass;
              continue;
            }
            localCursor2.close();
            break;
            if (str.equals(DataLineMsgRecord.tableName())) {
              localClass = DataLineMsgRecord.class;
            } else if (str.equals(MpfileTaskRecord.tableName())) {
              localClass = MpfileTaskRecord.class;
            } else if (str.equals(PrinterItemMsgRecord.tableName())) {
              localClass = PrinterItemMsgRecord.class;
            } else if (str.startsWith(RouterMsgRecord.tableBasicName())) {
              localClass = RouterMsgRecord.class;
            } else if (str.startsWith("mr_")) {
              localClass = MessageRecord.class;
            } else if (str.equals("recent")) {
              localClass = RecentUser.class;
            } else if (str.startsWith(SecMsg.getTabPrefix())) {
              localClass = SecMsg.class;
            } else if (str.equals("recent_call")) {
              localClass = QCallRecent.class;
            } else if (str.equals(ConversationInfo.getConversationInfoTableName())) {
              localClass = ConversationInfo.class;
            } else if (str.equals(TroopBarData.class.getSimpleName())) {
              localClass = TroopBarData.class;
            } else if (str.equals("EcShopData")) {
              localClass = EcShopData.class;
            } else {
              localClass = Class.forName(paramString + "." + str);
            }
          }
        }
      }
      localCursor1.close();
    }
    com.tencent.mobileqq.app.SQLiteDatabase.g();
    paramSQLiteDatabase.beginTransaction();
    try
    {
      paramString = localArrayList.iterator();
      while (paramString.hasNext()) {
        paramSQLiteDatabase.execSQL((String)paramString.next());
      }
      paramSQLiteDatabase.setTransactionSuccessful();
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
      com.tencent.mobileqq.app.SQLiteDatabase.h();
    }
    paramSQLiteDatabase.endTransaction();
    com.tencent.mobileqq.app.SQLiteDatabase.h();
  }
  
  public SQLiteOpenHelper build(String paramString)
  {
    if (this.dbHelper == null) {
      if (!VersionUtils.e()) {
        break label76;
      }
    }
    label76:
    for (this.mInnerDbHelper = new QQEntityManagerFactory.SQLiteOpenHelperImpl(this, paramString + ".db", null, 149, new rcg(this));; this.mInnerDbHelper = new QQEntityManagerFactory.SQLiteOpenHelperImpl(this, paramString + ".db", null, 149))
    {
      this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
      return this.dbHelper;
    }
  }
  
  protected void createDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(TableBuilder.a(new Groups()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new Friends()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new RecentUser()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new Ability()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new TroopInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new Card()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new DiscussionInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new PhoneContact()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new DataLineMsgRecord()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new DataLineMsgRecord(1)));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new EmoticonPackage()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new Emoticon()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new EmoticonTab()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new RoamSetting()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new TroopMemberInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new TroopRemindSettingData()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new ShieldListInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new ContactCard()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new QZoneCover()));
    MessageRecord localMessageRecord = MessageRecordFactory.a(64536);
    localMessageRecord.frienduin = String.valueOf(AppConstants.ar);
    localMessageRecord.istroop = 1001;
    paramSQLiteDatabase.execSQL(TableBuilder.a(localMessageRecord));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new SearchHistory()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new CircleBuddy()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new ExtensionInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new CommonlyUsedTroop()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new ExpiredPushBanner()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new HotChatInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new SpecialCareInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new ApolloBaseInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new ApolloPandora()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new FileManagerEntity()));
  }
  
  protected String getPackageName()
  {
    return "com.tencent.mobileqq.data";
  }
  
  public boolean isUpdateFromLowV74()
  {
    return isUpdateFromLowV74;
  }
  
  public boolean isUpdated()
  {
    return this.bUpdated;
  }
  
  public void resetUpdateFromLowV74()
  {
    isUpdateFromLowV74 = false;
  }
  
  protected void upgradeDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 20)
    {
      this.mInnerDbHelper.dropAllTable();
      return;
    }
    if (paramInt1 < 112) {
      paramSQLiteDatabase.execSQL(TableBuilder.a(new DataLineMsgRecord(1)));
    }
    if (paramInt1 < 70) {
      paramSQLiteDatabase.execSQL(TableBuilder.a(new ExtensionInfo()));
    }
    if (paramInt1 < 34)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.a(DiscussionInfo.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new DiscussionInfo()));
    }
    if (paramInt1 < 115) {
      paramSQLiteDatabase.execSQL(TableBuilder.a(TroopAppInfo.class.getSimpleName()));
    }
    if (paramInt1 < 29) {
      paramSQLiteDatabase.execSQL(TableBuilder.a(new Ability()));
    }
    if (paramInt1 < 35) {
      paramSQLiteDatabase.execSQL(TableBuilder.a(new PhoneContact()));
    }
    if (paramInt1 < 36)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.a("TroopSelfInfo"));
      paramSQLiteDatabase.execSQL(TableBuilder.a(TroopInfo.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new TroopInfo()));
      this.bUpdated = true;
    }
    if (paramInt1 < 41)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.a(Card.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new Card()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(ResourcePluginInfo.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new ResourcePluginInfo()));
    }
    if (paramInt1 < 48)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.a(Setting.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new Setting()));
    }
    if (paramInt1 <= 66)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.a(new SearchHistory()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new CircleBuddy()));
    }
    if (paramInt1 < 74) {
      isUpdateFromLowV74 = true;
    }
    if (paramInt1 <= 84)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.a(new ExpiredPushBanner()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new ShortVideoUpInfo()));
    }
    if (paramInt1 <= 89) {
      paramSQLiteDatabase.execSQL(TableBuilder.a(new HotChatInfo()));
    }
    if (paramInt1 <= 98)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.a(DatingFeedInfo.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(DatingPublishInfo.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(DatingApplyInfo.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(DatingInfo.class.getSimpleName()));
    }
    if (paramInt1 < 102) {
      paramSQLiteDatabase.execSQL(TableBuilder.a(new SpecialCareInfo()));
    }
    if (paramInt1 < 103) {
      paramSQLiteDatabase.execSQL(TableBuilder.a("RecommendMessage"));
    }
    if (paramInt1 < 108)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.a(new FreshNewsInfo()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new FreshNewsNotify()));
    }
    if (paramInt1 < 125)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.a(new ApolloBaseInfo()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new ApolloPandora()));
    }
    if (paramInt1 < 113)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.a(FreshNewsInfo.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(DatingInfo.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(FreshNewsNotify.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(DatingFeedInfo.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(DateEventMsg.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(DatingApplyInfo.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(DatingPublishInfo.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(DatingPublishInfoDel.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(DatingApplyInfoDel.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(RankEventMsg.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(DatingOthersCache.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(DatingRecentDetail.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(GodEntity.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(GodListConfig.class.getSimpleName()));
    }
    if (paramInt1 < 125) {
      paramSQLiteDatabase.execSQL(TableBuilder.a("t_qqcard_item"));
    }
    if (paramInt1 < 137)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.a(FreshNewsInfo.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(MessageRecord.getTableName(AppConstants.av, 0)));
    }
    checkColumnChange(getPackageName(), paramSQLiteDatabase);
  }
  
  public boolean verifyAuthentication()
  {
    if (this.name.matches("^[0-9]*$"))
    {
      EntityManager localEntityManager = createEntityManager();
      Ability localAbility = (Ability)localEntityManager.a(Ability.class, "flags=?", new String[] { String.valueOf(-1) });
      if (localAbility == null)
      {
        localAbility = new Ability();
        localAbility.flags = -1;
        localAbility.uin = this.name;
        localEntityManager.b(localAbility);
        return true;
      }
      if ((localAbility.uin == null) || (!localAbility.uin.equals(this.name)))
      {
        this.mInnerDbHelper.dropAllTable();
        localAbility = new Ability();
        localAbility.flags = -1;
        localAbility.uin = this.name;
        localEntityManager.b(localAbility);
        return false;
      }
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\data\QQEntityManagerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */