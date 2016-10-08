package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.qqstory.settings.QQStoryShieldActivity;
import com.tencent.biz.webviewplugin.ReportPlugin;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutDefault;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.util.QZoneDistributedAppCtrl;
import cooperation.qzone.util.QZoneDistributedAppCtrl.Control;
import java.util.ArrayList;
import java.util.List;
import mam;
import man;
import mao;
import map;
import maq;
import mar;
import mat;
import mau;
import mqq.os.MqqHandler;

public class ProfileCardMoreActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final int a = 0;
  public static final String a = "cur_add_source";
  public static final int b = 1;
  public static final String b = "key_nick_name";
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  public static final int i = 8;
  public static final int j = 9;
  public static final int k = 10;
  public static final int l = 11;
  public static final int m = 12;
  public static final int n = 13;
  private static final int o = 14;
  private static final int p = 1;
  private static final int q = 2;
  private static final int s = 0;
  private static final int t = 1;
  private static final int u = -1;
  long jdField_a_of_type_Long;
  public Intent a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public ProfileActivity.AllInOne a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  private ShieldListObserver jdField_a_of_type_ComTencentMobileqqAppShieldListObserver;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public QQProgressDialog a;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem b;
  private boolean jdField_b_of_type_Boolean;
  FormSimpleItem c;
  public String c;
  public FormSimpleItem d;
  private String d;
  FormSimpleItem jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_e_of_type_JavaLangString;
  FormSimpleItem jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_f_of_type_JavaLangString;
  FormSimpleItem g;
  FormSimpleItem h;
  FormSimpleItem i;
  FormSimpleItem j;
  private int r;
  
  public ProfileCardMoreActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new map(this);
    this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver = new maq(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new mar(this);
    this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = new mat(this);
  }
  
  /* Error */
  private int a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +13 -> 14
    //   4: aload_1
    //   5: invokevirtual 113	java/lang/String:trim	()Ljava/lang/String;
    //   8: invokevirtual 117	java/lang/String:length	()I
    //   11: ifne +5 -> 16
    //   14: iconst_m1
    //   15: ireturn
    //   16: aload_0
    //   17: getfield 121	com/tencent/mobileqq/activity/ProfileCardMoreActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokevirtual 126	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   23: invokevirtual 132	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   26: astore_2
    //   27: aload_2
    //   28: ifnull +3237 -> 3265
    //   31: aload_2
    //   32: ldc -122
    //   34: aload_1
    //   35: invokevirtual 139	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   38: checkcast 134	com/tencent/mobileqq/data/BmqqUserSimpleInfo
    //   41: astore 6
    //   43: aload_2
    //   44: ifnull +7 -> 51
    //   47: aload_2
    //   48: invokevirtual 141	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   51: aload 6
    //   53: ifnonnull +5 -> 58
    //   56: iconst_m1
    //   57: ireturn
    //   58: aload_0
    //   59: getfield 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   62: invokestatic 149	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   65: ifne +845 -> 910
    //   68: aload_0
    //   69: getfield 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   72: astore 4
    //   74: iconst_0
    //   75: istore 9
    //   77: iconst_0
    //   78: istore 10
    //   80: aconst_null
    //   81: astore_3
    //   82: aload_0
    //   83: invokevirtual 153	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   86: astore_2
    //   87: getstatic 159	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   90: astore 5
    //   92: new 161	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   99: ldc -92
    //   101: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload 4
    //   106: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc -86
    //   111: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: astore 7
    //   119: aload_2
    //   120: aload 5
    //   122: iconst_4
    //   123: anewarray 109	java/lang/String
    //   126: dup
    //   127: iconst_0
    //   128: ldc -81
    //   130: aastore
    //   131: dup
    //   132: iconst_1
    //   133: ldc -79
    //   135: aastore
    //   136: dup
    //   137: iconst_2
    //   138: ldc -77
    //   140: aastore
    //   141: dup
    //   142: iconst_3
    //   143: ldc -75
    //   145: aastore
    //   146: aload 7
    //   148: aconst_null
    //   149: aconst_null
    //   150: invokevirtual 187	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   153: astore_2
    //   154: iconst_0
    //   155: istore 11
    //   157: lconst_0
    //   158: lstore 15
    //   160: iload 10
    //   162: istore 9
    //   164: iload 11
    //   166: istore 10
    //   168: aload_2
    //   169: invokeinterface 193 1 0
    //   174: istore 17
    //   176: iload 17
    //   178: ifeq +3074 -> 3252
    //   181: aload_2
    //   182: iconst_0
    //   183: invokeinterface 197 2 0
    //   188: lstore 13
    //   190: iload 9
    //   192: istore 11
    //   194: aload 6
    //   196: getfield 200	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   199: astore_3
    //   200: aload_3
    //   201: ifnull +863 -> 1064
    //   204: aconst_null
    //   205: astore 5
    //   207: aload_0
    //   208: invokevirtual 153	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   211: astore_3
    //   212: getstatic 159	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   215: astore 7
    //   217: new 161	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   224: ldc -54
    //   226: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: lload 13
    //   231: invokevirtual 205	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   234: ldc -49
    //   236: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: ldc -77
    //   241: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc -47
    //   246: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: ldc -45
    //   251: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: ldc -86
    //   256: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: ldc -49
    //   261: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: ldc -75
    //   266: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: ldc -47
    //   271: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload 6
    //   276: getfield 200	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   279: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: ldc -86
    //   284: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: ldc -49
    //   289: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: ldc -43
    //   294: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: ldc -47
    //   299: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: iconst_2
    //   303: invokevirtual 216	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   306: ldc -86
    //   308: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: astore 8
    //   316: aload_3
    //   317: aload 7
    //   319: iconst_5
    //   320: anewarray 109	java/lang/String
    //   323: dup
    //   324: iconst_0
    //   325: ldc -81
    //   327: aastore
    //   328: dup
    //   329: iconst_1
    //   330: ldc -79
    //   332: aastore
    //   333: dup
    //   334: iconst_2
    //   335: ldc -77
    //   337: aastore
    //   338: dup
    //   339: iconst_3
    //   340: ldc -75
    //   342: aastore
    //   343: dup
    //   344: iconst_4
    //   345: ldc -43
    //   347: aastore
    //   348: aload 8
    //   350: aconst_null
    //   351: aconst_null
    //   352: invokevirtual 187	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   355: astore_3
    //   356: aload_3
    //   357: invokeinterface 219 1 0
    //   362: istore 17
    //   364: iload 17
    //   366: ifeq +575 -> 941
    //   369: iconst_1
    //   370: istore 10
    //   372: iconst_1
    //   373: istore 9
    //   375: aload_3
    //   376: astore 5
    //   378: aload_3
    //   379: ifnull +12 -> 391
    //   382: aload_3
    //   383: invokeinterface 222 1 0
    //   388: aconst_null
    //   389: astore 5
    //   391: aload 5
    //   393: ifnull +2850 -> 3243
    //   396: aload 5
    //   398: invokeinterface 222 1 0
    //   403: iconst_1
    //   404: istore 9
    //   406: iconst_1
    //   407: istore 10
    //   409: iload 10
    //   411: istore 12
    //   413: lload 13
    //   415: lstore 15
    //   417: iload 9
    //   419: istore 11
    //   421: aload_2
    //   422: ifnull +2806 -> 3228
    //   425: aload_2
    //   426: invokeinterface 222 1 0
    //   431: iload 10
    //   433: ifne +655 -> 1088
    //   436: iconst_1
    //   437: istore 10
    //   439: iconst_0
    //   440: istore 9
    //   442: new 224	android/content/ContentValues
    //   445: dup
    //   446: invokespecial 225	android/content/ContentValues:<init>	()V
    //   449: astore 5
    //   451: iload 10
    //   453: iconst_1
    //   454: if_icmpne +657 -> 1111
    //   457: aload_0
    //   458: invokevirtual 153	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   461: getstatic 228	android/provider/ContactsContract$RawContacts:CONTENT_URI	Landroid/net/Uri;
    //   464: aload 5
    //   466: invokevirtual 232	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   469: invokestatic 238	android/content/ContentUris:parseId	(Landroid/net/Uri;)J
    //   472: lstore 13
    //   474: aload 4
    //   476: invokestatic 149	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   479: ifne +51 -> 530
    //   482: aload 5
    //   484: invokevirtual 241	android/content/ContentValues:clear	()V
    //   487: aload 5
    //   489: ldc -81
    //   491: lload 13
    //   493: invokestatic 247	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   496: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   499: aload 5
    //   501: ldc -77
    //   503: ldc -3
    //   505: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   508: aload 5
    //   510: ldc -75
    //   512: aload 4
    //   514: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   517: aload_0
    //   518: invokevirtual 153	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   521: getstatic 159	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   524: aload 5
    //   526: invokevirtual 232	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   529: pop
    //   530: aload 6
    //   532: getfield 259	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   535: ifnonnull +11 -> 546
    //   538: aload 6
    //   540: getfield 262	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   543: ifnull +95 -> 638
    //   546: aload 5
    //   548: invokevirtual 241	android/content/ContentValues:clear	()V
    //   551: aload 5
    //   553: ldc -81
    //   555: lload 13
    //   557: invokestatic 247	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   560: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   563: aload 5
    //   565: ldc -77
    //   567: ldc_w 264
    //   570: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   573: aload 6
    //   575: getfield 262	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   578: ifnull +15 -> 593
    //   581: aload 5
    //   583: ldc -75
    //   585: aload 6
    //   587: getfield 262	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   590: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   593: aload 6
    //   595: getfield 259	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   598: ifnull +16 -> 614
    //   601: aload 5
    //   603: ldc_w 266
    //   606: aload 6
    //   608: getfield 259	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   611: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   614: aload 5
    //   616: ldc -43
    //   618: iconst_1
    //   619: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   622: invokevirtual 274	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   625: aload_0
    //   626: invokevirtual 153	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   629: getstatic 159	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   632: aload 5
    //   634: invokevirtual 232	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   637: pop
    //   638: aload 6
    //   640: getfield 200	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   643: ifnull +65 -> 708
    //   646: aload 5
    //   648: invokevirtual 241	android/content/ContentValues:clear	()V
    //   651: aload 5
    //   653: ldc -81
    //   655: lload 13
    //   657: invokestatic 247	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   660: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   663: aload 5
    //   665: ldc -77
    //   667: ldc -45
    //   669: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   672: aload 5
    //   674: ldc -75
    //   676: aload 6
    //   678: getfield 200	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   681: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   684: aload 5
    //   686: ldc -43
    //   688: iconst_2
    //   689: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   692: invokevirtual 274	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   695: aload_0
    //   696: invokevirtual 153	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   699: getstatic 159	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   702: aload 5
    //   704: invokevirtual 232	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   707: pop
    //   708: aload 6
    //   710: getfield 277	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   713: ifnull +65 -> 778
    //   716: aload 5
    //   718: invokevirtual 241	android/content/ContentValues:clear	()V
    //   721: aload 5
    //   723: ldc -81
    //   725: lload 13
    //   727: invokestatic 247	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   730: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   733: aload 5
    //   735: ldc -77
    //   737: ldc -45
    //   739: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   742: aload 5
    //   744: ldc -75
    //   746: aload 6
    //   748: getfield 277	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   751: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   754: aload 5
    //   756: ldc -43
    //   758: iconst_3
    //   759: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   762: invokevirtual 274	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   765: aload_0
    //   766: invokevirtual 153	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   769: getstatic 159	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   772: aload 5
    //   774: invokevirtual 232	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   777: pop
    //   778: aload 6
    //   780: getfield 280	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   783: ifnull +66 -> 849
    //   786: aload 5
    //   788: invokevirtual 241	android/content/ContentValues:clear	()V
    //   791: aload 5
    //   793: ldc -81
    //   795: lload 13
    //   797: invokestatic 247	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   800: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   803: aload 5
    //   805: ldc -77
    //   807: ldc_w 282
    //   810: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   813: aload 5
    //   815: ldc -75
    //   817: aload 6
    //   819: getfield 280	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   822: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   825: aload 5
    //   827: ldc -43
    //   829: iconst_2
    //   830: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   833: invokevirtual 274	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   836: aload_0
    //   837: invokevirtual 153	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   840: getstatic 159	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   843: aload 5
    //   845: invokevirtual 232	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   848: pop
    //   849: aload 5
    //   851: invokevirtual 241	android/content/ContentValues:clear	()V
    //   854: aload 5
    //   856: ldc -81
    //   858: lload 13
    //   860: invokestatic 247	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   863: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   866: aload 5
    //   868: ldc -77
    //   870: ldc_w 284
    //   873: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   876: aload 5
    //   878: ldc -75
    //   880: aload_1
    //   881: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   884: aload 5
    //   886: ldc -43
    //   888: iconst_2
    //   889: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   892: invokevirtual 274	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   895: aload_0
    //   896: invokevirtual 153	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   899: getstatic 159	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   902: aload 5
    //   904: invokevirtual 232	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   907: pop
    //   908: iconst_0
    //   909: ireturn
    //   910: aload 6
    //   912: getfield 287	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqNickName	Ljava/lang/String;
    //   915: ifnull +13 -> 928
    //   918: aload 6
    //   920: getfield 287	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqNickName	Ljava/lang/String;
    //   923: astore 4
    //   925: goto -851 -> 74
    //   928: aload_1
    //   929: invokestatic 149	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   932: ifne +2327 -> 3259
    //   935: aload_1
    //   936: astore 4
    //   938: goto -864 -> 74
    //   941: iconst_0
    //   942: istore 9
    //   944: iconst_0
    //   945: istore 11
    //   947: iload 9
    //   949: istore 10
    //   951: aload_3
    //   952: ifnull +2319 -> 3271
    //   955: iload 11
    //   957: istore 10
    //   959: aload_3
    //   960: invokeinterface 222 1 0
    //   965: iload 9
    //   967: istore 10
    //   969: goto +2302 -> 3271
    //   972: iload 9
    //   974: istore 10
    //   976: aload_3
    //   977: ifnull +2294 -> 3271
    //   980: iload 9
    //   982: istore 10
    //   984: aload_3
    //   985: invokeinterface 222 1 0
    //   990: iload 9
    //   992: istore 10
    //   994: goto +2277 -> 3271
    //   997: astore_3
    //   998: iload 10
    //   1000: istore 9
    //   1002: iconst_1
    //   1003: istore 10
    //   1005: iload 10
    //   1007: istore 12
    //   1009: lload 13
    //   1011: lstore 15
    //   1013: iload 9
    //   1015: istore 11
    //   1017: aload_2
    //   1018: ifnull +2210 -> 3228
    //   1021: aload_2
    //   1022: invokeinterface 222 1 0
    //   1027: goto -596 -> 431
    //   1030: astore_3
    //   1031: aload 5
    //   1033: ifnull +14 -> 1047
    //   1036: iload 9
    //   1038: istore 11
    //   1040: aload 5
    //   1042: invokeinterface 222 1 0
    //   1047: iload 9
    //   1049: istore 11
    //   1051: aload_3
    //   1052: athrow
    //   1053: astore_3
    //   1054: iconst_1
    //   1055: istore 10
    //   1057: iload 11
    //   1059: istore 9
    //   1061: goto -56 -> 1005
    //   1064: iconst_0
    //   1065: istore 9
    //   1067: iconst_1
    //   1068: istore 10
    //   1070: goto -661 -> 409
    //   1073: astore_1
    //   1074: aload_3
    //   1075: astore_2
    //   1076: aload_2
    //   1077: ifnull +9 -> 1086
    //   1080: aload_2
    //   1081: invokeinterface 222 1 0
    //   1086: aload_1
    //   1087: athrow
    //   1088: iload 9
    //   1090: ifne +12 -> 1102
    //   1093: iconst_1
    //   1094: istore 10
    //   1096: iconst_0
    //   1097: istore 9
    //   1099: goto -657 -> 442
    //   1102: iconst_1
    //   1103: istore 9
    //   1105: iconst_0
    //   1106: istore 10
    //   1108: goto -666 -> 442
    //   1111: iload 9
    //   1113: iconst_1
    //   1114: if_icmpne +1992 -> 3106
    //   1117: aload 6
    //   1119: getfield 200	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   1122: ifnull +123 -> 1245
    //   1125: aload 5
    //   1127: invokevirtual 241	android/content/ContentValues:clear	()V
    //   1130: aload 5
    //   1132: ldc -77
    //   1134: ldc -45
    //   1136: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1139: aload 5
    //   1141: ldc -75
    //   1143: aload 6
    //   1145: getfield 200	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   1148: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1151: aload 5
    //   1153: ldc -43
    //   1155: iconst_2
    //   1156: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1159: invokevirtual 274	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1162: aload_0
    //   1163: invokevirtual 153	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1166: getstatic 159	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1169: aload 5
    //   1171: new 161	java/lang/StringBuilder
    //   1174: dup
    //   1175: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   1178: ldc -54
    //   1180: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1183: lload 13
    //   1185: invokevirtual 205	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1188: ldc -49
    //   1190: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1193: ldc -77
    //   1195: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: ldc -47
    //   1200: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1203: ldc -45
    //   1205: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1208: ldc -86
    //   1210: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1213: ldc -49
    //   1215: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1218: ldc -43
    //   1220: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1223: ldc -47
    //   1225: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1228: iconst_2
    //   1229: invokevirtual 216	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1232: ldc -86
    //   1234: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1237: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1240: aconst_null
    //   1241: invokevirtual 291	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1244: pop
    //   1245: aload 6
    //   1247: getfield 259	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   1250: ifnull +272 -> 1522
    //   1253: aconst_null
    //   1254: astore_2
    //   1255: aload_0
    //   1256: invokevirtual 153	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1259: astore_3
    //   1260: getstatic 159	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1263: astore 4
    //   1265: new 161	java/lang/StringBuilder
    //   1268: dup
    //   1269: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   1272: ldc -54
    //   1274: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: lload 13
    //   1279: invokevirtual 205	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1282: ldc -49
    //   1284: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1287: ldc -77
    //   1289: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1292: ldc -47
    //   1294: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1297: ldc_w 264
    //   1300: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1303: ldc -86
    //   1305: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1308: ldc -49
    //   1310: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1313: ldc -43
    //   1315: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1318: ldc -47
    //   1320: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1323: iconst_1
    //   1324: invokevirtual 216	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1327: ldc -86
    //   1329: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1332: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1335: astore 7
    //   1337: aload_3
    //   1338: aload 4
    //   1340: iconst_5
    //   1341: anewarray 109	java/lang/String
    //   1344: dup
    //   1345: iconst_0
    //   1346: ldc -81
    //   1348: aastore
    //   1349: dup
    //   1350: iconst_1
    //   1351: ldc -79
    //   1353: aastore
    //   1354: dup
    //   1355: iconst_2
    //   1356: ldc -77
    //   1358: aastore
    //   1359: dup
    //   1360: iconst_3
    //   1361: ldc_w 266
    //   1364: aastore
    //   1365: dup
    //   1366: iconst_4
    //   1367: ldc -43
    //   1369: aastore
    //   1370: aload 7
    //   1372: aconst_null
    //   1373: aconst_null
    //   1374: invokevirtual 187	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1377: astore_3
    //   1378: aload_3
    //   1379: astore_2
    //   1380: aload_2
    //   1381: invokeinterface 219 1 0
    //   1386: ifeq +1259 -> 2645
    //   1389: aload 5
    //   1391: invokevirtual 241	android/content/ContentValues:clear	()V
    //   1394: aload 5
    //   1396: ldc -77
    //   1398: ldc_w 264
    //   1401: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1404: aload 5
    //   1406: ldc_w 266
    //   1409: aload 6
    //   1411: getfield 259	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   1414: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1417: aload 5
    //   1419: ldc -43
    //   1421: iconst_1
    //   1422: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1425: invokevirtual 274	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1428: aload_0
    //   1429: invokevirtual 153	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1432: getstatic 159	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1435: aload 5
    //   1437: new 161	java/lang/StringBuilder
    //   1440: dup
    //   1441: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   1444: ldc -54
    //   1446: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1449: lload 13
    //   1451: invokevirtual 205	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1454: ldc -49
    //   1456: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1459: ldc -77
    //   1461: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1464: ldc -47
    //   1466: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1469: ldc_w 264
    //   1472: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1475: ldc -86
    //   1477: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1480: ldc -49
    //   1482: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1485: ldc -43
    //   1487: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1490: ldc -47
    //   1492: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1495: iconst_1
    //   1496: invokevirtual 216	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1499: ldc -86
    //   1501: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1504: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1507: aconst_null
    //   1508: invokevirtual 291	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1511: pop
    //   1512: aload_2
    //   1513: ifnull +9 -> 1522
    //   1516: aload_2
    //   1517: invokeinterface 222 1 0
    //   1522: aload 6
    //   1524: getfield 262	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   1527: ifnull +270 -> 1797
    //   1530: aconst_null
    //   1531: astore_2
    //   1532: aload_0
    //   1533: invokevirtual 153	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1536: astore_3
    //   1537: getstatic 159	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1540: astore 4
    //   1542: new 161	java/lang/StringBuilder
    //   1545: dup
    //   1546: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   1549: ldc -54
    //   1551: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1554: lload 13
    //   1556: invokevirtual 205	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1559: ldc -49
    //   1561: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1564: ldc -77
    //   1566: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1569: ldc -47
    //   1571: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1574: ldc_w 264
    //   1577: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1580: ldc -86
    //   1582: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1585: ldc -49
    //   1587: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1590: ldc -43
    //   1592: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1595: ldc -47
    //   1597: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1600: iconst_1
    //   1601: invokevirtual 216	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1604: ldc -86
    //   1606: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1609: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1612: astore 7
    //   1614: aload_3
    //   1615: aload 4
    //   1617: iconst_5
    //   1618: anewarray 109	java/lang/String
    //   1621: dup
    //   1622: iconst_0
    //   1623: ldc -81
    //   1625: aastore
    //   1626: dup
    //   1627: iconst_1
    //   1628: ldc -79
    //   1630: aastore
    //   1631: dup
    //   1632: iconst_2
    //   1633: ldc -77
    //   1635: aastore
    //   1636: dup
    //   1637: iconst_3
    //   1638: ldc -75
    //   1640: aastore
    //   1641: dup
    //   1642: iconst_4
    //   1643: ldc -43
    //   1645: aastore
    //   1646: aload 7
    //   1648: aconst_null
    //   1649: aconst_null
    //   1650: invokevirtual 187	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1653: astore_3
    //   1654: aload_3
    //   1655: astore_2
    //   1656: aload_2
    //   1657: invokeinterface 219 1 0
    //   1662: ifeq +1077 -> 2739
    //   1665: aload 5
    //   1667: invokevirtual 241	android/content/ContentValues:clear	()V
    //   1670: aload 5
    //   1672: ldc -77
    //   1674: ldc_w 264
    //   1677: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1680: aload 5
    //   1682: ldc -75
    //   1684: aload 6
    //   1686: getfield 262	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   1689: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1692: aload 5
    //   1694: ldc -43
    //   1696: iconst_1
    //   1697: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1700: invokevirtual 274	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1703: aload_0
    //   1704: invokevirtual 153	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1707: getstatic 159	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1710: aload 5
    //   1712: new 161	java/lang/StringBuilder
    //   1715: dup
    //   1716: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   1719: ldc -54
    //   1721: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1724: lload 13
    //   1726: invokevirtual 205	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1729: ldc -49
    //   1731: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1734: ldc -77
    //   1736: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1739: ldc -47
    //   1741: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1744: ldc_w 264
    //   1747: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1750: ldc -86
    //   1752: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1755: ldc -49
    //   1757: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1760: ldc -43
    //   1762: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1765: ldc -47
    //   1767: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1770: iconst_1
    //   1771: invokevirtual 216	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1774: ldc -86
    //   1776: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1779: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1782: aconst_null
    //   1783: invokevirtual 291	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1786: pop
    //   1787: aload_2
    //   1788: ifnull +9 -> 1797
    //   1791: aload_2
    //   1792: invokeinterface 222 1 0
    //   1797: aload 6
    //   1799: getfield 277	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   1802: ifnull +279 -> 2081
    //   1805: aconst_null
    //   1806: astore_2
    //   1807: aload_0
    //   1808: invokevirtual 153	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1811: astore_3
    //   1812: getstatic 159	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1815: astore 4
    //   1817: new 161	java/lang/StringBuilder
    //   1820: dup
    //   1821: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   1824: ldc -54
    //   1826: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1829: lload 13
    //   1831: invokevirtual 205	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1834: ldc -49
    //   1836: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1839: ldc -77
    //   1841: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1844: ldc -47
    //   1846: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1849: ldc -45
    //   1851: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1854: ldc -86
    //   1856: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1859: ldc -49
    //   1861: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1864: ldc -43
    //   1866: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1869: ldc -47
    //   1871: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1874: iconst_3
    //   1875: invokevirtual 216	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1878: ldc -86
    //   1880: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1883: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1886: astore 7
    //   1888: aload_3
    //   1889: aload 4
    //   1891: iconst_5
    //   1892: anewarray 109	java/lang/String
    //   1895: dup
    //   1896: iconst_0
    //   1897: ldc -81
    //   1899: aastore
    //   1900: dup
    //   1901: iconst_1
    //   1902: ldc -79
    //   1904: aastore
    //   1905: dup
    //   1906: iconst_2
    //   1907: ldc -77
    //   1909: aastore
    //   1910: dup
    //   1911: iconst_3
    //   1912: ldc -75
    //   1914: aastore
    //   1915: dup
    //   1916: iconst_4
    //   1917: ldc -43
    //   1919: aastore
    //   1920: aload 7
    //   1922: aconst_null
    //   1923: aconst_null
    //   1924: invokevirtual 187	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1927: astore_3
    //   1928: aload_3
    //   1929: astore_2
    //   1930: aload_2
    //   1931: invokeinterface 219 1 0
    //   1936: ifeq +896 -> 2832
    //   1939: aload 5
    //   1941: invokevirtual 241	android/content/ContentValues:clear	()V
    //   1944: aload 5
    //   1946: ldc -81
    //   1948: lload 13
    //   1950: invokestatic 247	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1953: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   1956: aload 5
    //   1958: ldc -77
    //   1960: ldc -45
    //   1962: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1965: aload 5
    //   1967: ldc -75
    //   1969: aload 6
    //   1971: getfield 277	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   1974: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1977: aload 5
    //   1979: ldc -43
    //   1981: iconst_3
    //   1982: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1985: invokevirtual 274	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1988: aload_0
    //   1989: invokevirtual 153	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1992: getstatic 159	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1995: aload 5
    //   1997: new 161	java/lang/StringBuilder
    //   2000: dup
    //   2001: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   2004: ldc -54
    //   2006: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2009: lload 13
    //   2011: invokevirtual 205	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2014: ldc -49
    //   2016: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2019: ldc -77
    //   2021: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2024: ldc -47
    //   2026: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2029: ldc -45
    //   2031: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2034: ldc -86
    //   2036: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2039: ldc -49
    //   2041: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2044: ldc -43
    //   2046: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2049: ldc -47
    //   2051: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2054: iconst_3
    //   2055: invokevirtual 216	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2058: ldc -86
    //   2060: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2063: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2066: aconst_null
    //   2067: invokevirtual 291	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2070: pop
    //   2071: aload_2
    //   2072: ifnull +9 -> 2081
    //   2075: aload_2
    //   2076: invokeinterface 222 1 0
    //   2081: aload 6
    //   2083: getfield 280	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   2086: ifnull +282 -> 2368
    //   2089: aconst_null
    //   2090: astore_2
    //   2091: aload_0
    //   2092: invokevirtual 153	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2095: astore_3
    //   2096: getstatic 159	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2099: astore 4
    //   2101: new 161	java/lang/StringBuilder
    //   2104: dup
    //   2105: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   2108: ldc -54
    //   2110: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2113: lload 13
    //   2115: invokevirtual 205	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2118: ldc -49
    //   2120: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2123: ldc -77
    //   2125: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2128: ldc -47
    //   2130: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2133: ldc_w 282
    //   2136: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2139: ldc -86
    //   2141: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2144: ldc -49
    //   2146: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2149: ldc -43
    //   2151: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2154: ldc -47
    //   2156: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2159: iconst_2
    //   2160: invokevirtual 216	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2163: ldc -86
    //   2165: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2168: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2171: astore 7
    //   2173: aload_3
    //   2174: aload 4
    //   2176: iconst_5
    //   2177: anewarray 109	java/lang/String
    //   2180: dup
    //   2181: iconst_0
    //   2182: ldc -81
    //   2184: aastore
    //   2185: dup
    //   2186: iconst_1
    //   2187: ldc -79
    //   2189: aastore
    //   2190: dup
    //   2191: iconst_2
    //   2192: ldc -77
    //   2194: aastore
    //   2195: dup
    //   2196: iconst_3
    //   2197: ldc -75
    //   2199: aastore
    //   2200: dup
    //   2201: iconst_4
    //   2202: ldc -43
    //   2204: aastore
    //   2205: aload 7
    //   2207: aconst_null
    //   2208: aconst_null
    //   2209: invokevirtual 187	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2212: astore_3
    //   2213: aload_3
    //   2214: astore_2
    //   2215: aload_2
    //   2216: invokeinterface 219 1 0
    //   2221: ifeq +703 -> 2924
    //   2224: aload 5
    //   2226: invokevirtual 241	android/content/ContentValues:clear	()V
    //   2229: aload 5
    //   2231: ldc -81
    //   2233: lload 13
    //   2235: invokestatic 247	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2238: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2241: aload 5
    //   2243: ldc -77
    //   2245: ldc_w 282
    //   2248: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2251: aload 5
    //   2253: ldc -75
    //   2255: aload 6
    //   2257: getfield 280	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   2260: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2263: aload 5
    //   2265: ldc -43
    //   2267: iconst_2
    //   2268: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2271: invokevirtual 274	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2274: aload_0
    //   2275: invokevirtual 153	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2278: getstatic 159	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2281: aload 5
    //   2283: new 161	java/lang/StringBuilder
    //   2286: dup
    //   2287: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   2290: ldc -54
    //   2292: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2295: lload 13
    //   2297: invokevirtual 205	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2300: ldc -49
    //   2302: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2305: ldc -77
    //   2307: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2310: ldc -47
    //   2312: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2315: ldc_w 282
    //   2318: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2321: ldc -86
    //   2323: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2326: ldc -49
    //   2328: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2331: ldc -43
    //   2333: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2336: ldc -47
    //   2338: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2341: iconst_2
    //   2342: invokevirtual 216	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2345: ldc -86
    //   2347: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2350: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2353: aconst_null
    //   2354: invokevirtual 291	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2357: pop
    //   2358: aload_2
    //   2359: ifnull +9 -> 2368
    //   2362: aload_2
    //   2363: invokeinterface 222 1 0
    //   2368: aconst_null
    //   2369: astore_2
    //   2370: aload_0
    //   2371: invokevirtual 153	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2374: astore_3
    //   2375: getstatic 159	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2378: astore 4
    //   2380: new 161	java/lang/StringBuilder
    //   2383: dup
    //   2384: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   2387: ldc -54
    //   2389: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2392: lload 13
    //   2394: invokevirtual 205	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2397: ldc -49
    //   2399: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2402: ldc -77
    //   2404: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2407: ldc -47
    //   2409: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2412: ldc_w 284
    //   2415: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2418: ldc -86
    //   2420: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2423: ldc -49
    //   2425: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2428: ldc -43
    //   2430: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2433: ldc -47
    //   2435: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2438: iconst_2
    //   2439: invokevirtual 216	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2442: ldc -86
    //   2444: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2447: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2450: astore 6
    //   2452: aload_3
    //   2453: aload 4
    //   2455: iconst_5
    //   2456: anewarray 109	java/lang/String
    //   2459: dup
    //   2460: iconst_0
    //   2461: ldc -81
    //   2463: aastore
    //   2464: dup
    //   2465: iconst_1
    //   2466: ldc -79
    //   2468: aastore
    //   2469: dup
    //   2470: iconst_2
    //   2471: ldc -77
    //   2473: aastore
    //   2474: dup
    //   2475: iconst_3
    //   2476: ldc -75
    //   2478: aastore
    //   2479: dup
    //   2480: iconst_4
    //   2481: ldc -43
    //   2483: aastore
    //   2484: aload 6
    //   2486: aconst_null
    //   2487: aconst_null
    //   2488: invokevirtual 187	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2491: astore_3
    //   2492: aload_3
    //   2493: astore_2
    //   2494: aload_2
    //   2495: invokeinterface 219 1 0
    //   2500: ifeq +517 -> 3017
    //   2503: aload 5
    //   2505: invokevirtual 241	android/content/ContentValues:clear	()V
    //   2508: aload 5
    //   2510: ldc -81
    //   2512: lload 13
    //   2514: invokestatic 247	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2517: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2520: aload 5
    //   2522: ldc -77
    //   2524: ldc_w 284
    //   2527: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2530: aload 5
    //   2532: ldc -75
    //   2534: aload_1
    //   2535: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2538: aload 5
    //   2540: ldc -43
    //   2542: iconst_2
    //   2543: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2546: invokevirtual 274	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2549: aload_0
    //   2550: invokevirtual 153	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2553: getstatic 159	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2556: aload 5
    //   2558: new 161	java/lang/StringBuilder
    //   2561: dup
    //   2562: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   2565: ldc -54
    //   2567: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2570: lload 13
    //   2572: invokevirtual 205	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2575: ldc -49
    //   2577: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2580: ldc -77
    //   2582: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2585: ldc -47
    //   2587: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2590: ldc_w 284
    //   2593: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2596: ldc -86
    //   2598: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2601: ldc -49
    //   2603: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2606: ldc -43
    //   2608: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2611: ldc -47
    //   2613: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2616: iconst_2
    //   2617: invokevirtual 216	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2620: ldc -86
    //   2622: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2625: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2628: aconst_null
    //   2629: invokevirtual 291	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2632: pop
    //   2633: aload_2
    //   2634: ifnull +9 -> 2643
    //   2637: aload_2
    //   2638: invokeinterface 222 1 0
    //   2643: iconst_1
    //   2644: ireturn
    //   2645: aload 5
    //   2647: invokevirtual 241	android/content/ContentValues:clear	()V
    //   2650: aload 5
    //   2652: ldc -81
    //   2654: lload 13
    //   2656: invokestatic 247	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2659: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2662: aload 5
    //   2664: ldc -77
    //   2666: ldc_w 264
    //   2669: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2672: aload 5
    //   2674: ldc_w 266
    //   2677: aload 6
    //   2679: getfield 259	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   2682: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2685: aload 5
    //   2687: ldc -43
    //   2689: iconst_1
    //   2690: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2693: invokevirtual 274	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2696: aload_0
    //   2697: invokevirtual 153	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2700: getstatic 159	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2703: aload 5
    //   2705: invokevirtual 232	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2708: pop
    //   2709: goto -1197 -> 1512
    //   2712: astore_3
    //   2713: aload_2
    //   2714: ifnull -1192 -> 1522
    //   2717: aload_2
    //   2718: invokeinterface 222 1 0
    //   2723: goto -1201 -> 1522
    //   2726: astore_1
    //   2727: aload_2
    //   2728: ifnull +9 -> 2737
    //   2731: aload_2
    //   2732: invokeinterface 222 1 0
    //   2737: aload_1
    //   2738: athrow
    //   2739: aload 5
    //   2741: invokevirtual 241	android/content/ContentValues:clear	()V
    //   2744: aload 5
    //   2746: ldc -81
    //   2748: lload 13
    //   2750: invokestatic 247	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2753: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2756: aload 5
    //   2758: ldc -77
    //   2760: ldc_w 264
    //   2763: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2766: aload 5
    //   2768: ldc -75
    //   2770: aload 6
    //   2772: getfield 262	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   2775: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2778: aload 5
    //   2780: ldc -43
    //   2782: iconst_1
    //   2783: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2786: invokevirtual 274	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2789: aload_0
    //   2790: invokevirtual 153	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2793: getstatic 159	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2796: aload 5
    //   2798: invokevirtual 232	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2801: pop
    //   2802: goto -1015 -> 1787
    //   2805: astore_3
    //   2806: aload_2
    //   2807: ifnull -1010 -> 1797
    //   2810: aload_2
    //   2811: invokeinterface 222 1 0
    //   2816: goto -1019 -> 1797
    //   2819: astore_1
    //   2820: aload_2
    //   2821: ifnull +9 -> 2830
    //   2824: aload_2
    //   2825: invokeinterface 222 1 0
    //   2830: aload_1
    //   2831: athrow
    //   2832: aload 5
    //   2834: invokevirtual 241	android/content/ContentValues:clear	()V
    //   2837: aload 5
    //   2839: ldc -81
    //   2841: lload 13
    //   2843: invokestatic 247	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2846: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2849: aload 5
    //   2851: ldc -77
    //   2853: ldc -45
    //   2855: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2858: aload 5
    //   2860: ldc -75
    //   2862: aload 6
    //   2864: getfield 277	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   2867: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2870: aload 5
    //   2872: ldc -43
    //   2874: iconst_3
    //   2875: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2878: invokevirtual 274	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2881: aload_0
    //   2882: invokevirtual 153	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2885: getstatic 159	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2888: aload 5
    //   2890: invokevirtual 232	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2893: pop
    //   2894: goto -823 -> 2071
    //   2897: astore_3
    //   2898: aload_2
    //   2899: ifnull -818 -> 2081
    //   2902: aload_2
    //   2903: invokeinterface 222 1 0
    //   2908: goto -827 -> 2081
    //   2911: astore_1
    //   2912: aload_2
    //   2913: ifnull +9 -> 2922
    //   2916: aload_2
    //   2917: invokeinterface 222 1 0
    //   2922: aload_1
    //   2923: athrow
    //   2924: aload 5
    //   2926: invokevirtual 241	android/content/ContentValues:clear	()V
    //   2929: aload 5
    //   2931: ldc -81
    //   2933: lload 13
    //   2935: invokestatic 247	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2938: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2941: aload 5
    //   2943: ldc -77
    //   2945: ldc_w 282
    //   2948: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2951: aload 5
    //   2953: ldc -75
    //   2955: aload 6
    //   2957: getfield 280	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   2960: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2963: aload 5
    //   2965: ldc -43
    //   2967: iconst_2
    //   2968: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2971: invokevirtual 274	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2974: aload_0
    //   2975: invokevirtual 153	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2978: getstatic 159	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2981: aload 5
    //   2983: invokevirtual 232	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2986: pop
    //   2987: goto -629 -> 2358
    //   2990: astore_3
    //   2991: aload_2
    //   2992: ifnull -624 -> 2368
    //   2995: aload_2
    //   2996: invokeinterface 222 1 0
    //   3001: goto -633 -> 2368
    //   3004: astore_1
    //   3005: aload_2
    //   3006: ifnull +9 -> 3015
    //   3009: aload_2
    //   3010: invokeinterface 222 1 0
    //   3015: aload_1
    //   3016: athrow
    //   3017: aload 5
    //   3019: invokevirtual 241	android/content/ContentValues:clear	()V
    //   3022: aload 5
    //   3024: ldc -81
    //   3026: lload 13
    //   3028: invokestatic 247	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3031: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3034: aload 5
    //   3036: ldc -77
    //   3038: ldc_w 284
    //   3041: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3044: aload 5
    //   3046: ldc -75
    //   3048: aload_1
    //   3049: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3052: aload 5
    //   3054: ldc -43
    //   3056: iconst_2
    //   3057: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3060: invokevirtual 274	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3063: aload_0
    //   3064: invokevirtual 153	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   3067: getstatic 159	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   3070: aload 5
    //   3072: invokevirtual 232	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   3075: pop
    //   3076: goto -443 -> 2633
    //   3079: astore_1
    //   3080: aload_2
    //   3081: ifnull -438 -> 2643
    //   3084: aload_2
    //   3085: invokeinterface 222 1 0
    //   3090: goto -447 -> 2643
    //   3093: astore_1
    //   3094: aload_2
    //   3095: ifnull +9 -> 3104
    //   3098: aload_2
    //   3099: invokeinterface 222 1 0
    //   3104: aload_1
    //   3105: athrow
    //   3106: iconst_m1
    //   3107: ireturn
    //   3108: astore_1
    //   3109: goto -15 -> 3094
    //   3112: astore_1
    //   3113: aconst_null
    //   3114: astore_2
    //   3115: goto -35 -> 3080
    //   3118: astore_1
    //   3119: goto -114 -> 3005
    //   3122: astore_2
    //   3123: aconst_null
    //   3124: astore_2
    //   3125: goto -134 -> 2991
    //   3128: astore_1
    //   3129: goto -217 -> 2912
    //   3132: astore_2
    //   3133: aconst_null
    //   3134: astore_2
    //   3135: goto -237 -> 2898
    //   3138: astore_1
    //   3139: goto -319 -> 2820
    //   3142: astore_2
    //   3143: aconst_null
    //   3144: astore_2
    //   3145: goto -339 -> 2806
    //   3148: astore_1
    //   3149: goto -422 -> 2727
    //   3152: astore_2
    //   3153: aconst_null
    //   3154: astore_2
    //   3155: goto -442 -> 2713
    //   3158: astore_1
    //   3159: goto -2083 -> 1076
    //   3162: astore_2
    //   3163: aconst_null
    //   3164: astore_2
    //   3165: iconst_0
    //   3166: istore 10
    //   3168: lconst_0
    //   3169: lstore 13
    //   3171: goto -2166 -> 1005
    //   3174: astore_3
    //   3175: lload 15
    //   3177: lstore 13
    //   3179: goto -2174 -> 1005
    //   3182: astore_3
    //   3183: lload 15
    //   3185: lstore 13
    //   3187: iconst_1
    //   3188: istore 10
    //   3190: goto -2185 -> 1005
    //   3193: astore 7
    //   3195: aload_3
    //   3196: astore 5
    //   3198: aload 7
    //   3200: astore_3
    //   3201: goto -2170 -> 1031
    //   3204: astore 7
    //   3206: aload_3
    //   3207: astore 5
    //   3209: iconst_1
    //   3210: istore 9
    //   3212: aload 7
    //   3214: astore_3
    //   3215: goto -2184 -> 1031
    //   3218: astore 5
    //   3220: goto -2248 -> 972
    //   3223: astore 5
    //   3225: goto -2253 -> 972
    //   3228: lload 15
    //   3230: lstore 13
    //   3232: iload 12
    //   3234: istore 10
    //   3236: iload 11
    //   3238: istore 9
    //   3240: goto -2809 -> 431
    //   3243: iconst_1
    //   3244: istore 9
    //   3246: iconst_1
    //   3247: istore 10
    //   3249: goto -2840 -> 409
    //   3252: lload 15
    //   3254: lstore 13
    //   3256: goto -2847 -> 409
    //   3259: aconst_null
    //   3260: astore 4
    //   3262: goto -3188 -> 74
    //   3265: aconst_null
    //   3266: astore 6
    //   3268: goto -3225 -> 43
    //   3271: iload 10
    //   3273: istore 9
    //   3275: iconst_1
    //   3276: istore 10
    //   3278: lload 13
    //   3280: lstore 15
    //   3282: goto -3114 -> 168
    //   3285: astore_3
    //   3286: aconst_null
    //   3287: astore_3
    //   3288: goto -2316 -> 972
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3291	0	this	ProfileCardMoreActivity
    //   0	3291	1	paramString	String
    //   26	3089	2	localObject1	Object
    //   3122	1	2	localException1	Exception
    //   3124	1	2	localObject2	Object
    //   3132	1	2	localException2	Exception
    //   3134	1	2	localObject3	Object
    //   3142	1	2	localException3	Exception
    //   3144	1	2	localObject4	Object
    //   3152	1	2	localException4	Exception
    //   3154	1	2	localObject5	Object
    //   3162	1	2	localException5	Exception
    //   3164	1	2	localObject6	Object
    //   81	904	3	localObject7	Object
    //   997	1	3	localException6	Exception
    //   1030	22	3	localObject8	Object
    //   1053	22	3	localException7	Exception
    //   1259	1234	3	localObject9	Object
    //   2712	1	3	localException8	Exception
    //   2805	1	3	localException9	Exception
    //   2897	1	3	localException10	Exception
    //   2990	1	3	localException11	Exception
    //   3174	1	3	localException12	Exception
    //   3182	14	3	localException13	Exception
    //   3200	15	3	localObject10	Object
    //   3285	1	3	localException14	Exception
    //   3287	1	3	localObject11	Object
    //   72	3189	4	localObject12	Object
    //   90	3118	5	localObject13	Object
    //   3218	1	5	localException15	Exception
    //   3223	1	5	localException16	Exception
    //   41	3226	6	localObject14	Object
    //   117	2089	7	localObject15	Object
    //   3193	6	7	localObject16	Object
    //   3204	9	7	localObject17	Object
    //   314	35	8	str	String
    //   75	3199	9	i1	int
    //   78	3199	10	i2	int
    //   155	3082	11	i3	int
    //   411	2822	12	i4	int
    //   188	3091	13	l1	long
    //   158	3123	15	l2	long
    //   174	191	17	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   396	403	997	java/lang/Exception
    //   959	965	997	java/lang/Exception
    //   984	990	997	java/lang/Exception
    //   207	356	1030	finally
    //   194	200	1053	java/lang/Exception
    //   1040	1047	1053	java/lang/Exception
    //   1051	1053	1053	java/lang/Exception
    //   82	154	1073	finally
    //   1380	1512	2712	java/lang/Exception
    //   2645	2709	2712	java/lang/Exception
    //   1255	1378	2726	finally
    //   1656	1787	2805	java/lang/Exception
    //   2739	2802	2805	java/lang/Exception
    //   1532	1654	2819	finally
    //   1930	2071	2897	java/lang/Exception
    //   2832	2894	2897	java/lang/Exception
    //   1807	1928	2911	finally
    //   2215	2358	2990	java/lang/Exception
    //   2924	2987	2990	java/lang/Exception
    //   2091	2213	3004	finally
    //   2494	2633	3079	java/lang/Exception
    //   3017	3076	3079	java/lang/Exception
    //   2370	2492	3093	finally
    //   2494	2633	3108	finally
    //   3017	3076	3108	finally
    //   2370	2492	3112	java/lang/Exception
    //   2215	2358	3118	finally
    //   2924	2987	3118	finally
    //   2091	2213	3122	java/lang/Exception
    //   1930	2071	3128	finally
    //   2832	2894	3128	finally
    //   1807	1928	3132	java/lang/Exception
    //   1656	1787	3138	finally
    //   2739	2802	3138	finally
    //   1532	1654	3142	java/lang/Exception
    //   1380	1512	3148	finally
    //   2645	2709	3148	finally
    //   1255	1378	3152	java/lang/Exception
    //   168	176	3158	finally
    //   181	190	3158	finally
    //   194	200	3158	finally
    //   396	403	3158	finally
    //   959	965	3158	finally
    //   984	990	3158	finally
    //   1040	1047	3158	finally
    //   1051	1053	3158	finally
    //   82	154	3162	java/lang/Exception
    //   168	176	3174	java/lang/Exception
    //   181	190	3182	java/lang/Exception
    //   356	364	3193	finally
    //   382	388	3204	finally
    //   356	364	3218	java/lang/Exception
    //   382	388	3223	java/lang/Exception
    //   207	356	3285	java/lang/Exception
  }
  
  private String a()
  {
    Object localObject = null;
    try
    {
      String str = ContactUtils.f(this.app, this.jdField_d_of_type_JavaLangString);
      localObject = str;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.profilecard.FrdProfileCard", 2, localException.toString());
    }
    return (String)localObject;
    return null;
  }
  
  private void a(int paramInt1, FormSimpleItem paramFormSimpleItem, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= this.jdField_a_of_type_ArrayOfInt.length) || (paramFormSimpleItem == null)) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfInt[paramInt1] == 1)
    {
      paramFormSimpleItem.setVisibility(0);
      paramFormSimpleItem.setOnClickListener(this);
      if ((paramInt1 == paramInt2) && (paramInt1 == paramInt3))
      {
        paramFormSimpleItem.setBgType(0);
        return;
      }
      if (paramInt1 == paramInt2)
      {
        paramFormSimpleItem.setBgType(1);
        return;
      }
      if (paramInt1 == paramInt3)
      {
        paramFormSimpleItem.setBgType(3);
        return;
      }
      paramFormSimpleItem.setBgType(2);
      return;
    }
    paramFormSimpleItem.setVisibility(8);
  }
  
  private boolean a()
  {
    ShieldMsgManger localShieldMsgManger = null;
    Object localObject = null;
    switch (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    default: 
      localShieldMsgManger = (ShieldMsgManger)this.app.getManager(15);
      if (localShieldMsgManger == null) {
        break label150;
      }
      if (ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      break;
    }
    while (!TextUtils.isEmpty((CharSequence)localObject))
    {
      return localShieldMsgManger.a((String)localObject);
      localObject = (FriendsManager)this.app.getManager(50);
      if (localObject == null) {}
      for (localObject = localShieldMsgManger; (localObject != null) && (((Friends)localObject).groupid == 64534); localObject = ((FriendsManager)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        return true;
      }
      return false;
      if (ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        localObject = a();
      }
    }
    label150:
    return false;
  }
  
  protected ProfileActivity.CardContactInfo a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          localObject1 = (ProfileActivity.CardContactInfo)this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.get(0);
        }
      }
    }
    return (ProfileActivity.CardContactInfo)localObject1;
  }
  
  void a()
  {
    setContentViewB(2130904294);
    setTitle(2131371308);
    this.leftView.setText(2131367975);
    this.rightViewText.setVisibility(8);
    Object localObject1 = findViewById(2131297603);
    label92:
    int i3;
    int i5;
    int i2;
    if (this.jdField_a_of_type_ArrayOfInt[12] == 1)
    {
      ((View)localObject1).setVisibility(0);
      ((View)localObject1).setOnClickListener(this);
      localObject1 = findViewById(2131297614);
      if (this.jdField_a_of_type_ArrayOfInt[13] != 1) {
        break label210;
      }
      ((View)localObject1).setVisibility(0);
      ((View)localObject1).setOnClickListener(this);
      i3 = -1;
      i5 = -1;
      i2 = 3;
      localObject1 = getIntent().getStringExtra("cur_add_source");
      if (!BmqqSegmentUtil.c(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        break label219;
      }
      i2 = 5;
    }
    int i1;
    for (;;)
    {
      i1 = 0;
      while (i1 <= i2)
      {
        int i7 = i5;
        int i6 = i3;
        if (this.jdField_a_of_type_ArrayOfInt[i1] == 1)
        {
          int i4 = i3;
          if (i3 < 0) {
            i4 = i1;
          }
          i7 = i5;
          i6 = i4;
          if (i5 < i1)
          {
            i7 = i1;
            i6 = i4;
          }
        }
        i1 += 1;
        i5 = i7;
        i3 = i6;
      }
      ((View)localObject1).setVisibility(8);
      break;
      label210:
      ((View)localObject1).setVisibility(8);
      break label92;
      label219:
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        i2 = 4;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131302218));
    a(0, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, i3, i5);
    Object localObject2 = getIntent().getStringExtra("key_nick_name");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject2);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131302219));
    a(1, this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem, i3, i5);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131302220));
    a(2, this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, i3, i5);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131302221));
    a(3, this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem, i3, i5);
    if (((QidianManager)this.app.getManager(164)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
    }
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131302222));
    boolean bool;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      a(4, this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem, i3, i5);
      if (this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0) {
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject1);
      }
      this.g = ((FormSimpleItem)findViewById(2131302223));
      bool = BmqqSegmentUtil.c(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if (!bool) {
        break label597;
      }
      a(5, this.g, i3, i5);
      label498:
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131302224));
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("推荐该联系人");
      a(6, this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem, 6, 6);
      i3 = -1;
      i2 = -1;
      i1 = 7;
      label545:
      if (i1 > 11) {
        break label609;
      }
      if (this.jdField_a_of_type_ArrayOfInt[i1] != 1) {
        break label1328;
      }
      if (i3 >= 0) {
        break label1325;
      }
      i3 = i1;
      label569:
      if (i2 >= i1) {
        break label1322;
      }
      i2 = i1;
    }
    label597:
    label609:
    label811:
    label858:
    label884:
    label913:
    label1032:
    label1232:
    label1279:
    label1291:
    label1306:
    label1314:
    label1322:
    label1325:
    label1328:
    for (;;)
    {
      i1 += 1;
      break label545;
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      break;
      this.g.setVisibility(8);
      break label498;
      this.h = ((FormSimpleItem)findViewById(2131302225));
      a(7, this.h, i3, i2);
      if (bool) {
        this.h.setVisibility(8);
      }
      this.i = ((FormSimpleItem)findViewById(2131302226));
      a(8, this.i, i3, i2);
      if (bool) {
        this.i.setVisibility(8);
      }
      this.j = ((FormSimpleItem)findViewById(2131297600));
      a(9, this.j, i3, i2);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302228));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131302227));
      if ((!bool) && (this.jdField_a_of_type_ArrayOfInt[11] == 1)) {
        if ((11 == i3) && (11 == i2))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(0);
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131297601));
          if (this.jdField_a_of_type_ArrayOfInt[10] != 1) {
            break label1279;
          }
          if ((10 != i3) || (10 != i2)) {
            break label1232;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(0);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("屏蔽此人");
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
          if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
          {
            localObject2 = (FriendsManager)this.app.getManager(50);
            if (localObject2 != null) {
              break label1291;
            }
            localObject1 = null;
            if (localObject1 != null)
            {
              this.jdField_e_of_type_JavaLangString = ((Friends)localObject1).remark;
              this.jdField_c_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
              localObject2 = ((FriendsManager)localObject2).a(String.valueOf(((Friends)localObject1).groupid));
              if ((localObject2 != null) && (!Utils.a(this.jdField_f_of_type_JavaLangString, ((Groups)localObject2).group_name))) {
                this.jdField_f_of_type_JavaLangString = ((Groups)localObject2).group_name;
              }
              if (((Friends)localObject1).gathtertype == 1)
              {
                this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
                this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
                this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
              }
            }
            if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0)
            {
              localObject2 = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
              if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
                break label1306;
              }
              localObject1 = "";
              ((FormSimpleItem)localObject2).setRightText((CharSequence)localObject1);
            }
            if (this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0)
            {
              localObject2 = this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
              if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
                break label1314;
              }
            }
          }
        }
      }
      for (localObject1 = "";; localObject1 = this.jdField_f_of_type_JavaLangString)
      {
        ((FormSimpleItem)localObject2).setRightText((CharSequence)localObject1);
        if (this.jdField_a_of_type_ArrayOfInt[10] == 1)
        {
          this.jdField_a_of_type_Boolean = a();
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
        }
        if (AppSetting.j)
        {
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("收起到不常联系好友 ");
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
          if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) {
            ((TextView)findViewById(2131302228)).setFocusable(true);
          }
          this.j.setContentDescription(getString(2131371016));
        }
        return;
        if (11 == i3)
        {
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(1);
          break;
        }
        if (11 == i2)
        {
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(3);
          break;
        }
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(2);
        break;
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        break label811;
        if (10 == i3)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(1);
          break label858;
        }
        if (10 == i2)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(3);
          break label858;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(2);
        break label858;
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        break label884;
        localObject1 = ((FriendsManager)localObject2).c(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        break label913;
        localObject1 = this.jdField_e_of_type_JavaLangString;
        break label1032;
      }
      continue;
      break label569;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  void a(String paramString)
  {
    DialogUtil.a(this, 230).setTitle(getString(2131368711)).setMessage(getString(2131368722)).setPositiveButton(2131367499, new mao(this, paramString)).setNegativeButton(2131367976, new man(this)).show();
  }
  
  void a(boolean paramBoolean)
  {
    boolean bool = true;
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      ShieldMsgManger localShieldMsgManger = (ShieldMsgManger)this.app.getManager(15);
      if (localShieldMsgManger != null) {}
      for (;;)
      {
        int i1;
        try
        {
          Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
          if (ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
            localObject = a();
          }
          long l1 = Long.parseLong((String)localObject);
          localObject = new ArrayList();
          ((List)localObject).add(Long.valueOf(l1));
          i1 = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          if (paramBoolean)
          {
            localShieldMsgManger.b(i1, (List)localObject);
            i1 = 1;
          }
          switch (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
          {
          default: 
            i2 = i1;
            if (i2 == 0) {
              break label304;
            }
            if (paramBoolean) {
              break label299;
            }
            paramBoolean = bool;
            this.jdField_a_of_type_Boolean = paramBoolean;
            this.r |= 0x2;
            e();
            return;
            localShieldMsgManger.a(i1, (List)localObject);
            continue;
            i1 = 0;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.profilecard.FrdProfileCard", 2, "shieldMsg() " + localNumberFormatException.toString());
          }
        }
        continue;
        int i2 = i1;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString != null)
        {
          i2 = i1;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.length() > 0)
          {
            if (paramBoolean) {
              this.app.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            }
            for (;;)
            {
              i2 = 1;
              break;
              this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            }
            label299:
            paramBoolean = false;
          }
        }
      }
      label304:
      if (paramBoolean) {
        a(2131368704, 1);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
        return;
        a(2131368703, 1);
      }
    }
    a(2131367256, 1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    f();
    if ((this.r & 0x2) == 2)
    {
      if (!paramBoolean1) {
        break label72;
      }
      if (!paramBoolean2) {
        break label61;
      }
      a(2131368705, 2);
    }
    for (;;)
    {
      this.r &= 0xFFFFFFFD;
      this.jdField_a_of_type_Boolean = a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
      return;
      label61:
      a(2131368701, 2);
      continue;
      label72:
      if (paramBoolean2) {
        a(2131368704, 1);
      } else {
        a(2131368703, 1);
      }
    }
  }
  
  void b()
  {
    this.jdField_a_of_type_ArrayOfInt = new int[14];
    int i1 = 0;
    while (i1 < 14)
    {
      this.jdField_a_of_type_ArrayOfInt[i1] = 0;
      i1 += 1;
    }
    if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      this.jdField_a_of_type_ArrayOfInt[1] = 1;
      this.jdField_a_of_type_ArrayOfInt[2] = 1;
      this.jdField_a_of_type_ArrayOfInt[3] = 1;
      this.jdField_a_of_type_ArrayOfInt[0] = 1;
      this.jdField_a_of_type_ArrayOfInt[4] = 1;
      if (BmqqSegmentUtil.c(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ArrayOfInt[5] = 1;
      }
      this.jdField_a_of_type_ArrayOfInt[6] = 1;
      this.jdField_a_of_type_ArrayOfInt[7] = 1;
      this.jdField_a_of_type_ArrayOfInt[8] = 1;
      this.jdField_a_of_type_ArrayOfInt[9] = 1;
      this.jdField_a_of_type_ArrayOfInt[11] = 1;
      this.jdField_a_of_type_ArrayOfInt[12] = 1;
      this.jdField_a_of_type_ArrayOfInt[13] = 1;
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 22) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 47) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 74))
      {
        this.jdField_a_of_type_ArrayOfInt[1] = 1;
        this.jdField_a_of_type_ArrayOfInt[6] = 1;
        this.jdField_a_of_type_ArrayOfInt[10] = 1;
        this.jdField_a_of_type_ArrayOfInt[13] = 1;
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 42) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 57) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 58))
      {
        this.jdField_a_of_type_ArrayOfInt[6] = 1;
        this.jdField_a_of_type_ArrayOfInt[10] = 1;
        this.jdField_a_of_type_ArrayOfInt[13] = 1;
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34))
      {
        this.jdField_a_of_type_ArrayOfInt[10] = 1;
        this.jdField_a_of_type_ArrayOfInt[13] = 1;
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 71) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 72) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 27))
      {
        this.jdField_a_of_type_ArrayOfInt[1] = 1;
        this.jdField_a_of_type_ArrayOfInt[10] = 1;
        this.jdField_a_of_type_ArrayOfInt[13] = 1;
        return;
      }
    } while (!ProfileActivity.AllInOne.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
    this.jdField_a_of_type_ArrayOfInt[1] = 1;
    this.jdField_a_of_type_ArrayOfInt[6] = 1;
    this.jdField_a_of_type_ArrayOfInt[13] = 1;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight() - (int)(localDisplayMetrics.density * 10.0F), 0, paramInt2);
  }
  
  public void b(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
    FormSimpleItem localFormSimpleItem = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {}
    for (paramString = "";; paramString = this.jdField_e_of_type_JavaLangString)
    {
      localFormSimpleItem.setRightText(paramString);
      if (this.jdField_a_of_type_AndroidContentIntent == null) {
        this.jdField_a_of_type_AndroidContentIntent = new Intent();
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("remark", this.jdField_e_of_type_JavaLangString);
      setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
      return;
    }
  }
  
  void c()
  {
    Intent localIntent = new Intent(this, EditActivity.class);
    boolean bool = true;
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      bool = false;
    }
    localIntent.putExtra("title", 2131367739).putExtra("limit", 96).putExtra("current", this.jdField_c_of_type_JavaLangString).putExtra("canPostNull", bool).putExtra("multiLine", false);
    startActivityForResult(localIntent, 1003);
  }
  
  void d()
  {
    Object localObject = (FriendsManager)this.app.getManager(50);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((FriendsManager)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      if (localObject != null) {
        startActivityForResult(new Intent(getActivity(), MoveToGroupActivity.class).putExtra("friendUin", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).putExtra("mgid", (byte)((Friends)localObject).groupid), 0);
      }
      return;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = null;
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "onActivityResult, resultCode : " + paramInt1 + ", resultCode : " + paramInt2 + ", data : " + paramIntent);
    }
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      return;
    case 1003: 
      if (paramIntent != null) {
        localObject = paramIntent.getStringExtra("result");
      }
      if (localObject != null) {
        break;
      }
    }
    for (paramIntent = "";; paramIntent = (Intent)localObject)
    {
      if (NetworkUtil.e(BaseApplication.getContext()))
      {
        if (!paramIntent.equals(this.jdField_e_of_type_JavaLangString))
        {
          localObject = (FriendListHandler)this.app.a(1);
          if (localObject != null)
          {
            ((FriendListHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramIntent, false);
            this.r |= 0x1;
            b(paramIntent);
            paramIntent = new QZoneDistributedAppCtrl.Control();
            paramIntent.jdField_a_of_type_Int = 5;
            QZoneDistributedAppCtrl.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).a(paramIntent);
            return;
          }
          a(2131370010, 1);
          return;
        }
        a(2131370009, 0);
        return;
      }
      a(2131368804, 1);
      return;
      paramIntent.putExtra("selfSet_leftViewText", getString(2131367566));
      localObject = AIOUtils.a(new Intent(this, SplashActivity.class), null);
      ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
      paramIntent = ForwardUtils.a((Intent)localObject);
      ForwardUtils.a(this.app, this, paramIntent, (Intent)localObject);
      return;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)getIntent().getParcelableExtra("AllInOne"));
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      super.finish();
    }
    for (;;)
    {
      return true;
      try
      {
        b();
        a();
        addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
        addObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
        addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
        addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
        if (this.jdField_c_of_type_JavaLangString != null) {
          continue;
        }
        ThreadManager.a(new mam(this), 5, null, true);
        return true;
      }
      catch (NoSuchFieldError paramBundle)
      {
        for (;;)
        {
          super.finish();
        }
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    f();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    SpecialCareInfo localSpecialCareInfo = ((FriendsManager)this.app.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    if (this.j.getVisibility() == 0)
    {
      if ((localSpecialCareInfo == null) || (localSpecialCareInfo.globalSwitch == 0)) {
        this.j.setRightText(getString(2131370237));
      }
    }
    else {
      return;
    }
    this.j.setRightText(getString(2131370238));
  }
  
  void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131368647);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void g()
  {
    Object localObject1 = (FriendsManager)this.app.getManager(50);
    if (localObject1 == null)
    {
      localObject1 = null;
      if ((localObject1 == null) || (((Card)localObject1).strReMark == null) || (((Card)localObject1).strReMark.length() <= 0)) {
        break label148;
      }
    }
    label143:
    label148:
    for (localObject1 = ((Card)localObject1).strReMark;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((String)localObject1).length() > 0) {}
      }
      else
      {
        localObject2 = localObject1;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 30)
        {
          localObject1 = a();
          if (localObject1 == null) {
            break label143;
          }
        }
      }
      for (Object localObject2 = ((ProfileActivity.CardContactInfo)localObject1).jdField_a_of_type_JavaLangString;; localObject2 = null)
      {
        this.jdField_c_of_type_JavaLangString = ((String)localObject2);
        if (QLog.isDevelopLevel()) {
          QLog.i("IphoneTitleBarActivity", 4, "initRemark, " + this.jdField_c_of_type_JavaLangString);
        }
        return;
        localObject1 = ((FriendsManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        break;
      }
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if ((paramCompoundButton == this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) || (paramCompoundButton == this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()))
    {
      if (paramCompoundButton != this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break label66;
      }
      if (this.jdField_a_of_type_Boolean != paramBoolean) {
        break label48;
      }
    }
    label48:
    label66:
    while (paramCompoundButton != this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
    {
      return;
      bool1 = bool2;
      if (!paramBoolean) {
        bool1 = true;
      }
      a(bool1);
      return;
    }
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      paramCompoundButton = (FriendListHandler)this.app.a(1);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      paramCompoundButton.a((short)1, localArrayList, paramBoolean);
      if (paramBoolean)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8004C5A", "0X8004C5A", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8004C5B", "0X8004C5B", 0, 0, "", "", "", "");
      return;
    }
    a(2131367256, 1);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
    paramCompoundButton = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (!paramBoolean) {}
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      paramCompoundButton.setChecked(paramBoolean);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = null;
    int i1;
    if (paramView == null) {
      i1 = 0;
    }
    switch (i1)
    {
    default: 
    case 2131302219: 
    case 2131302220: 
    case 2131302221: 
    case 2131302223: 
    case 2131302224: 
    case 2131297603: 
    case 2131297614: 
    case 2131302225: 
      do
      {
        do
        {
          do
          {
            long l1;
            do
            {
              return;
              i1 = paramView.getId();
              break;
              l1 = System.currentTimeMillis();
            } while (!ProfileActivity.a(this.jdField_a_of_type_Long, l1));
            this.jdField_a_of_type_Long = l1;
            ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app, this);
            ReportController.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_more", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
            return;
            c();
            ReportController.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_edit_name", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
            return;
            d();
            ReportController.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_move", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
            return;
          } while (this.jdField_b_of_type_Boolean);
          this.jdField_b_of_type_Boolean = true;
          ThreadManager.a().post(new mau(this));
          return;
          Object localObject2 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class);
          localObject1 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
          Object localObject3 = "AppCmd://OpenContactInfo/?uin=" + this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h = ContactUtils.i(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          }
          paramView = getIntent().getStringExtra("SHARE_NICK_NAME");
          if (paramView == null)
          {
            paramView = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h;
            localObject2 = ((AbsShareMsg.Builder)localObject2).c(14).a("推荐了" + paramView).a(2).a("plugin", "", (String)localObject3, (String)localObject1, (String)localObject1).d(getResources().getString(2131368043)).a();
            localObject3 = new StructMsgItemLayoutDefault();
            ((AbsStructMsgItem)localObject3).d(1);
            ((AbsStructMsgItem)localObject3).b("推荐联系人");
            StructMsgItemLayout2 localStructMsgItemLayout2 = new StructMsgItemLayout2();
            localStructMsgItemLayout2.d(1);
            localStructMsgItemLayout2.a(new StructMsgItemCover((String)localObject1));
            localStructMsgItemLayout2.a(new StructMsgItemTitle(paramView));
            localStructMsgItemLayout2.a(new StructMsgItemSummary("帐号: " + this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
            ((AbsShareMsg)localObject2).addItem((AbsStructMsgElement)localObject3);
            ((AbsShareMsg)localObject2).addItem(localStructMsgItemLayout2);
            paramView = new Bundle();
            paramView.putInt("forward_type", 20);
            paramView.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
            paramView.putBoolean("k_dataline", false);
            localObject1 = new Intent();
            ((Intent)localObject1).putExtras(paramView);
            ForwardBaseOption.a(this, (Intent)localObject1, 21);
            if (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
              break label754;
            }
          }
          for (i1 = 1;; i1 = 2)
          {
            ReportController.b(this.app, "CliOper", "", "", "0X80050E7", "0X80050E7", i1, 0, "", "", "", "");
            return;
            break;
          }
          paramView = (View)localObject1;
          try
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {
              paramView = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
            }
            a(paramView);
            return;
          }
          catch (Exception paramView) {}
        } while (!QLog.isColorLevel());
        QLog.d("IphoneTitleBarActivity", 2, paramView, new Object[0]);
        return;
        if (((HotChatManager)this.app.getManager(59)).b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString)) {
          ReportPlugin.a(this, 202, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app.getAccount());
        }
        for (;;)
        {
          ReportController.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_report", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString;
          paramView = (View)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            paramView = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString;
          }
          ProfileCardUtil.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramView, this.app.getAccount(), 1101);
        }
        try
        {
          paramView = QZoneHelper.UserInfo.a();
          paramView.jdField_a_of_type_JavaLangString = this.app.a();
          paramView.b = this.app.b();
          QZoneHelper.a(this, paramView, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).longValue(), -1);
          ReportController.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_qzone", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
        }
        catch (Exception paramView) {}
      } while (!QLog.isColorLevel());
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramView.toString());
      return;
    case 2131297600: 
      label754:
      paramView = new Intent(this, QQSpecialCareSettingActivity.class);
      paramView.putExtra("key_friend_uin", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      startActivity(paramView);
      ReportController.b(null, "CliOper", "", "", "0X80050E4", "0X80050E4", 0, 0, "1", "", "", "");
      return;
    }
    paramView = new Intent(this, QQStoryShieldActivity.class);
    paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    paramView.putExtra("from", 1);
    startActivity(paramView);
    ReportController.b(null, "dc00899", "grp_story", "", "person_data_set", "clk_set", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\ProfileCardMoreActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */