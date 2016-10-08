package com.tencent.biz.pubaccount.util;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PAMessageUtil
{
  public static final String A = "needlogin";
  private static final String B = "nativejump";
  private static final String C = "more";
  private static final String D = "icons";
  private static final String E = "rflag";
  private static final String F = "new_time";
  private static final String G = "rna";
  private static final String H = "aru";
  private static final String I = "iru";
  private static final String J = "ard";
  private static final String K = "irs";
  private static final String L = "desc";
  private static final String M = "area";
  private static final String N = "temper";
  private static final String O = "wea";
  private static final String P = "o_wea";
  private static final String Q = "t_wea";
  private static final String R = "n_wea";
  private static final String S = "j_url";
  private static final String T = "e_url";
  private static final String U = "t";
  private static final String V = "b_ad";
  public static final int a = 1;
  public static final String a = "open_local";
  public static final int b = 2;
  public static final String b = "msg";
  public static final int c = 3;
  public static final String c = "type";
  public static final int d = 1;
  public static final String d = "meta";
  public static final int e = 0;
  public static final String e = "appmsg";
  public static final String f = "msg";
  public static final String g = "item";
  public static final String h = "title";
  public static final String i = "cover";
  public static final String j = "digest";
  public static final String k = "url";
  public static final String l = "action";
  public static final String m = "actionData";
  public static final String n = "a_actionData";
  public static final String o = "i_actionData";
  public static final String p = "appid";
  public static final String q = "time";
  public static final String r = "flag";
  public static final String s = "grayTips";
  public static final String t = "sender";
  public static final String u = "name";
  public static final String v = "email";
  public static final String w = "icon";
  public static final String x = "icon";
  public static final String y = "iosurl";
  public static final String z = "androidurl";
  
  public PAMessageUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static PAMessage.Item a(Node paramNode)
  {
    PAMessage.Item localItem = new PAMessage.Item();
    paramNode = paramNode.getChildNodes();
    int i3 = paramNode.getLength();
    int i1 = 0;
    if (i1 < i3)
    {
      Object localObject2 = paramNode.item(i1);
      Object localObject1 = a((Node)localObject2);
      Object localObject3 = ((Node)localObject2).getNodeName();
      if (((String)localObject3).equals("cover")) {
        localItem.cover = ((String)localObject1);
      }
      for (;;)
      {
        i1 += 1;
        break;
        if (((String)localObject3).equals("digest"))
        {
          if (localItem.digestList == null) {
            localItem.digestList = new ArrayList();
          }
          localItem.digestList.add(localObject1);
        }
        else if (((String)localObject3).equals("title"))
        {
          localItem.title = ((String)localObject1);
          localObject1 = ((Node)localObject2).getAttributes();
          localItem.mVideoFlag = 0;
          if ((localObject1 != null) && (((NamedNodeMap)localObject1).getLength() > 0))
          {
            localObject1 = ((NamedNodeMap)localObject1).getNamedItem("rflag");
            if (localObject1 != null) {
              try
              {
                localItem.mVideoFlag = Integer.parseInt(((Node)localObject1).getNodeValue());
              }
              catch (NumberFormatException localNumberFormatException) {}
            }
          }
        }
        else if (((String)localObject3).equals("url"))
        {
          localObject2 = ((Node)localObject2).getAttributes();
          long l2;
          long l1;
          if ((localObject2 != null) && (((NamedNodeMap)localObject2).getLength() > 0))
          {
            localObject3 = ((NamedNodeMap)localObject2).getNamedItem("action");
            if (localObject3 != null) {
              localItem.actionUrl = ((Node)localObject3).getNodeValue();
            }
            localObject3 = ((NamedNodeMap)localObject2).getNamedItem("actionData");
            Node localNode2 = ((NamedNodeMap)localObject2).getNamedItem("a_actionData");
            Node localNode3 = ((NamedNodeMap)localObject2).getNamedItem("i_actionData");
            localObject2 = ((NamedNodeMap)localObject2).getNamedItem("appid");
            if (localObject3 != null) {
              localItem.actionData = ((Node)localObject3).getNodeValue();
            }
            if (localNode2 != null) {
              localItem.a_actionData = localNode2.getNodeValue();
            }
            if (localNode3 != null) {
              localItem.i_actionData = localNode3.getNodeValue();
            }
            l2 = 0L;
            l1 = l2;
            if (localObject2 != null) {
              l1 = l2;
            }
          }
          try
          {
            if (!TextUtils.isEmpty(((Node)localObject2).getNodeValue())) {
              l1 = Long.parseLong(((Node)localObject2).getNodeValue());
            }
            localItem.appId = l1;
            localItem.url = localNumberFormatException;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              l1 = l2;
              if (QLog.isColorLevel())
              {
                QLog.d(PAMessageUtil.class.getSimpleName(), 2, localException.getMessage(), localException);
                l1 = l2;
              }
            }
          }
        }
        else if (((String)localObject3).equals("flag"))
        {
          localItem.flag = Integer.parseInt(localNumberFormatException);
        }
        else if (((String)localObject3).equals("icon"))
        {
          localItem.icon = localNumberFormatException;
        }
        else if (((String)localObject3).equals("icon"))
        {
          localItem.source = localNumberFormatException;
        }
        else if (((String)localObject3).equals("time"))
        {
          localItem.time = Long.valueOf(localNumberFormatException).longValue();
        }
        else
        {
          NodeList localNodeList;
          label531:
          Node localNode1;
          if (((String)localObject3).equals("sender"))
          {
            localNodeList = localException.getChildNodes();
            int i4 = localNodeList.getLength();
            int i2 = 0;
            if (i2 < i4)
            {
              localNode1 = localNodeList.item(i2);
              localObject3 = localNode1.getNodeName();
              if (!((String)localObject3).equals("email")) {
                break label584;
              }
              localItem.senderEmail = localNode1.getNodeValue();
            }
            for (;;)
            {
              i2 += 1;
              break label531;
              break;
              label584:
              if (((String)localObject3).equals("name")) {
                localItem.senderName = localNode1.getNodeValue();
              }
            }
          }
          if (((String)localObject3).equals("androidurl")) {
            localItem.androidUrl = localNodeList;
          } else if (((String)localObject3).equals("iosurl")) {
            localItem.iosUrl = localNodeList;
          } else if (((String)localObject3).equals("needlogin"))
          {
            if (Integer.valueOf(localNodeList).intValue() == 1) {
              localItem.needLogin = true;
            }
          }
          else if (((String)localObject3).equals("nativejump")) {
            localItem.nativeJumpString = localNodeList;
          } else if (((String)localObject3).equals("icons")) {
            localItem.iconsString = localNodeList;
          } else if (((String)localObject3).equals("rna")) {
            localItem.rankListName = localNodeList;
          } else if (((String)localObject3).equals("aru")) {
            localItem.a_rankListUrl = b(localNode1);
          } else if (((String)localObject3).equals("iru")) {
            localItem.i_rankListUrl = localNodeList;
          } else if (((String)localObject3).equals("ard")) {
            localItem.rankListDownload = b(localNode1);
          } else if (((String)localObject3).equals("irs")) {
            localItem.rankListSchema = localNodeList;
          } else if (((String)localObject3).equals("desc")) {
            localItem.desc = localNodeList;
          } else if (((String)localObject3).equals("area")) {
            localItem.weaArea = localNodeList;
          } else if (((String)localObject3).equals("temper")) {
            localItem.weaTemper = localNodeList;
          } else if (((String)localObject3).equals("wea")) {
            localItem.weather = localNodeList;
          } else if (((String)localObject3).equals("o_wea")) {
            localItem.oneWeather = localNodeList;
          } else if (((String)localObject3).equals("t_wea")) {
            localItem.twoWeather = localNodeList;
          } else if (((String)localObject3).equals("j_url")) {
            localItem.weaJumpUrl = localNodeList;
          } else if (((String)localObject3).equals("e_url")) {
            localItem.weaExposeUrl = localNodeList;
          } else if (((String)localObject3).equals("t")) {
            localItem.type = localNodeList;
          } else if (((String)localObject3).equals("new_time")) {
            localItem.time = Long.valueOf(localNodeList).longValue();
          } else if (((String)localObject3).equals("b_ad")) {
            localItem.isAd = localNodeList;
          } else if (((String)localObject3).equals("n_wea")) {
            localItem.nowTime = localNodeList;
          }
        }
      }
    }
    return localItem;
  }
  
  /* Error */
  public static com.tencent.mobileqq.data.PAMessage a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: ifnonnull +7 -> 10
    //   6: aload_2
    //   7: astore_1
    //   8: aload_1
    //   9: areturn
    //   10: invokestatic 382	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   13: invokevirtual 386	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   16: astore_3
    //   17: aload_2
    //   18: astore_1
    //   19: aload_3
    //   20: ifnull -12 -> 8
    //   23: new 388	java/io/ByteArrayInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokevirtual 392	java/lang/String:getBytes	()[B
    //   31: invokespecial 395	java/io/ByteArrayInputStream:<init>	([B)V
    //   34: astore_0
    //   35: aload_3
    //   36: aload_0
    //   37: invokevirtual 401	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   40: astore_0
    //   41: aload_2
    //   42: astore_1
    //   43: aload_0
    //   44: ifnull -36 -> 8
    //   47: aload_0
    //   48: invokeinterface 407 1 0
    //   53: astore_1
    //   54: new 409	com/tencent/mobileqq/data/PAMessage
    //   57: dup
    //   58: invokespecial 410	com/tencent/mobileqq/data/PAMessage:<init>	()V
    //   61: astore_0
    //   62: aload_0
    //   63: new 203	java/util/ArrayList
    //   66: dup
    //   67: invokespecial 204	java/util/ArrayList:<init>	()V
    //   70: putfield 414	com/tencent/mobileqq/data/PAMessage:items	Ljava/util/ArrayList;
    //   73: aload_1
    //   74: invokeinterface 173 1 0
    //   79: astore_2
    //   80: aload_2
    //   81: invokeinterface 179 1 0
    //   86: istore 7
    //   88: iconst_0
    //   89: istore 5
    //   91: aload_0
    //   92: astore_1
    //   93: iload 5
    //   95: iload 7
    //   97: if_icmpge -89 -> 8
    //   100: aload_2
    //   101: iload 5
    //   103: invokeinterface 182 2 0
    //   108: astore_1
    //   109: aload_1
    //   110: invokestatic 185	com/tencent/biz/pubaccount/util/PAMessageUtil:a	(Lorg/w3c/dom/Node;)Ljava/lang/String;
    //   113: astore_3
    //   114: aload_1
    //   115: invokeinterface 189 1 0
    //   120: ldc 83
    //   122: invokevirtual 195	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   125: ifeq +44 -> 169
    //   128: aload_0
    //   129: aload_3
    //   130: invokestatic 309	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   133: invokevirtual 312	java/lang/Integer:intValue	()I
    //   136: putfield 416	com/tencent/mobileqq/data/PAMessage:type	I
    //   139: iload 5
    //   141: iconst_1
    //   142: iadd
    //   143: istore 5
    //   145: goto -54 -> 91
    //   148: astore_0
    //   149: aload_0
    //   150: invokevirtual 419	javax/xml/parsers/ParserConfigurationException:printStackTrace	()V
    //   153: aconst_null
    //   154: areturn
    //   155: astore_0
    //   156: aload_0
    //   157: invokevirtual 420	org/xml/sax/SAXException:printStackTrace	()V
    //   160: aconst_null
    //   161: areturn
    //   162: astore_0
    //   163: aload_0
    //   164: invokevirtual 421	java/io/IOException:printStackTrace	()V
    //   167: aconst_null
    //   168: areturn
    //   169: aload_1
    //   170: invokeinterface 189 1 0
    //   175: ldc 90
    //   177: invokevirtual 195	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   180: ifeq +70 -> 250
    //   183: aload_1
    //   184: invokeinterface 173 1 0
    //   189: astore_1
    //   190: aload_1
    //   191: invokeinterface 179 1 0
    //   196: istore 8
    //   198: iconst_0
    //   199: istore 6
    //   201: iload 6
    //   203: iload 8
    //   205: if_icmpge -66 -> 139
    //   208: aload_1
    //   209: iload 6
    //   211: invokeinterface 182 2 0
    //   216: astore_3
    //   217: aload_3
    //   218: invokeinterface 425 1 0
    //   223: iconst_1
    //   224: if_icmpne +17 -> 241
    //   227: aload_3
    //   228: invokestatic 427	com/tencent/biz/pubaccount/util/PAMessageUtil:a	(Lorg/w3c/dom/Node;)Lcom/tencent/mobileqq/data/PAMessage$Item;
    //   231: astore_3
    //   232: aload_0
    //   233: getfield 414	com/tencent/mobileqq/data/PAMessage:items	Ljava/util/ArrayList;
    //   236: aload_3
    //   237: invokevirtual 428	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   240: pop
    //   241: iload 6
    //   243: iconst_1
    //   244: iadd
    //   245: istore 6
    //   247: goto -46 -> 201
    //   250: aload_1
    //   251: invokeinterface 189 1 0
    //   256: ldc 86
    //   258: invokevirtual 195	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   261: ifeq -122 -> 139
    //   264: aload_1
    //   265: invokeinterface 173 1 0
    //   270: astore_1
    //   271: aload_1
    //   272: invokeinterface 179 1 0
    //   277: istore 8
    //   279: iconst_0
    //   280: istore 6
    //   282: iload 6
    //   284: iload 8
    //   286: if_icmpge -147 -> 139
    //   289: aload_1
    //   290: iload 6
    //   292: invokeinterface 182 2 0
    //   297: astore 4
    //   299: aload 4
    //   301: invokestatic 185	com/tencent/biz/pubaccount/util/PAMessageUtil:a	(Lorg/w3c/dom/Node;)Ljava/lang/String;
    //   304: astore_3
    //   305: aload 4
    //   307: invokeinterface 189 1 0
    //   312: astore 4
    //   314: aload 4
    //   316: ldc 124
    //   318: invokevirtual 432	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   321: ifeq +23 -> 344
    //   324: aload_0
    //   325: aload_3
    //   326: invokestatic 288	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   329: invokevirtual 292	java/lang/Long:longValue	()J
    //   332: putfield 435	com/tencent/mobileqq/data/PAMessage:sendTime	J
    //   335: iload 6
    //   337: iconst_1
    //   338: iadd
    //   339: istore 6
    //   341: goto -59 -> 282
    //   344: aload 4
    //   346: ldc 14
    //   348: invokevirtual 432	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   351: ifeq +11 -> 362
    //   354: aload_0
    //   355: aload_3
    //   356: putfield 438	com/tencent/mobileqq/data/PAMessage:moreText	Ljava/lang/String;
    //   359: goto -24 -> 335
    //   362: aload 4
    //   364: ldc -126
    //   366: invokevirtual 432	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   369: ifeq -34 -> 335
    //   372: aload_0
    //   373: aload_3
    //   374: putfield 440	com/tencent/mobileqq/data/PAMessage:grayTips	Ljava/lang/String;
    //   377: goto -42 -> 335
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	paramString	String
    //   7	283	1	localObject1	Object
    //   1	100	2	localNodeList	NodeList
    //   16	358	3	localObject2	Object
    //   297	66	4	localObject3	Object
    //   89	55	5	i1	int
    //   199	141	6	i2	int
    //   86	12	7	i3	int
    //   196	91	8	i4	int
    // Exception table:
    //   from	to	target	type
    //   10	17	148	javax/xml/parsers/ParserConfigurationException
    //   35	41	155	org/xml/sax/SAXException
    //   35	41	162	java/io/IOException
  }
  
  /* Error */
  public static com.tencent.mobileqq.data.PAMessage a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 388	java/io/ByteArrayInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 395	java/io/ByteArrayInputStream:<init>	([B)V
    //   14: astore_3
    //   15: new 447	java/io/ObjectInputStream
    //   18: dup
    //   19: aload_3
    //   20: invokespecial 450	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   23: astore_1
    //   24: aload_1
    //   25: astore_0
    //   26: aload_1
    //   27: invokevirtual 454	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   30: checkcast 409	com/tencent/mobileqq/data/PAMessage
    //   33: astore_2
    //   34: aload_1
    //   35: ifnull +7 -> 42
    //   38: aload_1
    //   39: invokevirtual 457	java/io/ObjectInputStream:close	()V
    //   42: aload_3
    //   43: invokevirtual 458	java/io/ByteArrayInputStream:close	()V
    //   46: aload_2
    //   47: astore_0
    //   48: aload_0
    //   49: areturn
    //   50: astore_0
    //   51: aload_0
    //   52: invokevirtual 421	java/io/IOException:printStackTrace	()V
    //   55: aload_2
    //   56: astore_0
    //   57: goto -9 -> 48
    //   60: astore_0
    //   61: aconst_null
    //   62: astore_0
    //   63: aload_0
    //   64: ifnull +7 -> 71
    //   67: aload_0
    //   68: invokevirtual 457	java/io/ObjectInputStream:close	()V
    //   71: aload_3
    //   72: invokevirtual 458	java/io/ByteArrayInputStream:close	()V
    //   75: aconst_null
    //   76: astore_0
    //   77: goto -29 -> 48
    //   80: astore_0
    //   81: aload_0
    //   82: invokevirtual 421	java/io/IOException:printStackTrace	()V
    //   85: aconst_null
    //   86: astore_0
    //   87: goto -39 -> 48
    //   90: astore_2
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: astore_0
    //   95: aload_2
    //   96: invokevirtual 459	java/lang/ClassNotFoundException:printStackTrace	()V
    //   99: aload_1
    //   100: ifnull +7 -> 107
    //   103: aload_1
    //   104: invokevirtual 457	java/io/ObjectInputStream:close	()V
    //   107: aload_3
    //   108: invokevirtual 458	java/io/ByteArrayInputStream:close	()V
    //   111: aconst_null
    //   112: astore_0
    //   113: goto -65 -> 48
    //   116: astore_0
    //   117: aload_0
    //   118: invokevirtual 421	java/io/IOException:printStackTrace	()V
    //   121: aconst_null
    //   122: astore_0
    //   123: goto -75 -> 48
    //   126: astore_2
    //   127: aconst_null
    //   128: astore_1
    //   129: aload_1
    //   130: astore_0
    //   131: aload_2
    //   132: invokevirtual 460	java/lang/OutOfMemoryError:printStackTrace	()V
    //   135: aload_1
    //   136: ifnull +7 -> 143
    //   139: aload_1
    //   140: invokevirtual 457	java/io/ObjectInputStream:close	()V
    //   143: aload_3
    //   144: invokevirtual 458	java/io/ByteArrayInputStream:close	()V
    //   147: aconst_null
    //   148: astore_0
    //   149: goto -101 -> 48
    //   152: astore_0
    //   153: aload_0
    //   154: invokevirtual 421	java/io/IOException:printStackTrace	()V
    //   157: aconst_null
    //   158: astore_0
    //   159: goto -111 -> 48
    //   162: astore_2
    //   163: aconst_null
    //   164: astore_1
    //   165: aload_1
    //   166: astore_0
    //   167: aload_2
    //   168: invokevirtual 461	java/lang/Exception:printStackTrace	()V
    //   171: aload_1
    //   172: ifnull +7 -> 179
    //   175: aload_1
    //   176: invokevirtual 457	java/io/ObjectInputStream:close	()V
    //   179: aload_3
    //   180: invokevirtual 458	java/io/ByteArrayInputStream:close	()V
    //   183: aconst_null
    //   184: astore_0
    //   185: goto -137 -> 48
    //   188: astore_0
    //   189: aload_0
    //   190: invokevirtual 421	java/io/IOException:printStackTrace	()V
    //   193: aconst_null
    //   194: astore_0
    //   195: goto -147 -> 48
    //   198: astore_1
    //   199: aconst_null
    //   200: astore_0
    //   201: aload_0
    //   202: ifnull +7 -> 209
    //   205: aload_0
    //   206: invokevirtual 457	java/io/ObjectInputStream:close	()V
    //   209: aload_3
    //   210: invokevirtual 458	java/io/ByteArrayInputStream:close	()V
    //   213: aload_1
    //   214: athrow
    //   215: astore_0
    //   216: aload_0
    //   217: invokevirtual 421	java/io/IOException:printStackTrace	()V
    //   220: goto -7 -> 213
    //   223: astore_1
    //   224: goto -23 -> 201
    //   227: astore_2
    //   228: goto -63 -> 165
    //   231: astore_2
    //   232: goto -103 -> 129
    //   235: astore_2
    //   236: goto -143 -> 93
    //   239: astore_0
    //   240: aload_1
    //   241: astore_0
    //   242: goto -179 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	paramArrayOfByte	byte[]
    //   23	153	1	localObjectInputStream	java.io.ObjectInputStream
    //   198	16	1	localObject1	Object
    //   223	18	1	localObject2	Object
    //   33	23	2	localPAMessage	com.tencent.mobileqq.data.PAMessage
    //   90	6	2	localClassNotFoundException1	ClassNotFoundException
    //   126	6	2	localOutOfMemoryError1	OutOfMemoryError
    //   162	6	2	localException1	Exception
    //   227	1	2	localException2	Exception
    //   231	1	2	localOutOfMemoryError2	OutOfMemoryError
    //   235	1	2	localClassNotFoundException2	ClassNotFoundException
    //   14	196	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   38	42	50	java/io/IOException
    //   42	46	50	java/io/IOException
    //   15	24	60	java/io/IOException
    //   67	71	80	java/io/IOException
    //   71	75	80	java/io/IOException
    //   15	24	90	java/lang/ClassNotFoundException
    //   103	107	116	java/io/IOException
    //   107	111	116	java/io/IOException
    //   15	24	126	java/lang/OutOfMemoryError
    //   139	143	152	java/io/IOException
    //   143	147	152	java/io/IOException
    //   15	24	162	java/lang/Exception
    //   175	179	188	java/io/IOException
    //   179	183	188	java/io/IOException
    //   15	24	198	finally
    //   205	209	215	java/io/IOException
    //   209	213	215	java/io/IOException
    //   26	34	223	finally
    //   95	99	223	finally
    //   131	135	223	finally
    //   167	171	223	finally
    //   26	34	227	java/lang/Exception
    //   26	34	231	java/lang/OutOfMemoryError
    //   26	34	235	java/lang/ClassNotFoundException
    //   26	34	239	java/io/IOException
  }
  
  public static String a(Node paramNode)
  {
    if (paramNode.getNodeType() == 3) {}
    Object localObject;
    for (paramNode = paramNode.getNodeValue();; paramNode = ((StringBuilder)localObject).toString())
    {
      localObject = paramNode;
      if (paramNode == null) {
        localObject = "";
      }
      return (String)localObject;
      localObject = new StringBuilder();
      paramNode = paramNode.getChildNodes();
      int i2 = paramNode.getLength();
      int i1 = 0;
      while (i1 < i2)
      {
        Node localNode = paramNode.item(i1);
        if (localNode.getNodeType() == 3) {
          ((StringBuilder)localObject).append(localNode.getNodeValue());
        }
        i1 += 1;
      }
    }
  }
  
  public static boolean a(String paramString, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    new Bundle();
    Uri.parse(paramString).getPath();
    return false;
  }
  
  /* Error */
  public static byte[] a(com.tencent.mobileqq.data.PAMessage paramPAMessage)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 488	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 489	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore_3
    //   14: new 491	java/io/ObjectOutputStream
    //   17: dup
    //   18: aload_3
    //   19: invokespecial 494	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore_2
    //   23: aload_2
    //   24: astore_1
    //   25: aload_2
    //   26: aload_0
    //   27: invokevirtual 498	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   30: aload_2
    //   31: astore_1
    //   32: aload_3
    //   33: invokevirtual 501	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   36: astore_0
    //   37: aload_2
    //   38: ifnull +7 -> 45
    //   41: aload_2
    //   42: invokevirtual 502	java/io/ObjectOutputStream:close	()V
    //   45: aload_3
    //   46: invokevirtual 503	java/io/ByteArrayOutputStream:close	()V
    //   49: aload_0
    //   50: areturn
    //   51: astore_1
    //   52: aload_1
    //   53: invokevirtual 421	java/io/IOException:printStackTrace	()V
    //   56: aload_0
    //   57: areturn
    //   58: astore_0
    //   59: aconst_null
    //   60: astore_2
    //   61: aload_2
    //   62: astore_1
    //   63: aload_0
    //   64: invokevirtual 460	java/lang/OutOfMemoryError:printStackTrace	()V
    //   67: aload_2
    //   68: ifnull +7 -> 75
    //   71: aload_2
    //   72: invokevirtual 502	java/io/ObjectOutputStream:close	()V
    //   75: aload_3
    //   76: invokevirtual 503	java/io/ByteArrayOutputStream:close	()V
    //   79: aconst_null
    //   80: areturn
    //   81: astore_0
    //   82: aload_0
    //   83: invokevirtual 421	java/io/IOException:printStackTrace	()V
    //   86: aconst_null
    //   87: areturn
    //   88: astore_0
    //   89: aconst_null
    //   90: astore_2
    //   91: aload_2
    //   92: astore_1
    //   93: aload_0
    //   94: invokevirtual 421	java/io/IOException:printStackTrace	()V
    //   97: aload_2
    //   98: ifnull +7 -> 105
    //   101: aload_2
    //   102: invokevirtual 502	java/io/ObjectOutputStream:close	()V
    //   105: aload_3
    //   106: invokevirtual 503	java/io/ByteArrayOutputStream:close	()V
    //   109: aconst_null
    //   110: areturn
    //   111: astore_0
    //   112: aload_0
    //   113: invokevirtual 421	java/io/IOException:printStackTrace	()V
    //   116: aconst_null
    //   117: areturn
    //   118: astore_0
    //   119: aconst_null
    //   120: astore_1
    //   121: aload_1
    //   122: ifnull +7 -> 129
    //   125: aload_1
    //   126: invokevirtual 502	java/io/ObjectOutputStream:close	()V
    //   129: aload_3
    //   130: invokevirtual 503	java/io/ByteArrayOutputStream:close	()V
    //   133: aload_0
    //   134: athrow
    //   135: astore_1
    //   136: aload_1
    //   137: invokevirtual 421	java/io/IOException:printStackTrace	()V
    //   140: goto -7 -> 133
    //   143: astore_0
    //   144: goto -23 -> 121
    //   147: astore_0
    //   148: goto -57 -> 91
    //   151: astore_0
    //   152: goto -91 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	paramPAMessage	com.tencent.mobileqq.data.PAMessage
    //   24	8	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   51	2	1	localIOException1	java.io.IOException
    //   62	64	1	localObjectOutputStream2	java.io.ObjectOutputStream
    //   135	2	1	localIOException2	java.io.IOException
    //   22	80	2	localObjectOutputStream3	java.io.ObjectOutputStream
    //   13	117	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   41	45	51	java/io/IOException
    //   45	49	51	java/io/IOException
    //   14	23	58	java/lang/OutOfMemoryError
    //   71	75	81	java/io/IOException
    //   75	79	81	java/io/IOException
    //   14	23	88	java/io/IOException
    //   101	105	111	java/io/IOException
    //   105	109	111	java/io/IOException
    //   14	23	118	finally
    //   125	129	135	java/io/IOException
    //   129	133	135	java/io/IOException
    //   25	30	143	finally
    //   32	37	143	finally
    //   63	67	143	finally
    //   93	97	143	finally
    //   25	30	147	java/io/IOException
    //   32	37	147	java/io/IOException
    //   25	30	151	java/lang/OutOfMemoryError
    //   32	37	151	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public static com.tencent.mobileqq.data.PAMessage b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: ifnonnull +7 -> 10
    //   6: aload_2
    //   7: astore_1
    //   8: aload_1
    //   9: areturn
    //   10: invokestatic 382	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   13: invokevirtual 386	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   16: astore_3
    //   17: aload_2
    //   18: astore_1
    //   19: aload_3
    //   20: ifnull -12 -> 8
    //   23: new 388	java/io/ByteArrayInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokevirtual 392	java/lang/String:getBytes	()[B
    //   31: invokespecial 395	java/io/ByteArrayInputStream:<init>	([B)V
    //   34: astore_0
    //   35: aload_3
    //   36: aload_0
    //   37: invokevirtual 401	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   40: astore_0
    //   41: aload_2
    //   42: astore_1
    //   43: aload_0
    //   44: ifnull -36 -> 8
    //   47: aload_0
    //   48: invokeinterface 407 1 0
    //   53: astore_3
    //   54: aload_2
    //   55: astore_1
    //   56: aload_3
    //   57: invokeinterface 189 1 0
    //   62: ldc 79
    //   64: invokevirtual 195	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   67: ifeq -59 -> 8
    //   70: new 409	com/tencent/mobileqq/data/PAMessage
    //   73: dup
    //   74: invokespecial 410	com/tencent/mobileqq/data/PAMessage:<init>	()V
    //   77: astore_0
    //   78: aload_0
    //   79: new 203	java/util/ArrayList
    //   82: dup
    //   83: invokespecial 204	java/util/ArrayList:<init>	()V
    //   86: putfield 414	com/tencent/mobileqq/data/PAMessage:items	Ljava/util/ArrayList;
    //   89: aload_3
    //   90: invokeinterface 173 1 0
    //   95: astore_2
    //   96: iconst_0
    //   97: istore 4
    //   99: aload_2
    //   100: invokeinterface 179 1 0
    //   105: istore 5
    //   107: aload_0
    //   108: astore_1
    //   109: iload 4
    //   111: iload 5
    //   113: if_icmpge -105 -> 8
    //   116: aload_2
    //   117: iload 4
    //   119: invokeinterface 182 2 0
    //   124: astore_1
    //   125: aload_1
    //   126: invokestatic 185	com/tencent/biz/pubaccount/util/PAMessageUtil:a	(Lorg/w3c/dom/Node;)Ljava/lang/String;
    //   129: astore_3
    //   130: aload_1
    //   131: invokeinterface 189 1 0
    //   136: ldc 83
    //   138: invokevirtual 195	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   141: ifeq +44 -> 185
    //   144: aload_0
    //   145: aload_3
    //   146: invokestatic 309	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   149: invokevirtual 312	java/lang/Integer:intValue	()I
    //   152: putfield 416	com/tencent/mobileqq/data/PAMessage:type	I
    //   155: iload 4
    //   157: iconst_1
    //   158: iadd
    //   159: istore 4
    //   161: goto -54 -> 107
    //   164: astore_0
    //   165: aload_0
    //   166: invokevirtual 419	javax/xml/parsers/ParserConfigurationException:printStackTrace	()V
    //   169: aconst_null
    //   170: areturn
    //   171: astore_0
    //   172: aload_0
    //   173: invokevirtual 420	org/xml/sax/SAXException:printStackTrace	()V
    //   176: aconst_null
    //   177: areturn
    //   178: astore_0
    //   179: aload_0
    //   180: invokevirtual 421	java/io/IOException:printStackTrace	()V
    //   183: aconst_null
    //   184: areturn
    //   185: aload_1
    //   186: invokeinterface 189 1 0
    //   191: ldc 94
    //   193: invokevirtual 195	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   196: ifeq -41 -> 155
    //   199: aload_1
    //   200: invokestatic 427	com/tencent/biz/pubaccount/util/PAMessageUtil:a	(Lorg/w3c/dom/Node;)Lcom/tencent/mobileqq/data/PAMessage$Item;
    //   203: astore_1
    //   204: aload_0
    //   205: getfield 414	com/tencent/mobileqq/data/PAMessage:items	Ljava/util/ArrayList;
    //   208: aload_1
    //   209: invokevirtual 428	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   212: pop
    //   213: goto -58 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	paramString	String
    //   7	202	1	localObject1	Object
    //   1	116	2	localNodeList	NodeList
    //   16	130	3	localObject2	Object
    //   97	63	4	i1	int
    //   105	9	5	i2	int
    // Exception table:
    //   from	to	target	type
    //   10	17	164	javax/xml/parsers/ParserConfigurationException
    //   35	41	171	org/xml/sax/SAXException
    //   35	41	178	java/io/IOException
  }
  
  private static String b(Node paramNode)
  {
    if (paramNode == null) {}
    do
    {
      return null;
      paramNode = paramNode.getChildNodes();
    } while (paramNode == null);
    JSONObject localJSONObject = new JSONObject();
    int i1 = 0;
    for (;;)
    {
      if (i1 < paramNode.getLength())
      {
        Node localNode = paramNode.item(i1);
        try
        {
          localJSONObject.put(localNode.getNodeName(), a(localNode));
          i1 += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    return localJSONObject.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\util\PAMessageUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */