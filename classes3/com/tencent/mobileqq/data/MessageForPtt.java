package com.tencent.mobileqq.data;

import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Media;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.util.Utils;
import localpb.richMsg.RichMsg.PttRec;

public class MessageForPtt
  extends MessageForRichText
  implements MediaPlayerManager.Media
{
  public static final int PTT_SIZE_ANIM_START = -2;
  public static final int PTT_SIZE_RECV_ERROR = -4;
  public static final int PTT_SIZE_SATUTS_ERROR = -1;
  public static final int PTT_SIZE_UI_SEND = -3;
  public static final int STT_ABLE = 1;
  public static final int STT_DONE = 2;
  public static final int STT_EMPTY = 0;
  public static final int VIPFLAG_NONE = 0;
  public static final int VIPFLAG_SVIP = 2;
  public static final int VIPFLAG_VIP = 1;
  public static final int VOICE_CHANDE_YES = 1;
  public static final int VOICE_CHANGE_NO = 0;
  public int busiType;
  public boolean c2cViaOffline;
  public String directUrl;
  @notColumn
  public long estimatedSize;
  public boolean expandStt;
  public long extFlag;
  public long fileSize;
  public String fullLocalPath;
  public long groupFileID;
  public String groupFileKeyStr;
  public boolean isReadPtt;
  public int isReport;
  public int itemType;
  public int longPttVipFlag;
  public String md5;
  public long msgRecTime;
  public long msgTime;
  public int msgVia;
  public int sampleRate;
  public String storageSource;
  public int sttAbility;
  public String sttText;
  public int subVersion;
  public String timeStr;
  public String url;
  public String urlAtServer;
  public int voiceChangeFlag;
  public int voiceLength;
  public int voiceType;
  
  public MessageForPtt()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.expandStt = true;
    this.sttAbility = 0;
    this.subVersion = 5;
    this.directUrl = "";
    this.fullLocalPath = "";
    this.msgRecTime = 0L;
    this.msgTime = 0L;
  }
  
  public static String getLocalFilePath(int paramInt, String paramString)
  {
    String str = paramString;
    if (paramInt == 1)
    {
      str = paramString;
      if (paramString.endsWith(".amr"))
      {
        paramString = paramString.substring(0, paramString.length() - ".amr".length());
        str = paramString + ".slk";
      }
    }
    return str;
  }
  
  public static String getMsgFilePath(int paramInt, String paramString)
  {
    String str = paramString;
    if (paramInt == 1)
    {
      str = paramString;
      if (paramString.endsWith(".slk"))
      {
        paramString = paramString.substring(0, paramString.length() - ".slk".length());
        str = paramString + ".amr";
      }
    }
    return str;
  }
  
  /* Error */
  public void doParse()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 7
    //   3: iconst_0
    //   4: istore 4
    //   6: new 124	localpb/richMsg/RichMsg$PttRec
    //   9: dup
    //   10: invokespecial 125	localpb/richMsg/RichMsg$PttRec:<init>	()V
    //   13: astore_1
    //   14: aload_1
    //   15: aload_0
    //   16: getfield 129	com/tencent/mobileqq/data/MessageForPtt:msgData	[B
    //   19: invokevirtual 133	localpb/richMsg/RichMsg$PttRec:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   22: checkcast 124	localpb/richMsg/RichMsg$PttRec
    //   25: astore_2
    //   26: aload_2
    //   27: astore_1
    //   28: iconst_1
    //   29: istore_3
    //   30: iload_3
    //   31: ifeq +419 -> 450
    //   34: aload_0
    //   35: aload_1
    //   36: getfield 137	localpb/richMsg/RichMsg$PttRec:localPath	Lcom/tencent/mobileqq/pb/PBStringField;
    //   39: invokevirtual 142	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   42: putfield 144	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   45: aload_0
    //   46: aload_1
    //   47: getfield 148	localpb/richMsg/RichMsg$PttRec:size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   50: invokevirtual 153	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   53: putfield 155	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   56: aload_0
    //   57: aload_1
    //   58: getfield 159	localpb/richMsg/RichMsg$PttRec:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   61: invokevirtual 163	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   64: putfield 165	com/tencent/mobileqq/data/MessageForPtt:itemType	I
    //   67: aload_0
    //   68: aload_1
    //   69: getfield 169	localpb/richMsg/RichMsg$PttRec:isRead	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   72: invokevirtual 174	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   75: putfield 176	com/tencent/mobileqq/data/MessageForPtt:isReadPtt	Z
    //   78: aload_0
    //   79: aload_1
    //   80: getfield 179	localpb/richMsg/RichMsg$PttRec:uuid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   83: invokevirtual 142	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   86: putfield 181	com/tencent/mobileqq/data/MessageForPtt:urlAtServer	Ljava/lang/String;
    //   89: aload_0
    //   90: aload_1
    //   91: getfield 185	localpb/richMsg/RichMsg$PttRec:pttFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   94: invokevirtual 188	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   97: putfield 72	com/tencent/mobileqq/data/MessageForPtt:sttAbility	I
    //   100: aload_0
    //   101: aload_1
    //   102: getfield 190	localpb/richMsg/RichMsg$PttRec:md5	Lcom/tencent/mobileqq/pb/PBStringField;
    //   105: invokevirtual 142	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   108: putfield 192	com/tencent/mobileqq/data/MessageForPtt:md5	Ljava/lang/String;
    //   111: aload_0
    //   112: aload_1
    //   113: getfield 195	localpb/richMsg/RichMsg$PttRec:serverStorageSource	Lcom/tencent/mobileqq/pb/PBStringField;
    //   116: invokevirtual 142	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   119: putfield 197	com/tencent/mobileqq/data/MessageForPtt:storageSource	Ljava/lang/String;
    //   122: aload_0
    //   123: aload_1
    //   124: getfield 200	localpb/richMsg/RichMsg$PttRec:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   127: invokevirtual 188	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   130: putfield 74	com/tencent/mobileqq/data/MessageForPtt:subVersion	I
    //   133: aload_0
    //   134: aload_1
    //   135: getfield 202	localpb/richMsg/RichMsg$PttRec:isReport	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   138: invokevirtual 188	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   141: putfield 204	com/tencent/mobileqq/data/MessageForPtt:isReport	I
    //   144: aload_0
    //   145: aload_1
    //   146: getfield 206	localpb/richMsg/RichMsg$PttRec:groupFileID	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   149: invokevirtual 153	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   152: putfield 208	com/tencent/mobileqq/data/MessageForPtt:groupFileID	J
    //   155: aload_0
    //   156: aload_1
    //   157: getfield 210	localpb/richMsg/RichMsg$PttRec:sttText	Lcom/tencent/mobileqq/pb/PBStringField;
    //   160: invokevirtual 142	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   163: putfield 212	com/tencent/mobileqq/data/MessageForPtt:sttText	Ljava/lang/String;
    //   166: aload_0
    //   167: aload_1
    //   168: getfield 214	localpb/richMsg/RichMsg$PttRec:longPttVipFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   171: invokevirtual 188	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   174: putfield 216	com/tencent/mobileqq/data/MessageForPtt:longPttVipFlag	I
    //   177: aload_1
    //   178: getfield 218	localpb/richMsg/RichMsg$PttRec:expandStt	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   181: invokevirtual 221	com/tencent/mobileqq/pb/PBBoolField:has	()Z
    //   184: ifeq +12 -> 196
    //   187: aload_1
    //   188: getfield 218	localpb/richMsg/RichMsg$PttRec:expandStt	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   191: invokevirtual 174	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   194: istore 7
    //   196: aload_0
    //   197: iload 7
    //   199: putfield 70	com/tencent/mobileqq/data/MessageForPtt:expandStt	Z
    //   202: aload_1
    //   203: getfield 224	localpb/richMsg/RichMsg$PttRec:group_file_key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   206: invokevirtual 225	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   209: ifeq +14 -> 223
    //   212: aload_0
    //   213: aload_1
    //   214: getfield 224	localpb/richMsg/RichMsg$PttRec:group_file_key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   217: invokevirtual 142	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   220: putfield 227	com/tencent/mobileqq/data/MessageForPtt:groupFileKeyStr	Ljava/lang/String;
    //   223: aload_1
    //   224: getfield 229	localpb/richMsg/RichMsg$PttRec:msgTime	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   227: invokevirtual 230	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   230: ifeq +653 -> 883
    //   233: aload_1
    //   234: getfield 229	localpb/richMsg/RichMsg$PttRec:msgTime	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   237: invokevirtual 153	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   240: lstore 5
    //   242: aload_0
    //   243: lload 5
    //   245: putfield 84	com/tencent/mobileqq/data/MessageForPtt:msgTime	J
    //   248: aload_1
    //   249: getfield 232	localpb/richMsg/RichMsg$PttRec:msgRecTime	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   252: invokevirtual 230	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   255: ifeq +634 -> 889
    //   258: aload_1
    //   259: getfield 232	localpb/richMsg/RichMsg$PttRec:msgRecTime	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   262: invokevirtual 153	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   265: lstore 5
    //   267: aload_0
    //   268: lload 5
    //   270: putfield 82	com/tencent/mobileqq/data/MessageForPtt:msgRecTime	J
    //   273: aload_1
    //   274: getfield 234	localpb/richMsg/RichMsg$PttRec:voiceType	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   277: invokevirtual 235	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   280: ifeq +615 -> 895
    //   283: aload_1
    //   284: getfield 234	localpb/richMsg/RichMsg$PttRec:voiceType	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   287: invokevirtual 163	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   290: istore_3
    //   291: aload_0
    //   292: iload_3
    //   293: putfield 237	com/tencent/mobileqq/data/MessageForPtt:voiceType	I
    //   296: aload_1
    //   297: getfield 239	localpb/richMsg/RichMsg$PttRec:voiceLength	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   300: invokevirtual 235	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   303: ifeq +597 -> 900
    //   306: aload_1
    //   307: getfield 239	localpb/richMsg/RichMsg$PttRec:voiceLength	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   310: invokevirtual 163	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   313: istore_3
    //   314: aload_0
    //   315: iload_3
    //   316: putfield 241	com/tencent/mobileqq/data/MessageForPtt:voiceLength	I
    //   319: aload_1
    //   320: getfield 243	localpb/richMsg/RichMsg$PttRec:voiceChangeFlag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   323: invokevirtual 235	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   326: ifeq +579 -> 905
    //   329: aload_1
    //   330: getfield 243	localpb/richMsg/RichMsg$PttRec:voiceChangeFlag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   333: invokevirtual 163	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   336: istore_3
    //   337: aload_0
    //   338: iload_3
    //   339: putfield 245	com/tencent/mobileqq/data/MessageForPtt:voiceChangeFlag	I
    //   342: iload 4
    //   344: istore_3
    //   345: aload_1
    //   346: getfield 247	localpb/richMsg/RichMsg$PttRec:busiType	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   349: invokevirtual 235	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   352: ifeq +11 -> 363
    //   355: aload_1
    //   356: getfield 247	localpb/richMsg/RichMsg$PttRec:busiType	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   359: invokevirtual 163	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   362: istore_3
    //   363: aload_0
    //   364: iload_3
    //   365: putfield 249	com/tencent/mobileqq/data/MessageForPtt:busiType	I
    //   368: aload_1
    //   369: getfield 251	localpb/richMsg/RichMsg$PttRec:directUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   372: invokevirtual 225	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   375: ifeq +535 -> 910
    //   378: aload_1
    //   379: getfield 251	localpb/richMsg/RichMsg$PttRec:directUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   382: invokevirtual 142	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   385: astore_2
    //   386: aload_0
    //   387: aload_2
    //   388: putfield 78	com/tencent/mobileqq/data/MessageForPtt:directUrl	Ljava/lang/String;
    //   391: aload_1
    //   392: getfield 253	localpb/richMsg/RichMsg$PttRec:fullLocalPath	Lcom/tencent/mobileqq/pb/PBStringField;
    //   395: invokevirtual 225	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   398: ifeq +518 -> 916
    //   401: aload_1
    //   402: getfield 253	localpb/richMsg/RichMsg$PttRec:fullLocalPath	Lcom/tencent/mobileqq/pb/PBStringField;
    //   405: invokevirtual 142	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   408: astore_2
    //   409: aload_0
    //   410: aload_2
    //   411: putfield 80	com/tencent/mobileqq/data/MessageForPtt:fullLocalPath	Ljava/lang/String;
    //   414: aload_1
    //   415: getfield 255	localpb/richMsg/RichMsg$PttRec:extFlag	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   418: invokevirtual 230	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   421: ifeq +501 -> 922
    //   424: aload_1
    //   425: getfield 255	localpb/richMsg/RichMsg$PttRec:extFlag	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   428: invokevirtual 153	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   431: lstore 5
    //   433: aload_0
    //   434: lload 5
    //   436: putfield 257	com/tencent/mobileqq/data/MessageForPtt:extFlag	J
    //   439: return
    //   440: astore_2
    //   441: aload_2
    //   442: invokevirtual 260	java/lang/Exception:printStackTrace	()V
    //   445: iconst_0
    //   446: istore_3
    //   447: goto -417 -> 30
    //   450: aload_0
    //   451: getfield 263	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   454: astore_1
    //   455: aload_1
    //   456: ifnonnull +28 -> 484
    //   459: aload_0
    //   460: getfield 266	com/tencent/mobileqq/data/MessageForPtt:versionCode	I
    //   463: ifle +21 -> 484
    //   466: aload_0
    //   467: new 91	java/lang/String
    //   470: dup
    //   471: aload_0
    //   472: getfield 129	com/tencent/mobileqq/data/MessageForPtt:msgData	[B
    //   475: ldc_w 268
    //   478: invokespecial 271	java/lang/String:<init>	([BLjava/lang/String;)V
    //   481: putfield 263	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   484: aload_0
    //   485: iconst_0
    //   486: putfield 74	com/tencent/mobileqq/data/MessageForPtt:subVersion	I
    //   489: aload_0
    //   490: getfield 263	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   493: ifnull +384 -> 877
    //   496: aload_0
    //   497: getfield 274	com/tencent/mobileqq/data/MessageForPtt:msgtype	I
    //   500: sipush 64505
    //   503: if_icmpne +374 -> 877
    //   506: aload_0
    //   507: aload_0
    //   508: getfield 263	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   511: invokestatic 280	com/tencent/mobileqq/utils/ActionMsgUtil:a	(Ljava/lang/String;)LActionMsg/MsgBody;
    //   514: getfield 283	ActionMsg/MsgBody:msg	Ljava/lang/String;
    //   517: putfield 263	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   520: iconst_1
    //   521: istore_3
    //   522: aload_0
    //   523: getfield 263	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   526: ifnull +331 -> 857
    //   529: aload_0
    //   530: getfield 263	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   533: invokevirtual 99	java/lang/String:length	()I
    //   536: ifle +321 -> 857
    //   539: aload_0
    //   540: getfield 263	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   543: iconst_0
    //   544: invokevirtual 287	java/lang/String:charAt	(I)C
    //   547: bipush 22
    //   549: if_icmpne +308 -> 857
    //   552: aload_0
    //   553: getfield 263	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   556: ldc_w 289
    //   559: invokevirtual 293	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   562: astore_1
    //   563: aload_1
    //   564: ifnull +293 -> 857
    //   567: aload_1
    //   568: arraylength
    //   569: ifle +141 -> 710
    //   572: aload_0
    //   573: aload_1
    //   574: iconst_0
    //   575: aaload
    //   576: invokevirtual 296	java/lang/String:trim	()Ljava/lang/String;
    //   579: putfield 144	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   582: iload_3
    //   583: ifeq +11 -> 594
    //   586: aload_0
    //   587: aload_0
    //   588: getfield 144	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   591: putfield 181	com/tencent/mobileqq/data/MessageForPtt:urlAtServer	Ljava/lang/String;
    //   594: aload_1
    //   595: arraylength
    //   596: istore_3
    //   597: iload_3
    //   598: iconst_1
    //   599: if_icmple +16 -> 615
    //   602: aload_0
    //   603: aload_1
    //   604: iconst_1
    //   605: aaload
    //   606: invokestatic 302	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   609: invokevirtual 305	java/lang/Long:longValue	()J
    //   612: putfield 155	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   615: aload_1
    //   616: arraylength
    //   617: istore_3
    //   618: iload_3
    //   619: iconst_2
    //   620: if_icmple +13 -> 633
    //   623: aload_0
    //   624: aload_1
    //   625: iconst_2
    //   626: aaload
    //   627: invokestatic 311	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   630: putfield 165	com/tencent/mobileqq/data/MessageForPtt:itemType	I
    //   633: aload_1
    //   634: arraylength
    //   635: iconst_3
    //   636: if_icmple +213 -> 849
    //   639: aload_1
    //   640: iconst_3
    //   641: aaload
    //   642: invokevirtual 296	java/lang/String:trim	()Ljava/lang/String;
    //   645: invokestatic 314	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   648: invokevirtual 317	java/lang/Integer:intValue	()I
    //   651: ifeq +279 -> 930
    //   654: iconst_1
    //   655: istore 7
    //   657: aload_0
    //   658: iload 7
    //   660: putfield 176	com/tencent/mobileqq/data/MessageForPtt:isReadPtt	Z
    //   663: aload_1
    //   664: arraylength
    //   665: iconst_4
    //   666: if_icmple +216 -> 882
    //   669: aload_0
    //   670: aload_1
    //   671: iconst_4
    //   672: aaload
    //   673: putfield 181	com/tencent/mobileqq/data/MessageForPtt:urlAtServer	Ljava/lang/String;
    //   676: return
    //   677: astore_1
    //   678: aload_0
    //   679: getfield 263	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   682: ifnonnull +15 -> 697
    //   685: aload_0
    //   686: ldc 76
    //   688: putfield 144	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   691: aload_0
    //   692: ldc 76
    //   694: putfield 181	com/tencent/mobileqq/data/MessageForPtt:urlAtServer	Ljava/lang/String;
    //   697: aload_1
    //   698: invokevirtual 318	java/lang/Throwable:printStackTrace	()V
    //   701: return
    //   702: astore_1
    //   703: aload_1
    //   704: invokevirtual 260	java/lang/Exception:printStackTrace	()V
    //   707: goto -223 -> 484
    //   710: aload_0
    //   711: ldc 76
    //   713: putfield 144	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   716: iload_3
    //   717: ifeq -123 -> 594
    //   720: aload_0
    //   721: aload_0
    //   722: getfield 144	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   725: putfield 181	com/tencent/mobileqq/data/MessageForPtt:urlAtServer	Ljava/lang/String;
    //   728: goto -134 -> 594
    //   731: astore_2
    //   732: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   735: ifeq -120 -> 615
    //   738: aload_0
    //   739: invokevirtual 329	java/lang/Object:getClass	()Ljava/lang/Class;
    //   742: invokevirtual 334	java/lang/Class:getName	()Ljava/lang/String;
    //   745: iconst_2
    //   746: new 105	java/lang/StringBuilder
    //   749: dup
    //   750: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   753: ldc_w 336
    //   756: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: aload_1
    //   760: iconst_1
    //   761: aaload
    //   762: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: ldc_w 338
    //   768: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: aload_0
    //   772: getfield 263	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   775: invokestatic 343	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   778: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   784: invokestatic 347	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   787: goto -172 -> 615
    //   790: astore_2
    //   791: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   794: ifeq -161 -> 633
    //   797: aload_0
    //   798: invokevirtual 329	java/lang/Object:getClass	()Ljava/lang/Class;
    //   801: invokevirtual 334	java/lang/Class:getName	()Ljava/lang/String;
    //   804: iconst_2
    //   805: new 105	java/lang/StringBuilder
    //   808: dup
    //   809: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   812: ldc_w 349
    //   815: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: aload_1
    //   819: iconst_2
    //   820: aaload
    //   821: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: ldc_w 338
    //   827: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: aload_0
    //   831: getfield 263	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   834: invokestatic 343	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   837: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   843: invokestatic 347	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   846: goto -213 -> 633
    //   849: aload_0
    //   850: iconst_1
    //   851: putfield 176	com/tencent/mobileqq/data/MessageForPtt:isReadPtt	Z
    //   854: goto -191 -> 663
    //   857: aload_0
    //   858: getfield 263	com/tencent/mobileqq/data/MessageForPtt:msg	Ljava/lang/String;
    //   861: ifnonnull +21 -> 882
    //   864: aload_0
    //   865: ldc 76
    //   867: putfield 144	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   870: aload_0
    //   871: ldc 76
    //   873: putfield 181	com/tencent/mobileqq/data/MessageForPtt:urlAtServer	Ljava/lang/String;
    //   876: return
    //   877: iconst_0
    //   878: istore_3
    //   879: goto -357 -> 522
    //   882: return
    //   883: lconst_0
    //   884: lstore 5
    //   886: goto -644 -> 242
    //   889: lconst_0
    //   890: lstore 5
    //   892: goto -625 -> 267
    //   895: iconst_0
    //   896: istore_3
    //   897: goto -606 -> 291
    //   900: iconst_0
    //   901: istore_3
    //   902: goto -588 -> 314
    //   905: iconst_0
    //   906: istore_3
    //   907: goto -570 -> 337
    //   910: ldc 76
    //   912: astore_2
    //   913: goto -527 -> 386
    //   916: ldc 76
    //   918: astore_2
    //   919: goto -510 -> 409
    //   922: ldc2_w 350
    //   925: lstore 5
    //   927: goto -494 -> 433
    //   930: iconst_0
    //   931: istore 7
    //   933: goto -276 -> 657
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	936	0	this	MessageForPtt
    //   13	658	1	localObject1	Object
    //   677	21	1	localThrowable	Throwable
    //   702	117	1	localException1	Exception
    //   25	386	2	localObject2	Object
    //   440	2	2	localException2	Exception
    //   731	1	2	localException3	Exception
    //   790	1	2	localException4	Exception
    //   912	7	2	str	String
    //   29	878	3	i	int
    //   4	339	4	j	int
    //   240	686	5	l	long
    //   1	931	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   14	26	440	java/lang/Exception
    //   6	14	677	java/lang/Throwable
    //   14	26	677	java/lang/Throwable
    //   34	177	677	java/lang/Throwable
    //   177	196	677	java/lang/Throwable
    //   196	223	677	java/lang/Throwable
    //   223	242	677	java/lang/Throwable
    //   242	267	677	java/lang/Throwable
    //   267	291	677	java/lang/Throwable
    //   291	314	677	java/lang/Throwable
    //   314	337	677	java/lang/Throwable
    //   337	342	677	java/lang/Throwable
    //   345	363	677	java/lang/Throwable
    //   363	386	677	java/lang/Throwable
    //   386	409	677	java/lang/Throwable
    //   409	433	677	java/lang/Throwable
    //   433	439	677	java/lang/Throwable
    //   441	445	677	java/lang/Throwable
    //   450	455	677	java/lang/Throwable
    //   459	484	677	java/lang/Throwable
    //   484	520	677	java/lang/Throwable
    //   522	563	677	java/lang/Throwable
    //   567	582	677	java/lang/Throwable
    //   586	594	677	java/lang/Throwable
    //   594	597	677	java/lang/Throwable
    //   602	615	677	java/lang/Throwable
    //   615	618	677	java/lang/Throwable
    //   623	633	677	java/lang/Throwable
    //   633	654	677	java/lang/Throwable
    //   657	663	677	java/lang/Throwable
    //   663	676	677	java/lang/Throwable
    //   703	707	677	java/lang/Throwable
    //   710	716	677	java/lang/Throwable
    //   720	728	677	java/lang/Throwable
    //   732	787	677	java/lang/Throwable
    //   791	846	677	java/lang/Throwable
    //   849	854	677	java/lang/Throwable
    //   857	876	677	java/lang/Throwable
    //   459	484	702	java/lang/Exception
    //   602	615	731	java/lang/Exception
    //   623	633	790	java/lang/Exception
  }
  
  public String getLocalFilePath()
  {
    return getLocalFilePath(this.voiceType, this.url);
  }
  
  public String getSummaryMsg()
  {
    return "[语音]";
  }
  
  public boolean isReady()
  {
    return (this.fileSize > 0L) || (this.fileSize == -3L) || (this.fileSize == -1L);
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    serial();
  }
  
  public void serial()
  {
    if (this.versionCode < 3) {
      this.subVersion = 0;
    }
    RichMsg.PttRec localPttRec = new RichMsg.PttRec();
    PBStringField localPBStringField = localPttRec.localPath;
    if (this.url != null)
    {
      str = this.url;
      localPBStringField.set(str);
      localPttRec.size.set(this.fileSize);
      localPttRec.type.set(this.itemType);
      localPttRec.isRead.set(this.isReadPtt);
      localPBStringField = localPttRec.uuid;
      if (this.urlAtServer == null) {
        break label366;
      }
      str = this.urlAtServer;
      label93:
      localPBStringField.set(str);
      localPBStringField = localPttRec.md5;
      if (this.md5 == null) {
        break label372;
      }
      str = this.md5;
      label115:
      localPBStringField.set(str);
      localPBStringField = localPttRec.serverStorageSource;
      if (this.storageSource == null) {
        break label378;
      }
      str = this.storageSource;
      label137:
      localPBStringField.set(str);
      localPttRec.version.set(this.subVersion);
      localPttRec.isReport.set(this.isReport);
      localPttRec.pttFlag.set(this.sttAbility);
      localPttRec.groupFileID.set(this.groupFileID);
      localPBStringField = localPttRec.sttText;
      if (this.sttText == null) {
        break label384;
      }
    }
    label366:
    label372:
    label378:
    label384:
    for (String str = this.sttText;; str = "")
    {
      localPBStringField.set(str);
      localPttRec.longPttVipFlag.set(this.longPttVipFlag);
      localPttRec.expandStt.set(this.expandStt);
      if (this.groupFileKeyStr != null) {
        localPttRec.group_file_key.set(this.groupFileKeyStr);
      }
      localPttRec.msgTime.set(this.msgTime);
      localPttRec.msgRecTime.set(this.msgRecTime);
      localPttRec.voiceType.set(this.voiceType);
      localPttRec.voiceLength.set(Utils.a(this.voiceLength));
      localPttRec.voiceChangeFlag.set(this.voiceChangeFlag);
      localPttRec.busiType.set(this.busiType);
      localPttRec.directUrl.set(this.directUrl);
      localPttRec.fullLocalPath.set(this.fullLocalPath);
      localPttRec.extFlag.set(this.extFlag);
      try
      {
        this.msgData = localPttRec.toByteArray();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      str = "";
      break;
      str = "";
      break label93;
      str = "";
      break label115;
      str = "";
      break label137;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForPtt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */