package com.tencent.mobileqq.activity;

import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.qrcode.activity.QRLoginActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import lfe;
import lff;
import lfh;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;

public class DevlockQuickLoginActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  static final int jdField_a_of_type_Int = 1;
  static final long jdField_a_of_type_Long = 16L;
  static final String jdField_a_of_type_JavaLangString = "DevlockQuickLoginActivity";
  public static final String b = "QR_CODE_STRING";
  Handler jdField_a_of_type_AndroidOsHandler;
  Button jdField_a_of_type_AndroidWidgetButton;
  public ImageView a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver;
  byte[] jdField_a_of_type_ArrayOfByte;
  protected int b;
  Button jdField_b_of_type_AndroidWidgetButton;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  byte[] jdField_b_of_type_ArrayOfByte;
  protected int c;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  protected int d;
  String d;
  protected int e;
  String e;
  private int f;
  
  public DevlockQuickLoginActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = new lfe(this);
    this.jdField_a_of_type_ArrayOfByte = null;
    this.f = 1;
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = 2;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_MqqObserverWtloginObserver = new lfh(this);
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 104
    //   3: invokevirtual 105	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:getString	(I)Ljava/lang/String;
    //   6: astore_2
    //   7: aload_0
    //   8: ldc 106
    //   10: invokevirtual 105	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:getString	(I)Ljava/lang/String;
    //   13: astore_3
    //   14: aload_0
    //   15: ldc 107
    //   17: invokevirtual 105	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:getString	(I)Ljava/lang/String;
    //   20: astore_1
    //   21: aload_0
    //   22: getfield 49	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_ArrayOfByte	[B
    //   25: ifnull +1027 -> 1052
    //   28: new 109	com/tencent/ims/devlock_verify_scheme$SchemePkg
    //   31: dup
    //   32: invokespecial 110	com/tencent/ims/devlock_verify_scheme$SchemePkg:<init>	()V
    //   35: astore 6
    //   37: aload 6
    //   39: aload_0
    //   40: getfield 49	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_ArrayOfByte	[B
    //   43: invokevirtual 114	com/tencent/ims/devlock_verify_scheme$SchemePkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   46: pop
    //   47: aload 6
    //   49: getfield 118	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_verify_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   52: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   55: ifeq +1029 -> 1084
    //   58: aload 6
    //   60: getfield 118	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_verify_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   63: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   66: istore 11
    //   68: iload 11
    //   70: iconst_2
    //   71: if_icmpne +981 -> 1052
    //   74: aload 6
    //   76: getfield 129	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_use_local_scheme	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   79: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   82: ifeq +996 -> 1078
    //   85: aload 6
    //   87: getfield 129	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_use_local_scheme	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   90: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   93: istore 11
    //   95: iload 11
    //   97: ifne +955 -> 1052
    //   100: aload 6
    //   102: getfield 133	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   105: invokevirtual 136	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   108: ifeq +941 -> 1049
    //   111: aload 6
    //   113: getfield 133	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   116: invokevirtual 139	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   119: astore 4
    //   121: aload 4
    //   123: astore_2
    //   124: aload 6
    //   126: getfield 142	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_text	Lcom/tencent/mobileqq/pb/PBStringField;
    //   129: invokevirtual 136	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   132: ifeq +911 -> 1043
    //   135: aload 6
    //   137: getfield 142	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_text	Lcom/tencent/mobileqq/pb/PBStringField;
    //   140: invokevirtual 139	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   143: astore 5
    //   145: aload 6
    //   147: getfield 145	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_subtext	Lcom/tencent/mobileqq/pb/PBStringField;
    //   150: invokevirtual 136	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   153: ifeq +881 -> 1034
    //   156: aload 6
    //   158: getfield 145	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_subtext	Lcom/tencent/mobileqq/pb/PBStringField;
    //   161: invokevirtual 139	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   164: astore 4
    //   166: aload 4
    //   168: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   171: istore 17
    //   173: iload 17
    //   175: ifne +853 -> 1028
    //   178: iconst_1
    //   179: istore 13
    //   181: aload 6
    //   183: getfield 154	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button1_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   186: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   189: ifeq +15 -> 204
    //   192: aload_0
    //   193: aload 6
    //   195: getfield 154	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button1_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   198: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   201: putfield 55	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_c_of_type_Int	I
    //   204: aload 6
    //   206: getfield 157	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_button1_caption	Lcom/tencent/mobileqq/pb/PBStringField;
    //   209: invokevirtual 136	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   212: ifeq +383 -> 595
    //   215: aload 6
    //   217: getfield 157	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_button1_caption	Lcom/tencent/mobileqq/pb/PBStringField;
    //   220: invokevirtual 139	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   223: astore_3
    //   224: iconst_1
    //   225: istore 11
    //   227: aload 6
    //   229: getfield 160	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button1_auth	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   232: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   235: ifeq +15 -> 250
    //   238: aload_0
    //   239: aload 6
    //   241: getfield 160	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button1_auth	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   244: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   247: putfield 53	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_Int	I
    //   250: aload_0
    //   251: getfield 55	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_c_of_type_Int	I
    //   254: istore 12
    //   256: iload 12
    //   258: ifne +763 -> 1021
    //   261: iconst_0
    //   262: istore 12
    //   264: aload 6
    //   266: getfield 163	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button2_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   269: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   272: ifeq +15 -> 287
    //   275: aload_0
    //   276: aload 6
    //   278: getfield 163	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button2_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   281: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   284: putfield 57	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_e_of_type_Int	I
    //   287: aload 6
    //   289: getfield 166	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_button2_caption	Lcom/tencent/mobileqq/pb/PBStringField;
    //   292: invokevirtual 136	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   295: istore 17
    //   297: iload 17
    //   299: ifeq +713 -> 1012
    //   302: aload 6
    //   304: getfield 166	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_button2_caption	Lcom/tencent/mobileqq/pb/PBStringField;
    //   307: invokevirtual 139	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   310: astore 7
    //   312: iconst_1
    //   313: istore 11
    //   315: aload 6
    //   317: getfield 169	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button2_auth	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   320: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   323: ifeq +15 -> 338
    //   326: aload_0
    //   327: aload 6
    //   329: getfield 169	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button2_auth	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   332: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   335: putfield 171	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_d_of_type_Int	I
    //   338: aload_0
    //   339: getfield 57	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_e_of_type_Int	I
    //   342: istore 16
    //   344: iload 12
    //   346: istore 14
    //   348: iload 13
    //   350: istore 15
    //   352: aload 7
    //   354: astore_1
    //   355: aload_3
    //   356: astore 6
    //   358: aload 4
    //   360: astore 8
    //   362: aload 5
    //   364: astore 9
    //   366: aload_2
    //   367: astore 10
    //   369: iload 16
    //   371: ifne +31 -> 402
    //   374: iconst_0
    //   375: istore 11
    //   377: aload_2
    //   378: astore 10
    //   380: aload 5
    //   382: astore 9
    //   384: aload 4
    //   386: astore 8
    //   388: aload_3
    //   389: astore 6
    //   391: aload 7
    //   393: astore_1
    //   394: iload 13
    //   396: istore 15
    //   398: iload 12
    //   400: istore 14
    //   402: aload_0
    //   403: aload 10
    //   405: invokevirtual 175	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:setTitle	(Ljava/lang/CharSequence;)V
    //   408: aload_0
    //   409: getfield 177	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   412: astore_3
    //   413: aload_0
    //   414: getfield 181	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   417: ifnull +251 -> 668
    //   420: aload_0
    //   421: getfield 181	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   424: invokevirtual 185	com/tencent/mobileqq/app/QQAppInterface:b	()Ljava/lang/String;
    //   427: astore_2
    //   428: aload_3
    //   429: aload_2
    //   430: invokevirtual 190	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   433: aload_0
    //   434: getfield 192	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   437: aload 9
    //   439: invokevirtual 190	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   442: iload 15
    //   444: ifeq +230 -> 674
    //   447: aload_0
    //   448: getfield 194	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   451: aload 8
    //   453: invokevirtual 190	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   456: iload 14
    //   458: ifeq +298 -> 756
    //   461: aload 6
    //   463: astore_2
    //   464: aload 6
    //   466: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   469: ifeq +18 -> 487
    //   472: aload_0
    //   473: getfield 53	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_Int	I
    //   476: iconst_1
    //   477: if_icmpne +209 -> 686
    //   480: aload_0
    //   481: ldc -61
    //   483: invokevirtual 105	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:getString	(I)Ljava/lang/String;
    //   486: astore_2
    //   487: aload_0
    //   488: getfield 197	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   491: aload_2
    //   492: invokevirtual 200	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   495: aload_0
    //   496: getfield 55	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_c_of_type_Int	I
    //   499: iconst_2
    //   500: if_icmpne +196 -> 696
    //   503: aload_0
    //   504: getfield 197	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   507: ldc -55
    //   509: invokevirtual 205	android/widget/Button:setBackgroundResource	(I)V
    //   512: aload_0
    //   513: getfield 197	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   516: aload_0
    //   517: ldc -50
    //   519: invokevirtual 210	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   522: iload 11
    //   524: ifeq +310 -> 834
    //   527: aload_1
    //   528: astore_2
    //   529: aload_1
    //   530: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   533: ifeq +18 -> 551
    //   536: aload_0
    //   537: getfield 171	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_d_of_type_Int	I
    //   540: iconst_1
    //   541: if_icmpne +227 -> 768
    //   544: aload_0
    //   545: ldc -61
    //   547: invokevirtual 105	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:getString	(I)Ljava/lang/String;
    //   550: astore_2
    //   551: aload_0
    //   552: getfield 212	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   555: iconst_0
    //   556: invokevirtual 215	android/widget/Button:setVisibility	(I)V
    //   559: aload_0
    //   560: getfield 212	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   563: aload_2
    //   564: invokevirtual 200	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   567: aload_0
    //   568: getfield 57	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_e_of_type_Int	I
    //   571: iconst_2
    //   572: if_icmpne +206 -> 778
    //   575: aload_0
    //   576: getfield 212	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   579: ldc -55
    //   581: invokevirtual 205	android/widget/Button:setBackgroundResource	(I)V
    //   584: aload_0
    //   585: getfield 212	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   588: aload_0
    //   589: ldc -50
    //   591: invokevirtual 210	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   594: return
    //   595: iconst_0
    //   596: istore 11
    //   598: aconst_null
    //   599: astore_3
    //   600: goto -373 -> 227
    //   603: astore 4
    //   605: aload_2
    //   606: astore 7
    //   608: aconst_null
    //   609: astore 6
    //   611: aconst_null
    //   612: astore 8
    //   614: iconst_1
    //   615: istore 13
    //   617: iconst_0
    //   618: istore 11
    //   620: iconst_1
    //   621: istore 12
    //   623: aload 4
    //   625: astore_2
    //   626: aload_3
    //   627: astore 5
    //   629: aload_1
    //   630: astore 4
    //   632: aload 8
    //   634: astore_3
    //   635: aload 6
    //   637: astore_1
    //   638: aload_2
    //   639: invokevirtual 218	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   642: iload 12
    //   644: istore 14
    //   646: iload 13
    //   648: istore 15
    //   650: aload_3
    //   651: astore 6
    //   653: aload 4
    //   655: astore 8
    //   657: aload 5
    //   659: astore 9
    //   661: aload 7
    //   663: astore 10
    //   665: goto -263 -> 402
    //   668: ldc -36
    //   670: astore_2
    //   671: goto -243 -> 428
    //   674: aload_0
    //   675: getfield 194	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   678: bipush 8
    //   680: invokevirtual 221	android/widget/TextView:setVisibility	(I)V
    //   683: goto -227 -> 456
    //   686: aload_0
    //   687: ldc -34
    //   689: invokevirtual 105	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:getString	(I)Ljava/lang/String;
    //   692: astore_2
    //   693: goto -206 -> 487
    //   696: aload_0
    //   697: getfield 55	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_c_of_type_Int	I
    //   700: iconst_3
    //   701: if_icmpne +25 -> 726
    //   704: aload_0
    //   705: getfield 197	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   708: ldc -33
    //   710: invokevirtual 205	android/widget/Button:setBackgroundResource	(I)V
    //   713: aload_0
    //   714: getfield 197	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   717: aload_0
    //   718: ldc -32
    //   720: invokevirtual 210	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   723: goto -201 -> 522
    //   726: aload_0
    //   727: getfield 55	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_c_of_type_Int	I
    //   730: iconst_1
    //   731: if_icmpne -209 -> 522
    //   734: aload_0
    //   735: getfield 197	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   738: ldc -31
    //   740: invokevirtual 205	android/widget/Button:setBackgroundResource	(I)V
    //   743: aload_0
    //   744: getfield 197	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   747: aload_0
    //   748: ldc -30
    //   750: invokevirtual 210	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   753: goto -231 -> 522
    //   756: aload_0
    //   757: getfield 197	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   760: bipush 8
    //   762: invokevirtual 215	android/widget/Button:setVisibility	(I)V
    //   765: goto -243 -> 522
    //   768: aload_0
    //   769: ldc -34
    //   771: invokevirtual 105	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:getString	(I)Ljava/lang/String;
    //   774: astore_2
    //   775: goto -224 -> 551
    //   778: aload_0
    //   779: getfield 57	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_e_of_type_Int	I
    //   782: iconst_3
    //   783: if_icmpne +23 -> 806
    //   786: aload_0
    //   787: getfield 212	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   790: ldc -33
    //   792: invokevirtual 205	android/widget/Button:setBackgroundResource	(I)V
    //   795: aload_0
    //   796: getfield 212	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   799: aload_0
    //   800: ldc -32
    //   802: invokevirtual 210	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   805: return
    //   806: aload_0
    //   807: getfield 57	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_e_of_type_Int	I
    //   810: iconst_1
    //   811: if_icmpne -217 -> 594
    //   814: aload_0
    //   815: getfield 212	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   818: ldc -31
    //   820: invokevirtual 205	android/widget/Button:setBackgroundResource	(I)V
    //   823: aload_0
    //   824: getfield 212	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   827: aload_0
    //   828: ldc -30
    //   830: invokevirtual 210	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   833: return
    //   834: aload_0
    //   835: getfield 212	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   838: bipush 8
    //   840: invokevirtual 215	android/widget/Button:setVisibility	(I)V
    //   843: return
    //   844: astore 6
    //   846: aload_1
    //   847: astore 4
    //   849: aload_3
    //   850: astore 5
    //   852: iconst_1
    //   853: istore 13
    //   855: aconst_null
    //   856: astore_1
    //   857: aconst_null
    //   858: astore_3
    //   859: iconst_0
    //   860: istore 11
    //   862: iconst_1
    //   863: istore 12
    //   865: aload_2
    //   866: astore 7
    //   868: aload 6
    //   870: astore_2
    //   871: goto -233 -> 638
    //   874: astore 6
    //   876: aconst_null
    //   877: astore_3
    //   878: aload_1
    //   879: astore 4
    //   881: iconst_0
    //   882: istore 13
    //   884: aconst_null
    //   885: astore_1
    //   886: iconst_1
    //   887: istore 12
    //   889: iconst_0
    //   890: istore 11
    //   892: aload_2
    //   893: astore 7
    //   895: aload 6
    //   897: astore_2
    //   898: goto -260 -> 638
    //   901: astore 6
    //   903: aconst_null
    //   904: astore_1
    //   905: aconst_null
    //   906: astore_3
    //   907: iconst_0
    //   908: istore 13
    //   910: iconst_0
    //   911: istore 11
    //   913: iconst_1
    //   914: istore 12
    //   916: aload_2
    //   917: astore 7
    //   919: aload 6
    //   921: astore_2
    //   922: goto -284 -> 638
    //   925: astore 6
    //   927: aconst_null
    //   928: astore_3
    //   929: iconst_1
    //   930: istore 12
    //   932: aconst_null
    //   933: astore_1
    //   934: iconst_0
    //   935: istore 11
    //   937: aload_2
    //   938: astore 7
    //   940: aload 6
    //   942: astore_2
    //   943: goto -305 -> 638
    //   946: astore 6
    //   948: iload 11
    //   950: istore 12
    //   952: aconst_null
    //   953: astore_1
    //   954: iconst_0
    //   955: istore 11
    //   957: aload_2
    //   958: astore 7
    //   960: aload 6
    //   962: astore_2
    //   963: goto -325 -> 638
    //   966: astore 6
    //   968: aconst_null
    //   969: astore_1
    //   970: iconst_0
    //   971: istore 11
    //   973: aload_2
    //   974: astore 7
    //   976: aload 6
    //   978: astore_2
    //   979: goto -341 -> 638
    //   982: astore 6
    //   984: aconst_null
    //   985: astore_1
    //   986: iconst_1
    //   987: istore 11
    //   989: aload_2
    //   990: astore 7
    //   992: aload 6
    //   994: astore_2
    //   995: goto -357 -> 638
    //   998: astore 6
    //   1000: aload 7
    //   1002: astore_1
    //   1003: aload_2
    //   1004: astore 7
    //   1006: aload 6
    //   1008: astore_2
    //   1009: goto -371 -> 638
    //   1012: aconst_null
    //   1013: astore 7
    //   1015: iconst_0
    //   1016: istore 11
    //   1018: goto -703 -> 315
    //   1021: iload 11
    //   1023: istore 12
    //   1025: goto -761 -> 264
    //   1028: iconst_0
    //   1029: istore 13
    //   1031: goto -850 -> 181
    //   1034: iconst_0
    //   1035: istore 13
    //   1037: aload_1
    //   1038: astore 4
    //   1040: goto -859 -> 181
    //   1043: aload_3
    //   1044: astore 5
    //   1046: goto -901 -> 145
    //   1049: goto -925 -> 124
    //   1052: aload_1
    //   1053: astore 8
    //   1055: aconst_null
    //   1056: astore_1
    //   1057: aconst_null
    //   1058: astore 6
    //   1060: iconst_1
    //   1061: istore 15
    //   1063: iconst_1
    //   1064: istore 14
    //   1066: iconst_0
    //   1067: istore 11
    //   1069: aload_3
    //   1070: astore 9
    //   1072: aload_2
    //   1073: astore 10
    //   1075: goto -673 -> 402
    //   1078: iconst_1
    //   1079: istore 11
    //   1081: goto -986 -> 95
    //   1084: iconst_1
    //   1085: istore 11
    //   1087: goto -1019 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1090	0	this	DevlockQuickLoginActivity
    //   20	1037	1	localObject1	Object
    //   6	1067	2	localObject2	Object
    //   13	1057	3	localObject3	Object
    //   119	266	4	str	String
    //   603	21	4	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   630	409	4	localObject4	Object
    //   143	902	5	localObject5	Object
    //   35	617	6	localObject6	Object
    //   844	25	6	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   874	22	6	localInvalidProtocolBufferMicroException3	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   901	19	6	localInvalidProtocolBufferMicroException4	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   925	16	6	localInvalidProtocolBufferMicroException5	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   946	15	6	localInvalidProtocolBufferMicroException6	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   966	11	6	localInvalidProtocolBufferMicroException7	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   982	11	6	localInvalidProtocolBufferMicroException8	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   998	9	6	localInvalidProtocolBufferMicroException9	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   1058	1	6	localObject7	Object
    //   310	704	7	localObject8	Object
    //   360	694	8	localObject9	Object
    //   364	707	9	localObject10	Object
    //   367	707	10	localObject11	Object
    //   66	1020	11	i	int
    //   254	770	12	j	int
    //   179	857	13	k	int
    //   346	719	14	m	int
    //   350	712	15	n	int
    //   342	28	16	i1	int
    //   171	127	17	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   37	68	603	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   74	95	603	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   100	121	603	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   124	145	844	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   145	166	874	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   166	173	901	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   181	204	925	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   204	224	925	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   227	250	946	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   250	256	946	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   264	287	966	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   287	297	966	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   302	312	982	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   315	338	998	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   338	344	998	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void d()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
  {
    a();
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230).setTitle(paramString1).setMessage(paramString2);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(paramString3, paramOnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void b()
  {
    Object localObject1 = QRUtils.a(this.app.a());
    Object localObject2 = ByteBuffer.allocate(localObject1.length + 4);
    ((ByteBuffer)localObject2).putShort((short)2);
    ((ByteBuffer)localObject2).putShort((short)localObject1.length);
    ((ByteBuffer)localObject2).put((byte[])localObject1);
    Object localObject3 = ((ByteBuffer)localObject2).array();
    localObject1 = this.app.a();
    Object localObject4 = this.app.b((String)localObject1);
    localObject2 = new ArrayList();
    if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (!((String)localObject4).equals(localObject1)))
    {
      localObject4 = ((String)localObject4).getBytes();
      ByteBuffer localByteBuffer = ByteBuffer.allocate(localObject4.length + 4);
      localByteBuffer.putShort((short)1);
      localByteBuffer.putShort((short)localObject4.length);
      localByteBuffer.put((byte[])localObject4);
      localObject4 = localByteBuffer.array();
      localByteBuffer = ByteBuffer.allocate(localObject4.length + 4);
      localByteBuffer.putShort((short)4);
      localByteBuffer.putShort((short)localObject4.length);
      localByteBuffer.put((byte[])localObject4);
      localObject4 = localByteBuffer.array();
      ((ArrayList)localObject2).add(HexUtil.bytes2HexStr((byte[])localObject3));
      ((ArrayList)localObject2).add(HexUtil.bytes2HexStr((byte[])localObject4));
      localObject3 = ByteBuffer.allocate(8);
      ((ByteBuffer)localObject3).putShort((short)21);
      ((ByteBuffer)localObject3).putShort((short)4);
      if (this.f != 2) {
        break label305;
      }
    }
    label305:
    for (int i = 1;; i = 0)
    {
      ((ByteBuffer)localObject3).putInt(i);
      ((ArrayList)localObject2).add(HexUtil.bytes2HexStr(((ByteBuffer)localObject3).array()));
      if (QLog.isColorLevel()) {
        QLog.d("DevlockQuickLoginActivity", 2, "confirmLogin start CloseCode..");
      }
      ((WtloginManager)this.app.getManager(1)).CloseCode((String)localObject1, 16L, this.jdField_b_of_type_ArrayOfByte, 1, (ArrayList)localObject2, this.jdField_a_of_type_MqqObserverWtloginObserver);
      return;
      ((ArrayList)localObject2).add(HexUtil.bytes2HexStr((byte[])localObject3));
      break;
    }
  }
  
  protected boolean onBackEvent()
  {
    super.finish();
    super.overridePendingTransition(0, 2130968593);
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    switch (i)
    {
    default: 
      return;
    case 2131297183: 
      super.finish();
      super.overridePendingTransition(0, 2130968593);
      return;
    }
    if (!NetworkUtil.e(this))
    {
      QQToast.a(this, super.getString(2131367256), 0).b(super.getTitleBarHeight());
      return;
    }
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DevlockQuickLoginActivity", 2, "requestQRLogin qrCodeString is empty");
      }
      QQToast.a(super.getApplicationContext(), 1, super.getString(2131370746), 0).b(getTitleBarHeight());
      super.finish();
      super.overridePendingTransition(0, 2130968593);
      return;
    }
    int j = this.jdField_c_of_type_JavaLangString.indexOf("?k=") + 3;
    if (j < 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DevlockQuickLoginActivity", 2, "requestQRLogin qrCodeString  error");
      }
      QQToast.a(super.getApplicationContext(), 1, super.getString(2131370746), 0).b(getTitleBarHeight());
      super.finish();
      super.overridePendingTransition(0, 2130968593);
      return;
    }
    paramView = this.jdField_c_of_type_JavaLangString.substring(j, j + 32);
    this.jdField_b_of_type_ArrayOfByte = QRLoginActivity.a(paramView.getBytes(), paramView.length());
    paramView = this.app.a();
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) && (!super.isFinishing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131369268);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      if (QLog.isColorLevel()) {
        QLog.d("DevlockQuickLoginActivity", 2, "requestQRLogin start verifyCode..");
      }
      if (i == 2131300209)
      {
        i = this.jdField_b_of_type_Int;
        this.f = i;
        WtloginManager localWtloginManager = (WtloginManager)this.app.getManager(1);
        byte[] arrayOfByte = this.jdField_b_of_type_ArrayOfByte;
        WtloginObserver localWtloginObserver = this.jdField_a_of_type_MqqObserverWtloginObserver;
        localWtloginManager.VerifyCode(paramView, 16L, true, arrayOfByte, new int[] { 5 }, 1, localWtloginObserver);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        continue;
        i = this.jdField_d_of_type_Int;
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.setTheme(2131559165);
    super.onCreate(paramBundle);
    super.setContentView(2130904151);
    this.leftView.setVisibility(4);
    super.setRightButton(2131369134, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131300049));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131300050));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131301580));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131301581));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131300209));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131301582));
    paramBundle = super.getIntent();
    if (paramBundle != null)
    {
      this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("qrcode");
      this.jdField_d_of_type_JavaLangString = paramBundle.getStringExtra("maintip");
      this.jdField_e_of_type_JavaLangString = paramBundle.getStringExtra("smalltip");
      this.jdField_a_of_type_ArrayOfByte = paramBundle.getByteArrayExtra("loginConfig");
    }
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (QLog.isColorLevel()) {
      QLog.d("DevlockQuickLoginActivity", 2, "onCreate qrCodeSting=" + this.jdField_c_of_type_JavaLangString + " mainTip=" + this.jdField_d_of_type_JavaLangString + " smallTip=" + this.jdField_e_of_type_JavaLangString);
    }
    ThreadManager.a(new lff(this), 5, null, false);
    c();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    d();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("qrcode");
      this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("maintip");
      this.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("smalltip");
      this.jdField_a_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("loginConfig");
      if (QLog.isColorLevel()) {
        QLog.d("DevlockQuickLoginActivity", 2, "onNewIntent qrCodeSting=" + this.jdField_c_of_type_JavaLangString + " mainTip=" + this.jdField_d_of_type_JavaLangString + " smallTip=" + this.jdField_e_of_type_JavaLangString);
      }
      c();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("DevlockQuickLoginActivity", 2, "onNewIntent intent is null");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\DevlockQuickLoginActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */