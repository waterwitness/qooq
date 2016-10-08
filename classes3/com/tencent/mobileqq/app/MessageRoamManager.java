package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.bitapp.BitAppMsg;
import com.tencent.bitapp.BitAppMsgFactory;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.asyncdb.CacheManager;
import com.tencent.mobileqq.app.asyncdb.cache.RoamDateCache;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.utils.MessageRoamHandler;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RoamDate;
import com.tencent.mobileqq.data.RoamMessagePreloadInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.MessageRecordEntityManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.MessageDBUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import localpb.richMsg.MixedMsg.Elem;
import localpb.richMsg.MixedMsg.Msg;
import localpb.richMsg.RichMsg.PicRec;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qan;
import qao;
import qap;
import qaq;
import qar;
import qas;
import qat;
import qau;
import qav;
import qaw;
import qax;

public class MessageRoamManager
  implements Manager
{
  public static final int a = 0;
  private static final String jdField_a_of_type_JavaLangString = "Q.roammsg.MessageRoamManager";
  public static final int b = 1;
  private static final String jdField_b_of_type_JavaLangString = "first_page_date";
  public static final int c = 0;
  private static final String jdField_c_of_type_JavaLangString = "last_page_date";
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  public static final int g = 4;
  public static final int h = 5;
  public static final int i = 6;
  public static final int j = 8;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private RoamDateCache jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache;
  private MessageRoamHandler jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler;
  public MessageRecord a;
  public DownloadListener a;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  public Calendar a;
  public HashMap a;
  private List jdField_a_of_type_JavaUtilList;
  public volatile boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private Calendar jdField_b_of_type_JavaUtilCalendar;
  public volatile boolean b;
  private Calendar jdField_c_of_type_JavaUtilCalendar;
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private Calendar jdField_d_of_type_JavaUtilCalendar;
  private Calendar e;
  private Calendar f;
  private Calendar g;
  private int k;
  private int l;
  
  public MessageRoamManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.k = -1;
    this.l = -1;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new qao(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler = ((MessageRoamHandler)paramQQAppInterface.a(59));
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache = ((RoamDateCache)paramQQAppInterface.a().a(2));
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_passwordmd5_and_signature_file", 0).getString("vip_message_roam_passwordmd5" + paramQQAppInterface.a(), null);
    if (paramQQAppInterface != null) {}
    for (paramQQAppInterface = Base64.decode(paramQQAppInterface, 0);; paramQQAppInterface = null)
    {
      this.jdField_a_of_type_ArrayOfByte = paramQQAppInterface;
      return;
    }
  }
  
  private long a(Calendar paramCalendar)
  {
    if (paramCalendar == null) {
      throw new IllegalArgumentException("date is null!");
    }
    paramCalendar.set(11, 0);
    paramCalendar.set(12, 0);
    paramCalendar.set(13, 0);
    paramCalendar.set(14, 0);
    return paramCalendar.getTimeInMillis();
  }
  
  private String a()
  {
    String str = ContactUtils.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if ((str != null) && (!str.trim().equals(""))) {
      return str;
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
  }
  
  private String a(long paramLong)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("", Locale.SIMPLIFIED_CHINESE);
    localSimpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
    return localSimpleDateFormat.format(Long.valueOf(paramLong));
  }
  
  private String a(BitAppMsg paramBitAppMsg)
  {
    if (paramBitAppMsg == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    if (!TextUtils.isEmpty(paramBitAppMsg.mMsgBrief)) {
      localStringBuffer.append(paramBitAppMsg.mMsgBrief);
    }
    return localStringBuffer.toString();
  }
  
  private String a(AbsStructMsg paramAbsStructMsg)
  {
    if ((paramAbsStructMsg == null) || (!AbsShareMsg.class.isInstance(paramAbsStructMsg))) {
      return null;
    }
    paramAbsStructMsg = (AbsShareMsg)paramAbsStructMsg;
    StringBuffer localStringBuffer = new StringBuffer();
    if (!TextUtils.isEmpty(paramAbsStructMsg.mMsgBrief)) {
      localStringBuffer.append(paramAbsStructMsg.mMsgBrief);
    }
    for (;;)
    {
      return localStringBuffer.toString();
      if (!TextUtils.isEmpty(paramAbsStructMsg.mSourceName))
      {
        localStringBuffer.append(paramAbsStructMsg.mSourceName);
        localStringBuffer.append(" " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131370594) + " ");
        if (!TextUtils.isEmpty(paramAbsStructMsg.mContentTitle)) {
          localStringBuffer.append(paramAbsStructMsg.mContentTitle);
        }
      }
    }
  }
  
  private List a(String paramString1, String paramString2, String paramString3)
  {
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
    if (localSQLiteDatabase == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.roammsg.MessageRoamManager", 2, "rawQuery db = null!");
      }
      return null;
    }
    paramString1 = MessageDBUtils.a(paramString2, paramString1, localSQLiteDatabase, paramString3, null);
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.roammsg.MessageRoamManager", 2, "sqlStr db = null!");
      }
      return null;
    }
    return ((MessageRecordEntityManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createMessageRecordEntityManager()).a(paramString1.toString(), null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void a(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    b(localCalendar);
    a(localCalendar);
  }
  
  private void a(DownloadTask paramDownloadTask)
  {
    if ((paramDownloadTask.z == 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putLong("cloudSearchCfgLastModify", paramDownloadTask.i).commit();
      if (200 == paramDownloadTask.D) {
        ThreadManager.a().post(new qap(this));
      }
    }
    if (QLog.isColorLevel())
    {
      File localFile = new File(MessageRoamConstants.E);
      long l1 = 0L;
      if (localFile.exists()) {
        l1 = localFile.lastModified();
      }
      QLog.d("Q.roammsg.MessageRoamManager", 2, "onDone status=" + paramDownloadTask.a() + ",errCode=" + paramDownloadTask.z + "," + "httpCode=" + paramDownloadTask.D + ",local lastModify=" + l1 + ",server lastModify=" + paramDownloadTask.i);
    }
  }
  
  private boolean a(String paramString)
  {
    if (paramString.charAt(0) == '\026')
    {
      paramString = paramString.split("\026")[1].split("\\|");
      if (paramString.length < 2) {
        return true;
      }
      if (paramString.length > 3) {
        try
        {
          Long.valueOf(paramString[1]);
          Integer.valueOf(paramString[2]);
          Boolean.valueOf(paramString[3]);
          return true;
        }
        catch (NumberFormatException paramString)
        {
          return false;
        }
      }
      return false;
    }
    return false;
  }
  
  private void b(long paramLong)
  {
    Calendar localCalendar;
    if (this.jdField_c_of_type_Boolean) {
      if (a(paramLong - 5L, this.jdField_c_of_type_JavaUtilCalendar))
      {
        localCalendar = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.b(this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaUtilCalendar, null);
        if (localCalendar != null)
        {
          this.jdField_c_of_type_JavaUtilCalendar = localCalendar;
          if (this.jdField_d_of_type_JavaLangString == null) {}
        }
      }
    }
    label115:
    int m;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).edit().putLong("first_page_date" + this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaUtilCalendar.getTimeInMillis()).commit();
              break label115;
              break label115;
              break label115;
              do
              {
                return;
              } while (!a(paramLong - 5L, this.jdField_d_of_type_JavaUtilCalendar));
              localCalendar = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_JavaUtilCalendar, null);
            } while (localCalendar == null);
            this.jdField_d_of_type_JavaUtilCalendar = localCalendar;
          } while (this.jdField_d_of_type_JavaLangString == null);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).edit().putLong("last_page_date" + this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_JavaUtilCalendar.getTimeInMillis()).commit();
          return;
          if (!a(paramLong - 5L, this.f)) {
            break;
          }
          m = this.jdField_a_of_type_JavaUtilList.indexOf(Long.valueOf(a(this.f)));
        } while ((m == -1) || (m >= this.jdField_a_of_type_JavaUtilList.size() - 1));
        this.f.setTimeInMillis(((Long)this.jdField_a_of_type_JavaUtilList.get(m + 1)).longValue());
        return;
      } while (!a(paramLong - 5L, this.g));
      m = this.jdField_a_of_type_JavaUtilList.indexOf(Long.valueOf(a(this.g)));
    } while (m <= 0);
    this.g.setTimeInMillis(((Long)this.jdField_a_of_type_JavaUtilList.get(m - 1)).longValue());
  }
  
  private void b(DownloadTask paramDownloadTask)
  {
    boolean bool = true;
    Object localObject;
    SharedPreferences.Editor localEditor;
    if ((paramDownloadTask.a() == 3) && (paramDownloadTask.z == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.roammsg.MessageRoamManager", 2, "blue banner download success!");
      }
      localObject = new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getFilesDir(), paramDownloadTask.a);
      if (((File)localObject).exists())
      {
        paramDownloadTask = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
        localEditor = paramDownloadTask.edit();
      }
    }
    for (;;)
    {
      int m;
      try
      {
        localObject = new JSONArray(FileUtils.a((File)localObject));
        m = 0;
        if (m >= ((JSONArray)localObject).length()) {
          break label468;
        }
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(m);
        if ((localJSONObject == null) || (localJSONObject.getInt("id") != 1)) {
          break label475;
        }
        localEditor.putInt("blue_banner_cheak_update_internal", localJSONObject.getInt("updateinternal"));
        localEditor.putInt("blue_banner_show_internal", localJSONObject.getInt("showinternal"));
        localEditor.putInt("blue_banner_show_time", localJSONObject.getInt("showtime"));
        localEditor.putString("blue_banner_go_url", localJSONObject.getString("url"));
        localEditor.putString("blue_banner_notvip_text", localJSONObject.getString("notvip"));
        localEditor.putString("blue_banner_vip_text", localJSONObject.getString("vip"));
        localEditor.putString("blue_banner_svip_text", localJSONObject.getString("svip"));
        localEditor.commit();
        if (bool)
        {
          paramDownloadTask.edit().putLong("blue_banner_last_update_timestamp", NetConnInfoCenter.getServerTimeMillis()).commit();
          return;
        }
        if (!QLog.isColorLevel()) {
          break label474;
        }
        QLog.e("Q.roammsg.MessageRoamManager", 2, "save sp error , isSaveSuccess" + bool);
        return;
      }
      catch (JSONException paramDownloadTask)
      {
        if (!QLog.isColorLevel()) {
          break label474;
        }
        QLog.e("Q.roammsg.MessageRoamManager", 2, "JSONException,blue banner parse json error : " + paramDownloadTask.toString());
        return;
      }
      catch (Exception paramDownloadTask)
      {
        if (!QLog.isColorLevel()) {
          break label474;
        }
      }
      QLog.e("Q.roammsg.MessageRoamManager", 2, "Exception,blue banner parse json error : " + paramDownloadTask.toString());
      return;
      if (QLog.isColorLevel())
      {
        QLog.e("Q.roammsg.MessageRoamManager", 2, "blue banner download file save failed!");
        return;
        if (QLog.isColorLevel())
        {
          QLog.e("Q.roammsg.MessageRoamManager", 2, "blue banner download failed, task.status = " + paramDownloadTask.a() + " , task.errCode = " + paramDownloadTask.z);
          return;
          label468:
          bool = false;
          continue;
        }
      }
      label474:
      return;
      label475:
      m += 1;
    }
  }
  
  private boolean b(long paramLong, Calendar paramCalendar)
  {
    paramCalendar = a((Calendar)paramCalendar.clone());
    return (paramLong >= ((Long)paramCalendar.first).longValue()) && (paramLong <= ((Long)paramCalendar.second).longValue());
  }
  
  private boolean b(Calendar paramCalendar)
  {
    int m = paramCalendar.get(1);
    int n = paramCalendar.get(2);
    int i1 = paramCalendar.get(5);
    paramCalendar = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_d_of_type_JavaLangString, m, n + 1);
    return (paramCalendar == null) || (paramCalendar.getSerState(i1 - 1) == 0) || (paramCalendar.getSerState(i1 - 1) == 1);
  }
  
  private boolean c(Calendar paramCalendar)
  {
    long l1 = ((Long)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_d_of_type_JavaLangString).first).longValue();
    Pair localPair = a((Calendar)paramCalendar.clone());
    if ((l1 > ((Long)localPair.first).longValue()) && (l1 <= ((Long)localPair.second).longValue()))
    {
      int m = paramCalendar.get(1);
      int n = paramCalendar.get(2);
      int i1 = paramCalendar.get(5);
      paramCalendar = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_d_of_type_JavaLangString, m, n + 1);
      if (paramCalendar != null)
      {
        paramCalendar.setLocState(i1 - 1, 0);
        this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(paramCalendar);
      }
      return true;
    }
    return false;
  }
  
  private boolean k()
  {
    if (this.jdField_d_of_type_JavaLangString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.roammsg.MessageRoamManager", 2, "createLocMsgDateLine error : mFriendUin == null");
      }
      return false;
    }
    Object localObject2 = a();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
        break label89;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.roammsg.MessageRoamManager", 2, "createLocMsgDateLine fasle");
      return false;
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    label89:
    Object localObject1 = Calendar.getInstance();
    localObject2 = ((List)localObject2).iterator();
    long l1;
    while (((Iterator)localObject2).hasNext())
    {
      ((Calendar)localObject1).setTimeInMillis(((MessageRecord)((Iterator)localObject2).next()).time * 1000L);
      ((Calendar)localObject1).set(11, 0);
      ((Calendar)localObject1).set(12, 0);
      ((Calendar)localObject1).set(13, 0);
      ((Calendar)localObject1).set(14, 0);
      l1 = ((Calendar)localObject1).getTimeInMillis();
      if (!this.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(l1))) {
        this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(l1));
      }
    }
    if (this.g == null)
    {
      this.g = Calendar.getInstance();
      this.g.setTimeInMillis(((Long)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1)).longValue());
    }
    for (localObject1 = this.g.get(1) + "-" + (this.g.get(2) + 1) + "-" + this.g.get(5);; localObject1 = "")
    {
      if (this.f == null)
      {
        this.f = Calendar.getInstance();
        this.f.setTimeInMillis(((Long)this.jdField_a_of_type_JavaUtilList.get(0)).longValue());
      }
      for (localObject2 = this.f.get(1) + "-" + (this.f.get(2) + 1) + "-" + this.f.get(5);; localObject2 = "")
      {
        if (this.e == null)
        {
          this.e = Calendar.getInstance();
          this.e.setTimeInMillis(this.g.getTimeInMillis());
        }
        if ((this.f != null) && (this.g != null))
        {
          l1 = (this.g.getTimeInMillis() - this.f.getTimeInMillis()) / 86400000L;
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatHistory", "local_timeline", 0, 0, new String[] { l1 + "", "0", localObject2, localObject1 });
        }
        return true;
      }
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ThreadManager.b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  private void q()
  {
    ThreadManager.b().post(new qaw(this));
  }
  
  public int a()
  {
    return this.l;
  }
  
  public int a(String paramString, int paramInt, StringBuilder paramStringBuilder)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return 0;
    }
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
    if (localSQLiteDatabase == null) {
      return 0;
    }
    StringBuilder localStringBuilder;
    if (paramInt == 0)
    {
      localStringBuilder = new StringBuilder(" msgtype ");
      localStringBuilder.append(MsgProxyUtils.b());
      localStringBuilder.append(" and isValid=1 ");
    }
    for (paramString = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, "", localStringBuilder.toString(), ""); paramString == null; paramString = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, localStringBuilder.toString()))
    {
      return 0;
      localStringBuilder = new StringBuilder(" where msgtype ");
      localStringBuilder.append(MsgProxyUtils.b());
      localStringBuilder.append(" and isValid=1 ");
    }
    paramString = localSQLiteDatabase.a(paramString.toString(), null);
    if (paramString == null) {
      return 0;
    }
    long l1;
    if ((paramString.getCount() > 0) && (paramStringBuilder != null))
    {
      paramString.moveToLast();
      if (paramInt != 3000) {
        break label237;
      }
      l1 = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
    }
    for (;;)
    {
      if (l1 > 0L) {
        paramStringBuilder.append(String.valueOf(l1));
      }
      paramInt = paramString.getCount();
      paramString.close();
      return paramInt;
      label237:
      if (paramInt == 0) {
        l1 = paramString.getLong(paramString.getColumnIndex("time"));
      } else if (paramInt == 1) {
        l1 = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
      } else {
        l1 = 0L;
      }
    }
  }
  
  public int a(String paramString, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "getMessageFromDB: friendUin = " + paramString + ", start = " + paramLong1 + ", end = " + paramLong2);
    }
    String str = "time BETWEEN " + paramLong1 + " AND " + paramLong2;
    paramString = a(MessageRecord.getTableName(paramString, 0), null, "( msgtype " + MsgProxyUtils.b() + " and isValid=1 and " + str + " ) " + "ORDER BY time asc , longMsgIndex asc");
    if (paramString == null) {
      return 0;
    }
    return paramString.size();
  }
  
  public Bundle a(Calendar paramCalendar)
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a();
    int i2;
    int i3;
    int i4;
    int m;
    if (!localList.isEmpty())
    {
      i2 = paramCalendar.get(1);
      i3 = paramCalendar.get(2) + 1;
      i4 = paramCalendar.get(5);
      paramCalendar = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_d_of_type_JavaLangString, i2, i3);
      m = 0;
      if (m >= localList.size()) {
        break label391;
      }
      if (!((String)((Map.Entry)localList.get(m)).getKey()).equals(paramCalendar)) {}
    }
    label380:
    label391:
    for (;;)
    {
      if (m < localList.size())
      {
        paramCalendar = (RoamDate)((Map.Entry)localList.get(m)).getValue();
        String str = (String)((Map.Entry)localList.get(m)).getKey();
        str = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(str)[1];
        int i5 = Integer.valueOf(str.split("-")[0]).intValue();
        int i6 = Integer.valueOf(str.split("-")[1]).intValue();
        int i1 = 1;
        int n = i1;
        if (i2 == i5)
        {
          n = i1;
          if (i3 == i6) {
            n = i4 + 1;
          }
        }
        for (;;)
        {
          if (n > RoamDate.getDays(i5, i6)) {
            break label380;
          }
          if (paramCalendar.getLocState(n - 1) == 3)
          {
            paramCalendar = new Bundle();
            paramCalendar.putString("MSG_TYPE", "local");
            paramCalendar.putInt("DATE_YEAR", i5);
            paramCalendar.putInt("DATE_MONTH", i6);
            paramCalendar.putInt("DATE_DAY", n);
            return paramCalendar;
            m += 1;
            break;
          }
          if ((paramCalendar.getSerState(n - 1) == 2) && (NetworkUtil.e(BaseApplication.getContext())))
          {
            paramCalendar = new Bundle();
            paramCalendar.putString("MSG_TYPE", "server");
            paramCalendar.putInt("DATE_YEAR", i5);
            paramCalendar.putInt("DATE_MONTH", i6);
            paramCalendar.putInt("DATE_DAY", n);
            return paramCalendar;
          }
          n += 1;
        }
        m += 1;
      }
      else
      {
        return null;
      }
    }
  }
  
  public Pair a(Calendar paramCalendar)
  {
    paramCalendar.set(11, 0);
    paramCalendar.set(12, 0);
    paramCalendar.set(13, 0);
    paramCalendar.set(14, 0);
    long l1 = paramCalendar.getTimeInMillis() / 1000L;
    paramCalendar.set(11, 23);
    paramCalendar.set(12, 59);
    paramCalendar.set(13, 59);
    paramCalendar.set(14, 0);
    return new Pair(Long.valueOf(l1), Long.valueOf(paramCalendar.getTimeInMillis() / 1000L));
  }
  
  public RoamDateCache a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache;
  }
  
  public BitSet a(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    BitSet localBitSet = new BitSet();
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      paramCalendar1 = (Calendar)paramCalendar1.clone();
      int m = 0;
      while ((paramCalendar1.before(paramCalendar2)) || (paramCalendar1.equals(paramCalendar2)))
      {
        paramCalendar1.set(11, 0);
        paramCalendar1.set(12, 0);
        paramCalendar1.set(13, 0);
        paramCalendar1.set(14, 0);
        if (this.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(paramCalendar1.getTimeInMillis()))) {
          localBitSet.set(m, true);
        }
        paramCalendar1.add(5, 1);
        m += 1;
      }
    }
    return localBitSet;
  }
  
  public Calendar a()
  {
    if (this.jdField_c_of_type_Boolean) {
      return this.jdField_b_of_type_JavaUtilCalendar;
    }
    return this.e;
  }
  
  public List a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "getAllMessageFormDB: friendUin = " + this.jdField_d_of_type_JavaLangString);
    }
    if (this.jdField_d_of_type_JavaLangString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.roammsg.MessageRoamManager", 2, "getAllMessageFormDB error : mFriendUin == null");
      }
      return null;
    }
    return a(MessageRecord.getTableName(this.jdField_d_of_type_JavaLangString, 0), null, "( msgtype " + MsgProxyUtils.b() + " and isValid=1 ) " + "ORDER BY time asc , longMsgIndex asc");
  }
  
  public List a(String paramString, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "getMessageFromDB: friendUin = " + paramString + ", start = " + paramLong1 + ", end = " + paramLong2);
    }
    String str = "time BETWEEN " + paramLong1 + " AND " + paramLong2;
    return a(MessageRecord.getTableName(paramString, 0), null, str + " " + "ORDER BY time asc , longMsgIndex asc");
  }
  
  public void a()
  {
    this.jdField_b_of_type_JavaUtilCalendar = null;
    this.jdField_c_of_type_JavaUtilCalendar = null;
    this.jdField_d_of_type_JavaUtilCalendar = null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler.a(paramInt));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_b_of_type_JavaUtilCalendar == null) {
      this.jdField_b_of_type_JavaUtilCalendar = Calendar.getInstance();
    }
    this.jdField_b_of_type_JavaUtilCalendar.set(1, paramInt1);
    this.jdField_b_of_type_JavaUtilCalendar.set(2, paramInt2);
    this.jdField_b_of_type_JavaUtilCalendar.set(5, paramInt3);
    this.jdField_b_of_type_JavaUtilCalendar.set(11, 0);
    this.jdField_b_of_type_JavaUtilCalendar.set(12, 0);
    this.jdField_b_of_type_JavaUtilCalendar.set(13, 0);
    this.jdField_b_of_type_JavaUtilCalendar.set(14, 0);
    a(this.jdField_b_of_type_JavaUtilCalendar);
  }
  
  public void a(int paramInt, Calendar paramCalendar, boolean paramBoolean)
  {
    this.l = paramInt;
    int m;
    if ((paramCalendar != null) && (QLog.isColorLevel()))
    {
      m = paramCalendar.get(1);
      int n = paramCalendar.get(2);
      int i1 = paramCalendar.get(5);
      QLog.d("Q.roammsg.MessageRoamManager", 2, "getRoamHistory start... someday=" + m + "-" + (n + 1) + "-" + i1);
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      if (this.e == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.roammsg.MessageRoamManager", 2, "getRoamHistory error :mLocCurPageDate == null");
        }
        return;
      }
      if (paramCalendar != null) {
        m = this.jdField_a_of_type_JavaUtilList.indexOf(Long.valueOf(a(paramCalendar)));
      }
    }
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      if ((m < 0) || (m > this.jdField_a_of_type_JavaUtilList.size() - 1))
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.roammsg.MessageRoamManager", 2, "getForwardRoamHistoryByDate error :index < 0");
        }
        if ((paramInt == 1) || (paramInt == 0)) {
          break;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
        localObject2 = ((MqqHandler)localObject1).obtainMessage(31);
        ((Message)localObject2).obj = paramCalendar;
        ((MqqHandler)localObject1).sendMessageDelayed((Message)localObject2, 0L);
        return;
        if (paramInt == 1)
        {
          long l1 = a(this.e);
          m = this.jdField_a_of_type_JavaUtilList.size() - 1;
          label250:
          if ((m < 0) || (((Long)this.jdField_a_of_type_JavaUtilList.get(m)).longValue() <= l1))
          {
            if (m != -1) {
              break label302;
            }
            m += 1;
          }
          label302:
          for (;;)
          {
            break;
            m -= 1;
            break label250;
          }
        }
        if (paramInt == 3)
        {
          m = this.jdField_a_of_type_JavaUtilList.indexOf(Long.valueOf(a(this.e)));
          if (m >= this.jdField_a_of_type_JavaUtilList.size() - 1) {
            break;
          }
          m += 1;
          continue;
        }
        if (paramInt != 2) {
          break label776;
        }
        m = this.jdField_a_of_type_JavaUtilList.indexOf(Long.valueOf(a(this.e)));
        if (m <= 0) {
          break label773;
        }
        m -= 1;
        continue;
      }
      if (paramInt == 0) {
        b(this.g);
      }
      while (paramBoolean)
      {
        ThreadManager.b().post(new qar(this, m));
        return;
        a(((Long)this.jdField_a_of_type_JavaUtilList.get(m)).longValue());
      }
      paramCalendar = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
      paramCalendar.sendMessageDelayed(paramCalendar.obtainMessage(0), 0L);
      return;
      if (paramInt == 1)
      {
        localObject2 = this.jdField_b_of_type_JavaUtilCalendar;
        localObject1 = null;
      }
      for (;;)
      {
        if (localObject2 != null) {
          a((Calendar)localObject2, null, paramBoolean);
        }
        for (;;)
        {
          label506:
          if (QLog.isColorLevel())
          {
            QLog.w("Q.roammsg.MessageRoamManager", 2, "getRoamHistory end");
            return;
            if (paramInt == 0)
            {
              localObject2 = this.jdField_d_of_type_JavaUtilCalendar;
              localObject1 = null;
              break;
            }
            if (paramCalendar != null)
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_d_of_type_JavaLangString, paramCalendar, 0);
              localObject2 = null;
              break;
            }
            if ((paramInt == 3) && (this.jdField_b_of_type_JavaUtilCalendar != null))
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_d_of_type_JavaLangString, this.jdField_b_of_type_JavaUtilCalendar, 2);
              localObject2 = null;
              break;
            }
            if ((paramInt != 2) || (this.jdField_b_of_type_JavaUtilCalendar == null)) {
              break label764;
            }
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_d_of_type_JavaLangString, this.jdField_b_of_type_JavaUtilCalendar, 1);
            localObject2 = null;
            break;
            if ((localObject1 != null) && (((RoamMessagePreloadInfo)localObject1).curday != null))
            {
              a(((RoamMessagePreloadInfo)localObject1).curday, (RoamMessagePreloadInfo)localObject1, paramBoolean);
            }
            else if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder().append("getRoamHistory: null roamFrom: ").append(paramInt).append("info==null:");
              if (localObject1 != null) {
                break label759;
              }
            }
          }
        }
        label759:
        for (paramBoolean = true;; paramBoolean = false)
        {
          QLog.d("Q.roammsg.MessageRoamManager", 2, paramBoolean);
          if (paramCalendar == null) {
            break label506;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
          localObject2 = ((MqqHandler)localObject1).obtainMessage(31);
          ((Message)localObject2).obj = paramCalendar;
          ((MqqHandler)localObject1).sendMessageDelayed((Message)localObject2, 0L);
          break label506;
          break;
        }
        label764:
        localObject1 = null;
        localObject2 = null;
      }
      label773:
      continue;
      label776:
      m = 0;
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
      this.l = 6;
      long l1 = paramMessageRecord.time;
      paramMessageRecord = Calendar.getInstance();
      paramMessageRecord.setTimeInMillis(l1 * 1000L);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
      ((MqqHandler)localObject).sendMessageDelayed(((MqqHandler)localObject).obtainMessage(25), 0L);
      if (this.jdField_c_of_type_Boolean) {
        break label138;
      }
      m = this.jdField_a_of_type_JavaUtilList.indexOf(Long.valueOf(a(paramMessageRecord)));
      if (m >= 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.roammsg.MessageRoamManager", 2, "getRoamHistoryBySearchResult local state error index < 0");
    return;
    b(paramMessageRecord);
    p();
    this.jdField_a_of_type_JavaLangRunnable = new qat(this, m);
    ThreadManager.b().post(this.jdField_a_of_type_JavaLangRunnable);
    return;
    label138:
    Object localObject = Calendar.getInstance();
    if ((paramMessageRecord.get(1) == ((Calendar)localObject).get(1)) && (paramMessageRecord.get(2) == ((Calendar)localObject).get(2)) && (paramMessageRecord.get(5) == ((Calendar)localObject).get(5)) && (c(paramMessageRecord))) {}
    for (int m = 1;; m = 0)
    {
      if (m != 0)
      {
        a(false);
        return;
      }
      a(paramMessageRecord, null, true);
      return;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.d();
    this.jdField_b_of_type_JavaUtilCalendar = null;
    this.jdField_c_of_type_JavaUtilCalendar = null;
    this.jdField_d_of_type_JavaUtilCalendar = null;
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      this.e = null;
      this.f = null;
      this.g = null;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
      }
      this.jdField_d_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(paramString);
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
      long l1 = paramString.getLong("first_page_date" + this.jdField_d_of_type_JavaLangString, 0L);
      long l2 = paramString.getLong("last_page_date" + this.jdField_d_of_type_JavaLangString, 0L);
      if (l1 != 0L)
      {
        this.jdField_c_of_type_JavaUtilCalendar = Calendar.getInstance();
        this.jdField_c_of_type_JavaUtilCalendar.setTimeInMillis(l1);
      }
      if (l2 != 0L)
      {
        this.jdField_d_of_type_JavaUtilCalendar = Calendar.getInstance();
        this.jdField_d_of_type_JavaUtilCalendar.setTimeInMillis(l2);
      }
      this.jdField_a_of_type_JavaUtilCalendar = null;
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      ThreadManager.b().post(new qan(this));
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, StringBuffer paramStringBuffer)
  {
    Object localObject2 = "";
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject1;
    Cursor localCursor;
    label160:
    int n;
    label233:
    int m;
    Object localObject4;
    if ((paramInt == 1) || (paramInt == 3000))
    {
      localObject1 = MessageDBUtils.a(MessageRecord.getOldTableName(paramString1, paramInt), MessageRecord.getTableName(paramString1, paramInt), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b());
      if (localObject1 == null) {
        break label1231;
      }
      localCursor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b().a(((StringBuilder)localObject1).toString(), null);
      if (paramInt == 1)
      {
        localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, 1);
        localStringBuffer.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368682) + ":");
        localStringBuffer.append((String)localObject1);
        localStringBuffer.append("\r\n===========================================\r\n");
      }
      if ((localCursor != null) && (localCursor.moveToFirst()))
      {
        localObject1 = localObject2;
        n = localCursor.getInt(localCursor.getColumnIndex("time"));
        localObject2 = localCursor.getString(localCursor.getColumnIndex("senderuin"));
        if (1 != paramInt) {
          break label621;
        }
        localObject2 = String.format("%s(%s)", new Object[] { ContactUtils.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, (String)localObject2), localObject2 });
        m = localCursor.getInt(localCursor.getColumnIndex("issend"));
        if (!MsgUtils.a(m)) {
          break label667;
        }
        localObject4 = a();
        label266:
        if ((localCursor.getColumnIndex("versionCode") >= 0) && (localCursor.getInt(localCursor.getColumnIndex("versionCode")) > 0)) {
          break label674;
        }
        localObject1 = localCursor.getString(localCursor.getColumnIndex("msg"));
      }
    }
    label318:
    Object localObject5;
    label395:
    label424:
    label562:
    label621:
    label667:
    label674:
    int i1;
    for (;;)
    {
      localObject5 = new QQText((CharSequence)localObject1, 3).a();
      localObject2 = localObject5;
      if (localObject5 != null)
      {
        localObject2 = localObject5;
        if (((String)localObject5).length() > 0)
        {
          localObject2 = localObject5;
          if (a((String)localObject5))
          {
            localObject2 = localObject5.split("\026")[1].split("\\|");
            if (localObject2.length >= 2) {
              break label1160;
            }
            m = 1;
            if ((m != 1) && (m != 65538)) {
              break label1175;
            }
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368433);
          }
        }
      }
      localObject2 = a(n * 1000L) + "  " + (String)localObject4 + "\r\n" + (String)localObject2;
      localStringBuffer.append((String)localObject2 + "\r\n\r\n");
      do
      {
        if (localCursor.moveToNext()) {
          break label1228;
        }
        if (localCursor != null) {
          localCursor.close();
        }
        boolean bool = FileUtils.a(AppConstants.bj, paramStringBuffer.toString(), localStringBuffer.toString());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class).obtainMessage(12, Boolean.valueOf(bool)).sendToTarget();
        return;
        localObject1 = "( isValid=1 and msgtype " + MsgProxyUtils.b() + " ) ORDER BY time asc , longMsgIndex asc";
        localObject1 = MessageDBUtils.a(MessageRecord.getOldTableName(paramString1, paramInt), MessageRecord.getTableName(paramString1, paramInt), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(), (String)localObject1, null);
        break;
        if (3000 == paramInt)
        {
          localObject2 = String.format("%s(%s)", new Object[] { ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, 0), localObject2 });
          break label233;
        }
        localObject2 = paramString2;
        break label233;
        localObject4 = localObject2;
        break label266;
        i1 = localCursor.getInt(localCursor.getColumnIndex("msgtype"));
        if (i1 == 63529)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131370467);
          break label318;
        }
        if (i1 == 63525)
        {
          localObject1 = a(StructMsgFactory.a(localCursor.getBlob(localCursor.getColumnIndex("msgData"))));
          break label318;
        }
        if (i1 == 60527)
        {
          localObject1 = a(BitAppMsgFactory.a(localCursor.getBlob(localCursor.getColumnIndex("msgData"))));
          break label318;
        }
        if (i1 == 63516)
        {
          if (MsgUtils.a(m))
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131367606, new Object[] { paramString2 });
            break label318;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131367605);
          break label318;
        }
      } while (i1 == 63530);
      if (i1 == 63536)
      {
        localObject1 = "[图片]";
      }
      else if (i1 == 63534)
      {
        localObject1 = "[语音]";
      }
      else
      {
        if (i1 != 63514) {
          break label912;
        }
        localObject1 = "[视频]";
      }
    }
    label912:
    if (i1 == 64501) {
      localObject1 = new StringBuilder();
    }
    for (;;)
    {
      try
      {
        localObject5 = localCursor.getBlob(localCursor.getColumnIndex("msgData"));
        localObject2 = new MixedMsg.Msg();
        try
        {
          ((MixedMsg.Msg)localObject2).mergeFrom((byte[])localObject5);
          if (((MixedMsg.Msg)localObject2).elems.get().size() <= 0) {
            break label562;
          }
          i1 = ((MixedMsg.Msg)localObject2).elems.get().size();
          m = 0;
          if (m < i1)
          {
            localObject5 = (MixedMsg.Elem)((MixedMsg.Msg)localObject2).elems.get().get(m);
            if (!((MixedMsg.Elem)localObject5).textMsg.has()) {
              break label1091;
            }
            ((StringBuilder)localObject1).append(((MixedMsg.Elem)localObject5).textMsg.get());
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          continue;
        }
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.roammsg.MessageRoamManager", 2, "Parse mix message error");
        }
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      label1091:
      if (localInvalidProtocolBufferMicroException.picMsg.has())
      {
        ((StringBuilder)localObject1).append("[图片]");
        break label1237;
        try
        {
          String str = new String(localCursor.getBlob(localCursor.getColumnIndex("msgData")), "UTF-8");
          localObject1 = str;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
        break label318;
        label1160:
        m = Integer.valueOf(localException2[2]).intValue();
        break label395;
        label1175:
        Object localObject3 = localInvalidProtocolBufferMicroException;
        if (m != 2) {
          break label424;
        }
        localObject3 = "[" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368092) + "]";
        break label424;
        label1228:
        break label160;
        label1231:
        localCursor = null;
        break;
      }
      label1237:
      m += 1;
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if (this.jdField_d_of_type_JavaLangString != null) {}
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(paramString);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a();
    if (localObject != null)
    {
      localObject = (Calendar)((Pair)localObject).first;
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis((5L + paramLong) * 1000L);
      this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(paramString, (Calendar)localObject, localCalendar, 0);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.d();
  }
  
  public void a(Calendar paramCalendar)
  {
    if (this.jdField_a_of_type_JavaUtilCalendar == null) {
      this.jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
    }
    this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(paramCalendar.getTimeInMillis());
  }
  
  public void a(Calendar paramCalendar, RoamMessagePreloadInfo paramRoamMessagePreloadInfo, boolean paramBoolean)
  {
    if (paramCalendar == null) {}
    int i2;
    int i3;
    boolean bool;
    for (;;)
    {
      return;
      int m = paramCalendar.get(1);
      int n = paramCalendar.get(2) + 1;
      int i1 = paramCalendar.get(5);
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "handleRoamDateQuery: Date = " + m + "-" + n + "-" + i1);
      }
      RoamDate localRoamDate = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_d_of_type_JavaLangString, m, n);
      if (localRoamDate == null)
      {
        a(false);
        return;
      }
      a(m, n - 1, i1);
      i2 = localRoamDate.getLocState(i1 - 1);
      i3 = localRoamDate.getSerState(i1 - 1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "handleRoamDateQuery: serverStatus: " + i3 + ", localStaus: " + i2);
      }
      switch (i2)
      {
      default: 
        return;
      case 0: 
      case 1: 
      case 2: 
        bool = NetworkUtil.e(BaseApplication.getContext());
        if ((i3 != 2) || (!bool)) {
          break label418;
        }
        paramCalendar = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
        paramCalendar.sendMessageDelayed(paramCalendar.obtainMessage(25), 0L);
        paramCalendar = Calendar.getInstance();
        paramCalendar.setTime(new Date(m - 1900, n - 1, i1));
        this.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler.a(this.jdField_d_of_type_JavaLangString, paramCalendar, paramBoolean, 8, false);
        if (paramRoamMessagePreloadInfo != null)
        {
          this.jdField_a_of_type_JavaUtilHashMap.clear();
          this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_b_of_type_JavaUtilCalendar, paramRoamMessagePreloadInfo);
          return;
        }
        break;
      case 3: 
        if (paramBoolean) {
          ThreadManager.b().post(new qas(this, paramCalendar));
        }
        while ((NetworkUtil.e(BaseApplication.getContext())) && (paramRoamMessagePreloadInfo != null))
        {
          this.jdField_a_of_type_JavaUtilHashMap.clear();
          this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_b_of_type_JavaUtilCalendar, paramRoamMessagePreloadInfo);
          c(this.jdField_b_of_type_JavaUtilCalendar);
          return;
          paramCalendar = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
          paramCalendar.sendMessageDelayed(paramCalendar.obtainMessage(0), 0L);
        }
      }
    }
    label418:
    if (QLog.isColorLevel()) {
      QLog.w("Q.roammsg.MessageRoamManager", 2, "handleRoamDateQuery serStatus: " + i3 + ", locStatus: " + i2 + ", network status: " + bool);
    }
    paramCalendar = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
    paramRoamMessagePreloadInfo = paramCalendar.obtainMessage(1);
    paramRoamMessagePreloadInfo.arg1 = -1;
    paramCalendar.sendMessageDelayed(paramRoamMessagePreloadInfo, 0L);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = Calendar.getInstance();
    int m = ((Calendar)localObject).get(1);
    int n = ((Calendar)localObject).get(2);
    int i1 = ((Calendar)localObject).get(5);
    if ((paramBoolean) || (c((Calendar)localObject)) || (b((Calendar)localObject)))
    {
      paramBoolean = true;
      if (!paramBoolean) {
        break label114;
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        if (NetworkUtil.e(BaseApplication.getContext()))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
          ((MqqHandler)localObject).sendMessageDelayed(((MqqHandler)localObject).obtainMessage(25), 0L);
          this.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler.a(this.jdField_d_of_type_JavaLangString, 0, 1, m, n + 1, i1);
          return;
          paramBoolean = false;
          break;
          label114:
          paramBoolean = i();
          continue;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
        Message localMessage = ((MqqHandler)localObject).obtainMessage(15);
        localMessage.arg1 = 1;
        ((MqqHandler)localObject).sendMessageDelayed(localMessage, 0L);
        return;
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
    ((MqqHandler)localObject).sendMessageDelayed(((MqqHandler)localObject).obtainMessage(17), 0L);
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_JavaUtilCalendar != null;
  }
  
  public boolean a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler.b(paramInt));
    p();
    return (this.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler.a == null) || (this.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler.a.size() == 0);
  }
  
  public boolean a(long paramLong)
  {
    boolean bool = true;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis((5L + paramLong) * 1000L);
    if (this.jdField_b_of_type_JavaUtilCalendar == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "isSameDay return false: mCurPageDate == null");
      }
      return false;
    }
    if ((localCalendar.get(1) == this.jdField_b_of_type_JavaUtilCalendar.get(1)) && (localCalendar.get(2) == this.jdField_b_of_type_JavaUtilCalendar.get(2)) && (localCalendar.get(5) == this.jdField_b_of_type_JavaUtilCalendar.get(5))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean a(long paramLong, Calendar paramCalendar)
  {
    boolean bool = true;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis((5L + paramLong) * 1000L);
    if (paramCalendar == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "isSameDay return false: day == null");
      }
      return false;
    }
    if ((localCalendar.get(1) == paramCalendar.get(1)) && (localCalendar.get(2) == paramCalendar.get(2)) && (localCalendar.get(5) == paramCalendar.get(5))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean a(Calendar paramCalendar)
  {
    boolean bool = true;
    if (this.jdField_b_of_type_JavaUtilCalendar == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "isSameDay return false: mCurPageDate == null");
      }
      return false;
    }
    if ((paramCalendar.get(1) == this.jdField_b_of_type_JavaUtilCalendar.get(1)) && (paramCalendar.get(2) == this.jdField_b_of_type_JavaUtilCalendar.get(2)) && (paramCalendar.get(5) == this.jdField_b_of_type_JavaUtilCalendar.get(5))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public int b()
  {
    int m = 0;
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    }
    int n = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("auth_mode_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), -1);
    if ((n == 0) || (1 == n)) {
      m = n;
    }
    return m;
  }
  
  public BitSet b(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    BitSet localBitSet = new BitSet();
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a();
    Calendar localCalendar;
    if (!localList.isEmpty())
    {
      localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(paramCalendar1.getTimeInMillis());
      int m = 0;
      if ((localCalendar.before(paramCalendar2)) || (localCalendar.equals(paramCalendar2)))
      {
        int i3 = localCalendar.get(1);
        int i4 = localCalendar.get(2) + 1;
        localCalendar.get(5);
        paramCalendar1 = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_d_of_type_JavaLangString, i3, i4);
        int n = 0;
        int i2 = 0;
        while (n < localList.size())
        {
          int i1 = m;
          if (((String)((Map.Entry)localList.get(n)).getKey()).equals(paramCalendar1))
          {
            RoamDate localRoamDate = (RoamDate)((Map.Entry)localList.get(n)).getValue();
            i1 = localCalendar.get(5);
            if (i1 <= RoamDate.getDays(i3, i4))
            {
              if (this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(localRoamDate, i1 - 1))
              {
                localBitSet.set(m, true);
                if (QLog.isColorLevel()) {
                  QLog.d("TimeLineView", 2, paramCalendar1 + "-" + i1 + ",index= " + m + ",mask=" + localBitSet.get(m));
                }
              }
              for (;;)
              {
                m += 1;
                i1 += 1;
                break;
                localBitSet.set(m, false);
              }
            }
            i2 = 1;
            i1 = m;
          }
          n += 1;
          m = i1;
        }
        if (i2 != 0) {
          break label423;
        }
        n = m + RoamDate.getDays(i3, i4);
        m = n;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.roammsg.MessageRoamManager", 2, paramCalendar1 + " no roamDate add =" + RoamDate.getDays(i3, i4) + ",index=" + n);
          m = n;
        }
      }
    }
    label423:
    for (;;)
    {
      localCalendar.add(2, 1);
      localCalendar.set(5, 1);
      break;
      return localBitSet;
    }
  }
  
  public Calendar b()
  {
    if (this.jdField_c_of_type_Boolean) {
      return this.jdField_c_of_type_JavaUtilCalendar;
    }
    return this.f;
  }
  
  public void b()
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_passwordmd5_and_signature_file", 0).edit();
    localEditor.remove("vip_message_roam_passwordmd5" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).commit();
    this.jdField_a_of_type_ArrayOfByte = null;
    localEditor.putLong("vip_message_roam_last_request_timestamp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0L);
    localEditor.commit();
  }
  
  public void b(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, paramInt1);
    localCalendar.set(2, paramInt2 - 1);
    localCalendar.set(5, paramInt3);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_d_of_type_JavaLangString, 0);
    Object localObject;
    if (localList != null)
    {
      localObject = localList;
      if (!localList.isEmpty()) {}
    }
    else
    {
      localObject = a((Calendar)localCalendar.clone());
      localObject = a(this.jdField_d_of_type_JavaLangString, ((Long)((Pair)localObject).first).longValue(), ((Long)((Pair)localObject).second).longValue());
    }
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (b(((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).time, (Calendar)localCalendar.clone())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "judgeLatestMsgInToday: friendUin = " + this.jdField_d_of_type_JavaLangString + ", year/month/day = " + paramInt1 + "/" + paramInt2 + "/" + paramInt3);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_d_of_type_JavaLangString, localCalendar.getTimeInMillis() / 1000L, 2);
    }
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    String str = paramMessageRecord.frienduin;
    long l1 = paramMessageRecord.time;
    if (this.jdField_d_of_type_JavaLangString == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(str);
    }
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTimeInMillis(1000L * l1);
    Object localObject2 = a((Calendar)((Calendar)localObject1).clone());
    List localList;
    if (this.jdField_d_of_type_JavaLangString != null)
    {
      localObject1 = this.jdField_d_of_type_JavaLangString;
      localList = a((String)localObject1, ((Long)((Pair)localObject2).first).longValue(), ((Long)((Pair)localObject2).second).longValue());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("judgeClearRoamDateIndex: friendUin = ");
        if (this.jdField_d_of_type_JavaLangString != null) {
          break label377;
        }
        localObject1 = str;
        label124:
        localStringBuilder = localStringBuilder.append((String)localObject1).append(", dayList.size() = ");
        if (localList != null) {
          break label385;
        }
        localObject1 = "null";
        label147:
        QLog.d("Q.roammsg.MessageRoamManager", 2, localObject1);
      }
      localObject1 = new ArrayList();
      if ((paramMessageRecord instanceof MessageForLongMsg))
      {
        ((List)localObject1).addAll(((MessageForLongMsg)paramMessageRecord).longMsgFragmentList);
        if (QLog.isColorLevel()) {
          QLog.d("Q.roammsg.MessageRoamManager", 2, "judgeClearRoamDateIndex: delList.size() = " + ((List)localObject1).size());
        }
      }
      if (!((List)localObject1).isEmpty()) {
        break label404;
      }
      if ((localList != null) && (localList.size() == 1))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache;
        if (this.jdField_d_of_type_JavaLangString == null) {
          break label399;
        }
        paramMessageRecord = this.jdField_d_of_type_JavaLangString;
        label270:
        ((RoamDateCache)localObject1).a(paramMessageRecord, l1 - 5L, 1);
        paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache;
        if (this.jdField_d_of_type_JavaLangString != null) {
          str = this.jdField_d_of_type_JavaLangString;
        }
        paramMessageRecord.b(str, l1 - 5L, 0);
        if (QLog.isColorLevel()) {
          QLog.d("Q.roammsg.MessageRoamManager", 2, "judgeClearRoamDateIndex: " + l1);
        }
        if (this.jdField_d_of_type_JavaLangString != null) {
          b(l1);
        }
      }
    }
    label377:
    label385:
    label399:
    label404:
    do
    {
      if (this.jdField_d_of_type_JavaLangString == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.d();
      }
      return;
      localObject1 = str;
      break;
      localObject1 = this.jdField_d_of_type_JavaLangString;
      break label124;
      localObject1 = Integer.valueOf(localList.size());
      break label147;
      paramMessageRecord = str;
      break label270;
      if (((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).time > ((Long)((Pair)localObject2).second).longValue()) {
        break label572;
      }
    } while ((localList == null) || (localList.size() != ((List)localObject1).size()));
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache;
    if (this.jdField_d_of_type_JavaLangString != null) {}
    for (paramMessageRecord = this.jdField_d_of_type_JavaLangString;; paramMessageRecord = str)
    {
      ((RoamDateCache)localObject1).a(paramMessageRecord, l1 - 5L, 1);
      paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache;
      if (this.jdField_d_of_type_JavaLangString != null) {
        str = this.jdField_d_of_type_JavaLangString;
      }
      paramMessageRecord.b(str, l1 - 5L, 0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "judgeClearRoamDateIndex: " + l1);
      }
      if (this.jdField_d_of_type_JavaLangString == null) {
        break;
      }
      b(l1);
      break;
    }
    label572:
    int n = 0;
    int m = ((List)localObject1).size();
    paramMessageRecord = ((List)localObject1).iterator();
    label590:
    if (paramMessageRecord.hasNext())
    {
      if (((MessageRecord)paramMessageRecord.next()).time > ((Long)((Pair)localObject2).second).longValue()) {
        break label1076;
      }
      n += 1;
      m -= 1;
    }
    label676:
    label707:
    label820:
    label876:
    label898:
    label1035:
    label1040:
    label1050:
    label1058:
    label1071:
    label1076:
    for (;;)
    {
      break label590;
      if ((localList != null) && (localList.size() == n))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache;
        if (this.jdField_d_of_type_JavaLangString == null) {
          break label1035;
        }
        paramMessageRecord = this.jdField_d_of_type_JavaLangString;
        ((RoamDateCache)localObject2).a(paramMessageRecord, l1 - 5L, 1);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache;
        if (this.jdField_d_of_type_JavaLangString == null) {
          break label1040;
        }
        paramMessageRecord = this.jdField_d_of_type_JavaLangString;
        ((RoamDateCache)localObject2).b(paramMessageRecord, l1 - 5L, 0);
        if (QLog.isColorLevel()) {
          QLog.d("Q.roammsg.MessageRoamManager", 2, "judgeClearRoamDateIndex: " + l1);
        }
        if (this.jdField_d_of_type_JavaLangString != null) {
          b(l1);
        }
      }
      l1 = ((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).time;
      paramMessageRecord = Calendar.getInstance();
      paramMessageRecord.setTimeInMillis(1000L * l1);
      localObject1 = a(paramMessageRecord);
      if (this.jdField_d_of_type_JavaLangString != null)
      {
        paramMessageRecord = this.jdField_d_of_type_JavaLangString;
        localObject1 = a(paramMessageRecord, ((Long)((Pair)localObject1).first).longValue(), ((Long)((Pair)localObject1).second).longValue());
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("judgeClearRoamDateIndex: friendUin = ");
          if (this.jdField_d_of_type_JavaLangString != null) {
            break label1050;
          }
          paramMessageRecord = str;
          localObject2 = ((StringBuilder)localObject2).append(paramMessageRecord).append(", tomorrowList.size() = ");
          if (localObject1 != null) {
            break label1058;
          }
          paramMessageRecord = "null";
          QLog.d("Q.roammsg.MessageRoamManager", 2, paramMessageRecord);
        }
        if ((localObject1 == null) || (((List)localObject1).size() != m)) {
          break;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache;
        if (this.jdField_d_of_type_JavaLangString == null) {
          break label1071;
        }
      }
      for (paramMessageRecord = this.jdField_d_of_type_JavaLangString;; paramMessageRecord = str)
      {
        ((RoamDateCache)localObject1).a(paramMessageRecord, l1 - 5L, 1);
        paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache;
        if (this.jdField_d_of_type_JavaLangString != null) {
          str = this.jdField_d_of_type_JavaLangString;
        }
        paramMessageRecord.b(str, l1 - 5L, 0);
        if (QLog.isColorLevel()) {
          QLog.d("Q.roammsg.MessageRoamManager", 2, "judgeClearRoamDateIndex: " + l1);
        }
        if (this.jdField_d_of_type_JavaLangString == null) {
          break;
        }
        b(l1);
        break;
        paramMessageRecord = str;
        break label676;
        paramMessageRecord = str;
        break label707;
        paramMessageRecord = str;
        break label820;
        paramMessageRecord = this.jdField_d_of_type_JavaLangString;
        break label876;
        paramMessageRecord = Integer.valueOf(((List)localObject1).size());
        break label898;
      }
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class).obtainMessage(10, paramString).sendToTarget();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((short)1, (byte)1);
  }
  
  public void b(Calendar paramCalendar)
  {
    if (this.e == null) {
      this.e = Calendar.getInstance();
    }
    this.e.set(1, paramCalendar.get(1));
    this.e.set(2, paramCalendar.get(2));
    this.e.set(5, paramCalendar.get(5));
    this.e.set(11, 0);
    this.e.set(12, 0);
    this.e.set(13, 0);
    this.e.set(14, 0);
    a(this.e);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    Object localObject2;
    if (this.jdField_c_of_type_Boolean)
    {
      localObject2 = this.jdField_c_of_type_JavaUtilCalendar;
      if (!this.jdField_c_of_type_Boolean) {
        break label110;
      }
      localObject1 = this.jdField_b_of_type_JavaUtilCalendar;
      label24:
      if ((localObject2 != null) && (localObject1 != null)) {
        break label132;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("isFirstPage: firstPageDate ");
        if (localObject2 != null) {
          break label118;
        }
        localObject2 = "==";
        label60:
        localObject2 = localStringBuilder.append((String)localObject2).append(" null, curPageDate ");
        if (localObject1 != null) {
          break label125;
        }
      }
    }
    label110:
    label118:
    label125:
    for (Object localObject1 = "==";; localObject1 = "!=")
    {
      QLog.d("Q.roammsg.MessageRoamManager", 2, (String)localObject1 + " null");
      return true;
      localObject2 = this.f;
      break;
      localObject1 = this.e;
      break label24;
      localObject2 = "!=";
      break label60;
    }
    label132:
    return (((Calendar)localObject2).get(1) >= ((Calendar)localObject1).get(1)) && (((Calendar)localObject2).get(2) >= ((Calendar)localObject1).get(2)) && (((Calendar)localObject2).get(5) >= ((Calendar)localObject1).get(5));
  }
  
  public byte[] b()
  {
    int m = b();
    if (m == 0) {
      return this.jdField_a_of_type_ArrayOfByte;
    }
    if (1 == m) {
      return c();
    }
    return null;
  }
  
  public Calendar c()
  {
    if (this.jdField_c_of_type_Boolean) {
      return this.jdField_d_of_type_JavaUtilCalendar;
    }
    return this.g;
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a();
    if (localObject != null)
    {
      if (QLog.isColorLevel())
      {
        int m = ((Calendar)((Pair)localObject).first).get(1);
        int n = ((Calendar)((Pair)localObject).first).get(2);
        int i1 = ((Calendar)((Pair)localObject).first).get(5);
        int i2 = ((Calendar)((Pair)localObject).second).get(1);
        int i3 = ((Calendar)((Pair)localObject).second).get(2);
        int i4 = ((Calendar)((Pair)localObject).second).get(5);
        QLog.d("Q.roammsg.MessageRoamManager", 2, "setPageDateRange: first = " + m + "-" + (n + 1) + "-" + i1 + ", second = " + i2 + "-" + (i3 + 1) + "-" + i4);
      }
      this.jdField_c_of_type_JavaUtilCalendar = ((Calendar)((Pair)localObject).first);
      this.jdField_d_of_type_JavaUtilCalendar = ((Calendar)((Pair)localObject).second);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).edit();
      ((SharedPreferences.Editor)localObject).putLong("first_page_date" + this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaUtilCalendar.getTimeInMillis());
      ((SharedPreferences.Editor)localObject).putLong("last_page_date" + this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_JavaUtilCalendar.getTimeInMillis());
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "setPageDateRange: null");
    }
    this.jdField_c_of_type_JavaUtilCalendar = null;
    this.jdField_d_of_type_JavaUtilCalendar = null;
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("auth_mode_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramInt).apply();
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("auth_mode_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramInt).commit();
  }
  
  public void c(String paramString)
  {
    d(paramString);
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
    switch (this.k)
    {
    }
    for (;;)
    {
      this.k = -1;
      return;
      paramString.sendMessageDelayed(paramString.obtainMessage(23), 0L);
      continue;
      paramString.sendMessageDelayed(paramString.obtainMessage(24), 0L);
    }
  }
  
  public void c(Calendar paramCalendar)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramCalendar))
    {
      int m = paramCalendar.get(1);
      int n = paramCalendar.get(2);
      int i1 = paramCalendar.get(5);
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "startPreloadCalendar: Calendar key = " + m + "-" + (n + 1) + "-" + i1);
      }
      RoamMessagePreloadInfo localRoamMessagePreloadInfo = (RoamMessagePreloadInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramCalendar);
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramCalendar);
      if (localRoamMessagePreloadInfo.preloadType != 0)
      {
        d(localRoamMessagePreloadInfo.nextday);
        d(localRoamMessagePreloadInfo.previousday);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("first_use_devlock_for_roam_message_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramBoolean).apply();
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("first_use_devlock_for_roam_message_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramBoolean).commit();
  }
  
  public boolean c()
  {
    Object localObject2;
    if (this.jdField_c_of_type_Boolean)
    {
      localObject2 = this.jdField_d_of_type_JavaUtilCalendar;
      if (!this.jdField_c_of_type_Boolean) {
        break label110;
      }
      localObject1 = this.jdField_b_of_type_JavaUtilCalendar;
      label24:
      if ((localObject2 != null) && (localObject1 != null)) {
        break label132;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("isLastPage: lastPageDate ");
        if (localObject2 != null) {
          break label118;
        }
        localObject2 = "==";
        label60:
        localObject2 = localStringBuilder.append((String)localObject2).append(" null, curPageDate ");
        if (localObject1 != null) {
          break label125;
        }
      }
    }
    label110:
    label118:
    label125:
    for (Object localObject1 = "==";; localObject1 = "!=")
    {
      QLog.d("Q.roammsg.MessageRoamManager", 2, (String)localObject1 + " null");
      return true;
      localObject2 = this.g;
      break;
      localObject1 = this.e;
      break label24;
      localObject2 = "!=";
      break label60;
    }
    label132:
    return (((Calendar)localObject2).get(1) <= ((Calendar)localObject1).get(1)) && (((Calendar)localObject2).get(2) <= ((Calendar)localObject1).get(2)) && (((Calendar)localObject2).get(5) <= ((Calendar)localObject1).get(5));
  }
  
  public byte[] c()
  {
    Object localObject = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getDA2(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());; localObject = null)
    {
      if ((localObject != null) && (localObject.length > 0)) {
        return (byte[])localObject;
      }
      VasWebviewUtil.reportVasStatus("messageRoam", "da2", "0", 0, 0, 0, 0, "", "");
      return null;
    }
  }
  
  public void d()
  {
    this.l = 4;
    e();
  }
  
  public void d(String paramString)
  {
    int n = paramString.length();
    if (this.jdField_a_of_type_ArrayOfByte == null) {
      this.jdField_a_of_type_ArrayOfByte = new byte[n / 2];
    }
    int m = 0;
    while (m < n)
    {
      this.jdField_a_of_type_ArrayOfByte[(m / 2)] = ((byte)((Character.digit(paramString.charAt(m), 16) << 4) + Character.digit(paramString.charAt(m + 1), 16)));
      m += 2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "savePasswordMD5ForRoamMessage passwordMD5" + Arrays.toString(this.jdField_a_of_type_ArrayOfByte));
    }
    ThreadManager.a().post(new qau(this));
  }
  
  public void d(Calendar paramCalendar)
  {
    if (paramCalendar == null) {}
    int m;
    int n;
    int i1;
    int i2;
    int i3;
    do
    {
      return;
      m = paramCalendar.get(1);
      n = paramCalendar.get(2) + 1;
      i1 = paramCalendar.get(5);
      paramCalendar = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_d_of_type_JavaLangString, m, n);
      i2 = paramCalendar.getLocState(i1 - 1);
      i3 = paramCalendar.getSerState(i1 - 1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "preloadRoamMessage: Date = " + m + "-" + n + "-" + i1 + " locState: " + i2 + " serverState " + i3);
      }
    } while ((i2 == 3) || (i3 != 2));
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "preloadRoamMessage: preload >>>>> Date = " + m + "-" + n + "-" + i1);
    }
    paramCalendar = Calendar.getInstance();
    paramCalendar.setTime(new Date(m - 1900, n - 1, i1));
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler.a(this.jdField_d_of_type_JavaLangString, paramCalendar, false, 0, true);
  }
  
  public void d(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    long l1 = ((SharedPreferences)localObject).getLong("blue_banner_last_update_timestamp", 0L);
    long l2 = ((SharedPreferences)localObject).getInt("blue_banner_cheak_update_internal", 24);
    long l3 = NetConnInfoCenter.getServerTimeMillis();
    if ((paramBoolean) || (l3 - l1 > l2 * 3600000L) || (l3 < l1))
    {
      localObject = ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(1);
      if ((localObject != null) && (((DownloaderInterface)localObject).a("http://imgcache.qq.com/club/mobile/messageroam/xiaoximanyou2.json") == null))
      {
        DownloadTask localDownloadTask = new DownloadTask("http://imgcache.qq.com/club/mobile/messageroam/xiaoximanyou2.json", new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getFilesDir(), "http://imgcache.qq.com/club/mobile/messageroam/xiaoximanyou2.json"));
        localDownloadTask.n = false;
        ((DownloaderInterface)localObject).a(localDownloadTask, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, null);
      }
    }
  }
  
  public boolean d()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void e()
  {
    if (this.jdField_c_of_type_Boolean) {}
    for (Object localObject1 = this.jdField_b_of_type_JavaUtilCalendar; localObject1 == null; localObject1 = this.e)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.roammsg.MessageRoamManager", 2, "getMessageByDay error:curPageDate == null");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      int m = ((Calendar)localObject1).get(1);
      int n = ((Calendar)localObject1).get(2);
      int i1 = ((Calendar)localObject1).get(5);
      QLog.d("Q.roammsg.MessageRoamManager", 2, "getMessageByDay: friendUin = " + this.jdField_d_of_type_JavaLangString + ", curPageDate = " + m + "-" + (n + 1) + "-" + i1);
    }
    localObject1 = a((Calendar)((Calendar)localObject1).clone());
    long l1 = ((Long)((Pair)localObject1).second).longValue();
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilCalendar != null)
    {
      localObject2 = a((Calendar)this.jdField_a_of_type_JavaUtilCalendar.clone());
      if (((Long)((Pair)localObject2).second).longValue() > l1) {
        l1 = ((Long)((Pair)localObject2).second).longValue();
      }
    }
    for (;;)
    {
      String str = " time BETWEEN " + ((Pair)localObject1).first + " AND " + l1;
      localObject1 = MessageRecord.getTableName(this.jdField_d_of_type_JavaLangString, 0);
      localObject2 = MessageRecord.getOldTableName(this.jdField_d_of_type_JavaLangString, 0);
      str = "( msgtype " + MsgProxyUtils.b() + " and isValid=1 and" + str + " ) " + "ORDER BY time asc , longMsgIndex asc";
      ThreadManager.b().post(new qaq(this, (String)localObject1, (String)localObject2, str));
      return;
    }
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("auth_mode_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), -1) != -1;
  }
  
  public void f()
  {
    switch (this.l)
    {
    default: 
      g();
    case 4: 
      return;
    case 0: 
    case 1: 
    case 2: 
      a(2, null, false);
      return;
    }
    a(3, null, false);
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    }
    return 1 == this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("message_roam_is_set_password" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), -1);
  }
  
  public void g()
  {
    this.l = -1;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
  }
  
  public boolean g()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("message_roam_flag" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 1) != 1;
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_d_of_type_JavaLangString);
  }
  
  public boolean h()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("first_use_devlock_for_roam_message_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false);
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.f();
  }
  
  public boolean i()
  {
    boolean bool1 = false;
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {}
    boolean bool2;
    do
    {
      return bool1;
      if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
        this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
      }
      bool2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("delServerRoamMSg_" + this.jdField_d_of_type_JavaLangString, false);
      bool1 = bool2;
    } while (!bool2);
    m();
    return bool2;
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.e();
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).edit();
    localEditor.remove("first_page_date" + this.jdField_d_of_type_JavaLangString);
    localEditor.remove("last_page_date" + this.jdField_d_of_type_JavaLangString);
    localEditor.commit();
  }
  
  public boolean j()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      q();
      this.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "canSearchInCloud: " + this.jdField_b_of_type_Boolean + ", mShowRoamFlag: " + this.jdField_c_of_type_Boolean);
    }
    return (this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean);
  }
  
  public void k()
  {
    ThreadManager.b().post(new qav(this));
  }
  
  public void l()
  {
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "mFriendUin is null");
      }
    }
    for (;;)
    {
      return;
      Object localObject = a();
      if ((localObject == null) || (((List)localObject).isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.roammsg.MessageRoamManager", 2, "mergerLocTimeLine  no message");
        }
        i();
        return;
      }
      Calendar localCalendar = Calendar.getInstance();
      Iterator localIterator = ((List)localObject).iterator();
      int m = 0;
      int n = 0;
      label85:
      int i2;
      for (int i1 = 0; localIterator.hasNext(); i1 = i2)
      {
        localCalendar.setTimeInMillis(((MessageRecord)localIterator.next()).time * 1000L);
        i2 = localCalendar.get(1);
        int i3 = localCalendar.get(2) + 1;
        int i4 = localCalendar.get(5);
        if ((i1 == i2) && (i3 == n) && (i4 == m)) {
          break label85;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.roammsg.MessageRoamManager", 2, "mergerLocTimeLine add local msg: " + i2 + "-" + i3 + "-" + i4);
        }
        RoamDate localRoamDate = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_d_of_type_JavaLangString, i2, i3);
        localObject = localRoamDate;
        if (localRoamDate == null) {
          localObject = new RoamDate(String.valueOf(this.jdField_d_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(i2, i3));
        }
        if (2 != ((RoamDate)localObject).getSerState(i4 - 1))
        {
          ((RoamDate)localObject).setLocState(i4 - 1, 3);
          this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a((RoamDate)localObject);
        }
        m = i4;
        n = i3;
      }
    }
  }
  
  public void m()
  {
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      return;
    }
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("delServerRoamMSg_" + this.jdField_d_of_type_JavaLangString, false).apply();
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("delServerRoamMSg_" + this.jdField_d_of_type_JavaLangString, false).commit();
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "parseCloudSearchCfg start....");
    }
    Object localObject1 = new File(MessageRoamConstants.E);
    int m;
    Object localObject4;
    Object localObject2;
    Object localObject3;
    int i1;
    int n;
    if ((((File)localObject1).isFile()) && (((File)localObject1).exists()))
    {
      localObject1 = FileUtils.a((File)localObject1);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        try
        {
          JSONArray localJSONArray = new JSONObject((String)localObject1).getJSONObject("data").getJSONArray("searchStrategy");
          m = 0;
          if (m < localJSONArray.length())
          {
            localObject4 = (JSONObject)localJSONArray.get(0);
            localObject1 = ((JSONObject)localObject4).getString("version");
            if ((TextUtils.isEmpty((CharSequence)localObject1)) || ("6.5.5".compareTo(((String)localObject1).substring(0, "6.5.5".length())) < 0))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.roammsg.MessageRoamManager", 2, "curr ver: 6.5.5, config qqVer:" + (String)localObject1);
              }
            }
            else
            {
              localObject1 = ((JSONObject)localObject4).getString("canSearchInCloud");
              if (!"1".equals(localObject1))
              {
                if (!QLog.isColorLevel()) {
                  break label919;
                }
                QLog.d("Q.roammsg.MessageRoamManager", 2, "parseCloudSearchCfg Field[canSearchInCloud]: " + (String)localObject1);
              }
            }
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.roammsg.MessageRoamManager", 2, "parse cloudSearchcfg failed " + localException.getMessage());
          }
          this.jdField_b_of_type_Boolean = false;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.roammsg.MessageRoamManager", 2, "parseCloudSearchCfg done .... canCloudSearch: " + this.jdField_b_of_type_Boolean);
        }
        label348:
        do
        {
          return;
          localObject2 = ((JSONObject)localObject4).getString("whiteList");
          if ((TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject2).length() <= 2)) {
            break;
          }
          localObject2 = ((String)localObject2).substring(1, ((String)localObject2).length() - 1);
          localObject3 = ((String)localObject2).split(",");
          i1 = localObject3.length;
          n = 0;
          if (n >= i1) {
            break;
          }
          if (!localObject3[n].equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
            break label928;
          }
          this.jdField_b_of_type_Boolean = true;
        } while (!QLog.isColorLevel());
        QLog.d("Q.roammsg.MessageRoamManager", 2, "match Field[whitlist]:" + (String)localObject2);
        return;
        localObject3 = ((JSONObject)localObject4).getString("userType");
        localObject2 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label913;
        }
        localObject2 = localObject3;
        if (((String)localObject3).length() <= 2) {
          break label913;
        }
        localObject3 = ((String)localObject3).substring(1, ((String)localObject3).length() - 1);
        localObject2 = ((String)localObject3).split(",");
        ArrayList localArrayList = new ArrayList();
        i1 = localObject2.length;
        n = 0;
        label474:
        if (n < i1)
        {
          str = localObject2[n];
          if (str.equalsIgnoreCase("svip"))
          {
            localArrayList.add("2");
            break label937;
          }
          if (str.equalsIgnoreCase("vip"))
          {
            localArrayList.add("1");
            break label937;
          }
          if (!str.equalsIgnoreCase("normal")) {
            break label937;
          }
          localArrayList.add("0");
          break label937;
        }
        String str = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        if (localArrayList.contains("0")) {
          break label946;
        }
        localObject2 = localObject3;
        if (!localArrayList.contains(str)) {
          break label913;
        }
        break label946;
      }
    }
    for (;;)
    {
      label608:
      if (!bool2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.roammsg.MessageRoamManager", 2, "parseCloudSearchCfg Field[userType]: " + (String)localObject2 + ", matchUserType: " + bool2);
        }
      }
      else
      {
        localObject2 = ((JSONObject)localObject4).getString("lastNumber");
        boolean bool1;
        label796:
        boolean bool3;
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).length() > 2))
        {
          localObject2 = ((String)localObject2).substring(1, ((String)localObject2).length() - 1);
          localObject3 = new ArrayList(10);
          localObject4 = ((String)localObject2).split(",");
          i1 = localObject4.length;
          n = 0;
          while (n < i1)
          {
            ((List)localObject3).add(localObject4[n]);
            n += 1;
          }
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (((List)localObject3).contains(((String)localObject4).substring(((String)localObject4).length() - 1, ((String)localObject4).length()))))
          {
            bool1 = true;
            bool3 = bool1;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.roammsg.MessageRoamManager", 2, "parseCloudSearchCfg Field[lastNumber]: " + (String)localObject2 + ", matchLastNumber: " + bool1);
              bool3 = bool1;
            }
          }
        }
        for (;;)
        {
          if ((bool2) && (bool3))
          {
            this.jdField_b_of_type_Boolean = true;
            break;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.roammsg.MessageRoamManager", 2, "parseCloudSearchCfg json text is empty");
            break;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.roammsg.MessageRoamManager", 2, "parseCloudSearchCfg file not exist");
            break;
            bool1 = false;
            break label796;
            bool3 = false;
            continue;
            label913:
            bool2 = false;
            break label608;
          }
        }
      }
      label919:
      m += 1;
      break;
      label928:
      n += 1;
      break label348;
      label937:
      n += 1;
      break label474;
      label946:
      boolean bool2 = true;
      localObject2 = localObject3;
    }
  }
  
  public void o()
  {
    ThreadManager.b().postDelayed(new qax(this), 100L);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences = null;
    this.k = -1;
    this.jdField_d_of_type_JavaLangString = null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\MessageRoamManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */