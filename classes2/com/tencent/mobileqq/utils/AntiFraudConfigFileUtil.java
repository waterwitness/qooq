package com.tencent.mobileqq.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.os.MqqHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import vzm;
import vzn;
import vzo;
import vzq;
import vzr;

public class AntiFraudConfigFileUtil
{
  public static final String A = "MD5";
  public static final String B = "normal";
  public static final String C = "confirmed";
  public static final String D = "type";
  public static final String E = "url";
  public static final String F = "phone";
  public static final String G = "status";
  public static final String H = "sens_msg_uniseq";
  public static final String I = "openURL";
  public static final String J = "makePhoneCall";
  public static final String K = "showAlert";
  public static final String L = "transfer";
  public static final String M = "tipOff";
  public static final String N = "QQCall";
  public static final String O = "videoCall";
  public static final String P = "openDeviceLock";
  public static final String Q = "luckyMoney";
  public static final String R = "0";
  public static final String S = "1";
  private static final String T = "UinSafety.WordingConfigFileUtil";
  public static final int a = 1;
  public static final String a = "SecWarningCfg";
  private static final int jdField_b_of_type_Int = 0;
  public static final String b = "SensMsgTipsCfg";
  private static final int c = 2;
  public static final String c = "SenstiveMessageTipsCfg";
  public static final String d = "SecurityConfig";
  private static final int e = 0;
  public static final String e = "SubConfig";
  private static final int f = 1;
  public static final String f = "PublicElement";
  private static final int g = 2;
  public static final String g = "Element";
  private static final int h = 3;
  public static final String h = "BannerTTL";
  public static final String i = "BannerURL";
  public static final String j = "BannerWording";
  public static final String k = "AlertTitle";
  public static final String l = "AlertText";
  public static final String m = "AlertLeftBtnText";
  public static final String n = "AlertRightBtnText";
  public static final String o = "AlertOtherBtnText";
  public static final String p = "AlertCancelBtnText";
  public static final String q = "TailWording";
  public static final String r = "Action";
  public static final String s = "Version";
  public static final String t = "Type";
  public static final String u = "Value";
  public static final String v = "Status";
  public static final String w = "PlaceHolder";
  public static final String x = "Name";
  public static final String y = "LastModifiedTime";
  public static final String z = "EffectTime";
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private SecSvcObserver jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver;
  private Bundle jdField_b_of_type_AndroidOsBundle;
  private int d;
  
  private AntiFraudConfigFileUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = -1;
    this.b = new Bundle();
    this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver = new vzo(this);
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
  }
  
  public static AntiFraudConfigFileUtil a()
  {
    return vzr.a;
  }
  
  private void a(Bundle paramBundle, String paramString, Element paramElement)
  {
    try
    {
      i1 = Integer.parseInt(paramString);
      if ((i1 == 1) || (i1 == 2))
      {
        localObject1 = paramElement.getElementsByTagName("TailWording");
        if (((NodeList)localObject1).getLength() > 0)
        {
          localObject2 = new Bundle();
          i1 = 0;
          while (i1 < ((NodeList)localObject1).getLength())
          {
            localObject3 = (Element)((NodeList)localObject1).item(i1);
            str = ((Element)localObject3).getAttribute("Status");
            paramString = str;
            if (TextUtils.isEmpty(str)) {
              paramString = "0";
            }
            ((Bundle)localObject2).putString(paramString, ((Element)localObject3).getTextContent());
            i1 += 1;
          }
        }
      }
    }
    catch (Exception paramString)
    {
      int i1;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      String str;
      for (;;)
      {
        paramString.printStackTrace();
        i1 = 0;
      }
      paramBundle.putBundle("TailWording", (Bundle)localObject2);
      paramString = paramElement.getElementsByTagName("Action");
      if (paramString.getLength() > 0)
      {
        paramElement = new Bundle();
        i1 = 0;
        while (i1 < paramString.getLength())
        {
          localObject2 = (Element)paramString.item(i1);
          str = ((Element)localObject2).getAttribute("PlaceHolder");
          if (TextUtils.isEmpty(str))
          {
            i1 += 1;
          }
          else
          {
            localObject1 = new Bundle();
            localObject3 = ((Element)localObject2).getAttribute("Type");
            ((Bundle)localObject1).putString("Type", (String)localObject3);
            ((Bundle)localObject1).putString("Name", ((Element)localObject2).getAttribute("Name"));
            if (((String)localObject3).equalsIgnoreCase("openURL")) {
              a((Bundle)localObject1, (Element)localObject2);
            }
            for (;;)
            {
              paramElement.putBundle(str, (Bundle)localObject1);
              break;
              localObject3 = ((Element)localObject2).getElementsByTagName("AlertTitle");
              if (((NodeList)localObject3).getLength() > 0) {
                a((Bundle)localObject1, (Element)((NodeList)localObject3).item(0));
              }
              localObject3 = ((Element)localObject2).getElementsByTagName("AlertText");
              if (((NodeList)localObject3).getLength() > 0) {
                a((Bundle)localObject1, (Element)((NodeList)localObject3).item(0));
              }
              localObject3 = ((Element)localObject2).getElementsByTagName("AlertOtherBtnText");
              if (((NodeList)localObject3).getLength() > 0) {
                a((Bundle)localObject1, (Element)((NodeList)localObject3).item(0));
              }
              localObject2 = ((Element)localObject2).getElementsByTagName("AlertCancelBtnText");
              if (((NodeList)localObject2).getLength() > 0) {
                a((Bundle)localObject1, (Element)((NodeList)localObject2).item(0));
              }
            }
          }
        }
        paramBundle.putBundle("Action", paramElement);
      }
    }
    for (;;)
    {
      return;
      for (paramString = paramElement.getFirstChild(); paramString != null; paramString = paramString.getNextSibling()) {
        if ((paramString instanceof Element))
        {
          paramElement = new Bundle();
          a(paramElement, (Element)paramString);
          paramBundle.putBundle(paramString.getNodeName(), paramElement);
        }
      }
    }
  }
  
  private void a(Bundle paramBundle, Element paramElement)
  {
    String str = paramElement.getNodeName();
    paramElement = paramElement.getFirstChild();
    Object localObject2;
    for (Object localObject1 = ""; paramElement != null; localObject1 = localObject2)
    {
      localObject2 = localObject1;
      if ((paramElement instanceof Text)) {
        localObject2 = (String)localObject1 + paramElement.getNodeValue();
      }
      paramElement = paramElement.getNextSibling();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      paramBundle.putString(str, (String)localObject1);
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UinSafety.WordingConfigFileUtil", 2, "parse config file:" + paramString);
    }
    paramString = a(paramString);
    if (paramString != null) {
      b(paramString);
    }
  }
  
  /* Error */
  private void b(String paramString)
  {
    // Byte code:
    //   0: invokestatic 302	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   3: astore_2
    //   4: new 304	java/io/File
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 306	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: astore_1
    //   13: aload_1
    //   14: invokevirtual 309	java/io/File:getName	()Ljava/lang/String;
    //   17: astore_3
    //   18: aload_3
    //   19: iconst_0
    //   20: aload_3
    //   21: ldc_w 311
    //   24: invokevirtual 314	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   27: invokevirtual 318	java/lang/String:substring	(II)Ljava/lang/String;
    //   30: astore_3
    //   31: aload_2
    //   32: invokevirtual 322	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   35: aload_1
    //   36: invokevirtual 328	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/File;)Lorg/w3c/dom/Document;
    //   39: invokeinterface 334 1 0
    //   44: astore 5
    //   46: aload_0
    //   47: getfield 175	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   50: aload_3
    //   51: invokevirtual 338	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   54: astore_1
    //   55: aload_1
    //   56: ifnull +408 -> 464
    //   59: aload_1
    //   60: ldc 126
    //   62: invokevirtual 341	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   65: astore_1
    //   66: aload_1
    //   67: invokestatic 221	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   70: istore 12
    //   72: iload 12
    //   74: ifne +390 -> 464
    //   77: aload_1
    //   78: invokestatic 195	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   81: istore 10
    //   83: aload 5
    //   85: ldc 126
    //   87: invokeinterface 215 2 0
    //   92: astore_1
    //   93: aload_1
    //   94: invokestatic 195	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   97: istore 11
    //   99: iload 11
    //   101: iload 10
    //   103: if_icmpge +55 -> 158
    //   106: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   109: ifeq +354 -> 463
    //   112: ldc 65
    //   114: iconst_2
    //   115: new 264	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   122: aload_3
    //   123: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc_w 343
    //   129: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 290	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: return
    //   139: astore_1
    //   140: aload_1
    //   141: invokevirtual 232	java/lang/Exception:printStackTrace	()V
    //   144: goto +320 -> 464
    //   147: astore_2
    //   148: aload_2
    //   149: invokevirtual 344	java/lang/Throwable:printStackTrace	()V
    //   152: iconst_0
    //   153: istore 11
    //   155: goto -56 -> 99
    //   158: new 163	android/os/Bundle
    //   161: dup
    //   162: invokespecial 164	android/os/Bundle:<init>	()V
    //   165: astore 4
    //   167: aload_1
    //   168: astore_2
    //   169: aload_1
    //   170: invokestatic 221	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   173: ifeq +8 -> 181
    //   176: iconst_0
    //   177: invokestatic 347	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   180: astore_2
    //   181: aload 4
    //   183: ldc 126
    //   185: aload_2
    //   186: invokevirtual 229	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: aload_0
    //   190: iload 11
    //   192: putfield 161	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:d	I
    //   195: aload 5
    //   197: ldc 83
    //   199: invokeinterface 201 2 0
    //   204: astore_1
    //   205: iconst_0
    //   206: istore 10
    //   208: iload 10
    //   210: aload_1
    //   211: invokeinterface 207 1 0
    //   216: if_icmpge +196 -> 412
    //   219: aload_1
    //   220: iload 10
    //   222: invokeinterface 211 2 0
    //   227: checkcast 197	org/w3c/dom/Element
    //   230: astore 6
    //   232: aload 6
    //   234: ldc -127
    //   236: invokeinterface 215 2 0
    //   241: astore_2
    //   242: new 163	android/os/Bundle
    //   245: dup
    //   246: invokespecial 164	android/os/Bundle:<init>	()V
    //   249: astore 5
    //   251: aload 6
    //   253: ldc 89
    //   255: invokeinterface 201 2 0
    //   260: astore 7
    //   262: iconst_0
    //   263: istore 11
    //   265: iload 11
    //   267: aload 7
    //   269: invokeinterface 207 1 0
    //   274: if_icmpge +60 -> 334
    //   277: aload 7
    //   279: iload 11
    //   281: invokeinterface 211 2 0
    //   286: checkcast 197	org/w3c/dom/Element
    //   289: astore 8
    //   291: new 163	android/os/Bundle
    //   294: dup
    //   295: invokespecial 164	android/os/Bundle:<init>	()V
    //   298: astore 9
    //   300: aload_0
    //   301: aload 9
    //   303: aload_2
    //   304: aload 8
    //   306: invokespecial 349	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:a	(Landroid/os/Bundle;Ljava/lang/String;Lorg/w3c/dom/Element;)V
    //   309: aload 5
    //   311: aload 8
    //   313: ldc -124
    //   315: invokeinterface 215 2 0
    //   320: aload 9
    //   322: invokevirtual 236	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   325: iload 11
    //   327: iconst_1
    //   328: iadd
    //   329: istore 11
    //   331: goto -66 -> 265
    //   334: aload 6
    //   336: ldc 86
    //   338: invokeinterface 201 2 0
    //   343: astore 6
    //   345: aload 6
    //   347: invokeinterface 207 1 0
    //   352: ifle +43 -> 395
    //   355: aload 6
    //   357: iconst_0
    //   358: invokeinterface 211 2 0
    //   363: checkcast 197	org/w3c/dom/Element
    //   366: astore 6
    //   368: new 163	android/os/Bundle
    //   371: dup
    //   372: invokespecial 164	android/os/Bundle:<init>	()V
    //   375: astore 7
    //   377: aload_0
    //   378: aload 7
    //   380: aload_2
    //   381: aload 6
    //   383: invokespecial 349	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:a	(Landroid/os/Bundle;Ljava/lang/String;Lorg/w3c/dom/Element;)V
    //   386: aload 5
    //   388: ldc 86
    //   390: aload 7
    //   392: invokevirtual 236	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   395: aload 4
    //   397: aload_2
    //   398: aload 5
    //   400: invokevirtual 236	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   403: iload 10
    //   405: iconst_1
    //   406: iadd
    //   407: istore 10
    //   409: goto -201 -> 208
    //   412: aload_0
    //   413: getfield 175	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   416: aload_3
    //   417: aload 4
    //   419: invokevirtual 236	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   422: return
    //   423: astore_1
    //   424: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   427: ifeq +32 -> 459
    //   430: ldc 65
    //   432: iconst_2
    //   433: new 264	java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   440: ldc_w 351
    //   443: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: aload_1
    //   447: invokevirtual 354	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   450: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: invokestatic 290	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   459: aload_1
    //   460: invokevirtual 232	java/lang/Exception:printStackTrace	()V
    //   463: return
    //   464: iconst_0
    //   465: istore 10
    //   467: goto -384 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	470	0	this	AntiFraudConfigFileUtil
    //   0	470	1	paramString	String
    //   3	29	2	localDocumentBuilderFactory	DocumentBuilderFactory
    //   147	2	2	localThrowable	Throwable
    //   168	230	2	str1	String
    //   17	400	3	str2	String
    //   165	253	4	localBundle1	Bundle
    //   44	355	5	localObject1	Object
    //   230	152	6	localObject2	Object
    //   260	131	7	localObject3	Object
    //   289	23	8	localElement	Element
    //   298	23	9	localBundle2	Bundle
    //   81	385	10	i1	int
    //   97	233	11	i2	int
    //   70	3	12	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   77	83	139	java/lang/Exception
    //   93	99	147	java/lang/Throwable
    //   4	55	423	java/lang/Exception
    //   59	72	423	java/lang/Exception
    //   83	93	423	java/lang/Exception
    //   93	99	423	java/lang/Exception
    //   106	138	423	java/lang/Exception
    //   140	144	423	java/lang/Exception
    //   148	152	423	java/lang/Exception
    //   158	167	423	java/lang/Exception
    //   169	181	423	java/lang/Exception
    //   181	205	423	java/lang/Exception
    //   208	262	423	java/lang/Exception
    //   265	325	423	java/lang/Exception
    //   334	395	423	java/lang/Exception
    //   395	403	423	java/lang/Exception
    //   412	422	423	java/lang/Exception
  }
  
  public int a(String paramString)
  {
    DocumentBuilderFactory localDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
    try
    {
      paramString = new File(paramString);
      String str = paramString.getName();
      str.substring(0, str.lastIndexOf("."));
      paramString = localDocumentBuilderFactory.newDocumentBuilder().parse(paramString).getDocumentElement().getAttribute("Version");
      try
      {
        int i1 = Integer.parseInt(paramString);
        return i1;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return -1;
      }
      return -1;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UinSafety.WordingConfigFileUtil", 2, "exception occurred." + paramString.getMessage());
      }
      paramString.printStackTrace();
    }
  }
  
  public long a(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getLong(paramString + "_" + "LastModifiedTime", 0L);
  }
  
  public Object a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    ThreadManager.a().post(new vzn(this, paramString1));
    Bundle localBundle1 = null;
    Bundle localBundle2 = this.jdField_a_of_type_AndroidOsBundle.getBundle(paramString1);
    paramString1 = localBundle1;
    if (localBundle2 != null)
    {
      localBundle2 = localBundle2.getBundle(Integer.toString(paramInt1));
      paramString1 = localBundle1;
      if (localBundle2 != null)
      {
        Bundle localBundle3 = localBundle2.getBundle(Integer.toString(paramInt2));
        paramString1 = localBundle1;
        if (localBundle3 != null)
        {
          localBundle1 = localBundle3.getBundle(paramString2);
          paramString1 = localBundle1;
          if (localBundle1 == null)
          {
            localBundle2 = localBundle2.getBundle("PublicElement");
            paramString1 = localBundle1;
            if (localBundle2 != null) {
              paramString1 = localBundle2.getBundle(paramString2);
            }
          }
        }
      }
    }
    return paramString1;
  }
  
  public String a(String paramString)
  {
    return BaseApplication.getContext().getFilesDir().getPath() + "/" + paramString + ".xml";
  }
  
  public String a(String paramString1, String paramString2)
  {
    Object localObject = paramString1;
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject = paramString1;
      if (TextUtils.equals("SenstiveMessageTipsCfg", paramString1)) {
        localObject = "SensMsgTipsCfg";
      }
    }
    ThreadManager.a().post(new vzm(this, (String)localObject));
    paramString1 = null;
    localObject = this.jdField_a_of_type_AndroidOsBundle.getBundle((String)localObject);
    if (localObject != null) {
      paramString1 = ((Bundle)localObject).getString(paramString2);
    }
    return paramString1;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {}
    long l1;
    long l2;
    do
    {
      return;
      paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
      l1 = a(paramString);
      l2 = b(paramString);
    } while (System.currentTimeMillis() - l1 < l2 * 1000L);
    SecSvcHandler localSecSvcHandler = (SecSvcHandler)paramQQAppInterface.a(34);
    paramQQAppInterface = paramString;
    if (TextUtils.equals(paramString, "SensMsgTipsCfg")) {
      paramQQAppInterface = "SenstiveMessageTipsCfg";
    }
    localSecSvcHandler.a(paramQQAppInterface);
  }
  
  /* Error */
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aload_1
    //   7: ifnull +11 -> 18
    //   10: aload_1
    //   11: aload_0
    //   12: getfield 173	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver	Lcom/tencent/mobileqq/app/SecSvcObserver;
    //   15: invokevirtual 416	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   18: aload_2
    //   19: invokestatic 221	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   22: ifeq +4 -> 26
    //   25: return
    //   26: aload_2
    //   27: ldc 69
    //   29: invokevirtual 242	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   32: ifeq +51 -> 83
    //   35: aload_0
    //   36: aload_2
    //   37: invokevirtual 418	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:a	(Ljava/lang/String;)J
    //   40: lstore 11
    //   42: aload_0
    //   43: aload_2
    //   44: invokevirtual 420	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:b	(Ljava/lang/String;)J
    //   47: lstore 13
    //   49: aload_1
    //   50: ifnull -25 -> 25
    //   53: invokestatic 426	java/lang/System:currentTimeMillis	()J
    //   56: lload 11
    //   58: lsub
    //   59: lload 13
    //   61: ldc2_w 427
    //   64: lmul
    //   65: lcmp
    //   66: iflt -41 -> 25
    //   69: aload_1
    //   70: bipush 34
    //   72: invokevirtual 431	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   75: checkcast 433	com/tencent/mobileqq/app/SecSvcHandler
    //   78: aload_2
    //   79: invokevirtual 434	com/tencent/mobileqq/app/SecSvcHandler:a	(Ljava/lang/String;)V
    //   82: return
    //   83: aload_2
    //   84: ldc 73
    //   86: invokevirtual 242	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   89: ifeq -64 -> 25
    //   92: aload_0
    //   93: aload_2
    //   94: invokevirtual 439	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   97: astore 6
    //   99: aload_0
    //   100: ldc 73
    //   102: invokevirtual 292	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   105: astore 9
    //   107: aload 6
    //   109: invokestatic 221	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   112: istore 15
    //   114: aload_0
    //   115: getfield 161	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:d	I
    //   118: iconst_m1
    //   119: if_icmpne +21 -> 140
    //   122: aload 6
    //   124: invokestatic 221	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   127: ifne +13 -> 140
    //   130: aload_0
    //   131: aload_0
    //   132: aload 9
    //   134: invokevirtual 441	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:a	(Ljava/lang/String;)I
    //   137: putfield 161	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:d	I
    //   140: aload_0
    //   141: getfield 161	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:d	I
    //   144: iconst_2
    //   145: if_icmpge +6 -> 151
    //   148: iconst_1
    //   149: istore 15
    //   151: aload 6
    //   153: astore_1
    //   154: iload 15
    //   156: ifeq +123 -> 279
    //   159: invokestatic 361	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   162: invokevirtual 445	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   165: ldc_w 447
    //   168: invokevirtual 453	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   171: astore_1
    //   172: new 455	java/io/FileOutputStream
    //   175: dup
    //   176: aload 9
    //   178: invokespecial 456	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   181: astore 5
    //   183: sipush 4096
    //   186: newarray <illegal type>
    //   188: astore_2
    //   189: aload_1
    //   190: aload_2
    //   191: invokevirtual 462	java/io/InputStream:read	([B)I
    //   194: istore 10
    //   196: iload 10
    //   198: ifle +107 -> 305
    //   201: aload 5
    //   203: aload_2
    //   204: iconst_0
    //   205: iload 10
    //   207: invokevirtual 468	java/io/OutputStream:write	([BII)V
    //   210: goto -21 -> 189
    //   213: astore 7
    //   215: aload_1
    //   216: astore_2
    //   217: aload 5
    //   219: astore_1
    //   220: aload 7
    //   222: astore 5
    //   224: aload 5
    //   226: invokevirtual 232	java/lang/Exception:printStackTrace	()V
    //   229: aload_2
    //   230: ifnull +7 -> 237
    //   233: aload_2
    //   234: invokevirtual 471	java/io/InputStream:close	()V
    //   237: aload_1
    //   238: ifnull +7 -> 245
    //   241: aload_1
    //   242: invokevirtual 472	java/io/OutputStream:close	()V
    //   245: aload 6
    //   247: astore_1
    //   248: aload 9
    //   250: invokestatic 476	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Z
    //   253: ifeq +26 -> 279
    //   256: aload 9
    //   258: invokestatic 481	com/tencent/mobileqq/utils/SecUtil:getFileMd5	(Ljava/lang/String;)Ljava/lang/String;
    //   261: astore_1
    //   262: aload_0
    //   263: ldc 73
    //   265: aload_1
    //   266: invokevirtual 483	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   269: aload_0
    //   270: aload_0
    //   271: aload 9
    //   273: invokevirtual 441	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:a	(Ljava/lang/String;)I
    //   276: putfield 161	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:d	I
    //   279: aload_1
    //   280: aload 4
    //   282: invokestatic 407	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   285: ifne -260 -> 25
    //   288: aload_3
    //   289: invokestatic 221	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   292: ifne -267 -> 25
    //   295: aload_0
    //   296: ldc 73
    //   298: aload 4
    //   300: aload_3
    //   301: invokevirtual 486	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   304: return
    //   305: aload_1
    //   306: ifnull +7 -> 313
    //   309: aload_1
    //   310: invokevirtual 471	java/io/InputStream:close	()V
    //   313: aload 5
    //   315: ifnull -70 -> 245
    //   318: aload 5
    //   320: invokevirtual 472	java/io/OutputStream:close	()V
    //   323: goto -78 -> 245
    //   326: astore_1
    //   327: aload_1
    //   328: invokevirtual 487	java/io/IOException:printStackTrace	()V
    //   331: goto -86 -> 245
    //   334: astore_1
    //   335: aload_1
    //   336: invokevirtual 487	java/io/IOException:printStackTrace	()V
    //   339: goto -94 -> 245
    //   342: astore_2
    //   343: aconst_null
    //   344: astore_1
    //   345: aload 7
    //   347: astore_3
    //   348: aload_1
    //   349: ifnull +7 -> 356
    //   352: aload_1
    //   353: invokevirtual 471	java/io/InputStream:close	()V
    //   356: aload_3
    //   357: ifnull +7 -> 364
    //   360: aload_3
    //   361: invokevirtual 472	java/io/OutputStream:close	()V
    //   364: aload_2
    //   365: athrow
    //   366: astore_1
    //   367: aload_1
    //   368: invokevirtual 487	java/io/IOException:printStackTrace	()V
    //   371: goto -7 -> 364
    //   374: astore_2
    //   375: aload 7
    //   377: astore_3
    //   378: goto -30 -> 348
    //   381: astore_2
    //   382: aload 5
    //   384: astore_3
    //   385: goto -37 -> 348
    //   388: astore_3
    //   389: aload_2
    //   390: astore 4
    //   392: aload_3
    //   393: astore_2
    //   394: aload_1
    //   395: astore_3
    //   396: aload 4
    //   398: astore_1
    //   399: goto -51 -> 348
    //   402: astore 5
    //   404: aconst_null
    //   405: astore_1
    //   406: aload 8
    //   408: astore_2
    //   409: goto -185 -> 224
    //   412: astore 5
    //   414: aconst_null
    //   415: astore 7
    //   417: aload_1
    //   418: astore_2
    //   419: aload 7
    //   421: astore_1
    //   422: goto -198 -> 224
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	425	0	this	AntiFraudConfigFileUtil
    //   0	425	1	paramQQAppInterface	QQAppInterface
    //   0	425	2	paramString1	String
    //   0	425	3	paramString2	String
    //   0	425	4	paramString3	String
    //   181	202	5	localObject1	Object
    //   402	1	5	localException1	Exception
    //   412	1	5	localException2	Exception
    //   97	149	6	str1	String
    //   1	1	7	localObject2	Object
    //   213	163	7	localException3	Exception
    //   415	5	7	localObject3	Object
    //   4	403	8	localObject4	Object
    //   105	167	9	str2	String
    //   194	12	10	i1	int
    //   40	17	11	l1	long
    //   47	13	13	l2	long
    //   112	43	15	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   183	189	213	java/lang/Exception
    //   189	196	213	java/lang/Exception
    //   201	210	213	java/lang/Exception
    //   309	313	326	java/io/IOException
    //   318	323	326	java/io/IOException
    //   233	237	334	java/io/IOException
    //   241	245	334	java/io/IOException
    //   159	172	342	finally
    //   352	356	366	java/io/IOException
    //   360	364	366	java/io/IOException
    //   172	183	374	finally
    //   183	189	381	finally
    //   189	196	381	finally
    //   201	210	381	finally
    //   224	229	388	finally
    //   159	172	402	java/lang/Exception
    //   172	183	412	java/lang/Exception
  }
  
  public void a(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putLong(paramString + "_" + "LastModifiedTime", paramLong);
    localEditor.commit();
  }
  
  public void a(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putString(paramString1 + "_" + "MD5", paramString2);
    localEditor.commit();
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    int i1 = this.b.getInt(paramString2, 0);
    if ((i1 == 1) || (i1 == 3)) {
      return;
    }
    try
    {
      this.b.putInt(paramString2, 1);
      ThreadManager.a(new vzq(this, paramString1, paramString3, paramString2), 5, null, false);
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
  
  public long b(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getLong(paramString + "_" + "EffectTime", 0L);
  }
  
  public String b(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getString(paramString + "_" + "MD5", null);
  }
  
  public void b(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putLong(paramString + "_" + "EffectTime", paramLong);
    localEditor.commit();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\AntiFraudConfigFileUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */