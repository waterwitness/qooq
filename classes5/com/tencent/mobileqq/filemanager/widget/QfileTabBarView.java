package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import skg;

public class QfileTabBarView
  extends RelativeLayout
  implements View.OnClickListener
{
  public int a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public BaseFileAssistantActivity a;
  QfileBaseTabView jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView = null;
  private TabBarView.OnTabChangeListener jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener = new skg(this);
  public TabBarView a;
  String jdField_a_of_type_JavaLangString;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public boolean a;
  public int b;
  HashMap b = new HashMap();
  public HashMap c = new LinkedHashMap();
  
  public QfileTabBarView(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QfileTabBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = null;
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130904006, this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = ((BaseFileAssistantActivity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131298218));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131300977));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.a();
  }
  
  /* Error */
  public QfileBaseTabView a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:b	Ljava/util/HashMap;
    //   4: iload_1
    //   5: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   8: invokevirtual 108	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11: checkcast 93	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView
    //   14: astore_2
    //   15: aload_2
    //   16: ifnull +5 -> 21
    //   19: aload_2
    //   20: areturn
    //   21: aload_0
    //   22: getfield 50	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:c	Ljava/util/HashMap;
    //   25: iload_1
    //   26: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   29: invokevirtual 108	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   32: checkcast 100	java/lang/Integer
    //   35: invokevirtual 111	java/lang/Integer:intValue	()I
    //   38: istore 4
    //   40: aload_0
    //   41: getfield 113	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   44: ifnull +158 -> 202
    //   47: aload_0
    //   48: getfield 113	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   51: invokevirtual 119	java/lang/String:trim	()Ljava/lang/String;
    //   54: invokevirtual 122	java/lang/String:length	()I
    //   57: ifeq +145 -> 202
    //   60: iconst_1
    //   61: istore 5
    //   63: iload 4
    //   65: tableswitch	default:+83->148, 3:+143->208, 4:+186->251, 5:+229->294, 6:+272->337, 7:+315->380, 8:+358->423, 9:+377->442, 10:+396->461, 11:+415->480, 12:+435->500, 13:+455->520, 14:+475->540, 15:+515->580, 16:+494->559, 17:+536->601, 18:+557->622, 19:+578->643
    //   148: aload_0
    //   149: getfield 45	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:b	Ljava/util/HashMap;
    //   152: iload_1
    //   153: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   156: aload_2
    //   157: invokevirtual 126	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   160: pop
    //   161: aload_2
    //   162: areturn
    //   163: astore_2
    //   164: aconst_null
    //   165: astore_2
    //   166: ldc -128
    //   168: iconst_1
    //   169: new 130	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   176: ldc -123
    //   178: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: iload_1
    //   182: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   185: ldc -114
    //   187: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: iconst_3
    //   197: istore 4
    //   199: goto -159 -> 40
    //   202: iconst_0
    //   203: istore 5
    //   205: goto -142 -> 63
    //   208: iload 5
    //   210: ifeq +26 -> 236
    //   213: new 153	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentAllFileTabView
    //   216: dup
    //   217: aload_0
    //   218: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   221: aload_0
    //   222: getfield 113	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   225: invokespecial 156	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentAllFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   228: astore_2
    //   229: aload_2
    //   230: invokevirtual 158	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   233: goto -85 -> 148
    //   236: new 153	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentAllFileTabView
    //   239: dup
    //   240: aload_0
    //   241: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   244: invokespecial 160	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentAllFileTabView:<init>	(Landroid/content/Context;)V
    //   247: astore_2
    //   248: goto -19 -> 229
    //   251: iload 5
    //   253: ifeq +26 -> 279
    //   256: new 162	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentDocFileTabView
    //   259: dup
    //   260: aload_0
    //   261: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   264: aload_0
    //   265: getfield 113	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   268: invokespecial 163	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentDocFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   271: astore_2
    //   272: aload_2
    //   273: invokevirtual 158	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   276: goto -128 -> 148
    //   279: new 162	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentDocFileTabView
    //   282: dup
    //   283: aload_0
    //   284: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   287: invokespecial 164	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentDocFileTabView:<init>	(Landroid/content/Context;)V
    //   290: astore_2
    //   291: goto -19 -> 272
    //   294: iload 5
    //   296: ifeq +26 -> 322
    //   299: new 166	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentPicFileTabView
    //   302: dup
    //   303: aload_0
    //   304: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   307: aload_0
    //   308: getfield 113	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   311: invokespecial 167	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentPicFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   314: astore_2
    //   315: aload_2
    //   316: invokevirtual 158	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   319: goto -171 -> 148
    //   322: new 166	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentPicFileTabView
    //   325: dup
    //   326: aload_0
    //   327: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   330: invokespecial 168	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentPicFileTabView:<init>	(Landroid/content/Context;)V
    //   333: astore_2
    //   334: goto -19 -> 315
    //   337: iload 5
    //   339: ifeq +26 -> 365
    //   342: new 170	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentMediaFileTabView
    //   345: dup
    //   346: aload_0
    //   347: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   350: aload_0
    //   351: getfield 113	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   354: invokespecial 171	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentMediaFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   357: astore_2
    //   358: aload_2
    //   359: invokevirtual 158	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   362: goto -214 -> 148
    //   365: new 170	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentMediaFileTabView
    //   368: dup
    //   369: aload_0
    //   370: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   373: invokespecial 172	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentMediaFileTabView:<init>	(Landroid/content/Context;)V
    //   376: astore_2
    //   377: goto -19 -> 358
    //   380: iload 5
    //   382: ifeq +26 -> 408
    //   385: new 174	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentAppFileTabView
    //   388: dup
    //   389: aload_0
    //   390: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   393: aload_0
    //   394: getfield 113	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   397: invokespecial 175	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentAppFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   400: astore_2
    //   401: aload_2
    //   402: invokevirtual 158	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   405: goto -257 -> 148
    //   408: new 174	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentAppFileTabView
    //   411: dup
    //   412: aload_0
    //   413: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   416: invokespecial 176	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentAppFileTabView:<init>	(Landroid/content/Context;)V
    //   419: astore_2
    //   420: goto -19 -> 401
    //   423: new 178	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileAppTabView
    //   426: dup
    //   427: aload_0
    //   428: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   431: invokespecial 179	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileAppTabView:<init>	(Landroid/content/Context;)V
    //   434: astore_2
    //   435: aload_2
    //   436: invokevirtual 158	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   439: goto -291 -> 148
    //   442: new 181	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFilePicTabView
    //   445: dup
    //   446: aload_0
    //   447: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   450: invokespecial 182	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFilePicTabView:<init>	(Landroid/content/Context;)V
    //   453: astore_2
    //   454: aload_2
    //   455: invokevirtual 158	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   458: goto -310 -> 148
    //   461: new 184	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileDocTabView
    //   464: dup
    //   465: aload_0
    //   466: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   469: invokespecial 185	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileDocTabView:<init>	(Landroid/content/Context;)V
    //   472: astore_2
    //   473: aload_2
    //   474: invokevirtual 158	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   477: goto -329 -> 148
    //   480: new 187	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileMediaTabView
    //   483: dup
    //   484: aload_0
    //   485: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   488: iconst_3
    //   489: invokespecial 190	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileMediaTabView:<init>	(Landroid/content/Context;I)V
    //   492: astore_2
    //   493: aload_2
    //   494: invokevirtual 158	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   497: goto -349 -> 148
    //   500: new 187	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileMediaTabView
    //   503: dup
    //   504: aload_0
    //   505: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   508: iconst_1
    //   509: invokespecial 190	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileMediaTabView:<init>	(Landroid/content/Context;I)V
    //   512: astore_2
    //   513: aload_2
    //   514: invokevirtual 158	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   517: goto -369 -> 148
    //   520: new 187	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileMediaTabView
    //   523: dup
    //   524: aload_0
    //   525: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   528: iconst_2
    //   529: invokespecial 190	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileMediaTabView:<init>	(Landroid/content/Context;I)V
    //   532: astore_2
    //   533: aload_2
    //   534: invokevirtual 158	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   537: goto -389 -> 148
    //   540: new 192	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileOtherTabView
    //   543: dup
    //   544: aload_0
    //   545: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   548: invokespecial 193	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileOtherTabView:<init>	(Landroid/content/Context;)V
    //   551: astore_2
    //   552: aload_2
    //   553: invokevirtual 158	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   556: goto -408 -> 148
    //   559: new 195	com/tencent/mobileqq/filemanager/activity/cloudfile/QfileCloudFileTabView
    //   562: dup
    //   563: aload_0
    //   564: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   567: ldc -59
    //   569: invokespecial 198	com/tencent/mobileqq/filemanager/activity/cloudfile/QfileCloudFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   572: astore_2
    //   573: aload_2
    //   574: invokevirtual 158	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   577: goto -429 -> 148
    //   580: new 195	com/tencent/mobileqq/filemanager/activity/cloudfile/QfileCloudFileTabView
    //   583: dup
    //   584: aload_0
    //   585: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   588: ldc -56
    //   590: invokespecial 198	com/tencent/mobileqq/filemanager/activity/cloudfile/QfileCloudFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   593: astore_2
    //   594: aload_2
    //   595: invokevirtual 158	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   598: goto -450 -> 148
    //   601: new 195	com/tencent/mobileqq/filemanager/activity/cloudfile/QfileCloudFileTabView
    //   604: dup
    //   605: aload_0
    //   606: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   609: ldc -54
    //   611: invokespecial 198	com/tencent/mobileqq/filemanager/activity/cloudfile/QfileCloudFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   614: astore_2
    //   615: aload_2
    //   616: invokevirtual 158	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   619: goto -471 -> 148
    //   622: new 195	com/tencent/mobileqq/filemanager/activity/cloudfile/QfileCloudFileTabView
    //   625: dup
    //   626: aload_0
    //   627: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   630: ldc -52
    //   632: invokespecial 198	com/tencent/mobileqq/filemanager/activity/cloudfile/QfileCloudFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   635: astore_2
    //   636: aload_2
    //   637: invokevirtual 158	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   640: goto -492 -> 148
    //   643: new 195	com/tencent/mobileqq/filemanager/activity/cloudfile/QfileCloudFileTabView
    //   646: dup
    //   647: aload_0
    //   648: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   651: ldc -50
    //   653: invokespecial 198	com/tencent/mobileqq/filemanager/activity/cloudfile/QfileCloudFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   656: astore_2
    //   657: aload_2
    //   658: invokevirtual 158	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   661: goto -513 -> 148
    //   664: astore_3
    //   665: goto -499 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	668	0	this	QfileTabBarView
    //   0	668	1	paramInt	int
    //   14	148	2	localQfileBaseTabView	QfileBaseTabView
    //   163	1	2	localException1	Exception
    //   165	493	2	localObject	Object
    //   664	1	3	localException2	Exception
    //   38	160	4	i	int
    //   61	320	5	j	int
    // Exception table:
    //   from	to	target	type
    //   0	15	163	java/lang/Exception
    //   21	40	664	java/lang/Exception
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.j();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(this.jdField_a_of_type_Int, paramString);
    this.c.put(Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt));
    this.jdField_a_of_type_Int += 1;
  }
  
  public void a(String paramString, Class paramClass)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(this.jdField_a_of_type_Int, paramString);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_Int), paramClass);
    this.jdField_a_of_type_Int += 1;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.c(paramArrayList);
  }
  
  boolean a()
  {
    return true;
  }
  
  public void b()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.getChildCount();
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0);
      i += 1;
    }
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      i = ((Integer)localIterator.next()).intValue();
      QfileBaseTabView localQfileBaseTabView = (QfileBaseTabView)this.b.get(Integer.valueOf(i));
      if (localQfileBaseTabView != null) {
        localQfileBaseTabView.c();
      }
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelected(false);
    this.c.clear();
    this.b.clear();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView);
  }
  
  public void b(int paramInt)
  {
    QfileBaseTabView localQfileBaseTabView = a(paramInt);
    if (localQfileBaseTabView == null) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView == localQfileBaseTabView);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView != null)
      {
        if (a()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.r();
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.n();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView = localQfileBaseTabView;
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView == null);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.k();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.setExpandGroup(true);
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.o();
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView);
  }
  
  public void b(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.d(paramArrayList);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a();
  }
  
  public void c(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.a(paramArrayList);
  }
  
  public void d(ArrayList paramArrayList)
  {
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      ((QfileBaseTabView)this.b.get(Integer.valueOf(i))).f(paramArrayList);
    }
  }
  
  public void e(ArrayList paramArrayList)
  {
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      ((QfileBaseTabView)this.b.get(Integer.valueOf(i))).g(paramArrayList);
    }
  }
  
  public void f(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.e(paramArrayList);
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
  }
  
  public void setMemory(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setSelectedTab(int paramInt)
  {
    Iterator localIterator = this.c.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      int j = ((Integer)localIterator.next()).intValue();
      if (((Integer)this.c.get(Integer.valueOf(j))).intValue() != paramInt)
      {
        i += 1;
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a();
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(i, true);
      }
    }
  }
  
  public void setTabFrameHeight(int paramInt)
  {
    int i = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f())
    {
      i = paramInt;
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView instanceof QfileBaseCloudFileTabView)) {
        i = paramInt + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.a();
      }
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, i);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.setLayoutParams(localLayoutParams);
  }
  
  public void setUin(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\widget\QfileTabBarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */