package com.tencent.mobileqq.testassister.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.Time;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.testassister.ShareAppLogHelper;
import com.tencent.mobileqq.testassister.ShareAppLogHelper.OnGetLocalLogListener;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.widget.Switch;
import com.tencent.widget.TCWDatePickerDialogHelper;
import uyr;
import uys;
import uyt;
import uyw;
import uyx;
import uyy;

public class ShareAppLogActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ShareAppLogHelper.OnGetLocalLogListener jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper$OnGetLocalLogListener;
  private ShareAppLogHelper jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public ShareAppLogActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = new uyr(this);
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new uys(this);
    this.jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper$OnGetLocalLogListener = new uyt(this);
  }
  
  private int a(long paramLong)
  {
    Time localTime = new Time();
    localTime.set(paramLong);
    return localTime.hour;
  }
  
  public static Intent a(Context paramContext)
  {
    return new Intent(paramContext, ShareAppLogActivity.class);
  }
  
  private String a(long paramLong)
  {
    Time localTime = new Time();
    localTime.set(paramLong);
    return localTime.year + "-" + (localTime.month + 1) + "-" + localTime.monthDay;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new uyw(this));
  }
  
  private void a(TextView paramTextView)
  {
    Time localTime = ShareAppLogHelper.a(paramTextView.getEditableText().toString(), "-");
    if (localTime == null) {
      return;
    }
    int i = localTime.year;
    int j = localTime.month;
    int k = localTime.monthDay;
    try
    {
      TCWDatePickerDialogHelper.a(this, i, j + 1, k, new uyy(this, paramTextView));
      return;
    }
    catch (Exception paramTextView) {}
  }
  
  private void a(String paramString)
  {
    paramString = new FileInfo(paramString);
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(paramString);
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(localFileManagerEntity.nSessionId);
    localForwardFileInfo.d(3);
    localForwardFileInfo.b(10000);
    localForwardFileInfo.a(paramString.d());
    localForwardFileInfo.d(paramString.e());
    localForwardFileInfo.d(paramString.a());
    a(localForwardFileInfo);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new uyx(this));
  }
  
  protected void a(Bundle paramBundle)
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), new int[] { 2 });
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
    finish();
  }
  
  public void a(ForwardFileInfo paramForwardFileInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 0);
    localBundle.putParcelable("fileinfo", paramForwardFileInfo);
    localBundle.putBoolean("not_forward", true);
    Intent localIntent = new Intent();
    localIntent.putExtras(localBundle);
    localIntent.putExtra("forward_text", paramForwardFileInfo.d());
    localIntent.putExtra("forward_type", 0);
    localIntent.putExtra("forward _key_nojump", true);
    ForwardBaseOption.a(this, localIntent, 103);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      return;
    } while ((paramIntent == null) || (paramIntent.getExtras() == null));
    a(paramIntent.getExtras());
  }
  
  /* Error */
  public void onClick(android.view.View paramView)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 266	android/view/View:getId	()I
    //   4: lookupswitch	default:+44->48, 2131302465:+285->289, 2131302469:+294->298, 2131302473:+45->49, 2131302475:+303->307
    //   48: return
    //   49: aload_0
    //   50: getfield 268	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   53: invokevirtual 114	android/widget/TextView:getEditableText	()Landroid/text/Editable;
    //   56: invokevirtual 117	java/lang/Object:toString	()Ljava/lang/String;
    //   59: astore_2
    //   60: aload_0
    //   61: getfield 270	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   64: invokevirtual 114	android/widget/TextView:getEditableText	()Landroid/text/Editable;
    //   67: invokevirtual 117	java/lang/Object:toString	()Ljava/lang/String;
    //   70: astore_1
    //   71: aload_0
    //   72: getfield 272	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:jdField_a_of_type_AndroidWidgetEditText	Landroid/widget/EditText;
    //   75: invokevirtual 275	android/widget/EditText:getEditableText	()Landroid/text/Editable;
    //   78: invokevirtual 117	java/lang/Object:toString	()Ljava/lang/String;
    //   81: invokestatic 281	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   84: istore 5
    //   86: aload_0
    //   87: getfield 283	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:jdField_b_of_type_AndroidWidgetEditText	Landroid/widget/EditText;
    //   90: invokevirtual 275	android/widget/EditText:getEditableText	()Landroid/text/Editable;
    //   93: invokevirtual 117	java/lang/Object:toString	()Ljava/lang/String;
    //   96: invokestatic 281	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   99: istore 6
    //   101: iload 5
    //   103: iflt +22 -> 125
    //   106: iload 5
    //   108: bipush 24
    //   110: if_icmpge +15 -> 125
    //   113: iload 6
    //   115: iflt +10 -> 125
    //   118: iload 6
    //   120: bipush 24
    //   122: if_icmplt +19 -> 141
    //   125: aload_0
    //   126: invokevirtual 287	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:getApplicationContext	()Landroid/content/Context;
    //   129: ldc_w 289
    //   132: iconst_0
    //   133: invokestatic 294	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   136: invokevirtual 297	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   139: pop
    //   140: return
    //   141: new 73	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   148: aload_2
    //   149: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: ldc 83
    //   154: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: iload 5
    //   159: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   162: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: ldc 83
    //   167: invokestatic 122	com/tencent/mobileqq/testassister/ShareAppLogHelper:a	(Ljava/lang/String;Ljava/lang/String;)Landroid/text/format/Time;
    //   170: astore_2
    //   171: new 73	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   178: aload_1
    //   179: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: ldc 83
    //   184: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: iload 6
    //   189: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   192: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: ldc 83
    //   197: invokestatic 122	com/tencent/mobileqq/testassister/ShareAppLogHelper:a	(Ljava/lang/String;Ljava/lang/String;)Landroid/text/format/Time;
    //   200: astore_1
    //   201: aload_2
    //   202: ifnull +7 -> 209
    //   205: aload_1
    //   206: ifnonnull +19 -> 225
    //   209: aload_0
    //   210: invokevirtual 287	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:getApplicationContext	()Landroid/content/Context;
    //   213: ldc_w 299
    //   216: iconst_0
    //   217: invokestatic 294	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   220: invokevirtual 297	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   223: pop
    //   224: return
    //   225: aload_1
    //   226: aload_2
    //   227: invokevirtual 303	android/text/format/Time:before	(Landroid/text/format/Time;)Z
    //   230: ifeq +19 -> 249
    //   233: aload_0
    //   234: invokevirtual 287	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:getApplicationContext	()Landroid/content/Context;
    //   237: ldc_w 289
    //   240: iconst_0
    //   241: invokestatic 294	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   244: invokevirtual 297	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   247: pop
    //   248: return
    //   249: aload_0
    //   250: getfield 66	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper	Lcom/tencent/mobileqq/testassister/ShareAppLogHelper;
    //   253: aload_2
    //   254: aload_1
    //   255: aload_0
    //   256: getfield 305	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:jdField_a_of_type_ComTencentWidgetSwitch	Lcom/tencent/widget/Switch;
    //   259: invokevirtual 311	com/tencent/widget/Switch:isChecked	()Z
    //   262: invokevirtual 314	com/tencent/mobileqq/testassister/ShareAppLogHelper:a	(Landroid/text/format/Time;Landroid/text/format/Time;Z)Z
    //   265: ifeq +8 -> 273
    //   268: aload_0
    //   269: invokespecial 185	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:a	()V
    //   272: return
    //   273: aload_0
    //   274: invokevirtual 287	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:getApplicationContext	()Landroid/content/Context;
    //   277: ldc_w 316
    //   280: iconst_0
    //   281: invokestatic 294	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   284: invokevirtual 297	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   287: pop
    //   288: return
    //   289: aload_0
    //   290: aload_0
    //   291: getfield 268	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   294: invokespecial 318	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:a	(Landroid/widget/TextView;)V
    //   297: return
    //   298: aload_0
    //   299: aload_0
    //   300: getfield 270	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   303: invokespecial 318	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:a	(Landroid/widget/TextView;)V
    //   306: return
    //   307: new 320	java/io/File
    //   310: dup
    //   311: new 73	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   318: invokestatic 326	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   321: invokevirtual 329	java/io/File:getPath	()Ljava/lang/String;
    //   324: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: ldc_w 331
    //   330: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: invokespecial 332	java/io/File:<init>	(Ljava/lang/String;)V
    //   339: astore 4
    //   341: aconst_null
    //   342: astore_3
    //   343: aconst_null
    //   344: astore_1
    //   345: aload_3
    //   346: astore_2
    //   347: aload 4
    //   349: invokevirtual 335	java/io/File:exists	()Z
    //   352: ifeq +131 -> 483
    //   355: aload_3
    //   356: astore_2
    //   357: aload 4
    //   359: invokevirtual 338	java/io/File:isDirectory	()Z
    //   362: ifeq +121 -> 483
    //   365: aload 4
    //   367: invokevirtual 342	java/io/File:listFiles	()[Ljava/io/File;
    //   370: astore 4
    //   372: aload_3
    //   373: astore_2
    //   374: aload 4
    //   376: ifnull +107 -> 483
    //   379: lconst_0
    //   380: lstore 7
    //   382: iconst_0
    //   383: istore 5
    //   385: aload_1
    //   386: astore_2
    //   387: iload 5
    //   389: aload 4
    //   391: arraylength
    //   392: if_icmpge +91 -> 483
    //   395: lload 7
    //   397: lstore 9
    //   399: aload_1
    //   400: astore_2
    //   401: aload 4
    //   403: iload 5
    //   405: aaload
    //   406: invokevirtual 345	java/io/File:getName	()Ljava/lang/String;
    //   409: ldc_w 347
    //   412: invokevirtual 353	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   415: ifeq +96 -> 511
    //   418: lload 7
    //   420: lstore 9
    //   422: aload_1
    //   423: astore_2
    //   424: aload 4
    //   426: iload 5
    //   428: aaload
    //   429: invokevirtual 345	java/io/File:getName	()Ljava/lang/String;
    //   432: ldc_w 355
    //   435: invokevirtual 358	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   438: ifeq +73 -> 511
    //   441: lload 7
    //   443: lstore 9
    //   445: aload_1
    //   446: astore_2
    //   447: aload 4
    //   449: iload 5
    //   451: aaload
    //   452: invokevirtual 361	java/io/File:lastModified	()J
    //   455: lload 7
    //   457: lcmp
    //   458: ifle +53 -> 511
    //   461: aload 4
    //   463: iload 5
    //   465: aaload
    //   466: invokevirtual 329	java/io/File:getPath	()Ljava/lang/String;
    //   469: astore_2
    //   470: aload 4
    //   472: iload 5
    //   474: aaload
    //   475: invokevirtual 361	java/io/File:lastModified	()J
    //   478: lstore 9
    //   480: goto +31 -> 511
    //   483: aload_2
    //   484: ifnull +9 -> 493
    //   487: aload_0
    //   488: aload_2
    //   489: invokespecial 138	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:a	(Ljava/lang/String;)V
    //   492: return
    //   493: aload_0
    //   494: invokevirtual 287	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:getApplicationContext	()Landroid/content/Context;
    //   497: ldc_w 363
    //   500: iconst_0
    //   501: invokestatic 294	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   504: invokevirtual 297	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   507: pop
    //   508: return
    //   509: astore_1
    //   510: return
    //   511: iload 5
    //   513: iconst_1
    //   514: iadd
    //   515: istore 5
    //   517: lload 9
    //   519: lstore 7
    //   521: aload_2
    //   522: astore_1
    //   523: goto -138 -> 385
    //   526: astore_1
    //   527: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	528	0	this	ShareAppLogActivity
    //   0	528	1	paramView	android.view.View
    //   59	463	2	localObject1	Object
    //   342	31	3	localObject2	Object
    //   339	132	4	localObject3	Object
    //   84	432	5	i	int
    //   99	89	6	j	int
    //   380	140	7	l1	long
    //   397	121	9	l2	long
    // Exception table:
    //   from	to	target	type
    //   71	101	509	java/lang/Exception
    //   307	341	526	java/lang/Exception
    //   347	355	526	java/lang/Exception
    //   357	372	526	java/lang/Exception
    //   387	395	526	java/lang/Exception
    //   401	418	526	java/lang/Exception
    //   424	441	526	java/lang/Exception
    //   447	480	526	java/lang/Exception
    //   487	492	526	java/lang/Exception
    //   493	508	526	java/lang/Exception
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904351);
    setTitle(2131369794);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302465));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302469));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131302464));
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131302468));
    this.jdField_a_of_type_AndroidWidgetTextView.setInputType(4);
    this.jdField_b_of_type_AndroidWidgetTextView.setInputType(4);
    this.jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper = new ShareAppLogHelper(getApplicationContext());
    this.jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper.a(this.jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper$OnGetLocalLogListener);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(a(System.currentTimeMillis() - 7200000L));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(a(System.currentTimeMillis()));
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.format("%02d", new Object[] { Integer.valueOf(a(System.currentTimeMillis() - 7200000L)) }));
    this.jdField_b_of_type_AndroidWidgetEditText.setText(String.format("%02d", new Object[] { Integer.valueOf(a(System.currentTimeMillis())) }));
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131302471));
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131302473));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131302475));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  protected void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper.a(null);
    super.onDestroy();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\testassister\activity\ShareAppLogActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */