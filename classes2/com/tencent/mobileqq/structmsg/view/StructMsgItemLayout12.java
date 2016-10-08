package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyChatFlowerHelper;
import com.tencent.mobileqq.nearby.NearbyChatFlowerHelper.FlowerPlayable;
import com.tencent.mobileqq.nearby.NearbyFlowerMessage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.ObjectInput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import mqq.util.WeakReference;
import uwc;
import uwd;

public class StructMsgItemLayout12
  extends AbsStructMsgItem
  implements Handler.Callback
{
  public static final int aA = 1;
  public static final int av = 10;
  public static final int aw = 115;
  public static final int ax = 135;
  public static final int ay = 105;
  public static final int az = 0;
  public static final String o = "";
  public static final String p = "";
  public static final String q = "StructMsgItemLayout12";
  public GradientDrawable a;
  public Bundle a;
  public Handler a;
  public View.OnClickListener a;
  public boolean a;
  public boolean b;
  public boolean d;
  private String r;
  
  public StructMsgItemLayout12()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new uwc(this);
  }
  
  public StructMsgItemLayout12(int paramInt)
  {
    super(paramInt);
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new uwc(this);
  }
  
  public StructMsgItemLayout12(Collection paramCollection)
  {
    super(paramCollection);
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new uwc(this);
  }
  
  private FrameLayout a(Context paramContext)
  {
    FrameLayout localFrameLayout = new FrameLayout(paramContext);
    localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, AIOUtils.a(105.0F, paramContext.getResources())));
    localFrameLayout.setId(2131296514);
    if (AppSetting.j) {
      localFrameLayout.setContentDescription(this.r);
    }
    return localFrameLayout;
  }
  
  public static String a(AbsStructMsg paramAbsStructMsg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramAbsStructMsg instanceof AbsShareMsg))
    {
      paramAbsStructMsg = (AbsShareMsg)paramAbsStructMsg;
      if ((paramAbsStructMsg.getItemCount() > 0) && ((paramAbsStructMsg.getItemByIndex(0) instanceof StructMsgItemLayout12)))
      {
        paramAbsStructMsg = (StructMsgItemLayout12)paramAbsStructMsg.getItemByIndex(0);
        boolean bool = paramAbsStructMsg.jdField_a_of_type_AndroidOsBundle.getBoolean("isSend", false);
        localStringBuilder.append("isSend:").append(bool).append(" nick:");
        if (!bool) {
          break label97;
        }
        localStringBuilder.append(paramAbsStructMsg.jdField_a_of_type_AndroidOsBundle.getString("rNick"));
      }
    }
    for (;;)
    {
      return localStringBuilder.toString();
      label97:
      localStringBuilder.append(paramAbsStructMsg.jdField_a_of_type_AndroidOsBundle.getString("sNick"));
    }
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForStructing))
    {
      paramChatMessage = (MessageForStructing)paramChatMessage;
      if ((paramChatMessage.structingMsg != null) && ((paramChatMessage.structingMsg instanceof AbsShareMsg)) && (paramChatMessage.structingMsg.mMsgServiceID == 52))
      {
        paramChatMessage = (AbsShareMsg)paramChatMessage.structingMsg;
        if ((paramChatMessage.getItemCount() > 0) && ((paramChatMessage.getItemByIndex(0) instanceof StructMsgItemLayout12))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private String b(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      str = null;
    }
    try
    {
      localObject = Base64.decode(paramString, 0);
      str = paramString;
      if (localObject != null)
      {
        str = paramString;
        if (localObject.length > 0) {
          str = new String((byte[])localObject);
        }
      }
      return str;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.i("StructMsgItemLayout12", 2, localIllegalArgumentException.getMessage());
          localObject = str;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.i("StructMsgItemLayout12", 2, localException.getMessage());
          localObject = str;
        }
      }
    }
  }
  
  private void e(View paramView)
  {
    paramView.setOnTouchListener(new uwd(this, paramView));
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: new 213	org/json/JSONObject
    //   3: dup
    //   4: aload_0
    //   5: getfield 216	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:h	Ljava/lang/String;
    //   8: invokespecial 219	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11: astore 21
    //   13: invokestatic 188	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +14 -> 30
    //   19: ldc 27
    //   21: iconst_2
    //   22: aload 21
    //   24: invokevirtual 220	org/json/JSONObject:toString	()Ljava/lang/String;
    //   27: invokestatic 195	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   30: aload 21
    //   32: ldc -34
    //   34: invokevirtual 226	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   37: ifeq +1253 -> 1290
    //   40: aload 21
    //   42: ldc -34
    //   44: invokevirtual 227	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   47: astore_2
    //   48: aload 21
    //   50: ldc -27
    //   52: invokevirtual 226	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   55: ifeq +1241 -> 1296
    //   58: aload 21
    //   60: ldc -27
    //   62: invokevirtual 227	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   65: astore_1
    //   66: aload 21
    //   68: ldc -25
    //   70: invokevirtual 226	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   73: ifeq +1229 -> 1302
    //   76: aload 21
    //   78: ldc -25
    //   80: invokevirtual 227	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   83: astore_3
    //   84: aload 21
    //   86: ldc -23
    //   88: invokevirtual 226	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   91: ifeq +1217 -> 1308
    //   94: aload 21
    //   96: ldc -23
    //   98: invokevirtual 227	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   101: astore 4
    //   103: aload 21
    //   105: ldc -21
    //   107: invokevirtual 226	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   110: ifeq +1205 -> 1315
    //   113: aload 21
    //   115: ldc -21
    //   117: invokevirtual 227	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   120: astore 5
    //   122: aload 21
    //   124: ldc -19
    //   126: invokevirtual 226	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   129: ifeq +1193 -> 1322
    //   132: aload 21
    //   134: ldc -19
    //   136: invokevirtual 227	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   139: astore 6
    //   141: aload 21
    //   143: ldc -17
    //   145: invokevirtual 226	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   148: ifeq +1181 -> 1329
    //   151: aload 21
    //   153: ldc -17
    //   155: invokevirtual 227	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   158: astore 7
    //   160: aload 21
    //   162: ldc -15
    //   164: invokevirtual 226	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   167: ifeq +1169 -> 1336
    //   170: aload 21
    //   172: ldc -15
    //   174: invokevirtual 227	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   177: astore 8
    //   179: aload 21
    //   181: ldc -13
    //   183: invokevirtual 226	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   186: ifeq +1157 -> 1343
    //   189: aload 21
    //   191: ldc -13
    //   193: invokevirtual 227	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   196: astore 9
    //   198: aload 21
    //   200: ldc -11
    //   202: invokevirtual 226	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   205: ifeq +1145 -> 1350
    //   208: aload 21
    //   210: ldc -11
    //   212: invokevirtual 227	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   215: astore 10
    //   217: aload 21
    //   219: ldc -9
    //   221: invokevirtual 226	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   224: ifeq +1133 -> 1357
    //   227: aload 21
    //   229: ldc -9
    //   231: invokevirtual 227	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   234: astore 11
    //   236: aload 21
    //   238: ldc -7
    //   240: invokevirtual 226	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   243: ifeq +1121 -> 1364
    //   246: aload 21
    //   248: ldc -7
    //   250: invokevirtual 227	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   253: astore 12
    //   255: aload 21
    //   257: ldc -5
    //   259: invokevirtual 226	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   262: ifeq +1109 -> 1371
    //   265: aload 21
    //   267: ldc -5
    //   269: invokevirtual 227	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   272: astore 13
    //   274: aload 21
    //   276: ldc -3
    //   278: invokevirtual 226	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   281: ifeq +1097 -> 1378
    //   284: aload 21
    //   286: ldc -3
    //   288: invokevirtual 227	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   291: astore 14
    //   293: aload 21
    //   295: ldc -117
    //   297: invokevirtual 226	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   300: ifeq +1085 -> 1385
    //   303: aload 21
    //   305: ldc -117
    //   307: invokevirtual 227	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   310: astore 16
    //   312: aload 21
    //   314: ldc -107
    //   316: invokevirtual 226	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   319: ifeq +1073 -> 1392
    //   322: aload 21
    //   324: ldc -107
    //   326: invokevirtual 227	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   329: astore 18
    //   331: aload 21
    //   333: ldc -1
    //   335: invokevirtual 226	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   338: ifeq +1061 -> 1399
    //   341: aload 21
    //   343: ldc -1
    //   345: invokevirtual 227	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   348: astore 15
    //   350: aload 21
    //   352: ldc_w 257
    //   355: invokevirtual 226	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   358: ifeq +1048 -> 1406
    //   361: aload 21
    //   363: ldc_w 257
    //   366: invokevirtual 227	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   369: astore 17
    //   371: aload 21
    //   373: ldc_w 259
    //   376: invokevirtual 226	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   379: ifeq +1034 -> 1413
    //   382: aload 21
    //   384: ldc_w 259
    //   387: invokevirtual 227	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   390: astore 19
    //   392: aload 21
    //   394: ldc_w 261
    //   397: invokevirtual 226	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   400: ifeq +1020 -> 1420
    //   403: aload 21
    //   405: ldc_w 261
    //   408: invokevirtual 227	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   411: astore 20
    //   413: aload 21
    //   415: ldc_w 263
    //   418: invokevirtual 226	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   421: ifeq +1006 -> 1427
    //   424: aload 21
    //   426: ldc_w 263
    //   429: invokevirtual 227	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   432: astore 21
    //   434: aload 10
    //   436: invokestatic 171	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   439: ifeq +683 -> 1122
    //   442: iconst_0
    //   443: istore 25
    //   445: invokestatic 268	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   448: invokevirtual 271	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   451: checkcast 273	com/tencent/mobileqq/app/QQAppInterface
    //   454: invokevirtual 276	com/tencent/mobileqq/app/QQAppInterface:f	()Ljava/lang/String;
    //   457: astore 22
    //   459: aload 12
    //   461: aload 22
    //   463: invokevirtual 280	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   466: istore 27
    //   468: aload 11
    //   470: aload 22
    //   472: invokevirtual 280	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   475: istore 28
    //   477: aload_0
    //   478: getfield 50	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   481: ldc 122
    //   483: iload 27
    //   485: invokevirtual 284	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   488: aload_0
    //   489: getfield 50	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   492: ldc_w 286
    //   495: iload 28
    //   497: invokevirtual 284	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   500: aload_0
    //   501: getfield 289	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   504: invokevirtual 295	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   507: astore 22
    //   509: aload 22
    //   511: invokeinterface 300 1 0
    //   516: ifeq +759 -> 1275
    //   519: aload 22
    //   521: invokeinterface 304 1 0
    //   526: checkcast 306	com/tencent/mobileqq/structmsg/AbsStructMsgElement
    //   529: astore 23
    //   531: aload 23
    //   533: instanceof 308
    //   536: ifeq -27 -> 509
    //   539: aload 23
    //   541: checkcast 308	com/tencent/mobileqq/structmsg/view/StructMsgItemCover
    //   544: getfield 310	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:o	Ljava/lang/String;
    //   547: astore 22
    //   549: aload_0
    //   550: aload 16
    //   552: invokespecial 312	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:b	(Ljava/lang/String;)Ljava/lang/String;
    //   555: astore 16
    //   557: aload_0
    //   558: aload 18
    //   560: invokespecial 312	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:b	(Ljava/lang/String;)Ljava/lang/String;
    //   563: astore 24
    //   565: invokestatic 268	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   568: invokevirtual 271	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   571: checkcast 273	com/tencent/mobileqq/app/QQAppInterface
    //   574: astore 18
    //   576: aload 18
    //   578: bipush 50
    //   580: invokevirtual 316	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   583: checkcast 318	com/tencent/mobileqq/app/FriendsManager
    //   586: astore 23
    //   588: aload_0
    //   589: getfield 50	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   592: ldc -107
    //   594: aload 24
    //   596: invokevirtual 322	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   599: iload 27
    //   601: ifne +62 -> 663
    //   604: aload 23
    //   606: ifnull +828 -> 1434
    //   609: aload 23
    //   611: aload 12
    //   613: invokevirtual 324	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Z
    //   616: ifeq +818 -> 1434
    //   619: iconst_1
    //   620: istore 26
    //   622: iload 26
    //   624: ifeq +39 -> 663
    //   627: aload 18
    //   629: aload 12
    //   631: invokestatic 330	com/tencent/mobileqq/utils/ContactUtils:k	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   634: astore 24
    //   636: aload_0
    //   637: getfield 50	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   640: ldc -107
    //   642: aload 24
    //   644: invokevirtual 322	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   647: iload 28
    //   649: ifeq +14 -> 663
    //   652: aload_0
    //   653: getfield 50	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   656: ldc_w 332
    //   659: iconst_1
    //   660: invokevirtual 284	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   663: aload_0
    //   664: getfield 50	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   667: ldc -117
    //   669: aload 16
    //   671: invokevirtual 322	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   674: iload 28
    //   676: ifne +62 -> 738
    //   679: aload 23
    //   681: ifnull +759 -> 1440
    //   684: aload 23
    //   686: aload 11
    //   688: invokevirtual 324	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Z
    //   691: ifeq +749 -> 1440
    //   694: iconst_1
    //   695: istore 26
    //   697: iload 26
    //   699: ifeq +39 -> 738
    //   702: aload 18
    //   704: aload 11
    //   706: invokestatic 330	com/tencent/mobileqq/utils/ContactUtils:k	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   709: astore 18
    //   711: aload_0
    //   712: getfield 50	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   715: ldc -117
    //   717: aload 18
    //   719: invokevirtual 322	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   722: iload 27
    //   724: ifeq +14 -> 738
    //   727: aload_0
    //   728: getfield 50	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   731: ldc_w 332
    //   734: iconst_1
    //   735: invokevirtual 284	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   738: aload_0
    //   739: getfield 50	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   742: ldc -9
    //   744: aload 11
    //   746: invokevirtual 322	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   749: aload_0
    //   750: getfield 50	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   753: ldc -7
    //   755: aload 12
    //   757: invokevirtual 322	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   760: aload_0
    //   761: getfield 50	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   764: ldc -5
    //   766: aload 13
    //   768: invokevirtual 322	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   771: aload_0
    //   772: getfield 50	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   775: ldc -3
    //   777: aload 14
    //   779: invokevirtual 322	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   782: aload_0
    //   783: getfield 50	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   786: ldc -25
    //   788: aload_3
    //   789: invokevirtual 322	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   792: aload_0
    //   793: getfield 50	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   796: ldc_w 334
    //   799: aload 5
    //   801: invokevirtual 322	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   804: aload_0
    //   805: getfield 50	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   808: ldc_w 336
    //   811: aload 6
    //   813: invokevirtual 322	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   816: aload_0
    //   817: getfield 50	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   820: ldc -17
    //   822: aload 7
    //   824: invokevirtual 322	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   827: aload_0
    //   828: getfield 50	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   831: ldc -23
    //   833: aload 4
    //   835: invokevirtual 322	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   838: aload_0
    //   839: getfield 50	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   842: ldc -34
    //   844: aload_2
    //   845: invokevirtual 322	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   848: aload_0
    //   849: getfield 50	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   852: ldc -27
    //   854: aload_1
    //   855: invokevirtual 322	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   858: aload_0
    //   859: getfield 50	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   862: ldc -11
    //   864: aload 10
    //   866: invokevirtual 322	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   869: aload_0
    //   870: getfield 50	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   873: ldc_w 338
    //   876: iload 25
    //   878: invokevirtual 342	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   881: aload_0
    //   882: getfield 50	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   885: ldc -15
    //   887: aload 8
    //   889: invokevirtual 322	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   892: aload_0
    //   893: getfield 50	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   896: ldc -13
    //   898: aload 9
    //   900: invokevirtual 322	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   903: aload_0
    //   904: getfield 50	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   907: ldc -1
    //   909: aload 15
    //   911: invokevirtual 322	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   914: aload_0
    //   915: getfield 50	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   918: ldc_w 257
    //   921: aload 17
    //   923: invokevirtual 322	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   926: aload_0
    //   927: getfield 50	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   930: ldc_w 259
    //   933: aload 19
    //   935: invokevirtual 322	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   938: aload 22
    //   940: invokestatic 171	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   943: ifne +15 -> 958
    //   946: aload_0
    //   947: getfield 50	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   950: ldc_w 344
    //   953: aload 22
    //   955: invokevirtual 322	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   958: aload_0
    //   959: getfield 50	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   962: ldc_w 261
    //   965: aload 20
    //   967: invokevirtual 322	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   970: aload 21
    //   972: invokestatic 171	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   975: ifne +15 -> 990
    //   978: aload_0
    //   979: getfield 50	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   982: ldc_w 346
    //   985: aload 21
    //   987: invokevirtual 322	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   990: getstatic 100	com/tencent/common/config/AppSetting:j	Z
    //   993: ifeq +217 -> 1210
    //   996: aload_0
    //   997: getfield 102	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:r	Ljava/lang/String;
    //   1000: ifnonnull +210 -> 1210
    //   1003: new 109	java/lang/StringBuilder
    //   1006: dup
    //   1007: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   1010: astore 4
    //   1012: iload 27
    //   1014: ifeq +432 -> 1446
    //   1017: ldc_w 348
    //   1020: astore_2
    //   1021: aload 4
    //   1023: aload_2
    //   1024: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1027: pop
    //   1028: iload 27
    //   1030: ifeq +422 -> 1452
    //   1033: ldc_w 350
    //   1036: astore_2
    //   1037: aload 4
    //   1039: aload_2
    //   1040: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1043: pop
    //   1044: aload 4
    //   1046: aload_1
    //   1047: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: bipush 44
    //   1052: invokevirtual 353	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1055: pop
    //   1056: aconst_null
    //   1057: astore_1
    //   1058: aconst_null
    //   1059: astore_2
    //   1060: aload_0
    //   1061: getfield 289	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1064: invokevirtual 295	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1067: astore 5
    //   1069: aload 5
    //   1071: invokeinterface 300 1 0
    //   1076: ifeq +85 -> 1161
    //   1079: aload 5
    //   1081: invokeinterface 304 1 0
    //   1086: checkcast 306	com/tencent/mobileqq/structmsg/AbsStructMsgElement
    //   1089: astore_3
    //   1090: aload_3
    //   1091: getfield 355	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1094: astore 6
    //   1096: ldc_w 357
    //   1099: aload 6
    //   1101: invokevirtual 280	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1104: ifeq +31 -> 1135
    //   1107: aload_3
    //   1108: checkcast 359	com/tencent/mobileqq/structmsg/view/StructMsgItemRemark
    //   1111: invokevirtual 361	com/tencent/mobileqq/structmsg/view/StructMsgItemRemark:b	()Ljava/lang/String;
    //   1114: astore_3
    //   1115: aload_1
    //   1116: astore_2
    //   1117: aload_3
    //   1118: astore_1
    //   1119: goto +162 -> 1281
    //   1122: aload 10
    //   1124: invokestatic 367	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1127: invokevirtual 370	java/lang/Integer:intValue	()I
    //   1130: istore 25
    //   1132: goto -687 -> 445
    //   1135: ldc_w 372
    //   1138: aload 6
    //   1140: invokevirtual 280	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1143: ifeq +123 -> 1266
    //   1146: aload_3
    //   1147: checkcast 374	com/tencent/mobileqq/structmsg/view/StructMsgItemSummary
    //   1150: invokevirtual 375	com/tencent/mobileqq/structmsg/view/StructMsgItemSummary:b	()Ljava/lang/String;
    //   1153: astore_3
    //   1154: aload_2
    //   1155: astore_1
    //   1156: aload_3
    //   1157: astore_2
    //   1158: goto +123 -> 1281
    //   1161: aload 4
    //   1163: aload_1
    //   1164: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1167: ldc_w 377
    //   1170: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1173: pop
    //   1174: iload 27
    //   1176: ifeq +40 -> 1216
    //   1179: aload 4
    //   1181: ldc_w 379
    //   1184: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1187: aload_2
    //   1188: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1191: pop
    //   1192: aload 4
    //   1194: ldc_w 381
    //   1197: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1200: pop
    //   1201: aload_0
    //   1202: aload 4
    //   1204: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1207: putfield 102	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:r	Ljava/lang/String;
    //   1210: aload_0
    //   1211: iconst_1
    //   1212: putfield 383	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout12:jdField_a_of_type_Boolean	Z
    //   1215: return
    //   1216: aload 4
    //   1218: aload_2
    //   1219: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1222: pop
    //   1223: goto -31 -> 1192
    //   1226: astore_1
    //   1227: invokestatic 188	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1230: ifeq -20 -> 1210
    //   1233: ldc 27
    //   1235: iconst_2
    //   1236: aload_1
    //   1237: invokevirtual 384	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1240: invokestatic 195	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1243: goto -33 -> 1210
    //   1246: astore_1
    //   1247: invokestatic 188	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1250: ifeq -40 -> 1210
    //   1253: ldc 27
    //   1255: iconst_2
    //   1256: aload_1
    //   1257: invokevirtual 196	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1260: invokestatic 195	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1263: goto -53 -> 1210
    //   1266: aload_1
    //   1267: astore_3
    //   1268: aload_2
    //   1269: astore_1
    //   1270: aload_3
    //   1271: astore_2
    //   1272: goto +9 -> 1281
    //   1275: aconst_null
    //   1276: astore 22
    //   1278: goto -729 -> 549
    //   1281: aload_2
    //   1282: astore_3
    //   1283: aload_1
    //   1284: astore_2
    //   1285: aload_3
    //   1286: astore_1
    //   1287: goto -218 -> 1069
    //   1290: ldc 23
    //   1292: astore_2
    //   1293: goto -1245 -> 48
    //   1296: ldc 23
    //   1298: astore_1
    //   1299: goto -1233 -> 66
    //   1302: ldc 23
    //   1304: astore_3
    //   1305: goto -1221 -> 84
    //   1308: ldc 23
    //   1310: astore 4
    //   1312: goto -1209 -> 103
    //   1315: ldc 23
    //   1317: astore 5
    //   1319: goto -1197 -> 122
    //   1322: ldc 23
    //   1324: astore 6
    //   1326: goto -1185 -> 141
    //   1329: ldc 23
    //   1331: astore 7
    //   1333: goto -1173 -> 160
    //   1336: ldc 23
    //   1338: astore 8
    //   1340: goto -1161 -> 179
    //   1343: ldc 23
    //   1345: astore 9
    //   1347: goto -1149 -> 198
    //   1350: ldc 23
    //   1352: astore 10
    //   1354: goto -1137 -> 217
    //   1357: ldc 23
    //   1359: astore 11
    //   1361: goto -1125 -> 236
    //   1364: ldc 23
    //   1366: astore 12
    //   1368: goto -1113 -> 255
    //   1371: ldc 23
    //   1373: astore 13
    //   1375: goto -1101 -> 274
    //   1378: ldc 23
    //   1380: astore 14
    //   1382: goto -1089 -> 293
    //   1385: ldc 23
    //   1387: astore 16
    //   1389: goto -1077 -> 312
    //   1392: ldc 23
    //   1394: astore 18
    //   1396: goto -1065 -> 331
    //   1399: ldc 23
    //   1401: astore 15
    //   1403: goto -1053 -> 350
    //   1406: ldc 23
    //   1408: astore 17
    //   1410: goto -1039 -> 371
    //   1413: ldc 23
    //   1415: astore 19
    //   1417: goto -1025 -> 392
    //   1420: ldc 23
    //   1422: astore 20
    //   1424: goto -1011 -> 413
    //   1427: ldc 23
    //   1429: astore 21
    //   1431: goto -997 -> 434
    //   1434: iconst_0
    //   1435: istore 26
    //   1437: goto -815 -> 622
    //   1440: iconst_0
    //   1441: istore 26
    //   1443: goto -746 -> 697
    //   1446: aload 16
    //   1448: astore_2
    //   1449: goto -428 -> 1021
    //   1452: ldc_w 386
    //   1455: astore_2
    //   1456: goto -419 -> 1037
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1459	0	this	StructMsgItemLayout12
    //   65	1099	1	localObject1	Object
    //   1226	11	1	localJSONException	org.json.JSONException
    //   1246	21	1	localException	Exception
    //   1269	30	1	localObject2	Object
    //   47	1409	2	localObject3	Object
    //   83	1222	3	localObject4	Object
    //   101	1210	4	localObject5	Object
    //   120	1198	5	localObject6	Object
    //   139	1186	6	str1	String
    //   158	1174	7	str2	String
    //   177	1162	8	str3	String
    //   196	1150	9	str4	String
    //   215	1138	10	str5	String
    //   234	1126	11	str6	String
    //   253	1114	12	str7	String
    //   272	1102	13	str8	String
    //   291	1090	14	str9	String
    //   348	1054	15	str10	String
    //   310	1137	16	str11	String
    //   369	1040	17	str12	String
    //   329	1066	18	localObject7	Object
    //   390	1026	19	str13	String
    //   411	1012	20	str14	String
    //   11	1419	21	localObject8	Object
    //   457	820	22	localObject9	Object
    //   529	156	23	localObject10	Object
    //   563	80	24	str15	String
    //   443	688	25	i	int
    //   620	822	26	j	int
    //   466	709	27	bool1	boolean
    //   475	200	28	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   0	30	1226	org/json/JSONException
    //   30	48	1226	org/json/JSONException
    //   48	66	1226	org/json/JSONException
    //   66	84	1226	org/json/JSONException
    //   84	103	1226	org/json/JSONException
    //   103	122	1226	org/json/JSONException
    //   122	141	1226	org/json/JSONException
    //   141	160	1226	org/json/JSONException
    //   160	179	1226	org/json/JSONException
    //   179	198	1226	org/json/JSONException
    //   198	217	1226	org/json/JSONException
    //   217	236	1226	org/json/JSONException
    //   236	255	1226	org/json/JSONException
    //   255	274	1226	org/json/JSONException
    //   274	293	1226	org/json/JSONException
    //   293	312	1226	org/json/JSONException
    //   312	331	1226	org/json/JSONException
    //   331	350	1226	org/json/JSONException
    //   350	371	1226	org/json/JSONException
    //   371	392	1226	org/json/JSONException
    //   392	413	1226	org/json/JSONException
    //   413	434	1226	org/json/JSONException
    //   434	442	1226	org/json/JSONException
    //   445	509	1226	org/json/JSONException
    //   509	549	1226	org/json/JSONException
    //   549	599	1226	org/json/JSONException
    //   609	619	1226	org/json/JSONException
    //   627	647	1226	org/json/JSONException
    //   652	663	1226	org/json/JSONException
    //   663	674	1226	org/json/JSONException
    //   684	694	1226	org/json/JSONException
    //   702	722	1226	org/json/JSONException
    //   727	738	1226	org/json/JSONException
    //   738	958	1226	org/json/JSONException
    //   958	990	1226	org/json/JSONException
    //   990	1012	1226	org/json/JSONException
    //   1021	1028	1226	org/json/JSONException
    //   1037	1056	1226	org/json/JSONException
    //   1060	1069	1226	org/json/JSONException
    //   1069	1115	1226	org/json/JSONException
    //   1122	1132	1226	org/json/JSONException
    //   1135	1154	1226	org/json/JSONException
    //   1161	1174	1226	org/json/JSONException
    //   1179	1192	1226	org/json/JSONException
    //   1192	1210	1226	org/json/JSONException
    //   1216	1223	1226	org/json/JSONException
    //   0	30	1246	java/lang/Exception
    //   30	48	1246	java/lang/Exception
    //   48	66	1246	java/lang/Exception
    //   66	84	1246	java/lang/Exception
    //   84	103	1246	java/lang/Exception
    //   103	122	1246	java/lang/Exception
    //   122	141	1246	java/lang/Exception
    //   141	160	1246	java/lang/Exception
    //   160	179	1246	java/lang/Exception
    //   179	198	1246	java/lang/Exception
    //   198	217	1246	java/lang/Exception
    //   217	236	1246	java/lang/Exception
    //   236	255	1246	java/lang/Exception
    //   255	274	1246	java/lang/Exception
    //   274	293	1246	java/lang/Exception
    //   293	312	1246	java/lang/Exception
    //   312	331	1246	java/lang/Exception
    //   331	350	1246	java/lang/Exception
    //   350	371	1246	java/lang/Exception
    //   371	392	1246	java/lang/Exception
    //   392	413	1246	java/lang/Exception
    //   413	434	1246	java/lang/Exception
    //   434	442	1246	java/lang/Exception
    //   445	509	1246	java/lang/Exception
    //   509	549	1246	java/lang/Exception
    //   549	599	1246	java/lang/Exception
    //   609	619	1246	java/lang/Exception
    //   627	647	1246	java/lang/Exception
    //   652	663	1246	java/lang/Exception
    //   663	674	1246	java/lang/Exception
    //   684	694	1246	java/lang/Exception
    //   702	722	1246	java/lang/Exception
    //   727	738	1246	java/lang/Exception
    //   738	958	1246	java/lang/Exception
    //   958	990	1246	java/lang/Exception
    //   990	1012	1246	java/lang/Exception
    //   1021	1028	1246	java/lang/Exception
    //   1037	1056	1246	java/lang/Exception
    //   1060	1069	1246	java/lang/Exception
    //   1069	1115	1246	java/lang/Exception
    //   1122	1132	1246	java/lang/Exception
    //   1135	1154	1246	java/lang/Exception
    //   1161	1174	1246	java/lang/Exception
    //   1179	1192	1246	java/lang/Exception
    //   1192	1210	1246	java/lang/Exception
    //   1216	1223	1246	java/lang/Exception
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    if (QLog.isColorLevel()) {
      QLog.i("StructMsgItemLayout12", 2, "readExternal inited:" + this.jdField_a_of_type_Boolean + " " + hashCode());
    }
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    boolean bool = super.a(paramStructMsgNode);
    if (QLog.isColorLevel()) {
      QLog.i("StructMsgItemLayout12", 2, "fromXml inited:" + this.jdField_a_of_type_Boolean + " " + hashCode());
    }
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
    return bool;
  }
  
  protected int b()
  {
    return 12;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StructMsgItemLayout12", 2, "getView inited:" + this.jdField_a_of_type_Boolean + " " + hashCode());
    }
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
    boolean bool1 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isSend", false);
    boolean bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isReceive", false);
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("groupCode");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("rNick");
    Object localObject1;
    Resources localResources;
    if (!TextUtils.isEmpty(str1)) {
      if (bool1)
      {
        localObject1 = "0X800638D";
        NearbyFlowerManager.a(((BaseActivity)paramContext).app, (String)localObject1);
        localResources = paramContext.getResources();
        if ((paramView == null) || (!(paramView instanceof FrameLayout)) || (((FrameLayout)paramView).getChildCount() != 2) || (!(((FrameLayout)paramView).getTag() instanceof StructMsgItemLayout12.ViewHolder))) {
          break label524;
        }
        localObject1 = (FrameLayout)paramView;
        paramView = (StructMsgItemLayout12.ViewHolder)((FrameLayout)localObject1).getTag();
        if (paramView.c != null) {
          paramView.c.setVisibility(8);
        }
        if (paramView.d != null) {
          paramView.d.setVisibility(8);
        }
        if (paramView.jdField_b_of_type_AndroidViewView != null) {
          paramView.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        if (paramView.e == null) {
          break label1518;
        }
        paramView.e.setVisibility(8);
      }
    }
    label280:
    label289:
    label524:
    label839:
    label923:
    label1027:
    label1138:
    label1197:
    label1239:
    label1245:
    label1287:
    label1518:
    for (;;)
    {
      Object localObject2;
      if (bool1)
      {
        paramView.jdField_b_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, AIOUtils.a(15.0F, localResources), 0);
        localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (AbsStructMsgElement)((Iterator)localObject2).next();
          ((AbsStructMsgElement)localObject3).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
          Object localObject4 = ((AbsStructMsgElement)localObject3).jdField_a_of_type_JavaLangString;
          Object localObject5;
          int i;
          if ("title".equals(localObject4))
          {
            if ((localObject3 instanceof StructMsgItemTitle))
            {
              ((StructMsgItemTitle)localObject3).a(a(), 0);
              ((StructMsgItemTitle)localObject3).a(true);
              ((StructMsgItemTitle)localObject3).b(true);
            }
            localObject4 = ((AbsStructMsgElement)localObject3).a(paramContext, paramView.c, paramBundle);
            localObject5 = (TextView)((View)localObject4).findViewById(2131296360);
            if (paramView.c == null)
            {
              paramView.c = ((View)localObject4);
              paramView.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject4, 0);
            }
            for (;;)
            {
              if (!QLog.isColorLevel()) {
                break label839;
              }
              QLog.i("StructMsgItemLayout12", 2, "getview title:" + ((AbsStructMsgTextElement)localObject3).b() + " realText:" + ((TextView)localObject5).getText());
              break label289;
              if (bool2)
              {
                localObject1 = "0X800638E";
                break;
              }
              localObject1 = "0X800638F";
              break;
              if (bool1)
              {
                localObject1 = "0X80060B1";
                break;
              }
              localObject1 = "0X80060B2";
              break;
              paramView = new StructMsgItemLayout12.ViewHolder();
              localObject1 = a(paramContext);
              ((FrameLayout)localObject1).setTag(paramView);
              paramView.jdField_a_of_type_AndroidViewView = new View(paramContext);
              localObject2 = new FrameLayout.LayoutParams(-1, -1);
              ((FrameLayout)localObject1).addView(paramView.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject2);
              ((FrameLayout.LayoutParams)localObject2).setMargins(0, AIOUtils.a(10.0F, localResources), 0, 0);
              if (this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable == null)
              {
                this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = new GradientDrawable();
                this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setShape(0);
                this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(-1);
                this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setCornerRadius(AIOUtils.a(14.0F, localResources));
              }
              paramView.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable);
              paramView.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
              paramView.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
              localObject2 = new FrameLayout.LayoutParams(-2, -1);
              paramView.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(16);
              ((FrameLayout)localObject1).addView(paramView.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject2);
              paramView.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
              paramView.jdField_b_of_type_AndroidWidgetLinearLayout.setOrientation(1);
              localObject2 = new LinearLayout.LayoutParams(AIOUtils.a(135.0F, localResources), -2);
              ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
              ((LinearLayout.LayoutParams)localObject2).topMargin = AIOUtils.a(5.0F, localResources);
              localObject3 = paramView.jdField_b_of_type_AndroidWidgetLinearLayout;
              if (bool1) {}
              for (i = 5;; i = 3)
              {
                ((LinearLayout)localObject3).setGravity(i);
                paramView.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView.jdField_b_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject2);
                break;
              }
              paramView.jdField_b_of_type_AndroidWidgetLinearLayout.setPadding(AIOUtils.a(15.0F, localResources), 0, 0, 0);
              break label280;
              paramView.c.setVisibility(0);
            }
          }
          else
          {
            if ("summary".equals(localObject4))
            {
              if ((localObject3 instanceof StructMsgItemSummary)) {
                ((StructMsgItemSummary)localObject3).b("black");
              }
              localObject4 = ((AbsStructMsgElement)localObject3).a(paramContext, paramView.d, paramBundle);
              localObject5 = (TextView)localObject4;
              if (!TextUtils.isEmpty(str1))
              {
                ((TextView)localObject5).setMaxLines(1);
                if ((localObject3 instanceof StructMsgItemSummary)) {
                  ((StructMsgItemSummary)localObject3).a(str2);
                }
                if (paramView.d != null) {
                  break label1027;
                }
                paramView.d = ((View)localObject4);
                localObject5 = new LinearLayout.LayoutParams(-1, -2);
                ((LinearLayout.LayoutParams)localObject5).setMargins(0, AIOUtils.a(4.0F, localResources), 0, 0);
                paramView.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
              }
              for (;;)
              {
                localObject3 = (StructMsgItemSummary)localObject3;
                if ((this.jdField_a_of_type_AndroidOsBundle.size() <= 0) || (!TextUtils.isEmpty(str1))) {
                  break;
                }
                this.jdField_a_of_type_AndroidOsBundle.putString("cMeanPostfix", ((StructMsgItemSummary)localObject3).b());
                break;
                ((TextView)localObject5).setMaxLines(2);
                break label923;
                paramView.d.setVisibility(0);
              }
            }
            if ("picture".equals(localObject4))
            {
              localObject4 = (StructMsgItemCover)localObject3;
              if (!((StructMsgItemCover)localObject4).o.startsWith("http://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s".substring(0, 4))) {
                ((StructMsgItemCover)localObject4).o = String.format("http://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s", new Object[] { ((StructMsgItemCover)localObject4).o });
              }
              localObject3 = ((AbsStructMsgElement)localObject3).a(paramContext, paramView.jdField_b_of_type_AndroidViewView, paramBundle);
              if (this.jdField_a_of_type_AndroidOsBundle.getInt("count", 0) > 9)
              {
                ((ImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_END);
                if (paramView.jdField_b_of_type_AndroidViewView != null) {
                  break label1245;
                }
                paramView.jdField_b_of_type_AndroidViewView = ((View)localObject3);
                paramView.jdField_b_of_type_AndroidViewView.setFocusable(true);
                localObject4 = new LinearLayout.LayoutParams(AIOUtils.a(115.0F, localResources), -1);
                ((LinearLayout.LayoutParams)localObject4).weight = 1.0F;
                localObject5 = paramView.jdField_a_of_type_AndroidWidgetLinearLayout;
                if (!bool1) {
                  break label1239;
                }
                i = 0;
                ((LinearLayout)localObject5).addView((View)localObject3, i, (ViewGroup.LayoutParams)localObject4);
              }
              for (;;)
              {
                if (!VersionUtils.e()) {
                  break label1287;
                }
                e(paramView.jdField_b_of_type_AndroidViewView);
                break;
                ((ImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_CENTER);
                break label1138;
                i = 1;
                break label1197;
                paramView.jdField_b_of_type_AndroidViewView.setVisibility(0);
                if (bool1 != paramView.jdField_a_of_type_Boolean) {
                  if (bool1) {
                    paramView.jdField_b_of_type_AndroidWidgetLinearLayout.bringToFront();
                  } else {
                    paramView.jdField_b_of_type_AndroidViewView.bringToFront();
                  }
                }
              }
              paramView.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            }
            else if ("remark".equals(localObject4))
            {
              if ((localObject3 instanceof StructMsgItemRemark)) {
                ((StructMsgItemRemark)localObject3).b("#FF9B9B9B");
              }
              localObject4 = ((AbsStructMsgElement)localObject3).a(paramContext, paramView.e, paramBundle);
              if (paramView.e == null)
              {
                paramView.e = ((View)localObject4);
                localObject5 = new LinearLayout.LayoutParams(-1, -2);
                ((LinearLayout.LayoutParams)localObject5).topMargin = AIOUtils.a(7.0F, localResources);
                paramView.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
              }
              for (;;)
              {
                localObject4 = (StructMsgItemRemark)localObject3;
                if (this.jdField_a_of_type_AndroidOsBundle.size() > 0)
                {
                  this.jdField_a_of_type_AndroidOsBundle.putString("remark", ((StructMsgItemRemark)localObject4).b());
                  if (!TextUtils.isEmpty(str1)) {
                    this.jdField_a_of_type_AndroidOsBundle.putString("cMeanPostfix", ((StructMsgItemRemark)localObject4).b());
                  }
                }
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.i("StructMsgItemLayout12", 2, "getview remark:" + ((AbsStructMsgTextElement)localObject3).b());
                break;
                paramView.e.setVisibility(0);
              }
            }
          }
        }
      }
      paramView.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_AndroidOsBundle;
      paramView.jdField_a_of_type_Boolean = bool1;
      return (View)localObject1;
    }
  }
  
  public String b()
  {
    return "Layout12";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      this.d = ((NearbyFlowerManager)((QQAppInterface)BaseApplicationImpl.a().a()).getManager(123)).b;
      if (this.d)
      {
        paramMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 300L);
      }
    }
    do
    {
      do
      {
        do
        {
          return true;
        } while (paramMessage.what != 0);
        paramMessage = (WeakReference)paramMessage.obj;
      } while (paramMessage.get() == null);
      paramMessage = (Context)paramMessage.get();
    } while ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message == null) || (!(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message instanceof MessageForStructing)) || (!(paramMessage instanceof FragmentActivity)));
    Object localObject1 = (FragmentActivity)paramMessage;
    paramMessage = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message;
    Object localObject2 = (NearbyFlowerManager)((FragmentActivity)localObject1).app.getManager(123);
    if (localObject2 != null)
    {
      ((NearbyFlowerManager)localObject2).a(new NearbyFlowerMessage(((FragmentActivity)localObject1).app, paramMessage), true);
      localObject2 = ((FragmentActivity)localObject1).getChatFragment();
      paramMessage = null;
      if (localObject2 != null) {
        paramMessage = ((ChatFragment)localObject2).a();
      }
      if ((paramMessage == null) || (!(paramMessage instanceof NearbyChatFlowerHelper.FlowerPlayable))) {
        break label343;
      }
      paramMessage = ((NearbyChatFlowerHelper.FlowerPlayable)paramMessage).a();
      if (paramMessage == null) {
        break label325;
      }
      paramMessage.a();
      this.d = true;
      paramMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 300L);
      if (QLog.isColorLevel()) {
        QLog.i("StructMsgItemLayout12", 2, "start play");
      }
    }
    boolean bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isSend", false);
    localObject2 = ((FragmentActivity)localObject1).app;
    if (bool)
    {
      paramMessage = "0X80060B3";
      label291:
      if (!bool) {
        break label422;
      }
    }
    label325:
    label343:
    label422:
    for (localObject1 = "0X80060B3";; localObject1 = "0X80060B4")
    {
      ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", paramMessage, (String)localObject1, 0, 0, "", "", "", "");
      return true;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("StructMsgItemLayout12", 2, "helper is null");
      break;
      if (!QLog.isColorLevel()) {
        break;
      }
      localObject2 = new StringBuilder().append("play failed. cp==null:");
      if (paramMessage == null) {}
      for (paramMessage = "true";; paramMessage = "cp is NearbyChtaPie:" + (paramMessage instanceof NearbyChatPie))
      {
        QLog.i("StructMsgItemLayout12", 2, paramMessage);
        break;
      }
      paramMessage = "0X80060B4";
      break label291;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\view\StructMsgItemLayout12.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */