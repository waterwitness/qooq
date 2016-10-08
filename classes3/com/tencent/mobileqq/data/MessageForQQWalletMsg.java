package com.tencent.mobileqq.data;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class MessageForQQWalletMsg
  extends ChatMessage
{
  public static final int MSG_TYPE_COMMAND_REDPACKET = 6;
  public static final int MSG_TYPE_COMMON_REDPACKET = 2;
  public static final int MSG_TYPE_COMMON_THEME_REDPACKET = 4;
  public static final int MSG_TYPE_INDIVIDUAL_REDPACKET = 2001;
  public static final int MSG_TYPE_LUCY_REDPACKET = 3;
  public static final int MSG_TYPE_LUCY_THEME_REDPACKET = 5;
  public static final int MSG_TYPE_PUBLIC_ACCOUNT_REDPACKET = 2002;
  public static final int MSG_TYPE_TRANSFER = 1;
  private static int QQWALLET_TYPE_REDPACKET;
  private static int QQWALLET_TYPE_TRANSFER;
  private static int SUBVERSION_REDPACKET = 2;
  private static int SUBVERSION_TRANSFER;
  private static int VERSION1;
  private static int VERSION17;
  private static int VERSION2;
  private static int VERSION32;
  public static int[] mMsgType = { 1, 2, 3, 4, 5, 6 };
  public Bitmap background;
  public Bitmap customizeBg;
  public QQWalletRedPacketMsg mQQWalletRedPacketMsg;
  public QQWalletTransferMsg mQQWalletTransferMsg;
  public int messageType;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    QQWALLET_TYPE_TRANSFER = 1;
    QQWALLET_TYPE_REDPACKET = 2;
    VERSION1 = 1;
    VERSION2 = 2;
    VERSION17 = 17;
    VERSION32 = 32;
    SUBVERSION_TRANSFER = 3;
  }
  
  public MessageForQQWalletMsg() {}
  
  public MessageForQQWalletMsg(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5)
  {
    init(paramLong1, paramLong2, paramLong3, "[QQWallet Msg]", paramLong4, 63511, paramInt, paramLong5);
  }
  
  public static boolean isCommandRedPacketMsg(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForQQWalletMsg)) && (((MessageForQQWalletMsg)paramMessageRecord).messageType == 6);
  }
  
  public static boolean isRedPacketMsg(MessageRecord paramMessageRecord)
  {
    boolean bool1 = true;
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForQQWalletMsg)))
    {
      MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramMessageRecord;
      Object localObject = null;
      if ((localMessageForQQWalletMsg.mQQWalletTransferMsg != null) && (localMessageForQQWalletMsg.mQQWalletTransferMsg.elem != null))
      {
        localMessageForQQWalletMsg.parse();
        paramMessageRecord = localMessageForQQWalletMsg.mQQWalletTransferMsg.elem;
      }
      boolean bool2;
      while (paramMessageRecord == null)
      {
        bool2 = false;
        return bool2;
        paramMessageRecord = (MessageRecord)localObject;
        if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg != null)
        {
          paramMessageRecord = (MessageRecord)localObject;
          if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem != null) {
            return true;
          }
        }
      }
      paramMessageRecord = paramMessageRecord.nativeAndroid;
      if (TextUtils.isEmpty(paramMessageRecord)) {
        return false;
      }
      paramMessageRecord = paramMessageRecord.split("\\?");
      if ((!TextUtils.isEmpty(paramMessageRecord[0])) && (paramMessageRecord[0].equals("red"))) {}
      for (;;)
      {
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MessageForQQWaletMsg", 2, "isRedPacketMsg : " + bool1);
        return bool1;
        bool1 = false;
      }
    }
    return false;
  }
  
  /* Error */
  protected void doParse()
  {
    // Byte code:
    //   0: new 156	java/io/ObjectInputStream
    //   3: dup
    //   4: new 158	java/io/ByteArrayInputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 162	com/tencent/mobileqq/data/MessageForQQWalletMsg:msgData	[B
    //   12: invokespecial 165	java/io/ByteArrayInputStream:<init>	([B)V
    //   15: invokespecial 168	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_2
    //   22: invokevirtual 172	java/io/ObjectInputStream:readInt	()I
    //   25: istore 4
    //   27: aload_2
    //   28: astore_1
    //   29: iload 4
    //   31: getstatic 53	com/tencent/mobileqq/data/MessageForQQWalletMsg:VERSION1	I
    //   34: if_icmpeq +13 -> 47
    //   37: aload_2
    //   38: astore_1
    //   39: iload 4
    //   41: getstatic 55	com/tencent/mobileqq/data/MessageForQQWalletMsg:VERSION2	I
    //   44: if_icmpne +49 -> 93
    //   47: aload_2
    //   48: astore_1
    //   49: aload_2
    //   50: invokevirtual 172	java/io/ObjectInputStream:readInt	()I
    //   53: getstatic 49	com/tencent/mobileqq/data/MessageForQQWalletMsg:QQWALLET_TYPE_TRANSFER	I
    //   56: if_icmpne +28 -> 84
    //   59: aload_2
    //   60: astore_1
    //   61: aload_0
    //   62: new 85	com/tencent/mobileqq/data/QQWalletTransferMsg
    //   65: dup
    //   66: invokespecial 173	com/tencent/mobileqq/data/QQWalletTransferMsg:<init>	()V
    //   69: putfield 83	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   72: aload_2
    //   73: astore_1
    //   74: aload_0
    //   75: getfield 83	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   78: iload 4
    //   80: aload_2
    //   81: invokevirtual 177	com/tencent/mobileqq/data/QQWalletTransferMsg:readExternal	(ILjava/io/ObjectInput;)V
    //   84: aload_2
    //   85: ifnull +7 -> 92
    //   88: aload_2
    //   89: invokevirtual 180	java/io/ObjectInputStream:close	()V
    //   92: return
    //   93: aload_2
    //   94: astore_1
    //   95: iload 4
    //   97: getstatic 57	com/tencent/mobileqq/data/MessageForQQWalletMsg:VERSION17	I
    //   100: if_icmpne +78 -> 178
    //   103: aload_2
    //   104: astore_1
    //   105: aload_0
    //   106: new 96	com/tencent/mobileqq/data/QQWalletRedPacketMsg
    //   109: dup
    //   110: invokespecial 181	com/tencent/mobileqq/data/QQWalletRedPacketMsg:<init>	()V
    //   113: putfield 94	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   116: aload_2
    //   117: astore_1
    //   118: aload_0
    //   119: getfield 94	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   122: aload_2
    //   123: invokevirtual 184	com/tencent/mobileqq/data/QQWalletRedPacketMsg:readExternal	(Ljava/io/ObjectInput;)V
    //   126: goto -42 -> 84
    //   129: astore_3
    //   130: aload_2
    //   131: astore_1
    //   132: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq +14 -> 149
    //   138: aload_2
    //   139: astore_1
    //   140: ldc -70
    //   142: iconst_2
    //   143: ldc -68
    //   145: aload_3
    //   146: invokestatic 191	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   149: aload_2
    //   150: astore_1
    //   151: aload_0
    //   152: aconst_null
    //   153: putfield 83	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   156: aload_2
    //   157: astore_1
    //   158: aload_0
    //   159: aconst_null
    //   160: putfield 94	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   163: aload_2
    //   164: ifnull -72 -> 92
    //   167: aload_2
    //   168: invokevirtual 180	java/io/ObjectInputStream:close	()V
    //   171: return
    //   172: astore_1
    //   173: aload_1
    //   174: invokevirtual 194	java/lang/Exception:printStackTrace	()V
    //   177: return
    //   178: aload_2
    //   179: astore_1
    //   180: iload 4
    //   182: getstatic 59	com/tencent/mobileqq/data/MessageForQQWalletMsg:VERSION32	I
    //   185: if_icmplt -101 -> 84
    //   188: aload_2
    //   189: astore_1
    //   190: aload_2
    //   191: invokevirtual 172	java/io/ObjectInputStream:readInt	()I
    //   194: istore 4
    //   196: aload_2
    //   197: astore_1
    //   198: aload_2
    //   199: invokevirtual 172	java/io/ObjectInputStream:readInt	()I
    //   202: istore 5
    //   204: aload_2
    //   205: astore_1
    //   206: aload_0
    //   207: aload_2
    //   208: invokevirtual 172	java/io/ObjectInputStream:readInt	()I
    //   211: putfield 80	com/tencent/mobileqq/data/MessageForQQWalletMsg:messageType	I
    //   214: aload_2
    //   215: astore_1
    //   216: iload 4
    //   218: getstatic 49	com/tencent/mobileqq/data/MessageForQQWalletMsg:QQWALLET_TYPE_TRANSFER	I
    //   221: if_icmpne +46 -> 267
    //   224: aload_2
    //   225: astore_1
    //   226: aload_0
    //   227: new 85	com/tencent/mobileqq/data/QQWalletTransferMsg
    //   230: dup
    //   231: invokespecial 173	com/tencent/mobileqq/data/QQWalletTransferMsg:<init>	()V
    //   234: putfield 83	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   237: aload_2
    //   238: astore_1
    //   239: aload_0
    //   240: getfield 83	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   243: iload 5
    //   245: aload_2
    //   246: invokevirtual 177	com/tencent/mobileqq/data/QQWalletTransferMsg:readExternal	(ILjava/io/ObjectInput;)V
    //   249: goto -165 -> 84
    //   252: astore_3
    //   253: aload_1
    //   254: astore_2
    //   255: aload_3
    //   256: astore_1
    //   257: aload_2
    //   258: ifnull +7 -> 265
    //   261: aload_2
    //   262: invokevirtual 180	java/io/ObjectInputStream:close	()V
    //   265: aload_1
    //   266: athrow
    //   267: aload_2
    //   268: astore_1
    //   269: iload 4
    //   271: getstatic 51	com/tencent/mobileqq/data/MessageForQQWalletMsg:QQWALLET_TYPE_REDPACKET	I
    //   274: if_icmpne -190 -> 84
    //   277: aload_2
    //   278: astore_1
    //   279: aload_0
    //   280: new 96	com/tencent/mobileqq/data/QQWalletRedPacketMsg
    //   283: dup
    //   284: invokespecial 181	com/tencent/mobileqq/data/QQWalletRedPacketMsg:<init>	()V
    //   287: putfield 94	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   290: aload_2
    //   291: astore_1
    //   292: aload_0
    //   293: getfield 94	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   296: aload_2
    //   297: invokevirtual 184	com/tencent/mobileqq/data/QQWalletRedPacketMsg:readExternal	(Ljava/io/ObjectInput;)V
    //   300: goto -216 -> 84
    //   303: astore_1
    //   304: aload_1
    //   305: invokevirtual 194	java/lang/Exception:printStackTrace	()V
    //   308: return
    //   309: astore_2
    //   310: aload_2
    //   311: invokevirtual 194	java/lang/Exception:printStackTrace	()V
    //   314: goto -49 -> 265
    //   317: astore_1
    //   318: aconst_null
    //   319: astore_2
    //   320: goto -63 -> 257
    //   323: astore_3
    //   324: aconst_null
    //   325: astore_2
    //   326: goto -196 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	this	MessageForQQWalletMsg
    //   20	138	1	localObject1	Object
    //   172	2	1	localException1	Exception
    //   179	113	1	localObject2	Object
    //   303	2	1	localException2	Exception
    //   317	1	1	localObject3	Object
    //   18	279	2	localObject4	Object
    //   309	2	2	localException3	Exception
    //   319	7	2	localObject5	Object
    //   129	17	3	localException4	Exception
    //   252	4	3	localObject6	Object
    //   323	1	3	localException5	Exception
    //   25	250	4	i	int
    //   202	42	5	j	int
    // Exception table:
    //   from	to	target	type
    //   21	27	129	java/lang/Exception
    //   29	37	129	java/lang/Exception
    //   39	47	129	java/lang/Exception
    //   49	59	129	java/lang/Exception
    //   61	72	129	java/lang/Exception
    //   74	84	129	java/lang/Exception
    //   95	103	129	java/lang/Exception
    //   105	116	129	java/lang/Exception
    //   118	126	129	java/lang/Exception
    //   180	188	129	java/lang/Exception
    //   190	196	129	java/lang/Exception
    //   198	204	129	java/lang/Exception
    //   206	214	129	java/lang/Exception
    //   216	224	129	java/lang/Exception
    //   226	237	129	java/lang/Exception
    //   239	249	129	java/lang/Exception
    //   269	277	129	java/lang/Exception
    //   279	290	129	java/lang/Exception
    //   292	300	129	java/lang/Exception
    //   167	171	172	java/lang/Exception
    //   21	27	252	finally
    //   29	37	252	finally
    //   39	47	252	finally
    //   49	59	252	finally
    //   61	72	252	finally
    //   74	84	252	finally
    //   95	103	252	finally
    //   105	116	252	finally
    //   118	126	252	finally
    //   132	138	252	finally
    //   140	149	252	finally
    //   151	156	252	finally
    //   158	163	252	finally
    //   180	188	252	finally
    //   190	196	252	finally
    //   198	204	252	finally
    //   206	214	252	finally
    //   216	224	252	finally
    //   226	237	252	finally
    //   239	249	252	finally
    //   269	277	252	finally
    //   279	290	252	finally
    //   292	300	252	finally
    //   88	92	303	java/lang/Exception
    //   261	265	309	java/lang/Exception
    //   0	19	317	finally
    //   0	19	323	java/lang/Exception
  }
  
  public byte[] getBytes()
  {
    prewrite();
    return this.msgData;
  }
  
  public String getMsgSummary()
  {
    if ((this.mQQWalletTransferMsg != null) && (this.mQQWalletTransferMsg.elem != null)) {
      return this.mQQWalletTransferMsg.elem.notice;
    }
    if ((this.mQQWalletRedPacketMsg != null) && (this.mQQWalletRedPacketMsg.elem != null)) {
      return this.mQQWalletRedPacketMsg.elem.notice;
    }
    return "";
  }
  
  public String getSummaryMsg()
  {
    return getMsgSummary();
  }
  
  public boolean isMsgEmpty()
  {
    if ((this.mQQWalletTransferMsg == null) && (this.mQQWalletRedPacketMsg == null)) {}
    while (this.msgData == null) {
      return true;
    }
    return false;
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public boolean needVipBubble()
  {
    return false;
  }
  
  protected void postRead()
  {
    parse();
  }
  
  /* Error */
  protected void prewrite()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: getfield 83	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   6: ifnull +219 -> 225
    //   9: new 214	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 215	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore 4
    //   18: new 217	java/io/ObjectOutputStream
    //   21: dup
    //   22: aload 4
    //   24: invokespecial 220	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: astore_2
    //   28: aload_2
    //   29: astore_1
    //   30: aload_2
    //   31: getstatic 59	com/tencent/mobileqq/data/MessageForQQWalletMsg:VERSION32	I
    //   34: invokevirtual 224	java/io/ObjectOutputStream:writeInt	(I)V
    //   37: aload_2
    //   38: astore_1
    //   39: aload_2
    //   40: getstatic 49	com/tencent/mobileqq/data/MessageForQQWalletMsg:QQWALLET_TYPE_TRANSFER	I
    //   43: invokevirtual 224	java/io/ObjectOutputStream:writeInt	(I)V
    //   46: aload_2
    //   47: astore_1
    //   48: aload_2
    //   49: getstatic 61	com/tencent/mobileqq/data/MessageForQQWalletMsg:SUBVERSION_TRANSFER	I
    //   52: invokevirtual 224	java/io/ObjectOutputStream:writeInt	(I)V
    //   55: aload_2
    //   56: astore_1
    //   57: aload_2
    //   58: aload_0
    //   59: getfield 80	com/tencent/mobileqq/data/MessageForQQWalletMsg:messageType	I
    //   62: invokevirtual 224	java/io/ObjectOutputStream:writeInt	(I)V
    //   65: aload_2
    //   66: astore_1
    //   67: aload_0
    //   68: getfield 83	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   71: aload_2
    //   72: invokevirtual 228	com/tencent/mobileqq/data/QQWalletTransferMsg:writeExternal	(Ljava/io/ObjectOutput;)V
    //   75: aload_2
    //   76: astore_1
    //   77: aload_2
    //   78: invokevirtual 229	java/io/ObjectOutputStream:close	()V
    //   81: aload_2
    //   82: astore_1
    //   83: aload_0
    //   84: aload 4
    //   86: invokevirtual 232	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   89: putfield 162	com/tencent/mobileqq/data/MessageForQQWalletMsg:msgData	[B
    //   92: aload_2
    //   93: ifnull +7 -> 100
    //   96: aload_2
    //   97: invokevirtual 229	java/io/ObjectOutputStream:close	()V
    //   100: aload 4
    //   102: ifnull +8 -> 110
    //   105: aload 4
    //   107: invokevirtual 233	java/io/ByteArrayOutputStream:close	()V
    //   110: return
    //   111: astore_1
    //   112: aload_1
    //   113: invokevirtual 194	java/lang/Exception:printStackTrace	()V
    //   116: goto -16 -> 100
    //   119: astore_1
    //   120: aload_1
    //   121: invokevirtual 194	java/lang/Exception:printStackTrace	()V
    //   124: return
    //   125: astore_3
    //   126: aconst_null
    //   127: astore_2
    //   128: aload_2
    //   129: astore_1
    //   130: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +14 -> 147
    //   136: aload_2
    //   137: astore_1
    //   138: ldc -70
    //   140: iconst_2
    //   141: ldc -21
    //   143: aload_3
    //   144: invokestatic 191	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   147: aload_2
    //   148: astore_1
    //   149: aload_3
    //   150: invokevirtual 194	java/lang/Exception:printStackTrace	()V
    //   153: aload_2
    //   154: ifnull +7 -> 161
    //   157: aload_2
    //   158: invokevirtual 229	java/io/ObjectOutputStream:close	()V
    //   161: aload 4
    //   163: ifnull -53 -> 110
    //   166: aload 4
    //   168: invokevirtual 233	java/io/ByteArrayOutputStream:close	()V
    //   171: return
    //   172: astore_1
    //   173: aload_1
    //   174: invokevirtual 194	java/lang/Exception:printStackTrace	()V
    //   177: return
    //   178: astore_1
    //   179: aload_1
    //   180: invokevirtual 194	java/lang/Exception:printStackTrace	()V
    //   183: goto -22 -> 161
    //   186: astore_2
    //   187: aconst_null
    //   188: astore_1
    //   189: aload_1
    //   190: ifnull +7 -> 197
    //   193: aload_1
    //   194: invokevirtual 229	java/io/ObjectOutputStream:close	()V
    //   197: aload 4
    //   199: ifnull +8 -> 207
    //   202: aload 4
    //   204: invokevirtual 233	java/io/ByteArrayOutputStream:close	()V
    //   207: aload_2
    //   208: athrow
    //   209: astore_1
    //   210: aload_1
    //   211: invokevirtual 194	java/lang/Exception:printStackTrace	()V
    //   214: goto -17 -> 197
    //   217: astore_1
    //   218: aload_1
    //   219: invokevirtual 194	java/lang/Exception:printStackTrace	()V
    //   222: goto -15 -> 207
    //   225: aload_0
    //   226: getfield 94	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   229: ifnull -119 -> 110
    //   232: new 214	java/io/ByteArrayOutputStream
    //   235: dup
    //   236: invokespecial 215	java/io/ByteArrayOutputStream:<init>	()V
    //   239: astore 4
    //   241: new 217	java/io/ObjectOutputStream
    //   244: dup
    //   245: aload 4
    //   247: invokespecial 220	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   250: astore_2
    //   251: aload_2
    //   252: getstatic 59	com/tencent/mobileqq/data/MessageForQQWalletMsg:VERSION32	I
    //   255: invokevirtual 224	java/io/ObjectOutputStream:writeInt	(I)V
    //   258: aload_2
    //   259: getstatic 51	com/tencent/mobileqq/data/MessageForQQWalletMsg:QQWALLET_TYPE_REDPACKET	I
    //   262: invokevirtual 224	java/io/ObjectOutputStream:writeInt	(I)V
    //   265: aload_2
    //   266: getstatic 63	com/tencent/mobileqq/data/MessageForQQWalletMsg:SUBVERSION_REDPACKET	I
    //   269: invokevirtual 224	java/io/ObjectOutputStream:writeInt	(I)V
    //   272: aload_2
    //   273: aload_0
    //   274: getfield 80	com/tencent/mobileqq/data/MessageForQQWalletMsg:messageType	I
    //   277: invokevirtual 224	java/io/ObjectOutputStream:writeInt	(I)V
    //   280: aload_0
    //   281: getfield 94	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   284: aload_2
    //   285: invokevirtual 236	com/tencent/mobileqq/data/QQWalletRedPacketMsg:writeExternal	(Ljava/io/ObjectOutput;)V
    //   288: aload_2
    //   289: invokevirtual 229	java/io/ObjectOutputStream:close	()V
    //   292: aload_0
    //   293: aload 4
    //   295: invokevirtual 232	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   298: putfield 162	com/tencent/mobileqq/data/MessageForQQWalletMsg:msgData	[B
    //   301: aload_2
    //   302: ifnull +7 -> 309
    //   305: aload_2
    //   306: invokevirtual 229	java/io/ObjectOutputStream:close	()V
    //   309: aload 4
    //   311: ifnull -201 -> 110
    //   314: aload 4
    //   316: invokevirtual 233	java/io/ByteArrayOutputStream:close	()V
    //   319: return
    //   320: astore_1
    //   321: aload_1
    //   322: invokevirtual 194	java/lang/Exception:printStackTrace	()V
    //   325: return
    //   326: astore_1
    //   327: aload_1
    //   328: invokevirtual 194	java/lang/Exception:printStackTrace	()V
    //   331: goto -22 -> 309
    //   334: astore_2
    //   335: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   338: ifeq +12 -> 350
    //   341: ldc -70
    //   343: iconst_2
    //   344: ldc -21
    //   346: aload_2
    //   347: invokestatic 191	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   350: aload_2
    //   351: invokevirtual 194	java/lang/Exception:printStackTrace	()V
    //   354: aload_1
    //   355: ifnull +7 -> 362
    //   358: aload_1
    //   359: invokevirtual 229	java/io/ObjectOutputStream:close	()V
    //   362: aload 4
    //   364: ifnull -254 -> 110
    //   367: aload 4
    //   369: invokevirtual 233	java/io/ByteArrayOutputStream:close	()V
    //   372: return
    //   373: astore_1
    //   374: aload_1
    //   375: invokevirtual 194	java/lang/Exception:printStackTrace	()V
    //   378: return
    //   379: astore_1
    //   380: aload_1
    //   381: invokevirtual 194	java/lang/Exception:printStackTrace	()V
    //   384: goto -22 -> 362
    //   387: astore_1
    //   388: aconst_null
    //   389: astore_2
    //   390: aload_2
    //   391: ifnull +7 -> 398
    //   394: aload_2
    //   395: invokevirtual 229	java/io/ObjectOutputStream:close	()V
    //   398: aload 4
    //   400: ifnull +8 -> 408
    //   403: aload 4
    //   405: invokevirtual 233	java/io/ByteArrayOutputStream:close	()V
    //   408: aload_1
    //   409: athrow
    //   410: astore_2
    //   411: aload_2
    //   412: invokevirtual 194	java/lang/Exception:printStackTrace	()V
    //   415: goto -17 -> 398
    //   418: astore_2
    //   419: aload_2
    //   420: invokevirtual 194	java/lang/Exception:printStackTrace	()V
    //   423: goto -15 -> 408
    //   426: astore_1
    //   427: goto -37 -> 390
    //   430: astore_3
    //   431: aload_1
    //   432: astore_2
    //   433: aload_3
    //   434: astore_1
    //   435: goto -45 -> 390
    //   438: astore_3
    //   439: aload_2
    //   440: astore_1
    //   441: aload_3
    //   442: astore_2
    //   443: goto -108 -> 335
    //   446: astore_2
    //   447: goto -258 -> 189
    //   450: astore_3
    //   451: goto -323 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	454	0	this	MessageForQQWalletMsg
    //   1	82	1	localObject1	Object
    //   111	2	1	localException1	Exception
    //   119	2	1	localException2	Exception
    //   129	20	1	localObject2	Object
    //   172	2	1	localException3	Exception
    //   178	2	1	localException4	Exception
    //   188	6	1	localObject3	Object
    //   209	2	1	localException5	Exception
    //   217	2	1	localException6	Exception
    //   320	2	1	localException7	Exception
    //   326	33	1	localException8	Exception
    //   373	2	1	localException9	Exception
    //   379	2	1	localException10	Exception
    //   387	22	1	localObject4	Object
    //   426	6	1	localObject5	Object
    //   434	7	1	localObject6	Object
    //   27	131	2	localObjectOutputStream1	java.io.ObjectOutputStream
    //   186	22	2	localObject7	Object
    //   250	56	2	localObjectOutputStream2	java.io.ObjectOutputStream
    //   334	17	2	localException11	Exception
    //   389	6	2	localObject8	Object
    //   410	2	2	localException12	Exception
    //   418	2	2	localException13	Exception
    //   432	11	2	localObject9	Object
    //   446	1	2	localObject10	Object
    //   125	25	3	localException14	Exception
    //   430	4	3	localObject11	Object
    //   438	4	3	localException15	Exception
    //   450	1	3	localException16	Exception
    //   16	388	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   96	100	111	java/lang/Exception
    //   105	110	119	java/lang/Exception
    //   18	28	125	java/lang/Exception
    //   166	171	172	java/lang/Exception
    //   157	161	178	java/lang/Exception
    //   18	28	186	finally
    //   193	197	209	java/lang/Exception
    //   202	207	217	java/lang/Exception
    //   314	319	320	java/lang/Exception
    //   305	309	326	java/lang/Exception
    //   241	251	334	java/lang/Exception
    //   367	372	373	java/lang/Exception
    //   358	362	379	java/lang/Exception
    //   241	251	387	finally
    //   394	398	410	java/lang/Exception
    //   403	408	418	java/lang/Exception
    //   251	301	426	finally
    //   335	350	430	finally
    //   350	354	430	finally
    //   251	301	438	java/lang/Exception
    //   30	37	446	finally
    //   39	46	446	finally
    //   48	55	446	finally
    //   57	65	446	finally
    //   67	75	446	finally
    //   77	81	446	finally
    //   83	92	446	finally
    //   130	136	446	finally
    //   138	147	446	finally
    //   149	153	446	finally
    //   30	37	450	java/lang/Exception
    //   39	46	450	java/lang/Exception
    //   48	55	450	java/lang/Exception
    //   57	65	450	java/lang/Exception
    //   67	75	450	java/lang/Exception
    //   77	81	450	java/lang/Exception
    //   83	92	450	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForQQWalletMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */