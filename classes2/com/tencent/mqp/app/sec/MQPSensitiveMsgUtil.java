package com.tencent.mqp.app.sec;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.ims.bankcode_info.BankcodeCtrlInfo;
import com.tencent.ims.bankcode_info.BankcodeElem;
import com.tencent.ims.bankcode_info.ElemPos;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.QQText.EmotcationSpan;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import localpb.richMsg.SafeMsg.SafeMoreInfo;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import woz;
import wpb;
import wpc;
import wpd;
import wpe;
import wpf;

public class MQPSensitiveMsgUtil
{
  public static final int a = 1;
  private static BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new wpd();
  private static Bundle jdField_a_of_type_AndroidOsBundle;
  private static MQPSensitiveMsgUtil jdField_a_of_type_ComTencentMqpAppSecMQPSensitiveMsgUtil;
  public static final String a = "Safe_SensMsg";
  public static final int b = 2;
  public static final String b = "sens_msg_need_parse";
  private static int c = 0;
  public static final String c = "sens_msg_need_mask";
  private static final int d = 10;
  public static final String d = "sens_msg_original_text";
  public static final String e = "sens_msg_uniseq";
  public static final String f = "sens_msg_confirmed";
  public static final String g = "sens_msg_ctrl_info";
  public static final String h = "sens_msg_attr";
  public static final String i = "sens_msg_has_not_confirmed_msg";
  public static final String j = "sens_msg_id";
  public static final String k = "sens_msg_status";
  public static final String l = "sens_msg_phoe";
  public static final String m = "sens_msg_fromname";
  public static final String n = "sens_msg_sessiontype";
  public static final String o = "sens_msg_peeruin";
  public static final String p = "sens_msg_nickname";
  public static final String q = "sens_msg_senderuin";
  public static final String r = "sens_msg_istroop";
  public static final String s = "sens_msg_troopuin";
  public static final String t = "sens_msg_default_wording";
  public static final String u = "sens_msg_source_msg_info";
  public static final String v = "sens_msg_source_msg_troop_topic_info";
  public static final String w = "0";
  public static final String x = "1";
  private static final String y = "sp_confirmed_sensmsg";
  private static String z;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_AndroidOsBundle = new Bundle();
    z = "0";
  }
  
  private static int a(String paramString, int paramInt)
  {
    int i3 = 0;
    if (paramInt > 0) {
      i1 = paramInt;
    }
    while (i3 < paramInt) {
      try
      {
        int i4 = paramString.codePointAt(i3);
        int i2;
        if (i4 == 20) {
          i2 = i1 + 1;
        }
        for (;;)
        {
          i3 += 1;
          i1 = i2;
          break;
          i1 = 0;
          break;
          i2 = i1;
          if (EmotcationConstants.a.get(i4, -1) >= 0)
          {
            i2 = i1;
            if (i4 > 65535) {
              i2 = i1 + 1;
            }
          }
        }
        return i1;
      }
      catch (Exception paramString) {}
    }
  }
  
  public static MQPSensitiveMsgUtil a()
  {
    if (jdField_a_of_type_ComTencentMqpAppSecMQPSensitiveMsgUtil == null)
    {
      jdField_a_of_type_ComTencentMqpAppSecMQPSensitiveMsgUtil = new MQPSensitiveMsgUtil();
      a();
    }
    return jdField_a_of_type_ComTencentMqpAppSecMQPSensitiveMsgUtil;
  }
  
  private static Object a(String paramString, int paramInt, long paramLong, boolean paramBoolean, bankcode_info.BankcodeCtrlInfo paramBankcodeCtrlInfo)
  {
    return new wpf(paramString, paramInt, paramLong, paramBankcodeCtrlInfo, paramBoolean);
  }
  
  private static void a()
  {
    Object localObject = new IntentFilter("mqq.intent.action.ACCOUNT_CHANGED");
    BaseApplication.getContext().registerReceiver(jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
    localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject == null) {}
    while (!((AppRuntime)localObject).isLogin()) {
      return;
    }
    c(((AppRuntime)localObject).getAccount());
  }
  
  private static void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2)
  {
    if (paramSpannableStringBuilder == null) {
      return;
    }
    Object[] arrayOfObject = paramSpannableStringBuilder.getSpans(paramInt1, paramInt2, Object.class);
    int i2 = arrayOfObject.length;
    int i1 = 0;
    label21:
    Object localObject;
    int i3;
    int i4;
    int i5;
    if (i1 < i2)
    {
      localObject = arrayOfObject[i1];
      i3 = paramSpannableStringBuilder.getSpanStart(localObject);
      i4 = paramSpannableStringBuilder.getSpanEnd(localObject);
      i5 = paramSpannableStringBuilder.getSpanFlags(localObject);
      if ((i3 >= paramInt1) || (i4 > paramInt2)) {
        break label90;
      }
      paramSpannableStringBuilder.setSpan(localObject, i3, paramInt1, i5);
    }
    for (;;)
    {
      i1 += 1;
      break label21;
      break;
      label90:
      if ((i3 >= paramInt1) && (i4 <= paramInt2) && (!(localObject instanceof QQText.EmotcationSpan)))
      {
        paramSpannableStringBuilder.removeSpan(localObject);
      }
      else if ((i3 > paramInt1) && (i3 < paramInt2) && (i4 > paramInt2))
      {
        paramSpannableStringBuilder.setSpan(localObject, paramInt2, i4, i5);
      }
      else if ((i3 < paramInt1) && (i4 > paramInt2))
      {
        paramSpannableStringBuilder.setSpan(localObject, i3, paramInt1, i5);
        paramSpannableStringBuilder.setSpan(localObject, paramInt2, i4, i5);
      }
    }
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    Object localObject1 = paramMessageRecord.getExtInfoFromExtStr("sens_msg_ctrl_info");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    Object localObject3 = new bankcode_info.BankcodeCtrlInfo();
    for (;;)
    {
      int i1;
      try
      {
        ((bankcode_info.BankcodeCtrlInfo)localObject3).mergeFrom(HexUtil.a((String)localObject1));
        if (!((bankcode_info.BankcodeCtrlInfo)localObject3).bankcode_elems.has()) {
          break label253;
        }
        localObject1 = ((bankcode_info.BankcodeCtrlInfo)localObject3).bankcode_elems.get();
        if (localObject1 == null) {
          break;
        }
        localObject3 = ((List)localObject1).iterator();
        i1 = 0;
        if (((Iterator)localObject3).hasNext())
        {
          bankcode_info.BankcodeElem localBankcodeElem = (bankcode_info.BankcodeElem)((Iterator)localObject3).next();
          if (!localBankcodeElem.bankcode_attr.has()) {
            break label247;
          }
          i2 = localBankcodeElem.bankcode_attr.get();
          if (i2 <= i1) {
            break label240;
          }
          i1 = i2;
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject2 = null;
        continue;
      }
      if (i1 != 20) {
        break;
      }
      localObject3 = ((List)localObject2).iterator();
      label232:
      label234:
      label238:
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          localObject2 = (bankcode_info.BankcodeElem)((Iterator)localObject3).next();
          if (!((bankcode_info.BankcodeElem)localObject2).bankcode_attr.has()) {
            break label234;
          }
        }
        for (i1 = ((bankcode_info.BankcodeElem)localObject2).bankcode_attr.get();; i1 = 0)
        {
          if (i1 != 20) {
            break label238;
          }
          if (((bankcode_info.BankcodeElem)localObject2).clean_bankcode.has()) {}
          for (localObject2 = ((bankcode_info.BankcodeElem)localObject2).clean_bankcode.get();; localObject2 = null)
          {
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break label232;
            }
            a().a((String)localObject2);
            break;
            paramMessageRecord.saveExtInfoToExtStr("sens_msg_confirmed", "1");
            return;
          }
          break;
        }
      }
      label240:
      int i2 = i1;
      continue;
      label247:
      i2 = 0;
      continue;
      label253:
      Object localObject2 = null;
    }
  }
  
  /* Error */
  public static void a(MessageRecord paramMessageRecord, List paramList, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 13
    //   3: iconst_0
    //   4: istore 21
    //   6: aconst_null
    //   7: astore 5
    //   9: new 230	com/tencent/ims/bankcode_info$BankcodeCtrlInfo
    //   12: dup
    //   13: invokespecial 231	com/tencent/ims/bankcode_info$BankcodeCtrlInfo:<init>	()V
    //   16: astore 6
    //   18: aload 6
    //   20: aload_3
    //   21: invokevirtual 240	com/tencent/ims/bankcode_info$BankcodeCtrlInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   24: pop
    //   25: aload 6
    //   27: getfield 304	com/tencent/ims/bankcode_info$BankcodeCtrlInfo:msgtail_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   30: invokevirtual 307	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   33: ifeq +1103 -> 1136
    //   36: aload 6
    //   38: getfield 304	com/tencent/ims/bankcode_info$BankcodeCtrlInfo:msgtail_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   41: invokevirtual 308	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   44: istore 12
    //   46: aload 5
    //   48: astore_3
    //   49: aload 6
    //   51: getfield 244	com/tencent/ims/bankcode_info$BankcodeCtrlInfo:bankcode_elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   54: invokevirtual 249	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   57: ifeq +12 -> 69
    //   60: aload 6
    //   62: getfield 244	com/tencent/ims/bankcode_info$BankcodeCtrlInfo:bankcode_elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   65: invokevirtual 252	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   68: astore_3
    //   69: iload 12
    //   71: istore 15
    //   73: aload_3
    //   74: astore 5
    //   76: aload 6
    //   78: astore_3
    //   79: aload 5
    //   81: ifnonnull +26 -> 107
    //   84: return
    //   85: astore 5
    //   87: aconst_null
    //   88: astore_3
    //   89: iconst_0
    //   90: istore 12
    //   92: aload 5
    //   94: invokevirtual 282	java/lang/Exception:printStackTrace	()V
    //   97: aconst_null
    //   98: astore 5
    //   100: iload 12
    //   102: istore 15
    //   104: goto -25 -> 79
    //   107: aload_0
    //   108: ldc 37
    //   110: invokevirtual 222	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   113: astore 6
    //   115: aload 6
    //   117: invokestatic 228	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   120: ifne +484 -> 604
    //   123: aload 6
    //   125: invokestatic 314	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   128: istore 12
    //   130: iload 21
    //   132: istore 20
    //   134: iload 12
    //   136: bipush 20
    //   138: if_icmpne +26 -> 164
    //   141: aload_0
    //   142: ldc 40
    //   144: invokevirtual 222	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   147: astore 6
    //   149: aload 6
    //   151: invokestatic 228	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   154: ifne +534 -> 688
    //   157: aload 6
    //   159: invokestatic 320	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   162: istore 20
    //   164: iload_2
    //   165: ifne +937 -> 1102
    //   168: iload 15
    //   170: iconst_1
    //   171: if_icmpne +931 -> 1102
    //   174: iload 12
    //   176: bipush 30
    //   178: if_icmpeq +15 -> 193
    //   181: iload 12
    //   183: bipush 20
    //   185: if_icmpne +917 -> 1102
    //   188: iload 20
    //   190: ifeq +912 -> 1102
    //   193: iconst_1
    //   194: istore 20
    //   196: aload_0
    //   197: ldc 21
    //   199: iload 20
    //   201: invokestatic 324	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   204: invokevirtual 299	com/tencent/mobileqq/data/MessageRecord:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: aload_1
    //   208: invokeinterface 258 1 0
    //   213: astore 7
    //   215: iconst_0
    //   216: istore 16
    //   218: iconst_0
    //   219: istore 13
    //   221: aload 7
    //   223: invokeinterface 263 1 0
    //   228: ifeq -144 -> 84
    //   231: aload 7
    //   233: invokeinterface 267 1 0
    //   238: checkcast 219	com/tencent/mobileqq/data/MessageRecord
    //   241: astore 8
    //   243: aload 8
    //   245: instanceof 326
    //   248: ifeq +796 -> 1044
    //   251: iload 20
    //   253: ifeq +710 -> 963
    //   256: aload 5
    //   258: invokeinterface 258 1 0
    //   263: astore 9
    //   265: aload 9
    //   267: invokeinterface 263 1 0
    //   272: ifeq +691 -> 963
    //   275: aload 9
    //   277: invokeinterface 267 1 0
    //   282: checkcast 269	com/tencent/ims/bankcode_info$BankcodeElem
    //   285: astore 10
    //   287: iconst_0
    //   288: istore 14
    //   290: iconst_0
    //   291: istore 12
    //   293: aload 10
    //   295: getfield 330	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_pos	Lcom/tencent/ims/bankcode_info$ElemPos;
    //   298: invokevirtual 333	com/tencent/ims/bankcode_info$ElemPos:has	()Z
    //   301: ifeq +791 -> 1092
    //   304: aload 10
    //   306: getfield 330	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_pos	Lcom/tencent/ims/bankcode_info$ElemPos;
    //   309: invokevirtual 336	com/tencent/ims/bankcode_info$ElemPos:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   312: checkcast 332	com/tencent/ims/bankcode_info$ElemPos
    //   315: astore_1
    //   316: aload_1
    //   317: getfield 339	com/tencent/ims/bankcode_info$ElemPos:start_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   320: invokevirtual 307	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   323: ifeq +12 -> 335
    //   326: aload_1
    //   327: getfield 339	com/tencent/ims/bankcode_info$ElemPos:start_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   330: invokevirtual 308	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   333: istore 12
    //   335: iload 12
    //   337: istore 14
    //   339: aload_1
    //   340: getfield 342	com/tencent/ims/bankcode_info$ElemPos:end_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   343: invokevirtual 307	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   346: ifeq +746 -> 1092
    //   349: aload_1
    //   350: getfield 342	com/tencent/ims/bankcode_info$ElemPos:end_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   353: invokevirtual 308	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   356: istore 17
    //   358: iload 12
    //   360: istore 18
    //   362: iload 17
    //   364: iload 16
    //   366: if_icmplt -101 -> 265
    //   369: iload 18
    //   371: aload 8
    //   373: getfield 345	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   376: invokevirtual 348	java/lang/String:length	()I
    //   379: iload 16
    //   381: iadd
    //   382: if_icmpgt -117 -> 265
    //   385: iconst_0
    //   386: istore 14
    //   388: iconst_0
    //   389: istore 12
    //   391: aload 10
    //   393: getfield 351	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_hidden_pos	Lcom/tencent/ims/bankcode_info$ElemPos;
    //   396: invokevirtual 333	com/tencent/ims/bankcode_info$ElemPos:has	()Z
    //   399: ifeq +687 -> 1086
    //   402: aload 10
    //   404: getfield 351	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_hidden_pos	Lcom/tencent/ims/bankcode_info$ElemPos;
    //   407: invokevirtual 336	com/tencent/ims/bankcode_info$ElemPos:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   410: checkcast 332	com/tencent/ims/bankcode_info$ElemPos
    //   413: astore_1
    //   414: aload_1
    //   415: getfield 339	com/tencent/ims/bankcode_info$ElemPos:start_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   418: invokevirtual 307	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   421: ifeq +12 -> 433
    //   424: aload_1
    //   425: getfield 339	com/tencent/ims/bankcode_info$ElemPos:start_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   428: invokevirtual 308	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   431: istore 12
    //   433: iload 12
    //   435: istore 14
    //   437: aload_1
    //   438: getfield 342	com/tencent/ims/bankcode_info$ElemPos:end_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   441: invokevirtual 307	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   444: ifeq +642 -> 1086
    //   447: aload_1
    //   448: getfield 342	com/tencent/ims/bankcode_info$ElemPos:end_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   451: invokevirtual 308	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   454: istore 19
    //   456: iload 12
    //   458: istore 14
    //   460: iload 19
    //   462: istore 12
    //   464: aload 8
    //   466: getfield 345	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   469: iload 18
    //   471: iload 13
    //   473: iadd
    //   474: iload 16
    //   476: isub
    //   477: invokestatic 353	com/tencent/mqp/app/sec/MQPSensitiveMsgUtil:a	(Ljava/lang/String;I)I
    //   480: istore 18
    //   482: aload 8
    //   484: getfield 345	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   487: iload 17
    //   489: iload 13
    //   491: iadd
    //   492: iload 16
    //   494: isub
    //   495: invokestatic 353	com/tencent/mqp/app/sec/MQPSensitiveMsgUtil:a	(Ljava/lang/String;I)I
    //   498: istore 19
    //   500: iload 14
    //   502: iload 18
    //   504: iadd
    //   505: istore 14
    //   507: iload 12
    //   509: iload 18
    //   511: iadd
    //   512: istore 17
    //   514: aload 8
    //   516: getfield 345	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   519: iload 18
    //   521: iload 19
    //   523: iconst_1
    //   524: iadd
    //   525: invokevirtual 357	java/lang/String:substring	(II)Ljava/lang/String;
    //   528: astore 11
    //   530: ldc_w 359
    //   533: astore_1
    //   534: iconst_0
    //   535: istore 12
    //   537: iload 12
    //   539: aload 11
    //   541: invokevirtual 348	java/lang/String:length	()I
    //   544: if_icmpge +290 -> 834
    //   547: aload 11
    //   549: iload 12
    //   551: invokevirtual 363	java/lang/String:charAt	(I)C
    //   554: istore 4
    //   556: iload 15
    //   558: tableswitch	default:+18->576, 1:+241->799
    //   576: aload_1
    //   577: astore 6
    //   579: iload 12
    //   581: iconst_1
    //   582: iadd
    //   583: istore 12
    //   585: aload 6
    //   587: astore_1
    //   588: goto -51 -> 537
    //   591: astore 6
    //   593: aload 6
    //   595: invokevirtual 282	java/lang/Exception:printStackTrace	()V
    //   598: iconst_0
    //   599: istore 12
    //   601: goto -471 -> 130
    //   604: aload 5
    //   606: invokeinterface 258 1 0
    //   611: astore 6
    //   613: iload 13
    //   615: istore 12
    //   617: aload 6
    //   619: invokeinterface 263 1 0
    //   624: ifeq +509 -> 1133
    //   627: aload 6
    //   629: invokeinterface 267 1 0
    //   634: checkcast 269	com/tencent/ims/bankcode_info$BankcodeElem
    //   637: astore 7
    //   639: aload 7
    //   641: getfield 273	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_attr	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   644: invokevirtual 276	com/tencent/mobileqq/pb/PBEnumField:has	()Z
    //   647: ifeq +480 -> 1127
    //   650: aload 7
    //   652: getfield 273	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_attr	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   655: invokevirtual 279	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   658: istore 13
    //   660: iload 13
    //   662: iload 12
    //   664: if_icmple +456 -> 1120
    //   667: iload 13
    //   669: istore 12
    //   671: goto -54 -> 617
    //   674: astore 6
    //   676: aload 6
    //   678: invokevirtual 282	java/lang/Exception:printStackTrace	()V
    //   681: iload 21
    //   683: istore 20
    //   685: goto -521 -> 164
    //   688: aload 5
    //   690: invokeinterface 258 1 0
    //   695: astore 7
    //   697: iconst_0
    //   698: istore 20
    //   700: aload 7
    //   702: invokeinterface 263 1 0
    //   707: ifeq +410 -> 1117
    //   710: aload 7
    //   712: invokeinterface 267 1 0
    //   717: checkcast 269	com/tencent/ims/bankcode_info$BankcodeElem
    //   720: astore 6
    //   722: iconst_0
    //   723: istore 13
    //   725: aload 6
    //   727: getfield 273	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_attr	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   730: invokevirtual 276	com/tencent/mobileqq/pb/PBEnumField:has	()Z
    //   733: ifeq +13 -> 746
    //   736: aload 6
    //   738: getfield 273	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_attr	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   741: invokevirtual 279	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   744: istore 13
    //   746: iload 13
    //   748: bipush 20
    //   750: if_icmpne -50 -> 700
    //   753: aload 6
    //   755: getfield 286	com/tencent/ims/bankcode_info$BankcodeElem:clean_bankcode	Lcom/tencent/mobileqq/pb/PBStringField;
    //   758: invokevirtual 289	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   761: ifeq +350 -> 1111
    //   764: aload 6
    //   766: getfield 286	com/tencent/ims/bankcode_info$BankcodeElem:clean_bankcode	Lcom/tencent/mobileqq/pb/PBStringField;
    //   769: invokevirtual 291	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   772: astore 6
    //   774: aload 6
    //   776: invokestatic 228	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   779: ifne +329 -> 1108
    //   782: invokestatic 293	com/tencent/mqp/app/sec/MQPSensitiveMsgUtil:a	()Lcom/tencent/mqp/app/sec/MQPSensitiveMsgUtil;
    //   785: aload 6
    //   787: invokevirtual 365	com/tencent/mqp/app/sec/MQPSensitiveMsgUtil:a	(Ljava/lang/String;)Z
    //   790: ifne +318 -> 1108
    //   793: iconst_1
    //   794: istore 20
    //   796: goto -96 -> 700
    //   799: aload_1
    //   800: astore 6
    //   802: iload 4
    //   804: invokestatic 371	java/lang/Character:isDigit	(C)Z
    //   807: ifeq -228 -> 579
    //   810: new 373	java/lang/StringBuilder
    //   813: dup
    //   814: invokespecial 374	java/lang/StringBuilder:<init>	()V
    //   817: aload_1
    //   818: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: iload 4
    //   823: invokevirtual 381	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   826: invokevirtual 383	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   829: astore 6
    //   831: goto -252 -> 579
    //   834: aload_1
    //   835: invokestatic 228	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   838: ifne -573 -> 265
    //   841: aload 10
    //   843: getfield 286	com/tencent/ims/bankcode_info$BankcodeElem:clean_bankcode	Lcom/tencent/mobileqq/pb/PBStringField;
    //   846: invokevirtual 289	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   849: ifeq +231 -> 1080
    //   852: aload 10
    //   854: getfield 286	com/tencent/ims/bankcode_info$BankcodeElem:clean_bankcode	Lcom/tencent/mobileqq/pb/PBStringField;
    //   857: invokevirtual 291	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   860: astore 6
    //   862: aload_1
    //   863: aload 6
    //   865: invokestatic 387	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   868: ifeq -603 -> 265
    //   871: ldc_w 359
    //   874: astore_1
    //   875: iconst_0
    //   876: istore 12
    //   878: iload 12
    //   880: iload 17
    //   882: iconst_1
    //   883: iadd
    //   884: iload 14
    //   886: isub
    //   887: if_icmpge +33 -> 920
    //   890: new 373	java/lang/StringBuilder
    //   893: dup
    //   894: invokespecial 374	java/lang/StringBuilder:<init>	()V
    //   897: aload_1
    //   898: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: ldc_w 389
    //   904: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   907: invokevirtual 383	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   910: astore_1
    //   911: iload 12
    //   913: iconst_1
    //   914: iadd
    //   915: istore 12
    //   917: goto -39 -> 878
    //   920: new 192	android/text/SpannableStringBuilder
    //   923: dup
    //   924: aload 8
    //   926: checkcast 326	com/tencent/mobileqq/data/MessageForText
    //   929: getfield 393	com/tencent/mobileqq/data/MessageForText:sb	Ljava/lang/CharSequence;
    //   932: invokespecial 396	android/text/SpannableStringBuilder:<init>	(Ljava/lang/CharSequence;)V
    //   935: astore 6
    //   937: aload 6
    //   939: iload 14
    //   941: iload 17
    //   943: iconst_1
    //   944: iadd
    //   945: aload_1
    //   946: invokevirtual 400	android/text/SpannableStringBuilder:replace	(IILjava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    //   949: pop
    //   950: aload 8
    //   952: checkcast 326	com/tencent/mobileqq/data/MessageForText
    //   955: aload 6
    //   957: putfield 393	com/tencent/mobileqq/data/MessageForText:sb	Ljava/lang/CharSequence;
    //   960: goto -695 -> 265
    //   963: aload_0
    //   964: getfield 403	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   967: aload_0
    //   968: getfield 406	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   971: aload_0
    //   972: getfield 410	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   975: iload_2
    //   976: aload_3
    //   977: aload 8
    //   979: checkcast 326	com/tencent/mobileqq/data/MessageForText
    //   982: iload 16
    //   984: iload 13
    //   986: isub
    //   987: invokestatic 413	com/tencent/mqp/app/sec/MQPSensitiveMsgUtil:a	(Ljava/lang/String;IJZLcom/tencent/ims/bankcode_info$BankcodeCtrlInfo;Lcom/tencent/mobileqq/data/MessageForText;I)V
    //   990: iload 13
    //   992: aload 8
    //   994: getfield 345	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   997: aload 8
    //   999: getfield 345	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   1002: invokevirtual 348	java/lang/String:length	()I
    //   1005: invokestatic 353	com/tencent/mqp/app/sec/MQPSensitiveMsgUtil:a	(Ljava/lang/String;I)I
    //   1008: aload 8
    //   1010: getfield 345	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   1013: invokevirtual 348	java/lang/String:length	()I
    //   1016: isub
    //   1017: iadd
    //   1018: istore 12
    //   1020: aload 8
    //   1022: getfield 345	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   1025: invokevirtual 348	java/lang/String:length	()I
    //   1028: iload 16
    //   1030: iadd
    //   1031: istore 13
    //   1033: iload 13
    //   1035: istore 16
    //   1037: iload 12
    //   1039: istore 13
    //   1041: goto -820 -> 221
    //   1044: iload 16
    //   1046: iconst_1
    //   1047: iadd
    //   1048: istore 14
    //   1050: iload 13
    //   1052: istore 12
    //   1054: iload 14
    //   1056: istore 13
    //   1058: goto -25 -> 1033
    //   1061: astore 5
    //   1063: iconst_0
    //   1064: istore 12
    //   1066: aload 6
    //   1068: astore_3
    //   1069: goto -977 -> 92
    //   1072: astore 5
    //   1074: aload 6
    //   1076: astore_3
    //   1077: goto -985 -> 92
    //   1080: aconst_null
    //   1081: astore 6
    //   1083: goto -221 -> 862
    //   1086: iconst_0
    //   1087: istore 12
    //   1089: goto -625 -> 464
    //   1092: iconst_0
    //   1093: istore 17
    //   1095: iload 14
    //   1097: istore 18
    //   1099: goto -737 -> 362
    //   1102: iconst_0
    //   1103: istore 20
    //   1105: goto -909 -> 196
    //   1108: goto -312 -> 796
    //   1111: aconst_null
    //   1112: astore 6
    //   1114: goto -340 -> 774
    //   1117: goto -953 -> 164
    //   1120: iload 12
    //   1122: istore 13
    //   1124: goto -457 -> 667
    //   1127: iconst_0
    //   1128: istore 13
    //   1130: goto -470 -> 660
    //   1133: goto -1003 -> 130
    //   1136: iconst_0
    //   1137: istore 12
    //   1139: goto -1093 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1142	0	paramMessageRecord	MessageRecord
    //   0	1142	1	paramList	List
    //   0	1142	2	paramBoolean	boolean
    //   0	1142	3	paramArrayOfByte	byte[]
    //   554	268	4	c1	char
    //   7	73	5	arrayOfByte	byte[]
    //   85	8	5	localException1	Exception
    //   98	591	5	localObject1	Object
    //   1061	1	5	localException2	Exception
    //   1072	1	5	localException3	Exception
    //   16	570	6	localObject2	Object
    //   591	3	6	localException4	Exception
    //   611	17	6	localIterator1	Iterator
    //   674	3	6	localException5	Exception
    //   720	393	6	localObject3	Object
    //   213	498	7	localObject4	Object
    //   241	780	8	localMessageRecord	MessageRecord
    //   263	13	9	localIterator2	Iterator
    //   285	568	10	localBankcodeElem	bankcode_info.BankcodeElem
    //   528	20	11	str	String
    //   44	1094	12	i1	int
    //   1	1128	13	i2	int
    //   288	808	14	i3	int
    //   71	486	15	i4	int
    //   216	832	16	i5	int
    //   356	738	17	i6	int
    //   360	738	18	i7	int
    //   454	71	19	i8	int
    //   132	972	20	bool1	boolean
    //   4	678	21	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   9	18	85	java/lang/Exception
    //   123	130	591	java/lang/Exception
    //   157	164	674	java/lang/Exception
    //   18	46	1061	java/lang/Exception
    //   49	69	1072	java/lang/Exception
  }
  
  public static void a(String paramString1, int paramInt, long paramLong, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (((BaseActivity.sTopActivity instanceof MultiForwardActivity)) || ((BaseActivity.sTopActivity instanceof ChatHistoryForC2C))) {}
    QQMessageFacade localQQMessageFacade;
    Object localObject2;
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
        } while (localObject1 == null);
        localQQMessageFacade = (QQMessageFacade)((AppRuntime)localObject1).getManager(19);
      } while (localQQMessageFacade == null);
      localObject2 = localQQMessageFacade.a(paramString1, paramInt, paramLong);
    } while (localObject2 == null);
    int i2 = 0;
    int i4 = 0;
    int i6 = 0;
    int i5 = 0;
    int i1 = 0;
    Object localObject1 = ((MessageRecord)localObject2).getExtInfoFromExtStr("sens_msg_ctrl_info");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      int i3;
      try
      {
        localObject3 = new bankcode_info.BankcodeCtrlInfo();
        ((bankcode_info.BankcodeCtrlInfo)localObject3).mergeFrom(HexUtil.a((String)localObject1));
        if (!((bankcode_info.BankcodeCtrlInfo)localObject3).msgtail_id.has()) {
          break label496;
        }
        i3 = ((bankcode_info.BankcodeCtrlInfo)localObject3).msgtail_id.get();
        i2 = i3;
        i3 = i5;
      }
      catch (Exception localException1)
      {
        Object localObject3;
        i3 = i6;
        i1 = i2;
      }
      try
      {
        if (!((bankcode_info.BankcodeCtrlInfo)localObject3).bankcode_elems.has()) {
          continue;
        }
        i3 = i5;
        localObject1 = ((bankcode_info.BankcodeCtrlInfo)localObject3).bankcode_elems.get().iterator();
        i4 = i1;
        i3 = i1;
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        i3 = i1;
        localObject3 = (bankcode_info.BankcodeElem)((Iterator)localObject1).next();
        i3 = i1;
        if (!((bankcode_info.BankcodeElem)localObject3).bankcode_attr.has()) {
          break label490;
        }
        i3 = i1;
        i4 = ((bankcode_info.BankcodeElem)localObject3).bankcode_attr.get();
        i3 = i4;
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          MessageForSafeGrayTips localMessageForSafeGrayTips;
          i1 = i2;
        }
        i2 = 0;
        i1 = 0;
        continue;
        i3 = i1;
        continue;
        label490:
        i3 = 0;
        continue;
      }
      if (i3 > i1)
      {
        i1 = i3;
        continue;
        i1 = i2;
        i2 = i4;
        localObject1 = ((MessageRecord)localObject2).senderuin;
        localObject2 = DialogUtil.a(BaseActivity.sTopActivity, 230);
        ((QQCustomDialog)localObject2).setTitle(paramString2);
        ((QQCustomDialog)localObject2).setMessage(paramString3);
        if (!TextUtils.isEmpty(paramString4)) {
          ((QQCustomDialog)localObject2).setPositiveButton(paramString4, new woz((String)localObject1, i1, i2, localQQMessageFacade, paramString1, paramInt, paramLong));
        }
        if (!TextUtils.isEmpty(paramString5)) {
          ((QQCustomDialog)localObject2).setNegativeButton(paramString5, new wpb((String)localObject1, i1, i2));
        }
        ((QQCustomDialog)localObject2).show();
        return;
        localException1.printStackTrace();
        i2 = i3;
        continue;
        if ((localObject2 instanceof MessageForSafeGrayTips))
        {
          localMessageForSafeGrayTips = (MessageForSafeGrayTips)localObject2;
          if ((localMessageForSafeGrayTips.safeInfo != null) && (localMessageForSafeGrayTips.safeInfo.strMsgTxt.has())) {
            try
            {
              i2 = Integer.parseInt(localMessageForSafeGrayTips.safeInfo.strMsgTxt.get());
              i1 = 2;
            }
            catch (Exception localException2)
            {
              localException2.printStackTrace();
            }
          }
          i1 = 2;
          i2 = 0;
          continue;
        }
      }
      label496:
      i2 = 0;
    }
  }
  
  private static void a(String paramString, int paramInt1, long paramLong, boolean paramBoolean, bankcode_info.BankcodeCtrlInfo paramBankcodeCtrlInfo, MessageForText paramMessageForText, int paramInt2)
  {
    if ((paramBankcodeCtrlInfo == null) || (!paramBankcodeCtrlInfo.bankcode_elems.has())) {
      return;
    }
    if (paramBankcodeCtrlInfo.msgtail_id.has()) {}
    for (int i3 = paramBankcodeCtrlInfo.msgtail_id.get();; i3 = 0)
    {
      int i4 = 0;
      label41:
      Object localObject;
      if (i4 < paramBankcodeCtrlInfo.bankcode_elems.size())
      {
        localObject = (bankcode_info.BankcodeElem)paramBankcodeCtrlInfo.bankcode_elems.get(i4);
        if (localObject != null) {
          break label83;
        }
      }
      label83:
      label266:
      label290:
      label306:
      label408:
      label448:
      for (;;)
      {
        i4 += 1;
        break label41;
        break;
        int i5 = 0;
        int i1 = 0;
        int i2 = i5;
        if (((bankcode_info.BankcodeElem)localObject).bankcode_pos.has())
        {
          localObject = (bankcode_info.ElemPos)((bankcode_info.BankcodeElem)localObject).bankcode_pos.get();
          i2 = i5;
          if (localObject != null)
          {
            if (((bankcode_info.ElemPos)localObject).start_offset.has()) {
              i1 = ((bankcode_info.ElemPos)localObject).start_offset.get();
            }
            i2 = i1;
            if (((bankcode_info.ElemPos)localObject).end_offset.has())
            {
              i2 = ((bankcode_info.ElemPos)localObject).end_offset.get();
              i5 = i1;
              i1 = i2;
            }
          }
        }
        for (;;)
        {
          if ((i1 < paramInt2) || (i5 > paramMessageForText.sb.length() + paramInt2)) {
            break label448;
          }
          String str = paramMessageForText.getExtInfoFromExtStr("sens_msg_original_text");
          localObject = str;
          if (TextUtils.isEmpty(str)) {
            localObject = paramMessageForText.sb.toString();
          }
          int i6 = a((String)localObject, i5 - paramInt2);
          int i7 = a((String)localObject, i1 - paramInt2);
          i1 = i6;
          if ((i3 == 1) && (!Character.isDigit(paramMessageForText.sb.charAt(i1))))
          {
            i2 = i1;
            if (i1 < 0) {
              i2 = 0;
            }
            i1 = i7;
            if ((i3 != 1) || (Character.isDigit(paramMessageForText.sb.charAt(i1)))) {
              break label408;
            }
          }
          for (;;)
          {
            localObject = new SpannableStringBuilder(paramMessageForText.sb);
            a((SpannableStringBuilder)localObject, i2, i1);
            ((SpannableStringBuilder)localObject).setSpan(a(paramString, paramInt1, paramLong, paramBoolean, paramBankcodeCtrlInfo), i6, i7 + 1, 33);
            paramMessageForText.sb = ((CharSequence)localObject);
            break;
            i2 = i1 - 1;
            i1 = i2;
            if (i2 >= 0) {
              break label266;
            }
            i1 = i2;
            break label290;
            i5 = i1 + 1;
            i1 = i5;
            if (i5 < paramMessageForText.sb.length()) {
              break label306;
            }
            i1 = i5;
          }
          i1 = 0;
          i5 = i2;
        }
      }
    }
  }
  
  private static void c(String paramString)
  {
    c = 0;
    z = paramString;
    if (!TextUtils.isEmpty(z))
    {
      jdField_a_of_type_AndroidOsBundle.putBundle(z, null);
      ThreadManager.c(new wpe());
    }
  }
  
  public void a(String paramString)
  {
    String str1;
    String str2;
    Bundle localBundle;
    if ((!TextUtils.isEmpty(paramString)) && (!a(paramString)))
    {
      c = (c + 1) % 10;
      str1 = MD5Utils.b(paramString);
      str2 = Integer.toString(c);
      localBundle = jdField_a_of_type_AndroidOsBundle.getBundle(z);
      if (localBundle != null)
      {
        Iterator localIterator = localBundle.keySet().iterator();
        String str3;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          paramString = (String)localIterator.next();
          str3 = localBundle.getString(paramString);
        } while ((TextUtils.isEmpty(str3)) || (!str3.equals(str2)));
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString)) {
        localBundle.remove(paramString);
      }
      localBundle.putString(str1, str2);
      ThreadManager.c(new wpc(this, str2, str1));
      return;
      paramString = null;
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      Bundle localBundle = jdField_a_of_type_AndroidOsBundle.getBundle(z);
      bool1 = bool2;
      if (localBundle != null)
      {
        bool1 = bool2;
        if (localBundle.containsKey(MD5Utils.b(paramString))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mqp\app\sec\MQPSensitiveMsgUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */