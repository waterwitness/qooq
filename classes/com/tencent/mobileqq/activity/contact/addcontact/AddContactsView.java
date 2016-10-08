package com.tencent.mobileqq.activity.contact.addcontact;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RecommendFriendActivity;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.adapter.MayKnowAdapter;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.ConditionSearchManager.IFirstLocationReqCancelListener;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.FormMutiItem;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ogt;
import ogu;
import ogv;
import ogw;

public class AddContactsView
  extends ContactBaseView
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = 3;
  private static final String jdField_a_of_type_JavaLangString = AddContactsView.class.getSimpleName();
  private static final String jdField_c_of_type_JavaLangString = "、";
  private static final String jdField_d_of_type_JavaLangString = "条件：";
  private MayKnowAdapter jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter;
  ConditionSearchManager.IConfigListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener = new ogt(this);
  ConditionSearchManager.IFirstLocationReqCancelListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IFirstLocationReqCancelListener = new ogu(this);
  public ConditionSearchManager a;
  LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new ogv(this);
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  FormMutiItem jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private List jdField_a_of_type_JavaUtilList = new ArrayList(3);
  public boolean a;
  public String[] a;
  public FormMutiItem b;
  private String b;
  public boolean b;
  FormMutiItem jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem;
  private boolean jdField_c_of_type_Boolean = true;
  FormMutiItem jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem;
  FormMutiItem e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public AddContactsView(ContactBaseView.IAddContactContext paramIAddContactContext)
  {
    super(paramIAddContactContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "PhoneContactRecommendNames";
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfJavaLangString = null;
  }
  
  private String a(List paramList)
  {
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    StringBuffer localStringBuffer = new StringBuffer(100);
    int i = 0;
    while (i < paramList.size())
    {
      PhoneContact localPhoneContact = localPhoneContactManager.b((String)paramList.get(i));
      if (localPhoneContact != null)
      {
        localStringBuffer.append(localPhoneContact.name);
        localStringBuffer.append("、");
      }
      i += 1;
    }
    if (localStringBuffer.length() > 1) {
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    }
    return localStringBuffer.toString();
  }
  
  private List a()
  {
    Object localObject = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    List localList = b();
    if (localList.size() < 3)
    {
      localObject = ((PhoneContactManager)localObject).d();
      if ((localObject != null) && (((List)localObject).size() > 1))
      {
        localObject = (List)((List)localObject).get(0);
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          int i = 0;
          while ((i < ((List)localObject).size()) && (localList.size() < 3))
          {
            PhoneContact localPhoneContact = (PhoneContact)((List)localObject).get(i);
            if ((localPhoneContact != null) && (localPhoneContact.uin != null) && (localPhoneContact.uin.equals("0")) && (!localFriendsManager.d(localPhoneContact.nationCode + localPhoneContact.mobileCode)) && (!localList.contains(localPhoneContact.mobileNo))) {
              localList.add(localPhoneContact.mobileNo);
            }
            i += 1;
          }
        }
      }
    }
    return localList;
  }
  
  /* Error */
  private List b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 94	com/tencent/mobileqq/activity/contact/addcontact/AddContactsView:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: bipush 10
    //   6: invokevirtual 100	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9: checkcast 102	com/tencent/mobileqq/model/PhoneContactManager
    //   12: astore 6
    //   14: aload_0
    //   15: getfield 94	com/tencent/mobileqq/activity/contact/addcontact/AddContactsView:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   18: bipush 50
    //   20: invokevirtual 100	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   23: checkcast 142	com/tencent/mobileqq/app/FriendsManager
    //   26: astore 7
    //   28: new 81	java/util/ArrayList
    //   31: dup
    //   32: iconst_3
    //   33: invokespecial 84	java/util/ArrayList:<init>	(I)V
    //   36: astore 5
    //   38: aload_0
    //   39: getfield 94	com/tencent/mobileqq/activity/contact/addcontact/AddContactsView:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   42: invokevirtual 193	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   45: invokevirtual 199	mqq/app/MobileQQ:getContentResolver	()Landroid/content/ContentResolver;
    //   48: getstatic 205	android/provider/CallLog$Calls:CONTENT_URI	Landroid/net/Uri;
    //   51: iconst_2
    //   52: anewarray 117	java/lang/String
    //   55: dup
    //   56: iconst_0
    //   57: ldc -49
    //   59: aastore
    //   60: dup
    //   61: iconst_1
    //   62: ldc -47
    //   64: aastore
    //   65: aconst_null
    //   66: aconst_null
    //   67: ldc -45
    //   69: invokevirtual 217	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   72: astore_1
    //   73: aload_1
    //   74: invokeinterface 222 1 0
    //   79: istore 14
    //   81: new 224	java/util/HashSet
    //   84: dup
    //   85: iconst_4
    //   86: invokespecial 225	java/util/HashSet:<init>	(I)V
    //   89: astore 8
    //   91: iconst_0
    //   92: istore 12
    //   94: iconst_0
    //   95: istore 11
    //   97: iconst_0
    //   98: istore 10
    //   100: iconst_0
    //   101: istore 9
    //   103: aload_1
    //   104: invokeinterface 229 1 0
    //   109: ifeq +220 -> 329
    //   112: aload_1
    //   113: aload_1
    //   114: ldc -49
    //   116: invokeinterface 233 2 0
    //   121: invokeinterface 237 2 0
    //   126: invokestatic 242	com/tencent/mobileqq/app/PhoneContactHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   129: astore_3
    //   130: aload_3
    //   131: ldc -12
    //   133: invokevirtual 247	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   136: ifeq +151 -> 287
    //   139: aload_3
    //   140: iconst_3
    //   141: invokevirtual 250	java/lang/String:substring	(I)Ljava/lang/String;
    //   144: astore_2
    //   145: aload 8
    //   147: aload_3
    //   148: invokevirtual 251	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   151: ifne -48 -> 103
    //   154: aload 8
    //   156: aload_2
    //   157: invokevirtual 251	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   160: ifne -57 -> 103
    //   163: aload 8
    //   165: aload_3
    //   166: invokevirtual 252	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   169: pop
    //   170: aload 8
    //   172: aload_2
    //   173: invokevirtual 252	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   176: pop
    //   177: aload 6
    //   179: aload_3
    //   180: invokeinterface 120 2 0
    //   185: astore 4
    //   187: aload 4
    //   189: astore_3
    //   190: aload 4
    //   192: ifnonnull +12 -> 204
    //   195: aload 6
    //   197: aload_2
    //   198: invokeinterface 120 2 0
    //   203: astore_3
    //   204: aload_3
    //   205: ifnull +562 -> 767
    //   208: ldc -105
    //   210: aload_3
    //   211: getfield 149	com/tencent/mobileqq/data/PhoneContact:uin	Ljava/lang/String;
    //   214: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   217: ifeq +93 -> 310
    //   220: iload 9
    //   222: iconst_1
    //   223: iadd
    //   224: istore 9
    //   226: aload 7
    //   228: new 157	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   235: aload_3
    //   236: getfield 162	com/tencent/mobileqq/data/PhoneContact:nationCode	Ljava/lang/String;
    //   239: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload_3
    //   243: getfield 168	com/tencent/mobileqq/data/PhoneContact:mobileCode	Ljava/lang/String;
    //   246: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokevirtual 172	com/tencent/mobileqq/app/FriendsManager:d	(Ljava/lang/String;)Z
    //   255: ifne +500 -> 755
    //   258: aload 5
    //   260: aload_3
    //   261: getfield 175	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   264: invokeinterface 178 2 0
    //   269: ifne +486 -> 755
    //   272: aload 5
    //   274: aload_3
    //   275: getfield 175	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   278: invokeinterface 181 2 0
    //   283: pop
    //   284: goto -181 -> 103
    //   287: new 157	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   294: ldc -12
    //   296: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload_3
    //   300: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: astore_2
    //   307: goto -162 -> 145
    //   310: aload_3
    //   311: getfield 149	com/tencent/mobileqq/data/PhoneContact:uin	Ljava/lang/String;
    //   314: invokestatic 258	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   317: ifne +441 -> 758
    //   320: iload 11
    //   322: iconst_1
    //   323: iadd
    //   324: istore 11
    //   326: goto -223 -> 103
    //   329: new 260	java/util/HashMap
    //   332: dup
    //   333: invokespecial 261	java/util/HashMap:<init>	()V
    //   336: astore_2
    //   337: aload_2
    //   338: ldc_w 263
    //   341: aload 8
    //   343: invokevirtual 264	java/util/HashSet:size	()I
    //   346: invokestatic 267	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   349: invokevirtual 271	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   352: pop
    //   353: aload_2
    //   354: ldc_w 273
    //   357: iload 14
    //   359: invokestatic 267	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   362: invokevirtual 271	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   365: pop
    //   366: aload_2
    //   367: ldc_w 275
    //   370: iload 11
    //   372: invokestatic 267	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   375: invokevirtual 271	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   378: pop
    //   379: aload_2
    //   380: ldc_w 277
    //   383: iload 9
    //   385: invokestatic 267	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   388: invokevirtual 271	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   391: pop
    //   392: aload_2
    //   393: ldc_w 279
    //   396: iload 10
    //   398: invokestatic 267	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   401: invokevirtual 271	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   404: pop
    //   405: aload_2
    //   406: ldc_w 281
    //   409: iload 12
    //   411: invokestatic 267	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   414: invokevirtual 271	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   417: pop
    //   418: aload 6
    //   420: invokeinterface 146 1 0
    //   425: astore_3
    //   426: iconst_0
    //   427: istore 10
    //   429: iconst_0
    //   430: istore 11
    //   432: aload_3
    //   433: iconst_1
    //   434: invokeinterface 115 2 0
    //   439: checkcast 107	java/util/List
    //   442: invokeinterface 111 1 0
    //   447: istore 9
    //   449: aload_3
    //   450: iconst_0
    //   451: invokeinterface 115 2 0
    //   456: checkcast 107	java/util/List
    //   459: astore_3
    //   460: aload_3
    //   461: invokeinterface 111 1 0
    //   466: istore 15
    //   468: iconst_0
    //   469: istore 12
    //   471: iload 12
    //   473: iload 15
    //   475: if_icmpge +83 -> 558
    //   478: aload_3
    //   479: iload 12
    //   481: invokeinterface 115 2 0
    //   486: checkcast 122	com/tencent/mobileqq/data/PhoneContact
    //   489: astore 4
    //   491: aload 4
    //   493: ifnull +247 -> 740
    //   496: ldc -105
    //   498: aload 4
    //   500: getfield 149	com/tencent/mobileqq/data/PhoneContact:uin	Ljava/lang/String;
    //   503: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   506: ifeq +20 -> 526
    //   509: iload 11
    //   511: iconst_1
    //   512: iadd
    //   513: istore 13
    //   515: iload 9
    //   517: istore 11
    //   519: iload 13
    //   521: istore 9
    //   523: goto +253 -> 776
    //   526: aload 4
    //   528: getfield 149	com/tencent/mobileqq/data/PhoneContact:uin	Ljava/lang/String;
    //   531: invokestatic 258	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   534: ifne +267 -> 801
    //   537: iload 9
    //   539: istore 13
    //   541: iload 11
    //   543: istore 9
    //   545: iload 10
    //   547: iconst_1
    //   548: iadd
    //   549: istore 10
    //   551: iload 13
    //   553: istore 11
    //   555: goto +221 -> 776
    //   558: aload_2
    //   559: ldc_w 283
    //   562: iload 15
    //   564: iload 9
    //   566: iadd
    //   567: invokestatic 267	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   570: invokevirtual 271	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   573: pop
    //   574: aload_2
    //   575: ldc_w 285
    //   578: iload 10
    //   580: invokestatic 267	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   583: invokevirtual 271	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   586: pop
    //   587: aload_2
    //   588: ldc_w 287
    //   591: iload 11
    //   593: invokestatic 267	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   596: invokevirtual 271	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   599: pop
    //   600: aload_2
    //   601: ldc_w 289
    //   604: iload 9
    //   606: invokestatic 267	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   609: invokevirtual 271	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   612: pop
    //   613: aload_0
    //   614: invokevirtual 293	com/tencent/mobileqq/activity/contact/addcontact/AddContactsView:getContext	()Landroid/content/Context;
    //   617: invokestatic 298	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   620: aconst_null
    //   621: ldc_w 300
    //   624: iconst_1
    //   625: iload 14
    //   627: i2l
    //   628: lconst_0
    //   629: aload_2
    //   630: aconst_null
    //   631: invokevirtual 303	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   634: aload_1
    //   635: ifnull +9 -> 644
    //   638: aload_1
    //   639: invokeinterface 306 1 0
    //   644: aload 5
    //   646: invokeinterface 111 1 0
    //   651: iconst_3
    //   652: if_icmple +85 -> 737
    //   655: aload 5
    //   657: iconst_0
    //   658: iconst_3
    //   659: invokeinterface 310 3 0
    //   664: areturn
    //   665: astore_2
    //   666: aconst_null
    //   667: astore_1
    //   668: invokestatic 315	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   671: ifeq +14 -> 685
    //   674: ldc_w 317
    //   677: iconst_2
    //   678: ldc_w 319
    //   681: aload_2
    //   682: invokestatic 322	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   685: aload_1
    //   686: ifnull -42 -> 644
    //   689: aload_1
    //   690: invokeinterface 306 1 0
    //   695: goto -51 -> 644
    //   698: astore_1
    //   699: goto -55 -> 644
    //   702: astore_2
    //   703: aconst_null
    //   704: astore_1
    //   705: aload_1
    //   706: ifnull +9 -> 715
    //   709: aload_1
    //   710: invokeinterface 306 1 0
    //   715: aload_2
    //   716: athrow
    //   717: astore_1
    //   718: goto -74 -> 644
    //   721: astore_1
    //   722: goto -7 -> 715
    //   725: astore_2
    //   726: goto -21 -> 705
    //   729: astore_2
    //   730: goto -25 -> 705
    //   733: astore_2
    //   734: goto -66 -> 668
    //   737: aload 5
    //   739: areturn
    //   740: iload 9
    //   742: istore 13
    //   744: iload 11
    //   746: istore 9
    //   748: iload 13
    //   750: istore 11
    //   752: goto +24 -> 776
    //   755: goto -652 -> 103
    //   758: iload 10
    //   760: iconst_1
    //   761: iadd
    //   762: istore 10
    //   764: goto -661 -> 103
    //   767: iload 12
    //   769: iconst_1
    //   770: iadd
    //   771: istore 12
    //   773: goto -670 -> 103
    //   776: iload 12
    //   778: iconst_1
    //   779: iadd
    //   780: istore 13
    //   782: iload 11
    //   784: istore 12
    //   786: iload 9
    //   788: istore 11
    //   790: iload 12
    //   792: istore 9
    //   794: iload 13
    //   796: istore 12
    //   798: goto -327 -> 471
    //   801: iload 9
    //   803: iconst_1
    //   804: iadd
    //   805: istore 13
    //   807: iload 11
    //   809: istore 9
    //   811: iload 13
    //   813: istore 11
    //   815: goto -39 -> 776
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	818	0	this	AddContactsView
    //   72	618	1	localCursor	android.database.Cursor
    //   698	1	1	localException1	Exception
    //   704	6	1	localObject1	Object
    //   717	1	1	localException2	Exception
    //   721	1	1	localException3	Exception
    //   144	486	2	localObject2	Object
    //   665	17	2	localThrowable1	Throwable
    //   702	14	2	localObject3	Object
    //   725	1	2	localObject4	Object
    //   729	1	2	localObject5	Object
    //   733	1	2	localThrowable2	Throwable
    //   129	350	3	localObject6	Object
    //   185	342	4	localPhoneContact	PhoneContact
    //   36	702	5	localArrayList	ArrayList
    //   12	407	6	localPhoneContactManager	PhoneContactManager
    //   26	201	7	localFriendsManager	FriendsManager
    //   89	253	8	localHashSet	java.util.HashSet
    //   101	709	9	i	int
    //   98	665	10	j	int
    //   95	719	11	k	int
    //   92	705	12	m	int
    //   513	299	13	n	int
    //   79	547	14	i1	int
    //   466	101	15	i2	int
    // Exception table:
    //   from	to	target	type
    //   38	73	665	java/lang/Throwable
    //   689	695	698	java/lang/Exception
    //   38	73	702	finally
    //   638	644	717	java/lang/Exception
    //   709	715	721	java/lang/Exception
    //   73	91	725	finally
    //   103	145	725	finally
    //   145	187	725	finally
    //   195	204	725	finally
    //   208	220	725	finally
    //   226	284	725	finally
    //   287	307	725	finally
    //   310	320	725	finally
    //   329	426	725	finally
    //   432	468	725	finally
    //   478	491	725	finally
    //   496	509	725	finally
    //   526	537	725	finally
    //   558	634	725	finally
    //   668	685	729	finally
    //   73	91	733	java/lang/Throwable
    //   103	145	733	java/lang/Throwable
    //   145	187	733	java/lang/Throwable
    //   195	204	733	java/lang/Throwable
    //   208	220	733	java/lang/Throwable
    //   226	284	733	java/lang/Throwable
    //   287	307	733	java/lang/Throwable
    //   310	320	733	java/lang/Throwable
    //   329	426	733	java/lang/Throwable
    //   432	468	733	java/lang/Throwable
    //   478	491	733	java/lang/Throwable
    //   496	509	733	java/lang/Throwable
    //   526	537	733	java/lang/Throwable
    //   558	634	733	java/lang/Throwable
  }
  
  private void h()
  {
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
    String[] arrayOfString = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "initSearchConditions|autoReqLocation = " + this.jdField_a_of_type_Boolean + ", locCode[0] = " + arrayOfString[0]);
    }
    if ((this.jdField_a_of_type_Boolean) || ("0".equals(arrayOfString[0])))
    {
      if ((DatingUtil.a()) || (!NetworkUtil.e(this.jdField_a_of_type_AndroidAppActivity))) {
        break label177;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "initSearchConditions|getUserCurrentLocation execute : yes");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a().a(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
      ((LBSHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(3)).b();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
        this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IFirstLocationReqCancelListener);
      }
      return;
      label177:
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "-1", "-1", "-1", "-1" };
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "initSearchConditions|getUserCurrentLocation execute : no");
      }
    }
  }
  
  private void i()
  {
    super.a(2130903065);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131296899));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setPadding(getResources().getDimensionPixelSize(2131493321), 0, 0, 0);
    Object localObject = getResources().getDrawable(2130843266);
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setCompoundDrawables((Drawable)localObject, null, null, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setCursorVisible(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setOnClickListener(this);
    if (AppSetting.j) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription("搜索栏、QQ号、手机号、邮箱、群、公共号");
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem = ((FormMutiItem)findViewById(2131296901));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130840579));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(this.jdField_a_of_type_AndroidAppActivity.getString(2131369690));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineText("");
    if (((ConditionSearchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58)).b()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setRightIcon(getResources().getDrawable(2130843324));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.a(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem = ((FormMutiItem)findViewById(2131296903));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130840503));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(getResources().getString(2131369708));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineText("");
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.a(true);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
    if (AppSetting.j) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setContentDescription("添加手机联系人");
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem = ((FormMutiItem)findViewById(2131296904));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130840502));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText("查看附近的人");
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.a(true);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
    if (AppSetting.j) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setContentDescription("查看附近的人");
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131296915));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131296916));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter);
    this.e = ((FormMutiItem)findViewById(2131296902));
    AVNotifyCenter localAVNotifyCenter = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localAVNotifyCenter.h())
    {
      this.e.setVisibility(0);
      String str = localAVNotifyCenter.c();
      localObject = str;
      if (str == null) {
        localObject = "找行家";
      }
      this.e.setFirstLineText((CharSequence)localObject);
      localObject = localAVNotifyCenter.d();
      if (localObject == null)
      {
        this.e.setSecondLineVisible(false);
        this.e.a(true);
        this.e.setOnClickListener(this);
        this.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("sp_famous_person_chatting_show_guid", true);
        if (this.jdField_c_of_type_Boolean) {
          this.e.setRightIcon(getResources().getDrawable(2130843324));
        }
        if (localAVNotifyCenter.a() != null) {
          break label730;
        }
        this.e.setLeftIcon(getResources().getDrawable(2130839114));
      }
    }
    for (;;)
    {
      this.d = ((FormMutiItem)findViewById(2131296900));
      this.d.setLeftIcon(getResources().getDrawable(2130838519));
      this.d.setFirstLineText(getResources().getString(2131372052));
      this.d.setSecondLineText(getResources().getString(2131372053));
      this.d.setSecondLineVisible(true);
      this.d.a(true);
      this.d.setOnClickListener(this);
      if (AppSetting.j) {
        this.d.setContentDescription("当面加好友，添加身边的人和群");
      }
      return;
      this.e.setSecondLineVisible(true);
      this.e.setSecondLineText((CharSequence)localObject);
      break;
      label730:
      if ((localAVNotifyCenter.e() == 0) || (localAVNotifyCenter.f() == 0)) {
        localAVNotifyCenter.a(getResources(), 2130839114);
      }
      localObject = localAVNotifyCenter.a();
      localObject = new BitmapDrawable(getResources(), (Bitmap)localObject);
      this.e.setLeftIcon((Drawable)localObject, localAVNotifyCenter.f(), localAVNotifyCenter.e());
      continue;
      this.e.setVisibility(8);
    }
  }
  
  private void j()
  {
    h();
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a().getIntent();
    this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter = new MayKnowAdapter(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, 1, localIntent.getIntExtra("EntranceId", 0));
    k();
  }
  
  private void k()
  {
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    Object localObject = localSharedPreferences.getString(this.jdField_b_of_type_JavaLangString, "");
    if (((String)localObject).length() > 0)
    {
      localObject = ((String)localObject).split(",");
      if (localObject.length > 0) {
        this.jdField_a_of_type_JavaUtilList = Arrays.asList((Object[])localObject);
      }
    }
    localObject = a(this.jdField_a_of_type_JavaUtilList);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineText("");
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
    }
    for (;;)
    {
      if (localPhoneContactManager != null)
      {
        if (!localPhoneContactManager.b()) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new ogw(this, (String)localObject, localSharedPreferences));
      }
      return;
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineText((CharSequence)localObject);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(true);
    }
    localSharedPreferences.edit().putString(this.jdField_b_of_type_JavaLangString, "").commit();
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131493440);
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58));
    i();
    j();
  }
  
  protected void b()
  {
    super.b();
    e();
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b();
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter.a();
    }
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter.b();
    }
  }
  
  protected void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a().b(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter.c();
    }
  }
  
  public void e()
  {
    Object localObject2;
    Object localObject1;
    int i;
    if (QLog.isColorLevel())
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("fillSearchConditions | autoReqLocation = ").append(this.jdField_a_of_type_Boolean).append(" | code one = ");
      if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ArrayOfJavaLangString.length == 4))
      {
        localObject1 = this.jdField_a_of_type_ArrayOfJavaLangString[0];
        QLog.d((String)localObject2, 2, localObject1);
      }
    }
    else
    {
      localObject1 = new StringBuilder("条件：");
      i = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d();
      if (i != 0) {
        ((StringBuilder)localObject1).append(ConditionSearchManager.jdField_a_of_type_ArrayOfJavaLangString[i]).append("、");
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(localObject2[0], localObject2[1]);
      if (!ConditionSearchManager.b[0].equals(localObject2)) {
        ((StringBuilder)localObject1).append((String)localObject2).append("、");
      }
      i = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b();
      if ((i != 0) && (i != ConditionSearchManager.d.length - 1)) {
        ((StringBuilder)localObject1).append(ConditionSearchManager.e[i]).append("、");
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label557;
      }
      if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_b_of_type_Boolean)) {
        if ("-1".equals(this.jdField_a_of_type_ArrayOfJavaLangString[0]))
        {
          localObject2 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          if (localObject2 == null) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ArrayOfJavaLangString = ((Card)localObject2).strLocationCodes.split("-");
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "card.strLocationCodes = " + ((Card)localObject2).strLocationCodes);
        }
      }
      catch (Exception localException1)
      {
        try
        {
          this.jdField_a_of_type_ArrayOfJavaLangString[3] = "0";
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this.jdField_a_of_type_ArrayOfJavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this.jdField_a_of_type_ArrayOfJavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(0, (String)localObject2);
          if (!"0".equals(this.jdField_a_of_type_ArrayOfJavaLangString[0])) {
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a((String)localObject2)).append("、");
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(1);
          if (!((String)localObject2).startsWith("不限")) {
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a((String)localObject2)).append("、");
          }
          i = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c();
          if (i != 0) {
            ((StringBuilder)localObject1).append(ConditionSearchManager.c[i]).append("、");
          }
          localObject2 = ((StringBuilder)localObject1).toString();
          localObject1 = localObject2;
          if (((String)localObject2).endsWith("、")) {
            localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
          }
          if (((String)localObject1).equals("条件：")) {
            break label597;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(true);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineText((CharSequence)localObject1);
          return;
          localObject1 = Integer.valueOf(64536);
          break;
          localException1 = localException1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "spliteLocationString | exception: ", localException1);
          continue;
        }
        catch (Exception localException2)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "parseLocationDesc", localException2);
          continue;
        }
      }
      label557:
      String str = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(0);
      if (!str.startsWith("不限")) {
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(str)).append("、");
      }
    }
    label597:
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131296899: 
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BEC", "0X8004BEC", 1, 0, "", "", "", "");
      return;
    case 2131296901: 
      ((FormSimpleItem)findViewById(2131296901)).setRightIcon(null);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(new Intent(this.jdField_a_of_type_AndroidAppActivity, ConditionSearchFriendActivity.class).putExtra("from", "addcontacts").putExtra("key_first_req_location", this.jdField_a_of_type_Boolean));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004240", "0X8004240", 0, 0, "", "", "", "");
      return;
    case 2131296903: 
      paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, PhoneFrameActivity.class);
      paramView.putExtra("key_reserved_mobile", (String[])this.jdField_a_of_type_JavaUtilList.toArray(new String[this.jdField_a_of_type_JavaUtilList.size()]));
      paramView.putExtra("key_req_type", 3);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800474A", "0X800474A", 0, 0, "", "", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80068A6", "0X80068A6", 0, 0, "", "", "", "");
      switch (((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).d())
      {
      default: 
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80068A7", "0X80068A7", 0, 0, "", "", "", "");
      return;
    case 2131296904: 
      if (!NearbySPUtil.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))
      {
        paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, NearbyActivity.class);
        paramView.putExtra("ENTER_TIME", System.currentTimeMillis());
        paramView.putExtra("FROM_WHERE", 1004);
        paramView.putExtra("leftViewText", this.jdField_a_of_type_AndroidAppActivity.getResources().getText(2131368676));
        NearbyFakeActivity.a(this.jdField_a_of_type_AndroidAppActivity, paramView);
      }
      for (;;)
      {
        ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004FA1", "0X8004FA1", 0, 0, "", "", "", "");
        return;
        paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, NearbyGuideActivity.class);
        paramView.putExtra("FROM_WHERE", 1004);
        paramView.putExtra("leftViewText", this.jdField_a_of_type_AndroidAppActivity.getResources().getText(2131368676));
        this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
      }
    case 2131296900: 
      paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, Face2FaceAddFriendActivity.class);
      paramView.putExtra("activity_from_type", 0);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80050E8", "0X80050E8", 0, 0, "", "", "", "");
      return;
    case 2131296902: 
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("sp_famous_person_chatting_show_guid", false).commit();
      ((FormSimpleItem)findViewById(2131296902)).setRightIcon(null);
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      localIntent.putExtra("isShowAd", false);
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e();
      paramView = str;
      if (str == null) {
        paramView = "http://expert.mobile.qq.com/masters/client/masterlist.html?_wv=1027" + "&ADTAG=Client.Hangjia.Zhaoren.01";
      }
      localIntent.putExtra("url", paramView);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0x8006493", "0x8006493", 0, 0, "", "", "", "");
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a().getIntent().getIntExtra("EntranceId", 0);
    switch (i)
    {
    }
    for (;;)
    {
      paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, RecommendFriendActivity.class);
      paramView.putExtra("EntranceId", i);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006747", "0X8006747", 0, 0, "", "", "", "");
      continue;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006770", "0X8006770", 0, 0, "", "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\contact\addcontact\AddContactsView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */