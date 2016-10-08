package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout12;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.regex.Pattern;

public class StructMsgFactory
{
  public StructMsgFactory()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static AbsStructMsg a()
  {
    StructMsgForGeneralShare localStructMsgForGeneralShare = new StructMsgForGeneralShare();
    localStructMsgForGeneralShare.fwFlag = 0;
    localStructMsgForGeneralShare.mMsgTemplateID = 1;
    localStructMsgForGeneralShare.mMsgServiceID = 1;
    localStructMsgForGeneralShare.mMsgBrief = "你有新消息";
    localStructMsgForGeneralShare.mMsgAction = "";
    localStructMsgForGeneralShare.mMsgActionData = "";
    localStructMsgForGeneralShare.mMsg_A_ActionData = "";
    localStructMsgForGeneralShare.mMsg_I_ActionData = "";
    localStructMsgForGeneralShare.mMsgUrl = "";
    localStructMsgForGeneralShare.mFlag = 55;
    StructMsgElementFactory.a(0).a(new StructMsgItemTitle(""));
    return localStructMsgForGeneralShare;
  }
  
  public static AbsStructMsg a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    switch (paramBundle.getInt("req_type", 1))
    {
    case 4: 
    default: 
      return new StructMsgForGeneralShare(paramBundle);
    case 2: 
      return new StructMsgForAudioShare(paramBundle);
    case 3: 
      return new StructMsgForHypertext(paramBundle);
    }
    return new StructMsgForImageShare(paramBundle);
  }
  
  public static AbsStructMsg a(QQAppInterface paramQQAppInterface, int paramInt1, long paramLong, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte = a(paramArrayOfByte, paramInt2);
    if ((paramArrayOfByte != null) && ((paramArrayOfByte instanceof AbsShareMsg)))
    {
      l1 = paramArrayOfByte.mMsgServiceID;
      l2 = ((AbsShareMsg)paramArrayOfByte).mSourceAppid;
      if ((l1 == 23L) && ((paramInt1 == 82) || (paramInt1 == 43))) {
        ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_AIO", paramQQAppInterface.a(), "AIOchat", "appear_obj", 0, 0, String.valueOf(paramLong), String.valueOf(l1), String.valueOf(l2), "");
      }
      if (l1 == 52L)
      {
        paramQQAppInterface = new StringBuilder("rec flower msg,");
        paramQQAppInterface.append(StructMsgItemLayout12.a(paramArrayOfByte));
        QLog.i("StructMsg", 1, paramQQAppInterface.toString());
      }
    }
    while (!QLog.isColorLevel())
    {
      long l1;
      long l2;
      return paramArrayOfByte;
    }
    QLog.d("StructMsg", 2, "getStructMsgFromXmlBuff = null ,error happened ");
    return paramArrayOfByte;
  }
  
  /* Error */
  public static AbsStructMsg a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore_1
    //   7: aload_0
    //   8: ifnonnull +5 -> 13
    //   11: aload_1
    //   12: areturn
    //   13: new 175	java/io/ObjectInputStream
    //   16: dup
    //   17: new 177	java/io/ByteArrayInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 180	java/io/ByteArrayInputStream:<init>	([B)V
    //   25: invokespecial 183	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   28: astore_3
    //   29: aload_3
    //   30: astore_1
    //   31: aload 4
    //   33: astore_2
    //   34: aload_3
    //   35: invokevirtual 187	java/io/ObjectInputStream:readInt	()I
    //   38: istore 5
    //   40: iload 5
    //   42: iconst_2
    //   43: if_icmpne +72 -> 115
    //   46: aload_3
    //   47: astore_1
    //   48: aload 4
    //   50: astore_2
    //   51: new 85	com/tencent/mobileqq/structmsg/StructMsgForAudioShare
    //   54: dup
    //   55: invokespecial 188	com/tencent/mobileqq/structmsg/StructMsgForAudioShare:<init>	()V
    //   58: astore_0
    //   59: aload_0
    //   60: ifnull +22 -> 82
    //   63: aload_3
    //   64: astore_1
    //   65: aload_0
    //   66: astore_2
    //   67: aload_0
    //   68: iload 5
    //   70: putfield 101	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   73: aload_3
    //   74: astore_1
    //   75: aload_0
    //   76: astore_2
    //   77: aload_0
    //   78: aload_3
    //   79: invokevirtual 192	com/tencent/mobileqq/structmsg/AbsStructMsg:readExternal	(Ljava/io/ObjectInput;)V
    //   82: aload_0
    //   83: astore_1
    //   84: aload_3
    //   85: ifnull -74 -> 11
    //   88: aload_3
    //   89: invokevirtual 195	java/io/ObjectInputStream:close	()V
    //   92: aload_0
    //   93: areturn
    //   94: astore_2
    //   95: aload_0
    //   96: astore_1
    //   97: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq -89 -> 11
    //   103: ldc -106
    //   105: iconst_2
    //   106: aload_2
    //   107: invokevirtual 198	java/io/IOException:getMessage	()Ljava/lang/String;
    //   110: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aload_0
    //   114: areturn
    //   115: iload 5
    //   117: iconst_3
    //   118: if_icmpne +19 -> 137
    //   121: aload_3
    //   122: astore_1
    //   123: aload 4
    //   125: astore_2
    //   126: new 88	com/tencent/mobileqq/structmsg/StructMsgForHypertext
    //   129: dup
    //   130: invokespecial 199	com/tencent/mobileqq/structmsg/StructMsgForHypertext:<init>	()V
    //   133: astore_0
    //   134: goto -75 -> 59
    //   137: iload 5
    //   139: iconst_5
    //   140: if_icmpne +19 -> 159
    //   143: aload_3
    //   144: astore_1
    //   145: aload 4
    //   147: astore_2
    //   148: new 91	com/tencent/mobileqq/structmsg/StructMsgForImageShare
    //   151: dup
    //   152: invokespecial 200	com/tencent/mobileqq/structmsg/StructMsgForImageShare:<init>	()V
    //   155: astore_0
    //   156: goto -97 -> 59
    //   159: aload_3
    //   160: astore_1
    //   161: aload 4
    //   163: astore_2
    //   164: new 19	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   167: dup
    //   168: invokespecial 20	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:<init>	()V
    //   171: astore_0
    //   172: goto -113 -> 59
    //   175: astore 4
    //   177: aconst_null
    //   178: astore_0
    //   179: aload_0
    //   180: astore_1
    //   181: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   184: ifeq +16 -> 200
    //   187: aload_0
    //   188: astore_1
    //   189: ldc -106
    //   191: iconst_2
    //   192: aload 4
    //   194: invokevirtual 201	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   197: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   200: aload_2
    //   201: astore_1
    //   202: aload_0
    //   203: ifnull -192 -> 11
    //   206: aload_0
    //   207: invokevirtual 195	java/io/ObjectInputStream:close	()V
    //   210: aload_2
    //   211: areturn
    //   212: astore_0
    //   213: aload_2
    //   214: astore_1
    //   215: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq -207 -> 11
    //   221: ldc -106
    //   223: iconst_2
    //   224: aload_0
    //   225: invokevirtual 198	java/io/IOException:getMessage	()Ljava/lang/String;
    //   228: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   231: aload_2
    //   232: areturn
    //   233: astore_0
    //   234: aconst_null
    //   235: astore_1
    //   236: aload_1
    //   237: ifnull +7 -> 244
    //   240: aload_1
    //   241: invokevirtual 195	java/io/ObjectInputStream:close	()V
    //   244: aload_0
    //   245: athrow
    //   246: astore_1
    //   247: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   250: ifeq -6 -> 244
    //   253: ldc -106
    //   255: iconst_2
    //   256: aload_1
    //   257: invokevirtual 198	java/io/IOException:getMessage	()Ljava/lang/String;
    //   260: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: goto -19 -> 244
    //   266: astore_0
    //   267: goto -31 -> 236
    //   270: astore 4
    //   272: aload_3
    //   273: astore_0
    //   274: goto -95 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	paramArrayOfByte	byte[]
    //   6	235	1	localObject1	Object
    //   246	11	1	localIOException1	java.io.IOException
    //   1	76	2	localObject2	Object
    //   94	13	2	localIOException2	java.io.IOException
    //   125	107	2	localObject3	Object
    //   28	245	3	localObjectInputStream	java.io.ObjectInputStream
    //   3	159	4	localObject4	Object
    //   175	18	4	localException1	Exception
    //   270	1	4	localException2	Exception
    //   38	103	5	i	int
    // Exception table:
    //   from	to	target	type
    //   88	92	94	java/io/IOException
    //   13	29	175	java/lang/Exception
    //   206	210	212	java/io/IOException
    //   13	29	233	finally
    //   240	244	246	java/io/IOException
    //   34	40	266	finally
    //   51	59	266	finally
    //   67	73	266	finally
    //   77	82	266	finally
    //   126	134	266	finally
    //   148	156	266	finally
    //   164	172	266	finally
    //   181	187	266	finally
    //   189	200	266	finally
    //   34	40	270	java/lang/Exception
    //   51	59	270	java/lang/Exception
    //   67	73	270	java/lang/Exception
    //   77	82	270	java/lang/Exception
    //   126	134	270	java/lang/Exception
    //   148	156	270	java/lang/Exception
    //   164	172	270	java/lang/Exception
  }
  
  /* Error */
  public static AbsStructMsg a(byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +9 -> 10
    //   4: aload_0
    //   5: arraylength
    //   6: iconst_2
    //   7: if_icmpge +21 -> 28
    //   10: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13: ifeq +11 -> 24
    //   16: ldc -106
    //   18: iconst_2
    //   19: ldc -47
    //   21: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: aconst_null
    //   25: astore_0
    //   26: aload_0
    //   27: areturn
    //   28: aload_0
    //   29: iload_1
    //   30: invokestatic 214	com/tencent/mobileqq/structmsg/StructMsgUtils:a	([BI)[B
    //   33: astore_2
    //   34: invokestatic 220	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   37: invokevirtual 221	java/util/UUID:toString	()Ljava/lang/String;
    //   40: astore_0
    //   41: new 122	java/lang/String
    //   44: dup
    //   45: aload_2
    //   46: ldc -33
    //   48: invokespecial 226	java/lang/String:<init>	([BLjava/lang/String;)V
    //   51: aload_0
    //   52: invokestatic 231	com/tencent/mobileqq/text/EmotcationConstants:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   55: invokestatic 234	com/tencent/mobileqq/structmsg/StructMsgFactory:a	(Ljava/lang/String;)Ljava/lang/String;
    //   58: astore_2
    //   59: invokestatic 237	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   62: ifeq +28 -> 90
    //   65: ldc -106
    //   67: iconst_4
    //   68: new 136	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   75: ldc -16
    //   77: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_2
    //   81: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 159	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: new 177	java/io/ByteArrayInputStream
    //   93: dup
    //   94: aload_2
    //   95: invokevirtual 244	java/lang/String:getBytes	()[B
    //   98: invokespecial 180	java/io/ByteArrayInputStream:<init>	([B)V
    //   101: astore_2
    //   102: new 246	com/tencent/mobileqq/structmsg/StructMsgParserHandler
    //   105: dup
    //   106: invokespecial 247	com/tencent/mobileqq/structmsg/StructMsgParserHandler:<init>	()V
    //   109: astore_3
    //   110: aload_3
    //   111: aload_0
    //   112: invokevirtual 249	com/tencent/mobileqq/structmsg/StructMsgParserHandler:a	(Ljava/lang/String;)V
    //   115: invokestatic 255	javax/xml/parsers/SAXParserFactory:newInstance	()Ljavax/xml/parsers/SAXParserFactory;
    //   118: astore_0
    //   119: aload_0
    //   120: invokevirtual 259	javax/xml/parsers/SAXParserFactory:newSAXParser	()Ljavax/xml/parsers/SAXParser;
    //   123: aload_2
    //   124: aload_3
    //   125: invokevirtual 265	javax/xml/parsers/SAXParser:parse	(Ljava/io/InputStream;Lorg/xml/sax/helpers/DefaultHandler;)V
    //   128: aload_2
    //   129: invokevirtual 268	java/io/InputStream:close	()V
    //   132: aload_3
    //   133: invokevirtual 270	com/tencent/mobileqq/structmsg/StructMsgParserHandler:a	()Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   136: astore_2
    //   137: aload_2
    //   138: astore_0
    //   139: aload_2
    //   140: ifnull -114 -> 26
    //   143: aload_2
    //   144: astore_0
    //   145: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq -122 -> 26
    //   151: ldc -106
    //   153: iconst_2
    //   154: ldc_w 272
    //   157: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   160: aload_2
    //   161: areturn
    //   162: astore_0
    //   163: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +13 -> 179
    //   169: ldc -106
    //   171: iconst_2
    //   172: ldc_w 274
    //   175: aload_0
    //   176: invokestatic 278	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   179: aconst_null
    //   180: areturn
    //   181: astore_0
    //   182: aload_0
    //   183: invokevirtual 281	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   186: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq +32 -> 221
    //   192: ldc -106
    //   194: iconst_2
    //   195: new 136	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   202: ldc_w 283
    //   205: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_0
    //   209: invokevirtual 284	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   212: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: aconst_null
    //   222: areturn
    //   223: astore_0
    //   224: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   227: ifeq -48 -> 179
    //   230: ldc -106
    //   232: iconst_2
    //   233: ldc_w 274
    //   236: aload_0
    //   237: invokestatic 278	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   240: goto -61 -> 179
    //   243: astore_0
    //   244: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   247: ifeq -68 -> 179
    //   250: ldc -106
    //   252: iconst_2
    //   253: ldc_w 274
    //   256: aload_0
    //   257: invokestatic 278	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   260: goto -81 -> 179
    //   263: astore_0
    //   264: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   267: ifeq -88 -> 179
    //   270: ldc -106
    //   272: iconst_2
    //   273: ldc_w 286
    //   276: aload_0
    //   277: invokestatic 278	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   280: goto -101 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	paramArrayOfByte	byte[]
    //   0	283	1	paramInt	int
    //   33	128	2	localObject	Object
    //   109	24	3	localStructMsgParserHandler	StructMsgParserHandler
    // Exception table:
    //   from	to	target	type
    //   119	137	162	javax/xml/parsers/ParserConfigurationException
    //   145	160	162	javax/xml/parsers/ParserConfigurationException
    //   41	90	181	java/io/UnsupportedEncodingException
    //   119	137	223	org/xml/sax/SAXException
    //   145	160	223	org/xml/sax/SAXException
    //   119	137	243	java/io/IOException
    //   145	160	243	java/io/IOException
    //   119	137	263	java/lang/Exception
    //   145	160	263	java/lang/Exception
  }
  
  public static StructMsgForGeneralShare a()
  {
    return new StructMsgForGeneralShare();
  }
  
  public static StructMsgNode a(StructMsgNode paramStructMsgNode)
  {
    for (paramStructMsgNode = paramStructMsgNode.a(); (paramStructMsgNode != null) && (paramStructMsgNode.jdField_a_of_type_Int != 1); paramStructMsgNode = paramStructMsgNode.a()) {}
    return paramStructMsgNode;
  }
  
  public static InputStream a(String paramString)
  {
    return new ByteArrayInputStream(paramString.getBytes());
  }
  
  public static InputStream a(String paramString, Context paramContext)
  {
    Object localObject = null;
    for (;;)
    {
      try
      {
        paramString = paramContext.getResources().getAssets().open(paramString, 1);
        paramContext = paramString;
        if (paramString == null) {}
      }
      catch (Exception paramString)
      {
        paramString.getMessage();
        paramContext = (Context)localObject;
        if (0 == 0) {
          continue;
        }
        try
        {
          throw new NullPointerException();
        }
        catch (Exception paramString)
        {
          paramString.getMessage();
          return null;
        }
      }
      finally
      {
        if (0 == 0) {
          break label78;
        }
      }
      try
      {
        paramString.close();
        paramContext = paramString;
        return paramContext;
      }
      catch (Exception paramContext)
      {
        paramContext.getMessage();
        return paramString;
      }
    }
    try
    {
      throw new NullPointerException();
      label78:
      throw paramString;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.getMessage();
      }
    }
  }
  
  public static String a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode.jdField_a_of_type_Int == 3) {}
    Object localObject;
    for (paramStructMsgNode = paramStructMsgNode.jdField_a_of_type_JavaLangString;; paramStructMsgNode = ((StringBuilder)localObject).toString())
    {
      localObject = paramStructMsgNode;
      if (paramStructMsgNode == null) {
        localObject = "";
      }
      return (String)localObject;
      localObject = new StringBuilder();
      int j = paramStructMsgNode.a();
      int i = 0;
      if (i < j)
      {
        StructMsgNode localStructMsgNode = paramStructMsgNode.a(i);
        if (localStructMsgNode == null) {}
        for (;;)
        {
          i += 1;
          break;
          if (localStructMsgNode.jdField_a_of_type_Int == 3) {
            ((StringBuilder)localObject).append(localStructMsgNode.jdField_a_of_type_JavaLangString);
          }
        }
      }
    }
  }
  
  public static final String a(String paramString)
  {
    Object localObject = System.getProperty("java.vm.version");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      try
      {
        bool = a((String)localObject, "2.0.0", ".");
        if (QLog.isDevelopLevel()) {
          QLog.d("StructMsg", 4, "java vm version  = " + (String)localObject + " isART = " + bool);
        }
        localObject = AIOUtils.a().append(paramString);
        i = 0;
        k = 0;
        if (i < paramString.length())
        {
          int i1 = paramString.charAt(i);
          m = i;
          j = k;
          switch (i1)
          {
          default: 
            if (((i1 < 32) || (i1 > 55295)) && ((i1 < 57344) || (i1 > 65533))) {
              continue;
            }
            n = 1;
            if (!bool) {
              continue;
            }
            m = i;
            j = k;
            if (n == 0)
            {
              ((StringBuilder)localObject).deleteCharAt(i - k);
              k += 1;
              m = i;
              j = k;
              if (QLog.isColorLevel())
              {
                QLog.d("StructMsg", 2, " ContainInvalidCharacter return null ,invalid char  = " + Integer.toHexString(i1));
                j = k;
                m = i;
              }
            }
            break;
          }
          i = m + 1;
          k = j;
          continue;
        }
      }
      catch (Exception localException)
      {
        int i;
        int k;
        bool = false;
        continue;
        int n = 0;
        continue;
        int m = i;
        int j = k;
        if (n != 0) {
          continue;
        }
        n = paramString.codePointAt(i);
        if (EmotcationConstants.a.get(n, -1) >= 0)
        {
          m = i;
          j = k;
          if (n <= 65535) {
            continue;
          }
          m = i + 1;
          j = k;
          continue;
        }
        ((StringBuilder)localObject).deleteCharAt(i - k);
        j = k + 1;
        m = i;
        continue;
      }
      return ((StringBuilder)localObject).toString();
      boolean bool = false;
    }
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return false;
      try
      {
        paramString1 = Pattern.compile(paramString3, 16).split(paramString1);
        paramString2 = Pattern.compile(paramString3, 16).split(paramString2);
        int m = Math.max(paramString1.length, paramString2.length);
        int i = 0;
        label49:
        if (i < m)
        {
          int j;
          if (paramString1.length > i)
          {
            j = Integer.parseInt(paramString1[i]);
            label69:
            if (paramString2.length <= i) {
              break label103;
            }
          }
          label103:
          for (int k = Integer.parseInt(paramString2[i]); j >= k; k = 0)
          {
            i += 1;
            break label49;
            j = 0;
            break label69;
          }
        }
        return true;
      }
      catch (Exception paramString1) {}
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\StructMsgFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */